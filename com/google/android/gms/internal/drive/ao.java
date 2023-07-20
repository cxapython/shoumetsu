package com.google.android.gms.internal.drive;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.drive.DrivePreferencesApi;

/* loaded from: classes.dex */
final class ao extends zzl {
    private final BaseImplementation.ResultHolder<DrivePreferencesApi.FileUploadPreferencesResult> a;
    private final /* synthetic */ zzcb b;

    private ao(zzcb zzcbVar, BaseImplementation.ResultHolder<DrivePreferencesApi.FileUploadPreferencesResult> resultHolder) {
        this.b = zzcbVar;
        this.a = resultHolder;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ ao(zzcb zzcbVar, BaseImplementation.ResultHolder resultHolder, am amVar) {
        this(zzcbVar, resultHolder);
    }

    @Override // com.google.android.gms.internal.drive.zzl, com.google.android.gms.internal.drive.zzeq
    public final void zza(Status status) {
        this.a.setResult(new ap(this.b, status, null, null));
    }

    @Override // com.google.android.gms.internal.drive.zzl, com.google.android.gms.internal.drive.zzeq
    public final void zza(zzfd zzfdVar) {
        this.a.setResult(new ap(this.b, Status.RESULT_SUCCESS, zzfdVar.a, null));
    }
}
