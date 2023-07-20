package com.google.android.gms.internal.drive;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.drive.DriveFolder;

/* loaded from: classes.dex */
final class ag extends zzl {
    private final BaseImplementation.ResultHolder<DriveFolder.DriveFileResult> a;

    public ag(BaseImplementation.ResultHolder<DriveFolder.DriveFileResult> resultHolder) {
        this.a = resultHolder;
    }

    @Override // com.google.android.gms.internal.drive.zzl, com.google.android.gms.internal.drive.zzeq
    public final void zza(Status status) {
        this.a.setResult(new ai(status, null));
    }

    @Override // com.google.android.gms.internal.drive.zzl, com.google.android.gms.internal.drive.zzeq
    public final void zza(zzfh zzfhVar) {
        this.a.setResult(new ai(Status.RESULT_SUCCESS, new zzbn(zzfhVar.a)));
    }
}
