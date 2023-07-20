package com.google.android.gms.internal.drive;

import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.DriveApi;
import com.google.android.gms.drive.DriveContents;

/* loaded from: classes.dex */
final class f implements Releasable, DriveApi.DriveContentsResult {
    private final Status a;
    private final DriveContents b;

    public f(Status status, DriveContents driveContents) {
        this.a = status;
        this.b = driveContents;
    }

    @Override // com.google.android.gms.drive.DriveApi.DriveContentsResult
    public final DriveContents getDriveContents() {
        return this.b;
    }

    @Override // com.google.android.gms.common.api.Result
    public final Status getStatus() {
        return this.a;
    }

    @Override // com.google.android.gms.common.api.Releasable
    public final void release() {
        DriveContents driveContents = this.b;
        if (driveContents != null) {
            driveContents.zzi();
        }
    }
}
