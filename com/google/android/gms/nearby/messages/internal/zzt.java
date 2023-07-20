package com.google.android.gms.nearby.messages.internal;

import android.os.IBinder;
import android.os.Parcel;

/* loaded from: classes.dex */
public final class zzt extends com.google.android.gms.internal.nearby.zza implements zzs {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzt(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.nearby.messages.internal.INearbyMessagesService");
    }

    @Override // com.google.android.gms.nearby.messages.internal.zzs
    public final void zza(SubscribeRequest subscribeRequest) {
        Parcel a = a();
        com.google.android.gms.internal.nearby.zzc.zza(a, subscribeRequest);
        b(3, a);
    }

    @Override // com.google.android.gms.nearby.messages.internal.zzs
    public final void zza(zzbz zzbzVar) {
        Parcel a = a();
        com.google.android.gms.internal.nearby.zzc.zza(a, zzbzVar);
        b(1, a);
    }

    @Override // com.google.android.gms.nearby.messages.internal.zzs
    public final void zza(zzcb zzcbVar) {
        Parcel a = a();
        com.google.android.gms.internal.nearby.zzc.zza(a, zzcbVar);
        b(8, a);
    }

    @Override // com.google.android.gms.nearby.messages.internal.zzs
    public final void zza(zzce zzceVar) {
        Parcel a = a();
        com.google.android.gms.internal.nearby.zzc.zza(a, zzceVar);
        b(2, a);
    }

    @Override // com.google.android.gms.nearby.messages.internal.zzs
    public final void zza(zzcg zzcgVar) {
        Parcel a = a();
        com.google.android.gms.internal.nearby.zzc.zza(a, zzcgVar);
        b(4, a);
    }

    @Override // com.google.android.gms.nearby.messages.internal.zzs
    public final void zza(zzh zzhVar) {
        Parcel a = a();
        com.google.android.gms.internal.nearby.zzc.zza(a, zzhVar);
        b(7, a);
    }

    @Override // com.google.android.gms.nearby.messages.internal.zzs
    public final void zza(zzj zzjVar) {
        Parcel a = a();
        com.google.android.gms.internal.nearby.zzc.zza(a, zzjVar);
        b(9, a);
    }
}
