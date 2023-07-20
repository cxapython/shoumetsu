package com.google.android.gms.internal.gtm;

/* loaded from: classes.dex */
public abstract class zzqe {
    int a;
    int b;
    bm c;
    private int d;
    private boolean e;

    private zzqe() {
        this.b = 100;
        this.d = Integer.MAX_VALUE;
        this.e = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzqe a(byte[] bArr, int i, int i2, boolean z) {
        bl blVar = new bl(bArr, i, i2, false);
        try {
            blVar.zzaq(i2);
            return blVar;
        } catch (zzrk e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static zzqe zzd(byte[] bArr, int i, int i2) {
        return a(bArr, i, i2, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract long a();

    public abstract double readDouble();

    public abstract float readFloat();

    public abstract String readString();

    public abstract <T extends zzsk> T zza(zzsu<T> zzsuVar, zzqp zzqpVar);

    public abstract void zzan(int i);

    public abstract boolean zzao(int i);

    public final int zzap(int i) {
        if (i >= 0) {
            int i2 = this.b;
            this.b = i;
            return i2;
        }
        StringBuilder sb = new StringBuilder(47);
        sb.append("Recursion limit cannot be negative: ");
        sb.append(i);
        throw new IllegalArgumentException(sb.toString());
    }

    public abstract int zzaq(int i);

    public abstract void zzar(int i);

    public abstract void zzas(int i);

    public abstract int zzni();

    public abstract long zznj();

    public abstract long zznk();

    public abstract int zznl();

    public abstract long zznm();

    public abstract int zznn();

    public abstract boolean zzno();

    public abstract String zznp();

    public abstract zzps zznq();

    public abstract int zznr();

    public abstract int zzns();

    public abstract int zznt();

    public abstract long zznu();

    public abstract int zznv();

    public abstract long zznw();

    public abstract boolean zzny();

    public abstract int zznz();
}
