package org.apache.james.mime4j.field.language.parser;

import java.io.IOException;
import java.io.PrintStream;

/* loaded from: classes.dex */
public class ContentLanguageParserTokenManager implements ContentLanguageParserConstants {
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
    public static final String[] jjstrLiteralImages = {"", ",", "-", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, ".", null, null};
    public static final String[] lexStateNames = {"DEFAULT", "INCOMMENT", "NESTED_COMMENT", "INQUOTEDSTRING"};
    public static final int[] jjnewLexState = {-1, -1, -1, -1, 1, 0, -1, 2, -1, -1, -1, -1, -1, 3, -1, -1, 0, -1, -1, -1, -1, -1, -1};
    static final long[] jjtoToken = {2031623};
    static final long[] jjtoSkip = {40};
    static final long[] jjtoSpecial = {8};
    static final long[] jjtoMore = {65488};

    public ContentLanguageParserTokenManager(SimpleCharStream simpleCharStream) {
        this.debugStream = System.out;
        this.jjrounds = new int[4];
        this.jjstateSet = new int[8];
        this.curLexState = 0;
        this.defaultLexState = 0;
        this.input_stream = simpleCharStream;
    }

    public ContentLanguageParserTokenManager(SimpleCharStream simpleCharStream, int i) {
        this(simpleCharStream);
        SwitchTo(i);
    }

