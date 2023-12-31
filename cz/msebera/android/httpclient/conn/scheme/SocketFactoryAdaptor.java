package cz.msebera.android.httpclient.conn.scheme;

import cz.msebera.android.httpclient.params.BasicHttpParams;
import cz.msebera.android.httpclient.params.HttpParams;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;

@Deprecated
/* loaded from: classes.dex */
class SocketFactoryAdaptor implements SocketFactory {
    private final SchemeSocketFactory factory;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SocketFactoryAdaptor(SchemeSocketFactory schemeSocketFactory) {
        this.factory = schemeSocketFactory;
    }

    @Override // cz.msebera.android.httpclient.conn.scheme.SocketFactory
    public Socket connectSocket(Socket socket, String str, int i, InetAddress inetAddress, int i2, HttpParams httpParams) {
        InetSocketAddress inetSocketAddress;
        if (inetAddress != null || i2 > 0) {
            if (i2 <= 0) {
                i2 = 0;
            }
            inetSocketAddress = new InetSocketAddress(inetAddress, i2);
        } else {
            inetSocketAddress = null;
        }
        return this.factory.connectSocket(socket, new InetSocketAddress(InetAddress.getByName(str), i), inetSocketAddress, httpParams);
    }

    @Override // cz.msebera.android.httpclient.conn.scheme.SocketFactory
    public Socket createSocket() {
        return this.factory.createSocket(new BasicHttpParams());
    }

    public boolean equals(Object obj) {
        SchemeSocketFactory schemeSocketFactory;
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (obj instanceof SocketFactoryAdaptor) {
            schemeSocketFactory = this.factory;
            obj = ((SocketFactoryAdaptor) obj).factory;
        } else {
            schemeSocketFactory = this.factory;
        }
        return schemeSocketFactory.equals(obj);
    }

    public SchemeSocketFactory getFactory() {
        return this.factory;
    }

    public int hashCode() {
        return this.factory.hashCode();
    }

    @Override // cz.msebera.android.httpclient.conn.scheme.SocketFactory
    public boolean isSecure(Socket socket) {
        return this.factory.isSecure(socket);
    }
}
