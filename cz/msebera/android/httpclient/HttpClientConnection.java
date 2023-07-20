package cz.msebera.android.httpclient;

/* loaded from: classes.dex */
public interface HttpClientConnection extends HttpConnection {
    void flush();

    boolean isResponseAvailable(int i);

    void receiveResponseEntity(HttpResponse httpResponse);

    HttpResponse receiveResponseHeader();

    void sendRequestEntity(HttpEntityEnclosingRequest httpEntityEnclosingRequest);

    void sendRequestHeader(HttpRequest httpRequest);
}
