package org.apache.james.mime4j.field.datetime.parser;

import cz.msebera.android.httpclient.impl.client.cache.CacheValidityPolicy;
import java.io.IOException;
import java.io.PrintStream;

/* loaded from: classes.dex */
public class DateTimeParserTokenManager implements DateTimeParserConstants {
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
    public static final String[] jjstrLiteralImages = {"", "\r", "\n", ",", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun", "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec", ":", null, "UT", "GMT", "EST", "EDT", "CST", "CDT", "MST", "MDT", "PST", "PDT", null, null, null, null, null, null, null, null, null, null, null, null, null, null};
    public static final String[] lexStateNames = {"DEFAULT", "INCOMMENT", "NESTED_COMMENT"};
    public static final int[] jjnewLexState = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 1, 0, -1, 2, -1, -1, -1, -1, -1, -1, -1, -1};
    static final long[] jjtoToken = {70437463654399L};
    static final long[] jjtoSkip = {343597383680L};
    static final long[] jjtoSpecial = {68719476736L};
    static final long[] jjtoMore = {69956427317248L};

    public DateTimeParserTokenManager(SimpleCharStream simpleCharStream) {
        this.debugStream = System.out;
        this.jjrounds = new int[4];
        this.jjstateSet = new int[8];
        this.curLexState = 0;
        this.defaultLexState = 0;
        this.input_stream = simpleCharStream;
    }

