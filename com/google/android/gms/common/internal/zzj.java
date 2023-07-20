package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;

/* loaded from: classes.dex */
public abstract class zzj extends com.google.android.gms.internal.common.zzb implements zzi {
    public zzj() {
        super("com.google.android.gms.common.internal.ICertData");
    }

    public static zzi zzb(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.ICertData");
        return queryLocalInterface instanceof zzi ? (zzi) queryLocalInterface : new zzk(iBinder);
    }

    @Override // com.google.android.gms.internal.common.zzb
    protected final boolean a(int i, Parcel parcel, Parcel parcel2, int i2) {
        switch (i) {
            case 1:
                IObjectWrapper zzb = zzb();
                parcel2.writeNoException();
                com.google.android.gms.internal.common.zzc.zza(parcel2, zzb);
                return true;
            case 2:
                int zzc = zzc();
                parcel2.writeNoException();
                parcel2.writeInt(zzc);
                return true;
            default:
                return false;
        }
    }
}
