package com.google.android.gms.internal.drive;

/* loaded from: classes.dex */
public final class zzio {
    private final byte[] a;
    private final int b;
    private final int c;
    private int d;
    private int e;
    private int f;
    private int g = Integer.MAX_VALUE;
    private int h = 64;
    private int i = 67108864;

    private zzio(byte[] bArr, int i, int i2) {
        this.a = bArr;
        this.b = i;
        int i3 = i2 + i;
        this.d = i3;
        this.c = i3;
        this.e = i;
    }

    private final byte a() {
        int i = this.e;
        if (i != this.d) {
            byte[] bArr = this.a;
            this.e = i + 1;
            return bArr[i];
        }
        throw zziw.a();
    }

    private final void a(int i) {
        if (i >= 0) {
            int i2 = this.e;
            int i3 = i2 + i;
            int i4 = this.g;
            if (i3 > i4) {
                a(i4 - i2);
                throw zziw.a();
            } else if (i > this.d - i2) {
                throw zziw.a();
            } else {
                this.e = i2 + i;
                return;
            }
        }
        throw zziw.b();
    }

    public static zzio zza(byte[] bArr, int i, int i2) {
        return new zzio(bArr, 0, i2);
    }

    public final int getPosition() {
        return this.e - this.b;
    }

    public final String readString() {
        int zzbe = zzbe();
        if (zzbe >= 0) {
            int i = this.d;
            int i2 = this.e;
            if (zzbe > i - i2) {
                throw zziw.a();
            }
            String str = new String(this.a, i2, zzbe, zziv.a);
            this.e += zzbe;
            return str;
        }
        throw zziw.b();
    }

    public final byte[] zza(int i, int i2) {
        if (i2 == 0) {
            return zzja.zzns;
        }
        byte[] bArr = new byte[i2];
        System.arraycopy(this.a, this.b + i, bArr, 0, i2);
        return bArr;
    }

    public final int zzbd() {
        if (this.e == this.d) {
            this.f = 0;
            return 0;
        }
        this.f = zzbe();
        int i = this.f;
        if (i == 0) {
            throw new zziw("Protocol message contained an invalid tag (zero).");
        }
        return i;
    }

    public final int zzbe() {
        int i;
        byte a = a();
        if (a >= 0) {
            return a;
        }
        int i2 = a & Byte.MAX_VALUE;
        byte a2 = a();
        if (a2 >= 0) {
            i = a2 << 7;
        } else {
            i2 |= (a2 & Byte.MAX_VALUE) << 7;
            byte a3 = a();
            if (a3 >= 0) {
                i = a3 << 14;
            } else {
                i2 |= (a3 & Byte.MAX_VALUE) << 14;
                byte a4 = a();
                if (a4 < 0) {
                    int i3 = i2 | ((a4 & Byte.MAX_VALUE) << 21);
                    byte a5 = a();
                    int i4 = i3 | (a5 << 28);
                    if (a5 >= 0) {
                        return i4;
                    }
                    for (int i5 = 0; i5 < 5; i5++) {
                        if (a() >= 0) {
                            return i4;
                        }
                    }
                    throw zziw.c();
                }
                i = a4 << 21;
            }
        }
        return i2 | i;
    }

    public final long zzbf() {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            byte a = a();
            j |= (a & Byte.MAX_VALUE) << i;
            if ((a & 128) == 0) {
                return j;
            }
        }
        throw zziw.c();
    }

    public final void zzj(int i) {
        if (this.f == i) {
            return;
        }
        throw new zziw("Protocol message end-group tag did not match expected tag.");
    }

    public final boolean zzk(int i) {
        int zzbd;
        switch (i & 7) {
            case 0:
                zzbe();
                return true;
            case 1:
                a();
                a();
                a();
                a();
                a();
                a();
                a();
                a();
                return true;
            case 2:
                a(zzbe());
                return true;
            case 3:
                break;
            case 4:
                return false;
            case 5:
                a();
                a();
                a();
                a();
                return true;
            default:
                throw new zziw("Protocol message tag had invalid wire type.");
        }
        do {
            zzbd = zzbd();
            if (zzbd != 0) {
            }
            zzj(((i >>> 3) << 3) | 4);
            return true;
        } while (zzk(zzbd));
        zzj(((i >>> 3) << 3) | 4);
        return true;
    }
}
