package org.apache.james.mime4j.codec;

import java.io.InputStream;
import java.io.OutputStream;

/* loaded from: classes.dex */
final class QuotedPrintableEncoder {
    private static final byte CR = 13;
    private static final byte EQUALS = 61;
    private static final byte[] HEX_DIGITS = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70};
    private static final byte LF = 10;
    private static final byte QUOTED_PRINTABLE_LAST_PLAIN = 126;
    private static final int QUOTED_PRINTABLE_MAX_LINE_LENGTH = 76;
    private static final int QUOTED_PRINTABLE_OCTETS_PER_ESCAPE = 3;
    private static final byte SPACE = 32;
    private static final byte TAB = 9;
    private final boolean binary;
    private final byte[] inBuffer;
    private final byte[] outBuffer;
    private int outputIndex = 0;
    private int nextSoftBreak = 77;
    private OutputStream out = null;
    private boolean pendingSpace = false;
    private boolean pendingTab = false;
    private boolean pendingCR = false;

    public QuotedPrintableEncoder(int i, boolean z) {
        this.inBuffer = new byte[i];
        this.outBuffer = new byte[i * 3];
        this.binary = z;
    }

    private void clearPending() {
        this.pendingSpace = false;
        this.pendingTab = false;
        this.pendingCR = false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:42:0x0062, code lost:
        if (r5 == 61) goto L6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void encode(byte b) {
        if (b == 10) {
            if (this.binary) {
                writePending();
                escape(b);
            } else if (!this.pendingCR) {
                writePending();
                plain(b);
                return;
            } else {
                if (this.pendingSpace) {
                    escape(SPACE);
                } else if (this.pendingTab) {
                    escape(TAB);
                }
                lineBreak();
                clearPending();
                return;
            }
        }
        if (b != 13) {
            writePending();
            if (b == 32) {
                if (!this.binary) {
                    this.pendingSpace = true;
                    return;
                }
            } else if (b == 9) {
                if (!this.binary) {
                    this.pendingTab = true;
                    return;
                }
            } else if (b >= 32) {
                if (b <= 126) {
                }
            }
        } else if (!this.binary) {
            this.pendingCR = true;
            return;
        }
        escape(b);
    }

    private void escape(byte b) {
        int i = this.nextSoftBreak - 1;
        this.nextSoftBreak = i;
        if (i <= 3) {
            softBreak();
        }
        int i2 = b & 255;
        write(EQUALS);
        this.nextSoftBreak--;
        write(HEX_DIGITS[i2 >> 4]);
        this.nextSoftBreak--;
        write(HEX_DIGITS[i2 % 16]);
    }

    private void lineBreak() {
        write(CR);
        write(LF);
        this.nextSoftBreak = 76;
    }

    private void plain(byte b) {
        int i = this.nextSoftBreak - 1;
        this.nextSoftBreak = i;
        if (i <= 1) {
            softBreak();
        }
        write(b);
    }

    private void softBreak() {
        write(EQUALS);
        lineBreak();
    }

    private void write(byte b) {
        byte[] bArr = this.outBuffer;
        int i = this.outputIndex;
        this.outputIndex = i + 1;
        bArr[i] = b;
        if (this.outputIndex >= bArr.length) {
            flushOutput();
        }
    }

    private void writePending() {
        byte b;
        if (this.pendingSpace) {
            b = SPACE;
        } else if (!this.pendingTab) {
            if (this.pendingCR) {
                b = CR;
            }
            clearPending();
        } else {
            b = TAB;
        }
        plain(b);
        clearPending();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void completeEncoding() {
        writePending();
        flushOutput();
    }

    public void encode(InputStream inputStream, OutputStream outputStream) {
        initEncoding(outputStream);
        while (true) {
            int read = inputStream.read(this.inBuffer);
            if (read <= -1) {
                completeEncoding();
                return;
            }
            encodeChunk(this.inBuffer, 0, read);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void encodeChunk(byte[] bArr, int i, int i2) {
        for (int i3 = i; i3 < i2 + i; i3++) {
            encode(bArr[i3]);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void flushOutput() {
        int i = this.outputIndex;
        byte[] bArr = this.outBuffer;
        if (i < bArr.length) {
            this.out.write(bArr, 0, i);
        } else {
            this.out.write(bArr);
        }
        this.outputIndex = 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void initEncoding(OutputStream outputStream) {
        this.out = outputStream;
        this.pendingSpace = false;
        this.pendingTab = false;
        this.pendingCR = false;
        this.nextSoftBreak = 77;
    }
}
