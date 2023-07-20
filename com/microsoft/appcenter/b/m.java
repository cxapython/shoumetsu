package com.microsoft.appcenter.b;

import java.net.InetAddress;
import java.net.Socket;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

/* loaded from: classes.dex */
class m extends SSLSocketFactory {
    private static final String[] a = {"TLSv1.2"};
    private final SSLSocketFactory delegate;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m() {
        SSLSocketFactory sSLSocketFactory = null;
        try {
            SSLContext sSLContext = SSLContext.getInstance("TLSv1.2");
            sSLContext.init(null, null, null);
            sSLSocketFactory = sSLContext.getSocketFactory();
        } catch (KeyManagementException | NoSuchAlgorithmException unused) {
        }
        this.delegate = sSLSocketFactory == null ? HttpsURLConnection.getDefaultSSLSocketFactory() : sSLSocketFactory;
    }

    private SSLSocket a(Socket socket) {
        SSLSocket sSLSocket = (SSLSocket) socket;
        sSLSocket.setEnabledProtocols(a);
        return sSLSocket;
    }

    @Override // javax.net.SocketFactory
    /* renamed from: a */
    public SSLSocket createSocket() {
        return a(this.delegate.createSocket());
    }

    @Override // javax.net.SocketFactory
    /* renamed from: a */
    public SSLSocket createSocket(String str, int i) {
        return a(this.delegate.createSocket(str, i));
    }

    @Override // javax.net.SocketFactory
    /* renamed from: a */
    public SSLSocket createSocket(String str, int i, InetAddress inetAddress, int i2) {
        return a(this.delegate.createSocket(str, i, inetAddress, i2));
    }

    @Override // javax.net.SocketFactory
    /* renamed from: a */
    public SSLSocket createSocket(InetAddress inetAddress, int i) {
        return a(this.delegate.createSocket(inetAddress, i));
    }

    @Override // javax.net.SocketFactory
    /* renamed from: a */
    public SSLSocket createSocket(InetAddress inetAddress, int i, InetAddress inetAddress2, int i2) {
        return a(this.delegate.createSocket(inetAddress, i, inetAddress2, i2));
    }

    @Override // javax.net.ssl.SSLSocketFactory
    /* renamed from: a */
    public SSLSocket createSocket(Socket socket, String str, int i, boolean z) {
        return a(this.delegate.createSocket(socket, str, i, z));
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getDefaultCipherSuites() {
        return this.delegate.getDefaultCipherSuites();
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getSupportedCipherSuites() {
        return this.delegate.getSupportedCipherSuites();
    }
}
