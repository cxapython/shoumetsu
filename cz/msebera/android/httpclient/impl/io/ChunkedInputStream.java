package cz.msebera.android.httpclient.impl.io;

import cz.msebera.android.httpclient.ConnectionClosedException;
import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HttpException;
import cz.msebera.android.httpclient.MalformedChunkCodingException;
import cz.msebera.android.httpclient.TruncatedChunkException;
import cz.msebera.android.httpclient.annotation.NotThreadSafe;
import cz.msebera.android.httpclient.config.MessageConstraints;
import cz.msebera.android.httpclient.io.BufferInfo;
import cz.msebera.android.httpclient.io.SessionInputBuffer;
import cz.msebera.android.httpclient.util.Args;
import cz.msebera.android.httpclient.util.CharArrayBuffer;
import java.io.IOException;
import java.io.InputStream;

@NotThreadSafe
/* loaded from: classes.dex */
public class ChunkedInputStream extends InputStream {
    private static final int BUFFER_SIZE = 2048;
    private static final int CHUNK_CRLF = 3;
    private static final int CHUNK_DATA = 2;
    private static final int CHUNK_INVALID = Integer.MAX_VALUE;
    private static final int CHUNK_LEN = 1;
    private final CharArrayBuffer buffer;
    private int chunkSize;
    private boolean closed;
    private final MessageConstraints constraints;
    private boolean eof;
    private Header[] footers;
    private final SessionInputBuffer in;
    private int pos;
    private int state;

    public ChunkedInputStream(SessionInputBuffer sessionInputBuffer) {
        this(sessionInputBuffer, null);
    }

    public ChunkedInputStream(SessionInputBuffer sessionInputBuffer, MessageConstraints messageConstraints) {
        this.eof = false;
        this.closed = false;
        this.footers = new Header[0];
        this.in = (SessionInputBuffer) Args.notNull(sessionInputBuffer, "Session input buffer");
        this.pos = 0;
        this.buffer = new CharArrayBuffer(16);
        this.constraints = messageConstraints == null ? MessageConstraints.DEFAULT : messageConstraints;
        this.state = 1;
    }

    private int getChunkSize() {
        int i = this.state;
        if (i != 1) {
            if (i != 3) {
                throw new IllegalStateException("Inconsistent codec state");
            }
            this.buffer.clear();
            if (this.in.readLine(this.buffer) == -1) {
                throw new MalformedChunkCodingException("CRLF expected at end of chunk");
            }
            if (!this.buffer.isEmpty()) {
                throw new MalformedChunkCodingException("Unexpected content at the end of chunk");
            }
            this.state = 1;
        }
        this.buffer.clear();
        if (this.in.readLine(this.buffer) != -1) {
            int indexOf = this.buffer.indexOf(59);
            if (indexOf < 0) {
                indexOf = this.buffer.length();
            }
            try {
                return Integer.parseInt(this.buffer.substringTrimmed(0, indexOf), 16);
            } catch (NumberFormatException unused) {
                throw new MalformedChunkCodingException("Bad chunk header");
            }
        }
        throw new ConnectionClosedException("Premature end of chunk coded message body: closing chunk expected");
    }

    private void nextChunk() {
        if (this.state != Integer.MAX_VALUE) {
            try {
                this.chunkSize = getChunkSize();
                if (this.chunkSize < 0) {
                    throw new MalformedChunkCodingException("Negative chunk size");
                }
                this.state = 2;
                this.pos = 0;
                if (this.chunkSize != 0) {
                    return;
                }
                this.eof = true;
                parseTrailerHeaders();
                return;
            } catch (MalformedChunkCodingException e) {
                this.state = Integer.MAX_VALUE;
                throw e;
            }
        }
        throw new MalformedChunkCodingException("Corrupt data stream");
    }

    private void parseTrailerHeaders() {
        try {
            this.footers = AbstractMessageParser.parseHeaders(this.in, this.constraints.getMaxHeaderCount(), this.constraints.getMaxLineLength(), null);
        } catch (HttpException e) {
            MalformedChunkCodingException malformedChunkCodingException = new MalformedChunkCodingException("Invalid footer: " + e.getMessage());
            malformedChunkCodingException.initCause(e);
            throw malformedChunkCodingException;
        }
    }

    @Override // java.io.InputStream
    public int available() {
        SessionInputBuffer sessionInputBuffer = this.in;
        if (sessionInputBuffer instanceof BufferInfo) {
            return Math.min(((BufferInfo) sessionInputBuffer).length(), this.chunkSize - this.pos);
        }
        return 0;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (!this.closed) {
            try {
                if (this.eof || this.state == Integer.MAX_VALUE) {
                }
                do {
                } while (read(new byte[BUFFER_SIZE]) >= 0);
            } finally {
                this.eof = true;
                this.closed = true;
            }
        }
    }

    public Header[] getFooters() {
        return (Header[]) this.footers.clone();
    }

    @Override // java.io.InputStream
    public int read() {
        if (!this.closed) {
            if (this.eof) {
                return -1;
            }
            if (this.state != 2) {
                nextChunk();
                if (this.eof) {
                    return -1;
                }
            }
            int read = this.in.read();
            if (read != -1) {
                this.pos++;
                if (this.pos >= this.chunkSize) {
                    this.state = 3;
                }
            }
            return read;
        }
        throw new IOException("Attempted read from closed stream.");
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) {
        if (!this.closed) {
            if (this.eof) {
                return -1;
            }
            if (this.state != 2) {
                nextChunk();
                if (this.eof) {
                    return -1;
                }
            }
            int read = this.in.read(bArr, i, Math.min(i2, this.chunkSize - this.pos));
            if (read != -1) {
                this.pos += read;
                if (this.pos >= this.chunkSize) {
                    this.state = 3;
                }
                return read;
            }
            this.eof = true;
            throw new TruncatedChunkException("Truncated chunk ( expected size: " + this.chunkSize + "; actual size: " + this.pos + ")");
        }
        throw new IOException("Attempted read from closed stream.");
    }
}
