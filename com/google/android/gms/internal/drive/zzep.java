package com.google.android.gms.internal.drive;

import android.content.IntentSender;
import android.os.IBinder;
import android.os.Parcel;

/* loaded from: classes.dex */
public final class zzep extends zza implements zzeo {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzep(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.drive.internal.IDriveService");
    }

    @Override // com.google.android.gms.internal.drive.zzeo
    public final IntentSender zza(zzgg zzggVar) {
        Parcel a = a();
        zzc.zza(a, zzggVar);
        Parcel a2 = a(10, a);
        IntentSender intentSender = (IntentSender) zzc.zza(a2, IntentSender.CREATOR);
        a2.recycle();
        return intentSender;
    }

    @Override // com.google.android.gms.internal.drive.zzeo
    public final IntentSender zza(zzu zzuVar) {
        Parcel a = a();
        zzc.zza(a, zzuVar);
        Parcel a2 = a(11, a);
        IntentSender intentSender = (IntentSender) zzc.zza(a2, IntentSender.CREATOR);
        a2.recycle();
        return intentSender;
    }

    @Override // com.google.android.gms.internal.drive.zzeo
    public final zzec zza(zzgd zzgdVar, zzeq zzeqVar) {
        Parcel a = a();
        zzc.zza(a, zzgdVar);
        zzc.zza(a, zzeqVar);
        Parcel a2 = a(7, a);
        zzec zzecVar = (zzec) zzc.zza(a2, zzec.CREATOR);
        a2.recycle();
        return zzecVar;
    }

    @Override // com.google.android.gms.internal.drive.zzeo
    public final void zza(zzab zzabVar, zzeq zzeqVar) {
        Parcel a = a();
        zzc.zza(a, zzabVar);
        zzc.zza(a, zzeqVar);
        b(24, a);
    }

    @Override // com.google.android.gms.internal.drive.zzeo
    public final void zza(zzad zzadVar) {
        Parcel a = a();
        zzc.zza(a, zzadVar);
        b(16, a);
    }

    @Override // com.google.android.gms.internal.drive.zzeo
    public final void zza(zzek zzekVar, zzeq zzeqVar) {
        Parcel a = a();
        zzc.zza(a, zzekVar);
        zzc.zza(a, zzeqVar);
        b(1, a);
    }

    @Override // com.google.android.gms.internal.drive.zzeo
    public final void zza(zzeq zzeqVar) {
        Parcel a = a();
        zzc.zza(a, zzeqVar);
        b(9, a);
    }

    @Override // com.google.android.gms.internal.drive.zzeo
    public final void zza(zzex zzexVar, zzeq zzeqVar) {
        Parcel a = a();
        zzc.zza(a, zzexVar);
        zzc.zza(a, zzeqVar);
        b(13, a);
    }

    @Override // com.google.android.gms.internal.drive.zzeo
    public final void zza(zzgk zzgkVar, zzeq zzeqVar) {
        Parcel a = a();
        zzc.zza(a, zzgkVar);
        zzc.zza(a, zzeqVar);
        b(2, a);
    }

    @Override // com.google.android.gms.internal.drive.zzeo
    public final void zza(zzgm zzgmVar, zzes zzesVar, String str, zzeq zzeqVar) {
        Parcel a = a();
        zzc.zza(a, zzgmVar);
        zzc.zza(a, zzesVar);
        a.writeString(null);
        zzc.zza(a, zzeqVar);
        b(15, a);
    }

    @Override // com.google.android.gms.internal.drive.zzeo
    public final void zza(zzgo zzgoVar, zzeq zzeqVar) {
        Parcel a = a();
        zzc.zza(a, zzgoVar);
        zzc.zza(a, zzeqVar);
        b(36, a);
    }

    @Override // com.google.android.gms.internal.drive.zzeo
    public final void zza(zzgq zzgqVar, zzeq zzeqVar) {
        Parcel a = a();
        zzc.zza(a, zzgqVar);
        zzc.zza(a, zzeqVar);
        b(28, a);
    }

    @Override // com.google.android.gms.internal.drive.zzeo
    public final void zza(zzgv zzgvVar, zzeq zzeqVar) {
        Parcel a = a();
        zzc.zza(a, zzgvVar);
        zzc.zza(a, zzeqVar);
        b(17, a);
    }

    @Override // com.google.android.gms.internal.drive.zzeo
    public final void zza(zzgx zzgxVar, zzeq zzeqVar) {
        Parcel a = a();
        zzc.zza(a, zzgxVar);
        zzc.zza(a, zzeqVar);
        b(38, a);
    }

    @Override // com.google.android.gms.internal.drive.zzeo
    public final void zza(zzgz zzgzVar, zzeq zzeqVar) {
        Parcel a = a();
        zzc.zza(a, zzgzVar);
        zzc.zza(a, zzeqVar);
        b(3, a);
    }

    @Override // com.google.android.gms.internal.drive.zzeo
    public final void zza(zzj zzjVar, zzes zzesVar, String str, zzeq zzeqVar) {
        Parcel a = a();
        zzc.zza(a, zzjVar);
        zzc.zza(a, zzesVar);
        a.writeString(null);
        zzc.zza(a, zzeqVar);
        b(14, a);
    }

    @Override // com.google.android.gms.internal.drive.zzeo
    public final void zza(zzm zzmVar, zzeq zzeqVar) {
        Parcel a = a();
        zzc.zza(a, zzmVar);
        zzc.zza(a, zzeqVar);
        b(18, a);
    }

    @Override // com.google.android.gms.internal.drive.zzeo
    public final void zza(zzo zzoVar, zzeq zzeqVar) {
        Parcel a = a();
        zzc.zza(a, zzoVar);
        zzc.zza(a, zzeqVar);
        b(8, a);
    }

    @Override // com.google.android.gms.internal.drive.zzeo
    public final void zza(zzr zzrVar, zzeq zzeqVar) {
        Parcel a = a();
        zzc.zza(a, zzrVar);
        zzc.zza(a, zzeqVar);
        b(4, a);
    }

    @Override // com.google.android.gms.internal.drive.zzeo
    public final void zza(zzw zzwVar, zzeq zzeqVar) {
        Parcel a = a();
        zzc.zza(a, zzwVar);
        zzc.zza(a, zzeqVar);
        b(5, a);
    }

    @Override // com.google.android.gms.internal.drive.zzeo
    public final void zza(zzy zzyVar, zzeq zzeqVar) {
        Parcel a = a();
        zzc.zza(a, zzyVar);
        zzc.zza(a, zzeqVar);
        b(6, a);
    }

    @Override // com.google.android.gms.internal.drive.zzeo
    public final void zzb(zzeq zzeqVar) {
        Parcel a = a();
        zzc.zza(a, zzeqVar);
        b(35, a);
    }
}
