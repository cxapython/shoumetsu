package com.google.android.gms.internal.drive;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.drive.DriveFolder;

/* loaded from: classes.dex */
final class ai implements DriveFolder.DriveFileResult {
    private final Status a;
    private final DriveFile b;

    public ai(Status status, DriveFile driveFile) {
        this.a = status;
        this.b = driveFile;
    }

    @Override // com.google.android.gms.drive.DriveFolder.DriveFileResult
    public final DriveFile getDriveFile() {
        return this.b;
    }

    @Override // com.google.android.gms.common.api.Result
    public final Status getStatus() {
        return this.a;
    }
}
