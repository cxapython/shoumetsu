package com.google.android.gms.internal.drive;

/* loaded from: classes.dex */
public final class zzit implements Cloneable {
    private static final cr a = new cr();
    private boolean b;
    private int[] c;
    private cr[] d;
    private int e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzit() {
        this(10);
    }

    private zzit(int i) {
        this.b = false;
        int c = c(i);
        this.c = new int[c];
        this.d = new cr[c];
        this.e = 0;
    }

    private static int c(int i) {
        int i2 = i << 2;
        int i3 = 4;
        while (true) {
            if (i3 >= 32) {
                break;
            }
            int i4 = (1 << i3) - 12;
            if (i2 <= i4) {
                i2 = i4;
                break;
            }
            i3++;
        }
        return i2 / 4;
    }

    private final int d(int i) {
        int i2 = this.e - 1;
        int i3 = 0;
        while (i3 <= i2) {
            int i4 = (i3 + i2) >>> 1;
            int i5 = this.c[i4];
            if (i5 < i) {
                i3 = i4 + 1;
            } else if (i5 <= i) {
                return i4;
            } else {
                i2 = i4 - 1;
            }
        }
        return ~i3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int a() {
        return this.e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final cr a(int i) {
        int d = d(i);
        if (d >= 0) {
            cr[] crVarArr = this.d;
            if (crVarArr[d] != a) {
                return crVarArr[d];
            }
            return null;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(int i, cr crVar) {
        int d = d(i);
        if (d >= 0) {
            this.d[d] = crVar;
            return;
        }
        int i2 = ~d;
        if (i2 < this.e) {
            cr[] crVarArr = this.d;
            if (crVarArr[i2] == a) {
                this.c[i2] = i;
                crVarArr[i2] = crVar;
                return;
            }
        }
        int i3 = this.e;
        if (i3 >= this.c.length) {
            int c = c(i3 + 1);
            int[] iArr = new int[c];
            cr[] crVarArr2 = new cr[c];
            int[] iArr2 = this.c;
            System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
            cr[] crVarArr3 = this.d;
            System.arraycopy(crVarArr3, 0, crVarArr2, 0, crVarArr3.length);
            this.c = iArr;
            this.d = crVarArr2;
        }
        int i4 = this.e;
        if (i4 - i2 != 0) {
            int[] iArr3 = this.c;
            int i5 = i2 + 1;
            System.arraycopy(iArr3, i2, iArr3, i5, i4 - i2);
            cr[] crVarArr4 = this.d;
            System.arraycopy(crVarArr4, i2, crVarArr4, i5, this.e - i2);
        }
        this.c[i2] = i;
        this.d[i2] = crVar;
        this.e++;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final cr b(int i) {
        return this.d[i];
    }

    public final /* synthetic */ Object clone() {
        int i = this.e;
        zzit zzitVar = new zzit(i);
        System.arraycopy(this.c, 0, zzitVar.c, 0, i);
        for (int i2 = 0; i2 < i; i2++) {
            cr[] crVarArr = this.d;
            if (crVarArr[i2] != null) {
                zzitVar.d[i2] = (cr) crVarArr[i2].clone();
            }
        }
        zzitVar.e = i;
        return zzitVar;
    }

    public final boolean equals(Object obj) {
        boolean z;
        boolean z2;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzit)) {
            return false;
        }
        zzit zzitVar = (zzit) obj;
        int i = this.e;
        if (i != zzitVar.e) {
            return false;
        }
        int[] iArr = this.c;
        int[] iArr2 = zzitVar.c;
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
            cr[] crVarArr = this.d;
            cr[] crVarArr2 = zzitVar.d;
            int i3 = this.e;
            int i4 = 0;
            while (true) {
                if (i4 >= i3) {
                    z2 = true;
                    break;
                } else if (!crVarArr[i4].equals(crVarArr2[i4])) {
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
        return false;
    }

    public final int hashCode() {
        int i = 17;
        for (int i2 = 0; i2 < this.e; i2++) {
            i = (((i * 31) + this.c[i2]) * 31) + this.d[i2].hashCode();
        }
        return i;
    }

    public final boolean isEmpty() {
        return this.e == 0;
    }
}
