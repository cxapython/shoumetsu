package org.apache.james.mime4j.storage;

import java.io.IOException;
import java.io.OutputStream;

/* loaded from: classes.dex */
public abstract class StorageOutputStream extends OutputStream {
    private boolean closed;
    private byte[] singleByte;
    private boolean usedUp;

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.closed = true;
    }

    public final Storage toStorage() {
        if (!this.usedUp) {
            if (!this.closed) {
                close();
            }
            this.usedUp = true;
            return toStorage0();
        }
        throw new IllegalStateException("toStorage may be invoked only once");
    }

    protected abstract Storage toStorage0();

    @Override // java.io.OutputStream
    public final void write(int i) {
        if (!this.closed) {
            if (this.singleByte == null) {
                this.singleByte = new byte[1];
            }
            byte[] bArr = this.singleByte;
            bArr[0] = (byte) i;
            write0(bArr, 0, 1);
            return;
        }
        throw new IOException("StorageOutputStream has been closed");
    }

    @Override // java.io.OutputStream
    public final void write(byte[] bArr) {
        if (!this.closed) {
            if (bArr == null) {
                throw new NullPointerException();
            }
            if (bArr.length == 0) {
                return;
            }
            write0(bArr, 0, bArr.length);
            return;
        }
        throw new IOException("StorageOutputStream has been closed");
    }

    @Override // java.io.OutputStream
    public final void write(byte[] bArr, int i, int i2) {
        if (!this.closed) {
            if (bArr == null) {
                throw new NullPointerException();
            }
            if (i < 0 || i2 < 0 || i + i2 > bArr.length) {
                throw new IndexOutOfBoundsException();
            }
            if (i2 == 0) {
                return;
            }
            write0(bArr, i, i2);
            return;
        }
        throw new IOException("StorageOutputStream has been closed");
    }

    protected abstract void write0(byte[] bArr, int i, int i2);
}
