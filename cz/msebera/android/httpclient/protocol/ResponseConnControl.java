package cz.msebera.android.httpclient.protocol;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HttpEntity;
import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.HttpResponseInterceptor;
import cz.msebera.android.httpclient.HttpVersion;
import cz.msebera.android.httpclient.ProtocolVersion;
import cz.msebera.android.httpclient.annotation.Immutable;
import cz.msebera.android.httpclient.util.Args;

@Immutable
/* loaded from: classes.dex */
public class ResponseConnControl implements HttpResponseInterceptor {
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0067, code lost:
        if (r1.lessEquals(cz.msebera.android.httpclient.HttpVersion.HTTP_1_0) != false) goto L41;
     */
    @Override // cz.msebera.android.httpclient.HttpResponseInterceptor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void process(HttpResponse httpResponse, HttpContext httpContext) {
        String str;
        String str2;
        Args.notNull(httpResponse, "HTTP response");
        HttpCoreContext adapt = HttpCoreContext.adapt(httpContext);
        int statusCode = httpResponse.getStatusLine().getStatusCode();
        if (statusCode != 400 && statusCode != 408 && statusCode != 411 && statusCode != 413 && statusCode != 414 && statusCode != 503 && statusCode != 501) {
            Header firstHeader = httpResponse.getFirstHeader("Connection");
            if (firstHeader != null && HTTP.CONN_CLOSE.equalsIgnoreCase(firstHeader.getValue())) {
                return;
            }
            HttpEntity entity = httpResponse.getEntity();
            if (entity != null) {
                ProtocolVersion protocolVersion = httpResponse.getStatusLine().getProtocolVersion();
                if (entity.getContentLength() < 0) {
                    if (entity.isChunked()) {
                    }
                }
            }
            HttpRequest request = adapt.getRequest();
            if (request == null) {
                return;
            }
            Header firstHeader2 = request.getFirstHeader("Connection");
            if (firstHeader2 != null) {
                str = "Connection";
                str2 = firstHeader2.getValue();
            } else if (!request.getProtocolVersion().lessEquals(HttpVersion.HTTP_1_0)) {
                return;
            } else {
                str = "Connection";
                str2 = HTTP.CONN_CLOSE;
            }
            httpResponse.setHeader(str, str2);
            return;
        }
        httpResponse.setHeader("Connection", HTTP.CONN_CLOSE);
    }
}
