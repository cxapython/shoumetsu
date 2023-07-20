package org.apache.james.mime4j.field.contentdisposition.parser;

import java.io.IOException;
import java.io.PrintStream;

/* loaded from: classes.dex */
public class ContentDispositionParserTokenManager implements ContentDispositionParserConstants {
    static int commentNest;
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
    public static final String[] jjstrLiteralImages = {"", "\r", "\n", ";", "=", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null};
    public static final String[] lexStateNames = {"DEFAULT", "INCOMMENT", "NESTED_COMMENT", "INQUOTEDSTRING"};
    public static final int[] jjnewLexState = {-1, -1, -1, -1, -1, -1, 1, 0, -1, 2, -1, -1, -1, -1, -1, 3, -1, -1, 0, -1, -1, -1, -1};
    static final long[] jjtoToken = {1835039};
    static final long[] jjtoSkip = {160};
    static final long[] jjtoSpecial = {32};
    static final long[] jjtoMore = {261952};

    public ContentDispositionParserTokenManager(SimpleCharStream simpleCharStream) {
        this.debugStream = System.out;
        this.jjrounds = new int[3];
        this.jjstateSet = new int[6];
        this.curLexState = 0;
        this.defaultLexState = 0;
        this.input_stream = simpleCharStream;
    }

    public ContentDispositionParserTokenManager(SimpleCharStream simpleCharStream, int i) {
        this(simpleCharStream);
        SwitchTo(i);
    }

