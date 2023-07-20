package com.google.android.gms.internal.nearby;

import android.os.IBinder;
import android.os.Parcel;

/* loaded from: classes.dex */
public final class zzdt extends zza implements zzdr {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdt(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.nearby.internal.connection.IDiscoveryListener");
    }

    @Override // com.google.android.gms.internal.nearby.zzdr
    public final void zza(zzer zzerVar) {
        Parcel a = a();
        zzc.zza(a, zzerVar);
        b(2, a);
    }

    @Override // com.google.android.gms.internal.nearby.zzdr
    public final void zza(zzet zzetVar) {
        Parcel a = a();
        zzc.zza(a, zzetVar);
        b(3, a);
    }

    @Override // com.google.android.gms.internal.nearby.zzdr
    public final void zza(zzfd zzfdVar) {
        Parcel a = a();
        zzc.zza(a, zzfdVar);
        b(4, a);
    }
}
