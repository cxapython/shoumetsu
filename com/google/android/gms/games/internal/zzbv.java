package com.google.android.gms.games.internal;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.games.GamesStatusCodes;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.games.multiplayer.ParticipantResult;
import com.google.android.gms.games.multiplayer.realtime.RoomEntity;
import com.google.android.gms.games.snapshot.SnapshotMetadataChangeEntity;
import com.google.android.gms.nearby.connection.ConnectionsStatusCodes;
import net.gree.gamelib.payment.PaymentError;

/* loaded from: classes.dex */
public final class zzbv extends com.google.android.gms.internal.games.zza implements zzbu {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbv(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.games.internal.IGamesService");
    }

    @Override // com.google.android.gms.games.internal.zzbu
    public final Bundle getConnectionHint() {
        Parcel a = a(5004, a());
        Bundle bundle = (Bundle) com.google.android.gms.internal.games.zzc.zza(a, Bundle.CREATOR);
        a.recycle();
        return bundle;
    }

    @Override // com.google.android.gms.games.internal.zzbu
    public final int zza(zzbq zzbqVar, byte[] bArr, String str, String str2) {
        Parcel a = a();
        com.google.android.gms.internal.games.zzc.zza(a, zzbqVar);
        a.writeByteArray(bArr);
        a.writeString(str);
        a.writeString(str2);
        Parcel a2 = a(5033, a);
        int readInt = a2.readInt();
        a2.recycle();
        return readInt;
    }

    @Override // com.google.android.gms.games.internal.zzbu
    public final Intent zza(int i, int i2, boolean z) {
        Parcel a = a();
        a.writeInt(i);
        a.writeInt(i2);
        com.google.android.gms.internal.games.zzc.writeBoolean(a, z);
        Parcel a2 = a(9008, a);
        Intent intent = (Intent) com.google.android.gms.internal.games.zzc.zza(a2, Intent.CREATOR);
        a2.recycle();
        return intent;
    }

    @Override // com.google.android.gms.games.internal.zzbu
    public final Intent zza(int i, byte[] bArr, int i2, String str) {
        Parcel a = a();
        a.writeInt(i);
        a.writeByteArray(bArr);
        a.writeInt(i2);
        a.writeString(str);
        Parcel a2 = a(10012, a);
        Intent intent = (Intent) com.google.android.gms.internal.games.zzc.zza(a2, Intent.CREATOR);
        a2.recycle();
        return intent;
    }

    @Override // com.google.android.gms.games.internal.zzbu
    public final Intent zza(PlayerEntity playerEntity) {
        Parcel a = a();
        com.google.android.gms.internal.games.zzc.zza(a, playerEntity);
        Parcel a2 = a(15503, a);
        Intent intent = (Intent) com.google.android.gms.internal.games.zzc.zza(a2, Intent.CREATOR);
        a2.recycle();
        return intent;
    }

    @Override // com.google.android.gms.games.internal.zzbu
    public final Intent zza(RoomEntity roomEntity, int i) {
        Parcel a = a();
        com.google.android.gms.internal.games.zzc.zza(a, roomEntity);
        a.writeInt(i);
        Parcel a2 = a(9011, a);
        Intent intent = (Intent) com.google.android.gms.internal.games.zzc.zza(a2, Intent.CREATOR);
        a2.recycle();
        return intent;
    }

    @Override // com.google.android.gms.games.internal.zzbu
    public final Intent zza(String str, boolean z, boolean z2, int i) {
        Parcel a = a();
        a.writeString(str);
        com.google.android.gms.internal.games.zzc.writeBoolean(a, z);
        com.google.android.gms.internal.games.zzc.writeBoolean(a, z2);
        a.writeInt(i);
        Parcel a2 = a(PaymentError.ERROR_CODE_QUERY_BALANCE_LIST_ERROR, a);
        Intent intent = (Intent) com.google.android.gms.internal.games.zzc.zza(a2, Intent.CREATOR);
        a2.recycle();
        return intent;
    }

    @Override // com.google.android.gms.games.internal.zzbu
    public final Intent zza(int[] iArr) {
        Parcel a = a();
        a.writeIntArray(iArr);
        Parcel a2 = a(12030, a);
        Intent intent = (Intent) com.google.android.gms.internal.games.zzc.zza(a2, Intent.CREATOR);
        a2.recycle();
        return intent;
    }

    @Override // com.google.android.gms.games.internal.zzbu
    public final void zza(long j) {
        Parcel a = a();
        a.writeLong(j);
        b(PaymentError.ERROR_CODE_REQUEST_MIGRATION_CODE_ERROR, a);
    }

