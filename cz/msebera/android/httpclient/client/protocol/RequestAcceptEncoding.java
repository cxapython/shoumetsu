package cz.msebera.android.httpclient.client.protocol;

import cz.msebera.android.httpclient.HttpHeaders;
import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.HttpRequestInterceptor;
import cz.msebera.android.httpclient.annotation.Immutable;
import cz.msebera.android.httpclient.protocol.HttpContext;
import java.util.List;

@Immutable
/* loaded from: classes.dex */
public class RequestAcceptEncoding implements HttpRequestInterceptor {
    private final String acceptEncoding;

    public RequestAcceptEncoding() {
        this(null);
    }

    public RequestAcceptEncoding(List<String> list) {
        String str;
        if (list == null || list.isEmpty()) {
            str = "gzip,deflate";
        } else {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < list.size(); i++) {
                if (i > 0) {
                    sb.append(",");
                }
                sb.append(list.get(i));
            }
            str = sb.toString();
        }
        this.acceptEncoding = str;
    }

    @Override // cz.msebera.android.httpclient.HttpRequestInterceptor
    public void process(HttpRequest httpRequest, HttpContext httpContext) {
        if (!httpRequest.containsHeader(HttpHeaders.ACCEPT_ENCODING)) {
            httpRequest.addHeader(HttpHeaders.ACCEPT_ENCODING, this.acceptEncoding);
        }
    }
}
