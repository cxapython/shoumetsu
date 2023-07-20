package com.google.android.gms.common.server.response;

import android.util.Log;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.server.response.FastJsonResponse;
import com.google.android.gms.common.util.Base64Utils;
import com.google.android.gms.common.util.JsonUtils;
import com.google.android.gms.nearby.messages.BleSignal;
import cz.msebera.android.httpclient.message.TokenParser;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

@ShowFirstParty
@KeepForSdk
/* loaded from: classes.dex */
public class FastParser<T extends FastJsonResponse> {
    private static final char[] f = {'u', 'l', 'l'};
    private static final char[] g = {'r', 'u', 'e'};
    private static final char[] h = {'r', 'u', 'e', TokenParser.DQUOTE};
    private static final char[] i = {'a', 'l', 's', 'e'};
    private static final char[] j = {'a', 'l', 's', 'e', TokenParser.DQUOTE};
    private static final char[] k = {'\n'};
    private static final a<Integer> m = new com.google.android.gms.common.server.response.a();
    private static final a<Long> n = new b();
    private static final a<Float> o = new c();
    private static final a<Double> p = new d();
    private static final a<Boolean> q = new e();
    private static final a<String> r = new f();
    private static final a<BigInteger> s = new g();
    private static final a<BigDecimal> t = new h();
    private final char[] a = new char[1];
    private final char[] b = new char[32];
    private final char[] c = new char[1024];
    private final StringBuilder d = new StringBuilder(32);
    private final StringBuilder e = new StringBuilder(1024);
    private final Stack<Integer> l = new Stack<>();

    @ShowFirstParty
    @KeepForSdk
    /* loaded from: classes.dex */
    public static class ParseException extends Exception {
        public ParseException(String str) {
            super(str);
        }

        public ParseException(String str, Throwable th) {
            super(str, th);
        }

