package com.google.android.gms.internal.drive;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.drive.DriveApi;
import com.google.android.gms.drive.MetadataBuffer;

/* loaded from: classes.dex */
final class l extends zzl {
    private final BaseImplementation.ResultHolder<DriveApi.MetadataBufferResult> a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(BaseImplementation.ResultHolder<DriveApi.MetadataBufferResult> resultHolder) {
        this.a = resultHolder;
    }

    @Override // com.google.android.gms.internal.drive.zzl, com.google.android.gms.internal.drive.zzeq
    public final void zza(Status status) {
        this.a.setResult(new zzaq(status, null, false));
    }

    @Override // com.google.android.gms.internal.drive.zzl, com.google.android.gms.internal.drive.zzeq
    public final void zza(zzfn zzfnVar) {
        this.a.setResult(new zzaq(Status.RESULT_SUCCESS, new MetadataBuffer(zzfnVar.a), zzfnVar.b));
    }
}
