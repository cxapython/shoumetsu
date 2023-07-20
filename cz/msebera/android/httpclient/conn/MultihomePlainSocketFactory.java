package cz.msebera.android.httpclient.conn;

import cz.msebera.android.httpclient.annotation.Immutable;
import cz.msebera.android.httpclient.conn.scheme.SocketFactory;
import cz.msebera.android.httpclient.params.HttpConnectionParams;
import cz.msebera.android.httpclient.params.HttpParams;
import cz.msebera.android.httpclient.util.Args;
import cz.msebera.android.httpclient.util.Asserts;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

@Immutable
@Deprecated
/* loaded from: classes.dex */
public final class MultihomePlainSocketFactory implements SocketFactory {
    private static final MultihomePlainSocketFactory DEFAULT_FACTORY = new MultihomePlainSocketFactory();

    private MultihomePlainSocketFactory() {
    }

    public static MultihomePlainSocketFactory getSocketFactory() {
        return DEFAULT_FACTORY;
    }

    @Override // cz.msebera.android.httpclient.conn.scheme.SocketFactory
    public Socket connectSocket(Socket socket, String str, int i, InetAddress inetAddress, int i2, HttpParams httpParams) {
        Args.notNull(str, "Target host");
        Args.notNull(httpParams, "HTTP parameters");
        if (socket == null) {
            socket = createSocket();
        }
        if (inetAddress != null || i2 > 0) {
            if (i2 <= 0) {
                i2 = 0;
            }
            socket.bind(new InetSocketAddress(inetAddress, i2));
        }
        int connectionTimeout = HttpConnectionParams.getConnectionTimeout(httpParams);
        InetAddress[] allByName = InetAddress.getAllByName(str);
        ArrayList<InetAddress> arrayList = new ArrayList(allByName.length);
        arrayList.addAll(Arrays.asList(allByName));
        Collections.shuffle(arrayList);
        IOException iOException = null;
        for (InetAddress inetAddress2 : arrayList) {
            try {
                socket.connect(new InetSocketAddress(inetAddress2, i), connectionTimeout);
                break;
            } catch (SocketTimeoutException unused) {
                throw new ConnectTimeoutException("Connect to " + inetAddress2 + " timed out");
            } catch (IOException e) {
                iOException = e;
                socket = new Socket();
            }
        }
        if (iOException == null) {
            return socket;
        }
        throw iOException;
    }

    @Override // cz.msebera.android.httpclient.conn.scheme.SocketFactory
    public Socket createSocket() {
        return new Socket();
    }

    @Override // cz.msebera.android.httpclient.conn.scheme.SocketFactory
    public final boolean isSecure(Socket socket) {
        Args.notNull(socket, "Socket");
        Asserts.check(!socket.isClosed(), "Socket is closed");
        return false;
    }
}
