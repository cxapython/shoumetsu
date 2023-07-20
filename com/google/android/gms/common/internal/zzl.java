package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.internal.common.zza;

/* loaded from: classes.dex */
public final class zzl extends zza implements IGmsCallbacks {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzl(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.IGmsCallbacks");
    }

    @Override // com.google.android.gms.common.internal.IGmsCallbacks
    public final void onPostInitComplete(int i, IBinder iBinder, Bundle bundle) {
        Parcel a = a();
        a.writeInt(i);
        a.writeStrongBinder(iBinder);
        com.google.android.gms.internal.common.zzc.zza(a, bundle);
        b(1, a);
    }

    @Override // com.google.android.gms.common.internal.IGmsCallbacks
    public final void zza(int i, Bundle bundle) {
        Parcel a = a();
        a.writeInt(i);
        com.google.android.gms.internal.common.zzc.zza(a, bundle);
        b(2, a);
    }

    @Override // com.google.android.gms.common.internal.IGmsCallbacks
    public final void zza(int i, IBinder iBinder, zzb zzbVar) {
        Parcel a = a();
        a.writeInt(i);
        a.writeStrongBinder(iBinder);
        com.google.android.gms.internal.common.zzc.zza(a, zzbVar);
        b(3, a);
    }
}