        public ParseException(Throwable th) {
            super(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public interface a<O> {
        O a(FastParser fastParser, BufferedReader bufferedReader);
    }

    private final int a(BufferedReader bufferedReader, char[] cArr) {
        int i2;
        char j2 = j(bufferedReader);
        if (j2 != 0) {
            if (j2 == ',') {
                throw new ParseException("Missing value");
            }
            if (j2 == 'n') {
                b(bufferedReader, f);
                return 0;
            }
            bufferedReader.mark(1024);
            if (j2 == '\"') {
                i2 = 0;
                boolean z = false;
                while (i2 < cArr.length && bufferedReader.read(cArr, i2, 1) != -1) {
                    char c = cArr[i2];
                    if (Character.isISOControl(c)) {
                        throw new ParseException("Unexpected control character while reading string");
                    }
                    if (c == '\"' && !z) {
                        bufferedReader.reset();
                        bufferedReader.skip(i2 + 1);
                        return i2;
                    }
                    z = c == '\\' ? !z : false;
                    i2++;
                }
            } else {
                cArr[0] = j2;
                i2 = 1;
                while (i2 < cArr.length && bufferedReader.read(cArr, i2, 1) != -1) {
                    if (cArr[i2] == '}' || cArr[i2] == ',' || Character.isWhitespace(cArr[i2]) || cArr[i2] == ']') {
                        bufferedReader.reset();
                        bufferedReader.skip(i2 - 1);
                        cArr[i2] = 0;
                        return i2;
                    }
                    i2++;
                }
            }
            if (i2 != cArr.length) {
                throw new ParseException("Unexpected EOF");
            }
            throw new ParseException("Absurdly long value");
        }
        throw new ParseException("Unexpected EOF");
    }

    private final String a(BufferedReader bufferedReader) {
        this.l.push(2);
        char j2 = j(bufferedReader);
        if (j2 == '\"') {
            this.l.push(3);
            String b = b(bufferedReader, this.b, this.d, null);
            a(3);
            if (j(bufferedReader) != ':') {
                throw new ParseException("Expected key/value separator");
            }
            return b;
        } else if (j2 == ']') {
            a(2);
            a(1);
            a(5);
            return null;
        } else if (j2 == '}') {
            a(2);
            return null;
        } else {
            StringBuilder sb = new StringBuilder(19);
            sb.append("Unexpected token: ");
            sb.append(j2);
            throw new ParseException(sb.toString());
        }
    }

    private final String a(BufferedReader bufferedReader, char[] cArr, StringBuilder sb, char[] cArr2) {
        char j2 = j(bufferedReader);
        if (j2 != '\"') {
            if (j2 != 'n') {
                throw new ParseException("Expected string");
            }
            b(bufferedReader, f);
            return null;
        }
        return b(bufferedReader, cArr, sb, cArr2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final <T extends FastJsonResponse> ArrayList<T> a(BufferedReader bufferedReader, FastJsonResponse.Field<?, ?> field) {
        ArrayList<T> arrayList = (ArrayList<T>) new ArrayList();
        char j2 = j(bufferedReader);
        if (j2 == ']') {
            a(5);
            return arrayList;
        } else if (j2 == 'n') {
            b(bufferedReader, f);
            a(5);
            return null;
        } else if (j2 != '{') {
            StringBuilder sb = new StringBuilder(19);
            sb.append("Unexpected token: ");
            sb.append(j2);
            throw new ParseException(sb.toString());
        } else {
            Stack<Integer> stack = this.l;
            while (true) {
                stack.push(1);
                try {
                    FastJsonResponse zacp = field.zacp();
                    if (!a(bufferedReader, zacp)) {
                        return arrayList;
                    }
                    arrayList.add(zacp);
                    char j3 = j(bufferedReader);
                    if (j3 != ',') {
                        if (j3 == ']') {
                            a(5);
                            return arrayList;
                        }
                        StringBuilder sb2 = new StringBuilder(19);
                        sb2.append("Unexpected token: ");
                        sb2.append(j3);
                        throw new ParseException(sb2.toString());
                    } else if (j(bufferedReader) != '{') {
                        throw new ParseException("Expected start of next object in array");
                    } else {
                        stack = this.l;
                    }
                } catch (IllegalAccessException e) {
                    throw new ParseException("Error instantiating inner object", e);
                } catch (InstantiationException e2) {
                    throw new ParseException("Error instantiating inner object", e2);
                }
            }
        }
    }

    private final <O> ArrayList<O> a(BufferedReader bufferedReader, a<O> aVar) {
        char j2 = j(bufferedReader);
        if (j2 == 'n') {
            b(bufferedReader, f);
            return null;
        } else if (j2 != '[') {
            throw new ParseException("Expected start of array");
        } else {
            this.l.push(5);
            ArrayList<O> arrayList = new ArrayList<>();
            while (true) {
                bufferedReader.mark(1024);
                char j3 = j(bufferedReader);
                if (j3 == 0) {
                    throw new ParseException("Unexpected EOF");
                }
                if (j3 != ',') {
                    if (j3 == ']') {
                        a(5);
                        return arrayList;
                    }
                    bufferedReader.reset();
                    arrayList.add(aVar.a(this, bufferedReader));
                }
            }
        }
    }

    private final void a(int i2) {
        if (this.l.isEmpty()) {
            StringBuilder sb = new StringBuilder(46);
            sb.append("Expected state ");
            sb.append(i2);
            sb.append(" but had empty stack");
            throw new ParseException(sb.toString());
        }
        int intValue = this.l.pop().intValue();
        if (intValue == i2) {
            return;
        }
        StringBuilder sb2 = new StringBuilder(46);
        sb2.append("Expected state ");
        sb2.append(i2);
        sb2.append(" but had ");
        sb2.append(intValue);
        throw new ParseException(sb2.toString());
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final boolean a(BufferedReader bufferedReader, FastJsonResponse fastJsonResponse) {
        byte[] decode;
        HashMap hashMap;
        Map<String, FastJsonResponse.Field<?, ?>> fieldMappings = fastJsonResponse.getFieldMappings();
        String a2 = a(bufferedReader);
        if (a2 == null) {
            a(1);
            return false;
        }
        while (a2 != null) {
            FastJsonResponse.Field<?, ?> field = fieldMappings.get(a2);
            if (field == null) {
                a2 = b(bufferedReader);
            } else {
                this.l.push(4);
                switch (field.a) {
                    case 0:
                        if (!field.b) {
                            fastJsonResponse.zaa((FastJsonResponse.Field) field, d(bufferedReader));
                            break;
                        } else {
                            fastJsonResponse.zaa((FastJsonResponse.Field) field, (ArrayList<Integer>) a(bufferedReader, m));
                            break;
                        }
                    case 1:
                        if (!field.b) {
                            fastJsonResponse.zaa(field, f(bufferedReader));
                            break;
                        } else {
                            fastJsonResponse.zab(field, a(bufferedReader, s));
                            break;
                        }
                    case 2:
                        if (!field.b) {
                            fastJsonResponse.zaa((FastJsonResponse.Field) field, e(bufferedReader));
                            break;
                        } else {
                            fastJsonResponse.zac(field, a(bufferedReader, n));
                            break;
                        }
                    case 3:
                        if (!field.b) {
                            fastJsonResponse.zaa((FastJsonResponse.Field) field, g(bufferedReader));
                            break;
                        } else {
                            fastJsonResponse.zad(field, a(bufferedReader, o));
                            break;
                        }
                    case 4:
                        if (!field.b) {
                            fastJsonResponse.zaa(field, h(bufferedReader));
                            break;
                        } else {
                            fastJsonResponse.zae(field, a(bufferedReader, p));
                            break;
                        }
                    case 5:
                        if (!field.b) {
                            fastJsonResponse.zaa(field, i(bufferedReader));
                            break;
                        } else {
                            fastJsonResponse.zaf(field, a(bufferedReader, t));
                            break;
                        }
                    case 6:
                        if (!field.b) {
                            fastJsonResponse.zaa(field, a(bufferedReader, false));
                            break;
                        } else {
                            fastJsonResponse.zag(field, a(bufferedReader, q));
                            break;
                        }
                    case 7:
                        if (!field.b) {
                            fastJsonResponse.zaa(field, c(bufferedReader));
                            break;
                        } else {
                            fastJsonResponse.zah(field, a(bufferedReader, r));
                            break;
                        }
                    case 8:
                        decode = Base64Utils.decode(a(bufferedReader, this.c, this.e, k));
                        fastJsonResponse.zaa(field, decode);
                        break;
                    case 9:
                        decode = Base64Utils.decodeUrlSafe(a(bufferedReader, this.c, this.e, k));
                        fastJsonResponse.zaa(field, decode);
                        break;
                    case 10:
                        char j2 = j(bufferedReader);
                        if (j2 == 'n') {
                            b(bufferedReader, f);
                            hashMap = null;
                        } else if (j2 != '{') {
                            throw new ParseException("Expected start of a map object");
                        } else {
                            this.l.push(1);
                            hashMap = new HashMap();
                            while (true) {
                                char j3 = j(bufferedReader);
                                if (j3 == 0) {
                                    throw new ParseException("Unexpected EOF");
                                }
                                if (j3 == '\"') {
                                    String b = b(bufferedReader, this.b, this.d, null);
                                    if (j(bufferedReader) != ':') {
                                        String valueOf = String.valueOf(b);
                                        throw new ParseException(valueOf.length() != 0 ? "No map value found for key ".concat(valueOf) : new String("No map value found for key "));
                                    } else if (j(bufferedReader) != '\"') {
                                        String valueOf2 = String.valueOf(b);
                                        throw new ParseException(valueOf2.length() != 0 ? "Expected String value for key ".concat(valueOf2) : new String("Expected String value for key "));
                                    } else {
                                        hashMap.put(b, b(bufferedReader, this.b, this.d, null));
                                        char j4 = j(bufferedReader);
                                        if (j4 != ',') {
                                            if (j4 != '}') {
                                                StringBuilder sb = new StringBuilder(48);
                                                sb.append("Unexpected character while parsing string map: ");
                                                sb.append(j4);
                                                throw new ParseException(sb.toString());
                                            }
                                        }
                                    }
                                } else if (j3 != '}') {
                                }
                            }
                            a(1);
                        }
                        fastJsonResponse.zaa(field, hashMap);
                        break;
                    case 11:
                        if (field.b) {
                            char j5 = j(bufferedReader);
                            if (j5 == 'n') {
                                b(bufferedReader, f);
                                fastJsonResponse.addConcreteTypeArrayInternal(field, field.e, null);
                                break;
                            } else {
                                this.l.push(5);
                                if (j5 != '[') {
                                    throw new ParseException("Expected array start");
                                }
                                fastJsonResponse.addConcreteTypeArrayInternal(field, field.e, a(bufferedReader, field));
                                break;
                            }
                        } else {
                            char j6 = j(bufferedReader);
                            if (j6 == 'n') {
                                b(bufferedReader, f);
                                fastJsonResponse.addConcreteTypeInternal(field, field.e, null);
                                break;
                            } else {
                                this.l.push(1);
                                if (j6 != '{') {
                                    throw new ParseException("Expected start of object");
                                }
                                try {
                                    FastJsonResponse zacp = field.zacp();
                                    a(bufferedReader, zacp);
                                    fastJsonResponse.addConcreteTypeInternal(field, field.e, zacp);
                                    break;
                                } catch (IllegalAccessException e) {
                                    throw new ParseException("Error instantiating inner object", e);
                                } catch (InstantiationException e2) {
                                    throw new ParseException("Error instantiating inner object", e2);
                                }
                            }
                        }
                    default:
                        int i2 = field.a;
                        StringBuilder sb2 = new StringBuilder(30);
                        sb2.append("Invalid field type ");
                        sb2.append(i2);
                        throw new ParseException(sb2.toString());
                }
                a(4);
                a(2);
                char j7 = j(bufferedReader);
                if (j7 == ',') {
                    a2 = a(bufferedReader);
                } else if (j7 != '}') {
                    StringBuilder sb3 = new StringBuilder(55);
                    sb3.append("Expected end of object or field separator, but found: ");
                    sb3.append(j7);
                    throw new ParseException(sb3.toString());
                } else {
                    a2 = null;
                }
            }
        }
        a(1);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean a(BufferedReader bufferedReader, boolean z) {
        while (true) {
            char j2 = j(bufferedReader);
            if (j2 != '\"') {
                if (j2 == 'f') {
                    b(bufferedReader, z ? j : i);
                    return false;
                } else if (j2 == 'n') {
                    b(bufferedReader, f);
                    return false;
                } else if (j2 == 't') {
                    b(bufferedReader, z ? h : g);
                    return true;
                } else {
                    StringBuilder sb = new StringBuilder(19);
                    sb.append("Unexpected token: ");
                    sb.append(j2);
                    throw new ParseException(sb.toString());
                }
            } else if (z) {
                throw new ParseException("No boolean value found in string");
            } else {
                z = true;
            }
        }
    }

    private final String b(BufferedReader bufferedReader) {
        bufferedReader.mark(1024);
        char j2 = j(bufferedReader);
        if (j2 == '\"') {
            if (bufferedReader.read(this.a) == -1) {
                throw new ParseException("Unexpected EOF while parsing string");
            }
            char c = this.a[0];
            boolean z = false;
            do {
                if (c != '\"' || z) {
                    z = c == '\\' ? !z : false;
                    if (bufferedReader.read(this.a) == -1) {
                        throw new ParseException("Unexpected EOF while parsing string");
                    }
                    c = this.a[0];
                }
            } while (!Character.isISOControl(c));
            throw new ParseException("Unexpected control character while reading string");
        } else if (j2 == ',') {
            throw new ParseException("Missing value");
        } else {
            int i2 = 1;
            if (j2 == '[') {
                this.l.push(5);
                bufferedReader.mark(32);
                if (j(bufferedReader) != ']') {
                    bufferedReader.reset();
                    boolean z2 = false;
                    boolean z3 = false;
                    while (i2 > 0) {
                        char j3 = j(bufferedReader);
                        if (j3 == 0) {
                            throw new ParseException("Unexpected EOF while parsing array");
                        }
                        if (Character.isISOControl(j3)) {
                            throw new ParseException("Unexpected control character while reading array");
                        }
                        if (j3 == '\"' && !z2) {
                            z3 = !z3;
                        }
                        if (j3 == '[' && !z3) {
                            i2++;
                        }
                        if (j3 == ']' && !z3) {
                            i2--;
                        }
                        z2 = (j3 != '\\' || !z3) ? false : !z2;
                    }
                }
                a(5);
            } else if (j2 != '{') {
                bufferedReader.reset();
                a(bufferedReader, this.c);
            } else {
                this.l.push(1);
                bufferedReader.mark(32);
                char j4 = j(bufferedReader);
                if (j4 == '}') {
                    a(1);
                } else if (j4 != '\"') {
                    StringBuilder sb = new StringBuilder(18);
                    sb.append("Unexpected token ");
                    sb.append(j4);
                    throw new ParseException(sb.toString());
                } else {
                    bufferedReader.reset();
                    a(bufferedReader);
                    do {
                    } while (b(bufferedReader) != null);
                    a(1);
                }
            }
        }
        char j5 = j(bufferedReader);
        if (j5 == ',') {
            a(2);
            return a(bufferedReader);
        } else if (j5 == '}') {
            a(2);
            return null;
        } else {
            StringBuilder sb2 = new StringBuilder(18);
            sb2.append("Unexpected token ");
            sb2.append(j5);
            throw new ParseException(sb2.toString());
        }
    }

    private static String b(BufferedReader bufferedReader, char[] cArr, StringBuilder sb, char[] cArr2) {
        boolean z;
        sb.setLength(0);
        bufferedReader.mark(cArr.length);
        boolean z2 = false;
        boolean z3 = false;
        while (true) {
            int read = bufferedReader.read(cArr);
            if (read != -1) {
                boolean z4 = z3;
                boolean z5 = z2;
                for (int i2 = 0; i2 < read; i2++) {
                    char c = cArr[i2];
                    if (Character.isISOControl(c)) {
                        if (cArr2 != null) {
                            for (char c2 : cArr2) {
                                if (c2 == c) {
                                    z = true;
                                    break;
                                }
                            }
                        }
                        z = false;
                        if (!z) {
                            throw new ParseException("Unexpected control character while reading string");
                        }
                    }
                    if (c == '\"' && !z5) {
                        sb.append(cArr, 0, i2);
                        bufferedReader.reset();
                        bufferedReader.skip(i2 + 1);
                        return z4 ? JsonUtils.unescapeString(sb.toString()) : sb.toString();
                    }
                    if (c == '\\') {
                        z5 = !z5;
                        z4 = true;
                    } else {
                        z5 = false;
                    }
                }
                sb.append(cArr, 0, read);
                bufferedReader.mark(cArr.length);
                z2 = z5;
                z3 = z4;
            } else {
                throw new ParseException("Unexpected EOF while parsing string");
            }
        }
    }

    private final void b(BufferedReader bufferedReader, char[] cArr) {
        int i2 = 0;
        while (i2 < cArr.length) {
            int read = bufferedReader.read(this.b, 0, cArr.length - i2);
            if (read == -1) {
                throw new ParseException("Unexpected EOF");
            }
            for (int i3 = 0; i3 < read; i3++) {
                if (cArr[i3 + i2] != this.b[i3]) {
                    throw new ParseException("Unexpected character");
                }
            }
            i2 += read;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String c(BufferedReader bufferedReader) {
        return a(bufferedReader, this.b, this.d, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int d(BufferedReader bufferedReader) {
        int i2;
        boolean z;
        int i3;
        int i4;
        int i5;
        int a2 = a(bufferedReader, this.c);
        if (a2 == 0) {
            return 0;
        }
        char[] cArr = this.c;
        if (a2 <= 0) {
            throw new ParseException("No number to parse");
        }
        if (cArr[0] == '-') {
            i2 = 1;
            z = true;
            i3 = BleSignal.UNKNOWN_TX_POWER;
        } else {
            i2 = 0;
            z = false;
            i3 = -2147483647;
        }
        if (i2 < a2) {
            i4 = i2 + 1;
            int digit = Character.digit(cArr[i2], 10);
            if (digit < 0) {
                throw new ParseException("Unexpected non-digit character");
            }
            i5 = -digit;
        } else {
            i4 = i2;
            i5 = 0;
        }
        while (i4 < a2) {
            int i6 = i4 + 1;
            int digit2 = Character.digit(cArr[i4], 10);
            if (digit2 < 0) {
                throw new ParseException("Unexpected non-digit character");
            }
            if (i5 < -214748364) {
                throw new ParseException("Number too large");
            }
            int i7 = i5 * 10;
            if (i7 < i3 + digit2) {
                throw new ParseException("Number too large");
            }
            i5 = i7 - digit2;
            i4 = i6;
        }
        if (!z) {
            return -i5;
        }
        if (i4 <= 1) {
            throw new ParseException("No digits to parse");
        }
        return i5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long e(BufferedReader bufferedReader) {
        long j2;
        boolean z;
        long j3;
        int i2;
        int a2 = a(bufferedReader, this.c);
        if (a2 == 0) {
            return 0L;
        }
        char[] cArr = this.c;
        if (a2 <= 0) {
            throw new ParseException("No number to parse");
        }
        int i3 = 0;
        if (cArr[0] == '-') {
            j2 = Long.MIN_VALUE;
            i3 = 1;
            z = true;
        } else {
            j2 = -9223372036854775807L;
            z = false;
        }
        if (i3 < a2) {
            i2 = i3 + 1;
            int digit = Character.digit(cArr[i3], 10);
            if (digit < 0) {
                throw new ParseException("Unexpected non-digit character");
            }
            j3 = -digit;
        } else {
            j3 = 0;
            i2 = i3;
        }
        while (i2 < a2) {
            int i4 = i2 + 1;
            int digit2 = Character.digit(cArr[i2], 10);
            if (digit2 < 0) {
                throw new ParseException("Unexpected non-digit character");
            }
            if (j3 < -922337203685477580L) {
                throw new ParseException("Number too large");
            }
            long j4 = j3 * 10;
            long j5 = digit2;
            if (j4 < j2 + j5) {
                throw new ParseException("Number too large");
            }
            j3 = j4 - j5;
            i2 = i4;
        }
        if (!z) {
            return -j3;
        }
        if (i2 <= 1) {
            throw new ParseException("No digits to parse");
        }
        return j3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final BigInteger f(BufferedReader bufferedReader) {
        int a2 = a(bufferedReader, this.c);
        if (a2 == 0) {
            return null;
        }
        return new BigInteger(new String(this.c, 0, a2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final float g(BufferedReader bufferedReader) {
        int a2 = a(bufferedReader, this.c);
        if (a2 == 0) {
            return 0.0f;
        }
        return Float.parseFloat(new String(this.c, 0, a2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final double h(BufferedReader bufferedReader) {
        int a2 = a(bufferedReader, this.c);
        if (a2 == 0) {
            return 0.0d;
        }
        return Double.parseDouble(new String(this.c, 0, a2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final BigDecimal i(BufferedReader bufferedReader) {
        int a2 = a(bufferedReader, this.c);
        if (a2 == 0) {
            return null;
        }
        return new BigDecimal(new String(this.c, 0, a2));
    }

    private final char j(BufferedReader bufferedReader) {
        if (bufferedReader.read(this.a) == -1) {
            return (char) 0;
        }
        while (Character.isWhitespace(this.a[0])) {
            if (bufferedReader.read(this.a) == -1) {
                return (char) 0;
            }
        }
        return this.a[0];
    }

    @KeepForSdk
    public void parse(InputStream inputStream, T t2) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream), 1024);
        try {
            try {
                this.l.push(0);
                char j2 = j(bufferedReader);
                if (j2 == 0) {
                    throw new ParseException("No data to parse");
                }
                if (j2 == '[') {
                    this.l.push(5);
                    Map<String, FastJsonResponse.Field<?, ?>> fieldMappings = t2.getFieldMappings();
                    if (fieldMappings.size() != 1) {
                        throw new ParseException("Object array response class must have a single Field");
                    }
                    FastJsonResponse.Field<?, ?> value = fieldMappings.entrySet().iterator().next().getValue();
                    t2.addConcreteTypeArrayInternal(value, value.e, a(bufferedReader, value));
                } else if (j2 != '{') {
                    StringBuilder sb = new StringBuilder(19);
                    sb.append("Unexpected token: ");
                    sb.append(j2);
                    throw new ParseException(sb.toString());
                } else {
                    this.l.push(1);
                    a(bufferedReader, t2);
                }
                a(0);
                try {
                    bufferedReader.close();
                } catch (IOException unused) {
                    Log.w("FastParser", "Failed to close reader while parsing.");
                }
            } catch (IOException e) {
                throw new ParseException(e);
            }
        } catch (Throwable th) {
            try {
                bufferedReader.close();
            } catch (IOException unused2) {
                Log.w("FastParser", "Failed to close reader while parsing.");
            }
            throw th;
        }
    }
}
