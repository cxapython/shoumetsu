package cz.msebera.android.httpclient.conn;

import cz.msebera.android.httpclient.annotation.NotThreadSafe;
import cz.msebera.android.httpclient.util.Args;
import java.io.IOException;
import java.io.InputStream;

@NotThreadSafe
/* loaded from: classes.dex */
public class EofSensorInputStream extends InputStream implements ConnectionReleaseTrigger {
    private final EofSensorWatcher eofWatcher;
    private boolean selfClosed;
    protected InputStream wrappedStream;

    public EofSensorInputStream(InputStream inputStream, EofSensorWatcher eofSensorWatcher) {
        Args.notNull(inputStream, "Wrapped stream");
        this.wrappedStream = inputStream;
        this.selfClosed = false;
        this.eofWatcher = eofSensorWatcher;
    }

    @Override // cz.msebera.android.httpclient.conn.ConnectionReleaseTrigger
    public void abortConnection() {
        this.selfClosed = true;
        checkAbort();
    }

    @Override // java.io.InputStream
    public int available() {
        if (isReadAllowed()) {
            try {
                return this.wrappedStream.available();
            } catch (IOException e) {
                checkAbort();
                throw e;
            }
        }
        return 0;
    }

    protected void checkAbort() {
        InputStream inputStream = this.wrappedStream;
        if (inputStream != null) {
            boolean z = true;
            try {
                if (this.eofWatcher != null) {
                    z = this.eofWatcher.streamAbort(inputStream);
                }
                if (z) {
                    this.wrappedStream.close();
                }
            } finally {
                this.wrappedStream = null;
            }
        }
    }

    protected void checkClose() {
        InputStream inputStream = this.wrappedStream;
        if (inputStream != null) {
            boolean z = true;
            try {
                if (this.eofWatcher != null) {
                    z = this.eofWatcher.streamClosed(inputStream);
                }
                if (z) {
                    this.wrappedStream.close();
                }
            } finally {
                this.wrappedStream = null;
            }
        }
    }

    protected void checkEOF(int i) {
        InputStream inputStream = this.wrappedStream;
        if (inputStream == null || i >= 0) {
            return;
        }
        boolean z = true;
        try {
            if (this.eofWatcher != null) {
                z = this.eofWatcher.eofDetected(inputStream);
            }
            if (z) {
                this.wrappedStream.close();
            }
        } finally {
            this.wrappedStream = null;
        }
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.selfClosed = true;
        checkClose();
    }

    InputStream getWrappedStream() {
        return this.wrappedStream;
    }

    protected boolean isReadAllowed() {
        if (!this.selfClosed) {
            return this.wrappedStream != null;
        }
        throw new IOException("Attempted read on closed stream.");
    }

    boolean isSelfClosed() {
        return this.selfClosed;
    }

    @Override // java.io.InputStream
    public int read() {
        if (isReadAllowed()) {
            try {
                int read = this.wrappedStream.read();
                checkEOF(read);
                return read;
            } catch (IOException e) {
                checkAbort();
                throw e;
            }
        }
        return -1;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) {
        if (isReadAllowed()) {
            try {
                int read = this.wrappedStream.read(bArr, i, i2);
                checkEOF(read);
                return read;
            } catch (IOException e) {
                checkAbort();
                throw e;
            }
        }
        return -1;
    }

    @Override // cz.msebera.android.httpclient.conn.ConnectionReleaseTrigger
    public void releaseConnection() {
        close();
    }
}
