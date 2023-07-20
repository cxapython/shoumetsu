package com.google.android.gms.internal.nearby;

import android.os.Parcel;

/* loaded from: classes.dex */
public abstract class zzdx extends zzb implements zzdw {
    public zzdx() {
        super("com.google.android.gms.nearby.internal.connection.IPayloadListener");
    }

    @Override // com.google.android.gms.internal.nearby.zzb
    protected final boolean a(int i, Parcel parcel, Parcel parcel2, int i2) {
        switch (i) {
            case 2:
                zza((zzev) zzc.zza(parcel, zzev.CREATOR));
                return true;
            case 3:
                zza((zzex) zzc.zza(parcel, zzex.CREATOR));
                return true;
            default:
                return false;
        }
    }
}
