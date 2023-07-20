package cz.msebera.android.httpclient.impl.auth;

import java.io.IOException;
import java.io.OutputStream;
import java.security.MessageDigest;

/* loaded from: classes.dex */
class HttpEntityDigester extends OutputStream {
    private boolean closed;
    private byte[] digest;
    private final MessageDigest digester;

    /* JADX INFO: Access modifiers changed from: package-private */
    public HttpEntityDigester(MessageDigest messageDigest) {
        this.digester = messageDigest;
        this.digester.reset();
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.closed) {
            return;
        }
        this.closed = true;
        this.digest = this.digester.digest();
        super.close();
    }

    public byte[] getDigest() {
        return this.digest;
    }

    @Override // java.io.OutputStream
    public void write(int i) {
        if (!this.closed) {
            this.digester.update((byte) i);
            return;
        }
        throw new IOException("Stream has been already closed");
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) {
        if (!this.closed) {
            this.digester.update(bArr, i, i2);
            return;
        }
        throw new IOException("Stream has been already closed");
    }
}
