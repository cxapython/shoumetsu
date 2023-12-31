package cz.msebera.android.httpclient.impl.conn;

import com.adjust.sdk.Constants;
import cz.msebera.android.httpclient.HttpHost;
import cz.msebera.android.httpclient.annotation.Immutable;
import cz.msebera.android.httpclient.conn.SchemePortResolver;
import cz.msebera.android.httpclient.conn.UnsupportedSchemeException;
import cz.msebera.android.httpclient.util.Args;

@Immutable
/* loaded from: classes.dex */
public class DefaultSchemePortResolver implements SchemePortResolver {
    public static final DefaultSchemePortResolver INSTANCE = new DefaultSchemePortResolver();

    @Override // cz.msebera.android.httpclient.conn.SchemePortResolver
    public int resolve(HttpHost httpHost) {
        Args.notNull(httpHost, "HTTP host");
        int port = httpHost.getPort();
        if (port > 0) {
            return port;
        }
        String schemeName = httpHost.getSchemeName();
        if (schemeName.equalsIgnoreCase(HttpHost.DEFAULT_SCHEME_NAME)) {
            return 80;
        }
        if (schemeName.equalsIgnoreCase(Constants.SCHEME)) {
            return 443;
        }
        throw new UnsupportedSchemeException(schemeName + " protocol is not supported");
    }
}
