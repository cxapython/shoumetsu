package com.google.android.gms.internal.drive;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;

/* loaded from: classes.dex */
public final class zzgs extends zzl {
    private final BaseImplementation.ResultHolder<Status> a;

    public zzgs(BaseImplementation.ResultHolder<Status> resultHolder) {
        this.a = resultHolder;
    }

    @Override // com.google.android.gms.internal.drive.zzl, com.google.android.gms.internal.drive.zzeq
    public final void onSuccess() {
        this.a.setResult(Status.RESULT_SUCCESS);
    }

    @Override // com.google.android.gms.internal.drive.zzl, com.google.android.gms.internal.drive.zzeq
    public final void zza(Status status) {
        this.a.setResult(status);
    }
}
