package com.google.android.gms.internal.drive;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.drive.DriveId;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class zzfa implements Parcelable.Creator<zzez> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzez createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        DataHolder dataHolder = null;
        ArrayList arrayList = null;
        com.google.android.gms.drive.zza zzaVar = null;
        boolean z = false;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(readHeader)) {
                case 2:
                    dataHolder = (DataHolder) SafeParcelReader.createParcelable(parcel, readHeader, DataHolder.CREATOR);
                    break;
                case 3:
                    arrayList = SafeParcelReader.createTypedList(parcel, readHeader, DriveId.CREATOR);
                    break;
                case 4:
                    zzaVar = (com.google.android.gms.drive.zza) SafeParcelReader.createParcelable(parcel, readHeader, com.google.android.gms.drive.zza.CREATOR);
                    break;
                case 5:
                    z = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, readHeader);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new zzez(dataHolder, arrayList, zzaVar, z);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzez[] newArray(int i) {
        return new zzez[i];
    }
}
