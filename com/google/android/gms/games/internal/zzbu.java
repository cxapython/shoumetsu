package com.google.android.gms.games.internal;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.games.multiplayer.ParticipantResult;
import com.google.android.gms.games.multiplayer.realtime.RoomEntity;
import com.google.android.gms.games.snapshot.SnapshotMetadataChangeEntity;

/* loaded from: classes.dex */
public interface zzbu extends IInterface {
    Bundle getConnectionHint();

    int zza(zzbq zzbqVar, byte[] bArr, String str, String str2);

    Intent zza(int i, int i2, boolean z);

    Intent zza(int i, byte[] bArr, int i2, String str);

    Intent zza(PlayerEntity playerEntity);

    Intent zza(RoomEntity roomEntity, int i);

    Intent zza(String str, boolean z, boolean z2, int i);

    Intent zza(int[] iArr);

    void zza(long j);

    void zza(IBinder iBinder, Bundle bundle);

    void zza(Contents contents);

    void zza(zzbq zzbqVar);

    void zza(zzbq zzbqVar, int i);

    void zza(zzbq zzbqVar, int i, int i2, int i3);

    void zza(zzbq zzbqVar, int i, int i2, String[] strArr, Bundle bundle);

    void zza(zzbq zzbqVar, int i, boolean z, boolean z2);

    void zza(zzbq zzbqVar, int i, int[] iArr);

    void zza(zzbq zzbqVar, long j);

    void zza(zzbq zzbqVar, Bundle bundle, int i, int i2);

    void zza(zzbq zzbqVar, IBinder iBinder, int i, String[] strArr, Bundle bundle, boolean z, long j);

    void zza(zzbq zzbqVar, IBinder iBinder, String str, boolean z, long j);

    void zza(zzbq zzbqVar, String str);

    void zza(zzbq zzbqVar, String str, int i, int i2, int i3, boolean z);

    void zza(zzbq zzbqVar, String str, int i, IBinder iBinder, Bundle bundle);

    void zza(zzbq zzbqVar, String str, int i, boolean z, boolean z2);

    void zza(zzbq zzbqVar, String str, long j, String str2);

    void zza(zzbq zzbqVar, String str, IBinder iBinder, Bundle bundle);

    void zza(zzbq zzbqVar, String str, SnapshotMetadataChangeEntity snapshotMetadataChangeEntity, Contents contents);

    void zza(zzbq zzbqVar, String str, String str2);

    void zza(zzbq zzbqVar, String str, String str2, int i, int i2);

    void zza(zzbq zzbqVar, String str, String str2, SnapshotMetadataChangeEntity snapshotMetadataChangeEntity, Contents contents);

    void zza(zzbq zzbqVar, String str, boolean z);

    void zza(zzbq zzbqVar, String str, boolean z, int i);

    void zza(zzbq zzbqVar, String str, byte[] bArr, String str2, ParticipantResult[] participantResultArr);

    void zza(zzbq zzbqVar, String str, byte[] bArr, ParticipantResult[] participantResultArr);

    void zza(zzbq zzbqVar, boolean z);

    void zza(zzbq zzbqVar, boolean z, String[] strArr);

    void zza(zzbq zzbqVar, int[] iArr, int i, boolean z);

    void zza(zzbq zzbqVar, String[] strArr);

    void zza(zzbq zzbqVar, String[] strArr, boolean z);

    void zza(zzbs zzbsVar, long j);

    void zza(String str, int i);

    void zza(String str, IBinder iBinder, Bundle bundle);

    void zza(String str, zzbq zzbqVar);

    String zzau();

    int zzb(byte[] bArr, String str, String[] strArr);

    Intent zzb(String str, int i, int i2);

    void zzb(long j);

    void zzb(zzbq zzbqVar);

    void zzb(zzbq zzbqVar, int i);

    void zzb(zzbq zzbqVar, long j);

    void zzb(zzbq zzbqVar, String str);

    void zzb(zzbq zzbqVar, String str, int i, int i2, int i3, boolean z);

    void zzb(zzbq zzbqVar, String str, int i, IBinder iBinder, Bundle bundle);

    void zzb(zzbq zzbqVar, String str, IBinder iBinder, Bundle bundle);

    void zzb(zzbq zzbqVar, String str, String str2);

    void zzb(zzbq zzbqVar, String str, boolean z);

    void zzb(zzbq zzbqVar, boolean z);

    void zzb(zzbq zzbqVar, String[] strArr);

    void zzb(String str, int i);

    Intent zzba();

    Intent zzbc();

    Intent zzbd();

    Intent zzbe();

    Intent zzbl();

    Intent zzbn();

    int zzbp();

    String zzbr();

    int zzbt();

    Intent zzbv();

    int zzbw();

    int zzbx();

    int zzby();

    Intent zzc(int i, int i2, boolean z);

    void zzc(long j);

    void zzc(zzbq zzbqVar);

    void zzc(zzbq zzbqVar, long j);

    void zzc(zzbq zzbqVar, String str);

    void zzc(zzbq zzbqVar, boolean z);

    int zzca();

    boolean zzce();

    void zzci();

    String zzck();

    DataHolder zzcl();

    DataHolder zzcm();

    Intent zzcn();

    Intent zzd(String str);

    void zzd(long j);

    void zzd(zzbq zzbqVar);

    void zzd(zzbq zzbqVar, long j);

    void zzd(zzbq zzbqVar, String str);

    void zzd(zzbq zzbqVar, boolean z);

    void zzd(String str, int i);

    void zze(long j);

    void zze(zzbq zzbqVar, long j);

    void zze(zzbq zzbqVar, String str);

    void zze(zzbq zzbqVar, boolean z);

    void zzf(long j);

    void zzf(zzbq zzbqVar, String str);

    void zzf(zzbq zzbqVar, boolean z);

    void zzf(String str);

    void zzg(zzbq zzbqVar, String str);

    void zzh(zzbq zzbqVar, String str);

    void zzl(int i);
}
