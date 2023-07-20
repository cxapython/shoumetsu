package com.google.android.gms.internal.drive;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

@SafeParcelable.Class(creator = "CloseContentsAndUpdateMetadataRequestCreator")
@SafeParcelable.Reserved({1})
/* loaded from: classes.dex */
public final class zzm extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzm> CREATOR = new zzn();
    @SafeParcelable.Field(id = 2)
    private final DriveId a;
    @SafeParcelable.Field(id = 3)
    private final MetadataBundle b;
    @SafeParcelable.Field(id = 4)
    private final Contents c;
    @SafeParcelable.Field(id = 5)
    private final boolean d;
    @SafeParcelable.Field(id = 6)
    private final String e;
    @SafeParcelable.Field(id = 7)
    private final int f;
    @SafeParcelable.Field(id = 8)
    private final int g;
    @SafeParcelable.Field(id = 9)
    private final boolean h;
    @SafeParcelable.Field(defaultValue = "true", id = 10)
    private final boolean i;

    @VisibleForTesting
    public zzm(DriveId driveId, MetadataBundle metadataBundle, int i, boolean z, com.google.android.gms.drive.zzn zznVar) {
        this(driveId, metadataBundle, null, zznVar.zzl(), zznVar.zzk(), zznVar.zzm(), i, z, zznVar.zzo());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public zzm(@SafeParcelable.Param(id = 2) DriveId driveId, @SafeParcelable.Param(id = 3) MetadataBundle metadataBundle, @SafeParcelable.Param(id = 4) Contents contents, @SafeParcelable.Param(id = 5) boolean z, @SafeParcelable.Param(id = 6) String str, @SafeParcelable.Param(id = 7) int i, @SafeParcelable.Param(id = 8) int i2, @SafeParcelable.Param(id = 9) boolean z2, @SafeParcelable.Param(id = 10) boolean z3) {
        this.a = driveId;
        this.b = metadataBundle;
        this.c = contents;
        this.d = z;
        this.e = str;
        this.f = i;
        this.g = i2;
        this.h = z2;
        this.i = z3;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 2, this.a, i, false);
        SafeParcelWriter.writeParcelable(parcel, 3, this.b, i, false);
        SafeParcelWriter.writeParcelable(parcel, 4, this.c, i, false);
        SafeParcelWriter.writeBoolean(parcel, 5, this.d);
        SafeParcelWriter.writeString(parcel, 6, this.e, false);
        SafeParcelWriter.writeInt(parcel, 7, this.f);
        SafeParcelWriter.writeInt(parcel, 8, this.g);
        SafeParcelWriter.writeBoolean(parcel, 9, this.h);
        SafeParcelWriter.writeBoolean(parcel, 10, this.i);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
