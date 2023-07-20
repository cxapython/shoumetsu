package com.google.android.gms.internal.drive;

import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.drive.DriveContents;
import com.google.android.gms.drive.MetadataChangeSet;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes.dex */
final class bh extends TaskApiCall<zzaw, Void> {
    private final /* synthetic */ com.google.android.gms.drive.zzn a;
    private final /* synthetic */ DriveContents b;
    private final /* synthetic */ MetadataChangeSet c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bh(zzch zzchVar, com.google.android.gms.drive.zzn zznVar, DriveContents driveContents, MetadataChangeSet metadataChangeSet) {
        this.a = zznVar;
        this.b = driveContents;
        this.c = metadataChangeSet;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.api.internal.TaskApiCall
    public final /* synthetic */ void a(zzaw zzawVar, TaskCompletionSource<Void> taskCompletionSource) {
        zzaw zzawVar2 = zzawVar;
        try {
            this.a.zza(zzawVar2);
        } catch (IllegalStateException e) {
            taskCompletionSource.setException(e);
        }
        this.b.zzi();
        this.c.zzp().zza(zzawVar2.getContext());
        ((zzeo) zzawVar2.getService()).zza(new zzm(this.b.getDriveId(), this.c.zzp(), this.b.zzh().getRequestId(), this.b.zzh().zza(), this.a), new zzhl(taskCompletionSource));
    }
}
