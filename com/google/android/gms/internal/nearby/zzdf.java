package com.google.android.gms.internal.nearby;

import android.os.IBinder;
import android.os.Parcel;

/* loaded from: classes.dex */
public final class zzdf extends zza implements zzdd {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdf(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.nearby.internal.connection.IAdvertisingCallback");
    }

    @Override // com.google.android.gms.internal.nearby.zzdd
    public final void zza(zzej zzejVar) {
        Parcel a = a();
        zzc.zza(a, zzejVar);
        b(2, a);
    }

    @Override // com.google.android.gms.internal.nearby.zzdd
    public final void zza(zzfb zzfbVar) {
        Parcel a = a();
        zzc.zza(a, zzfbVar);
        b(3, a);
    }
}
