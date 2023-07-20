package org.apache.james.mime4j.io;

import java.io.FilterInputStream;
import java.io.InputStream;

/* loaded from: classes.dex */
public class PositionInputStream extends FilterInputStream {
    private long markedPosition;
    protected long position;

    public PositionInputStream(InputStream inputStream) {
        super(inputStream);
        this.position = 0L;
        this.markedPosition = 0L;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int available() {
        return this.in.available();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.in.close();
    }

    public long getPosition() {
        return this.position;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void mark(int i) {
        this.in.mark(i);
        this.markedPosition = this.position;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        return this.in.markSupported();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() {
        int read = this.in.read();
        if (read != -1) {
            this.position++;
        }
        return read;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i, int i2) {
        int read = this.in.read(bArr, i, i2);
        if (read > 0) {
            this.position += read;
        }
        return read;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void reset() {
        this.in.reset();
        this.position = this.markedPosition;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long j) {
        long skip = this.in.skip(j);
        if (skip > 0) {
            this.position += skip;
        }
        return skip;
    }
}
