package com.google.android.gms.internal.nearby;

import android.os.IBinder;
import android.os.Parcel;

/* loaded from: classes.dex */
public final class zzdo extends zza implements zzdm {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdo(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.nearby.internal.connection.IConnectionResponseListener");
    }

    @Override // com.google.android.gms.internal.nearby.zzdm
    public final void zza(zzel zzelVar) {
        Parcel a = a();
        zzc.zza(a, zzelVar);
        b(2, a);
    }
}
