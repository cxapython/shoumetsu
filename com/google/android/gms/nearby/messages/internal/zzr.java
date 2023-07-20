package com.google.android.gms.nearby.messages.internal;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.api.Status;

/* loaded from: classes.dex */
public final class zzr extends com.google.android.gms.internal.nearby.zza implements zzp {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzr(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.nearby.messages.internal.INearbyMessagesCallback");
    }

    @Override // com.google.android.gms.nearby.messages.internal.zzp
    public final void zza(Status status) {
        Parcel a = a();
        com.google.android.gms.internal.nearby.zzc.zza(a, status);
        b(1, a);
    }
}
