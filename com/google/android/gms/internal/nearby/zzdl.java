package com.google.android.gms.internal.nearby;

import android.os.IBinder;
import android.os.Parcel;

/* loaded from: classes.dex */
public final class zzdl extends zza implements zzdj {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdl(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.nearby.internal.connection.IConnectionLifecycleListener");
    }

    @Override // com.google.android.gms.internal.nearby.zzdj
    public final void zza(zzef zzefVar) {
        Parcel a = a();
        zzc.zza(a, zzefVar);
        b(5, a);
    }

    @Override // com.google.android.gms.internal.nearby.zzdj
    public final void zza(zzeh zzehVar) {
        Parcel a = a();
        zzc.zza(a, zzehVar);
        b(2, a);
    }

    @Override // com.google.android.gms.internal.nearby.zzdj
    public final void zza(zzen zzenVar) {
        Parcel a = a();
        zzc.zza(a, zzenVar);
        b(3, a);
    }

    @Override // com.google.android.gms.internal.nearby.zzdj
    public final void zza(zzep zzepVar) {
        Parcel a = a();
        zzc.zza(a, zzepVar);
        b(4, a);
    }
}
