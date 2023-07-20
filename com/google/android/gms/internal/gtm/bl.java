package com.google.android.gms.internal.gtm;

import java.util.Arrays;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class bl extends zzqe {
    private final byte[] d;
    private final boolean e;
    private int f;
    private int g;
    private int h;
    private int i;
    private int j;
    private int k;

    private bl(byte[] bArr, int i, int i2, boolean z) {
        super();
        this.k = Integer.MAX_VALUE;
        this.d = bArr;
        this.f = i2 + i;
        this.h = i;
        this.i = this.h;
        this.e = z;
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0066, code lost:
        if (r2[r3] >= 0) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final int b() {
        int i;
        int i2 = this.h;
        int i3 = this.f;
        if (i3 != i2) {
            byte[] bArr = this.d;
            int i4 = i2 + 1;
            byte b = bArr[i2];
            if (b >= 0) {
                this.h = i4;
                return b;
            } else if (i3 - i4 >= 9) {
                int i5 = i4 + 1;
                int i6 = b ^ (bArr[i4] << 7);
                if (i6 < 0) {
                    i = i6 ^ (-128);
                } else {
                    int i7 = i5 + 1;
                    int i8 = i6 ^ (bArr[i5] << 14);
                    if (i8 >= 0) {
                        i = i8 ^ 16256;
                    } else {
                        i5 = i7 + 1;
                        int i9 = i8 ^ (bArr[i7] << 21);
                        if (i9 < 0) {
                            i = i9 ^ (-2080896);
                        } else {
                            i7 = i5 + 1;
                            byte b2 = bArr[i5];
                            i = (i9 ^ (b2 << 28)) ^ 266354560;
                            if (b2 < 0) {
                                i5 = i7 + 1;
                                if (bArr[i7] < 0) {
                                    i7 = i5 + 1;
                                    if (bArr[i5] < 0) {
                                        i5 = i7 + 1;
                                        if (bArr[i7] < 0) {
                                            i7 = i5 + 1;
                                            if (bArr[i5] < 0) {
                                                i5 = i7 + 1;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    i5 = i7;
                }
                this.h = i5;
                return i;
            }
        }
        return (int) a();
    }

    /* JADX WARN: Code restructure failed: missing block: B:37:0x00b0, code lost:
        if (r2[r0] >= 0) goto L40;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final long c() {
        long j;
        long j2;
        long j3;
        int i;
        int i2 = this.h;
        int i3 = this.f;
        if (i3 != i2) {
            byte[] bArr = this.d;
            int i4 = i2 + 1;
            byte b = bArr[i2];
            if (b >= 0) {
                this.h = i4;
                return b;
            } else if (i3 - i4 >= 9) {
                int i5 = i4 + 1;
                int i6 = b ^ (bArr[i4] << 7);
                if (i6 >= 0) {
                    int i7 = i5 + 1;
                    int i8 = i6 ^ (bArr[i5] << 14);
                    if (i8 >= 0) {
                        i5 = i7;
                        j = i8 ^ 16256;
                    } else {
                        i5 = i7 + 1;
                        int i9 = i8 ^ (bArr[i7] << 21);
                        if (i9 < 0) {
                            i = i9 ^ (-2080896);
                        } else {
                            long j4 = i9;
                            int i10 = i5 + 1;
                            long j5 = j4 ^ (bArr[i5] << 28);
                            if (j5 >= 0) {
                                j3 = 266354560;
                            } else {
                                i5 = i10 + 1;
                                long j6 = j5 ^ (bArr[i10] << 35);
                                if (j6 < 0) {
                                    j2 = -34093383808L;
                                } else {
                                    i10 = i5 + 1;
                                    j5 = j6 ^ (bArr[i5] << 42);
                                    if (j5 >= 0) {
                                        j3 = 4363953127296L;
                                    } else {
                                        i5 = i10 + 1;
                                        j6 = j5 ^ (bArr[i10] << 49);
                                        if (j6 < 0) {
                                            j2 = -558586000294016L;
                                        } else {
                                            int i11 = i5 + 1;
                                            long j7 = (j6 ^ (bArr[i5] << 56)) ^ 71499008037633920L;
                                            i5 = j7 < 0 ? i11 + 1 : i11;
                                            j = j7;
                                        }
                                    }
                                }
                                j = j6 ^ j2;
                            }
                            j = j5 ^ j3;
                            i5 = i10;
                        }
                    }
                    this.h = i5;
                    return j;
                }
                i = i6 ^ (-128);
                j = i;
                this.h = i5;
                return j;
            }
        }
        return a();
    }

    private final int d() {
        int i = this.h;
        if (this.f - i >= 4) {
            byte[] bArr = this.d;
            this.h = i + 4;
            return ((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
        }
        throw zzrk.a();
    }

    private final long e() {
        int i = this.h;
        if (this.f - i >= 8) {
            byte[] bArr = this.d;
            this.h = i + 8;
            return ((bArr[i + 7] & 255) << 56) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16) | ((bArr[i + 3] & 255) << 24) | ((bArr[i + 4] & 255) << 32) | ((bArr[i + 5] & 255) << 40) | ((bArr[i + 6] & 255) << 48);
        }
        throw zzrk.a();
    }

    private final void f() {
        this.f += this.g;
        int i = this.f;
        int i2 = i - this.i;
        int i3 = this.k;
        if (i2 <= i3) {
            this.g = 0;
            return;
        }
        this.g = i2 - i3;
        this.f = i - this.g;
    }

    private final byte g() {
        int i = this.h;
        if (i != this.f) {
            byte[] bArr = this.d;
            this.h = i + 1;
            return bArr[i];
        }
        throw zzrk.a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.gtm.zzqe
    public final long a() {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            byte g = g();
            j |= (g & Byte.MAX_VALUE) << i;
            if ((g & 128) == 0) {
                return j;
            }
        }
        throw zzrk.c();
    }

    @Override // com.google.android.gms.internal.gtm.zzqe
    public final double readDouble() {
        return Double.longBitsToDouble(e());
    }

    @Override // com.google.android.gms.internal.gtm.zzqe
    public final float readFloat() {
        return Float.intBitsToFloat(d());
    }

    @Override // com.google.android.gms.internal.gtm.zzqe
    public final String readString() {
        int b = b();
        if (b > 0) {
            int i = this.f;
            int i2 = this.h;
            if (b <= i - i2) {
                String str = new String(this.d, i2, b, zzre.a);
                this.h += b;
                return str;
            }
        }
        if (b == 0) {
            return "";
        }
        if (b >= 0) {
            throw zzrk.a();
        }
        throw zzrk.b();
    }

    @Override // com.google.android.gms.internal.gtm.zzqe
    public final <T extends zzsk> T zza(zzsu<T> zzsuVar, zzqp zzqpVar) {
        int b = b();
        if (this.a < this.b) {
            int zzaq = zzaq(b);
            this.a++;
            T zza = zzsuVar.zza(this, zzqpVar);
            zzan(0);
            this.a--;
            zzar(zzaq);
            return zza;
        }
        throw zzrk.f();
    }

    @Override // com.google.android.gms.internal.gtm.zzqe
    public final void zzan(int i) {
        if (this.j == i) {
            return;
        }
        throw zzrk.d();
    }

    @Override // com.google.android.gms.internal.gtm.zzqe
    public final boolean zzao(int i) {
        int zzni;
        int i2 = 0;
        switch (i & 7) {
            case 0:
                if (this.f - this.h < 10) {
                    while (i2 < 10) {
                        if (g() < 0) {
                            i2++;
                        }
                    }
                    throw zzrk.c();
                }
                while (i2 < 10) {
                    byte[] bArr = this.d;
                    int i3 = this.h;
                    this.h = i3 + 1;
                    if (bArr[i3] < 0) {
                        i2++;
                    }
                }
                throw zzrk.c();
                return true;
            case 1:
                zzas(8);
                return true;
            case 2:
                zzas(b());
                return true;
            case 3:
                break;
            case 4:
                return false;
            case 5:
                zzas(4);
                return true;
            default:
                throw zzrk.e();
        }
        do {
            zzni = zzni();
            if (zzni != 0) {
            }
            zzan(((i >>> 3) << 3) | 4);
            return true;
        } while (zzao(zzni));
        zzan(((i >>> 3) << 3) | 4);
        return true;
    }

    @Override // com.google.android.gms.internal.gtm.zzqe
    public final int zzaq(int i) {
        if (i >= 0) {
            int zznz = i + zznz();
            int i2 = this.k;
            if (zznz > i2) {
                throw zzrk.a();
            }
            this.k = zznz;
            f();
            return i2;
        }
        throw zzrk.b();
    }

    @Override // com.google.android.gms.internal.gtm.zzqe
    public final void zzar(int i) {
        this.k = i;
        f();
    }

    @Override // com.google.android.gms.internal.gtm.zzqe
    public final void zzas(int i) {
        if (i >= 0) {
            int i2 = this.f;
            int i3 = this.h;
            if (i <= i2 - i3) {
                this.h = i3 + i;
                return;
            }
        }
        if (i < 0) {
            throw zzrk.b();
        }
        throw zzrk.a();
    }

    @Override // com.google.android.gms.internal.gtm.zzqe
    public final int zzni() {
        if (zzny()) {
            this.j = 0;
            return 0;
        }
        this.j = b();
        int i = this.j;
        if ((i >>> 3) == 0) {
            throw new zzrk("Protocol message contained an invalid tag (zero).");
        }
        return i;
    }

    @Override // com.google.android.gms.internal.gtm.zzqe
    public final long zznj() {
        return c();
    }

    @Override // com.google.android.gms.internal.gtm.zzqe
    public final long zznk() {
        return c();
    }

    @Override // com.google.android.gms.internal.gtm.zzqe
    public final int zznl() {
        return b();
    }

    @Override // com.google.android.gms.internal.gtm.zzqe
    public final long zznm() {
        return e();
    }

    @Override // com.google.android.gms.internal.gtm.zzqe
    public final int zznn() {
        return d();
    }

    @Override // com.google.android.gms.internal.gtm.zzqe
    public final boolean zzno() {
        return c() != 0;
    }

    @Override // com.google.android.gms.internal.gtm.zzqe
    public final String zznp() {
        int b = b();
        if (b > 0) {
            int i = this.f;
            int i2 = this.h;
            if (b <= i - i2) {
                String b2 = eb.b(this.d, i2, b);
                this.h += b;
                return b2;
            }
        }
        if (b == 0) {
            return "";
        }
        if (b > 0) {
            throw zzrk.a();
        }
        throw zzrk.b();
    }

    @Override // com.google.android.gms.internal.gtm.zzqe
    public final zzps zznq() {
        byte[] bArr;
        int b = b();
        if (b > 0) {
            int i = this.f;
            int i2 = this.h;
            if (b <= i - i2) {
                zzps zzb = zzps.zzb(this.d, i2, b);
                this.h += b;
                return zzb;
            }
        }
        if (b == 0) {
            return zzps.zzavx;
        }
        if (b > 0) {
            int i3 = this.f;
            int i4 = this.h;
            if (b <= i3 - i4) {
                this.h = b + i4;
                bArr = Arrays.copyOfRange(this.d, i4, this.h);
                return zzps.a(bArr);
            }
        }
        if (b > 0) {
            throw zzrk.a();
        }
        if (b != 0) {
            throw zzrk.b();
        }
        bArr = zzre.zzbbh;
        return zzps.a(bArr);
    }

    @Override // com.google.android.gms.internal.gtm.zzqe
    public final int zznr() {
        return b();
    }

    @Override // com.google.android.gms.internal.gtm.zzqe
    public final int zzns() {
        return b();
    }

    @Override // com.google.android.gms.internal.gtm.zzqe
    public final int zznt() {
        return d();
    }

    @Override // com.google.android.gms.internal.gtm.zzqe
    public final long zznu() {
        return e();
    }

    @Override // com.google.android.gms.internal.gtm.zzqe
    public final int zznv() {
        int b = b();
        return (-(b & 1)) ^ (b >>> 1);
    }

    @Override // com.google.android.gms.internal.gtm.zzqe
    public final long zznw() {
        long c = c();
        return (-(c & 1)) ^ (c >>> 1);
    }

    @Override // com.google.android.gms.internal.gtm.zzqe
    public final boolean zzny() {
        return this.h == this.f;
    }

    @Override // com.google.android.gms.internal.gtm.zzqe
    public final int zznz() {
        return this.h - this.i;
    }
}
