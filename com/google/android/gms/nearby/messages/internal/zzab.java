package com.google.android.gms.nearby.messages.internal;

import android.os.Parcel;

/* loaded from: classes.dex */
public abstract class zzab extends com.google.android.gms.internal.nearby.zzb implements zzaa {
    public zzab() {
        super("com.google.android.gms.nearby.messages.internal.ISubscribeCallback");
    }

    @Override // com.google.android.gms.internal.nearby.zzb
    protected final boolean a(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i == 1) {
            onExpired();
            return true;
        }
        return false;
    }
}
