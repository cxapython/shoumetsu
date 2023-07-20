package com.google.android.gms.internal.gtm;

import java.io.IOException;

/* loaded from: classes.dex */
public final class zzun {
    private final byte[] a;
    private final int b;
    private final int c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int i;
    private zzqe l;
    private int h = Integer.MAX_VALUE;
    private int j = 64;
    private int k = 67108864;

    private zzun(byte[] bArr, int i, int i2) {
        this.a = bArr;
        this.b = i;
        int i3 = i2 + i;
        this.d = i3;
        this.c = i3;
        this.f = i;
    }

    private final zzqe a() {
        if (this.l == null) {
            this.l = zzqe.zzd(this.a, this.b, this.c);
        }
        int zznz = this.l.zznz();
        int i = this.f - this.b;
        if (zznz <= i) {
            this.l.zzas(i - zznz);
            this.l.zzap(this.j - this.i);
            return this.l;
        }
        throw new IOException(String.format("CodedInputStream read ahead of CodedInputByteBufferNano: %s > %s", Integer.valueOf(zznz), Integer.valueOf(i)));
    }

    private final void a(int i) {
        if (i >= 0) {
            int i2 = this.f;
            int i3 = i2 + i;
            int i4 = this.h;
            if (i3 > i4) {
                a(i4 - i2);
                throw zzuv.a();
            } else if (i > this.d - i2) {
                throw zzuv.a();
            } else {
                this.f = i2 + i;
                return;
            }
        }
        throw zzuv.b();
    }

    private final void b() {
        this.d += this.e;
        int i = this.d;
        int i2 = this.h;
        if (i <= i2) {
            this.e = 0;
            return;
        }
        this.e = i - i2;
        this.d = i - this.e;
    }

    private final byte c() {
        int i = this.f;
        if (i != this.d) {
            byte[] bArr = this.a;
            this.f = i + 1;
            return bArr[i];
        }
        throw zzuv.a();
    }

    public static zzun zzj(byte[] bArr, int i, int i2) {
        return new zzun(bArr, 0, i2);
    }

    public static zzun zzk(byte[] bArr) {
        return zzj(bArr, 0, bArr.length);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(int i, int i2) {
        int i3 = this.f;
        int i4 = this.b;
        if (i > i3 - i4) {
            StringBuilder sb = new StringBuilder(50);
            sb.append("Position ");
            sb.append(i);
            sb.append(" is beyond current ");
            sb.append(i3 - i4);
            throw new IllegalArgumentException(sb.toString());
        } else if (i >= 0) {
            this.f = i4 + i;
            this.g = i2;
        } else {
            StringBuilder sb2 = new StringBuilder(24);
            sb2.append("Bad position ");
            sb2.append(i);
            throw new IllegalArgumentException(sb2.toString());
        }
    }

    public final int getPosition() {
        return this.f - this.b;
    }

    public final String readString() {
        int zzoa = zzoa();
        if (zzoa >= 0) {
            int i = this.d;
            int i2 = this.f;
            if (zzoa > i - i2) {
                throw zzuv.a();
            }
            String str = new String(this.a, i2, zzoa, zzuu.a);
            this.f += zzoa;
            return str;
        }
        throw zzuv.b();
    }

    public final <T extends zzrc<T, ?>> T zza(zzsu<T> zzsuVar) {
        try {
            T t = (T) a().zza(zzsuVar, zzqp.zzor());
            zzao(this.g);
            return t;
        } catch (zzrk e) {
            throw new zzuv("", e);
        }
    }

    public final void zza(zzuw zzuwVar) {
        int zzoa = zzoa();
        if (this.i < this.j) {
            int zzaq = zzaq(zzoa);
            this.i++;
            zzuwVar.zza(this);
            zzan(0);
            this.i--;
            zzar(zzaq);
            return;
        }
        throw zzuv.d();
    }

    public final void zza(zzuw zzuwVar, int i) {
        int i2 = this.i;
        if (i2 < this.j) {
            this.i = i2 + 1;
            zzuwVar.zza(this);
            zzan((i << 3) | 4);
            this.i--;
            return;
        }
        throw zzuv.d();
    }

    public final void zzan(int i) {
        if (this.g == i) {
            return;
        }
        throw new zzuv("Protocol message end-group tag did not match expected tag.");
    }

    public final boolean zzao(int i) {
        int zzni;
        switch (i & 7) {
            case 0:
                zzoa();
                return true;
            case 1:
                c();
                c();
                c();
                c();
                c();
                c();
                c();
                c();
                return true;
            case 2:
                a(zzoa());
                return true;
            case 3:
                break;
            case 4:
                return false;
            case 5:
                zzoc();
                return true;
            default:
                throw new zzuv("Protocol message tag had invalid wire type.");
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

    public final int zzaq(int i) {
        if (i >= 0) {
            int i2 = i + this.f;
            int i3 = this.h;
            if (i2 > i3) {
                throw zzuv.a();
            }
            this.h = i2;
            b();
            return i3;
        }
        throw zzuv.b();
    }

    public final void zzar(int i) {
        this.h = i;
        b();
    }

    public final void zzbz(int i) {
        a(i, this.g);
    }

    public final int zzni() {
        if (this.f == this.d) {
            this.g = 0;
            return 0;
        }
        this.g = zzoa();
        int i = this.g;
        if (i == 0) {
            throw new zzuv("Protocol message contained an invalid tag (zero).");
        }
        return i;
    }

    public final boolean zzno() {
        return zzoa() != 0;
    }

    public final int zzoa() {
        int i;
        byte c = c();
        if (c >= 0) {
            return c;
        }
        int i2 = c & Byte.MAX_VALUE;
        byte c2 = c();
        if (c2 >= 0) {
            i = c2 << 7;
        } else {
            i2 |= (c2 & Byte.MAX_VALUE) << 7;
            byte c3 = c();
            if (c3 >= 0) {
                i = c3 << 14;
            } else {
                i2 |= (c3 & Byte.MAX_VALUE) << 14;
                byte c4 = c();
                if (c4 < 0) {
                    int i3 = i2 | ((c4 & Byte.MAX_VALUE) << 21);
                    byte c5 = c();
                    int i4 = i3 | (c5 << 28);
                    if (c5 >= 0) {
                        return i4;
                    }
                    for (int i5 = 0; i5 < 5; i5++) {
                        if (c() >= 0) {
                            return i4;
                        }
                    }
                    throw zzuv.c();
                }
                i = c4 << 21;
            }
        }
        return i2 | i;
    }

    public final long zzob() {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            byte c = c();
            j |= (c & Byte.MAX_VALUE) << i;
            if ((c & 128) == 0) {
                return j;
            }
        }
        throw zzuv.c();
    }

    public final int zzoc() {
        return (c() & 255) | ((c() & 255) << 8) | ((c() & 255) << 16) | ((c() & 255) << 24);
    }

    public final int zzrv() {
        int i = this.h;
        if (i == Integer.MAX_VALUE) {
            return -1;
        }
        return i - this.f;
    }

    public final byte[] zzt(int i, int i2) {
        if (i2 == 0) {
            return zzuz.zzbhw;
        }
        byte[] bArr = new byte[i2];
        System.arraycopy(this.a, this.b + i, bArr, 0, i2);
        return bArr;
    }
}
