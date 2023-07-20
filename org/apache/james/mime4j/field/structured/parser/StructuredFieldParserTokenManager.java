package org.apache.james.mime4j.field.structured.parser;

import java.io.IOException;
import java.io.PrintStream;

/* loaded from: classes.dex */
public class StructuredFieldParserTokenManager implements StructuredFieldParserConstants {
    int commentNest;
    protected char curChar;
    int curLexState;
    public PrintStream debugStream;
    int defaultLexState;
    StringBuffer image;
    protected SimpleCharStream input_stream;
    int jjimageLen;
    int jjmatchedKind;
    int jjmatchedPos;
    int jjnewStateCnt;
    int jjround;
    private final int[] jjrounds;
    private final int[] jjstateSet;
    int lengthOfMatch;
    static final long[] jjbitVec0 = {0, 0, -1, -1};
    static final int[] jjnextStates = new int[0];
    public static final String[] jjstrLiteralImages = {"", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null};
    public static final String[] lexStateNames = {"DEFAULT", "INCOMMENT", "NESTED_COMMENT", "INQUOTEDSTRING"};
    public static final int[] jjnewLexState = {-1, 1, 0, 2, -1, -1, -1, -1, -1, 3, -1, -1, -1, 0, -1, -1, -1, -1};
    static final long[] jjtoToken = {63489};
    static final long[] jjtoSkip = {1022};
    static final long[] jjtoMore = {1024};

    public StructuredFieldParserTokenManager(SimpleCharStream simpleCharStream) {
        this.debugStream = System.out;
        this.jjrounds = new int[6];
        this.jjstateSet = new int[12];
        this.curLexState = 0;
        this.defaultLexState = 0;
        this.input_stream = simpleCharStream;
    }

    public StructuredFieldParserTokenManager(SimpleCharStream simpleCharStream, int i) {
        this(simpleCharStream);
        SwitchTo(i);
    }

    private final void ReInitRounds() {
        this.jjround = -2147483647;
        int i = 6;
        while (true) {
            int i2 = i - 1;
            if (i > 0) {
                this.jjrounds[i2] = Integer.MIN_VALUE;
                i = i2;
            } else {
                return;
            }
        }
    }

    private final void jjAddStates(int i, int i2) {
        while (true) {
            int[] iArr = this.jjstateSet;
            int i3 = this.jjnewStateCnt;
            this.jjnewStateCnt = i3 + 1;
            iArr[i3] = jjnextStates[i];
            int i4 = i + 1;
            if (i == i2) {
                return;
            }
            i = i4;
        }
    }

    private final void jjCheckNAdd(int i) {
        int[] iArr = this.jjrounds;
        int i2 = iArr[i];
        int i3 = this.jjround;
        if (i2 != i3) {
            int[] iArr2 = this.jjstateSet;
            int i4 = this.jjnewStateCnt;
            this.jjnewStateCnt = i4 + 1;
            iArr2[i4] = i;
            iArr[i] = i3;
        }
    }

    private final void jjCheckNAddStates(int i) {
        jjCheckNAdd(jjnextStates[i]);
        jjCheckNAdd(jjnextStates[i + 1]);
    }

    private final void jjCheckNAddStates(int i, int i2) {
        while (true) {
            jjCheckNAdd(jjnextStates[i]);
            int i3 = i + 1;
            if (i == i2) {
                return;
            }
            i = i3;
        }
    }

    private final void jjCheckNAddTwoStates(int i, int i2) {
        jjCheckNAdd(i);
        jjCheckNAdd(i2);
    }

