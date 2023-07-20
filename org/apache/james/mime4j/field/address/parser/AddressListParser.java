package org.apache.james.mime4j.field.address.parser;

import java.io.InputStream;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.util.Enumeration;
import java.util.Vector;

/* loaded from: classes.dex */
public class AddressListParser implements AddressListParserConstants, AddressListParserTreeConstants {
    private static int[] jj_la1_0;
    private static int[] jj_la1_1;
    private final JJCalls[] jj_2_rtns;
    private int jj_endpos;
    private Vector<int[]> jj_expentries;
    private int[] jj_expentry;
    private int jj_gc;
    private int jj_gen;
    SimpleCharStream jj_input_stream;
    private int jj_kind;
    private int jj_la;
    private final int[] jj_la1;
    private Token jj_lastpos;
    private int[] jj_lasttokens;
    private final LookaheadSuccess jj_ls;
    public Token jj_nt;
    private int jj_ntk;
    private boolean jj_rescan;
    private Token jj_scanpos;
    private boolean jj_semLA;
    protected JJTAddressListParserState jjtree;
    public boolean lookingAhead;
    public Token token;
    public AddressListParserTokenManager token_source;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class JJCalls {
        int arg;
        Token first;
        int gen;
        JJCalls next;

        JJCalls() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class LookaheadSuccess extends Error {
        private LookaheadSuccess() {
        }
    }

    static {
        jj_la1_0();
        jj_la1_1();
    }

    public AddressListParser(InputStream inputStream) {
        this(inputStream, null);
    }

    public AddressListParser(InputStream inputStream, String str) {
        this.jjtree = new JJTAddressListParserState();
        int i = 0;
        this.lookingAhead = false;
        this.jj_la1 = new int[22];
        this.jj_2_rtns = new JJCalls[2];
        this.jj_rescan = false;
        this.jj_gc = 0;
        this.jj_ls = new LookaheadSuccess();
        this.jj_expentries = new Vector<>();
        this.jj_kind = -1;
        this.jj_lasttokens = new int[100];
        try {
            this.jj_input_stream = new SimpleCharStream(inputStream, str, 1, 1);
            this.token_source = new AddressListParserTokenManager(this.jj_input_stream);
            this.token = new Token();
            this.jj_ntk = -1;
            this.jj_gen = 0;
            for (int i2 = 0; i2 < 22; i2++) {
                this.jj_la1[i2] = -1;
            }
            while (true) {
                JJCalls[] jJCallsArr = this.jj_2_rtns;
                if (i >= jJCallsArr.length) {
                    return;
                }
                jJCallsArr[i] = new JJCalls();
                i++;
            }
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    public AddressListParser(Reader reader) {
        this.jjtree = new JJTAddressListParserState();
        int i = 0;
        this.lookingAhead = false;
        this.jj_la1 = new int[22];
        this.jj_2_rtns = new JJCalls[2];
        this.jj_rescan = false;
        this.jj_gc = 0;
        this.jj_ls = new LookaheadSuccess();
        this.jj_expentries = new Vector<>();
        this.jj_kind = -1;
        this.jj_lasttokens = new int[100];
        this.jj_input_stream = new SimpleCharStream(reader, 1, 1);
        this.token_source = new AddressListParserTokenManager(this.jj_input_stream);
        this.token = new Token();
        this.jj_ntk = -1;
        this.jj_gen = 0;
        for (int i2 = 0; i2 < 22; i2++) {
            this.jj_la1[i2] = -1;
        }
        while (true) {
            JJCalls[] jJCallsArr = this.jj_2_rtns;
            if (i < jJCallsArr.length) {
                jJCallsArr[i] = new JJCalls();
                i++;
            } else {
                return;
            }
        }
    }

    public AddressListParser(AddressListParserTokenManager addressListParserTokenManager) {
        this.jjtree = new JJTAddressListParserState();
        int i = 0;
        this.lookingAhead = false;
        this.jj_la1 = new int[22];
        this.jj_2_rtns = new JJCalls[2];
        this.jj_rescan = false;
        this.jj_gc = 0;
        this.jj_ls = new LookaheadSuccess();
        this.jj_expentries = new Vector<>();
        this.jj_kind = -1;
        this.jj_lasttokens = new int[100];
        this.token_source = addressListParserTokenManager;
        this.token = new Token();
        this.jj_ntk = -1;
        this.jj_gen = 0;
        for (int i2 = 0; i2 < 22; i2++) {
            this.jj_la1[i2] = -1;
        }
        while (true) {
            JJCalls[] jJCallsArr = this.jj_2_rtns;
            if (i < jJCallsArr.length) {
                jJCallsArr[i] = new JJCalls();
                i++;
            } else {
                return;
            }
        }
    }

    private final boolean jj_2_1(int i) {
        this.jj_la = i;
        Token token = this.token;
        this.jj_scanpos = token;
        this.jj_lastpos = token;
        try {
            return true ^ jj_3_1();
        } catch (LookaheadSuccess unused) {
            return true;
        } finally {
            jj_save(0, i);
        }
    }

    private final boolean jj_2_2(int i) {
        this.jj_la = i;
        Token token = this.token;
        this.jj_scanpos = token;
        this.jj_lastpos = token;
        try {
            return !jj_3_2();
        } catch (LookaheadSuccess unused) {
            return true;
        } finally {
            jj_save(1, i);
        }
    }

    private final boolean jj_3R_10() {
        Token token = this.jj_scanpos;
        if (jj_3R_12()) {
            this.jj_scanpos = token;
            return jj_scan_token(18);
        }
        return false;
    }

    private final boolean jj_3R_11() {
        Token token = this.jj_scanpos;
        if (jj_scan_token(9)) {
            this.jj_scanpos = token;
        }
        Token token2 = this.jj_scanpos;
        if (jj_scan_token(14)) {
            this.jj_scanpos = token2;
            return jj_scan_token(31);
        }
        return false;
    }

    private final boolean jj_3R_12() {
        Token token;
        if (jj_scan_token(14)) {
            return true;
        }
        do {
            token = this.jj_scanpos;
        } while (!jj_3R_13());
        this.jj_scanpos = token;
        return false;
    }

    private final boolean jj_3R_13() {
        Token token = this.jj_scanpos;
        if (jj_scan_token(9)) {
            this.jj_scanpos = token;
        }
        return jj_scan_token(14);
    }

    private final boolean jj_3R_8() {
        return jj_3R_9() || jj_scan_token(8) || jj_3R_10();
    }

    private final boolean jj_3R_9() {
        Token token;
        Token token2 = this.jj_scanpos;
        if (jj_scan_token(14)) {
            this.jj_scanpos = token2;
            if (jj_scan_token(31)) {
                return true;
            }
        }
        do {
            token = this.jj_scanpos;
        } while (!jj_3R_11());
        this.jj_scanpos = token;
        return false;
    }

    private final boolean jj_3_1() {
        return jj_3R_8();
    }

    private final boolean jj_3_2() {
        return jj_3R_8();
    }

    private void jj_add_error_token(int i, int i2) {
        if (i2 >= 100) {
            return;
        }
        int i3 = this.jj_endpos;
        if (i2 == i3 + 1) {
            int[] iArr = this.jj_lasttokens;
            this.jj_endpos = i3 + 1;
            iArr[i3] = i;
        } else if (i3 != 0) {
            this.jj_expentry = new int[i3];
            for (int i4 = 0; i4 < this.jj_endpos; i4++) {
                this.jj_expentry[i4] = this.jj_lasttokens[i4];
            }
            Enumeration<int[]> elements = this.jj_expentries.elements();
            boolean z = false;
            while (elements.hasMoreElements()) {
                int[] nextElement = elements.nextElement();
                if (nextElement.length == this.jj_expentry.length) {
                    int i5 = 0;
                    while (true) {
                        int[] iArr2 = this.jj_expentry;
                        if (i5 >= iArr2.length) {
                            z = true;
                            break;
                        } else if (nextElement[i5] != iArr2[i5]) {
                            z = false;
                            break;
                        } else {
                            i5++;
                        }
                    }
                    if (z) {
                        break;
                    }
                }
            }
            if (!z) {
                this.jj_expentries.addElement(this.jj_expentry);
            }
            if (i2 == 0) {
                return;
            }
            int[] iArr3 = this.jj_lasttokens;
            this.jj_endpos = i2;
            iArr3[i2 - 1] = i;
        }
    }

    private final Token jj_consume_token(int i) {
        Token token = this.token;
        if (token.next != null) {
            this.token = this.token.next;
        } else {
            Token token2 = this.token;
            Token nextToken = this.token_source.getNextToken();
            token2.next = nextToken;
            this.token = nextToken;
        }
        this.jj_ntk = -1;
        if (this.token.kind != i) {
            this.token = token;
            this.jj_kind = i;
            throw generateParseException();
        }
        this.jj_gen++;
        int i2 = this.jj_gc + 1;
        this.jj_gc = i2;
        if (i2 > 100) {
            int i3 = 0;
            this.jj_gc = 0;
            while (true) {
                JJCalls[] jJCallsArr = this.jj_2_rtns;
                if (i3 >= jJCallsArr.length) {
                    break;
                }
                for (JJCalls jJCalls = jJCallsArr[i3]; jJCalls != null; jJCalls = jJCalls.next) {
                    if (jJCalls.gen < this.jj_gen) {
                        jJCalls.first = null;
                    }
                }
                i3++;
            }
        }
        return this.token;
    }

    private static void jj_la1_0() {
        jj_la1_0 = new int[]{2, -2147467200, 8, -2147467200, 80, -2147467200, -2147467200, -2147467200, 8, -2147467200, 256, 264, 8, -2147467264, -2147467264, -2147467264, -2147466752, 512, -2147467264, 16896, 512, 278528};
    }

    private static void jj_la1_1() {
        jj_la1_1 = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    }

    private final int jj_ntk() {
        int i;
        Token token = this.token.next;
        this.jj_nt = token;
        if (token == null) {
            Token token2 = this.token;
            Token nextToken = this.token_source.getNextToken();
            token2.next = nextToken;
            i = nextToken.kind;
        } else {
            i = this.jj_nt.kind;
        }
        this.jj_ntk = i;
        return i;
    }

    private final void jj_rescan_token() {
        this.jj_rescan = true;
        for (int i = 0; i < 2; i++) {
            try {
                JJCalls jJCalls = this.jj_2_rtns[i];
                do {
                    if (jJCalls.gen > this.jj_gen) {
                        this.jj_la = jJCalls.arg;
                        Token token = jJCalls.first;
                        this.jj_scanpos = token;
                        this.jj_lastpos = token;
                        switch (i) {
                            case 0:
                                jj_3_1();
                                break;
                            case 1:
                                jj_3_2();
                                break;
                        }
                    }
                    jJCalls = jJCalls.next;
                } while (jJCalls != null);
            } catch (LookaheadSuccess unused) {
            }
        }
        this.jj_rescan = false;
    }

    private final void jj_save(int i, int i2) {
        JJCalls jJCalls = this.jj_2_rtns[i];
        while (true) {
            if (jJCalls.gen <= this.jj_gen) {
                break;
            } else if (jJCalls.next == null) {
                JJCalls jJCalls2 = new JJCalls();
                jJCalls.next = jJCalls2;
                jJCalls = jJCalls2;
                break;
            } else {
                jJCalls = jJCalls.next;
            }
        }
        jJCalls.gen = (this.jj_gen + i2) - this.jj_la;
        jJCalls.first = this.token;
        jJCalls.arg = i2;
    }

    private final boolean jj_scan_token(int i) {
        Token token = this.jj_scanpos;
        if (token == this.jj_lastpos) {
            this.jj_la--;
            if (token.next == null) {
                Token token2 = this.jj_scanpos;
                Token nextToken = this.token_source.getNextToken();
                token2.next = nextToken;
                this.jj_scanpos = nextToken;
                this.jj_lastpos = nextToken;
            } else {
                Token token3 = this.jj_scanpos.next;
                this.jj_scanpos = token3;
                this.jj_lastpos = token3;
            }
        } else {
            this.jj_scanpos = token.next;
        }
        if (this.jj_rescan) {
            Token token4 = this.token;
            int i2 = 0;
            while (token4 != null && token4 != this.jj_scanpos) {
                i2++;
                token4 = token4.next;
            }
            if (token4 != null) {
                jj_add_error_token(i, i2);
            }
        }
        if (this.jj_scanpos.kind != i) {
            return true;
        }
        if (this.jj_la != 0 || this.jj_scanpos != this.jj_lastpos) {
            return false;
        }
        throw this.jj_ls;
    }

    public static void main(String[] strArr) {
        while (true) {
            try {
                AddressListParser addressListParser = new AddressListParser(System.in);
                addressListParser.parseLine();
                ((SimpleNode) addressListParser.jjtree.rootNode()).dump("> ");
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
    }

    public void ReInit(InputStream inputStream) {
        ReInit(inputStream, null);
    }

    public void ReInit(InputStream inputStream, String str) {
        try {
            this.jj_input_stream.ReInit(inputStream, str, 1, 1);
            this.token_source.ReInit(this.jj_input_stream);
            this.token = new Token();
            this.jj_ntk = -1;
            this.jjtree.reset();
            int i = 0;
            this.jj_gen = 0;
            for (int i2 = 0; i2 < 22; i2++) {
                this.jj_la1[i2] = -1;
            }
            while (true) {
                JJCalls[] jJCallsArr = this.jj_2_rtns;
                if (i >= jJCallsArr.length) {
                    return;
                }
                jJCallsArr[i] = new JJCalls();
                i++;
            }
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    public void ReInit(Reader reader) {
        this.jj_input_stream.ReInit(reader, 1, 1);
        this.token_source.ReInit(this.jj_input_stream);
        this.token = new Token();
        this.jj_ntk = -1;
        this.jjtree.reset();
        int i = 0;
        this.jj_gen = 0;
        for (int i2 = 0; i2 < 22; i2++) {
            this.jj_la1[i2] = -1;
        }
        while (true) {
            JJCalls[] jJCallsArr = this.jj_2_rtns;
            if (i < jJCallsArr.length) {
                jJCallsArr[i] = new JJCalls();
                i++;
            } else {
                return;
            }
        }
    }

    public void ReInit(AddressListParserTokenManager addressListParserTokenManager) {
        this.token_source = addressListParserTokenManager;
        this.token = new Token();
        this.jj_ntk = -1;
        this.jjtree.reset();
        int i = 0;
        this.jj_gen = 0;
        for (int i2 = 0; i2 < 22; i2++) {
            this.jj_la1[i2] = -1;
        }
        while (true) {
            JJCalls[] jJCallsArr = this.jj_2_rtns;
            if (i < jJCallsArr.length) {
                jJCallsArr[i] = new JJCalls();
                i++;
            } else {
                return;
            }
        }
    }

    public final void addr_spec() {
        boolean z;
        ASTaddr_spec aSTaddr_spec = new ASTaddr_spec(9);
        this.jjtree.openNodeScope(aSTaddr_spec);
        jjtreeOpenNodeScope(aSTaddr_spec);
        try {
            local_part();
            jj_consume_token(8);
            domain();
            this.jjtree.closeNodeScope((Node) aSTaddr_spec, true);
            jjtreeCloseNodeScope(aSTaddr_spec);
        } catch (Throwable th) {
            try {
                this.jjtree.clearNodeScope(aSTaddr_spec);
                z = false;
                try {
                    if (th instanceof RuntimeException) {
                        throw ((RuntimeException) th);
                    }
                    if (!(th instanceof ParseException)) {
                        throw ((Error) th);
                    }
                    throw ((ParseException) th);
                } catch (Throwable th2) {
                    th = th2;
                    if (z) {
                        this.jjtree.closeNodeScope((Node) aSTaddr_spec, true);
                        jjtreeCloseNodeScope(aSTaddr_spec);
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                z = true;
            }
        }
    }

    public final void address() {
        boolean z;
        ASTaddress aSTaddress = new ASTaddress(2);
        this.jjtree.openNodeScope(aSTaddress);
        jjtreeOpenNodeScope(aSTaddress);
        try {
            if (jj_2_1(Integer.MAX_VALUE)) {
                addr_spec();
            } else {
                int jj_ntk = this.jj_ntk == -1 ? jj_ntk() : this.jj_ntk;
                if (jj_ntk != 6) {
                    if (jj_ntk != 14 && jj_ntk != 31) {
                        this.jj_la1[5] = this.jj_gen;
                        jj_consume_token(-1);
                        throw new ParseException();
                    }
                    phrase();
                    int jj_ntk2 = this.jj_ntk == -1 ? jj_ntk() : this.jj_ntk;
                    if (jj_ntk2 == 4) {
                        group_body();
                    } else if (jj_ntk2 != 6) {
                        this.jj_la1[4] = this.jj_gen;
                        jj_consume_token(-1);
                        throw new ParseException();
                    }
                }
                angle_addr();
            }
            this.jjtree.closeNodeScope((Node) aSTaddress, true);
            jjtreeCloseNodeScope(aSTaddress);
        } catch (Throwable th) {
            try {
                this.jjtree.clearNodeScope(aSTaddress);
                z = false;
            } catch (Throwable th2) {
                th = th2;
                z = true;
            }
            try {
                if (th instanceof RuntimeException) {
                    throw ((RuntimeException) th);
                }
                if (!(th instanceof ParseException)) {
                    throw ((Error) th);
                }
                throw ((ParseException) th);
            } catch (Throwable th3) {
                th = th3;
                if (z) {
                    this.jjtree.closeNodeScope((Node) aSTaddress, true);
                    jjtreeCloseNodeScope(aSTaddress);
                }
                throw th;
            }
        }
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:56)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:30)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:18)
        */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0033 A[Catch: Throwable -> 0x006b, TryCatch #0 {Throwable -> 0x006b, blocks: (B:3:0x000e, B:5:0x0013, B:11:0x0025, B:13:0x002f, B:15:0x0033, B:19:0x003d, B:22:0x004d, B:24:0x0054, B:29:0x0061, B:25:0x0059, B:16:0x0038, B:12:0x002c, B:6:0x0018), top: B:50:0x000e }] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0038 A[Catch: Throwable -> 0x006b, TryCatch #0 {Throwable -> 0x006b, blocks: (B:3:0x000e, B:5:0x0013, B:11:0x0025, B:13:0x002f, B:15:0x0033, B:19:0x003d, B:22:0x004d, B:24:0x0054, B:29:0x0061, B:25:0x0059, B:16:0x0038, B:12:0x002c, B:6:0x0018), top: B:50:0x000e }] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x004d A[Catch: Throwable -> 0x006b, TRY_ENTER, TryCatch #0 {Throwable -> 0x006b, blocks: (B:3:0x000e, B:5:0x0013, B:11:0x0025, B:13:0x002f, B:15:0x0033, B:19:0x003d, B:22:0x004d, B:24:0x0054, B:29:0x0061, B:25:0x0059, B:16:0x0038, B:12:0x002c, B:6:0x0018), top: B:50:0x000e }] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x003d A[SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x002c -> B:13:0x002f). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void address_list() {
        /*
            r9 = this;
            org.apache.james.mime4j.field.address.parser.ASTaddress_list r0 = new org.apache.james.mime4j.field.address.parser.ASTaddress_list
            r1 = 1
            r0.<init>(r1)
            org.apache.james.mime4j.field.address.parser.JJTAddressListParserState r2 = r9.jjtree
            r2.openNodeScope(r0)
            r9.jjtreeOpenNodeScope(r0)
            int r2 = r9.jj_ntk     // Catch: java.lang.Throwable -> L6b
            r3 = -1
            if (r2 != r3) goto L18
            int r2 = r9.jj_ntk()     // Catch: java.lang.Throwable -> L6b
            goto L1a
        L18:
            int r2 = r9.jj_ntk     // Catch: java.lang.Throwable -> L6b
        L1a:
            r4 = 31
            r5 = 14
            r6 = 6
            if (r2 == r6) goto L2c
            if (r2 == r5) goto L2c
            if (r2 == r4) goto L2c
            int[] r2 = r9.jj_la1     // Catch: java.lang.Throwable -> L6b
            int r7 = r9.jj_gen     // Catch: java.lang.Throwable -> L6b
            r2[r1] = r7     // Catch: java.lang.Throwable -> L6b
            goto L2f
        L2c:
            r9.address()     // Catch: java.lang.Throwable -> L6b
        L2f:
            int r2 = r9.jj_ntk     // Catch: java.lang.Throwable -> L6b
            if (r2 != r3) goto L38
            int r2 = r9.jj_ntk()     // Catch: java.lang.Throwable -> L6b
            goto L3a
        L38:
            int r2 = r9.jj_ntk     // Catch: java.lang.Throwable -> L6b
        L3a:
            r7 = 3
            if (r2 == r7) goto L4d
            int[] r2 = r9.jj_la1     // Catch: java.lang.Throwable -> L6b
            r3 = 2
            int r4 = r9.jj_gen     // Catch: java.lang.Throwable -> L6b
            r2[r3] = r4     // Catch: java.lang.Throwable -> L6b
            org.apache.james.mime4j.field.address.parser.JJTAddressListParserState r2 = r9.jjtree
            r2.closeNodeScope(r0, r1)
            r9.jjtreeCloseNodeScope(r0)
            return
        L4d:
            r9.jj_consume_token(r7)     // Catch: java.lang.Throwable -> L6b
            int r2 = r9.jj_ntk     // Catch: java.lang.Throwable -> L6b
            if (r2 != r3) goto L59
            int r2 = r9.jj_ntk()     // Catch: java.lang.Throwable -> L6b
            goto L5b
        L59:
            int r2 = r9.jj_ntk     // Catch: java.lang.Throwable -> L6b
        L5b:
            if (r2 == r6) goto L2c
            if (r2 == r5) goto L2c
            if (r2 == r4) goto L2c
            int[] r2 = r9.jj_la1     // Catch: java.lang.Throwable -> L6b
            int r8 = r9.jj_gen     // Catch: java.lang.Throwable -> L6b
            r2[r7] = r8     // Catch: java.lang.Throwable -> L6b
            goto L2f
        L68:
            r2 = move-exception
            r3 = 1
            goto L84
        L6b:
            r2 = move-exception
            org.apache.james.mime4j.field.address.parser.JJTAddressListParserState r3 = r9.jjtree     // Catch: java.lang.Throwable -> L68
            r3.clearNodeScope(r0)     // Catch: java.lang.Throwable -> L68
            r3 = 0
            boolean r4 = r2 instanceof java.lang.RuntimeException     // Catch: java.lang.Throwable -> L83
            if (r4 != 0) goto L80
            boolean r4 = r2 instanceof org.apache.james.mime4j.field.address.parser.ParseException     // Catch: java.lang.Throwable -> L83
            if (r4 == 0) goto L7d
            org.apache.james.mime4j.field.address.parser.ParseException r2 = (org.apache.james.mime4j.field.address.parser.ParseException) r2     // Catch: java.lang.Throwable -> L83
            throw r2     // Catch: java.lang.Throwable -> L83
        L7d:
            java.lang.Error r2 = (java.lang.Error) r2     // Catch: java.lang.Throwable -> L83
            throw r2     // Catch: java.lang.Throwable -> L83
        L80:
            java.lang.RuntimeException r2 = (java.lang.RuntimeException) r2     // Catch: java.lang.Throwable -> L83
            throw r2     // Catch: java.lang.Throwable -> L83
        L83:
            r2 = move-exception
        L84:
            if (r3 == 0) goto L8e
            org.apache.james.mime4j.field.address.parser.JJTAddressListParserState r3 = r9.jjtree
            r3.closeNodeScope(r0, r1)
            r9.jjtreeCloseNodeScope(r0)
        L8e:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.james.mime4j.field.address.parser.AddressListParser.address_list():void");
    }

    public final void angle_addr() {
        boolean z;
        ASTangle_addr aSTangle_addr = new ASTangle_addr(6);
        this.jjtree.openNodeScope(aSTangle_addr);
        jjtreeOpenNodeScope(aSTangle_addr);
        try {
            jj_consume_token(6);
            if ((this.jj_ntk == -1 ? jj_ntk() : this.jj_ntk) != 8) {
                this.jj_la1[10] = this.jj_gen;
            } else {
                route();
            }
            addr_spec();
            jj_consume_token(7);
            this.jjtree.closeNodeScope((Node) aSTangle_addr, true);
            jjtreeCloseNodeScope(aSTangle_addr);
        } catch (Throwable th) {
            try {
                this.jjtree.clearNodeScope(aSTangle_addr);
                z = false;
            } catch (Throwable th2) {
                th = th2;
                z = true;
            }
            try {
                if (th instanceof RuntimeException) {
                    throw ((RuntimeException) th);
                }
                if (!(th instanceof ParseException)) {
                    throw ((Error) th);
                }
                throw ((ParseException) th);
            } catch (Throwable th3) {
                th = th3;
                if (z) {
                    this.jjtree.closeNodeScope((Node) aSTangle_addr, true);
                    jjtreeCloseNodeScope(aSTangle_addr);
                }
                throw th;
            }
        }
    }

    public final void disable_tracing() {
    }

    public final void domain() {
        ASTdomain aSTdomain = new ASTdomain(11);
        this.jjtree.openNodeScope(aSTdomain);
        jjtreeOpenNodeScope(aSTdomain);
        try {
            int jj_ntk = this.jj_ntk == -1 ? jj_ntk() : this.jj_ntk;
            if (jj_ntk == 14) {
                while (true) {
                    Token jj_consume_token = jj_consume_token(14);
                    int jj_ntk2 = this.jj_ntk == -1 ? jj_ntk() : this.jj_ntk;
                    if (jj_ntk2 != 9 && jj_ntk2 != 14) {
                        this.jj_la1[19] = this.jj_gen;
                        break;
                    }
                    if ((this.jj_ntk == -1 ? jj_ntk() : this.jj_ntk) != 9) {
                        this.jj_la1[20] = this.jj_gen;
                    } else {
                        jj_consume_token = jj_consume_token(9);
                    }
                    if (jj_consume_token.image.charAt(jj_consume_token.image.length() - 1) != '.') {
                        throw new ParseException("Atoms in domain names must be separated by '.'");
                    }
                }
            } else if (jj_ntk != 18) {
                this.jj_la1[21] = this.jj_gen;
                jj_consume_token(-1);
                throw new ParseException();
            } else {
                jj_consume_token(18);
            }
        } finally {
            this.jjtree.closeNodeScope((Node) aSTdomain, true);
            jjtreeCloseNodeScope(aSTdomain);
        }
    }

    public final void enable_tracing() {
    }

    public ParseException generateParseException() {
        this.jj_expentries.removeAllElements();
        boolean[] zArr = new boolean[34];
        for (int i = 0; i < 34; i++) {
            zArr[i] = false;
        }
        int i2 = this.jj_kind;
        if (i2 >= 0) {
            zArr[i2] = true;
            this.jj_kind = -1;
        }
        for (int i3 = 0; i3 < 22; i3++) {
            if (this.jj_la1[i3] == this.jj_gen) {
                for (int i4 = 0; i4 < 32; i4++) {
                    int i5 = 1 << i4;
                    if ((jj_la1_0[i3] & i5) != 0) {
                        zArr[i4] = true;
                    }
                    if ((jj_la1_1[i3] & i5) != 0) {
                        zArr[i4 + 32] = true;
                    }
                }
            }
        }
        for (int i6 = 0; i6 < 34; i6++) {
            if (zArr[i6]) {
                this.jj_expentry = new int[1];
                int[] iArr = this.jj_expentry;
                iArr[0] = i6;
                this.jj_expentries.addElement(iArr);
            }
        }
        this.jj_endpos = 0;
        jj_rescan_token();
        jj_add_error_token(0, 0);
        int[][] iArr2 = new int[this.jj_expentries.size()];
        for (int i7 = 0; i7 < this.jj_expentries.size(); i7++) {
            iArr2[i7] = this.jj_expentries.elementAt(i7);
        }
        return new ParseException(this.token, iArr2, tokenImage);
    }

    public final Token getNextToken() {
        if (this.token.next != null) {
            this.token = this.token.next;
        } else {
            Token token = this.token;
            Token nextToken = this.token_source.getNextToken();
            token.next = nextToken;
            this.token = nextToken;
        }
        this.jj_ntk = -1;
        this.jj_gen++;
        return this.token;
    }

    public final Token getToken(int i) {
        Token token = this.lookingAhead ? this.jj_scanpos : this.token;
        for (int i2 = 0; i2 < i; i2++) {
            if (token.next != null) {
                token = token.next;
            } else {
                Token nextToken = this.token_source.getNextToken();
                token.next = nextToken;
                token = nextToken;
            }
        }
        return token;
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:56)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:30)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:18)
        */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0039 A[Catch: Throwable -> 0x0077, TryCatch #1 {Throwable -> 0x0077, blocks: (B:3:0x0010, B:5:0x0018, B:11:0x002a, B:13:0x0035, B:15:0x0039, B:19:0x0043, B:22:0x0057, B:24:0x005e, B:29:0x006b, B:25:0x0063, B:16:0x003e, B:12:0x0032, B:6:0x001d), top: B:52:0x0010 }] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x003e A[Catch: Throwable -> 0x0077, TryCatch #1 {Throwable -> 0x0077, blocks: (B:3:0x0010, B:5:0x0018, B:11:0x002a, B:13:0x0035, B:15:0x0039, B:19:0x0043, B:22:0x0057, B:24:0x005e, B:29:0x006b, B:25:0x0063, B:16:0x003e, B:12:0x0032, B:6:0x001d), top: B:52:0x0010 }] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0057 A[Catch: Throwable -> 0x0077, TRY_ENTER, TryCatch #1 {Throwable -> 0x0077, blocks: (B:3:0x0010, B:5:0x0018, B:11:0x002a, B:13:0x0035, B:15:0x0039, B:19:0x0043, B:22:0x0057, B:24:0x005e, B:29:0x006b, B:25:0x0063, B:16:0x003e, B:12:0x0032, B:6:0x001d), top: B:52:0x0010 }] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0043 A[SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x0032 -> B:13:0x0035). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void group_body() {
        /*
            r10 = this;
            org.apache.james.mime4j.field.address.parser.ASTgroup_body r0 = new org.apache.james.mime4j.field.address.parser.ASTgroup_body
            r1 = 5
            r0.<init>(r1)
            org.apache.james.mime4j.field.address.parser.JJTAddressListParserState r2 = r10.jjtree
            r2.openNodeScope(r0)
            r10.jjtreeOpenNodeScope(r0)
            r2 = 4
            r3 = 1
            r10.jj_consume_token(r2)     // Catch: java.lang.Throwable -> L77
            int r2 = r10.jj_ntk     // Catch: java.lang.Throwable -> L77
            r4 = -1
            if (r2 != r4) goto L1d
            int r2 = r10.jj_ntk()     // Catch: java.lang.Throwable -> L77
            goto L1f
        L1d:
            int r2 = r10.jj_ntk     // Catch: java.lang.Throwable -> L77
        L1f:
            r5 = 31
            r6 = 14
            r7 = 6
            if (r2 == r7) goto L32
            if (r2 == r6) goto L32
            if (r2 == r5) goto L32
            int[] r2 = r10.jj_la1     // Catch: java.lang.Throwable -> L77
            r8 = 7
            int r9 = r10.jj_gen     // Catch: java.lang.Throwable -> L77
            r2[r8] = r9     // Catch: java.lang.Throwable -> L77
            goto L35
        L32:
            r10.mailbox()     // Catch: java.lang.Throwable -> L77
        L35:
            int r2 = r10.jj_ntk     // Catch: java.lang.Throwable -> L77
            if (r2 != r4) goto L3e
            int r2 = r10.jj_ntk()     // Catch: java.lang.Throwable -> L77
            goto L40
        L3e:
            int r2 = r10.jj_ntk     // Catch: java.lang.Throwable -> L77
        L40:
            r8 = 3
            if (r2 == r8) goto L57
            int[] r2 = r10.jj_la1     // Catch: java.lang.Throwable -> L77
            r4 = 8
            int r5 = r10.jj_gen     // Catch: java.lang.Throwable -> L77
            r2[r4] = r5     // Catch: java.lang.Throwable -> L77
            r10.jj_consume_token(r1)     // Catch: java.lang.Throwable -> L77
            org.apache.james.mime4j.field.address.parser.JJTAddressListParserState r1 = r10.jjtree
            r1.closeNodeScope(r0, r3)
            r10.jjtreeCloseNodeScope(r0)
            return
        L57:
            r10.jj_consume_token(r8)     // Catch: java.lang.Throwable -> L77
            int r2 = r10.jj_ntk     // Catch: java.lang.Throwable -> L77
            if (r2 != r4) goto L63
            int r2 = r10.jj_ntk()     // Catch: java.lang.Throwable -> L77
            goto L65
        L63:
            int r2 = r10.jj_ntk     // Catch: java.lang.Throwable -> L77
        L65:
            if (r2 == r7) goto L32
            if (r2 == r6) goto L32
            if (r2 == r5) goto L32
            int[] r2 = r10.jj_la1     // Catch: java.lang.Throwable -> L77
            r8 = 9
            int r9 = r10.jj_gen     // Catch: java.lang.Throwable -> L77
            r2[r8] = r9     // Catch: java.lang.Throwable -> L77
            goto L35
        L74:
            r1 = move-exception
            r2 = 1
            goto L90
        L77:
            r1 = move-exception
            org.apache.james.mime4j.field.address.parser.JJTAddressListParserState r2 = r10.jjtree     // Catch: java.lang.Throwable -> L74
            r2.clearNodeScope(r0)     // Catch: java.lang.Throwable -> L74
            r2 = 0
            boolean r4 = r1 instanceof java.lang.RuntimeException     // Catch: java.lang.Throwable -> L8f
            if (r4 != 0) goto L8c
            boolean r4 = r1 instanceof org.apache.james.mime4j.field.address.parser.ParseException     // Catch: java.lang.Throwable -> L8f
            if (r4 == 0) goto L89
            org.apache.james.mime4j.field.address.parser.ParseException r1 = (org.apache.james.mime4j.field.address.parser.ParseException) r1     // Catch: java.lang.Throwable -> L8f
            throw r1     // Catch: java.lang.Throwable -> L8f
        L89:
            java.lang.Error r1 = (java.lang.Error) r1     // Catch: java.lang.Throwable -> L8f
            throw r1     // Catch: java.lang.Throwable -> L8f
        L8c:
            java.lang.RuntimeException r1 = (java.lang.RuntimeException) r1     // Catch: java.lang.Throwable -> L8f
            throw r1     // Catch: java.lang.Throwable -> L8f
        L8f:
            r1 = move-exception
        L90:
            if (r2 == 0) goto L9a
            org.apache.james.mime4j.field.address.parser.JJTAddressListParserState r2 = r10.jjtree
            r2.closeNodeScope(r0, r3)
            r10.jjtreeCloseNodeScope(r0)
        L9a:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.james.mime4j.field.address.parser.AddressListParser.group_body():void");
    }

    void jjtreeCloseNodeScope(Node node) {
        ((SimpleNode) node).lastToken = getToken(0);
    }

    void jjtreeOpenNodeScope(Node node) {
        ((SimpleNode) node).firstToken = getToken(1);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x003e A[Catch: all -> 0x00bb, TryCatch #0 {all -> 0x00bb, blocks: (B:3:0x0010, B:5:0x0015, B:10:0x0024, B:13:0x003a, B:15:0x003e, B:21:0x004d, B:24:0x005e, B:26:0x0062, B:29:0x006b, B:31:0x0078, B:33:0x007c, B:35:0x008d, B:37:0x0091, B:42:0x009d, B:43:0x00ad, B:38:0x0096, B:45:0x00b3, B:46:0x00ba, B:30:0x0074, B:27:0x0067, B:16:0x0043, B:11:0x0029, B:12:0x0039, B:44:0x00ae, B:6:0x001a), top: B:50:0x0010 }] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0043 A[Catch: all -> 0x00bb, TryCatch #0 {all -> 0x00bb, blocks: (B:3:0x0010, B:5:0x0015, B:10:0x0024, B:13:0x003a, B:15:0x003e, B:21:0x004d, B:24:0x005e, B:26:0x0062, B:29:0x006b, B:31:0x0078, B:33:0x007c, B:35:0x008d, B:37:0x0091, B:42:0x009d, B:43:0x00ad, B:38:0x0096, B:45:0x00b3, B:46:0x00ba, B:30:0x0074, B:27:0x0067, B:16:0x0043, B:11:0x0029, B:12:0x0039, B:44:0x00ae, B:6:0x001a), top: B:50:0x0010 }] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0049 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0062 A[Catch: all -> 0x00bb, TryCatch #0 {all -> 0x00bb, blocks: (B:3:0x0010, B:5:0x0015, B:10:0x0024, B:13:0x003a, B:15:0x003e, B:21:0x004d, B:24:0x005e, B:26:0x0062, B:29:0x006b, B:31:0x0078, B:33:0x007c, B:35:0x008d, B:37:0x0091, B:42:0x009d, B:43:0x00ad, B:38:0x0096, B:45:0x00b3, B:46:0x00ba, B:30:0x0074, B:27:0x0067, B:16:0x0043, B:11:0x0029, B:12:0x0039, B:44:0x00ae, B:6:0x001a), top: B:50:0x0010 }] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0067 A[Catch: all -> 0x00bb, TryCatch #0 {all -> 0x00bb, blocks: (B:3:0x0010, B:5:0x0015, B:10:0x0024, B:13:0x003a, B:15:0x003e, B:21:0x004d, B:24:0x005e, B:26:0x0062, B:29:0x006b, B:31:0x0078, B:33:0x007c, B:35:0x008d, B:37:0x0091, B:42:0x009d, B:43:0x00ad, B:38:0x0096, B:45:0x00b3, B:46:0x00ba, B:30:0x0074, B:27:0x0067, B:16:0x0043, B:11:0x0029, B:12:0x0039, B:44:0x00ae, B:6:0x001a), top: B:50:0x0010 }] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x006b A[Catch: all -> 0x00bb, TryCatch #0 {all -> 0x00bb, blocks: (B:3:0x0010, B:5:0x0015, B:10:0x0024, B:13:0x003a, B:15:0x003e, B:21:0x004d, B:24:0x005e, B:26:0x0062, B:29:0x006b, B:31:0x0078, B:33:0x007c, B:35:0x008d, B:37:0x0091, B:42:0x009d, B:43:0x00ad, B:38:0x0096, B:45:0x00b3, B:46:0x00ba, B:30:0x0074, B:27:0x0067, B:16:0x0043, B:11:0x0029, B:12:0x0039, B:44:0x00ae, B:6:0x001a), top: B:50:0x0010 }] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0074 A[Catch: all -> 0x00bb, TryCatch #0 {all -> 0x00bb, blocks: (B:3:0x0010, B:5:0x0015, B:10:0x0024, B:13:0x003a, B:15:0x003e, B:21:0x004d, B:24:0x005e, B:26:0x0062, B:29:0x006b, B:31:0x0078, B:33:0x007c, B:35:0x008d, B:37:0x0091, B:42:0x009d, B:43:0x00ad, B:38:0x0096, B:45:0x00b3, B:46:0x00ba, B:30:0x0074, B:27:0x0067, B:16:0x0043, B:11:0x0029, B:12:0x0039, B:44:0x00ae, B:6:0x001a), top: B:50:0x0010 }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x007c A[Catch: all -> 0x00bb, TryCatch #0 {all -> 0x00bb, blocks: (B:3:0x0010, B:5:0x0015, B:10:0x0024, B:13:0x003a, B:15:0x003e, B:21:0x004d, B:24:0x005e, B:26:0x0062, B:29:0x006b, B:31:0x0078, B:33:0x007c, B:35:0x008d, B:37:0x0091, B:42:0x009d, B:43:0x00ad, B:38:0x0096, B:45:0x00b3, B:46:0x00ba, B:30:0x0074, B:27:0x0067, B:16:0x0043, B:11:0x0029, B:12:0x0039, B:44:0x00ae, B:6:0x001a), top: B:50:0x0010 }] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:41:0x009c -> B:10:0x0024). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:44:0x00ae -> B:13:0x003a). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void local_part() {
        Token jj_consume_token;
        int jj_ntk;
        ASTlocal_part aSTlocal_part = new ASTlocal_part(10);
        this.jjtree.openNodeScope(aSTlocal_part);
        jjtreeOpenNodeScope(aSTlocal_part);
        try {
            int jj_ntk2 = this.jj_ntk == -1 ? jj_ntk() : this.jj_ntk;
            if (jj_ntk2 != 14) {
                if (jj_ntk2 != 31) {
                    this.jj_la1[15] = this.jj_gen;
                    jj_consume_token(-1);
                    throw new ParseException();
                }
                jj_consume_token = jj_consume_token(31);
                jj_ntk = this.jj_ntk == -1 ? jj_ntk() : this.jj_ntk;
                if (jj_ntk == 9 && jj_ntk != 14 && jj_ntk != 31) {
                    this.jj_la1[16] = this.jj_gen;
                    return;
                }
                if ((this.jj_ntk == -1 ? jj_ntk() : this.jj_ntk) != 9) {
                    this.jj_la1[17] = this.jj_gen;
                } else {
                    jj_consume_token = jj_consume_token(9);
                }
                if (jj_consume_token.kind != 31 || jj_consume_token.image.charAt(jj_consume_token.image.length() - 1) != '.') {
                    throw new ParseException("Words in local part must be separated by '.'");
                }
                int jj_ntk3 = this.jj_ntk == -1 ? jj_ntk() : this.jj_ntk;
                if (jj_ntk3 != 14) {
                    if (jj_ntk3 != 31) {
                        this.jj_la1[18] = this.jj_gen;
                        jj_consume_token(-1);
                        throw new ParseException();
                    }
                    jj_consume_token = jj_consume_token(31);
                    if (this.jj_ntk == -1) {
                    }
                    if (jj_ntk == 9) {
                    }
                    if ((this.jj_ntk == -1 ? jj_ntk() : this.jj_ntk) != 9) {
                    }
                    if (jj_consume_token.kind != 31) {
                    }
                    throw new ParseException("Words in local part must be separated by '.'");
                }
            }
            jj_consume_token = jj_consume_token(14);
            if (this.jj_ntk == -1) {
            }
            if (jj_ntk == 9) {
            }
            if ((this.jj_ntk == -1 ? jj_ntk() : this.jj_ntk) != 9) {
            }
            if (jj_consume_token.kind != 31) {
            }
            throw new ParseException("Words in local part must be separated by '.'");
        } finally {
            this.jjtree.closeNodeScope((Node) aSTlocal_part, true);
            jjtreeCloseNodeScope(aSTlocal_part);
        }
    }

    public final void mailbox() {
        boolean z;
        ASTmailbox aSTmailbox = new ASTmailbox(3);
        this.jjtree.openNodeScope(aSTmailbox);
        jjtreeOpenNodeScope(aSTmailbox);
        try {
            if (jj_2_2(Integer.MAX_VALUE)) {
                addr_spec();
            } else {
                int jj_ntk = this.jj_ntk == -1 ? jj_ntk() : this.jj_ntk;
                if (jj_ntk != 6) {
                    if (jj_ntk != 14 && jj_ntk != 31) {
                        this.jj_la1[6] = this.jj_gen;
                        jj_consume_token(-1);
                        throw new ParseException();
                    }
                    name_addr();
                } else {
                    angle_addr();
                }
            }
            this.jjtree.closeNodeScope((Node) aSTmailbox, true);
            jjtreeCloseNodeScope(aSTmailbox);
        } catch (Throwable th) {
            try {
                this.jjtree.clearNodeScope(aSTmailbox);
                z = false;
                try {
                    if (th instanceof RuntimeException) {
                        throw ((RuntimeException) th);
                    }
                    if (!(th instanceof ParseException)) {
                        throw ((Error) th);
                    }
                    throw ((ParseException) th);
                } catch (Throwable th2) {
                    th = th2;
                    if (z) {
                        this.jjtree.closeNodeScope((Node) aSTmailbox, true);
                        jjtreeCloseNodeScope(aSTmailbox);
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                z = true;
            }
        }
    }

    public final void name_addr() {
        boolean z;
        ASTname_addr aSTname_addr = new ASTname_addr(4);
        this.jjtree.openNodeScope(aSTname_addr);
        jjtreeOpenNodeScope(aSTname_addr);
        try {
            phrase();
            angle_addr();
            this.jjtree.closeNodeScope((Node) aSTname_addr, true);
            jjtreeCloseNodeScope(aSTname_addr);
        } catch (Throwable th) {
            try {
                this.jjtree.clearNodeScope(aSTname_addr);
                z = false;
            } catch (Throwable th2) {
                th = th2;
                z = true;
            }
            try {
                if (th instanceof RuntimeException) {
                    throw ((RuntimeException) th);
                }
                if (!(th instanceof ParseException)) {
                    throw ((Error) th);
                }
                throw ((ParseException) th);
            } catch (Throwable th3) {
                th = th3;
                if (z) {
                    this.jjtree.closeNodeScope((Node) aSTname_addr, true);
                    jjtreeCloseNodeScope(aSTname_addr);
                }
                throw th;
            }
        }
    }

    public ASTaddress parseAddress() {
        try {
            parseAddress0();
            return (ASTaddress) this.jjtree.rootNode();
        } catch (TokenMgrError e) {
            throw new ParseException(e.getMessage());
        }
    }

    public final void parseAddress0() {
        address();
        jj_consume_token(0);
    }

    public ASTaddress_list parseAddressList() {
        try {
            parseAddressList0();
            return (ASTaddress_list) this.jjtree.rootNode();
        } catch (TokenMgrError e) {
            throw new ParseException(e.getMessage());
        }
    }

    public final void parseAddressList0() {
        address_list();
        jj_consume_token(0);
    }

    public final void parseLine() {
        address_list();
        int i = this.jj_ntk;
        if (i == -1) {
            i = jj_ntk();
        }
        if (i != 1) {
            this.jj_la1[0] = this.jj_gen;
        } else {
            jj_consume_token(1);
        }
        jj_consume_token(2);
    }

    public ASTmailbox parseMailbox() {
        try {
            parseMailbox0();
            return (ASTmailbox) this.jjtree.rootNode();
        } catch (TokenMgrError e) {
            throw new ParseException(e.getMessage());
        }
    }

    public final void parseMailbox0() {
        mailbox();
        jj_consume_token(0);
    }

    public final void phrase() {
        ASTphrase aSTphrase = new ASTphrase(8);
        this.jjtree.openNodeScope(aSTphrase);
        jjtreeOpenNodeScope(aSTphrase);
        while (true) {
            try {
                int jj_ntk = this.jj_ntk == -1 ? jj_ntk() : this.jj_ntk;
                if (jj_ntk == 14) {
                    jj_consume_token(14);
                } else if (jj_ntk != 31) {
                    this.jj_la1[13] = this.jj_gen;
                    jj_consume_token(-1);
                    throw new ParseException();
                } else {
                    jj_consume_token(31);
                }
                int jj_ntk2 = this.jj_ntk == -1 ? jj_ntk() : this.jj_ntk;
                if (jj_ntk2 != 14 && jj_ntk2 != 31) {
                    this.jj_la1[14] = this.jj_gen;
                    return;
                }
            } finally {
                this.jjtree.closeNodeScope((Node) aSTphrase, true);
                jjtreeCloseNodeScope(aSTphrase);
            }
        }
    }

    public final void route() {
        boolean z;
        ASTroute aSTroute = new ASTroute(7);
        this.jjtree.openNodeScope(aSTroute);
        jjtreeOpenNodeScope(aSTroute);
        try {
            jj_consume_token(8);
            while (true) {
                domain();
                int jj_ntk = this.jj_ntk == -1 ? jj_ntk() : this.jj_ntk;
                if (jj_ntk != 3 && jj_ntk != 8) {
                    this.jj_la1[11] = this.jj_gen;
                    jj_consume_token(4);
                    this.jjtree.closeNodeScope((Node) aSTroute, true);
                    jjtreeCloseNodeScope(aSTroute);
                    return;
                }
                while (true) {
                    if ((this.jj_ntk == -1 ? jj_ntk() : this.jj_ntk) != 3) {
                        break;
                    }
                    jj_consume_token(3);
                }
                this.jj_la1[12] = this.jj_gen;
                jj_consume_token(8);
            }
        } catch (Throwable th) {
            try {
                this.jjtree.clearNodeScope(aSTroute);
                z = false;
            } catch (Throwable th2) {
                th = th2;
                z = true;
            }
            try {
                if (th instanceof RuntimeException) {
                    throw ((RuntimeException) th);
                }
                if (!(th instanceof ParseException)) {
                    throw ((Error) th);
                }
                throw ((ParseException) th);
            } catch (Throwable th3) {
                th = th3;
                if (z) {
                    this.jjtree.closeNodeScope((Node) aSTroute, true);
                    jjtreeCloseNodeScope(aSTroute);
                }
                throw th;
            }
        }
    }
}