    private final void ReInitRounds() {
        this.jjround = -2147483647;
        int i = 4;
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

    /* JADX WARN: Code restructure failed: missing block: B:23:0x005d, code lost:
        if (r6 > 17) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0076, code lost:
        if (r6 > 17) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0078, code lost:
        r6 = 17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x007a, code lost:
        jjCheckNAdd(1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00b5, code lost:
        if (r6 > 18) goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x00ce, code lost:
        if (r6 > 18) goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x00d1, code lost:
        r3 = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x00d2, code lost:
        jjCheckNAdd(2);
        r6 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x0089, code lost:
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final int jjMoveNfa_0(int i, int i2) {
        this.jjnewStateCnt = 4;
        int i3 = 0;
        this.jjstateSet[0] = i;
        int i4 = i2;
        int i5 = 1;
        int i6 = Integer.MAX_VALUE;
        int i7 = 0;
        while (true) {
            int i8 = this.jjround + 1;
            this.jjround = i8;
            if (i8 == Integer.MAX_VALUE) {
                ReInitRounds();
            }
            char c = this.curChar;
            if (c < '@') {
                long j = 1 << c;
                do {
                    i5--;
                    switch (this.jjstateSet[i5]) {
                        case 0:
                            if ((j & 4294977024L) == 0) {
                                continue;
                            } else {
                                jjCheckNAdd(i3);
                                i6 = 3;
                                continue;
                            }
                        case 1:
                            if ((j & 287948901175001088L) == 0) {
                                continue;
                            }
                            break;
                        case 3:
                            if ((j & 287948901175001088L) != 0) {
                                if (i6 > 19) {
                                    i6 = 19;
                                }
                                jjCheckNAdd(3);
                                continue;
                            } else {
                                continue;
                            }
                        case 4:
                            int i9 = ((j & 287948901175001088L) > 0L ? 1 : ((j & 287948901175001088L) == 0L ? 0 : -1));
                            if (i9 != 0) {
                                if (i6 > 19) {
                                    i6 = 19;
                                }
                                jjCheckNAdd(3);
                            } else if ((j & 4294977024L) != 0) {
                                if (i6 > 3) {
                                    i6 = 3;
                                }
                                jjCheckNAdd(i3);
                            }
                            if (i9 == 0) {
                                continue;
                            }
                            break;
                    }
                } while (i5 != i7);
            } else if (c < 128) {
                long j2 = 1 << (c & '?');
                while (true) {
                    i5--;
                    int i10 = 18;
                    switch (this.jjstateSet[i5]) {
                        case 2:
                            if ((j2 & 576460743847706622L) != 0) {
                            }
                            break;
                        case 3:
                            if ((j2 & 576460743847706622L) != 0) {
                                if (i6 > 19) {
                                    i6 = 19;
                                }
                                jjCheckNAdd(3);
                                break;
                            }
                            break;
                        case 4:
                            int i11 = ((j2 & 576460743847706622L) > 0L ? 1 : ((j2 & 576460743847706622L) == 0L ? 0 : -1));
                            if (i11 != 0) {
                                if (i6 > 19) {
                                    i6 = 19;
                                }
                                jjCheckNAdd(3);
                            }
                            if (i11 != 0) {
                            }
                            break;
                    }
                    if (i5 == i7) {
                    }
                }
            } else {
                do {
                    i5--;
                    int i12 = this.jjstateSet[i5];
                } while (i5 != i7);
            }
            if (i6 != Integer.MAX_VALUE) {
                this.jjmatchedKind = i6;
                this.jjmatchedPos = i4;
                i6 = Integer.MAX_VALUE;
            }
            i4++;
            i5 = this.jjnewStateCnt;
            this.jjnewStateCnt = i7;
            i7 = 4 - i7;
            if (i5 == i7) {
                return i4;
            }
            try {
                this.curChar = this.input_stream.readChar();
                i3 = 0;
            } catch (IOException unused) {
                return i4;
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
                                if ((jjbitVec0[i8] & j) != 0 && i5 > 8) {
                                    i5 = 8;
                                    continue;
                                }
                                break;
                            case 1:
                                if ((jjbitVec0[i8] & j) != 0 && i5 > 6) {
                                    i5 = 6;
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
                                if (i5 > 8) {
                                    i5 = 8;
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
                                if (i5 > 6) {
                                    i5 = 6;
                                    continue;
                                } else {
                                    continue;
                                }
                            case 2:
                                if (i5 > 8) {
                                    i5 = 8;
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
                            if (i5 > 8) {
                                i5 = 8;
                                continue;
                            } else {
                                continue;
                            }
                        case 1:
                            if (i5 > 6) {
                                i5 = 6;
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
                                if ((jjbitVec0[i8] & j) != 0 && i5 > 12) {
                                    i5 = 12;
                                    continue;
                                }
                                break;
                            case 1:
                                if ((jjbitVec0[i8] & j) != 0 && i5 > 9) {
                                    i5 = 9;
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
                                if (i5 > 12) {
                                    i5 = 12;
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
                                if (i5 > 9) {
                                    i5 = 9;
                                    continue;
                                } else {
                                    continue;
                                }
                            case 2:
                                if (i5 > 12) {
                                    i5 = 12;
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
                            if (i5 > 12) {
                                i5 = 12;
                                continue;
                            } else {
                                continue;
                            }
                        case 1:
                            if (i5 > 9) {
                                i5 = 9;
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
        if (r5 > 15) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0080, code lost:
        if (r5 > 15) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0082, code lost:
        r5 = 15;
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
                                    if (i5 > 15) {
                                        i5 = 15;
                                    }
                                    jjCheckNAdd(2);
                                    continue;
                                } else {
                                    continue;
                                }
                            case 1:
                                if ((jjbitVec0[i8] & j) != 0 && i5 > 14) {
                                    i5 = 14;
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
                                if (i5 > 14) {
                                    i5 = 14;
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
                                if (i5 > 15) {
                                    i5 = 15;
                                }
                                jjCheckNAdd(2);
                                continue;
                            } else {
                                continue;
                            }
                        case 1:
                            if (i5 > 14) {
                                i5 = 14;
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
        int i;
        char c = this.curChar;
        if (c == '\"') {
            i = 13;
        } else if (c == '(') {
            return jjStopAtPos(0, 4);
        } else {
            switch (c) {
                case ',':
                    i = 1;
                    break;
                case '-':
                    i = 2;
                    break;
                case '.':
                    i = 20;
                    break;
                default:
                    return jjMoveNfa_0(4, 0);
            }
        }
        return jjStopAtPos(0, i);
    }

    private final int jjMoveStringLiteralDfa0_1() {
        int i;
        switch (this.curChar) {
            case '(':
                i = 7;
                break;
            case ')':
                i = 5;
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
                i = 10;
                break;
            case ')':
                i = 11;
                break;
            default:
                return jjMoveNfa_2(0, 0);
        }
        return jjStopAtPos(0, i);
    }

    private final int jjMoveStringLiteralDfa0_3() {
        return this.curChar != '\"' ? jjMoveNfa_3(0, 0) : jjStopAtPos(0, 16);
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
            case 6:
                if (this.image == null) {
                    stringBuffer = new StringBuffer();
                    this.image = stringBuffer;
                }
                this.image.append(this.input_stream.GetSuffix(this.jjimageLen));
                this.jjimageLen = 0;
                stringBuffer2 = this.image;
                length = stringBuffer2.length() - 2;
                break;
            case 7:
                if (this.image == null) {
                    this.image = new StringBuffer();
                }
                this.image.append(this.input_stream.GetSuffix(this.jjimageLen));
                this.jjimageLen = 0;
                this.commentNest = 1;
                return;
            case 8:
            case 12:
            default:
                return;
            case 9:
                if (this.image == null) {
                    stringBuffer = new StringBuffer();
                    this.image = stringBuffer;
                }
                this.image.append(this.input_stream.GetSuffix(this.jjimageLen));
                this.jjimageLen = 0;
                stringBuffer2 = this.image;
                length = stringBuffer2.length() - 2;
                break;
            case 10:
                if (this.image == null) {
                    this.image = new StringBuffer();
                }
                this.image.append(this.input_stream.GetSuffix(this.jjimageLen));
                this.jjimageLen = 0;
                this.commentNest++;
                return;
            case 11:
                if (this.image == null) {
                    this.image = new StringBuffer();
                }
                this.image.append(this.input_stream.GetSuffix(this.jjimageLen));
                this.jjimageLen = 0;
                this.commentNest--;
                if (this.commentNest != 0) {
                    return;
                }
                SwitchTo(1);
                return;
            case 13:
                if (this.image == null) {
                    this.image = new StringBuffer();
                }
                this.image.append(this.input_stream.GetSuffix(this.jjimageLen));
                this.jjimageLen = 0;
                stringBuffer2 = this.image;
                length = stringBuffer2.length() - 1;
                break;
            case 14:
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
        if (this.jjmatchedKind != 16) {
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
