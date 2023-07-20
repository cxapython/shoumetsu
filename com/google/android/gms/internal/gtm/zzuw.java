package com.google.android.gms.internal.gtm;

import java.io.IOException;

/* loaded from: classes.dex */
public abstract class zzuw {
    protected volatile int b = -1;

    private static final <T extends zzuw> T a(T t, byte[] bArr, int i, int i2) {
        try {
            zzun zzj = zzun.zzj(bArr, 0, i2);
            t.zza(zzj);
            zzj.zzan(0);
            return t;
        } catch (zzuv e) {
            throw e;
        } catch (IOException e2) {
            throw new RuntimeException("Reading from a byte array threw an IOException (should never happen).", e2);
        }
    }

    public static final <T extends zzuw> T zza(T t, byte[] bArr) {
        return (T) a(t, bArr, 0, bArr.length);
    }

    public static final void zza(zzuw zzuwVar, byte[] bArr, int i, int i2) {
        try {
            zzuo zzk = zzuo.zzk(bArr, 0, i2);
            zzuwVar.zza(zzk);
            zzk.zzrx();
        } catch (IOException e) {
            throw new RuntimeException("Serializing to a byte array threw an IOException (should never happen).", e);
        }
    }

    protected int a() {
        return 0;
    }

    public String toString() {
        return zzux.zzc(this);
    }

    public abstract zzuw zza(zzun zzunVar);

    public void zza(zzuo zzuoVar) {
    }

    public final int zzpe() {
        int a = a();
        this.b = a;
        return a;
    }

    @Override // 
    /* renamed from: zzry */
    public zzuw clone() {
        return (zzuw) super.clone();
    }

    public final int zzse() {
        if (this.b < 0) {
            zzpe();
        }
        return this.b;
    }
}
