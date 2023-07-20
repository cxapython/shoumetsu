package com.google.android.gms.internal.drive;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.drive.DriveApi;

/* loaded from: classes.dex */
final class e extends zzl {
    private final BaseImplementation.ResultHolder<DriveApi.DriveContentsResult> a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(BaseImplementation.ResultHolder<DriveApi.DriveContentsResult> resultHolder) {
        this.a = resultHolder;
    }

    @Override // com.google.android.gms.internal.drive.zzl, com.google.android.gms.internal.drive.zzeq
    public final void zza(Status status) {
        this.a.setResult(new f(status, null));
    }

    @Override // com.google.android.gms.internal.drive.zzl, com.google.android.gms.internal.drive.zzeq
    public final void zza(zzfb zzfbVar) {
        this.a.setResult(new f(Status.RESULT_SUCCESS, new zzbi(zzfbVar.a)));
    }
}
