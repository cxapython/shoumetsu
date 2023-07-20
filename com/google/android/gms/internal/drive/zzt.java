package com.google.android.gms.internal.drive;

import android.content.IntentSender;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.drive.Drive;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.MetadataChangeSet;

@Deprecated
/* loaded from: classes.dex */
public final class zzt {
    private MetadataChangeSet a;
    private Integer b;
    private String c;
    private DriveId d;
    private final int e = 0;

    public zzt(int i) {
    }

    public final IntentSender build(GoogleApiClient googleApiClient) {
        Preconditions.checkState(googleApiClient.isConnected(), "Client must be connected");
        zzf();
        zzaw zzawVar = (zzaw) googleApiClient.getClient(Drive.CLIENT_KEY);
        this.a.zzp().zza(zzawVar.getContext());
        try {
            return ((zzeo) zzawVar.getService()).zza(new zzu(this.a.zzp(), this.b.intValue(), this.c, this.d, 0));
        } catch (RemoteException e) {
            throw new RuntimeException("Unable to connect Drive Play Service", e);
        }
    }

    public final int getRequestId() {
        return this.b.intValue();
    }

    public final void zza(DriveId driveId) {
        this.d = (DriveId) Preconditions.checkNotNull(driveId);
    }

    public final void zza(MetadataChangeSet metadataChangeSet) {
        this.a = (MetadataChangeSet) Preconditions.checkNotNull(metadataChangeSet);
    }

    public final MetadataChangeSet zzb() {
        return this.a;
    }

    public final DriveId zzc() {
        return this.d;
    }

    public final void zzc(String str) {
        this.c = (String) Preconditions.checkNotNull(str);
    }

    public final String zzd() {
        return this.c;
    }

    public final void zzd(int i) {
        this.b = Integer.valueOf(i);
    }

    public final void zzf() {
        Preconditions.checkNotNull(this.a, "Must provide initial metadata via setInitialMetadata.");
        Integer num = this.b;
        this.b = Integer.valueOf(num == null ? 0 : num.intValue());
    }
}
