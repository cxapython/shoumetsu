package com.google.android.gms.games.internal;

import android.os.Bundle;
import android.os.IInterface;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.games.multiplayer.realtime.RealTimeMessage;
import com.google.android.gms.games.video.VideoCapabilities;

/* loaded from: classes.dex */
public interface zzbq extends IInterface {
    void onCaptureOverlayStateChanged(int i);

    void onInvitationRemoved(String str);

    void onLeftRoom(int i, String str);

    void onP2PConnected(String str);

    void onP2PDisconnected(String str);

    void onRealTimeMessageReceived(RealTimeMessage realTimeMessage);

    void onRequestRemoved(String str);

    void onSignOutComplete();

    void onTurnBasedMatchRemoved(String str);

    void zza(int i, int i2, String str);

    void zza(int i, Bundle bundle);

    void zza(int i, VideoCapabilities videoCapabilities);

    void zza(int i, String str);

    void zza(int i, String str, boolean z);

    void zza(int i, boolean z);

    void zza(DataHolder dataHolder);

    void zza(DataHolder dataHolder, DataHolder dataHolder2);

    void zza(DataHolder dataHolder, Contents contents);

    void zza(DataHolder dataHolder, String str, Contents contents, Contents contents2, Contents contents3);

    void zza(DataHolder dataHolder, String[] strArr);

    void zza(DataHolder[] dataHolderArr);

    void zzaa(DataHolder dataHolder);

    void zzab(DataHolder dataHolder);

    void zzac(DataHolder dataHolder);

    void zzad(DataHolder dataHolder);

    void zzae(DataHolder dataHolder);

    void zzaf(DataHolder dataHolder);

    void zzag(DataHolder dataHolder);

    void zzah(DataHolder dataHolder);

    void zzai(DataHolder dataHolder);

    void zzaj(DataHolder dataHolder);

    void zzak(DataHolder dataHolder);

    void zzal(DataHolder dataHolder);

    void zzam(DataHolder dataHolder);

    void zzan(DataHolder dataHolder);

    void zzao(DataHolder dataHolder);

    void zzap(DataHolder dataHolder);

    void zzaq(DataHolder dataHolder);

    void zzar(DataHolder dataHolder);

    void zzas(DataHolder dataHolder);

    void zzat(DataHolder dataHolder);

    void zzau(DataHolder dataHolder);

    void zzav(DataHolder dataHolder);

    void zzaw(DataHolder dataHolder);

    void zzax(DataHolder dataHolder);

    void zzb(int i, Bundle bundle);

    void zzb(int i, String str);

    void zzb(DataHolder dataHolder);

    void zzb(DataHolder dataHolder, String[] strArr);

    void zzc(int i);

    void zzc(int i, Bundle bundle);

    void zzc(int i, String str);

    void zzc(Status status);

    void zzc(DataHolder dataHolder);

    void zzc(DataHolder dataHolder, String[] strArr);

    void zzd(int i);

    void zzd(int i, Bundle bundle);

    void zzd(int i, String str);

    void zzd(DataHolder dataHolder);

    void zzd(DataHolder dataHolder, String[] strArr);

    void zze(int i);

    void zze(int i, Bundle bundle);

    void zze(DataHolder dataHolder);

    void zze(DataHolder dataHolder, String[] strArr);

    void zzf(int i);

    void zzf(DataHolder dataHolder);

    void zzf(DataHolder dataHolder, String[] strArr);

    void zzg(int i);

    void zzg(DataHolder dataHolder);

    void zzh(int i);

    void zzh(DataHolder dataHolder);

    void zzi(int i);

    void zzi(DataHolder dataHolder);

    void zzj(int i);

    void zzj(DataHolder dataHolder);

    void zzk(DataHolder dataHolder);

    void zzl(DataHolder dataHolder);

    void zzm(DataHolder dataHolder);

    void zzn(DataHolder dataHolder);

    void zzo(DataHolder dataHolder);

    void zzp(DataHolder dataHolder);

    void zzq(DataHolder dataHolder);

    void zzr(DataHolder dataHolder);

    void zzs(DataHolder dataHolder);

    void zzt(DataHolder dataHolder);

    void zzu(DataHolder dataHolder);

    void zzv(DataHolder dataHolder);

    void zzw(DataHolder dataHolder);

    void zzx(DataHolder dataHolder);

    void zzy(DataHolder dataHolder);

    void zzz(DataHolder dataHolder);
}