    private final void ReInitRounds() {
        this.jjround = -2147483647;
        int i = 3;
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

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0067, code lost:
        if (r6 > 19) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0080, code lost:
        if (r6 > 19) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0083, code lost:
        r1 = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0084, code lost:
        jjCheckNAdd(1);
        r6 = r1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final int jjMoveNfa_0(int i, int i2) {
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
            if (c < '@') {
                long j = 1 << c;
                while (true) {
                    i4--;
                    int i8 = 19;
                    switch (this.jjstateSet[i4]) {
                        case 0:
                            if ((j & 4294967808L) != 0) {
                                jjCheckNAdd(0);
                                i5 = 5;
                                break;
                            }
                            break;
                        case 1:
                            if ((j & 287948901175001088L) != 0) {
                            }
                            break;
                        case 2:
                            if ((j & 288068726467591679L) != 0) {
                                if (i5 > 20) {
                                    i5 = 20;
                                }
                                jjCheckNAdd(2);
                                break;
                            }
                            break;
                        case 3:
                            if ((j & 288068726467591679L) != 0) {
                                if (i5 > 20) {
                                    i5 = 20;
                                }
                                jjCheckNAdd(2);
                            } else if ((j & 4294967808L) != 0) {
                                if (i5 > 5) {
                                    i5 = 5;
                                }
                                jjCheckNAdd(0);
                            }
                            if ((j & 287948901175001088L) != 0) {
                            }
                            break;
                    }
                    if (i4 == i6) {
                    }
                }
            } else if (c < 128) {
                long j2 = 1 << (c & '?');
                do {
                    i4--;
                    switch (this.jjstateSet[i4]) {
                        case 2:
                        case 3:
                            if ((j2 & (-939524098)) == 0) {
                                continue;
                            } else {
                                jjCheckNAdd(2);
                                i5 = 20;
                                continue;
                            }
                    }
                } while (i4 != i6);
            } else {
                int i9 = (c & 255) >> 6;
                long j3 = 1 << (c & '?');
                do {
                    i4--;
                    switch (this.jjstateSet[i4]) {
                        case 2:
                        case 3:
                            if ((jjbitVec0[i9] & j3) != 0) {
                                if (i5 > 20) {
                                    i5 = 20;
                                }
                                jjCheckNAdd(2);
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

    private final int jjMoveNfa_1(int i, int i2) {
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
            if (c >= '@') {
                if (c >= 128) {
                    int i8 = (c & 255) >> 6;
                    long j = 1 << (c & '?');
                    do {
                        i4--;
                        switch (this.jjstateSet[i4]) {
                            case 0:
                                if ((jjbitVec0[i8] & j) != 0 && i5 > 10) {
                                    i5 = 10;
                                    continue;
                                }
                                break;
                            case 1:
                                if ((jjbitVec0[i8] & j) != 0 && i5 > 8) {
                                    i5 = 8;
                                    continue;
                                }
                                break;
                        }
                    } while (i4 != i6);
                } else {
                    do {
                        i4--;
                        switch (this.jjstateSet[i4]) {
                            case 0:
                                if (i5 > 10) {
                                    i5 = 10;
                                }
                                if (this.curChar == '\\') {
                                    int[] iArr = this.jjstateSet;
                                    int i9 = this.jjnewStateCnt;
                                    this.jjnewStateCnt = i9 + 1;
                                    iArr[i9] = 1;
                                    continue;
                                } else {
                                    continue;
                                }
                            case 1:
                                if (i5 > 8) {
                                    i5 = 8;
                                    continue;
                                } else {
                                    continue;
                                }
                            case 2:
                                if (i5 > 10) {
                                    i5 = 10;
                                    continue;
                                } else {
                                    continue;
                                }
                        }
                    } while (i4 != i6);
                }
            } else {
                do {
                    i4--;
                    switch (this.jjstateSet[i4]) {
                        case 0:
                            if (i5 > 10) {
                                i5 = 10;
                                continue;
                            } else {
                                continue;
                            }
                        case 1:
                            if (i5 > 8) {
                                i5 = 8;
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
            if (c >= '@') {
                if (c >= 128) {
                    int i8 = (c & 255) >> 6;
                    long j = 1 << (c & '?');
                    do {
                        i4--;
                        switch (this.jjstateSet[i4]) {
                            case 0:
                                if ((jjbitVec0[i8] & j) != 0 && i5 > 14) {
                                    i5 = 14;
                                    continue;
                                }
                                break;
                            case 1:
                                if ((jjbitVec0[i8] & j) != 0 && i5 > 11) {
                                    i5 = 11;
                                    continue;
                                }
                                break;
                        }
                    } while (i4 != i6);
                } else {
                    do {
                        i4--;
                        switch (this.jjstateSet[i4]) {
                            case 0:
                                if (i5 > 14) {
                                    i5 = 14;
                                }
                                if (this.curChar == '\\') {
                                    int[] iArr = this.jjstateSet;
                                    int i9 = this.jjnewStateCnt;
                                    this.jjnewStateCnt = i9 + 1;
                                    iArr[i9] = 1;
                                    continue;
                                } else {
                                    continue;
                                }
                            case 1:
                                if (i5 > 11) {
                                    i5 = 11;
                                    continue;
                                } else {
                                    continue;
                                }
                            case 2:
                                if (i5 > 14) {
                                    i5 = 14;
                                    continue;
                                } else {
                                    continue;
                                }
                        }
                    } while (i4 != i6);
                }
            } else {
                do {
                    i4--;
                    switch (this.jjstateSet[i4]) {
                        case 0:
                            if (i5 > 14) {
                                i5 = 14;
                                continue;
                            } else {
                                continue;
                            }
                        case 1:
                            if (i5 > 11) {
                                i5 = 11;
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

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0072, code lost:
        if (r5 > 17) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0080, code lost:
        if (r5 > 17) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0082, code lost:
        r5 = 17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0084, code lost:
        jjCheckNAdd(2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x0096, code lost:
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final int jjMoveNfa_3(int i, int i2) {
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
            if (c >= '@') {
                if (c >= 128) {
                    int i8 = (c & 255) >> 6;
                    long j = 1 << (c & '?');
                    do {
                        i4--;
                        switch (this.jjstateSet[i4]) {
                            case 0:
                            case 2:
                                if ((jjbitVec0[i8] & j) != 0) {
                                    if (i5 > 17) {
                                        i5 = 17;
                                    }
                                    jjCheckNAdd(2);
                                    continue;
                                } else {
                                    continue;
                                }
                            case 1:
                                if ((jjbitVec0[i8] & j) != 0 && i5 > 16) {
                                    i5 = 16;
                                    continue;
                                }
                                break;
                        }
                    } while (i4 != i6);
                } else {
                    long j2 = 1 << (c & '?');
                    do {
                        int[] iArr = this.jjstateSet;
                        i4--;
                        switch (iArr[i4]) {
                            case 0:
                                if ((j2 & (-268435457)) == 0) {
                                    if (this.curChar == '\\') {
                                        int i9 = this.jjnewStateCnt;
                                        this.jjnewStateCnt = i9 + 1;
                                        iArr[i9] = 1;
                                        continue;
                                    } else {
                                        continue;
                                    }
                                }
                                break;
                            case 1:
                                if (i5 > 16) {
                                    i5 = 16;
                                    continue;
                                } else {
                                    continue;
                                }
                            case 2:
                                if ((j2 & (-268435457)) == 0) {
                                    continue;
                                }
                                break;
                        }
                    } while (i4 != i6);
                }
            } else {
                long j3 = 1 << c;
                do {
                    i4--;
                    switch (this.jjstateSet[i4]) {
                        case 0:
                        case 2:
                            if ((j3 & (-17179869185L)) != 0) {
                                if (i5 > 17) {
                                    i5 = 17;
                                }
                                jjCheckNAdd(2);
                                continue;
                            } else {
                                continue;
                            }
                        case 1:
                            if (i5 > 16) {
                                i5 = 16;
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

    private final int jjMoveStringLiteralDfa0_0() {
        char c = this.curChar;
        return c != '\n' ? c != '\r' ? c != '\"' ? c != '(' ? c != ';' ? c != '=' ? jjMoveNfa_0(3, 0) : jjStopAtPos(0, 4) : jjStopAtPos(0, 3) : jjStopAtPos(0, 6) : jjStopAtPos(0, 15) : jjStartNfaWithStates_0(0, 1, 2) : jjStartNfaWithStates_0(0, 2, 2);
    }

    private final int jjMoveStringLiteralDfa0_1() {
        int i;
        switch (this.curChar) {
            case '(':
                i = 9;
                break;
            case ')':
                i = 7;
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
                i = 12;
                break;
            case ')':
                i = 13;
                break;
            default:
                return jjMoveNfa_2(0, 0);
        }
        return jjStopAtPos(0, i);
    }

    private final int jjMoveStringLiteralDfa0_3() {
        return this.curChar != '\"' ? jjMoveNfa_3(0, 0) : jjStopAtPos(0, 18);
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
        StringBuffer stringBuffer;
        StringBuffer stringBuffer2;
        int length;
        int i = this.jjimageLen;
        int i2 = this.jjmatchedPos + 1;
        this.lengthOfMatch = i2;
        this.jjimageLen = i + i2;
        switch (this.jjmatchedKind) {
            case 8:
                if (this.image == null) {
                    stringBuffer = new StringBuffer();
                    this.image = stringBuffer;
                }
                this.image.append(this.input_stream.GetSuffix(this.jjimageLen));
                this.jjimageLen = 0;
                stringBuffer2 = this.image;
                length = stringBuffer2.length() - 2;
                break;
            case 9:
                if (this.image == null) {
                    this.image = new StringBuffer();
                }
                this.image.append(this.input_stream.GetSuffix(this.jjimageLen));
                this.jjimageLen = 0;
                commentNest = 1;
                return;
            case 10:
            case 14:
            default:
                return;
            case 11:
                if (this.image == null) {
                    stringBuffer = new StringBuffer();
                    this.image = stringBuffer;
                }
                this.image.append(this.input_stream.GetSuffix(this.jjimageLen));
                this.jjimageLen = 0;
                stringBuffer2 = this.image;
                length = stringBuffer2.length() - 2;
                break;
            case 12:
                if (this.image == null) {
                    this.image = new StringBuffer();
                }
                this.image.append(this.input_stream.GetSuffix(this.jjimageLen));
                this.jjimageLen = 0;
                commentNest++;
                return;
            case 13:
                if (this.image == null) {
                    this.image = new StringBuffer();
                }
                this.image.append(this.input_stream.GetSuffix(this.jjimageLen));
                this.jjimageLen = 0;
                commentNest--;
                if (commentNest != 0) {
                    return;
                }
                SwitchTo(1);
                return;
            case 15:
                if (this.image == null) {
                    this.image = new StringBuffer();
                }
                this.image.append(this.input_stream.GetSuffix(this.jjimageLen));
                this.jjimageLen = 0;
                stringBuffer2 = this.image;
                length = stringBuffer2.length() - 1;
                break;
            case 16:
                if (this.image == null) {
                    stringBuffer = new StringBuffer();
                    this.image = stringBuffer;
                }
                this.image.append(this.input_stream.GetSuffix(this.jjimageLen));
                this.jjimageLen = 0;
                stringBuffer2 = this.image;
                length = stringBuffer2.length() - 2;
                break;
        }
        stringBuffer2.deleteCharAt(length);
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

    public void SwitchTo(int i) {
        if (i < 4 && i >= 0) {
            this.curLexState = i;
            return;
        }
        throw new TokenMgrError("Error: Ignoring invalid lexical state : " + i + ". State unchanged.", 2);
    }

    void TokenLexicalActions(Token token) {
        if (this.jjmatchedKind != 18) {
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
        int i;
        boolean z;
        int i2;
        String str = null;
        Token token = null;
        int i3 = 0;
        while (true) {
            try {
                this.curChar = this.input_stream.BeginToken();
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
                            jjFillToken.specialToken = token;
                            TokenLexicalActions(jjFillToken);
                            int[] iArr = jjnewLexState;
                            int i6 = this.jjmatchedKind;
                            if (iArr[i6] != -1) {
                                this.curLexState = iArr[i6];
                            }
                            return jjFillToken;
                        }
                        if (((1 << (i5 & 63)) & jjtoSkip[i5 >> 6]) != 0) {
                            if (((1 << (i5 & 63)) & jjtoSpecial[i5 >> 6]) != 0) {
                                Token jjFillToken2 = jjFillToken();
                                if (token != null) {
                                    jjFillToken2.specialToken = token;
                                    token.next = jjFillToken2;
                                }
                                token = jjFillToken2;
                            }
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
                                int endLine = this.input_stream.getEndLine();
                                int endColumn = this.input_stream.getEndColumn();
                                try {
                                    this.input_stream.readChar();
                                    this.input_stream.backup(1);
                                    i = endLine;
                                    i2 = endColumn;
                                    z = false;
                                } catch (IOException unused2) {
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
                                    str = i3 <= 1 ? "" : this.input_stream.GetImage();
                                }
                                throw new TokenMgrError(z, this.curLexState, i, i2, str, this.curChar, 0);
                            }
                        }
                    }
                }
            } catch (IOException unused3) {
                this.jjmatchedKind = 0;
                Token jjFillToken3 = jjFillToken();
                jjFillToken3.specialToken = token;
                return jjFillToken3;
            }
        }
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
