package com.google.android.gms.internal.drive;

import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.drive.DriveContents;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes.dex */
final class bk extends TaskApiCall<zzaw, Void> {
    private final /* synthetic */ DriveContents a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bk(zzch zzchVar, DriveContents driveContents) {
        this.a = driveContents;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.api.internal.TaskApiCall
    public final /* synthetic */ void a(zzaw zzawVar, TaskCompletionSource<Void> taskCompletionSource) {
        ((zzeo) zzawVar.getService()).zza(new zzo(this.a.zzh().getRequestId(), false), new zzhl(taskCompletionSource));
    }
}
