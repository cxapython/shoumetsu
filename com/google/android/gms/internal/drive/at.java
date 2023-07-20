package com.google.android.gms.internal.drive;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.drive.DriveFolder;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes.dex */
final class at extends TaskApiCall<zzaw, DriveFolder> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public at(zzch zzchVar) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.api.internal.TaskApiCall
    public final /* synthetic */ void a(zzaw zzawVar, TaskCompletionSource<DriveFolder> taskCompletionSource) {
        zzaw zzawVar2 = zzawVar;
        if (zzawVar2.zzad() == null) {
            taskCompletionSource.setException(new ApiException(new Status(10, "Drive#SCOPE_FILE must be requested")));
        } else {
            taskCompletionSource.setResult(new zzbs(zzawVar2.zzad()));
        }
    }
}
