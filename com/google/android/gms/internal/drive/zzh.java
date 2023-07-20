package com.google.android.gms.internal.drive;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;

@SafeParcelable.Class(creator = "TransferProgressDataCreator")
@SafeParcelable.Reserved({1})
/* loaded from: classes.dex */
public final class zzh extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzh> CREATOR = new zzi();
    @SafeParcelable.Field(id = 2)
    final int a;
    @SafeParcelable.Field(id = 3)
    final DriveId b;
    @SafeParcelable.Field(id = 4)
    final int c;
    @SafeParcelable.Field(id = 5)
    final long d;
    @SafeParcelable.Field(id = 6)
    final long e;

    @SafeParcelable.Constructor
    public zzh(@SafeParcelable.Param(id = 2) int i, @SafeParcelable.Param(id = 3) DriveId driveId, @SafeParcelable.Param(id = 4) int i2, @SafeParcelable.Param(id = 5) long j, @SafeParcelable.Param(id = 6) long j2) {
        this.a = i;
        this.b = driveId;
        this.c = i2;
        this.d = j;
        this.e = j2;
    }

    public final boolean equals(Object obj) {
        if (obj != null && obj.getClass() == getClass()) {
            if (obj == this) {
                return true;
            }
            zzh zzhVar = (zzh) obj;
            if (this.a == zzhVar.a && Objects.equal(this.b, zzhVar.b) && this.c == zzhVar.c && this.d == zzhVar.d && this.e == zzhVar.e) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.a), this.b, Integer.valueOf(this.c), Long.valueOf(this.d), Long.valueOf(this.e));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 2, this.a);
        SafeParcelWriter.writeParcelable(parcel, 3, this.b, i, false);
        SafeParcelWriter.writeInt(parcel, 4, this.c);
        SafeParcelWriter.writeLong(parcel, 5, this.d);
        SafeParcelWriter.writeLong(parcel, 6, this.e);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
