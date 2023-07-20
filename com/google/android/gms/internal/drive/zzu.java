package com.google.android.gms.internal.drive;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

@SafeParcelable.Class(creator = "CreateFileIntentSenderRequestCreator")
@SafeParcelable.Reserved({1})
/* loaded from: classes.dex */
public final class zzu extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzu> CREATOR = new zzv();
    @SafeParcelable.Field(id = 2)
    private final MetadataBundle a;
    @SafeParcelable.Field(id = 3)
    private final int b;
    @SafeParcelable.Field(id = 4)
    private final String c;
    @SafeParcelable.Field(id = 5)
    private final DriveId d;
    @SafeParcelable.Field(id = 6)
    private final Integer e;

    @SafeParcelable.Constructor
    @VisibleForTesting
    public zzu(@SafeParcelable.Param(id = 2) MetadataBundle metadataBundle, @SafeParcelable.Param(id = 3) int i, @SafeParcelable.Param(id = 4) String str, @SafeParcelable.Param(id = 5) DriveId driveId, @SafeParcelable.Param(id = 6) Integer num) {
        this.a = metadataBundle;
        this.b = i;
        this.c = str;
        this.d = driveId;
        this.e = num;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 2, this.a, i, false);
        SafeParcelWriter.writeInt(parcel, 3, this.b);
        SafeParcelWriter.writeString(parcel, 4, this.c, false);
        SafeParcelWriter.writeParcelable(parcel, 5, this.d, i, false);
        SafeParcelWriter.writeIntegerObject(parcel, 6, this.e, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