    public DateTimeParserTokenManager(SimpleCharStream simpleCharStream, int i) {
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

    private final int jjMoveNfa_0(int i, int i2) {
        this.jjnewStateCnt = 4;
        this.jjstateSet[0] = i;
        int i3 = 1;
        int i4 = i2;
        int i5 = 1;
        int i6 = Integer.MAX_VALUE;
        int i7 = 0;
        while (true) {
            int i8 = this.jjround + i3;
            this.jjround = i8;
            if (i8 == Integer.MAX_VALUE) {
                ReInitRounds();
            }
            char c = this.curChar;
            if (c < '@') {
                long j = 1 << c;
                while (true) {
                    i5--;
                    int i9 = this.jjstateSet[i5];
                    int i10 = 36;
                    int i11 = 46;
                    if (i9 != 0) {
                        switch (i9) {
                            case 2:
                                if ((j & 4294967808L) != 0) {
                                    jjCheckNAdd(2);
                                    i6 = 36;
                                    break;
                                }
                                break;
                            case 3:
                                if ((j & 287948901175001088L) != 0) {
                                    jjCheckNAdd(3);
                                    i6 = 46;
                                    break;
                                }
                                break;
                        }
                    } else if ((j & 287948901175001088L) != 0) {
                        if (i6 <= 46) {
                            i11 = i6;
                        }
                        jjCheckNAdd(3);
                        i6 = i11;
                    } else if ((j & 4294967808L) != 0) {
                        if (i6 <= 36) {
                            i10 = i6;
                        }
                        jjCheckNAdd(2);
                        i6 = i10;
                    } else if ((43980465111040L & j) != 0 && i6 > 24) {
                        i6 = 24;
                    }
                    if (i5 == i7) {
                    }
                }
            } else if (c < 128) {
                long j2 = 1 << (c & '?');
                do {
                    i5--;
                    if (this.jjstateSet[i5] == 0 && (576456345801194494L & j2) != 0) {
                        i6 = 35;
                        continue;
                    }
                } while (i5 != i7);
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
                i3 = 1;
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
                                if ((jjbitVec0[i8] & j) != 0 && i5 > 41) {
                                    i5 = 41;
                                    continue;
                                }
                                break;
                            case 1:
                                if ((jjbitVec0[i8] & j) != 0 && i5 > 39) {
                                    i5 = 39;
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
                                if (i5 > 41) {
                                    i5 = 41;
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
                                if (i5 > 39) {
                                    i5 = 39;
                                    continue;
                                } else {
                                    continue;
                                }
                            case 2:
                                if (i5 > 41) {
                                    i5 = 41;
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
                            if (i5 > 41) {
                                i5 = 41;
                                continue;
                            } else {
                                continue;
                            }
                        case 1:
                            if (i5 > 39) {
                                i5 = 39;
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
                                if ((jjbitVec0[i8] & j) != 0 && i5 > 45) {
                                    i5 = 45;
                                    continue;
                                }
                                break;
                            case 1:
                                if ((jjbitVec0[i8] & j) != 0 && i5 > 42) {
                                    i5 = 42;
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
                                if (i5 > 45) {
                                    i5 = 45;
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
                                if (i5 > 42) {
                                    i5 = 42;
                                    continue;
                                } else {
                                    continue;
                                }
                            case 2:
                                if (i5 > 45) {
                                    i5 = 45;
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
                            if (i5 > 45) {
                                i5 = 45;
                                continue;
                            } else {
                                continue;
                            }
                        case 1:
                            if (i5 > 42) {
                                i5 = 42;
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
        switch (c) {
            case 'C':
                return jjMoveStringLiteralDfa1_0(1610612736L);
            case 'D':
                return jjMoveStringLiteralDfa1_0(4194304L);
            case 'E':
                return jjMoveStringLiteralDfa1_0(402653184L);
            case 'F':
                return jjMoveStringLiteralDfa1_0(4352L);
            case 'G':
                return jjMoveStringLiteralDfa1_0(67108864L);
            default:
                switch (c) {
                    case 'M':
                        return jjMoveStringLiteralDfa1_0(6442491920L);
                    case 'N':
                        return jjMoveStringLiteralDfa1_0(2097152L);
                    case 'O':
                        return jjMoveStringLiteralDfa1_0(1048576L);
                    case 'P':
                        return jjMoveStringLiteralDfa1_0(25769803776L);
                    default:
                        switch (c) {
                            case 'S':
                                return jjMoveStringLiteralDfa1_0(525824L);
                            case 'T':
                                return jjMoveStringLiteralDfa1_0(160L);
                            case 'U':
                                return jjMoveStringLiteralDfa1_0(33554432L);
                            default:
                                switch (c) {
                                    case '\n':
                                        return jjStopAtPos(0, 2);
                                    case '\r':
                                        return jjStopAtPos(0, 1);
                                    case '(':
                                        return jjStopAtPos(0, 37);
                                    case ',':
                                        return jjStopAtPos(0, 3);
                                    case ':':
                                        return jjStopAtPos(0, 23);
                                    case 'A':
                                        return jjMoveStringLiteralDfa1_0(278528L);
                                    case 'J':
                                        return jjMoveStringLiteralDfa1_0(198656L);
                                    case 'W':
                                        return jjMoveStringLiteralDfa1_0(64L);
                                    default:
                                        return jjMoveNfa_0(0, 0);
                                }
                        }
                }
        }
    }

    private final int jjMoveStringLiteralDfa0_1() {
        int i;
        switch (this.curChar) {
            case '(':
                i = 40;
                break;
            case ')':
                i = 38;
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
                i = 43;
                break;
            case ')':
                i = 44;
                break;
            default:
                return jjMoveNfa_2(0, 0);
        }
        return jjStopAtPos(0, i);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private final int jjMoveStringLiteralDfa1_0(long j) {
        try {
            this.curChar = this.input_stream.readChar();
            switch (this.curChar) {
                case 'D':
                    return jjMoveStringLiteralDfa2_0(j, 22817013760L);
                case 'M':
                    return jjMoveStringLiteralDfa2_0(j, 67108864L);
                case 'S':
                    return jjMoveStringLiteralDfa2_0(j, 11408506880L);
                case 'T':
                    if ((33554432 & j) != 0) {
                        return jjStopAtPos(1, 25);
                    }
                    break;
                case 'a':
                    return jjMoveStringLiteralDfa2_0(j, 43520L);
                case 'c':
                    return jjMoveStringLiteralDfa2_0(j, 1048576L);
                case 'e':
                    return jjMoveStringLiteralDfa2_0(j, 4722752L);
                case 'h':
                    return jjMoveStringLiteralDfa2_0(j, 128L);
                case 'o':
                    return jjMoveStringLiteralDfa2_0(j, 2097168L);
                case 'p':
                    return jjMoveStringLiteralDfa2_0(j, 16384L);
                case 'r':
                    return jjMoveStringLiteralDfa2_0(j, 256L);
                case 'u':
                    return jjMoveStringLiteralDfa2_0(j, 459808L);
            }
            return jjStartNfa_0(0, j);
        } catch (IOException unused) {
            jjStopStringLiteralDfa_0(0, j);
            return 1;
        }
    }

    private final int jjMoveStringLiteralDfa2_0(long j, long j2) {
        long j3 = j2 & j;
        if (j3 == 0) {
            return jjStartNfa_0(0, j);
        }
        try {
            this.curChar = this.input_stream.readChar();
            char c = this.curChar;
            if (c != 'T') {
                if (c != 'g') {
                    if (c != 'i') {
                        if (c != 'l') {
                            if (c != 'n') {
                                if (c != 'p') {
                                    if (c != 'r') {
                                        if (c != 'y') {
                                            switch (c) {
                                                case 'b':
                                                    if ((4096 & j3) != 0) {
                                                        return jjStopAtPos(2, 12);
                                                    }
                                                    break;
                                                case 'c':
                                                    if ((4194304 & j3) != 0) {
                                                        return jjStopAtPos(2, 22);
                                                    }
                                                    break;
                                                case 'd':
                                                    if ((64 & j3) != 0) {
                                                        return jjStopAtPos(2, 6);
                                                    }
                                                    break;
                                                case 'e':
                                                    if ((32 & j3) != 0) {
                                                        return jjStopAtPos(2, 5);
                                                    }
                                                    break;
                                                default:
                                                    switch (c) {
                                                        case 't':
                                                            if ((512 & j3) != 0) {
                                                                return jjStopAtPos(2, 9);
                                                            }
                                                            if ((1048576 & j3) != 0) {
                                                                return jjStopAtPos(2, 20);
                                                            }
                                                            break;
                                                        case 'u':
                                                            if ((128 & j3) != 0) {
                                                                return jjStopAtPos(2, 7);
                                                            }
                                                            break;
                                                        case 'v':
                                                            if ((2097152 & j3) != 0) {
                                                                return jjStopAtPos(2, 21);
                                                            }
                                                            break;
                                                    }
                                            }
                                        } else if ((32768 & j3) != 0) {
                                            return jjStopAtPos(2, 15);
                                        }
                                    } else if ((8192 & j3) != 0) {
                                        return jjStopAtPos(2, 13);
                                    } else {
                                        if ((16384 & j3) != 0) {
                                            return jjStopAtPos(2, 14);
                                        }
                                    }
                                } else if ((524288 & j3) != 0) {
                                    return jjStopAtPos(2, 19);
                                }
                            } else if ((16 & j3) != 0) {
                                return jjStopAtPos(2, 4);
                            } else {
                                if ((1024 & j3) != 0) {
                                    return jjStopAtPos(2, 10);
                                }
                                if ((2048 & j3) != 0) {
                                    return jjStopAtPos(2, 11);
                                }
                                if ((65536 & j3) != 0) {
                                    return jjStopAtPos(2, 16);
                                }
                            }
                        } else if ((131072 & j3) != 0) {
                            return jjStopAtPos(2, 17);
                        }
                    } else if ((256 & j3) != 0) {
                        return jjStopAtPos(2, 8);
                    }
                } else if ((262144 & j3) != 0) {
                    return jjStopAtPos(2, 18);
                }
            } else if ((67108864 & j3) != 0) {
                return jjStopAtPos(2, 26);
            } else {
                if ((134217728 & j3) != 0) {
                    return jjStopAtPos(2, 27);
                }
                if ((268435456 & j3) != 0) {
                    return jjStopAtPos(2, 28);
                }
                if ((536870912 & j3) != 0) {
                    return jjStopAtPos(2, 29);
                }
                if ((1073741824 & j3) != 0) {
                    return jjStopAtPos(2, 30);
                }
                if ((CacheValidityPolicy.MAX_AGE & j3) != 0) {
                    return jjStopAtPos(2, 31);
                }
                if ((4294967296L & j3) != 0) {
                    return jjStopAtPos(2, 32);
                }
                if ((8589934592L & j3) != 0) {
                    return jjStopAtPos(2, 33);
                }
                if ((17179869184L & j3) != 0) {
                    return jjStopAtPos(2, 34);
                }
            }
            return jjStartNfa_0(1, j3);
        } catch (IOException unused) {
            jjStopStringLiteralDfa_0(1, j3);
            return 2;
        }
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

    private final int jjStartNfa_0(int i, long j) {
        return jjMoveNfa_0(jjStopStringLiteralDfa_0(i, j), i + 1);
    }

    private final int jjStartNfa_1(int i, long j) {
        return jjMoveNfa_1(jjStopStringLiteralDfa_1(i, j), i + 1);
    }

    private final int jjStartNfa_2(int i, long j) {
        return jjMoveNfa_2(jjStopStringLiteralDfa_2(i, j), i + 1);
    }

    private final int jjStopAtPos(int i, int i2) {
        this.jjmatchedKind = i2;
        this.jjmatchedPos = i;
        return i + 1;
    }

    private final int jjStopStringLiteralDfa_0(int i, long j) {
        switch (i) {
            case 0:
                if ((j & 34334373872L) != 0) {
                    this.jjmatchedKind = 35;
                }
                return -1;
            case 1:
                if ((j & 34334373872L) != 0 && this.jjmatchedPos == 0) {
                    this.jjmatchedKind = 35;
                    this.jjmatchedPos = 0;
                }
                return -1;
            default:
                return -1;
        }
    }

    private final int jjStopStringLiteralDfa_1(int i, long j) {
        return -1;
    }

    private final int jjStopStringLiteralDfa_2(int i, long j) {
        return -1;
    }

    void MoreLexicalActions() {
        StringBuffer stringBuffer;
        StringBuffer stringBuffer2;
        int i = this.jjimageLen;
        int i2 = this.jjmatchedPos + 1;
        this.lengthOfMatch = i2;
        this.jjimageLen = i + i2;
        switch (this.jjmatchedKind) {
            case 39:
                if (this.image == null) {
                    stringBuffer = new StringBuffer();
                    this.image = stringBuffer;
                    break;
                }
                break;
            case 40:
                if (this.image == null) {
                    this.image = new StringBuffer();
                }
                this.image.append(this.input_stream.GetSuffix(this.jjimageLen));
                this.jjimageLen = 0;
                commentNest = 1;
                return;
            case 41:
            default:
                return;
            case 42:
                if (this.image == null) {
                    stringBuffer = new StringBuffer();
                    this.image = stringBuffer;
                    break;
                }
                break;
            case 43:
                if (this.image == null) {
                    this.image = new StringBuffer();
                }
                this.image.append(this.input_stream.GetSuffix(this.jjimageLen));
                this.jjimageLen = 0;
                commentNest++;
                return;
            case 44:
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
        }
        this.image.append(this.input_stream.GetSuffix(this.jjimageLen));
        this.jjimageLen = 0;
        this.image.deleteCharAt(stringBuffer2.length() - 2);
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
        if (i < 3 && i >= 0) {
            this.curLexState = i;
            return;
        }
        throw new TokenMgrError("Error: Ignoring invalid lexical state : " + i + ". State unchanged.", 2);
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
                            }
                        }
                    }
                }
            } catch (IOException unused2) {
                this.jjmatchedKind = 0;
                Token jjFillToken3 = jjFillToken();
                jjFillToken3.specialToken = token;
                return jjFillToken3;
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
            str = i3 <= 1 ? "" : this.input_stream.GetImage();
        }
        throw new TokenMgrError(z, this.curLexState, i, i2, str, this.curChar, 0);
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
