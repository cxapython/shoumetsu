package com.google.android.gms.drive.events;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.drive.zzh;

@SafeParcelable.Class(creator = "TransferProgressEventCreator")
@SafeParcelable.Reserved({1})
/* loaded from: classes.dex */
public final class zzr extends AbstractSafeParcelable implements DriveEvent {
    public static final Parcelable.Creator<zzr> CREATOR = new zzs();
    @SafeParcelable.Field(id = 2)
    private final zzh a;

    @SafeParcelable.Constructor
    public zzr(@SafeParcelable.Param(id = 2) zzh zzhVar) {
        this.a = zzhVar;
    }

    public final boolean equals(Object obj) {
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        if (obj != this) {
            return Objects.equal(this.a, ((zzr) obj).a);
        }
        return true;
    }

    @Override // com.google.android.gms.drive.events.DriveEvent
    public final int getType() {
        return 8;
    }

    public final int hashCode() {
        return Objects.hashCode(this.a);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 2, this.a, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final zzh zzab() {
        return this.a;
    }
}
