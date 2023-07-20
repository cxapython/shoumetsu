package com.google.android.gms.internal.drive;

import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.drive.DriveFolder;
import com.google.android.gms.drive.MetadataChangeSet;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes.dex */
final class bl extends TaskApiCall<zzaw, DriveFolder> {
    private final /* synthetic */ MetadataChangeSet a;
    private final /* synthetic */ DriveFolder b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bl(zzch zzchVar, MetadataChangeSet metadataChangeSet, DriveFolder driveFolder) {
        this.a = metadataChangeSet;
        this.b = driveFolder;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.api.internal.TaskApiCall
    public final /* synthetic */ void a(zzaw zzawVar, TaskCompletionSource<DriveFolder> taskCompletionSource) {
        zzaw zzawVar2 = zzawVar;
        this.a.zzp().zza(zzawVar2.getContext());
        ((zzeo) zzawVar2.getService()).zza(new zzy(this.b.getDriveId(), this.a.zzp()), new zzhe(taskCompletionSource));
    }
}
