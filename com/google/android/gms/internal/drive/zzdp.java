package com.google.android.gms.internal.drive;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.drive.Drive;
import com.google.android.gms.drive.DriveApi;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.DriveResource;
import com.google.android.gms.drive.MetadataChangeSet;
import com.google.android.gms.drive.events.ChangeListener;
import java.util.ArrayList;
import java.util.Set;

/* loaded from: classes.dex */
public class zzdp implements DriveResource {
    protected final DriveId a;

    public zzdp(DriveId driveId) {
        this.a = driveId;
    }

    @Override // com.google.android.gms.drive.DriveResource
    public PendingResult<Status> addChangeListener(GoogleApiClient googleApiClient, ChangeListener changeListener) {
        return ((zzaw) googleApiClient.getClient(Drive.CLIENT_KEY)).a(googleApiClient, this.a, changeListener);
    }

    @Override // com.google.android.gms.drive.DriveResource
    public PendingResult<Status> addChangeSubscription(GoogleApiClient googleApiClient) {
        zzaw zzawVar = (zzaw) googleApiClient.getClient(Drive.CLIENT_KEY);
        zzj zzjVar = new zzj(1, this.a);
        Preconditions.checkArgument(com.google.android.gms.drive.events.zzj.zza(zzjVar.b, zzjVar.a));
        Preconditions.checkState(zzawVar.isConnected(), "Client must be connected");
        if (zzawVar.d) {
            return googleApiClient.execute(new p(zzawVar, googleApiClient, zzjVar));
        }
        throw new IllegalStateException("Application must define an exported DriveEventService subclass in AndroidManifest.xml to add event subscriptions");
    }

    @Override // com.google.android.gms.drive.DriveResource
    public PendingResult<Status> delete(GoogleApiClient googleApiClient) {
        return googleApiClient.execute(new cd(this, googleApiClient));
    }

    @Override // com.google.android.gms.drive.DriveResource
    public DriveId getDriveId() {
        return this.a;
    }

    @Override // com.google.android.gms.drive.DriveResource
    public PendingResult<DriveResource.MetadataResult> getMetadata(GoogleApiClient googleApiClient) {
        return googleApiClient.enqueue(new bz(this, googleApiClient, false));
    }

    @Override // com.google.android.gms.drive.DriveResource
    public PendingResult<DriveApi.MetadataBufferResult> listParents(GoogleApiClient googleApiClient) {
        return googleApiClient.enqueue(new ca(this, googleApiClient));
    }

    @Override // com.google.android.gms.drive.DriveResource
    public PendingResult<Status> removeChangeListener(GoogleApiClient googleApiClient, ChangeListener changeListener) {
        return ((zzaw) googleApiClient.getClient(Drive.CLIENT_KEY)).b(googleApiClient, this.a, changeListener);
    }

    @Override // com.google.android.gms.drive.DriveResource
    public PendingResult<Status> removeChangeSubscription(GoogleApiClient googleApiClient) {
        zzaw zzawVar = (zzaw) googleApiClient.getClient(Drive.CLIENT_KEY);
        DriveId driveId = this.a;
        Preconditions.checkArgument(com.google.android.gms.drive.events.zzj.zza(1, driveId));
        Preconditions.checkState(zzawVar.isConnected(), "Client must be connected");
        return googleApiClient.execute(new q(zzawVar, googleApiClient, driveId, 1));
    }

    @Override // com.google.android.gms.drive.DriveResource
    public PendingResult<Status> setParents(GoogleApiClient googleApiClient, Set<DriveId> set) {
        if (set != null) {
            return googleApiClient.execute(new cb(this, googleApiClient, new ArrayList(set)));
        }
        throw new IllegalArgumentException("ParentIds must be provided.");
    }

    @Override // com.google.android.gms.drive.DriveResource
    public PendingResult<Status> trash(GoogleApiClient googleApiClient) {
        return googleApiClient.execute(new ce(this, googleApiClient));
    }

    @Override // com.google.android.gms.drive.DriveResource
    public PendingResult<Status> untrash(GoogleApiClient googleApiClient) {
        return googleApiClient.execute(new cf(this, googleApiClient));
    }

    @Override // com.google.android.gms.drive.DriveResource
    public PendingResult<DriveResource.MetadataResult> updateMetadata(GoogleApiClient googleApiClient, MetadataChangeSet metadataChangeSet) {
        if (metadataChangeSet != null) {
            return googleApiClient.execute(new cc(this, googleApiClient, metadataChangeSet));
        }
        throw new IllegalArgumentException("ChangeSet must be provided.");
    }
}
