package cz.msebera.android.httpclient.conn.ssl;

import cz.msebera.android.httpclient.HttpHost;
import cz.msebera.android.httpclient.annotation.ThreadSafe;
import cz.msebera.android.httpclient.conn.socket.LayeredConnectionSocketFactory;
import cz.msebera.android.httpclient.conn.util.PublicSuffixMatcherLoader;
import cz.msebera.android.httpclient.extras.HttpClientAndroidLog;
import cz.msebera.android.httpclient.protocol.HttpContext;
import cz.msebera.android.httpclient.util.Args;
import cz.msebera.android.httpclient.util.TextUtils;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.security.auth.x500.X500Principal;

@ThreadSafe
/* loaded from: classes.dex */
public class SSLConnectionSocketFactory implements LayeredConnectionSocketFactory {
    public static final String SSL = "SSL";
    public static final String SSLV2 = "SSLv2";
    public static final String TLS = "TLS";
    private final HostnameVerifier hostnameVerifier;
    public HttpClientAndroidLog log;
    private final javax.net.ssl.SSLSocketFactory socketfactory;
    private final String[] supportedCipherSuites;
    private final String[] supportedProtocols;
    @Deprecated
    public static final X509HostnameVerifier ALLOW_ALL_HOSTNAME_VERIFIER = AllowAllHostnameVerifier.INSTANCE;
    @Deprecated
    public static final X509HostnameVerifier BROWSER_COMPATIBLE_HOSTNAME_VERIFIER = BrowserCompatHostnameVerifier.INSTANCE;
    @Deprecated
    public static final X509HostnameVerifier STRICT_HOSTNAME_VERIFIER = StrictHostnameVerifier.INSTANCE;

    public SSLConnectionSocketFactory(SSLContext sSLContext) {
        this(sSLContext, getDefaultHostnameVerifier());
    }

    @Deprecated
    public SSLConnectionSocketFactory(SSLContext sSLContext, X509HostnameVerifier x509HostnameVerifier) {
        this(((SSLContext) Args.notNull(sSLContext, "SSL context")).getSocketFactory(), (String[]) null, (String[]) null, x509HostnameVerifier);
    }

    public SSLConnectionSocketFactory(SSLContext sSLContext, HostnameVerifier hostnameVerifier) {
        this(((SSLContext) Args.notNull(sSLContext, "SSL context")).getSocketFactory(), (String[]) null, (String[]) null, hostnameVerifier);
    }

    @Deprecated
    public SSLConnectionSocketFactory(SSLContext sSLContext, String[] strArr, String[] strArr2, X509HostnameVerifier x509HostnameVerifier) {
        this(((SSLContext) Args.notNull(sSLContext, "SSL context")).getSocketFactory(), strArr, strArr2, x509HostnameVerifier);
    }

    public SSLConnectionSocketFactory(SSLContext sSLContext, String[] strArr, String[] strArr2, HostnameVerifier hostnameVerifier) {
        this(((SSLContext) Args.notNull(sSLContext, "SSL context")).getSocketFactory(), strArr, strArr2, hostnameVerifier);
    }

    @Deprecated
    public SSLConnectionSocketFactory(javax.net.ssl.SSLSocketFactory sSLSocketFactory, X509HostnameVerifier x509HostnameVerifier) {
        this(sSLSocketFactory, (String[]) null, (String[]) null, x509HostnameVerifier);
    }

    public SSLConnectionSocketFactory(javax.net.ssl.SSLSocketFactory sSLSocketFactory, HostnameVerifier hostnameVerifier) {
        this(sSLSocketFactory, (String[]) null, (String[]) null, hostnameVerifier);
    }

    @Deprecated
    public SSLConnectionSocketFactory(javax.net.ssl.SSLSocketFactory sSLSocketFactory, String[] strArr, String[] strArr2, X509HostnameVerifier x509HostnameVerifier) {
        this(sSLSocketFactory, strArr, strArr2, (HostnameVerifier) x509HostnameVerifier);
    }

