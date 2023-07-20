package com.google.android.gms.internal.nearby;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* loaded from: classes.dex */
public final class zzgv implements Parcelable.Creator<zzgu> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzgu createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        int i = 0;
        byte[] bArr = null;
        int i2 = 0;
        boolean z = false;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            int fieldId = SafeParcelReader.getFieldId(readHeader);
            if (fieldId != 1000) {
                switch (fieldId) {
                    case 1:
                        i2 = SafeParcelReader.readInt(parcel, readHeader);
                        continue;
                    case 2:
                        bArr = SafeParcelReader.createByteArray(parcel, readHeader);
                        continue;
                    case 3:
                        z = SafeParcelReader.readBoolean(parcel, readHeader);
                        continue;
                    default:
                        SafeParcelReader.skipUnknownField(parcel, readHeader);
                        continue;
                }
            } else {
                i = SafeParcelReader.readInt(parcel, readHeader);
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new zzgu(i, i2, bArr, z);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzgu[] newArray(int i) {
        return new zzgu[i];
    }
}
