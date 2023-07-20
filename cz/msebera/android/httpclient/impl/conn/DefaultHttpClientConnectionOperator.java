package cz.msebera.android.httpclient.impl.conn;

import cz.msebera.android.httpclient.HttpHost;
import cz.msebera.android.httpclient.annotation.Immutable;
import cz.msebera.android.httpclient.client.protocol.HttpClientContext;
import cz.msebera.android.httpclient.config.Lookup;
import cz.msebera.android.httpclient.config.SocketConfig;
import cz.msebera.android.httpclient.conn.ConnectTimeoutException;
import cz.msebera.android.httpclient.conn.DnsResolver;
import cz.msebera.android.httpclient.conn.HttpClientConnectionOperator;
import cz.msebera.android.httpclient.conn.HttpHostConnectException;
import cz.msebera.android.httpclient.conn.ManagedHttpClientConnection;
import cz.msebera.android.httpclient.conn.SchemePortResolver;
import cz.msebera.android.httpclient.conn.UnsupportedSchemeException;
import cz.msebera.android.httpclient.conn.socket.ConnectionSocketFactory;
import cz.msebera.android.httpclient.conn.socket.LayeredConnectionSocketFactory;
import cz.msebera.android.httpclient.extras.HttpClientAndroidLog;
import cz.msebera.android.httpclient.protocol.HttpContext;
import cz.msebera.android.httpclient.util.Args;
import java.net.ConnectException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.NoRouteToHostException;
import java.net.Socket;
import java.net.SocketTimeoutException;

@Immutable
/* loaded from: classes.dex */
public class DefaultHttpClientConnectionOperator implements HttpClientConnectionOperator {
    static final String SOCKET_FACTORY_REGISTRY = "http.socket-factory-registry";
    private final DnsResolver dnsResolver;
    public HttpClientAndroidLog log = new HttpClientAndroidLog(getClass());
    private final SchemePortResolver schemePortResolver;
    private final Lookup<ConnectionSocketFactory> socketFactoryRegistry;

    public DefaultHttpClientConnectionOperator(Lookup<ConnectionSocketFactory> lookup, SchemePortResolver schemePortResolver, DnsResolver dnsResolver) {
        Args.notNull(lookup, "Socket factory registry");
        this.socketFactoryRegistry = lookup;
        this.schemePortResolver = schemePortResolver == null ? DefaultSchemePortResolver.INSTANCE : schemePortResolver;
        this.dnsResolver = dnsResolver == null ? SystemDefaultDnsResolver.INSTANCE : dnsResolver;
    }

    private Lookup<ConnectionSocketFactory> getSocketFactoryRegistry(HttpContext httpContext) {
        Lookup<ConnectionSocketFactory> lookup = (Lookup) httpContext.getAttribute("http.socket-factory-registry");
        return lookup == null ? this.socketFactoryRegistry : lookup;
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x011b A[SYNTHETIC] */
    @Override // cz.msebera.android.httpclient.conn.HttpClientConnectionOperator
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void connect(ManagedHttpClientConnection managedHttpClientConnection, HttpHost httpHost, InetSocketAddress inetSocketAddress, int i, SocketConfig socketConfig, HttpContext httpContext) {
        ConnectionSocketFactory mo34lookup = getSocketFactoryRegistry(httpContext).mo34lookup(httpHost.getSchemeName());
        if (mo34lookup == null) {
            throw new UnsupportedSchemeException(httpHost.getSchemeName() + " protocol is not supported");
        }
        InetAddress[] resolve = httpHost.getAddress() != null ? new InetAddress[]{httpHost.getAddress()} : this.dnsResolver.resolve(httpHost.getHostName());
        int resolve2 = this.schemePortResolver.resolve(httpHost);
        int i2 = 0;
        while (i2 < resolve.length) {
            InetAddress inetAddress = resolve[i2];
            boolean z = i2 == resolve.length - 1;
            Socket createSocket = mo34lookup.createSocket(httpContext);
            createSocket.setSoTimeout(socketConfig.getSoTimeout());
            createSocket.setReuseAddress(socketConfig.isSoReuseAddress());
            createSocket.setTcpNoDelay(socketConfig.isTcpNoDelay());
            createSocket.setKeepAlive(socketConfig.isSoKeepAlive());
            int soLinger = socketConfig.getSoLinger();
            if (soLinger >= 0) {
                createSocket.setSoLinger(true, soLinger);
            }
            managedHttpClientConnection.bind(createSocket);
            InetSocketAddress inetSocketAddress2 = new InetSocketAddress(inetAddress, resolve2);
            if (this.log.isDebugEnabled()) {
                HttpClientAndroidLog httpClientAndroidLog = this.log;
                httpClientAndroidLog.debug("Connecting to " + inetSocketAddress2);
            }
            int i3 = i2;
            int i4 = resolve2;
            try {
                managedHttpClientConnection.bind(mo34lookup.connectSocket(i, createSocket, httpHost, inetSocketAddress2, inetSocketAddress, httpContext));
                if (!this.log.isDebugEnabled()) {
                    return;
                }
                HttpClientAndroidLog httpClientAndroidLog2 = this.log;
                httpClientAndroidLog2.debug("Connection established " + managedHttpClientConnection);
                return;
            } catch (ConnectException e) {
                if (z) {
                    if (!"Connection timed out".equals(e.getMessage())) {
                        throw new HttpHostConnectException(e, httpHost, resolve);
                    }
                    throw new ConnectTimeoutException(e, httpHost, resolve);
                }
                if (this.log.isDebugEnabled()) {
                    HttpClientAndroidLog httpClientAndroidLog3 = this.log;
                    httpClientAndroidLog3.debug("Connect to " + inetSocketAddress2 + " timed out. Connection will be retried using another IP address");
                }
                i2 = i3 + 1;
                resolve2 = i4;
            } catch (NoRouteToHostException e2) {
                if (z) {
                    throw e2;
                }
                if (this.log.isDebugEnabled()) {
                }
                i2 = i3 + 1;
                resolve2 = i4;
            } catch (SocketTimeoutException e3) {
                if (z) {
                    throw new ConnectTimeoutException(e3, httpHost, resolve);
                }
                if (this.log.isDebugEnabled()) {
                }
                i2 = i3 + 1;
                resolve2 = i4;
            }
        }
    }

    @Override // cz.msebera.android.httpclient.conn.HttpClientConnectionOperator
    public void upgrade(ManagedHttpClientConnection managedHttpClientConnection, HttpHost httpHost, HttpContext httpContext) {
        ConnectionSocketFactory mo34lookup = getSocketFactoryRegistry(HttpClientContext.adapt(httpContext)).mo34lookup(httpHost.getSchemeName());
        if (mo34lookup == null) {
            throw new UnsupportedSchemeException(httpHost.getSchemeName() + " protocol is not supported");
        } else if (mo34lookup instanceof LayeredConnectionSocketFactory) {
            managedHttpClientConnection.bind(((LayeredConnectionSocketFactory) mo34lookup).createLayeredSocket(managedHttpClientConnection.getSocket(), httpHost.getHostName(), this.schemePortResolver.resolve(httpHost), httpContext));
        } else {
            throw new UnsupportedSchemeException(httpHost.getSchemeName() + " protocol does not support connection upgrade");
        }
    }
}
