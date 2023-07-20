package com.google.android.gms.internal.drive;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* loaded from: classes.dex */
public final class zzfe implements Parcelable.Creator<zzfd> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzfd createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        zzei zzeiVar = null;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            if (SafeParcelReader.getFieldId(readHeader) != 2) {
                SafeParcelReader.skipUnknownField(parcel, readHeader);
            } else {
                zzeiVar = (zzei) SafeParcelReader.createParcelable(parcel, readHeader, zzei.CREATOR);
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new zzfd(zzeiVar);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzfd[] newArray(int i) {
        return new zzfd[i];
    }
}
