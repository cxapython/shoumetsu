package cz.msebera.android.httpclient;

import cz.msebera.android.httpclient.HttpConnection;
import java.net.Socket;

/* loaded from: classes.dex */
public interface HttpConnectionFactory<T extends HttpConnection> {
    T createConnection(Socket socket);
}
