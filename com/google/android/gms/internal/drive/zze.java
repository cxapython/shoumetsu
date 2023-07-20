package com.google.android.gms.internal.drive;

import com.google.android.gms.common.internal.Objects;
import java.util.Locale;

/* loaded from: classes.dex */
public final class zze implements com.google.android.gms.drive.events.zzk {
    private final com.google.android.gms.drive.events.zzm a;
    private final long b;
    private final long c;

    /* JADX WARN: Type inference failed for: r0v0, types: [com.google.android.gms.drive.events.zzm, com.google.android.gms.internal.drive.zzf] */
    public zze(zzh zzhVar) {
        this.a = new zzf(zzhVar);
        this.b = zzhVar.d;
        this.c = zzhVar.e;
    }

    public final boolean equals(Object obj) {
        if (obj != null && obj.getClass() == getClass()) {
            if (obj == this) {
                return true;
            }
            zze zzeVar = (zze) obj;
            if (Objects.equal(this.a, zzeVar.a) && this.b == zzeVar.b && this.c == zzeVar.c) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(Long.valueOf(this.c), Long.valueOf(this.b), Long.valueOf(this.c));
    }

    public final String toString() {
        return String.format(Locale.US, "FileTransferProgress[FileTransferState: %s, BytesTransferred: %d, TotalBytes: %d]", this.a.toString(), Long.valueOf(this.b), Long.valueOf(this.c));
    }
}
