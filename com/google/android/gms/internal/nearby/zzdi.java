package com.google.android.gms.internal.nearby;

import android.os.IBinder;
import android.os.Parcel;

/* loaded from: classes.dex */
public final class zzdi extends zza implements zzdg {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdi(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.nearby.internal.connection.IConnectionEventListener");
    }

    @Override // com.google.android.gms.internal.nearby.zzdg
    public final void zza(zzep zzepVar) {
        Parcel a = a();
        zzc.zza(a, zzepVar);
        b(3, a);
    }

    @Override // com.google.android.gms.internal.nearby.zzdg
    public final void zza(zzev zzevVar) {
        Parcel a = a();
        zzc.zza(a, zzevVar);
        b(2, a);
    }

    @Override // com.google.android.gms.internal.nearby.zzdg
    public final void zza(zzex zzexVar) {
        Parcel a = a();
        zzc.zza(a, zzexVar);
        b(4, a);
    }
}