    @Override // com.google.android.gms.games.internal.zzbu
    public final void zza(IBinder iBinder, Bundle bundle) {
        Parcel a = a();
        a.writeStrongBinder(iBinder);
        com.google.android.gms.internal.games.zzc.zza(a, bundle);
        b(5005, a);
    }

    @Override // com.google.android.gms.games.internal.zzbu
    public final void zza(Contents contents) {
        Parcel a = a();
        com.google.android.gms.internal.games.zzc.zza(a, contents);
        b(12019, a);
    }

    @Override // com.google.android.gms.games.internal.zzbu
    public final void zza(zzbq zzbqVar) {
        Parcel a = a();
        com.google.android.gms.internal.games.zzc.zza(a, zzbqVar);
        b(PaymentError.ERROR_CODE_REQUEST_MIGRATION_CODE_CAN_NOT_RENEW, a);
    }

    @Override // com.google.android.gms.games.internal.zzbu
    public final void zza(zzbq zzbqVar, int i) {
        Parcel a = a();
        com.google.android.gms.internal.games.zzc.zza(a, zzbqVar);
        a.writeInt(i);
        b(10016, a);
    }

    @Override // com.google.android.gms.games.internal.zzbu
    public final void zza(zzbq zzbqVar, int i, int i2, int i3) {
        Parcel a = a();
        com.google.android.gms.internal.games.zzc.zza(a, zzbqVar);
        a.writeInt(i);
        a.writeInt(i2);
        a.writeInt(i3);
        b(10009, a);
    }

    @Override // com.google.android.gms.games.internal.zzbu
    public final void zza(zzbq zzbqVar, int i, int i2, String[] strArr, Bundle bundle) {
        Parcel a = a();
        com.google.android.gms.internal.games.zzc.zza(a, zzbqVar);
        a.writeInt(i);
        a.writeInt(i2);
        a.writeStringArray(strArr);
        com.google.android.gms.internal.games.zzc.zza(a, bundle);
        b(8004, a);
    }

    @Override // com.google.android.gms.games.internal.zzbu
    public final void zza(zzbq zzbqVar, int i, boolean z, boolean z2) {
        Parcel a = a();
        com.google.android.gms.internal.games.zzc.zza(a, zzbqVar);
        a.writeInt(i);
        com.google.android.gms.internal.games.zzc.writeBoolean(a, z);
        com.google.android.gms.internal.games.zzc.writeBoolean(a, z2);
        b(5015, a);
    }

    @Override // com.google.android.gms.games.internal.zzbu
    public final void zza(zzbq zzbqVar, int i, int[] iArr) {
        Parcel a = a();
        com.google.android.gms.internal.games.zzc.zza(a, zzbqVar);
        a.writeInt(i);
        a.writeIntArray(iArr);
        b(10018, a);
    }

    @Override // com.google.android.gms.games.internal.zzbu
    public final void zza(zzbq zzbqVar, long j) {
        Parcel a = a();
        com.google.android.gms.internal.games.zzc.zza(a, zzbqVar);
        a.writeLong(j);
        b(5058, a);
    }

    @Override // com.google.android.gms.games.internal.zzbu
    public final void zza(zzbq zzbqVar, Bundle bundle, int i, int i2) {
        Parcel a = a();
        com.google.android.gms.internal.games.zzc.zza(a, zzbqVar);
        com.google.android.gms.internal.games.zzc.zza(a, bundle);
        a.writeInt(i);
        a.writeInt(i2);
        b(5021, a);
    }

    @Override // com.google.android.gms.games.internal.zzbu
    public final void zza(zzbq zzbqVar, IBinder iBinder, int i, String[] strArr, Bundle bundle, boolean z, long j) {
        Parcel a = a();
        com.google.android.gms.internal.games.zzc.zza(a, zzbqVar);
        a.writeStrongBinder(iBinder);
        a.writeInt(i);
        a.writeStringArray(strArr);
        com.google.android.gms.internal.games.zzc.zza(a, bundle);
        com.google.android.gms.internal.games.zzc.writeBoolean(a, false);
        a.writeLong(j);
        b(5030, a);
    }

    @Override // com.google.android.gms.games.internal.zzbu
    public final void zza(zzbq zzbqVar, IBinder iBinder, String str, boolean z, long j) {
        Parcel a = a();
        com.google.android.gms.internal.games.zzc.zza(a, zzbqVar);
        a.writeStrongBinder(iBinder);
        a.writeString(str);
        com.google.android.gms.internal.games.zzc.writeBoolean(a, false);
        a.writeLong(j);
        b(5031, a);
    }

