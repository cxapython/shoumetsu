package cz.msebera.android.httpclient.impl.conn;

import cz.msebera.android.httpclient.annotation.NotThreadSafe;
import java.io.IOException;
import java.io.OutputStream;

@NotThreadSafe
/* loaded from: classes.dex */
class LoggingOutputStream extends OutputStream {
    private final OutputStream out;
    private final Wire wire;

    public LoggingOutputStream(OutputStream outputStream, Wire wire) {
        this.out = outputStream;
        this.wire = wire;
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        try {
            this.out.close();
        } catch (IOException e) {
            Wire wire = this.wire;
            wire.output("[close] I/O error: " + e.getMessage());
            throw e;
        }
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() {
        try {
            this.out.flush();
        } catch (IOException e) {
            Wire wire = this.wire;
            wire.output("[flush] I/O error: " + e.getMessage());
            throw e;
        }
    }

    @Override // java.io.OutputStream
    public void write(int i) {
        try {
            this.wire.output(i);
        } catch (IOException e) {
            Wire wire = this.wire;
            wire.output("[write] I/O error: " + e.getMessage());
            throw e;
        }
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) {
        try {
            this.wire.output(bArr);
            this.out.write(bArr);
        } catch (IOException e) {
            Wire wire = this.wire;
            wire.output("[write] I/O error: " + e.getMessage());
            throw e;
        }
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) {
        try {
            this.wire.output(bArr, i, i2);
            this.out.write(bArr, i, i2);
        } catch (IOException e) {
            Wire wire = this.wire;
            wire.output("[write] I/O error: " + e.getMessage());
            throw e;
        }
    }
}
