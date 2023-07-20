package com.google.android.gms.internal.nearby;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.games.GamesStatusCodes;

/* loaded from: classes.dex */
public final class zzdv extends zza implements zzdu {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdv(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.nearby.internal.connection.INearbyConnectionService");
    }

    @Override // com.google.android.gms.internal.nearby.zzdu
    public final void zza(zzcz zzczVar) {
        Parcel a = a();
        zzc.zza(a, zzczVar);
        a(2009, a);
    }

    @Override // com.google.android.gms.internal.nearby.zzdu
    public final void zza(zzfm zzfmVar) {
        Parcel a = a();
        zzc.zza(a, zzfmVar);
        a(2007, a);
    }

    @Override // com.google.android.gms.internal.nearby.zzdu
    public final void zza(zzfq zzfqVar) {
        Parcel a = a();
        zzc.zza(a, zzfqVar);
        a(2005, a);
    }

    @Override // com.google.android.gms.internal.nearby.zzdu
    public final void zza(zzfu zzfuVar) {
        Parcel a = a();
        zzc.zza(a, zzfuVar);
        a(2008, a);
    }

    @Override // com.google.android.gms.internal.nearby.zzdu
    public final void zza(zzfy zzfyVar) {
        Parcel a = a();
        zzc.zza(a, zzfyVar);
        a(2001, a);
    }

    @Override // com.google.android.gms.internal.nearby.zzdu
    public final void zza(zzgc zzgcVar) {
        Parcel a = a();
        zzc.zza(a, zzgcVar);
        a(2003, a);
    }

    @Override // com.google.android.gms.internal.nearby.zzdu
    public final void zza(zzgg zzggVar) {
        Parcel a = a();
        zzc.zza(a, zzggVar);
        a(GamesStatusCodes.STATUS_REQUEST_TOO_MANY_RECIPIENTS, a);
    }

    @Override // com.google.android.gms.internal.nearby.zzdu
    public final void zza(zzgj zzgjVar) {
        Parcel a = a();
        zzc.zza(a, zzgjVar);
        a(2010, a);
    }

    @Override // com.google.android.gms.internal.nearby.zzdu
    public final void zza(zzgm zzgmVar) {
        Parcel a = a();
        zzc.zza(a, zzgmVar);
        a(2004, a);
    }

    @Override // com.google.android.gms.internal.nearby.zzdu
    public final void zza(zzm zzmVar) {
        Parcel a = a();
        zzc.zza(a, zzmVar);
        a(2006, a);
    }

    @Override // com.google.android.gms.internal.nearby.zzdu
    public final void zza(zzq zzqVar) {
        Parcel a = a();
        zzc.zza(a, zzqVar);
        a(2012, a);
    }

    @Override // com.google.android.gms.internal.nearby.zzdu
    public final void zza(zzu zzuVar) {
        Parcel a = a();
        zzc.zza(a, zzuVar);
        a(2011, a);
    }
}
