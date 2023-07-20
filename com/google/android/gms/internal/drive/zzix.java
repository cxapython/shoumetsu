package com.google.android.gms.internal.drive;

import java.io.IOException;

/* loaded from: classes.dex */
public abstract class zzix {
    protected volatile int b = -1;

    public static final <T extends zzix> T zza(T t, byte[] bArr, int i, int i2) {
        try {
            zzio zza = zzio.zza(bArr, 0, i2);
            t.zza(zza);
            zza.zzj(0);
            return t;
        } catch (zziw e) {
            throw e;
        } catch (IOException e2) {
            throw new RuntimeException("Reading from a byte array threw an IOException (should never happen).", e2);
        }
    }

    public static final byte[] zza(zzix zzixVar) {
        int a = zzixVar.a();
        zzixVar.b = a;
        byte[] bArr = new byte[a];
        try {
            zzip zzb = zzip.zzb(bArr, 0, bArr.length);
            zzixVar.zza(zzb);
            zzb.zzbh();
            return bArr;
        } catch (IOException e) {
            throw new RuntimeException("Serializing to a byte array threw an IOException (should never happen).", e);
        }
    }

    protected int a() {
        return 0;
    }

    public String toString() {
        return zziy.zzb(this);
    }

    public abstract zzix zza(zzio zzioVar);

    public void zza(zzip zzipVar) {
    }

    @Override // 
    /* renamed from: zzbi */
    public zzix clone() {
        return (zzix) super.clone();
    }
}
