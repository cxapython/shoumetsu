package org.apache.james.mime4j.io;

import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
public class LimitedInputStream extends PositionInputStream {
    private final long limit;

    public LimitedInputStream(InputStream inputStream, long j) {
        super(inputStream);
        if (j >= 0) {
            this.limit = j;
            return;
        }
        throw new IllegalArgumentException("Limit may not be negative");
    }

    private void enforceLimit() {
        if (this.position < this.limit) {
            return;
        }
        throw new IOException("Input stream limit exceeded");
    }

    private int getBytesLeft() {
        return (int) Math.min(2147483647L, this.limit - this.position);
    }

    @Override // org.apache.james.mime4j.io.PositionInputStream, java.io.FilterInputStream, java.io.InputStream
    public int read() {
        enforceLimit();
        return super.read();
    }

    @Override // org.apache.james.mime4j.io.PositionInputStream, java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i, int i2) {
        enforceLimit();
        return super.read(bArr, i, Math.min(i2, getBytesLeft()));
    }

    @Override // org.apache.james.mime4j.io.PositionInputStream, java.io.FilterInputStream, java.io.InputStream
    public long skip(long j) {
        enforceLimit();
        return super.skip(Math.min(j, getBytesLeft()));
    }
}
