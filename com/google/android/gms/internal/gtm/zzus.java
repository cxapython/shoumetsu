package com.google.android.gms.internal.gtm;

/* loaded from: classes.dex */
public final class zzus implements Cloneable {
    private static final en a = new en();
    private boolean b;
    private int[] c;
    private en[] d;
    private int e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzus() {
        this(10);
    }

    private zzus(int i) {
        this.b = false;
        int c = c(i);
        this.c = new int[c];
        this.d = new en[c];
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
    public final en a(int i) {
        int d = d(i);
        if (d >= 0) {
            en[] enVarArr = this.d;
            if (enVarArr[d] != a) {
                return enVarArr[d];
            }
            return null;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(int i, en enVar) {
        int d = d(i);
        if (d >= 0) {
            this.d[d] = enVar;
            return;
        }
        int i2 = ~d;
        if (i2 < this.e) {
            en[] enVarArr = this.d;
            if (enVarArr[i2] == a) {
                this.c[i2] = i;
                enVarArr[i2] = enVar;
                return;
            }
        }
        int i3 = this.e;
        if (i3 >= this.c.length) {
            int c = c(i3 + 1);
            int[] iArr = new int[c];
            en[] enVarArr2 = new en[c];
            int[] iArr2 = this.c;
            System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
            en[] enVarArr3 = this.d;
            System.arraycopy(enVarArr3, 0, enVarArr2, 0, enVarArr3.length);
            this.c = iArr;
            this.d = enVarArr2;
        }
        int i4 = this.e;
        if (i4 - i2 != 0) {
            int[] iArr3 = this.c;
            int i5 = i2 + 1;
            System.arraycopy(iArr3, i2, iArr3, i5, i4 - i2);
            en[] enVarArr4 = this.d;
            System.arraycopy(enVarArr4, i2, enVarArr4, i5, this.e - i2);
        }
        this.c[i2] = i;
        this.d[i2] = enVar;
        this.e++;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final en b(int i) {
        return this.d[i];
    }

    public final /* synthetic */ Object clone() {
        int i = this.e;
        zzus zzusVar = new zzus(i);
        System.arraycopy(this.c, 0, zzusVar.c, 0, i);
        for (int i2 = 0; i2 < i; i2++) {
            en[] enVarArr = this.d;
            if (enVarArr[i2] != null) {
                zzusVar.d[i2] = (en) enVarArr[i2].clone();
            }
        }
        zzusVar.e = i;
        return zzusVar;
    }

    public final boolean equals(Object obj) {
        boolean z;
        boolean z2;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzus)) {
            return false;
        }
        zzus zzusVar = (zzus) obj;
        int i = this.e;
        if (i != zzusVar.e) {
            return false;
        }
        int[] iArr = this.c;
        int[] iArr2 = zzusVar.c;
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
            en[] enVarArr = this.d;
            en[] enVarArr2 = zzusVar.d;
            int i3 = this.e;
            int i4 = 0;
            while (true) {
                if (i4 >= i3) {
                    z2 = true;
                    break;
                } else if (!enVarArr[i4].equals(enVarArr2[i4])) {
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