    @Override // com.google.android.gms.games.internal.zzbu
    public final void zza(zzbq zzbqVar, String str) {
        Parcel a = a();
        com.google.android.gms.internal.games.zzc.zza(a, zzbqVar);
        a.writeString(str);
        b(5032, a);
    }

    @Override // com.google.android.gms.games.internal.zzbu
    public final void zza(zzbq zzbqVar, String str, int i, int i2, int i3, boolean z) {
        Parcel a = a();
        com.google.android.gms.internal.games.zzc.zza(a, zzbqVar);
        a.writeString(str);
        a.writeInt(i);
        a.writeInt(i2);
        a.writeInt(i3);
        com.google.android.gms.internal.games.zzc.writeBoolean(a, z);
        b(5019, a);
    }

    @Override // com.google.android.gms.games.internal.zzbu
    public final void zza(zzbq zzbqVar, String str, int i, IBinder iBinder, Bundle bundle) {
        Parcel a = a();
        com.google.android.gms.internal.games.zzc.zza(a, zzbqVar);
        a.writeString(str);
        a.writeInt(i);
        a.writeStrongBinder(iBinder);
        com.google.android.gms.internal.games.zzc.zza(a, bundle);
        b(5025, a);
    }

    @Override // com.google.android.gms.games.internal.zzbu
    public final void zza(zzbq zzbqVar, String str, int i, boolean z, boolean z2) {
        Parcel a = a();
        com.google.android.gms.internal.games.zzc.zza(a, zzbqVar);
        a.writeString(str);
        a.writeInt(i);
        com.google.android.gms.internal.games.zzc.writeBoolean(a, z);
        com.google.android.gms.internal.games.zzc.writeBoolean(a, z2);
        b(9020, a);
    }

    @Override // com.google.android.gms.games.internal.zzbu
    public final void zza(zzbq zzbqVar, String str, long j, String str2) {
        Parcel a = a();
        com.google.android.gms.internal.games.zzc.zza(a, zzbqVar);
        a.writeString(str);
        a.writeLong(j);
        a.writeString(str2);
        b(7002, a);
    }

    @Override // com.google.android.gms.games.internal.zzbu
    public final void zza(zzbq zzbqVar, String str, IBinder iBinder, Bundle bundle) {
        Parcel a = a();
        com.google.android.gms.internal.games.zzc.zza(a, zzbqVar);
        a.writeString(str);
        a.writeStrongBinder(iBinder);
        com.google.android.gms.internal.games.zzc.zza(a, bundle);
        b(5023, a);
    }

    @Override // com.google.android.gms.games.internal.zzbu
    public final void zza(zzbq zzbqVar, String str, SnapshotMetadataChangeEntity snapshotMetadataChangeEntity, Contents contents) {
        Parcel a = a();
        com.google.android.gms.internal.games.zzc.zza(a, zzbqVar);
        a.writeString(str);
        com.google.android.gms.internal.games.zzc.zza(a, snapshotMetadataChangeEntity);
        com.google.android.gms.internal.games.zzc.zza(a, contents);
        b(12007, a);
    }

    @Override // com.google.android.gms.games.internal.zzbu
    public final void zza(zzbq zzbqVar, String str, String str2) {
        Parcel a = a();
        com.google.android.gms.internal.games.zzc.zza(a, zzbqVar);
        a.writeString(str);
        a.writeString(str2);
        b(8011, a);
    }

    @Override // com.google.android.gms.games.internal.zzbu
    public final void zza(zzbq zzbqVar, String str, String str2, int i, int i2) {
        Parcel a = a();
        com.google.android.gms.internal.games.zzc.zza(a, zzbqVar);
        a.writeString(null);
        a.writeString(str2);
        a.writeInt(i);
        a.writeInt(i2);
        b(8001, a);
    }

    @Override // com.google.android.gms.games.internal.zzbu
    public final void zza(zzbq zzbqVar, String str, String str2, SnapshotMetadataChangeEntity snapshotMetadataChangeEntity, Contents contents) {
        Parcel a = a();
        com.google.android.gms.internal.games.zzc.zza(a, zzbqVar);
        a.writeString(str);
        a.writeString(str2);
        com.google.android.gms.internal.games.zzc.zza(a, snapshotMetadataChangeEntity);
        com.google.android.gms.internal.games.zzc.zza(a, contents);
        b(12033, a);
    }

