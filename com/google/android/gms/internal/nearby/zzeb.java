package com.google.android.gms.internal.nearby;

import android.os.IBinder;
import android.os.Parcel;

/* loaded from: classes.dex */
public final class zzeb extends zza implements zzdz {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzeb(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.nearby.internal.connection.IResultListener");
    }

    @Override // com.google.android.gms.internal.nearby.zzdz
    public final void zzc(int i) {
        Parcel a = a();
        a.writeInt(i);
        b(2, a);
    }
}
