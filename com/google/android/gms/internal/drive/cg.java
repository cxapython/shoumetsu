package com.google.android.gms.internal.drive;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.drive.DriveApi;
import com.google.android.gms.drive.MetadataBuffer;

/* loaded from: classes.dex */
final class cg extends zzl {
    private final BaseImplementation.ResultHolder<DriveApi.MetadataBufferResult> a;

    public cg(BaseImplementation.ResultHolder<DriveApi.MetadataBufferResult> resultHolder) {
        this.a = resultHolder;
    }

    @Override // com.google.android.gms.internal.drive.zzl, com.google.android.gms.internal.drive.zzeq
    public final void zza(Status status) {
        this.a.setResult(new zzaq(status, null, false));
    }

    @Override // com.google.android.gms.internal.drive.zzl, com.google.android.gms.internal.drive.zzeq
    public final void zza(zzfp zzfpVar) {
        this.a.setResult(new zzaq(Status.RESULT_SUCCESS, new MetadataBuffer(zzfpVar.a), false));
    }
}
