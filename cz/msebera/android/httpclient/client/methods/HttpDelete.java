package cz.msebera.android.httpclient.client.methods;

import cz.msebera.android.httpclient.annotation.NotThreadSafe;
import java.net.URI;

@NotThreadSafe
/* loaded from: classes.dex */
public class HttpDelete extends HttpRequestBase {
    public static final String METHOD_NAME = "DELETE";

    public HttpDelete() {
    }

    public HttpDelete(String str) {
        setURI(URI.create(str));
    }

    public HttpDelete(URI uri) {
        setURI(uri);
    }

    @Override // cz.msebera.android.httpclient.client.methods.HttpRequestBase, cz.msebera.android.httpclient.client.methods.HttpUriRequest
    public String getMethod() {
        return "DELETE";
    }
}
