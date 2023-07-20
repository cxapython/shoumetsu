package com.google.android.gms.internal.gtm;

import com.google.android.gms.internal.gtm.zzrc;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class zzts {
    private static final zzts a = new zzts(0, new int[0], new Object[0], false);
    private int b;
    private int[] c;
    private Object[] d;
    private int e;
    private boolean f;

    private zzts() {
        this(0, new int[8], new Object[8], true);
    }

    private zzts(int i, int[] iArr, Object[] objArr, boolean z) {
        this.e = -1;
        this.b = i;
        this.c = iArr;
        this.d = objArr;
        this.f = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzts a() {
        return new zzts();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzts a(zzts zztsVar, zzts zztsVar2) {
        int i = zztsVar.b + zztsVar2.b;
        int[] copyOf = Arrays.copyOf(zztsVar.c, i);
        System.arraycopy(zztsVar2.c, 0, copyOf, zztsVar.b, zztsVar2.b);
        Object[] copyOf2 = Arrays.copyOf(zztsVar.d, i);
        System.arraycopy(zztsVar2.d, 0, copyOf2, zztsVar.b, zztsVar2.b);
        return new zzts(i, copyOf, copyOf2, true);
    }

    private static void a(int i, Object obj, em emVar) {
        int i2 = i >>> 3;
        int i3 = i & 7;
        if (i3 == 5) {
            emVar.d(i2, ((Integer) obj).intValue());
            return;
        }
        switch (i3) {
            case 0:
                emVar.a(i2, ((Long) obj).longValue());
                return;
            case 1:
                emVar.d(i2, ((Long) obj).longValue());
                return;
            case 2:
                emVar.a(i2, (zzps) obj);
                return;
            case 3:
                if (emVar.a() == zzrc.zze.zzbbc) {
                    emVar.a(i2);
                    ((zzts) obj).zzb(emVar);
                    emVar.b(i2);
                    return;
                }
                emVar.b(i2);
                ((zzts) obj).zzb(emVar);
                emVar.a(i2);
                return;
            default:
                throw new RuntimeException(zzrk.e());
        }
    }

    public static zzts zzrj() {
        return a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(int i, Object obj) {
        if (this.f) {
            int i2 = this.b;
            if (i2 == this.c.length) {
                int i3 = this.b + (i2 < 4 ? 8 : i2 >> 1);
                this.c = Arrays.copyOf(this.c, i3);
                this.d = Arrays.copyOf(this.d, i3);
            }
            int[] iArr = this.c;
            int i4 = this.b;
            iArr[i4] = i;
            this.d[i4] = obj;
            this.b = i4 + 1;
            return;
        }
        throw new UnsupportedOperationException();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(em emVar) {
        if (emVar.a() == zzrc.zze.zzbbd) {
            for (int i = this.b - 1; i >= 0; i--) {
                emVar.a(this.c[i] >>> 3, this.d[i]);
            }
            return;
        }
        for (int i2 = 0; i2 < this.b; i2++) {
            emVar.a(this.c[i2] >>> 3, this.d[i2]);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(StringBuilder sb, int i) {
        for (int i2 = 0; i2 < this.b; i2++) {
            cu.a(sb, i, String.valueOf(this.c[i2] >>> 3), this.d[i2]);
        }
    }

    public final boolean equals(Object obj) {
        boolean z;
        boolean z2;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof zzts)) {
            return false;
        }
        zzts zztsVar = (zzts) obj;
        int i = this.b;
        if (i == zztsVar.b) {
            int[] iArr = this.c;
            int[] iArr2 = zztsVar.c;
            int i2 = 0;
            while (true) {
                if (i2 >= i) {
                    z = true;
                    break;
                } else if (iArr[i2] != iArr2[i2]) {
                    z = false;
                    break;
                } else {
                    i2++;
                }
            }
            if (z) {
                Object[] objArr = this.d;
                Object[] objArr2 = zztsVar.d;
                int i3 = this.b;
                int i4 = 0;
                while (true) {
                    if (i4 >= i3) {
                        z2 = true;
                        break;
                    } else if (!objArr[i4].equals(objArr2[i4])) {
                        z2 = false;
                        break;
                    } else {
                        i4++;
                    }
                }
                if (z2) {
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        int i = this.b;
        int i2 = (i + 527) * 31;
        int[] iArr = this.c;
        int i3 = 17;
        int i4 = 17;
        for (int i5 = 0; i5 < i; i5++) {
            i4 = (i4 * 31) + iArr[i5];
        }
        int i6 = (i2 + i4) * 31;
        Object[] objArr = this.d;
        int i7 = this.b;
        for (int i8 = 0; i8 < i7; i8++) {
            i3 = (i3 * 31) + objArr[i8].hashCode();
        }
        return i6 + i3;
    }

    public final void zzb(em emVar) {
        if (this.b == 0) {
            return;
        }
        if (emVar.a() == zzrc.zze.zzbbc) {
            for (int i = 0; i < this.b; i++) {
                a(this.c[i], this.d[i], emVar);
            }
            return;
        }
        for (int i2 = this.b - 1; i2 >= 0; i2--) {
            a(this.c[i2], this.d[i2], emVar);
        }
    }

    public final void zzmi() {
        this.f = false;
    }

    public final int zzpe() {
        int zzl;
        int i = this.e;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.b; i3++) {
            int i4 = this.c[i3];
            int i5 = i4 >>> 3;
            int i6 = i4 & 7;
            if (i6 != 5) {
                switch (i6) {
                    case 0:
                        zzl = zzqj.zze(i5, ((Long) this.d[i3]).longValue());
                        break;
                    case 1:
                        zzl = zzqj.zzg(i5, ((Long) this.d[i3]).longValue());
                        break;
                    case 2:
                        zzl = zzqj.zzc(i5, (zzps) this.d[i3]);
                        break;
                    case 3:
                        zzl = (zzqj.zzbb(i5) << 1) + ((zzts) this.d[i3]).zzpe();
                        break;
                    default:
                        throw new IllegalStateException(zzrk.e());
                }
            } else {
                zzl = zzqj.zzl(i5, ((Integer) this.d[i3]).intValue());
            }
            i2 += zzl;
        }
        this.e = i2;
        return i2;
    }

    public final int zzrl() {
        int i = this.e;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.b; i3++) {
            i2 += zzqj.zzd(this.c[i3] >>> 3, (zzps) this.d[i3]);
        }
        this.e = i2;
        return i2;
    }
}
