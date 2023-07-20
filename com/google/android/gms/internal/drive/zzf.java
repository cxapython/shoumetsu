package com.google.android.gms.internal.drive;

import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.drive.DriveId;

/* loaded from: classes.dex */
public final class zzf {
    private final DriveId a;
    private final int b;
    private final int c;

    public zzf(zzh zzhVar) {
        this.a = zzhVar.b;
        this.b = zzhVar.a;
        this.c = zzhVar.c;
    }

    public final boolean equals(Object obj) {
        if (obj != null && obj.getClass() == getClass()) {
            if (obj == this) {
                return true;
            }
            zzf zzfVar = (zzf) obj;
            if (Objects.equal(this.a, zzfVar.a) && this.b == zzfVar.b && this.c == zzfVar.c) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(this.a, Integer.valueOf(this.b), Integer.valueOf(this.c));
    }

    public final String toString() {
        return String.format("FileTransferState[TransferType: %d, DriveId: %s, status: %d]", Integer.valueOf(this.b), this.a, Integer.valueOf(this.c));
    }
}
