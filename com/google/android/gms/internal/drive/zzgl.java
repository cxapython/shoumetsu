package com.google.android.gms.internal.drive;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.drive.query.Query;

/* loaded from: classes.dex */
public final class zzgl implements Parcelable.Creator<zzgk> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzgk createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        Query query = null;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            if (SafeParcelReader.getFieldId(readHeader) != 2) {
                SafeParcelReader.skipUnknownField(parcel, readHeader);
            } else {
                query = (Query) SafeParcelReader.createParcelable(parcel, readHeader, Query.CREATOR);
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new zzgk(query);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzgk[] newArray(int i) {
        return new zzgk[i];
    }
}
