package org.apache.james.mime4j.io;

import java.io.InputStream;
import org.apache.james.mime4j.util.ByteArrayBuffer;

/* loaded from: classes.dex */
public class BufferedLineReaderInputStream extends LineReaderInputStream {
    private byte[] buffer;
    private int buflen;
    private int bufpos;
    private final int maxLineLen;
    private boolean truncated;

    public BufferedLineReaderInputStream(InputStream inputStream, int i) {
        this(inputStream, i, -1);
    }

    public BufferedLineReaderInputStream(InputStream inputStream, int i, int i2) {
        super(inputStream);
        if (inputStream != null) {
            if (i <= 0) {
                throw new IllegalArgumentException("Buffer size may not be negative or zero");
            }
            this.buffer = new byte[i];
            this.bufpos = 0;
            this.buflen = 0;
            this.maxLineLen = i2;
            this.truncated = false;
            return;
        }
        throw new IllegalArgumentException("Input stream may not be null");
    }

    private void expand(int i) {
        byte[] bArr = new byte[i];
        int i2 = this.buflen;
        int i3 = this.bufpos;
        int i4 = i2 - i3;
        if (i4 > 0) {
            System.arraycopy(this.buffer, i3, bArr, i3, i4);
        }
        this.buffer = bArr;
    }

    public byte[] buf() {
        return this.buffer;
    }

    public int capacity() {
        return this.buffer.length;
    }

    public byte charAt(int i) {
        if (i < this.bufpos || i > this.buflen) {
            throw new IndexOutOfBoundsException();
        }
        return this.buffer[i];
    }

    public void clear() {
        this.bufpos = 0;
        this.buflen = 0;
    }

    public void ensureCapacity(int i) {
        if (i > this.buffer.length) {
            expand(i);
        }
    }

    public int fillBuffer() {
        int i = this.bufpos;
        if (i > 0) {
            int i2 = this.buflen - i;
            if (i2 > 0) {
                byte[] bArr = this.buffer;
                System.arraycopy(bArr, i, bArr, 0, i2);
            }
            this.bufpos = 0;
            this.buflen = i2;
        }
        int i3 = this.buflen;
        int read = this.in.read(this.buffer, i3, this.buffer.length - i3);
        if (read == -1) {
            return -1;
        }
        this.buflen = i3 + read;
        return read;
    }

    public boolean hasBufferedData() {
        return this.bufpos < this.buflen;
    }

    public int indexOf(byte b) {
        int i = this.bufpos;
        return indexOf(b, i, this.buflen - i);
    }

    public int indexOf(byte b, int i, int i2) {
        int i3;
        if (i < this.bufpos || i2 < 0 || (i3 = i2 + i) > this.buflen) {
            throw new IndexOutOfBoundsException();
        }
        while (i < i3) {
            if (this.buffer[i] == b) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public int indexOf(byte[] bArr) {
        int i = this.bufpos;
        return indexOf(bArr, i, this.buflen - i);
    }

    public int indexOf(byte[] bArr, int i, int i2) {
        boolean z;
        if (bArr != null) {
            if (i < this.bufpos || i2 < 0 || i + i2 > this.buflen) {
                throw new IndexOutOfBoundsException();
            }
            if (i2 < bArr.length) {
                return -1;
            }
            int[] iArr = new int[256];
            for (int i3 = 0; i3 < iArr.length; i3++) {
                iArr[i3] = bArr.length + 1;
            }
            for (int i4 = 0; i4 < bArr.length; i4++) {
                iArr[bArr[i4] & 255] = bArr.length - i4;
            }
            int i5 = 0;
            while (i5 <= i2 - bArr.length) {
                int i6 = i + i5;
                int i7 = 0;
                while (true) {
                    if (i7 >= bArr.length) {
                        z = true;
                        break;
                    } else if (this.buffer[i6 + i7] != bArr[i7]) {
                        z = false;
                        break;
                    } else {
                        i7++;
                    }
                }
                if (z) {
                    return i6;
                }
                int length = i6 + bArr.length;
                byte[] bArr2 = this.buffer;
                if (length >= bArr2.length) {
                    break;
                }
                i5 += iArr[bArr2[length] & 255];
            }
            return -1;
        }
        throw new IllegalArgumentException("Pattern may not be null");
    }

    public int length() {
        return this.buflen - this.bufpos;
    }

    public int limit() {
        return this.buflen;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        return false;
    }

    public int pos() {
        return this.bufpos;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() {
        if (this.truncated) {
            return -1;
        }
        while (!hasBufferedData()) {
            if (fillBuffer() == -1) {
                return -1;
            }
        }
        byte[] bArr = this.buffer;
        int i = this.bufpos;
        this.bufpos = i + 1;
        return bArr[i] & 255;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr) {
        if (this.truncated) {
            return -1;
        }
        if (bArr != null) {
            return read(bArr, 0, bArr.length);
        }
        return 0;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i, int i2) {
        if (this.truncated) {
            return -1;
        }
        if (bArr == null) {
            return 0;
        }
        while (!hasBufferedData()) {
            if (fillBuffer() == -1) {
                return -1;
            }
        }
        int i3 = this.buflen - this.bufpos;
        if (i3 <= i2) {
            i2 = i3;
        }
        System.arraycopy(this.buffer, this.bufpos, bArr, i, i2);
        this.bufpos += i2;
        return i2;
    }

    @Override // org.apache.james.mime4j.io.LineReaderInputStream
    public int readLine(ByteArrayBuffer byteArrayBuffer) {
        int length;
        if (byteArrayBuffer != null) {
            if (this.truncated) {
                return -1;
            }
            boolean z = false;
            int i = 0;
            int i2 = 0;
            while (!z && (hasBufferedData() || (i2 = fillBuffer()) != -1)) {
                int indexOf = indexOf((byte) 10);
                if (indexOf != -1) {
                    length = (indexOf + 1) - pos();
                    z = true;
                } else {
                    length = length();
                }
                if (length > 0) {
                    byteArrayBuffer.append(buf(), pos(), length);
                    skip(length);
                    i += length;
                }
                if (this.maxLineLen > 0 && byteArrayBuffer.length() >= this.maxLineLen) {
                    throw new MaxLineLimitException("Maximum line length limit exceeded");
                }
            }
            if (i != 0 || i2 != -1) {
                return i;
            }
            return -1;
        }
        throw new IllegalArgumentException("Buffer may not be null");
    }

    public int skip(int i) {
        int min = Math.min(i, this.buflen - this.bufpos);
        this.bufpos += min;
        return min;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[pos: ");
        sb.append(this.bufpos);
        sb.append("]");
        sb.append("[limit: ");
        sb.append(this.buflen);
        sb.append("]");
        sb.append("[");
        for (int i = this.bufpos; i < this.buflen; i++) {
            sb.append((char) this.buffer[i]);
        }
        sb.append("]");
        return sb.toString();
    }

    public void truncate() {
        clear();
        this.truncated = true;
    }
}
