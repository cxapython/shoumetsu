package com.google.android.gms.internal.drive;

import android.os.Parcel;

/* loaded from: classes.dex */
public abstract class zzet extends zzb implements zzes {
    public zzet() {
        super("com.google.android.gms.drive.internal.IEventCallback");
    }

    @Override // com.google.android.gms.internal.drive.zzb
    protected final boolean a(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i == 1) {
            zzc((zzfj) zzc.zza(parcel, zzfj.CREATOR));
            parcel2.writeNoException();
            return true;
        }
        return false;
    }
}
