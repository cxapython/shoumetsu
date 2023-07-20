package com.google.android.gms.internal.nearby;

import android.os.Parcel;

/* loaded from: classes.dex */
public abstract class zzds extends zzb implements zzdr {
    public zzds() {
        super("com.google.android.gms.nearby.internal.connection.IDiscoveryListener");
    }

    @Override // com.google.android.gms.internal.nearby.zzb
    protected final boolean a(int i, Parcel parcel, Parcel parcel2, int i2) {
        switch (i) {
            case 2:
                zza((zzer) zzc.zza(parcel, zzer.CREATOR));
                return true;
            case 3:
                zza((zzet) zzc.zza(parcel, zzet.CREATOR));
                return true;
            case 4:
                zza((zzfd) zzc.zza(parcel, zzfd.CREATOR));
                return true;
            default:
                return false;
        }
    }
}
