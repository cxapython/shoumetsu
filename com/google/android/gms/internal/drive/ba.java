package com.google.android.gms.internal.drive;

import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.drive.DriveResource;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes.dex */
final class ba extends TaskApiCall<zzaw, Void> {
    private final /* synthetic */ DriveResource a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ba(zzch zzchVar, DriveResource driveResource) {
        this.a = driveResource;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.api.internal.TaskApiCall
    public final /* synthetic */ void a(zzaw zzawVar, TaskCompletionSource<Void> taskCompletionSource) {
        zzaw zzawVar2 = zzawVar;
        if (zzawVar2.d) {
            ((zzeo) zzawVar2.getService()).zza(new zzj(1, this.a.getDriveId()), (zzes) null, (String) null, new zzhl(taskCompletionSource));
            return;
        }
        throw new IllegalStateException("Application must define an exported DriveEventService subclass in AndroidManifest.xml to add event subscriptions");
    }
}
