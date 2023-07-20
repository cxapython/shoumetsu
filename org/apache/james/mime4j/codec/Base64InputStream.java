package org.apache.james.mime4j.codec;

import java.io.IOException;
import java.io.InputStream;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/* loaded from: classes.dex */
public class Base64InputStream extends InputStream {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final byte BASE64_PAD = 61;
    private static final int ENCODED_BUFFER_SIZE = 1536;
    private static final int EOF = -1;
    private boolean closed;
    private final byte[] encoded;
    private boolean eof;
    private final InputStream in;
    private int position;
    private final ByteQueue q;
    private final byte[] singleByte;
    private int size;
    private boolean strict;
    private static Log log = LogFactory.getLog(Base64InputStream.class);
    private static final int[] BASE64_DECODE = new int[256];

    static {
        for (int i = 0; i < 256; i++) {
            BASE64_DECODE[i] = -1;
        }
        for (int i2 = 0; i2 < Base64OutputStream.BASE64_TABLE.length; i2++) {
            BASE64_DECODE[Base64OutputStream.BASE64_TABLE[i2] & 255] = i2;
        }
    }

    public Base64InputStream(InputStream inputStream) {
        this(inputStream, false);
    }

    public Base64InputStream(InputStream inputStream, boolean z) {
        this.singleByte = new byte[1];
        this.closed = false;
        this.encoded = new byte[ENCODED_BUFFER_SIZE];
        this.position = 0;
        this.size = 0;
        this.q = new ByteQueue();
        if (inputStream != null) {
            this.in = inputStream;
            this.strict = z;
            return;
        }
        throw new IllegalArgumentException();
    }

    private int decodePad(int i, int i2, byte[] bArr, int i3, int i4) {
        byte b;
        this.eof = true;
        if (i2 == 2) {
            b = (byte) (i >>> 4);
            if (i3 < i4) {
                int i5 = i3 + 1;
                bArr[i3] = b;
                return i5;
            }
        } else if (i2 != 3) {
            handleUnexpecedPad(i2);
            return i3;
        } else {
            byte b2 = (byte) (i >>> 10);
            b = (byte) ((i >>> 2) & 255);
            if (i3 < i4 - 1) {
                int i6 = i3 + 1;
                bArr[i3] = b2;
                int i7 = i6 + 1;
                bArr[i6] = b;
                return i7;
            } else if (i3 < i4) {
                int i8 = i3 + 1;
                bArr[i3] = b2;
                this.q.enqueue(b);
                return i8;
            } else {
                this.q.enqueue(b2);
            }
        }
        this.q.enqueue(b);
        return i3;
    }

    private void handleUnexpecedPad(int i) {
        if (!this.strict) {
            Log log2 = log;
            log2.warn("unexpected padding character; dropping " + i + " sextet(s)");
            return;
        }
        throw new IOException("unexpected padding character");
    }

    private void handleUnexpectedEof(int i) {
        if (!this.strict) {
            Log log2 = log;
            log2.warn("unexpected end of file; dropping " + i + " sextet(s)");
            return;
        }
        throw new IOException("unexpected end of file");
    }

    private int read0(byte[] bArr, int i, int i2) {
        int count = this.q.count();
        int i3 = i;
        while (true) {
            int i4 = count - 1;
            if (count <= 0 || i3 >= i2) {
                break;
            }
            bArr[i3] = this.q.dequeue();
            i3++;
            count = i4;
        }
        if (this.eof) {
            if (i3 != i) {
                return i3 - i;
            }
            return -1;
        }
        int i5 = 0;
        int i6 = 0;
        while (i3 < i2) {
            while (this.position == this.size) {
                InputStream inputStream = this.in;
                byte[] bArr2 = this.encoded;
                int read = inputStream.read(bArr2, 0, bArr2.length);
                if (read == -1) {
                    this.eof = true;
                    if (i5 != 0) {
                        handleUnexpectedEof(i5);
                    }
                    if (i3 != i) {
                        return i3 - i;
                    }
                    return -1;
                } else if (read > 0) {
                    this.position = 0;
                    this.size = read;
                }
            }
            int i7 = i3;
            int i8 = i5;
            while (true) {
                int i9 = this.position;
                if (i9 < this.size && i7 < i2) {
                    byte[] bArr3 = this.encoded;
                    this.position = i9 + 1;
                    int i10 = bArr3[i9] & 255;
                    if (i10 == 61) {
                        return decodePad(i6, i8, bArr, i7, i2) - i;
                    }
                    int i11 = BASE64_DECODE[i10];
                    if (i11 >= 0) {
                        i6 = (i6 << 6) | i11;
                        int i12 = i8 + 1;
                        if (i12 == 4) {
                            byte b = (byte) (i6 >>> 16);
                            byte b2 = (byte) (i6 >>> 8);
                            byte b3 = (byte) i6;
                            if (i7 >= i2 - 2) {
                                if (i7 < i2 - 1) {
                                    bArr[i7] = b;
                                    bArr[i7 + 1] = b2;
                                } else {
                                    if (i7 < i2) {
                                        bArr[i7] = b;
                                    } else {
                                        this.q.enqueue(b);
                                    }
                                    this.q.enqueue(b2);
                                }
                                this.q.enqueue(b3);
                                return i2 - i;
                            }
                            int i13 = i7 + 1;
                            bArr[i7] = b;
                            int i14 = i13 + 1;
                            bArr[i13] = b2;
                            i7 = i14 + 1;
                            bArr[i14] = b3;
                            i8 = 0;
                        } else {
                            i8 = i12;
                        }
                    }
                }
            }
            i5 = i8;
            i3 = i7;
        }
        return i2 - i;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.closed) {
            return;
        }
        this.closed = true;
    }

    @Override // java.io.InputStream
    public int read() {
        int read0;
        if (!this.closed) {
            do {
                read0 = read0(this.singleByte, 0, 1);
                if (read0 == -1) {
                    return -1;
                }
            } while (read0 != 1);
            return this.singleByte[0] & 255;
        }
        throw new IOException("Base64InputStream has been closed");
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) {
        if (!this.closed) {
            if (bArr == null) {
                throw new NullPointerException();
            }
            if (bArr.length != 0) {
                return read0(bArr, 0, bArr.length);
            }
            return 0;
        }
        throw new IOException("Base64InputStream has been closed");
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) {
        int i3;
        if (!this.closed) {
            if (bArr == null) {
                throw new NullPointerException();
            }
            if (i < 0 || i2 < 0 || (i3 = i + i2) > bArr.length) {
                throw new IndexOutOfBoundsException();
            }
            if (i2 != 0) {
                return read0(bArr, i, i3);
            }
            return 0;
        }
        throw new IOException("Base64InputStream has been closed");
    }
}
