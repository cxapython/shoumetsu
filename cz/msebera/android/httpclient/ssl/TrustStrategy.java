package cz.msebera.android.httpclient.ssl;

import java.security.cert.X509Certificate;

/* loaded from: classes.dex */
public interface TrustStrategy {
    boolean isTrusted(X509Certificate[] x509CertificateArr, String str);
}
