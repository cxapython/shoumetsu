package com.google.android.gms.internal.drive;

import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.drive.DriveResource;
import com.google.android.gms.drive.Metadata;
import com.google.android.gms.drive.MetadataChangeSet;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes.dex */
final class bn extends TaskApiCall<zzaw, Metadata> {
    private final /* synthetic */ MetadataChangeSet a;
    private final /* synthetic */ DriveResource b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bn(zzch zzchVar, MetadataChangeSet metadataChangeSet, DriveResource driveResource) {
        this.a = metadataChangeSet;
        this.b = driveResource;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.api.internal.TaskApiCall
    public final /* synthetic */ void a(zzaw zzawVar, TaskCompletionSource<Metadata> taskCompletionSource) {
        zzaw zzawVar2 = zzawVar;
        this.a.zzp().zza(zzawVar2.getContext());
        ((zzeo) zzawVar2.getService()).zza(new zzgz(this.b.getDriveId(), this.a.zzp()), new zzhj(taskCompletionSource));
    }
}
