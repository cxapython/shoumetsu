package cz.msebera.android.httpclient.impl.conn;

import cz.msebera.android.httpclient.HttpHost;
import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.annotation.Immutable;
import cz.msebera.android.httpclient.conn.SchemePortResolver;
import cz.msebera.android.httpclient.protocol.HttpContext;
import cz.msebera.android.httpclient.util.Args;

@Immutable
/* loaded from: classes.dex */
public class DefaultProxyRoutePlanner extends DefaultRoutePlanner {
    private final HttpHost proxy;

    public DefaultProxyRoutePlanner(HttpHost httpHost) {
        this(httpHost, null);
    }

    public DefaultProxyRoutePlanner(HttpHost httpHost, SchemePortResolver schemePortResolver) {
        super(schemePortResolver);
        this.proxy = (HttpHost) Args.notNull(httpHost, "Proxy host");
    }

    @Override // cz.msebera.android.httpclient.impl.conn.DefaultRoutePlanner
    protected HttpHost determineProxy(HttpHost httpHost, HttpRequest httpRequest, HttpContext httpContext) {
        return this.proxy;
    }
}
