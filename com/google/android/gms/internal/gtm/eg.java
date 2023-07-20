package com.google.android.gms.internal.gtm;

import java.nio.ByteBuffer;

/* loaded from: classes.dex */
final class eg extends ed {
    private static int a(byte[] bArr, int i, long j, int i2) {
        int b;
        int b2;
        int b3;
        switch (i2) {
            case 0:
                b = eb.b(i);
                return b;
            case 1:
                b2 = eb.b(i, dz.a(bArr, j));
                return b2;
            case 2:
                b3 = eb.b(i, dz.a(bArr, j), dz.a(bArr, j + 1));
                return b3;
            default:
                throw new AssertionError();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x0061, code lost:
        return -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x00b9, code lost:
        return -1;
     */
    @Override // com.google.android.gms.internal.gtm.ed
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    final int a(int i, byte[] bArr, int i2, int i3) {
        int i4;
        long j;
        long j2;
        if ((i2 | i3 | (bArr.length - i3)) >= 0) {
            long j3 = i2;
            int i5 = (int) (i3 - j3);
            if (i5 >= 16) {
                long j4 = j3;
                i4 = 0;
                while (true) {
                    if (i4 >= i5) {
                        i4 = i5;
                        break;
                    }
                    long j5 = j4 + 1;
                    if (dz.a(bArr, j4) < 0) {
                        break;
                    }
                    i4++;
                    j4 = j5;
                }
            } else {
                i4 = 0;
            }
            int i6 = i5 - i4;
            long j6 = j3 + i4;
            while (true) {
                byte b = 0;
                while (true) {
                    if (i6 <= 0) {
                        j = j6;
                        break;
                    }
                    j = j6 + 1;
                    b = dz.a(bArr, j6);
                    if (b < 0) {
                        break;
                    }
                    i6--;
                    j6 = j;
                }
                if (i6 == 0) {
                    return 0;
                }
                int i7 = i6 - 1;
                if (b >= -32) {
                    if (b >= -16) {
                        if (i7 >= 3) {
                            i6 = i7 - 3;
                            long j7 = j + 1;
                            byte a = dz.a(bArr, j);
                            if (a > -65 || (((b << 28) + (a + 112)) >> 30) != 0) {
                                break;
                            }
                            long j8 = j7 + 1;
                            if (dz.a(bArr, j7) > -65) {
                                break;
                            }
                            j2 = j8 + 1;
                            if (dz.a(bArr, j8) > -65) {
                                break;
                            }
                        } else {
                            return a(bArr, b, j, i7);
                        }
                    } else if (i7 >= 2) {
                        i6 = i7 - 2;
                        long j9 = j + 1;
                        byte a2 = dz.a(bArr, j);
                        if (a2 > -65 || ((b == -32 && a2 < -96) || (b == -19 && a2 >= -96))) {
                            break;
                        }
                        long j10 = j9 + 1;
                        if (dz.a(bArr, j9) > -65) {
                            break;
                        }
                        j6 = j10;
                    } else {
                        return a(bArr, b, j, i7);
                    }
                } else if (i7 != 0) {
                    i6 = i7 - 1;
                    if (b < -62) {
                        break;
                    }
                    j2 = j + 1;
                    if (dz.a(bArr, j) > -65) {
                        break;
                    }
                } else {
                    return b;
                }
                j6 = j2;
            }
            return -1;
        }
        throw new ArrayIndexOutOfBoundsException(String.format("Array length=%d, index=%d, limit=%d", Integer.valueOf(bArr.length), Integer.valueOf(i2), Integer.valueOf(i3)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.gtm.ed
    public final int a(CharSequence charSequence, byte[] bArr, int i, int i2) {
        long j;
        int i3;
        char c;
        char charAt;
        long j2 = i;
        long j3 = i2 + j2;
        int length = charSequence.length();
        if (length > i2 || bArr.length - i2 < i) {
            char charAt2 = charSequence.charAt(length - 1);
            StringBuilder sb = new StringBuilder(37);
            sb.append("Failed writing ");
            sb.append(charAt2);
            sb.append(" at index ");
            sb.append(i + i2);
            throw new ArrayIndexOutOfBoundsException(sb.toString());
        }
        int i4 = 0;
        while (i4 < length && (charAt = charSequence.charAt(i4)) < 128) {
            dz.a(bArr, j2, (byte) charAt);
            i4++;
            j2 = 1 + j2;
        }
        if (i4 == length) {
            return (int) j2;
        }
        while (i4 < length) {
            char charAt3 = charSequence.charAt(i4);
            if (charAt3 >= 128 || j2 >= j3) {
                if (charAt3 < 2048 && j2 <= j3 - 2) {
                    long j4 = j2 + 1;
                    dz.a(bArr, j2, (byte) ((charAt3 >>> 6) | 960));
                    j2 = j4 + 1;
                    dz.a(bArr, j4, (byte) ((charAt3 & '?') | 128));
                } else if ((charAt3 >= 55296 && 57343 >= charAt3) || j2 > j3 - 3) {
                    if (j2 > j3 - 4) {
                        if (55296 <= charAt3 && charAt3 <= 57343 && ((i3 = i4 + 1) == length || !Character.isSurrogatePair(charAt3, charSequence.charAt(i3)))) {
                            throw new ef(i4, length);
                        }
                        StringBuilder sb2 = new StringBuilder(46);
                        sb2.append("Failed writing ");
                        sb2.append(charAt3);
                        sb2.append(" at index ");
                        sb2.append(j2);
                        throw new ArrayIndexOutOfBoundsException(sb2.toString());
                    }
                    int i5 = i4 + 1;
                    if (i5 != length) {
                        char charAt4 = charSequence.charAt(i5);
                        if (Character.isSurrogatePair(charAt3, charAt4)) {
                            int codePoint = Character.toCodePoint(charAt3, charAt4);
                            long j5 = j2 + 1;
                            dz.a(bArr, j2, (byte) ((codePoint >>> 18) | 240));
                            long j6 = j5 + 1;
                            dz.a(bArr, j5, (byte) (((codePoint >>> 12) & 63) | 128));
                            long j7 = j6 + 1;
                            dz.a(bArr, j6, (byte) (((codePoint >>> 6) & 63) | 128));
                            j2 = j7 + 1;
                            dz.a(bArr, j7, (byte) ((codePoint & 63) | 128));
                            i4 = i5;
                        }
                    } else {
                        i5 = i4;
                    }
                    throw new ef(i5 - 1, length);
                } else {
                    long j8 = j2 + 1;
                    dz.a(bArr, j2, (byte) ((charAt3 >>> '\f') | 480));
                    j2 = j8 + 1;
                    dz.a(bArr, j8, (byte) (((charAt3 >>> 6) & 63) | 128));
                    j = j2 + 1;
                    c = (charAt3 & '?') | 128;
                }
                i4++;
            } else {
                j = j2 + 1;
                c = charAt3;
            }
            dz.a(bArr, j2, (byte) c);
            j2 = j;
            i4++;
        }
        return (int) j2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.gtm.ed
    public final void a(CharSequence charSequence, ByteBuffer byteBuffer) {
        char c;
        long j;
        long j2;
        long j3;
        int i;
        char charAt;
        long a = dz.a(byteBuffer);
        long position = byteBuffer.position() + a;
        long limit = byteBuffer.limit() + a;
        int length = charSequence.length();
        if (length > limit - position) {
            char charAt2 = charSequence.charAt(length - 1);
            int limit2 = byteBuffer.limit();
            StringBuilder sb = new StringBuilder(37);
            sb.append("Failed writing ");
            sb.append(charAt2);
            sb.append(" at index ");
            sb.append(limit2);
            throw new ArrayIndexOutOfBoundsException(sb.toString());
        }
        int i2 = 0;
        while (true) {
            c = 128;
            j = 1;
            if (i2 >= length || (charAt = charSequence.charAt(i2)) >= 128) {
                break;
            }
            dz.a(position, (byte) charAt);
            i2++;
            position++;
        }
        if (i2 != length) {
            while (i2 < length) {
                char charAt3 = charSequence.charAt(i2);
                if (charAt3 < c && position < limit) {
                    j2 = position + j;
                    dz.a(position, (byte) charAt3);
                } else if (charAt3 < 2048 && position <= limit - 2) {
                    long j4 = position + j;
                    dz.a(position, (byte) ((charAt3 >>> 6) | 960));
                    dz.a(j4, (byte) ((charAt3 & '?') | 128));
                    j2 = j4 + j;
                } else if ((charAt3 >= 55296 && 57343 >= charAt3) || position > limit - 3) {
                    if (position > limit - 4) {
                        if (55296 <= charAt3 && charAt3 <= 57343 && ((i = i2 + 1) == length || !Character.isSurrogatePair(charAt3, charSequence.charAt(i)))) {
                            throw new ef(i2, length);
                        }
                        StringBuilder sb2 = new StringBuilder(46);
                        sb2.append("Failed writing ");
                        sb2.append(charAt3);
                        sb2.append(" at index ");
                        sb2.append(position);
                        throw new ArrayIndexOutOfBoundsException(sb2.toString());
                    }
                    int i3 = i2 + 1;
                    if (i3 != length) {
                        char charAt4 = charSequence.charAt(i3);
                        if (Character.isSurrogatePair(charAt3, charAt4)) {
                            int codePoint = Character.toCodePoint(charAt3, charAt4);
                            long j5 = position + 1;
                            dz.a(position, (byte) ((codePoint >>> 18) | 240));
                            long j6 = j5 + 1;
                            dz.a(j5, (byte) (((codePoint >>> 12) & 63) | 128));
                            long j7 = j6 + 1;
                            dz.a(j6, (byte) (((codePoint >>> 6) & 63) | 128));
                            j3 = 1;
                            dz.a(j7, (byte) ((codePoint & 63) | 128));
                            i2 = i3;
                            j2 = j7 + 1;
                            i2++;
                            j = j3;
                            position = j2;
                            c = 128;
                        } else {
                            i2 = i3;
                        }
                    }
                    throw new ef(i2 - 1, length);
                } else {
                    long j8 = position + j;
                    dz.a(position, (byte) ((charAt3 >>> '\f') | 480));
                    long j9 = j8 + j;
                    dz.a(j8, (byte) (((charAt3 >>> 6) & 63) | 128));
                    dz.a(j9, (byte) ((charAt3 & '?') | 128));
                    j2 = j9 + 1;
                    j3 = 1;
                    i2++;
                    j = j3;
                    position = j2;
                    c = 128;
                }
                j3 = j;
                i2++;
                j = j3;
                position = j2;
                c = 128;
            }
        }
        byteBuffer.position((int) (position - a));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.gtm.ed
    public final String b(byte[] bArr, int i, int i2) {
        boolean d;
        boolean d2;
        boolean e;
        boolean f;
        boolean d3;
        if ((i | i2 | ((bArr.length - i) - i2)) >= 0) {
            int i3 = i + i2;
            char[] cArr = new char[i2];
            int i4 = 0;
            while (i < i3) {
                byte a = dz.a(bArr, i);
                d3 = ec.d(a);
                if (!d3) {
                    break;
                }
                i++;
                ec.b(a, cArr, i4);
                i4++;
            }
            int i5 = i4;
            while (i < i3) {
                int i6 = i + 1;
                byte a2 = dz.a(bArr, i);
                d = ec.d(a2);
                if (d) {
                    int i7 = i5 + 1;
                    ec.b(a2, cArr, i5);
                    while (i6 < i3) {
                        byte a3 = dz.a(bArr, i6);
                        d2 = ec.d(a3);
                        if (!d2) {
                            break;
                        }
                        i6++;
                        ec.b(a3, cArr, i7);
                        i7++;
                    }
                    i = i6;
                    i5 = i7;
                } else {
                    e = ec.e(a2);
                    if (!e) {
                        f = ec.f(a2);
                        if (f) {
                            if (i6 >= i3 - 1) {
                                throw zzrk.h();
                            }
                            int i8 = i6 + 1;
                            ec.b(a2, dz.a(bArr, i6), dz.a(bArr, i8), cArr, i5);
                            i = i8 + 1;
                            i5++;
                        } else if (i6 >= i3 - 2) {
                            throw zzrk.h();
                        } else {
                            int i9 = i6 + 1;
                            int i10 = i9 + 1;
                            ec.b(a2, dz.a(bArr, i6), dz.a(bArr, i9), dz.a(bArr, i10), cArr, i5);
                            i = i10 + 1;
                            i5 = i5 + 1 + 1;
                        }
                    } else if (i6 >= i3) {
                        throw zzrk.h();
                    } else {
                        ec.b(a2, dz.a(bArr, i6), cArr, i5);
                        i = i6 + 1;
                        i5++;
                    }
                }
            }
            return new String(cArr, 0, i5);
        }
        throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", Integer.valueOf(bArr.length), Integer.valueOf(i), Integer.valueOf(i2)));
    }
}
