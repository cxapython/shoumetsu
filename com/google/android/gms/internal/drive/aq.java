package com.google.android.gms.internal.drive;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.DrivePreferencesApi;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class aq extends zzau<DrivePreferencesApi.FileUploadPreferencesResult> {
    private final /* synthetic */ zzcb b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public aq(zzcb zzcbVar, GoogleApiClient googleApiClient) {
        super(googleApiClient);
        this.b = zzcbVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.api.internal.BasePendingResult
    /* renamed from: createFailedResult */
    public /* synthetic */ Result mo8createFailedResult(Status status) {
        return new ap(this.b, status, null, null);
    }
}
