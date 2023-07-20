package com.google.android.gms.internal.drive;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.MetadataChangeSet;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class y extends zzav {
    private final /* synthetic */ MetadataChangeSet b;
    private final /* synthetic */ com.google.android.gms.drive.zzn c;
    private final /* synthetic */ zzbi d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y(zzbi zzbiVar, GoogleApiClient googleApiClient, MetadataChangeSet metadataChangeSet, com.google.android.gms.drive.zzn zznVar) {
        super(googleApiClient);
        this.d = zzbiVar;
        this.b = metadataChangeSet;
        this.c = zznVar;
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    protected final /* synthetic */ void a(zzaw zzawVar) {
        Contents contents;
        Contents contents2;
        Contents contents3;
        zzaw zzawVar2 = zzawVar;
        this.b.zzp().zza(zzawVar2.getContext());
        contents = this.d.b;
        DriveId driveId = contents.getDriveId();
        MetadataBundle zzp = this.b.zzp();
        contents2 = this.d.b;
        int requestId = contents2.getRequestId();
        contents3 = this.d.b;
        ((zzeo) zzawVar2.getService()).zza(new zzm(driveId, zzp, requestId, contents3.zza(), this.c), new zzgs(this));
    }
}
