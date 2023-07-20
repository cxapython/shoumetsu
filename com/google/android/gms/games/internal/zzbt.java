package com.google.android.gms.games.internal;

import android.os.Parcel;

/* loaded from: classes.dex */
public abstract class zzbt extends com.google.android.gms.internal.games.zzb implements zzbs {
    public zzbt() {
        super("com.google.android.gms.games.internal.IGamesClient");
    }

    @Override // com.google.android.gms.internal.games.zzb
    protected final boolean a(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i == 1001) {
            zzbw zzas = zzas();
            parcel2.writeNoException();
            com.google.android.gms.internal.games.zzc.zzb(parcel2, zzas);
            return true;
        }
        return false;
    }
}
