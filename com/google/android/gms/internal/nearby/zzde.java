package com.google.android.gms.internal.nearby;

import android.os.Parcel;

/* loaded from: classes.dex */
public abstract class zzde extends zzb implements zzdd {
    public zzde() {
        super("com.google.android.gms.nearby.internal.connection.IAdvertisingCallback");
    }

    @Override // com.google.android.gms.internal.nearby.zzb
    protected final boolean a(int i, Parcel parcel, Parcel parcel2, int i2) {
        switch (i) {
            case 2:
                zza((zzej) zzc.zza(parcel, zzej.CREATOR));
                return true;
            case 3:
                zza((zzfb) zzc.zza(parcel, zzfb.CREATOR));
                return true;
            default:
                return false;
        }
    }
}
