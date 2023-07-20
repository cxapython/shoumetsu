package com.google.android.gms.nearby.messages;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.internal.nearby.zzgp;
import com.google.android.gms.internal.nearby.zzgu;
import com.google.android.gms.nearby.messages.internal.zzad;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class zzc implements Parcelable.Creator<MessageFilter> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ MessageFilter createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        ArrayList arrayList = null;
        ArrayList arrayList2 = null;
        ArrayList arrayList3 = null;
        int i = 0;
        boolean z = false;
        int i2 = 0;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            int fieldId = SafeParcelReader.getFieldId(readHeader);
            if (fieldId != 1000) {
                switch (fieldId) {
                    case 1:
                        arrayList = SafeParcelReader.createTypedList(parcel, readHeader, zzad.CREATOR);
                        continue;
                    case 2:
                        arrayList2 = SafeParcelReader.createTypedList(parcel, readHeader, zzgu.CREATOR);
                        continue;
                    case 3:
                        z = SafeParcelReader.readBoolean(parcel, readHeader);
                        continue;
                    case 4:
                        arrayList3 = SafeParcelReader.createTypedList(parcel, readHeader, zzgp.CREATOR);
                        continue;
                    case 5:
                        i2 = SafeParcelReader.readInt(parcel, readHeader);
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
        return new MessageFilter(i, arrayList, arrayList2, z, arrayList3, i2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ MessageFilter[] newArray(int i) {
        return new MessageFilter[i];
    }
}
