package com.google.android.gms.internal.drive;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.drive.DriveApi;
import com.google.android.gms.drive.DriveFile;

/* loaded from: classes.dex */
final class cn extends zzl {
    private final BaseImplementation.ResultHolder<DriveApi.DriveContentsResult> a;
    private final DriveFile.DownloadProgressListener b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cn(BaseImplementation.ResultHolder<DriveApi.DriveContentsResult> resultHolder, DriveFile.DownloadProgressListener downloadProgressListener) {
        this.a = resultHolder;
        this.b = downloadProgressListener;
    }

    @Override // com.google.android.gms.internal.drive.zzl, com.google.android.gms.internal.drive.zzeq
    public final void zza(Status status) {
        this.a.setResult(new f(status, null));
    }

    @Override // com.google.android.gms.internal.drive.zzl, com.google.android.gms.internal.drive.zzeq
    public final void zza(zzfb zzfbVar) {
        this.a.setResult(new f(zzfbVar.b ? new Status(-1) : Status.RESULT_SUCCESS, new zzbi(zzfbVar.a)));
    }

    @Override // com.google.android.gms.internal.drive.zzl, com.google.android.gms.internal.drive.zzeq
    public final void zza(zzff zzffVar) {
        DriveFile.DownloadProgressListener downloadProgressListener = this.b;
        if (downloadProgressListener != null) {
            downloadProgressListener.onProgress(zzffVar.a, zzffVar.b);
        }
    }
}
