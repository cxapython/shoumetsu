package com.google.android.gms.internal.drive;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "OnListParentsResponseCreator")
@SafeParcelable.Reserved({1})
/* loaded from: classes.dex */
public final class zzfp extends com.google.android.gms.drive.zzu {
    public static final Parcelable.Creator<zzfp> CREATOR = new zzfq();
    @SafeParcelable.Field(id = 2)
    final DataHolder a;

    @SafeParcelable.Constructor
    public zzfp(@SafeParcelable.Param(id = 2) DataHolder dataHolder) {
        this.a = dataHolder;
    }

    @Override // com.google.android.gms.drive.zzu
    protected final void zza(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 2, this.a, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final DataHolder zzam() {
        return this.a;
    }
}
