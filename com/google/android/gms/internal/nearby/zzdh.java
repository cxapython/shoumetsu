package com.google.android.gms.internal.nearby;

import android.os.Parcel;

/* loaded from: classes.dex */
public abstract class zzdh extends zzb implements zzdg {
    public zzdh() {
        super("com.google.android.gms.nearby.internal.connection.IConnectionEventListener");
    }

    @Override // com.google.android.gms.internal.nearby.zzb
    protected final boolean a(int i, Parcel parcel, Parcel parcel2, int i2) {
        switch (i) {
            case 2:
                zza((zzev) zzc.zza(parcel, zzev.CREATOR));
                return true;
            case 3:
                zza((zzep) zzc.zza(parcel, zzep.CREATOR));
                return true;
            case 4:
                zza((zzex) zzc.zza(parcel, zzex.CREATOR));
                return true;
            default:
                return false;
        }
    }
}
