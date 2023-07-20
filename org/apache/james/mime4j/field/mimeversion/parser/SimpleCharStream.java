package org.apache.james.mime4j.field.mimeversion.parser;

import com.google.android.gms.nearby.connection.Connections;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

/* loaded from: classes.dex */
public class SimpleCharStream {
    public static final boolean staticFlag = false;
    int available;
    protected int[] bufcolumn;
    protected char[] buffer;
    protected int[] bufline;
    public int bufpos;
    int bufsize;
    protected int column;
    protected int inBuf;
    protected Reader inputStream;
    protected int line;
    protected int maxNextCharInd;
    protected boolean prevCharIsCR;
    protected boolean prevCharIsLF;
    protected int tabSize;
    int tokenBegin;

    public SimpleCharStream(InputStream inputStream) {
        this(inputStream, 1, 1, (int) Connections.MAX_RELIABLE_MESSAGE_LEN);
    }

    public SimpleCharStream(InputStream inputStream, int i, int i2) {
        this(inputStream, i, i2, (int) Connections.MAX_RELIABLE_MESSAGE_LEN);
    }

    public SimpleCharStream(InputStream inputStream, int i, int i2, int i3) {
        this(new InputStreamReader(inputStream), i, i2, i3);
    }

    public SimpleCharStream(InputStream inputStream, String str) {
        this(inputStream, str, 1, 1, Connections.MAX_RELIABLE_MESSAGE_LEN);
    }

    public SimpleCharStream(InputStream inputStream, String str, int i, int i2) {
        this(inputStream, str, i, i2, Connections.MAX_RELIABLE_MESSAGE_LEN);
    }

    public SimpleCharStream(InputStream inputStream, String str, int i, int i2, int i3) {
        this(str == null ? new InputStreamReader(inputStream) : new InputStreamReader(inputStream, str), i, i2, i3);
    }

    public SimpleCharStream(Reader reader) {
        this(reader, 1, 1, (int) Connections.MAX_RELIABLE_MESSAGE_LEN);
    }

    public SimpleCharStream(Reader reader, int i, int i2) {
        this(reader, i, i2, (int) Connections.MAX_RELIABLE_MESSAGE_LEN);
    }

    public SimpleCharStream(Reader reader, int i, int i2, int i3) {
        this.bufpos = -1;
        this.column = 0;
        this.line = 1;
        this.prevCharIsCR = false;
        this.prevCharIsLF = false;
        this.maxNextCharInd = 0;
        this.inBuf = 0;
        this.tabSize = 8;
        this.inputStream = reader;
        this.line = i;
        this.column = i2 - 1;
        this.bufsize = i3;
        this.available = i3;
        this.buffer = new char[i3];
        this.bufline = new int[i3];
        this.bufcolumn = new int[i3];
    }

    public char BeginToken() {
        this.tokenBegin = -1;
        char readChar = readChar();
        this.tokenBegin = this.bufpos;
        return readChar;
    }

    public void Done() {
        this.buffer = null;
        this.bufline = null;
        this.bufcolumn = null;
    }

    protected void ExpandBuff(boolean z) {
        int i;
        int i2 = this.bufsize;
        char[] cArr = new char[i2 + 2048];
        int[] iArr = new int[i2 + 2048];
        int[] iArr2 = new int[i2 + 2048];
        try {
            if (z) {
                System.arraycopy(this.buffer, this.tokenBegin, cArr, 0, i2 - this.tokenBegin);
                System.arraycopy(this.buffer, 0, cArr, this.bufsize - this.tokenBegin, this.bufpos);
                this.buffer = cArr;
                System.arraycopy(this.bufline, this.tokenBegin, iArr, 0, this.bufsize - this.tokenBegin);
                System.arraycopy(this.bufline, 0, iArr, this.bufsize - this.tokenBegin, this.bufpos);
                this.bufline = iArr;
                System.arraycopy(this.bufcolumn, this.tokenBegin, iArr2, 0, this.bufsize - this.tokenBegin);
                System.arraycopy(this.bufcolumn, 0, iArr2, this.bufsize - this.tokenBegin, this.bufpos);
                this.bufcolumn = iArr2;
                i = this.bufpos + (this.bufsize - this.tokenBegin);
                this.bufpos = i;
            } else {
                System.arraycopy(this.buffer, this.tokenBegin, cArr, 0, i2 - this.tokenBegin);
                this.buffer = cArr;
                System.arraycopy(this.bufline, this.tokenBegin, iArr, 0, this.bufsize - this.tokenBegin);
                this.bufline = iArr;
                System.arraycopy(this.bufcolumn, this.tokenBegin, iArr2, 0, this.bufsize - this.tokenBegin);
                this.bufcolumn = iArr2;
                i = this.bufpos - this.tokenBegin;
                this.bufpos = i;
            }
            this.maxNextCharInd = i;
            this.bufsize += 2048;
            this.available = this.bufsize;
            this.tokenBegin = 0;
        } catch (Throwable th) {
            throw new Error(th.getMessage());
        }
    }

