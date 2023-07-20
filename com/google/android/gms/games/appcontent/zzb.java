package com.google.android.gms.games.appcontent;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class zzb implements Parcelable.Creator<AppContentActionEntity> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ AppContentActionEntity createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        ArrayList arrayList = null;
        String str = null;
        Bundle bundle = null;
        String str2 = null;
        String str3 = null;
        AppContentAnnotationEntity appContentAnnotationEntity = null;
        String str4 = null;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(readHeader)) {
                case 1:
                    arrayList = SafeParcelReader.createTypedList(parcel, readHeader, AppContentConditionEntity.CREATOR);
                    break;
                case 2:
                    str = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 3:
                    bundle = SafeParcelReader.createBundle(parcel, readHeader);
                    break;
                case 4:
                case 5:
                default:
                    SafeParcelReader.skipUnknownField(parcel, readHeader);
                    break;
                case 6:
                    str2 = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 7:
                    str3 = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 8:
                    appContentAnnotationEntity = (AppContentAnnotationEntity) SafeParcelReader.createParcelable(parcel, readHeader, AppContentAnnotationEntity.CREATOR);
                    break;
                case 9:
                    str4 = SafeParcelReader.createString(parcel, readHeader);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new AppContentActionEntity(arrayList, str, bundle, str2, str3, appContentAnnotationEntity, str4);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ AppContentActionEntity[] newArray(int i) {
        return new AppContentActionEntity[i];
    }
}