    @Override // com.google.android.gms.games.internal.zzbu
    public final void zza(zzbq zzbqVar, String str, boolean z) {
        Parcel a = a();
        com.google.android.gms.internal.games.zzc.zza(a, zzbqVar);
        a.writeString(str);
        com.google.android.gms.internal.games.zzc.writeBoolean(a, z);
        b(GamesStatusCodes.STATUS_MATCH_ERROR_INVALID_MATCH_RESULTS, a);
    }

    @Override // com.google.android.gms.games.internal.zzbu
    public final void zza(zzbq zzbqVar, String str, boolean z, int i) {
        Parcel a = a();
        com.google.android.gms.internal.games.zzc.zza(a, zzbqVar);
        a.writeString(str);
        com.google.android.gms.internal.games.zzc.writeBoolean(a, z);
        a.writeInt(i);
        b(PaymentError.ERROR_CODE_QUERY_PRODUCT_LIST_ERROR, a);
    }

    @Override // com.google.android.gms.games.internal.zzbu
    public final void zza(zzbq zzbqVar, String str, byte[] bArr, String str2, ParticipantResult[] participantResultArr) {
        Parcel a = a();
        com.google.android.gms.internal.games.zzc.zza(a, zzbqVar);
        a.writeString(str);
        a.writeByteArray(bArr);
        a.writeString(str2);
        a.writeTypedArray(participantResultArr, 0);
        b(ConnectionsStatusCodes.STATUS_BLUETOOTH_ERROR, a);
    }

    @Override // com.google.android.gms.games.internal.zzbu
    public final void zza(zzbq zzbqVar, String str, byte[] bArr, ParticipantResult[] participantResultArr) {
        Parcel a = a();
        com.google.android.gms.internal.games.zzc.zza(a, zzbqVar);
        a.writeString(str);
        a.writeByteArray(bArr);
        a.writeTypedArray(participantResultArr, 0);
        b(ConnectionsStatusCodes.STATUS_ALREADY_HAVE_ACTIVE_STRATEGY, a);
    }

    @Override // com.google.android.gms.games.internal.zzbu
    public final void zza(zzbq zzbqVar, boolean z) {
        Parcel a = a();
        com.google.android.gms.internal.games.zzc.zza(a, zzbqVar);
        com.google.android.gms.internal.games.zzc.writeBoolean(a, z);
        b(6001, a);
    }

    @Override // com.google.android.gms.games.internal.zzbu
    public final void zza(zzbq zzbqVar, boolean z, String[] strArr) {
        Parcel a = a();
        com.google.android.gms.internal.games.zzc.zza(a, zzbqVar);
        com.google.android.gms.internal.games.zzc.writeBoolean(a, z);
        a.writeStringArray(strArr);
        b(12031, a);
    }

    @Override // com.google.android.gms.games.internal.zzbu
    public final void zza(zzbq zzbqVar, int[] iArr, int i, boolean z) {
        Parcel a = a();
        com.google.android.gms.internal.games.zzc.zza(a, zzbqVar);
        a.writeIntArray(iArr);
        a.writeInt(i);
        com.google.android.gms.internal.games.zzc.writeBoolean(a, z);
        b(12010, a);
    }

    @Override // com.google.android.gms.games.internal.zzbu
    public final void zza(zzbq zzbqVar, String[] strArr) {
        Parcel a = a();
        com.google.android.gms.internal.games.zzc.zza(a, zzbqVar);
        a.writeStringArray(strArr);
        b(10006, a);
    }

    @Override // com.google.android.gms.games.internal.zzbu
    public final void zza(zzbq zzbqVar, String[] strArr, boolean z) {
        Parcel a = a();
        com.google.android.gms.internal.games.zzc.zza(a, zzbqVar);
        a.writeStringArray(strArr);
        com.google.android.gms.internal.games.zzc.writeBoolean(a, z);
        b(12029, a);
    }

    @Override // com.google.android.gms.games.internal.zzbu
    public final void zza(zzbs zzbsVar, long j) {
        Parcel a = a();
        com.google.android.gms.internal.games.zzc.zza(a, zzbsVar);
        a.writeLong(j);
        b(15501, a);
    }

    @Override // com.google.android.gms.games.internal.zzbu
    public final void zza(String str, int i) {
        Parcel a = a();
        a.writeString(str);
        a.writeInt(i);
        b(12017, a);
    }

