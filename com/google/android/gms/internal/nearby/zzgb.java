package com.google.android.gms.internal.nearby;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.nearby.connection.AdvertisingOptions;

/* loaded from: classes.dex */
public final class zzgb implements Parcelable.Creator<zzfy> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzfy createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        IBinder iBinder = null;
        IBinder iBinder2 = null;
        String str = null;
        String str2 = null;
        AdvertisingOptions advertisingOptions = null;
        IBinder iBinder3 = null;
        long j = 0;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(readHeader)) {
                case 1:
                    iBinder = SafeParcelReader.readIBinder(parcel, readHeader);
                    break;
                case 2:
                    iBinder2 = SafeParcelReader.readIBinder(parcel, readHeader);
                    break;
                case 3:
                    str = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 4:
                    str2 = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 5:
                    j = SafeParcelReader.readLong(parcel, readHeader);
                    break;
                case 6:
                    advertisingOptions = (AdvertisingOptions) SafeParcelReader.createParcelable(parcel, readHeader, AdvertisingOptions.CREATOR);
                    break;
                case 7:
                    iBinder3 = SafeParcelReader.readIBinder(parcel, readHeader);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, readHeader);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new zzfy(iBinder, iBinder2, str, str2, j, advertisingOptions, iBinder3);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzfy[] newArray(int i) {
        return new zzfy[i];
    }
}
