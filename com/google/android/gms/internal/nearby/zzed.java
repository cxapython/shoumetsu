package com.google.android.gms.internal.nearby;

import android.os.Parcel;

/* loaded from: classes.dex */
public abstract class zzed extends zzb implements zzec {
    public zzed() {
        super("com.google.android.gms.nearby.internal.connection.IStartAdvertisingResultListener");
    }

    @Override // com.google.android.gms.internal.nearby.zzb
    protected final boolean a(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i == 2) {
            zza((zzez) zzc.zza(parcel, zzez.CREATOR));
            return true;
        }
        return false;
    }
}