    @Override // com.google.android.gms.games.internal.zzbu
    public final void zza(String str, IBinder iBinder, Bundle bundle) {
        Parcel a = a();
        a.writeString(str);
        a.writeStrongBinder(iBinder);
        com.google.android.gms.internal.games.zzc.zza(a, bundle);
        b(13002, a);
    }

    @Override // com.google.android.gms.games.internal.zzbu
    public final void zza(String str, zzbq zzbqVar) {
        Parcel a = a();
        a.writeString(str);
        com.google.android.gms.internal.games.zzc.zza(a, zzbqVar);
        b(PaymentError.ERROR_CODE_VERIFY_AGE_CONTRADICT_AGE_GROUP_BIRTHDAY, a);
    }

    @Override // com.google.android.gms.games.internal.zzbu
    public final String zzau() {
        Parcel a = a(5007, a());
        String readString = a.readString();
        a.recycle();
        return readString;
    }

    @Override // com.google.android.gms.games.internal.zzbu
    public final int zzb(byte[] bArr, String str, String[] strArr) {
        Parcel a = a();
        a.writeByteArray(bArr);
        a.writeString(str);
        a.writeStringArray(strArr);
        Parcel a2 = a(5034, a);
        int readInt = a2.readInt();
        a2.recycle();
        return readInt;
    }

    @Override // com.google.android.gms.games.internal.zzbu
    public final Intent zzb(String str, int i, int i2) {
        Parcel a = a();
        a.writeString(str);
        a.writeInt(i);
        a.writeInt(i2);
        Parcel a2 = a(18001, a);
        Intent intent = (Intent) com.google.android.gms.internal.games.zzc.zza(a2, Intent.CREATOR);
        a2.recycle();
        return intent;
    }

    @Override // com.google.android.gms.games.internal.zzbu
    public final void zzb(long j) {
        Parcel a = a();
        a.writeLong(j);
        b(5059, a);
    }

    @Override // com.google.android.gms.games.internal.zzbu
    public final void zzb(zzbq zzbqVar) {
        Parcel a = a();
        com.google.android.gms.internal.games.zzc.zza(a, zzbqVar);
        b(5026, a);
    }

    @Override // com.google.android.gms.games.internal.zzbu
    public final void zzb(zzbq zzbqVar, int i) {
        Parcel a = a();
        com.google.android.gms.internal.games.zzc.zza(a, zzbqVar);
        a.writeInt(i);
        b(22016, a);
    }

    @Override // com.google.android.gms.games.internal.zzbu
    public final void zzb(zzbq zzbqVar, long j) {
        Parcel a = a();
        com.google.android.gms.internal.games.zzc.zza(a, zzbqVar);
        a.writeLong(j);
        b(8012, a);
    }

    @Override // com.google.android.gms.games.internal.zzbu
    public final void zzb(zzbq zzbqVar, String str) {
        Parcel a = a();
        com.google.android.gms.internal.games.zzc.zza(a, zzbqVar);
        a.writeString(str);
        b(ConnectionsStatusCodes.STATUS_NOT_CONNECTED_TO_ENDPOINT, a);
    }

    @Override // com.google.android.gms.games.internal.zzbu
    public final void zzb(zzbq zzbqVar, String str, int i, int i2, int i3, boolean z) {
        Parcel a = a();
        com.google.android.gms.internal.games.zzc.zza(a, zzbqVar);
        a.writeString(str);
        a.writeInt(i);
        a.writeInt(i2);
        a.writeInt(i3);
        com.google.android.gms.internal.games.zzc.writeBoolean(a, z);
        b(5020, a);
    }

    @Override // com.google.android.gms.games.internal.zzbu
    public final void zzb(zzbq zzbqVar, String str, int i, IBinder iBinder, Bundle bundle) {
        Parcel a = a();
        com.google.android.gms.internal.games.zzc.zza(a, zzbqVar);
        a.writeString(str);
        a.writeInt(i);
        a.writeStrongBinder(iBinder);
        com.google.android.gms.internal.games.zzc.zza(a, bundle);
        b(7003, a);
    }

    @Override // com.google.android.gms.games.internal.zzbu
    public final void zzb(zzbq zzbqVar, String str, IBinder iBinder, Bundle bundle) {
        Parcel a = a();
        com.google.android.gms.internal.games.zzc.zza(a, zzbqVar);
        a.writeString(str);
        a.writeStrongBinder(iBinder);
        com.google.android.gms.internal.games.zzc.zza(a, bundle);
        b(5024, a);
    }