    public SSLConnectionSocketFactory(javax.net.ssl.SSLSocketFactory sSLSocketFactory, String[] strArr, String[] strArr2, HostnameVerifier hostnameVerifier) {
        this.log = new HttpClientAndroidLog(getClass());
        this.socketfactory = (javax.net.ssl.SSLSocketFactory) Args.notNull(sSLSocketFactory, "SSL socket factory");
        this.supportedProtocols = strArr;
        this.supportedCipherSuites = strArr2;
        this.hostnameVerifier = hostnameVerifier == null ? getDefaultHostnameVerifier() : hostnameVerifier;
    }

    public static HostnameVerifier getDefaultHostnameVerifier() {
        return new DefaultHostnameVerifier(PublicSuffixMatcherLoader.getDefault());
    }

    public static SSLConnectionSocketFactory getSocketFactory() {
        return new SSLConnectionSocketFactory(cz.msebera.android.httpclient.ssl.SSLContexts.createDefault(), getDefaultHostnameVerifier());
    }

    public static SSLConnectionSocketFactory getSystemSocketFactory() {
        return new SSLConnectionSocketFactory((javax.net.ssl.SSLSocketFactory) javax.net.ssl.SSLSocketFactory.getDefault(), split(System.getProperty("https.protocols")), split(System.getProperty("https.cipherSuites")), getDefaultHostnameVerifier());
    }

    private static String[] split(String str) {
        if (TextUtils.isBlank(str)) {
            return null;
        }
        return str.split(" *, *");
    }

    private void verifyHostname(SSLSocket sSLSocket, String str) {
        try {
            SSLSession session = sSLSocket.getSession();
            if (session == null) {
                sSLSocket.getInputStream().available();
                session = sSLSocket.getSession();
                if (session == null) {
                    sSLSocket.startHandshake();
                    session = sSLSocket.getSession();
                }
            }
            if (session == null) {
                throw new SSLHandshakeException("SSL session not available");
            }
            if (this.log.isDebugEnabled()) {
                this.log.debug("Secure session established");
                HttpClientAndroidLog httpClientAndroidLog = this.log;
                httpClientAndroidLog.debug(" negotiated protocol: " + session.getProtocol());
                HttpClientAndroidLog httpClientAndroidLog2 = this.log;
                httpClientAndroidLog2.debug(" negotiated cipher suite: " + session.getCipherSuite());
                try {
                    X509Certificate x509Certificate = (X509Certificate) session.getPeerCertificates()[0];
                    X500Principal subjectX500Principal = x509Certificate.getSubjectX500Principal();
                    HttpClientAndroidLog httpClientAndroidLog3 = this.log;
                    httpClientAndroidLog3.debug(" peer principal: " + subjectX500Principal.toString());
                    Collection<List<?>> subjectAlternativeNames = x509Certificate.getSubjectAlternativeNames();
                    if (subjectAlternativeNames != null) {
                        ArrayList arrayList = new ArrayList();
                        for (List<?> list : subjectAlternativeNames) {
                            if (!list.isEmpty()) {
                                arrayList.add((String) list.get(1));
                            }
                        }
                        HttpClientAndroidLog httpClientAndroidLog4 = this.log;
                        httpClientAndroidLog4.debug(" peer alternative names: " + arrayList);
                    }
                    X500Principal issuerX500Principal = x509Certificate.getIssuerX500Principal();
                    HttpClientAndroidLog httpClientAndroidLog5 = this.log;
                    httpClientAndroidLog5.debug(" issuer principal: " + issuerX500Principal.toString());
                    Collection<List<?>> issuerAlternativeNames = x509Certificate.getIssuerAlternativeNames();
                    if (issuerAlternativeNames != null) {
                        ArrayList arrayList2 = new ArrayList();
                        for (List<?> list2 : issuerAlternativeNames) {
                            if (!list2.isEmpty()) {
                                arrayList2.add((String) list2.get(1));
                            }
                        }
                        HttpClientAndroidLog httpClientAndroidLog6 = this.log;
                        httpClientAndroidLog6.debug(" issuer alternative names: " + arrayList2);
                    }
                } catch (Exception unused) {
                }
            }
            if (this.hostnameVerifier.verify(str, session)) {
                return;
            }
            X500Principal subjectX500Principal2 = ((X509Certificate) session.getPeerCertificates()[0]).getSubjectX500Principal();
            throw new SSLPeerUnverifiedException("Host name '" + str + "' does not match the certificate subject provided by the peer (" + subjectX500Principal2.toString() + ")");
        } catch (IOException e) {
            try {
                sSLSocket.close();
            } catch (Exception unused2) {
            }
            throw e;
        }
    }

