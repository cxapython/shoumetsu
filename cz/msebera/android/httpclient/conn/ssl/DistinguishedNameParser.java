package cz.msebera.android.httpclient.conn.ssl;

import cz.msebera.android.httpclient.message.TokenParser;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.security.auth.x500.X500Principal;

/* loaded from: classes.dex */
public final class DistinguishedNameParser {
    private int beg;
    private char[] chars;
    private int cur;
    private final String dn;
    private int end;
    private final int length;
    private int pos;

    public DistinguishedNameParser(X500Principal x500Principal) {
        this.dn = x500Principal.getName("RFC2253");
        this.length = this.dn.length();
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x00a2, code lost:
        return new java.lang.String(r1, r2, r6.cur - r2);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String escapedAV() {
        int i = this.pos;
        this.beg = i;
        this.end = i;
        while (true) {
            int i2 = this.pos;
            if (i2 >= this.length) {
                char[] cArr = this.chars;
                int i3 = this.beg;
                return new String(cArr, i3, this.end - i3);
            }
            char[] cArr2 = this.chars;
            char c = cArr2[i2];
            if (c == ' ') {
                int i4 = this.end;
                this.cur = i4;
                this.pos = i2 + 1;
                this.end = i4 + 1;
                cArr2[i4] = TokenParser.SP;
                while (true) {
                    int i5 = this.pos;
                    if (i5 < this.length) {
                        char[] cArr3 = this.chars;
                        if (cArr3[i5] == ' ') {
                            int i6 = this.end;
                            this.end = i6 + 1;
                            cArr3[i6] = TokenParser.SP;
                            this.pos = i5 + 1;
                        }
                    }
                }
                int i7 = this.pos;
                if (i7 != this.length) {
                    char[] cArr4 = this.chars;
                    if (cArr4[i7] != ',' && cArr4[i7] != '+' && cArr4[i7] != ';') {
                    }
                }
            } else if (c != ';') {
                if (c != '\\') {
                    switch (c) {
                        case '+':
                        case ',':
                            break;
                        default:
                            int i8 = this.end;
                            this.end = i8 + 1;
                            cArr2[i8] = cArr2[i2];
                            break;
                    }
                } else {
                    int i9 = this.end;
                    this.end = i9 + 1;
                    cArr2[i9] = getEscaped();
                    i2 = this.pos;
                }
                this.pos = i2 + 1;
            }
        }
        char[] cArr5 = this.chars;
        int i10 = this.beg;
        return new String(cArr5, i10, this.end - i10);
    }

    private int getByte(int i) {
        int i2;
        int i3;
        int i4 = i + 1;
        if (i4 >= this.length) {
            throw new IllegalStateException("Malformed DN: " + this.dn);
        }
        char c = this.chars[i];
        if (c >= '0' && c <= '9') {
            i2 = c - '0';
        } else if (c >= 'a' && c <= 'f') {
            i2 = c - 'W';
        } else if (c < 'A' || c > 'F') {
            throw new IllegalStateException("Malformed DN: " + this.dn);
        } else {
            i2 = c - '7';
        }
        char c2 = this.chars[i4];
        if (c2 >= '0' && c2 <= '9') {
            i3 = c2 - '0';
        } else if (c2 >= 'a' && c2 <= 'f') {
            i3 = c2 - 'W';
        } else if (c2 < 'A' || c2 > 'F') {
            throw new IllegalStateException("Malformed DN: " + this.dn);
        } else {
            i3 = c2 - '7';
        }
        return (i2 << 4) + i3;
    }

    private char getEscaped() {
        this.pos++;
        int i = this.pos;
        if (i == this.length) {
            throw new IllegalStateException("Unexpected end of DN: " + this.dn);
        }
        char c = this.chars[i];
        if (c != ' ' && c != '%' && c != '\\' && c != '_') {
            switch (c) {
                case '\"':
                case '#':
                    break;
                default:
                    switch (c) {
                        case '*':
                        case '+':
                        case ',':
                            break;
                        default:
                            switch (c) {
                                case ';':
                                case '<':
                                case '=':
                                case '>':
                                    break;
                                default:
                                    return getUTF8();
                            }
                    }
            }
        }
        return this.chars[this.pos];
    }

    private char getUTF8() {
        int i;
        int i2;
        int i3 = getByte(this.pos);
        this.pos++;
        if (i3 < 128) {
            return (char) i3;
        }
        if (i3 < 192 || i3 > 247) {
            return '?';
        }
        if (i3 <= 223) {
            i2 = i3 & 31;
            i = 1;
        } else if (i3 <= 239) {
            i = 2;
            i2 = i3 & 15;
        } else {
            i = 3;
            i2 = i3 & 7;
        }
        for (int i4 = 0; i4 < i; i4++) {
            this.pos++;
            int i5 = this.pos;
            if (i5 == this.length || this.chars[i5] != '\\') {
                return '?';
            }
            this.pos = i5 + 1;
            int i6 = getByte(this.pos);
            this.pos++;
            if ((i6 & 192) != 128) {
                return '?';
            }
            i2 = (i2 << 6) + (i6 & 63);
        }
        return (char) i2;
    }

    private String hexAV() {
        int i = this.pos;
        if (i + 4 >= this.length) {
            throw new IllegalStateException("Unexpected end of DN: " + this.dn);
        }
        this.beg = i;
        while (true) {
            this.pos = i + 1;
            int i2 = this.pos;
            if (i2 == this.length) {
                break;
            }
            char[] cArr = this.chars;
            if (cArr[i2] == '+' || cArr[i2] == ',' || cArr[i2] == ';') {
                break;
            } else if (cArr[i2] == ' ') {
                this.end = i2;
                do {
                    this.pos = i2 + 1;
                    i2 = this.pos;
                    if (i2 >= this.length) {
                        break;
                    }
                } while (this.chars[i2] == ' ');
            } else {
                if (cArr[i2] >= 'A' && cArr[i2] <= 'F') {
                    cArr[i2] = (char) (cArr[i2] + TokenParser.SP);
                }
                i = this.pos;
            }
        }
        this.end = this.pos;
        int i3 = this.end;
        int i4 = this.beg;
        int i5 = i3 - i4;
        if (i5 < 5 || (i5 & 1) == 0) {
            throw new IllegalStateException("Unexpected end of DN: " + this.dn);
        }
        byte[] bArr = new byte[i5 / 2];
        int i6 = i4 + 1;
        for (int i7 = 0; i7 < bArr.length; i7++) {
            bArr[i7] = (byte) getByte(i6);
            i6 += 2;
        }
        return new String(this.chars, this.beg, i5);
    }

    private String nextAT() {
        char[] cArr;
        while (true) {
            int i = this.pos;
            if (i >= this.length || this.chars[i] != ' ') {
                break;
            }
            this.pos = i + 1;
        }
        int i2 = this.pos;
        if (i2 == this.length) {
            return null;
        }
        this.beg = i2;
        do {
            this.pos = i2 + 1;
            i2 = this.pos;
            if (i2 >= this.length) {
                break;
            }
            cArr = this.chars;
            if (cArr[i2] == '=') {
                break;
            }
        } while (cArr[i2] != ' ');
        int i3 = this.pos;
        if (i3 >= this.length) {
            throw new IllegalStateException("Unexpected end of DN: " + this.dn);
        }
        this.end = i3;
        if (this.chars[i3] == ' ') {
            while (true) {
                int i4 = this.pos;
                if (i4 >= this.length) {
                    break;
                }
                char[] cArr2 = this.chars;
                if (cArr2[i4] == '=' || cArr2[i4] != ' ') {
                    break;
                }
                this.pos = i4 + 1;
            }
            char[] cArr3 = this.chars;
            int i5 = this.pos;
            if (cArr3[i5] != '=' || i5 == this.length) {
                throw new IllegalStateException("Unexpected end of DN: " + this.dn);
            }
        }
        int i6 = this.pos;
        do {
            this.pos = i6 + 1;
            i6 = this.pos;
            if (i6 >= this.length) {
                break;
            }
        } while (this.chars[i6] == ' ');
        int i7 = this.end;
        int i8 = this.beg;
        if (i7 - i8 > 4) {
            char[] cArr4 = this.chars;
            if (cArr4[i8 + 3] == '.' && (cArr4[i8] == 'O' || cArr4[i8] == 'o')) {
                char[] cArr5 = this.chars;
                int i9 = this.beg;
                if (cArr5[i9 + 1] == 'I' || cArr5[i9 + 1] == 'i') {
                    char[] cArr6 = this.chars;
                    int i10 = this.beg;
                    if (cArr6[i10 + 2] == 'D' || cArr6[i10 + 2] == 'd') {
                        this.beg += 4;
                    }
                }
            }
        }
        char[] cArr7 = this.chars;
        int i11 = this.beg;
        return new String(cArr7, i11, this.end - i11);
    }

    private String quotedAV() {
        this.pos++;
        this.beg = this.pos;
        int i = this.beg;
        while (true) {
            this.end = i;
            int i2 = this.pos;
            if (i2 == this.length) {
                throw new IllegalStateException("Unexpected end of DN: " + this.dn);
            }
            char[] cArr = this.chars;
            if (cArr[i2] == '\"') {
                do {
                    this.pos = i2 + 1;
                    i2 = this.pos;
                    if (i2 >= this.length) {
                        break;
                    }
                } while (this.chars[i2] == ' ');
                char[] cArr2 = this.chars;
                int i3 = this.beg;
                return new String(cArr2, i3, this.end - i3);
            }
            if (cArr[i2] == '\\') {
                cArr[this.end] = getEscaped();
            } else {
                cArr[this.end] = cArr[i2];
            }
            this.pos++;
            i = this.end + 1;
        }
    }

    public String findMostSpecific(String str) {
        this.pos = 0;
        this.beg = 0;
        this.end = 0;
        this.cur = 0;
        this.chars = this.dn.toCharArray();
        String nextAT = nextAT();
        if (nextAT == null) {
            return null;
        }
        do {
            String str2 = "";
            int i = this.pos;
            if (i == this.length) {
                return null;
            }
            switch (this.chars[i]) {
                case '\"':
                    str2 = quotedAV();
                    break;
                case '#':
                    str2 = hexAV();
                    break;
                case '+':
                case ',':
                case ';':
                    break;
                default:
                    str2 = escapedAV();
                    break;
            }
            if (str.equalsIgnoreCase(nextAT)) {
                return str2;
            }
            int i2 = this.pos;
            if (i2 >= this.length) {
                return null;
            }
            char[] cArr = this.chars;
            if (cArr[i2] != ',' && cArr[i2] != ';' && cArr[i2] != '+') {
                throw new IllegalStateException("Malformed DN: " + this.dn);
            }
            this.pos++;
            nextAT = nextAT();
        } while (nextAT != null);
        throw new IllegalStateException("Malformed DN: " + this.dn);
    }

    public List<String> getAllMostSpecificFirst(String str) {
        this.pos = 0;
        this.beg = 0;
        this.end = 0;
        this.cur = 0;
        this.chars = this.dn.toCharArray();
        List<String> emptyList = Collections.emptyList();
        String nextAT = nextAT();
        if (nextAT == null) {
            return emptyList;
        }
        do {
            int i = this.pos;
            if (i < this.length) {
                String str2 = "";
                switch (this.chars[i]) {
                    case '\"':
                        str2 = quotedAV();
                        break;
                    case '#':
                        str2 = hexAV();
                        break;
                    case '+':
                    case ',':
                    case ';':
                        break;
                    default:
                        str2 = escapedAV();
                        break;
                }
                if (str.equalsIgnoreCase(nextAT)) {
                    if (emptyList.isEmpty()) {
                        emptyList = new ArrayList<>();
                    }
                    emptyList.add(str2);
                }
                int i2 = this.pos;
                if (i2 < this.length) {
                    char[] cArr = this.chars;
                    if (cArr[i2] != ',' && cArr[i2] != ';' && cArr[i2] != '+') {
                        throw new IllegalStateException("Malformed DN: " + this.dn);
                    }
                    this.pos++;
                    nextAT = nextAT();
                }
            }
            return emptyList;
        } while (nextAT != null);
        throw new IllegalStateException("Malformed DN: " + this.dn);
    }
}
