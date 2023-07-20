package com.google.android.gms.nearby.messages.internal;

import android.os.Parcel;
import com.google.android.gms.common.api.Status;

/* loaded from: classes.dex */
public abstract class zzq extends com.google.android.gms.internal.nearby.zzb implements zzp {
    public zzq() {
        super("com.google.android.gms.nearby.messages.internal.INearbyMessagesCallback");
    }

    @Override // com.google.android.gms.internal.nearby.zzb
    protected final boolean a(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i == 1) {
            zza((Status) com.google.android.gms.internal.nearby.zzc.zza(parcel, Status.CREATOR));
            return true;
        }
        return false;
    }
}
