package cz.msebera.android.httpclient.impl.conn;

import com.adjust.sdk.Constants;
import cz.msebera.android.httpclient.HttpHost;
import cz.msebera.android.httpclient.annotation.ThreadSafe;
import cz.msebera.android.httpclient.conn.scheme.PlainSocketFactory;
import cz.msebera.android.httpclient.conn.scheme.Scheme;
import cz.msebera.android.httpclient.conn.scheme.SchemeRegistry;
import cz.msebera.android.httpclient.conn.ssl.SSLSocketFactory;

@ThreadSafe
@Deprecated
/* loaded from: classes.dex */
public final class SchemeRegistryFactory {
    public static SchemeRegistry createDefault() {
        SchemeRegistry schemeRegistry = new SchemeRegistry();
        schemeRegistry.register(new Scheme(HttpHost.DEFAULT_SCHEME_NAME, 80, PlainSocketFactory.getSocketFactory()));
        schemeRegistry.register(new Scheme(Constants.SCHEME, 443, SSLSocketFactory.getSocketFactory()));
        return schemeRegistry;
    }

    public static SchemeRegistry createSystemDefault() {
        SchemeRegistry schemeRegistry = new SchemeRegistry();
        schemeRegistry.register(new Scheme(HttpHost.DEFAULT_SCHEME_NAME, 80, PlainSocketFactory.getSocketFactory()));
        schemeRegistry.register(new Scheme(Constants.SCHEME, 443, SSLSocketFactory.getSystemSocketFactory()));
        return schemeRegistry;
    }
}
