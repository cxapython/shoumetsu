package com.google.android.gms.internal.drive;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.DriveApi;
import com.google.android.gms.drive.DriveId;

/* loaded from: classes.dex */
final class i implements DriveApi.DriveIdResult {
    private final Status a;
    private final DriveId b;

    public i(Status status, DriveId driveId) {
        this.a = status;
        this.b = driveId;
    }

    @Override // com.google.android.gms.drive.DriveApi.DriveIdResult
    public final DriveId getDriveId() {
        return this.b;
    }

    @Override // com.google.android.gms.common.api.Result
    public final Status getStatus() {
        return this.a;
    }
}
