package com.google.android.gms.internal.drive;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;

@SafeParcelable.Class(creator = "AddEventListenerRequestCreator")
@SafeParcelable.Reserved({1})
/* loaded from: classes.dex */
public final class zzj extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzj> CREATOR = new zzk();
    @SafeParcelable.Field(id = 2)
    final DriveId a;
    @SafeParcelable.Field(id = 3)
    final int b;
    @SafeParcelable.Field(id = 4)
    private final com.google.android.gms.drive.events.zze c;
    @SafeParcelable.Field(id = 5)
    private final com.google.android.gms.drive.events.zzx d;
    @SafeParcelable.Field(id = 6)
    private final com.google.android.gms.drive.events.zzt e;

    public zzj(int i, DriveId driveId) {
        this((DriveId) Preconditions.checkNotNull(driveId), 1, null, null, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public zzj(@SafeParcelable.Param(id = 2) DriveId driveId, @SafeParcelable.Param(id = 3) int i, @SafeParcelable.Param(id = 4) com.google.android.gms.drive.events.zze zzeVar, @SafeParcelable.Param(id = 5) com.google.android.gms.drive.events.zzx zzxVar, @SafeParcelable.Param(id = 6) com.google.android.gms.drive.events.zzt zztVar) {
        this.a = driveId;
        this.b = i;
        this.c = zzeVar;
        this.d = zzxVar;
        this.e = zztVar;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 2, this.a, i, false);
        SafeParcelWriter.writeInt(parcel, 3, this.b);
        SafeParcelWriter.writeParcelable(parcel, 4, this.c, i, false);
        SafeParcelWriter.writeParcelable(parcel, 5, this.d, i, false);
        SafeParcelWriter.writeParcelable(parcel, 6, this.e, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
