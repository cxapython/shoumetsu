package cz.msebera.android.httpclient.impl.io;

import cz.msebera.android.httpclient.annotation.NotThreadSafe;
import cz.msebera.android.httpclient.io.EofSensor;
import cz.msebera.android.httpclient.params.HttpParams;
import cz.msebera.android.httpclient.util.Args;
import java.net.Socket;

@NotThreadSafe
@Deprecated
/* loaded from: classes.dex */
public class SocketInputBuffer extends AbstractSessionInputBuffer implements EofSensor {
    private boolean eof;
    private final Socket socket;

    public SocketInputBuffer(Socket socket, int i, HttpParams httpParams) {
        Args.notNull(socket, "Socket");
        this.socket = socket;
        this.eof = false;
        i = i < 0 ? socket.getReceiveBufferSize() : i;
        init(socket.getInputStream(), i < 1024 ? 1024 : i, httpParams);
    }

    @Override // cz.msebera.android.httpclient.impl.io.AbstractSessionInputBuffer
    protected int fillBuffer() {
        int fillBuffer = super.fillBuffer();
        this.eof = fillBuffer == -1;
        return fillBuffer;
    }

    @Override // cz.msebera.android.httpclient.io.SessionInputBuffer
    public boolean isDataAvailable(int i) {
        boolean hasBufferedData = hasBufferedData();
        if (!hasBufferedData) {
            int soTimeout = this.socket.getSoTimeout();
            try {
                this.socket.setSoTimeout(i);
                fillBuffer();
                return hasBufferedData();
            } finally {
                this.socket.setSoTimeout(soTimeout);
            }
        }
        return hasBufferedData;
    }

    @Override // cz.msebera.android.httpclient.io.EofSensor
    public boolean isEof() {
        return this.eof;
    }
}