    @Override // com.google.android.gms.games.internal.zzbu
    public final void zzb(zzbq zzbqVar, String str, String str2) {
        Parcel a = a();
        com.google.android.gms.internal.games.zzc.zza(a, zzbqVar);
        a.writeString(str);
        a.writeString(str2);
        b(12009, a);
    }

    @Override // com.google.android.gms.games.internal.zzbu
    public final void zzb(zzbq zzbqVar, String str, boolean z) {
        Parcel a = a();
        com.google.android.gms.internal.games.zzc.zza(a, zzbqVar);
        a.writeString(str);
        com.google.android.gms.internal.games.zzc.writeBoolean(a, z);
        b(13006, a);
    }

    @Override // com.google.android.gms.games.internal.zzbu
    public final void zzb(zzbq zzbqVar, boolean z) {
        Parcel a = a();
        com.google.android.gms.internal.games.zzc.zza(a, zzbqVar);
        com.google.android.gms.internal.games.zzc.writeBoolean(a, z);
        b(GamesStatusCodes.STATUS_MATCH_ERROR_OUT_OF_DATE_VERSION, a);
    }

    @Override // com.google.android.gms.games.internal.zzbu
    public final void zzb(zzbq zzbqVar, String[] strArr) {
        Parcel a = a();
        com.google.android.gms.internal.games.zzc.zza(a, zzbqVar);
        a.writeStringArray(strArr);
        b(10007, a);
    }

    @Override // com.google.android.gms.games.internal.zzbu
    public final void zzb(String str, int i) {
        Parcel a = a();
        a.writeString(str);
        a.writeInt(i);
        b(5029, a);
    }

    @Override // com.google.android.gms.games.internal.zzbu
    public final Intent zzba() {
        Parcel a = a(GamesStatusCodes.STATUS_VIDEO_STORAGE_ERROR, a());
        Intent intent = (Intent) com.google.android.gms.internal.games.zzc.zza(a, Intent.CREATOR);
        a.recycle();
        return intent;
    }

    @Override // com.google.android.gms.games.internal.zzbu
    public final Intent zzbc() {
        Parcel a = a(9005, a());
        Intent intent = (Intent) com.google.android.gms.internal.games.zzc.zza(a, Intent.CREATOR);
        a.recycle();
        return intent;
    }

    @Override // com.google.android.gms.games.internal.zzbu
    public final Intent zzbd() {
        Parcel a = a(GamesStatusCodes.STATUS_VIDEO_ALREADY_CAPTURING, a());
        Intent intent = (Intent) com.google.android.gms.internal.games.zzc.zza(a, Intent.CREATOR);
        a.recycle();
        return intent;
    }

    @Override // com.google.android.gms.games.internal.zzbu
    public final Intent zzbe() {
        Parcel a = a(9007, a());
        Intent intent = (Intent) com.google.android.gms.internal.games.zzc.zza(a, Intent.CREATOR);
        a.recycle();
        return intent;
    }

    @Override // com.google.android.gms.games.internal.zzbu
    public final Intent zzbl() {
        Parcel a = a(9010, a());
        Intent intent = (Intent) com.google.android.gms.internal.games.zzc.zza(a, Intent.CREATOR);
        a.recycle();
        return intent;
    }

    @Override // com.google.android.gms.games.internal.zzbu
    public final Intent zzbn() {
        Parcel a = a(9012, a());
        Intent intent = (Intent) com.google.android.gms.internal.games.zzc.zza(a, Intent.CREATOR);
        a.recycle();
        return intent;
    }

    @Override // com.google.android.gms.games.internal.zzbu
    public final int zzbp() {
        Parcel a = a(9019, a());
        int readInt = a.readInt();
        a.recycle();
        return readInt;
    }

    @Override // com.google.android.gms.games.internal.zzbu
    public final String zzbr() {
        Parcel a = a(5003, a());
        String readString = a.readString();
        a.recycle();
        return readString;
    }

    @Override // com.google.android.gms.games.internal.zzbu
    public final int zzbt() {
        Parcel a = a(8024, a());
        int readInt = a.readInt();
        a.recycle();
        return readInt;
    }

    @Override // com.google.android.gms.games.internal.zzbu
    public final Intent zzbv() {
        Parcel a = a(10015, a());
        Intent intent = (Intent) com.google.android.gms.internal.games.zzc.zza(a, Intent.CREATOR);
        a.recycle();
        return intent;
    }

    @Override // com.google.android.gms.games.internal.zzbu
    public final int zzbw() {
        Parcel a = a(10013, a());
        int readInt = a.readInt();
        a.recycle();
        return readInt;
    }