    private final int jjMoveNfa_0(int i, int i2) {
        this.jjnewStateCnt = 2;
        this.jjstateSet[0] = i;
        int i3 = i2;
        int i4 = 1;
        int i5 = Integer.MAX_VALUE;
        int i6 = 0;
        while (true) {
            int i7 = this.jjround + 1;
            this.jjround = i7;
            if (i7 == Integer.MAX_VALUE) {
                ReInitRounds();
            }
            char c = this.curChar;
            if (c < '@') {
                long j = 1 << c;
                do {
                    i4--;
                    switch (this.jjstateSet[i4]) {
                        case 0:
                            if ((j & 4294977024L) == 0) {
                                continue;
                            } else {
                                jjCheckNAdd(0);
                                i5 = 14;
                                continue;
                            }
                        case 1:
                            if ((j & (-1120986473985L)) == 0) {
                                continue;
                            } else {
                                jjCheckNAdd(1);
                                i5 = 15;
                                continue;
                            }
                        case 2:
                            if ((j & (-1120986473985L)) != 0) {
                                if (i5 > 15) {
                                    i5 = 15;
                                }
                                jjCheckNAdd(1);
                                continue;
                            } else if ((j & 4294977024L) == 0) {
                                continue;
                            } else {
                                if (i5 > 14) {
                                    i5 = 14;
                                }
                                jjCheckNAdd(0);
                                continue;
                            }
                    }
                } while (i4 != i6);
            } else if (c < 128) {
                do {
                    i4--;
                    switch (this.jjstateSet[i4]) {
                        case 1:
                        case 2:
                            jjCheckNAdd(1);
                            i5 = 15;
                            continue;
                    }
                } while (i4 != i6);
            } else {
                int i8 = (c & 255) >> 6;
                long j2 = 1 << (c & '?');
                do {
                    i4--;
                    switch (this.jjstateSet[i4]) {
                        case 1:
                        case 2:
                            if ((jjbitVec0[i8] & j2) != 0) {
                                if (i5 > 15) {
                                    i5 = 15;
                                }
                                jjCheckNAdd(1);
                                continue;
                            } else {
                                continue;
                            }
                    }
                } while (i4 != i6);
            }
            if (i5 != Integer.MAX_VALUE) {
                this.jjmatchedKind = i5;
                this.jjmatchedPos = i3;
                i5 = Integer.MAX_VALUE;
            }
            i3++;
            i4 = this.jjnewStateCnt;
            this.jjnewStateCnt = i6;
            i6 = 2 - i6;
            if (i4 == i6) {
                return i3;
            }
            try {
                this.curChar = this.input_stream.readChar();
            } catch (IOException unused) {
                return i3;
            }
        }
    }

    private final int jjMoveNfa_1(int i, int i2) {
        this.jjnewStateCnt = 1;
        int i3 = 0;
        this.jjstateSet[0] = i;
        int i4 = i2;
        int i5 = 1;
        int i6 = Integer.MAX_VALUE;
        while (true) {
            int i7 = this.jjround + 1;
            this.jjround = i7;
            if (i7 == Integer.MAX_VALUE) {
                ReInitRounds();
            }
            char c = this.curChar;
            if (c < '@') {
                long j = 1 << c;
                do {
                    i5--;
                    if (this.jjstateSet[i5] == 0 && ((-3298534883329L) & j) != 0) {
                        i6 = 4;
                        continue;
                    }
                } while (i5 != i3);
            } else if (c < 128) {
                do {
                    i5--;
                    if (this.jjstateSet[i5] == 0) {
                        i6 = 4;
                        continue;
                    }
                } while (i5 != i3);
            } else {
                int i8 = (c & 255) >> 6;
                long j2 = 1 << (c & '?');
                do {
                    i5--;
                    if (this.jjstateSet[i5] == 0 && (jjbitVec0[i8] & j2) != 0 && i6 > 4) {
                        i6 = 4;
                        continue;
                    }
                } while (i5 != i3);
            }
            if (i6 != Integer.MAX_VALUE) {
                this.jjmatchedKind = i6;
                this.jjmatchedPos = i4;
                i6 = Integer.MAX_VALUE;
            }
            i4++;
            i5 = this.jjnewStateCnt;
            this.jjnewStateCnt = i3;
            i3 = 1 - i3;
            if (i5 == i3) {
                return i4;
            }
            try {
                this.curChar = this.input_stream.readChar();
            } catch (IOException unused) {
                return i4;
            }
        }
    }

