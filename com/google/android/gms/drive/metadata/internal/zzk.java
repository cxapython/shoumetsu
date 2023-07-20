package com.google.android.gms.drive.metadata.internal;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.drive.DriveFolder;
import java.util.Locale;

/* loaded from: classes.dex */
public final class zzk {
    private String a;

    private zzk(String str) {
        this.a = str.toLowerCase(Locale.US);
    }

    public static zzk zze(String str) {
        Preconditions.checkArgument(str == null || !str.isEmpty());
        if (str == null) {
            return null;
        }
        return new zzk(str);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj != null && obj.getClass() == getClass()) {
            return this.a.equals(((zzk) obj).a);
        }
        return false;
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final boolean isFolder() {
        return this.a.equals(DriveFolder.MIME_TYPE);
    }

    public final String toString() {
        return this.a;
    }

    public final boolean zzaz() {
        return this.a.startsWith("application/vnd.google-apps");
    }
}
