package com.google.android.gms.internal.nearby;

import android.os.IBinder;
import android.os.Parcel;

/* loaded from: classes.dex */
public final class zzdy extends zza implements zzdw {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdy(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.nearby.internal.connection.IPayloadListener");
    }

    @Override // com.google.android.gms.internal.nearby.zzdw
    public final void zza(zzev zzevVar) {
        Parcel a = a();
        zzc.zza(a, zzevVar);
        b(2, a);
    }

    @Override // com.google.android.gms.internal.nearby.zzdw
    public final void zza(zzex zzexVar) {
        Parcel a = a();
        zzc.zza(a, zzexVar);
        b(3, a);
    }
}
