package com.google.android.gms.internal.drive;

import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.drive.DriveContents;
import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes.dex */
final class bg extends TaskApiCall<zzaw, DriveContents> {
    private final /* synthetic */ DriveContents a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bg(zzch zzchVar, DriveContents driveContents) {
        this.a = driveContents;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.api.internal.TaskApiCall
    public final /* synthetic */ void a(zzaw zzawVar, TaskCompletionSource<DriveContents> taskCompletionSource) {
        ((zzeo) zzawVar.getService()).zza(new zzgd(this.a.getDriveId(), DriveFile.MODE_WRITE_ONLY, this.a.zzh().getRequestId()), new zzhc(taskCompletionSource));
    }
}
