package com.google.android.gms.internal.drive;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Collections;
import java.util.List;

@SafeParcelable.Class(creator = "OnDownloadProgressResponseCreator")
@SafeParcelable.Reserved({1})
/* loaded from: classes.dex */
public final class zzff extends AbstractSafeParcelable {
    @SafeParcelable.Field(id = 2)
    final long a;
    @SafeParcelable.Field(id = 3)
    final long b;
    @SafeParcelable.Field(id = 4)
    private final int d;
    @SafeParcelable.Field(id = 5)
    private final List<com.google.android.gms.drive.zzh> e;
    private static final List<com.google.android.gms.drive.zzh> c = Collections.emptyList();
    public static final Parcelable.Creator<zzff> CREATOR = new zzfg();

    @SafeParcelable.Constructor
    public zzff(@SafeParcelable.Param(id = 2) long j, @SafeParcelable.Param(id = 3) long j2, @SafeParcelable.Param(id = 4) int i, @SafeParcelable.Param(id = 5) List<com.google.android.gms.drive.zzh> list) {
        this.a = j;
        this.b = j2;
        this.d = i;
        this.e = list;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeLong(parcel, 2, this.a);
        SafeParcelWriter.writeLong(parcel, 3, this.b);
        SafeParcelWriter.writeInt(parcel, 4, this.d);
        SafeParcelWriter.writeTypedList(parcel, 5, this.e, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
