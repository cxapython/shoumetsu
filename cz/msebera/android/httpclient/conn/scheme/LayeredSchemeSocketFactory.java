package cz.msebera.android.httpclient.conn.scheme;

import java.net.Socket;

@Deprecated
/* loaded from: classes.dex */
public interface LayeredSchemeSocketFactory extends SchemeSocketFactory {
    Socket createLayeredSocket(Socket socket, String str, int i, boolean z);
}
