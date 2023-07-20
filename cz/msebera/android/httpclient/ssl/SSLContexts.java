package cz.msebera.android.httpclient.ssl;

import cz.msebera.android.httpclient.annotation.Immutable;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import javax.net.ssl.SSLContext;

@Immutable
/* loaded from: classes.dex */
public class SSLContexts {
    public static SSLContext createDefault() {
        try {
            SSLContext sSLContext = SSLContext.getInstance("TLS");
            sSLContext.init(null, null, null);
            return sSLContext;
        } catch (KeyManagementException e) {
            throw new SSLInitializationException(e.getMessage(), e);
        } catch (NoSuchAlgorithmException e2) {
            throw new SSLInitializationException(e2.getMessage(), e2);
        }
    }

    public static SSLContext createSystemDefault() {
        try {
            return SSLContext.getDefault();
        } catch (NoSuchAlgorithmException unused) {
            return createDefault();
        }
    }

    public static SSLContextBuilder custom() {
        return SSLContextBuilder.create();
    }
}
