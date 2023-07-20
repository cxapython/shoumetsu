package cz.msebera.android.httpclient.conn.scheme;

import java.net.Socket;

@Deprecated
/* loaded from: classes.dex */
class LayeredSocketFactoryAdaptor extends SocketFactoryAdaptor implements LayeredSocketFactory {
    private final LayeredSchemeSocketFactory factory;

    /* JADX INFO: Access modifiers changed from: package-private */
    public LayeredSocketFactoryAdaptor(LayeredSchemeSocketFactory layeredSchemeSocketFactory) {
        super(layeredSchemeSocketFactory);
        this.factory = layeredSchemeSocketFactory;
    }

    @Override // cz.msebera.android.httpclient.conn.scheme.LayeredSocketFactory
    public Socket createSocket(Socket socket, String str, int i, boolean z) {
        return this.factory.createLayeredSocket(socket, str, i, z);
    }
}
