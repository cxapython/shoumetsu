package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: classes.dex */
public interface IGmsCallbacks extends IInterface {

    /* loaded from: classes.dex */
    public static abstract class zza extends com.google.android.gms.internal.common.zzb implements IGmsCallbacks {
        public zza() {
            super("com.google.android.gms.common.internal.IGmsCallbacks");
        }

        @Override // com.google.android.gms.internal.common.zzb
        protected final boolean a(int i, Parcel parcel, Parcel parcel2, int i2) {
            switch (i) {
                case 1:
                    onPostInitComplete(parcel.readInt(), parcel.readStrongBinder(), (Bundle) com.google.android.gms.internal.common.zzc.zza(parcel, Bundle.CREATOR));
                    break;
                case 2:
                    zza(parcel.readInt(), (Bundle) com.google.android.gms.internal.common.zzc.zza(parcel, Bundle.CREATOR));
                    break;
                case 3:
                    zza(parcel.readInt(), parcel.readStrongBinder(), (zzb) com.google.android.gms.internal.common.zzc.zza(parcel, zzb.CREATOR));
                    break;
                default:
                    return false;
            }
            parcel2.writeNoException();
            return true;
        }
    }

    void onPostInitComplete(int i, IBinder iBinder, Bundle bundle);

    void zza(int i, Bundle bundle);

    void zza(int i, IBinder iBinder, zzb zzbVar);
}