    @Override // com.google.android.gms.games.internal.zzbu
    public final int zzbx() {
        Parcel a = a(10023, a());
        int readInt = a.readInt();
        a.recycle();
        return readInt;
    }

    @Override // com.google.android.gms.games.internal.zzbu
    public final int zzby() {
        Parcel a = a(12035, a());
        int readInt = a.readInt();
        a.recycle();
        return readInt;
    }

    @Override // com.google.android.gms.games.internal.zzbu
    public final Intent zzc(int i, int i2, boolean z) {
        Parcel a = a();
        a.writeInt(i);
        a.writeInt(i2);
        com.google.android.gms.internal.games.zzc.writeBoolean(a, z);
        Parcel a2 = a(GamesStatusCodes.STATUS_VIDEO_OUT_OF_DISK_SPACE, a);
        Intent intent = (Intent) com.google.android.gms.internal.games.zzc.zza(a2, Intent.CREATOR);
        a2.recycle();
        return intent;
    }

    @Override // com.google.android.gms.games.internal.zzbu
    public final void zzc(long j) {
        Parcel a = a();
        a.writeLong(j);
        b(ConnectionsStatusCodes.STATUS_PAYLOAD_IO_ERROR, a);
    }

    @Override // com.google.android.gms.games.internal.zzbu
    public final void zzc(zzbq zzbqVar) {
        Parcel a = a();
        com.google.android.gms.internal.games.zzc.zza(a, zzbqVar);
        b(21007, a);
    }

    @Override // com.google.android.gms.games.internal.zzbu
    public final void zzc(zzbq zzbqVar, long j) {
        Parcel a = a();
        com.google.android.gms.internal.games.zzc.zza(a, zzbqVar);
        a.writeLong(j);
        b(10001, a);
    }

    @Override // com.google.android.gms.games.internal.zzbu
    public final void zzc(zzbq zzbqVar, String str) {
        Parcel a = a();
        com.google.android.gms.internal.games.zzc.zza(a, zzbqVar);
        a.writeString(str);
        b(8006, a);
    }

    @Override // com.google.android.gms.games.internal.zzbu
    public final void zzc(zzbq zzbqVar, boolean z) {
        Parcel a = a();
        com.google.android.gms.internal.games.zzc.zza(a, zzbqVar);
        com.google.android.gms.internal.games.zzc.writeBoolean(a, z);
        b(8027, a);
    }

    @Override // com.google.android.gms.games.internal.zzbu
    public final int zzca() {
        Parcel a = a(12036, a());
        int readInt = a.readInt();
        a.recycle();
        return readInt;
    }

    @Override // com.google.android.gms.games.internal.zzbu
    public final boolean zzce() {
        Parcel a = a(22030, a());
        boolean zza = com.google.android.gms.internal.games.zzc.zza(a);
        a.recycle();
        return zza;
    }

    @Override // com.google.android.gms.games.internal.zzbu
    public final void zzci() {
        b(5006, a());
    }

    @Override // com.google.android.gms.games.internal.zzbu
    public final String zzck() {
        Parcel a = a(5012, a());
        String readString = a.readString();
        a.recycle();
        return readString;
    }

    @Override // com.google.android.gms.games.internal.zzbu
    public final DataHolder zzcl() {
        Parcel a = a(5013, a());
        DataHolder dataHolder = (DataHolder) com.google.android.gms.internal.games.zzc.zza(a, DataHolder.CREATOR);
        a.recycle();
        return dataHolder;
    }

    @Override // com.google.android.gms.games.internal.zzbu
    public final DataHolder zzcm() {
        Parcel a = a(5502, a());
        DataHolder dataHolder = (DataHolder) com.google.android.gms.internal.games.zzc.zza(a, DataHolder.CREATOR);
        a.recycle();
        return dataHolder;
    }

    @Override // com.google.android.gms.games.internal.zzbu
    public final Intent zzcn() {
        Parcel a = a(19002, a());
        Intent intent = (Intent) com.google.android.gms.internal.games.zzc.zza(a, Intent.CREATOR);
        a.recycle();
        return intent;
    }

    @Override // com.google.android.gms.games.internal.zzbu
    public final Intent zzd(String str) {
        Parcel a = a();
        a.writeString(str);
        Parcel a2 = a(12034, a);
        Intent intent = (Intent) com.google.android.gms.internal.games.zzc.zza(a2, Intent.CREATOR);
        a2.recycle();
        return intent;
    }

