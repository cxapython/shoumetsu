package com.google.android.gms.internal.drive;

import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.drive.DriveContents;
import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes.dex */
final class bf extends TaskApiCall<zzaw, DriveContents> {
    private final /* synthetic */ int a = DriveFile.MODE_WRITE_ONLY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bf(zzch zzchVar, int i) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.api.internal.TaskApiCall
    public final /* synthetic */ void a(zzaw zzawVar, TaskCompletionSource<DriveContents> taskCompletionSource) {
        ((zzeo) zzawVar.getService()).zza(new zzr(this.a), new zzhc(taskCompletionSource));
    }
}
