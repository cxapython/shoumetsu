package com.google.android.gms.internal.drive;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.drive.DriveResource;

/* loaded from: classes.dex */
final class ch extends zzl {
    private final BaseImplementation.ResultHolder<DriveResource.MetadataResult> a;

    public ch(BaseImplementation.ResultHolder<DriveResource.MetadataResult> resultHolder) {
        this.a = resultHolder;
    }

    @Override // com.google.android.gms.internal.drive.zzl, com.google.android.gms.internal.drive.zzeq
    public final void zza(Status status) {
        this.a.setResult(new ci(status, null));
    }

    @Override // com.google.android.gms.internal.drive.zzl, com.google.android.gms.internal.drive.zzeq
    public final void zza(zzfs zzfsVar) {
        this.a.setResult(new ci(Status.RESULT_SUCCESS, new zzaa(zzfsVar.a)));
    }
}
