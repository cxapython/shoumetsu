package cz.msebera.android.httpclient;

/* loaded from: classes.dex */
public interface HttpRequestFactory {
    HttpRequest newHttpRequest(RequestLine requestLine);

    HttpRequest newHttpRequest(String str, String str2);
}
