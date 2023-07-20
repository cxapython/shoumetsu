package com.google.android.gms.drive.query;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.drive.query.internal.zzf;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class zzc implements Parcelable.Creator<SortOrder> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ SortOrder createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        ArrayList arrayList = null;
        boolean z = false;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(readHeader)) {
                case 1:
                    arrayList = SafeParcelReader.createTypedList(parcel, readHeader, zzf.CREATOR);
                    break;
                case 2:
                    z = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, readHeader);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new SortOrder(arrayList, z);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ SortOrder[] newArray(int i) {
        return new SortOrder[i];
    }
}
