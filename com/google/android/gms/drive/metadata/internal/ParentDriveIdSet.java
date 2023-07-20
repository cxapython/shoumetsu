package com.google.android.gms.drive.metadata.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.List;

@SafeParcelable.Class(creator = "ParentDriveIdSetCreator")
@SafeParcelable.Reserved({1})
/* loaded from: classes.dex */
public class ParentDriveIdSet extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<ParentDriveIdSet> CREATOR = new zzn();
    @SafeParcelable.Field(id = 2)
    final List<zzq> a;

    public ParentDriveIdSet() {
        this(new ArrayList());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public ParentDriveIdSet(@SafeParcelable.Param(id = 2) List<zzq> list) {
        this.a = list;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeTypedList(parcel, 2, this.a, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
