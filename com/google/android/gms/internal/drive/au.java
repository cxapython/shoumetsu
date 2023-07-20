package com.google.android.gms.internal.drive;

import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.drive.DriveResource;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes.dex */
final class au extends TaskApiCall<zzaw, Void> {
    private final /* synthetic */ DriveResource a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public au(zzch zzchVar, DriveResource driveResource) {
        this.a = driveResource;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.api.internal.TaskApiCall
    public final /* synthetic */ void a(zzaw zzawVar, TaskCompletionSource<Void> taskCompletionSource) {
        ((zzeo) zzawVar.getService()).zza(new zzab(this.a.getDriveId()), new zzhl(taskCompletionSource));
    }
}
