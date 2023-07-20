package com.c.a.a;

import cz.msebera.android.httpclient.conn.ssl.SSLSocketFactory;
import java.net.Socket;
import java.security.KeyStore;
import java.security.cert.X509Certificate;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

/* loaded from: classes.dex */
public class j extends SSLSocketFactory {
    final SSLContext a;

    public j(KeyStore keyStore) {
        super(keyStore);
        this.a = SSLContext.getInstance("TLS");
        this.a.init(null, new TrustManager[]{new X509TrustManager() { // from class: com.c.a.a.j.1
            @Override // javax.net.ssl.X509TrustManager
            public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) {
            }

            @Override // javax.net.ssl.X509TrustManager
            public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) {
            }

            @Override // javax.net.ssl.X509TrustManager
            public X509Certificate[] getAcceptedIssuers() {
                return null;
            }
        }}, null);
    }

    public static KeyStore a() {
        KeyStore keyStore;
        KeyStore keyStore2 = null;
        try {
            keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
        } catch (Throwable th) {
            th = th;
        }
        try {
            keyStore.load(null, null);
            return keyStore;
        } catch (Throwable th2) {
            th = th2;
            keyStore2 = keyStore;
            th.printStackTrace();
            return keyStore2;
        }
    }

    public static SSLSocketFactory b() {
        try {
            j jVar = new j(a());
            jVar.setHostnameVerifier(SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
            return jVar;
        } catch (Throwable th) {
            th.printStackTrace();
            return SSLSocketFactory.getSocketFactory();
        }
    }

    @Override // cz.msebera.android.httpclient.conn.ssl.SSLSocketFactory, cz.msebera.android.httpclient.conn.scheme.SocketFactory
    public Socket createSocket() {
        return this.a.getSocketFactory().createSocket();
    }

    @Override // cz.msebera.android.httpclient.conn.ssl.SSLSocketFactory, cz.msebera.android.httpclient.conn.scheme.LayeredSocketFactory
    public Socket createSocket(Socket socket, String str, int i, boolean z) {
        return this.a.getSocketFactory().createSocket(socket, str, i, z);
    }
}
