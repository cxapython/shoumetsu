package com.google.android.gms.nearby.messages;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.internal.nearby.zzgs;

/* loaded from: classes.dex */
public final class zza implements Parcelable.Creator<Message> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Message createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        byte[] bArr = null;
        String str = null;
        String str2 = null;
        zzgs[] zzgsVarArr = null;
        long j = 0;
        int i = 0;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            int fieldId = SafeParcelReader.getFieldId(readHeader);
            if (fieldId != 1000) {
                switch (fieldId) {
                    case 1:
                        bArr = SafeParcelReader.createByteArray(parcel, readHeader);
                        continue;
                    case 2:
                        str2 = SafeParcelReader.createString(parcel, readHeader);
                        continue;
                    case 3:
                        str = SafeParcelReader.createString(parcel, readHeader);
                        continue;
                    case 4:
                        zzgsVarArr = (zzgs[]) SafeParcelReader.createTypedArray(parcel, readHeader, zzgs.CREATOR);
                        continue;
                    case 5:
                        j = SafeParcelReader.readLong(parcel, readHeader);
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
        return new Message(i, bArr, str, str2, zzgsVarArr, j);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Message[] newArray(int i) {
        return new Message[i];
    }
}
