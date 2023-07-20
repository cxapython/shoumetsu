package com.google.android.gms.drive.query;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.drive.DriveSpace;
import com.google.android.gms.drive.query.internal.zzr;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class zzb implements Parcelable.Creator<Query> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Query createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        zzr zzrVar = null;
        String str = null;
        SortOrder sortOrder = null;
        ArrayList<String> arrayList = null;
        ArrayList arrayList2 = null;
        boolean z = false;
        boolean z2 = false;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            int fieldId = SafeParcelReader.getFieldId(readHeader);
            if (fieldId != 1) {
                switch (fieldId) {
                    case 3:
                        str = SafeParcelReader.createString(parcel, readHeader);
                        continue;
                    case 4:
                        sortOrder = (SortOrder) SafeParcelReader.createParcelable(parcel, readHeader, SortOrder.CREATOR);
                        continue;
                    case 5:
                        arrayList = SafeParcelReader.createStringList(parcel, readHeader);
                        continue;
                    case 6:
                        z = SafeParcelReader.readBoolean(parcel, readHeader);
                        continue;
                    case 7:
                        arrayList2 = SafeParcelReader.createTypedList(parcel, readHeader, DriveSpace.CREATOR);
                        continue;
                    case 8:
                        z2 = SafeParcelReader.readBoolean(parcel, readHeader);
                        continue;
                    default:
                        SafeParcelReader.skipUnknownField(parcel, readHeader);
                        continue;
                }
            } else {
                zzrVar = (zzr) SafeParcelReader.createParcelable(parcel, readHeader, zzr.CREATOR);
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new Query(zzrVar, str, sortOrder, arrayList, z, arrayList2, z2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Query[] newArray(int i) {
        return new Query[i];
    }
}
