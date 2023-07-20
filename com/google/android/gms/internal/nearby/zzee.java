package com.google.android.gms.internal.nearby;

import android.os.IBinder;
import android.os.Parcel;

/* loaded from: classes.dex */
public final class zzee extends zza implements zzec {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzee(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.nearby.internal.connection.IStartAdvertisingResultListener");
    }

    @Override // com.google.android.gms.internal.nearby.zzec
    public final void zza(zzez zzezVar) {
        Parcel a = a();
        zzc.zza(a, zzezVar);
        b(2, a);
    }
}