    @Override // cz.msebera.android.httpclient.conn.socket.ConnectionSocketFactory
    public Socket connectSocket(int i, Socket socket, HttpHost httpHost, InetSocketAddress inetSocketAddress, InetSocketAddress inetSocketAddress2, HttpContext httpContext) {
        Args.notNull(httpHost, "HTTP host");
        Args.notNull(inetSocketAddress, "Remote address");
        if (socket == null) {
            socket = createSocket(httpContext);
        }
        if (inetSocketAddress2 != null) {
            socket.bind(inetSocketAddress2);
        }
        if (i > 0) {
            try {
                if (socket.getSoTimeout() == 0) {
                    socket.setSoTimeout(i);
                }
            } catch (IOException e) {
                try {
                    socket.close();
                } catch (IOException unused) {
                }
                throw e;
            }
        }
        if (this.log.isDebugEnabled()) {
            HttpClientAndroidLog httpClientAndroidLog = this.log;
            httpClientAndroidLog.debug("Connecting socket to " + inetSocketAddress + " with timeout " + i);
        }
        socket.connect(inetSocketAddress, i);
        if (socket instanceof SSLSocket) {
            SSLSocket sSLSocket = (SSLSocket) socket;
            this.log.debug("Starting handshake");
            sSLSocket.startHandshake();
            verifyHostname(sSLSocket, httpHost.getHostName());
            return socket;
        }
        return createLayeredSocket(socket, httpHost.getHostName(), inetSocketAddress.getPort(), httpContext);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0051  */
    @Override // cz.msebera.android.httpclient.conn.socket.LayeredConnectionSocketFactory
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Socket createLayeredSocket(Socket socket, String str, int i, HttpContext httpContext) {
        String[] strArr;
        SSLSocket sSLSocket = (SSLSocket) this.socketfactory.createSocket(socket, str, i, true);
        String[] strArr2 = this.supportedProtocols;
        if (strArr2 == null) {
            String[] enabledProtocols = sSLSocket.getEnabledProtocols();
            ArrayList arrayList = new ArrayList(enabledProtocols.length);
            for (String str2 : enabledProtocols) {
                if (!str2.startsWith("SSL")) {
                    arrayList.add(str2);
                }
            }
            if (!arrayList.isEmpty()) {
                strArr2 = (String[]) arrayList.toArray(new String[arrayList.size()]);
            }
            strArr = this.supportedCipherSuites;
            if (strArr != null) {
                sSLSocket.setEnabledCipherSuites(strArr);
            }
            if (this.log.isDebugEnabled()) {
                this.log.debug("Enabled protocols: " + Arrays.asList(sSLSocket.getEnabledProtocols()));
                this.log.debug("Enabled cipher suites:" + Arrays.asList(sSLSocket.getEnabledCipherSuites()));
            }
            prepareSocket(sSLSocket);
            this.log.debug("Starting handshake");
            sSLSocket.startHandshake();
            verifyHostname(sSLSocket, str);
            return sSLSocket;
        }
        sSLSocket.setEnabledProtocols(strArr2);
        strArr = this.supportedCipherSuites;
        if (strArr != null) {
        }
        if (this.log.isDebugEnabled()) {
        }
        prepareSocket(sSLSocket);
        this.log.debug("Starting handshake");
        sSLSocket.startHandshake();
        verifyHostname(sSLSocket, str);
        return sSLSocket;
    }

    @Override // cz.msebera.android.httpclient.conn.socket.ConnectionSocketFactory
    public Socket createSocket(HttpContext httpContext) {
        return SocketFactory.getDefault().createSocket();
    }

    protected void prepareSocket(SSLSocket sSLSocket) {
    }
}
