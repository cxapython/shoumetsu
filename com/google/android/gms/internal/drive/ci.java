package com.google.android.gms.internal.drive;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.DriveResource;
import com.google.android.gms.drive.Metadata;

/* loaded from: classes.dex */
final class ci implements DriveResource.MetadataResult {
    private final Status a;
    private final Metadata b;

    public ci(Status status, Metadata metadata) {
        this.a = status;
        this.b = metadata;
    }

    @Override // com.google.android.gms.drive.DriveResource.MetadataResult
    public final Metadata getMetadata() {
        return this.b;
    }

    @Override // com.google.android.gms.common.api.Result
    public final Status getStatus() {
        return this.a;
    }
}