    protected void FillBuff() {
        int i = this.maxNextCharInd;
        int i2 = this.available;
        if (i == i2) {
            int i3 = this.bufsize;
            if (i2 == i3) {
                i3 = this.tokenBegin;
                if (i3 > 2048) {
                    this.maxNextCharInd = 0;
                    this.bufpos = 0;
                    this.available = i3;
                } else if (i3 < 0) {
                    this.maxNextCharInd = 0;
                    this.bufpos = 0;
                } else {
                    ExpandBuff(false);
                }
            } else {
                int i4 = this.tokenBegin;
                if (i2 <= i4) {
                    if (i4 - i2 < 2048) {
                        ExpandBuff(true);
                    } else {
                        this.available = i4;
                    }
                }
                this.available = i3;
            }
        }
        try {
            int read = this.inputStream.read(this.buffer, this.maxNextCharInd, this.available - this.maxNextCharInd);
            if (read != -1) {
                this.maxNextCharInd += read;
            } else {
                this.inputStream.close();
                throw new IOException();
            }
        } catch (IOException e) {
            this.bufpos--;
            backup(0);
            if (this.tokenBegin == -1) {
                this.tokenBegin = this.bufpos;
            }
            throw e;
        }
    }

    public String GetImage() {
        int i = this.bufpos;
        int i2 = this.tokenBegin;
        if (i >= i2) {
            return new String(this.buffer, i2, (i - i2) + 1);
        }
        StringBuilder sb = new StringBuilder();
        char[] cArr = this.buffer;
        int i3 = this.tokenBegin;
        sb.append(new String(cArr, i3, this.bufsize - i3));
        sb.append(new String(this.buffer, 0, this.bufpos + 1));
        return sb.toString();
    }

    public char[] GetSuffix(int i) {
        char[] cArr = new char[i];
        int i2 = this.bufpos;
        if (i2 + 1 >= i) {
            System.arraycopy(this.buffer, (i2 - i) + 1, cArr, 0, i);
        } else {
            System.arraycopy(this.buffer, this.bufsize - ((i - i2) - 1), cArr, 0, (i - i2) - 1);
            char[] cArr2 = this.buffer;
            int i3 = this.bufpos;
            System.arraycopy(cArr2, 0, cArr, (i - i3) - 1, i3 + 1);
        }
        return cArr;
    }

    public void ReInit(InputStream inputStream) {
        ReInit(inputStream, 1, 1, Connections.MAX_RELIABLE_MESSAGE_LEN);
    }

    public void ReInit(InputStream inputStream, int i, int i2) {
        ReInit(inputStream, i, i2, Connections.MAX_RELIABLE_MESSAGE_LEN);
    }

    public void ReInit(InputStream inputStream, int i, int i2, int i3) {
        ReInit(new InputStreamReader(inputStream), i, i2, i3);
    }

    public void ReInit(InputStream inputStream, String str) {
        ReInit(inputStream, str, 1, 1, Connections.MAX_RELIABLE_MESSAGE_LEN);
    }

    public void ReInit(InputStream inputStream, String str, int i, int i2) {
        ReInit(inputStream, str, i, i2, Connections.MAX_RELIABLE_MESSAGE_LEN);
    }

    public void ReInit(InputStream inputStream, String str, int i, int i2, int i3) {
        ReInit(str == null ? new InputStreamReader(inputStream) : new InputStreamReader(inputStream, str), i, i2, i3);
    }

    public void ReInit(Reader reader) {
        ReInit(reader, 1, 1, Connections.MAX_RELIABLE_MESSAGE_LEN);
    }

    public void ReInit(Reader reader, int i, int i2) {
        ReInit(reader, i, i2, Connections.MAX_RELIABLE_MESSAGE_LEN);
    }

