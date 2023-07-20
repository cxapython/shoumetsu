package cz.msebera.android.httpclient.protocol;

import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.HttpResponseInterceptor;
import cz.msebera.android.httpclient.annotation.Immutable;
import cz.msebera.android.httpclient.util.Args;

@Immutable
/* loaded from: classes.dex */
public class ResponseServer implements HttpResponseInterceptor {
    private final String originServer;

    public ResponseServer() {
        this(null);
    }

    public ResponseServer(String str) {
        this.originServer = str;
    }

    @Override // cz.msebera.android.httpclient.HttpResponseInterceptor
    public void process(HttpResponse httpResponse, HttpContext httpContext) {
        String str;
        Args.notNull(httpResponse, "HTTP response");
        if (httpResponse.containsHeader("Server") || (str = this.originServer) == null) {
            return;
        }
        httpResponse.addHeader("Server", str);
    }
}
