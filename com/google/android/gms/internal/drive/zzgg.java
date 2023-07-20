package com.google.android.gms.internal.drive;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.query.internal.FilterHolder;

@SafeParcelable.Class(creator = "OpenFileIntentSenderRequestCreator")
@SafeParcelable.Reserved({1})
/* loaded from: classes.dex */
public final class zzgg extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzgg> CREATOR = new zzgh();
    @SafeParcelable.Field(id = 2)
    private final String a;
    @SafeParcelable.Field(id = 3)
    private final String[] b;
    @SafeParcelable.Field(id = 4)
    private final DriveId c;
    @SafeParcelable.Field(id = 5)
    private final FilterHolder d;

    @SafeParcelable.Constructor
    @VisibleForTesting
    public zzgg(@SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) String[] strArr, @SafeParcelable.Param(id = 4) DriveId driveId, @SafeParcelable.Param(id = 5) FilterHolder filterHolder) {
        this.a = str;
        this.b = strArr;
        this.c = driveId;
        this.d = filterHolder;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.a, false);
        SafeParcelWriter.writeStringArray(parcel, 3, this.b, false);
        SafeParcelWriter.writeParcelable(parcel, 4, this.c, i, false);
        SafeParcelWriter.writeParcelable(parcel, 5, this.d, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
