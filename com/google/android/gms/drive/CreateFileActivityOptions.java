package com.google.android.gms.drive;

import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.internal.drive.zzq;

/* loaded from: classes.dex */
public final class CreateFileActivityOptions extends zzq {
    public static final String EXTRA_RESPONSE_DRIVE_ID = "response_drive_id";

    /* loaded from: classes.dex */
    public static class Builder {
        protected final CreateFileActivityBuilder a = new CreateFileActivityBuilder();

        public CreateFileActivityOptions build() {
            this.a.f();
            return new CreateFileActivityOptions(this.a.b().zzp(), Integer.valueOf(this.a.a()), this.a.d(), this.a.c(), this.a.e());
        }

        public Builder setActivityStartFolder(DriveId driveId) {
            this.a.setActivityStartFolder(driveId);
            return this;
        }

        public Builder setActivityTitle(String str) {
            this.a.setActivityTitle(str);
            return this;
        }

        public Builder setInitialDriveContents(DriveContents driveContents) {
            this.a.setInitialDriveContents(driveContents);
            return this;
        }

        public Builder setInitialMetadata(MetadataChangeSet metadataChangeSet) {
            this.a.setInitialMetadata(metadataChangeSet);
            return this;
        }
    }

    private CreateFileActivityOptions(MetadataBundle metadataBundle, Integer num, String str, DriveId driveId, int i) {
        super(metadataBundle, num, str, driveId, i);
    }
}
