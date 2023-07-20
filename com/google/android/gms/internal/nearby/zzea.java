package com.google.android.gms.internal.nearby;

import android.os.Parcel;

/* loaded from: classes.dex */
public abstract class zzea extends zzb implements zzdz {
    public zzea() {
        super("com.google.android.gms.nearby.internal.connection.IResultListener");
    }

    @Override // com.google.android.gms.internal.nearby.zzb
    protected final boolean a(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i == 2) {
            zzc(parcel.readInt());
            return true;
        }
        return false;
    }
}
