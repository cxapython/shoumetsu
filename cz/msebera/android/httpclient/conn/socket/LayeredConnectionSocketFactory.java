package cz.msebera.android.httpclient.conn.socket;

import cz.msebera.android.httpclient.protocol.HttpContext;
import java.net.Socket;

/* loaded from: classes.dex */
public interface LayeredConnectionSocketFactory extends ConnectionSocketFactory {
    Socket createLayeredSocket(Socket socket, String str, int i, HttpContext httpContext);
}
