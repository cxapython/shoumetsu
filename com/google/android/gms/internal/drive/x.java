package com.google.android.gms.internal.drive;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.drive.DriveId;

/* loaded from: classes.dex */
final class x extends g {
    private final /* synthetic */ zzbi b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x(zzbi zzbiVar, GoogleApiClient googleApiClient) {
        super(googleApiClient);
        this.b = zzbiVar;
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    protected final /* synthetic */ void a(zzaw zzawVar) {
        Contents contents;
        DriveId driveId = this.b.getDriveId();
        contents = this.b.b;
        ((zzeo) zzawVar.getService()).zza(new zzgd(driveId, DriveFile.MODE_WRITE_ONLY, contents.getRequestId()), new cn(this, null));
    }
}