    public void ReInit(Reader reader, int i, int i2, int i3) {
        this.inputStream = reader;
        this.line = i;
        this.column = i2 - 1;
        char[] cArr = this.buffer;
        if (cArr == null || i3 != cArr.length) {
            this.bufsize = i3;
            this.available = i3;
            this.buffer = new char[i3];
            this.bufline = new int[i3];
            this.bufcolumn = new int[i3];
        }
        this.prevCharIsCR = false;
        this.prevCharIsLF = false;
        this.maxNextCharInd = 0;
        this.inBuf = 0;
        this.tokenBegin = 0;
        this.bufpos = -1;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x003c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void UpdateLineColumn(char c) {
        this.column++;
        if (!this.prevCharIsLF) {
            if (this.prevCharIsCR) {
                this.prevCharIsCR = false;
                if (c == '\n') {
                    this.prevCharIsLF = true;
                }
            }
            if (c == '\r') {
                switch (c) {
                    case '\t':
                        this.column--;
                        int i = this.column;
                        int i2 = this.tabSize;
                        this.column = i + (i2 - (i % i2));
                        break;
                    case '\n':
                        this.prevCharIsLF = true;
                        break;
                }
            } else {
                this.prevCharIsCR = true;
            }
            int[] iArr = this.bufline;
            int i3 = this.bufpos;
            iArr[i3] = this.line;
            this.bufcolumn[i3] = this.column;
        }
        this.prevCharIsLF = false;
        int i4 = this.line;
        this.column = 1;
        this.line = i4 + 1;
        if (c == '\r') {
        }
        int[] iArr2 = this.bufline;
        int i32 = this.bufpos;
        iArr2[i32] = this.line;
        this.bufcolumn[i32] = this.column;
    }

    public void adjustBeginLineColumn(int i, int i2) {
        int i3;
        int i4 = this.tokenBegin;
        int i5 = this.bufpos;
        if (i5 >= i4) {
            i3 = (i5 - i4) + this.inBuf + 1;
        } else {
            i3 = this.inBuf + (this.bufsize - i4) + i5 + 1;
        }
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        while (true) {
            if (i6 >= i3) {
                break;
            }
            int[] iArr = this.bufline;
            int i9 = this.bufsize;
            int i10 = i4 % i9;
            i4++;
            int i11 = i4 % i9;
            if (iArr[i10] != iArr[i11]) {
                i7 = i10;
                break;
            }
            iArr[i10] = i;
            int[] iArr2 = this.bufcolumn;
            iArr2[i10] = i8 + i2;
            i6++;
            i8 = (iArr2[i11] + i8) - iArr2[i10];
            i7 = i10;
        }
        if (i6 < i3) {
            int i12 = i + 1;
            this.bufline[i7] = i;
            this.bufcolumn[i7] = i2 + i8;
            while (true) {
                int i13 = i6 + 1;
                if (i6 >= i3) {
                    break;
                }
                int[] iArr3 = this.bufline;
                int i14 = this.bufsize;
                i7 = i4 % i14;
                i4++;
                if (iArr3[i7] != iArr3[i4 % i14]) {
                    iArr3[i7] = i12;
                    i12++;
                } else {
                    iArr3[i7] = i12;
                }
                i6 = i13;
            }
        }
        this.line = this.bufline[i7];
        this.column = this.bufcolumn[i7];
    }

    public void backup(int i) {
        this.inBuf += i;
        int i2 = this.bufpos - i;
        this.bufpos = i2;
        if (i2 < 0) {
            this.bufpos += this.bufsize;
        }
    }

    public int getBeginColumn() {
        return this.bufcolumn[this.tokenBegin];
    }

    public int getBeginLine() {
        return this.bufline[this.tokenBegin];
    }

    public int getColumn() {
        return this.bufcolumn[this.bufpos];
    }

    public int getEndColumn() {
        return this.bufcolumn[this.bufpos];
    }

    public int getEndLine() {
        return this.bufline[this.bufpos];
    }

    public int getLine() {
        return this.bufline[this.bufpos];
    }

    protected int getTabSize(int i) {
        return this.tabSize;
    }

    public char readChar() {
        int i = this.inBuf;
        if (i > 0) {
            this.inBuf = i - 1;
            int i2 = this.bufpos + 1;
            this.bufpos = i2;
            if (i2 == this.bufsize) {
                this.bufpos = 0;
            }
            return this.buffer[this.bufpos];
        }
        int i3 = this.bufpos + 1;
        this.bufpos = i3;
        if (i3 >= this.maxNextCharInd) {
            FillBuff();
        }
        char c = this.buffer[this.bufpos];
        UpdateLineColumn(c);
        return c;
    }

    protected void setTabSize(int i) {
        this.tabSize = i;
    }
}
