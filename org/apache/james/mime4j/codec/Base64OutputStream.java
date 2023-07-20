package org.apache.james.mime4j.codec;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes.dex */
public class Base64OutputStream extends FilterOutputStream {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final byte BASE64_PAD = 61;
    private static final int DEFAULT_LINE_LENGTH = 76;
    private static final int ENCODED_BUFFER_SIZE = 2048;
    private static final int MASK_6BITS = 63;
    private boolean closed;
    private int data;
    private final byte[] encoded;
    private final int lineLength;
    private int linePosition;
    private final byte[] lineSeparator;
    private int modulus;
    private int position;
    private final byte[] singleByte;
    private static final byte[] CRLF_SEPARATOR = {13, 10};
    static final byte[] BASE64_TABLE = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};
    private static final Set<Byte> BASE64_CHARS = new HashSet();

    static {
        for (byte b : BASE64_TABLE) {
            BASE64_CHARS.add(Byte.valueOf(b));
        }
        BASE64_CHARS.add(Byte.valueOf((byte) BASE64_PAD));
    }

    public Base64OutputStream(OutputStream outputStream) {
        this(outputStream, 76, CRLF_SEPARATOR);
    }

    public Base64OutputStream(OutputStream outputStream, int i) {
        this(outputStream, i, CRLF_SEPARATOR);
    }

    public Base64OutputStream(OutputStream outputStream, int i, byte[] bArr) {
        super(outputStream);
        this.singleByte = new byte[1];
        this.closed = false;
        this.position = 0;
        this.data = 0;
        this.modulus = 0;
        this.linePosition = 0;
        if (outputStream != null) {
            if (i < 0) {
                throw new IllegalArgumentException();
            }
            checkLineSeparator(bArr);
            this.lineLength = i;
            this.lineSeparator = new byte[bArr.length];
            System.arraycopy(bArr, 0, this.lineSeparator, 0, bArr.length);
            this.encoded = new byte[ENCODED_BUFFER_SIZE];
            return;
        }
        throw new IllegalArgumentException();
    }

    private void checkLineSeparator(byte[] bArr) {
        if (bArr.length <= ENCODED_BUFFER_SIZE) {
            for (byte b : bArr) {
                if (BASE64_CHARS.contains(Byte.valueOf(b))) {
                    throw new IllegalArgumentException("line separator must not contain base64 character '" + ((char) (b & 255)) + "'");
                }
            }
            return;
        }
        throw new IllegalArgumentException("line separator length exceeds 2048");
    }

    private void close0() {
        if (this.modulus != 0) {
            writePad();
        }
        if (this.lineLength > 0 && this.linePosition > 0) {
            writeLineSeparator();
        }
        flush0();
    }

    private void flush0() {
        if (this.position > 0) {
            this.out.write(this.encoded, 0, this.position);
            this.position = 0;
        }
    }

    private void write0(byte[] bArr, int i, int i2) {
        byte[] bArr2;
        while (i < i2) {
            this.data = (this.data << 8) | (bArr[i] & 255);
            int i3 = this.modulus + 1;
            this.modulus = i3;
            if (i3 == 3) {
                this.modulus = 0;
                int i4 = this.lineLength;
                if (i4 > 0 && this.linePosition >= i4) {
                    this.linePosition = 0;
                    if (this.encoded.length - this.position < this.lineSeparator.length) {
                        flush0();
                    }
                    for (byte b : this.lineSeparator) {
                        byte[] bArr3 = this.encoded;
                        int i5 = this.position;
                        this.position = i5 + 1;
                        bArr3[i5] = b;
                    }
                }
                if (this.encoded.length - this.position < 4) {
                    flush0();
                }
                byte[] bArr4 = this.encoded;
                int i6 = this.position;
                this.position = i6 + 1;
                byte[] bArr5 = BASE64_TABLE;
                int i7 = this.data;
                bArr4[i6] = bArr5[(i7 >> 18) & 63];
                int i8 = this.position;
                this.position = i8 + 1;
                bArr4[i8] = bArr5[(i7 >> 12) & 63];
                int i9 = this.position;
                this.position = i9 + 1;
                bArr4[i9] = bArr5[(i7 >> 6) & 63];
                int i10 = this.position;
                this.position = i10 + 1;
                bArr4[i10] = bArr5[i7 & 63];
                this.linePosition += 4;
            }
            i++;
        }
    }

    private void writeLineSeparator() {
        byte[] bArr;
        this.linePosition = 0;
        if (this.encoded.length - this.position < this.lineSeparator.length) {
            flush0();
        }
        for (byte b : this.lineSeparator) {
            byte[] bArr2 = this.encoded;
            int i = this.position;
            this.position = i + 1;
            bArr2[i] = b;
        }
    }

    private void writePad() {
        int i = this.lineLength;
        if (i > 0 && this.linePosition >= i) {
            writeLineSeparator();
        }
        if (this.encoded.length - this.position < 4) {
            flush0();
        }
        if (this.modulus == 1) {
            byte[] bArr = this.encoded;
            int i2 = this.position;
            this.position = i2 + 1;
            byte[] bArr2 = BASE64_TABLE;
            int i3 = this.data;
            bArr[i2] = bArr2[(i3 >> 2) & 63];
            int i4 = this.position;
            this.position = i4 + 1;
            bArr[i4] = bArr2[(i3 << 4) & 63];
            int i5 = this.position;
            this.position = i5 + 1;
            bArr[i5] = BASE64_PAD;
            int i6 = this.position;
            this.position = i6 + 1;
            bArr[i6] = BASE64_PAD;
        } else {
            byte[] bArr3 = this.encoded;
            int i7 = this.position;
            this.position = i7 + 1;
            byte[] bArr4 = BASE64_TABLE;
            int i8 = this.data;
            bArr3[i7] = bArr4[(i8 >> 10) & 63];
            int i9 = this.position;
            this.position = i9 + 1;
            bArr3[i9] = bArr4[(i8 >> 4) & 63];
            int i10 = this.position;
            this.position = i10 + 1;
            bArr3[i10] = bArr4[(i8 << 2) & 63];
            int i11 = this.position;
            this.position = i11 + 1;
            bArr3[i11] = BASE64_PAD;
        }
        this.linePosition += 4;
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.closed) {
            return;
        }
        this.closed = true;
        close0();
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
    public void flush() {
        if (!this.closed) {
            flush0();
            return;
        }
        throw new IOException("Base64OutputStream has been closed");
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public final void write(int i) {
        if (!this.closed) {
            byte[] bArr = this.singleByte;
            bArr[0] = (byte) i;
            write0(bArr, 0, 1);
            return;
        }
        throw new IOException("Base64OutputStream has been closed");
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
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
        throw new IOException("Base64OutputStream has been closed");
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public final void write(byte[] bArr, int i, int i2) {
        int i3;
        if (!this.closed) {
            if (bArr == null) {
                throw new NullPointerException();
            }
            if (i < 0 || i2 < 0 || (i3 = i + i2) > bArr.length) {
                throw new IndexOutOfBoundsException();
            }
            if (i2 == 0) {
                return;
            }
            write0(bArr, i, i3);
            return;
        }
        throw new IOException("Base64OutputStream has been closed");
    }
}
