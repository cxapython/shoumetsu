package com.google.android.gms.internal.drive;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.ExecutionOptions;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

@SafeParcelable.Class(creator = "CreateFileRequestCreator")
@SafeParcelable.Reserved({1, 10})
/* loaded from: classes.dex */
public final class zzw extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzw> CREATOR = new zzx();
    @SafeParcelable.Field(id = 2)
    private final DriveId a;
    @SafeParcelable.Field(id = 3)
    private final MetadataBundle b;
    @SafeParcelable.Field(id = 4)
    private final Contents c;
    @SafeParcelable.Field(id = 5)
    private final Integer d;
    @SafeParcelable.Field(id = 6)
    private final boolean e;
    @SafeParcelable.Field(id = 7)
    private final String f;
    @SafeParcelable.Field(id = 8)
    private final int g;
    @SafeParcelable.Field(id = 9)
    private final int h;

    @VisibleForTesting
    public zzw(DriveId driveId, MetadataBundle metadataBundle, int i, int i2, ExecutionOptions executionOptions) {
        this(driveId, metadataBundle, null, i2, executionOptions.zzl(), executionOptions.zzk(), executionOptions.zzm(), i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public zzw(@SafeParcelable.Param(id = 2) DriveId driveId, @SafeParcelable.Param(id = 3) MetadataBundle metadataBundle, @SafeParcelable.Param(id = 4) Contents contents, @SafeParcelable.Param(id = 5) int i, @SafeParcelable.Param(id = 6) boolean z, @SafeParcelable.Param(id = 7) String str, @SafeParcelable.Param(id = 8) int i2, @SafeParcelable.Param(id = 9) int i3) {
        if (contents != null && i3 != 0) {
            Preconditions.checkArgument(contents.getRequestId() == i3, "inconsistent contents reference");
        }
        if (i == 0 && contents == null && i3 == 0) {
            throw new IllegalArgumentException("Need a valid contents");
        }
        this.a = (DriveId) Preconditions.checkNotNull(driveId);
        this.b = (MetadataBundle) Preconditions.checkNotNull(metadataBundle);
        this.c = contents;
        this.d = Integer.valueOf(i);
        this.f = str;
        this.g = i2;
        this.e = z;
        this.h = i3;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 2, this.a, i, false);
        SafeParcelWriter.writeParcelable(parcel, 3, this.b, i, false);
        SafeParcelWriter.writeParcelable(parcel, 4, this.c, i, false);
        SafeParcelWriter.writeIntegerObject(parcel, 5, this.d, false);
        SafeParcelWriter.writeBoolean(parcel, 6, this.e);
        SafeParcelWriter.writeString(parcel, 7, this.f, false);
        SafeParcelWriter.writeInt(parcel, 8, this.g);
        SafeParcelWriter.writeInt(parcel, 9, this.h);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
