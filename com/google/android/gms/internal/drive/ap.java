package com.google.android.gms.internal.drive;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.DrivePreferencesApi;
import com.google.android.gms.drive.FileUploadPreferences;

/* loaded from: classes.dex */
final class ap implements DrivePreferencesApi.FileUploadPreferencesResult {
    private final Status a;
    private final FileUploadPreferences b;

    private ap(zzcb zzcbVar, Status status, FileUploadPreferences fileUploadPreferences) {
        this.a = status;
        this.b = fileUploadPreferences;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ ap(zzcb zzcbVar, Status status, FileUploadPreferences fileUploadPreferences, am amVar) {
        this(zzcbVar, status, fileUploadPreferences);
    }

    @Override // com.google.android.gms.drive.DrivePreferencesApi.FileUploadPreferencesResult
    public final FileUploadPreferences getFileUploadPreferences() {
        return this.b;
    }

    @Override // com.google.android.gms.common.api.Result
    public final Status getStatus() {
        return this.a;
    }
}