    @Override // com.google.android.gms.games.internal.zzbu
    public final void zzd(long j) {
        Parcel a = a();
        a.writeLong(j);
        b(10002, a);
    }

    @Override // com.google.android.gms.games.internal.zzbu
    public final void zzd(zzbq zzbqVar) {
        Parcel a = a();
        com.google.android.gms.internal.games.zzc.zza(a, zzbqVar);
        b(22028, a);
    }

    @Override // com.google.android.gms.games.internal.zzbu
    public final void zzd(zzbq zzbqVar, long j) {
        Parcel a = a();
        com.google.android.gms.internal.games.zzc.zza(a, zzbqVar);
        a.writeLong(j);
        b(12011, a);
    }

    @Override // com.google.android.gms.games.internal.zzbu
    public final void zzd(zzbq zzbqVar, String str) {
        Parcel a = a();
        com.google.android.gms.internal.games.zzc.zza(a, zzbqVar);
        a.writeString(str);
        b(ConnectionsStatusCodes.STATUS_OUT_OF_ORDER_API_CALL, a);
    }

    @Override // com.google.android.gms.games.internal.zzbu
    public final void zzd(zzbq zzbqVar, boolean z) {
        Parcel a = a();
        com.google.android.gms.internal.games.zzc.zza(a, zzbqVar);
        com.google.android.gms.internal.games.zzc.writeBoolean(a, z);
        b(12002, a);
    }

    @Override // com.google.android.gms.games.internal.zzbu
    public final void zzd(String str, int i) {
        Parcel a = a();
        a.writeString(str);
        a.writeInt(i);
        b(5028, a);
    }

    @Override // com.google.android.gms.games.internal.zzbu
    public final void zze(long j) {
        Parcel a = a();
        a.writeLong(j);
        b(12012, a);
    }

    @Override // com.google.android.gms.games.internal.zzbu
    public final void zze(zzbq zzbqVar, long j) {
        Parcel a = a();
        com.google.android.gms.internal.games.zzc.zza(a, zzbqVar);
        a.writeLong(j);
        b(22026, a);
    }

    @Override // com.google.android.gms.games.internal.zzbu
    public final void zze(zzbq zzbqVar, String str) {
        Parcel a = a();
        com.google.android.gms.internal.games.zzc.zza(a, zzbqVar);
        a.writeString(str);
        b(8010, a);
    }

    @Override // com.google.android.gms.games.internal.zzbu
    public final void zze(zzbq zzbqVar, boolean z) {
        Parcel a = a();
        com.google.android.gms.internal.games.zzc.zza(a, zzbqVar);
        com.google.android.gms.internal.games.zzc.writeBoolean(a, z);
        b(12016, a);
    }

    @Override // com.google.android.gms.games.internal.zzbu
    public final void zzf(long j) {
        Parcel a = a();
        a.writeLong(j);
        b(22027, a);
    }

    @Override // com.google.android.gms.games.internal.zzbu
    public final void zzf(zzbq zzbqVar, String str) {
        Parcel a = a();
        com.google.android.gms.internal.games.zzc.zza(a, zzbqVar);
        a.writeString(str);
        b(8014, a);
    }

    @Override // com.google.android.gms.games.internal.zzbu
    public final void zzf(zzbq zzbqVar, boolean z) {
        Parcel a = a();
        com.google.android.gms.internal.games.zzc.zza(a, zzbqVar);
        com.google.android.gms.internal.games.zzc.writeBoolean(a, z);
        b(PaymentError.ERROR_CODE_SUBMIT_PRODUCT_ID_IS_NOT_EXIST, a);
    }

    @Override // com.google.android.gms.games.internal.zzbu
    public final void zzf(String str) {
        Parcel a = a();
        a.writeString(str);
        b(8002, a);
    }

    @Override // com.google.android.gms.games.internal.zzbu
    public final void zzg(zzbq zzbqVar, String str) {
        Parcel a = a();
        com.google.android.gms.internal.games.zzc.zza(a, zzbqVar);
        a.writeString(str);
        b(12020, a);
    }

    @Override // com.google.android.gms.games.internal.zzbu
    public final void zzh(zzbq zzbqVar, String str) {
        Parcel a = a();
        com.google.android.gms.internal.games.zzc.zza(a, zzbqVar);
        a.writeString(str);
        b(12008, a);
    }

    @Override // com.google.android.gms.games.internal.zzbu
    public final void zzl(int i) {
        Parcel a = a();
        a.writeInt(i);
        b(5036, a);
    }
}