    private final int jjMoveNfa_2(int i, int i2) {
        this.jjnewStateCnt = 3;
        this.jjstateSet[0] = i;
        int i3 = i2;
        int i4 = 1;
        int i5 = Integer.MAX_VALUE;
        int i6 = 0;
        while (true) {
            int i7 = this.jjround + 1;
            this.jjround = i7;
            if (i7 == Integer.MAX_VALUE) {
                ReInitRounds();
            }
            char c = this.curChar;
            int i8 = 7;
            if (c < '@') {
                long j = 1 << c;
                do {
                    i4--;
                    switch (this.jjstateSet[i4]) {
                        case 0:
                            if ((j & (-3298534883329L)) != 0 && i5 > 8) {
                                i5 = 8;
                                continue;
                            }
                            break;
                        case 1:
                            if (i5 > 7) {
                                i5 = 7;
                            }
                            int[] iArr = this.jjstateSet;
                            int i9 = this.jjnewStateCnt;
                            this.jjnewStateCnt = i9 + 1;
                            iArr[i9] = 1;
                            continue;
                    }
                } while (i4 != i6);
            } else if (c < 128) {
                do {
                    i4--;
                    switch (this.jjstateSet[i4]) {
                        case 0:
                            if (i5 > 8) {
                                i5 = 8;
                            }
                            if (this.curChar != '\\') {
                                continue;
                            }
                            jjCheckNAdd(1);
                            continue;
                        case 1:
                            if (i5 > 7) {
                                i5 = 7;
                            }
                            jjCheckNAdd(1);
                            continue;
                        case 2:
                            if (i5 > 8) {
                                i5 = 8;
                                continue;
                            } else {
                                continue;
                            }
                    }
                } while (i4 != i6);
            } else {
                int i10 = (c & 255) >> 6;
                long j2 = 1 << (c & '?');
                while (true) {
                    i4--;
                    switch (this.jjstateSet[i4]) {
                        case 0:
                            if ((jjbitVec0[i10] & j2) != 0 && i5 > 8) {
                                i5 = 8;
                                break;
                            }
                            break;
                        case 1:
                            if ((jjbitVec0[i10] & j2) != 0) {
                                if (i5 > i8) {
                                    i5 = 7;
                                }
                                int[] iArr2 = this.jjstateSet;
                                int i11 = this.jjnewStateCnt;
                                this.jjnewStateCnt = i11 + 1;
                                iArr2[i11] = 1;
                                break;
                            }
                            break;
                    }
                    if (i4 != i6) {
                        i8 = 7;
                    }
                }
            }
            if (i5 != Integer.MAX_VALUE) {
                this.jjmatchedKind = i5;
                this.jjmatchedPos = i3;
                i5 = Integer.MAX_VALUE;
            }
            i3++;
            i4 = this.jjnewStateCnt;
            this.jjnewStateCnt = i6;
            i6 = 3 - i6;
            if (i4 == i6) {
                return i3;
            }
            try {
                this.curChar = this.input_stream.readChar();
            } catch (IOException unused) {
                return i3;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:102:0x00a2, code lost:
        continue;
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x00a2, code lost:
        continue;
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x00e2, code lost:
        continue;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x005d, code lost:
        if (r5 > 12) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0065, code lost:
        if (r5 > 12) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0067, code lost:
        r5 = 12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0069, code lost:
        jjCheckNAdd(4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0075, code lost:
        if (r5 > 11) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x008d, code lost:
        if (r5 > 11) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x008f, code lost:
        r5 = 11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0091, code lost:
        jjCheckNAdd(2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00c2, code lost:
        if (r5 > 11) goto L73;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x00d3, code lost:
        if (r5 > 11) goto L73;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00d5, code lost:
        r5 = 11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00d7, code lost:
        jjCheckNAdd(2);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final int jjMoveNfa_3(int i, int i2) {
        int i3 = 6;
        this.jjnewStateCnt = 6;
        this.jjstateSet[0] = i;
        int i4 = Integer.MAX_VALUE;
        int i5 = i2;
        int i6 = 1;
        int i7 = Integer.MAX_VALUE;
        int i8 = 0;
        while (true) {
            int i9 = this.jjround + 1;
            this.jjround = i9;
            if (i9 == i4) {
                ReInitRounds();
            }
            char c = this.curChar;
            int i10 = 10;
            if (c < '@') {
                long j = 1 << c;
                do {
                    int[] iArr = this.jjstateSet;
                    i6--;
                    switch (iArr[i6]) {
                        case 0:
                            if ((j & (-17179877377L)) == 0) {
                                if (this.curChar == '\r') {
                                    int i11 = this.jjnewStateCnt;
                                    this.jjnewStateCnt = i11 + 1;
                                    iArr[i11] = 3;
                                    continue;
                                } else {
                                    continue;
                                }
                            }
                            break;
                        case 1:
                            if (i7 > 10) {
                                i7 = 10;
                            }
                            int[] iArr2 = this.jjstateSet;
                            int i12 = this.jjnewStateCnt;
                            this.jjnewStateCnt = i12 + 1;
                            iArr2[i12] = 1;
                            continue;
                        case 2:
                            if ((j & (-17179877377L)) == 0) {
                                continue;
                            }
                            break;
                        case 3:
                            if (this.curChar != '\n') {
                                continue;
                            }
                            break;
                        case 4:
                            if ((j & 4294967808L) == 0) {
                                continue;
                            }
                            break;
                        case 5:
                            if (this.curChar == '\r') {
                                int i13 = this.jjnewStateCnt;
                                this.jjnewStateCnt = i13 + 1;
                                iArr[i13] = 3;
                                continue;
                            } else {
                                continue;
                            }
                    }
                } while (i6 != i8);
            } else if (c < 128) {
                long j2 = 1 << (c & '?');
                do {
                    i6--;
                    switch (this.jjstateSet[i6]) {
                        case 0:
                            if ((j2 & (-268435457)) == 0) {
                                if (this.curChar != '\\') {
                                    continue;
                                }
                                jjCheckNAdd(1);
                                continue;
                            }
                            break;
                        case 1:
                            if (i7 > 10) {
                                i7 = 10;
                            }
                            jjCheckNAdd(1);
                            continue;
                        case 2:
                            if ((j2 & (-268435457)) == 0) {
                                continue;
                            }
                            break;
                    }
                } while (i6 != i8);
            } else {
                int i14 = (c & 255) >> i3;
                long j3 = 1 << (c & '?');
                while (true) {
                    i6--;
                    switch (this.jjstateSet[i6]) {
                        case 0:
                        case 2:
                            if ((jjbitVec0[i14] & j3) != 0) {
                                if (i7 > 11) {
                                    i7 = 11;
                                }
                                jjCheckNAdd(2);
                                break;
                            }
                            break;
                        case 1:
                            if ((jjbitVec0[i14] & j3) != 0) {
                                if (i7 > i10) {
                                    i7 = 10;
                                }
                                int[] iArr3 = this.jjstateSet;
                                int i15 = this.jjnewStateCnt;
                                this.jjnewStateCnt = i15 + 1;
                                iArr3[i15] = 1;
                                break;
                            }
                            break;
                    }
                    if (i6 != i8) {
                        i10 = 10;
                    }
                }
            }
            if (i7 != Integer.MAX_VALUE) {
                this.jjmatchedKind = i7;
                this.jjmatchedPos = i5;
                i7 = Integer.MAX_VALUE;
            }
            i5++;
            i6 = this.jjnewStateCnt;
            this.jjnewStateCnt = i8;
            i8 = 6 - i8;
            if (i6 == i8) {
                return i5;
            }
            try {
                this.curChar = this.input_stream.readChar();
                i3 = 6;
                i4 = Integer.MAX_VALUE;
            } catch (IOException unused) {
                return i5;
            }
        }
    }

    private final int jjMoveStringLiteralDfa0_0() {
        char c = this.curChar;
        return c != '\"' ? c != '(' ? jjMoveNfa_0(2, 0) : jjStopAtPos(0, 1) : jjStopAtPos(0, 9);
    }

    private final int jjMoveStringLiteralDfa0_1() {
        int i;
        switch (this.curChar) {
            case '(':
                i = 3;
                break;
            case ')':
                i = 2;
                break;
            default:
                return jjMoveNfa_1(0, 0);
        }
        return jjStopAtPos(0, i);
    }

    private final int jjMoveStringLiteralDfa0_2() {
        int i;
        switch (this.curChar) {
            case '(':
                i = 5;
                break;
            case ')':
                i = 6;
                break;
            default:
                return jjMoveNfa_2(0, 0);
        }
        return jjStopAtPos(0, i);
    }

    private final int jjMoveStringLiteralDfa0_3() {
        return this.curChar != '\"' ? jjMoveNfa_3(0, 0) : jjStopAtPos(0, 13);
    }

    private final int jjStartNfaWithStates_0(int i, int i2, int i3) {
        this.jjmatchedKind = i2;
        this.jjmatchedPos = i;
        try {
            this.curChar = this.input_stream.readChar();
            return jjMoveNfa_0(i3, i + 1);
        } catch (IOException unused) {
            return i + 1;
        }
    }

    private final int jjStartNfaWithStates_1(int i, int i2, int i3) {
        this.jjmatchedKind = i2;
        this.jjmatchedPos = i;
        try {
            this.curChar = this.input_stream.readChar();
            return jjMoveNfa_1(i3, i + 1);
        } catch (IOException unused) {
            return i + 1;
        }
    }

    private final int jjStartNfaWithStates_2(int i, int i2, int i3) {
        this.jjmatchedKind = i2;
        this.jjmatchedPos = i;
        try {
            this.curChar = this.input_stream.readChar();
            return jjMoveNfa_2(i3, i + 1);
        } catch (IOException unused) {
            return i + 1;
        }
    }

    private final int jjStartNfaWithStates_3(int i, int i2, int i3) {
        this.jjmatchedKind = i2;
        this.jjmatchedPos = i;
        try {
            this.curChar = this.input_stream.readChar();
            return jjMoveNfa_3(i3, i + 1);
        } catch (IOException unused) {
            return i + 1;
        }
    }

    private final int jjStartNfa_0(int i, long j) {
        return jjMoveNfa_0(jjStopStringLiteralDfa_0(i, j), i + 1);
    }

    private final int jjStartNfa_1(int i, long j) {
        return jjMoveNfa_1(jjStopStringLiteralDfa_1(i, j), i + 1);
    }

    private final int jjStartNfa_2(int i, long j) {
        return jjMoveNfa_2(jjStopStringLiteralDfa_2(i, j), i + 1);
    }

    private final int jjStartNfa_3(int i, long j) {
        return jjMoveNfa_3(jjStopStringLiteralDfa_3(i, j), i + 1);
    }

    private final int jjStopAtPos(int i, int i2) {
        this.jjmatchedKind = i2;
        this.jjmatchedPos = i;
        return i + 1;
    }

    private final int jjStopStringLiteralDfa_0(int i, long j) {
        return -1;
    }

    private final int jjStopStringLiteralDfa_1(int i, long j) {
        return -1;
    }

    private final int jjStopStringLiteralDfa_2(int i, long j) {
        return -1;
    }

    private final int jjStopStringLiteralDfa_3(int i, long j) {
        return -1;
    }

    void MoreLexicalActions() {
        int i = this.jjimageLen;
        int i2 = this.jjmatchedPos + 1;
        this.lengthOfMatch = i2;
        this.jjimageLen = i + i2;
        if (this.jjmatchedKind != 10) {
            return;
        }
        if (this.image == null) {
            this.image = new StringBuffer();
        }
        this.image.append(this.input_stream.GetSuffix(this.jjimageLen));
        this.jjimageLen = 0;
        StringBuffer stringBuffer = this.image;
        stringBuffer.deleteCharAt(stringBuffer.length() - 2);
    }

    public void ReInit(SimpleCharStream simpleCharStream) {
        this.jjnewStateCnt = 0;
        this.jjmatchedPos = 0;
        this.curLexState = this.defaultLexState;
        this.input_stream = simpleCharStream;
        ReInitRounds();
    }

    public void ReInit(SimpleCharStream simpleCharStream, int i) {
        ReInit(simpleCharStream);
        SwitchTo(i);
    }

    void SkipLexicalActions(Token token) {
        StringBuffer stringBuffer;
        int i = this.jjmatchedKind;
        if (i == 3) {
            if (this.image == null) {
                this.image = new StringBuffer();
            }
            StringBuffer stringBuffer2 = this.image;
            SimpleCharStream simpleCharStream = this.input_stream;
            int i2 = this.jjimageLen;
            int i3 = this.jjmatchedPos + 1;
            this.lengthOfMatch = i3;
            stringBuffer2.append(simpleCharStream.GetSuffix(i2 + i3));
            this.commentNest = 1;
            return;
        }
        switch (i) {
            case 5:
                if (this.image == null) {
                    this.image = new StringBuffer();
                }
                StringBuffer stringBuffer3 = this.image;
                SimpleCharStream simpleCharStream2 = this.input_stream;
                int i4 = this.jjimageLen;
                int i5 = this.jjmatchedPos + 1;
                this.lengthOfMatch = i5;
                stringBuffer3.append(simpleCharStream2.GetSuffix(i4 + i5));
                this.commentNest++;
                System.out.println("+++ COMMENT NEST=" + this.commentNest);
                return;
            case 6:
                if (this.image == null) {
                    this.image = new StringBuffer();
                }
                StringBuffer stringBuffer4 = this.image;
                SimpleCharStream simpleCharStream3 = this.input_stream;
                int i6 = this.jjimageLen;
                int i7 = this.jjmatchedPos + 1;
                this.lengthOfMatch = i7;
                stringBuffer4.append(simpleCharStream3.GetSuffix(i6 + i7));
                this.commentNest--;
                System.out.println("+++ COMMENT NEST=" + this.commentNest);
                if (this.commentNest != 0) {
                    return;
                }
                SwitchTo(1);
                return;
            case 7:
                if (this.image == null) {
                    this.image = new StringBuffer();
                }
                StringBuffer stringBuffer5 = this.image;
                SimpleCharStream simpleCharStream4 = this.input_stream;
                int i8 = this.jjimageLen;
                int i9 = this.jjmatchedPos + 1;
                this.lengthOfMatch = i9;
                stringBuffer5.append(simpleCharStream4.GetSuffix(i8 + i9));
                this.image.deleteCharAt(stringBuffer.length() - 2);
                return;
            default:
                return;
        }
    }

    public void SwitchTo(int i) {
        if (i < 4 && i >= 0) {
            this.curLexState = i;
            return;
        }
        throw new TokenMgrError("Error: Ignoring invalid lexical state : " + i + ". State unchanged.", 2);
    }

    void TokenLexicalActions(Token token) {
        if (this.jjmatchedKind != 13) {
            return;
        }
        if (this.image == null) {
            this.image = new StringBuffer();
        }
        StringBuffer stringBuffer = this.image;
        SimpleCharStream simpleCharStream = this.input_stream;
        int i = this.jjimageLen;
        int i2 = this.jjmatchedPos + 1;
        this.lengthOfMatch = i2;
        stringBuffer.append(simpleCharStream.GetSuffix(i + i2));
        StringBuffer stringBuffer2 = this.image;
        token.image = stringBuffer2.substring(0, stringBuffer2.length() - 1);
    }

    public Token getNextToken() {
        String str;
        int i;
        boolean z;
        int i2;
        String str2;
        int i3 = 0;
        while (true) {
            try {
                this.curChar = this.input_stream.BeginToken();
                str = null;
                this.image = null;
                this.jjimageLen = 0;
                while (true) {
                    switch (this.curLexState) {
                        case 0:
                            this.jjmatchedKind = Integer.MAX_VALUE;
                            this.jjmatchedPos = 0;
                            i3 = jjMoveStringLiteralDfa0_0();
                            break;
                        case 1:
                            this.jjmatchedKind = Integer.MAX_VALUE;
                            this.jjmatchedPos = 0;
                            i3 = jjMoveStringLiteralDfa0_1();
                            break;
                        case 2:
                            this.jjmatchedKind = Integer.MAX_VALUE;
                            this.jjmatchedPos = 0;
                            i3 = jjMoveStringLiteralDfa0_2();
                            break;
                        case 3:
                            this.jjmatchedKind = Integer.MAX_VALUE;
                            this.jjmatchedPos = 0;
                            i3 = jjMoveStringLiteralDfa0_3();
                            break;
                    }
                    if (this.jjmatchedKind != Integer.MAX_VALUE) {
                        int i4 = this.jjmatchedPos;
                        if (i4 + 1 < i3) {
                            this.input_stream.backup((i3 - i4) - 1);
                        }
                        long[] jArr = jjtoToken;
                        int i5 = this.jjmatchedKind;
                        if ((jArr[i5 >> 6] & (1 << (i5 & 63))) != 0) {
                            Token jjFillToken = jjFillToken();
                            TokenLexicalActions(jjFillToken);
                            int[] iArr = jjnewLexState;
                            int i6 = this.jjmatchedKind;
                            if (iArr[i6] != -1) {
                                this.curLexState = iArr[i6];
                            }
                            return jjFillToken;
                        }
                        if (((1 << (i5 & 63)) & jjtoSkip[i5 >> 6]) != 0) {
                            SkipLexicalActions(null);
                            int[] iArr2 = jjnewLexState;
                            int i7 = this.jjmatchedKind;
                            if (iArr2[i7] != -1) {
                                this.curLexState = iArr2[i7];
                            }
                        } else {
                            MoreLexicalActions();
                            int[] iArr3 = jjnewLexState;
                            int i8 = this.jjmatchedKind;
                            if (iArr3[i8] != -1) {
                                this.curLexState = iArr3[i8];
                            }
                            this.jjmatchedKind = Integer.MAX_VALUE;
                            try {
                                this.curChar = this.input_stream.readChar();
                                i3 = 0;
                            } catch (IOException unused) {
                                i3 = 0;
                            }
                        }
                    }
                }
            } catch (IOException unused2) {
                this.jjmatchedKind = 0;
                return jjFillToken();
            }
        }
        int endLine = this.input_stream.getEndLine();
        int endColumn = this.input_stream.getEndColumn();
        try {
            this.input_stream.readChar();
            this.input_stream.backup(1);
            i = endLine;
            i2 = endColumn;
            z = false;
        } catch (IOException unused3) {
            str = i3 <= 1 ? "" : this.input_stream.GetImage();
            char c = this.curChar;
            if (c == '\n' || c == '\r') {
                i = endLine + 1;
                z = true;
                i2 = 0;
            } else {
                i2 = endColumn + 1;
                i = endLine;
                z = true;
            }
        }
        if (!z) {
            this.input_stream.backup(1);
            str2 = i3 <= 1 ? "" : this.input_stream.GetImage();
        } else {
            str2 = str;
        }
        throw new TokenMgrError(z, this.curLexState, i, i2, str2, this.curChar, 0);
    }

    protected Token jjFillToken() {
        Token newToken = Token.newToken(this.jjmatchedKind);
        int i = this.jjmatchedKind;
        newToken.kind = i;
        String str = jjstrLiteralImages[i];
        if (str == null) {
            str = this.input_stream.GetImage();
        }
        newToken.image = str;
        newToken.beginLine = this.input_stream.getBeginLine();
        newToken.beginColumn = this.input_stream.getBeginColumn();
        newToken.endLine = this.input_stream.getEndLine();
        newToken.endColumn = this.input_stream.getEndColumn();
        return newToken;
    }

    public void setDebugStream(PrintStream printStream) {
        this.debugStream = printStream;
    }
}
