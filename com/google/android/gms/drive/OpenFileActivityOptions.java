package com.google.android.gms.drive;

import com.google.android.gms.drive.query.Filter;
import com.google.android.gms.drive.query.internal.FilterHolder;
import java.util.List;

/* loaded from: classes.dex */
public final class OpenFileActivityOptions {
    public static final String EXTRA_RESPONSE_DRIVE_ID = "response_drive_id";
    public final String zzay;
    public final String[] zzaz;
    public final DriveId zzbb;
    public final FilterHolder zzbc;

    /* loaded from: classes.dex */
    public static class Builder {
        private final OpenFileActivityBuilder a = new OpenFileActivityBuilder();

        public OpenFileActivityOptions build() {
            this.a.e();
            return new OpenFileActivityOptions(this.a.a(), this.a.b(), this.a.c(), this.a.d());
        }

        public Builder setActivityStartFolder(DriveId driveId) {
            this.a.setActivityStartFolder(driveId);
            return this;
        }

        public Builder setActivityTitle(String str) {
            this.a.setActivityTitle(str);
            return this;
        }

        public Builder setMimeType(List<String> list) {
            this.a.setMimeType((String[]) list.toArray(new String[0]));
            return this;
        }

        public Builder setSelectionFilter(Filter filter) {
            this.a.setSelectionFilter(filter);
            return this;
        }
    }

    private OpenFileActivityOptions(String str, String[] strArr, Filter filter, DriveId driveId) {
        this.zzay = str;
        this.zzaz = strArr;
        this.zzbc = filter == null ? null : new FilterHolder(filter);
        this.zzbb = driveId;
    }
}
