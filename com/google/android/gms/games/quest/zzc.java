package com.google.android.gms.games.quest;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.games.GameEntity;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class zzc implements Parcelable.Creator<QuestEntity> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ QuestEntity createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        long j = 0;
        long j2 = 0;
        long j3 = 0;
        long j4 = 0;
        long j5 = 0;
        GameEntity gameEntity = null;
        String str = null;
        Uri uri = null;
        String str2 = null;
        String str3 = null;
        Uri uri2 = null;
        String str4 = null;
        String str5 = null;
        ArrayList arrayList = null;
        int i = 0;
        int i2 = 0;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(readHeader)) {
                case 1:
                    gameEntity = (GameEntity) SafeParcelReader.createParcelable(parcel, readHeader, GameEntity.CREATOR);
                    break;
                case 2:
                    str = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 3:
                    j = SafeParcelReader.readLong(parcel, readHeader);
                    break;
                case 4:
                    uri = (Uri) SafeParcelReader.createParcelable(parcel, readHeader, Uri.CREATOR);
                    break;
                case 5:
                    str2 = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 6:
                    str3 = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 7:
                    j2 = SafeParcelReader.readLong(parcel, readHeader);
                    break;
                case 8:
                    j3 = SafeParcelReader.readLong(parcel, readHeader);
                    break;
                case 9:
                    uri2 = (Uri) SafeParcelReader.createParcelable(parcel, readHeader, Uri.CREATOR);
                    break;
                case 10:
                    str4 = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 11:
                default:
                    SafeParcelReader.skipUnknownField(parcel, readHeader);
                    break;
                case 12:
                    str5 = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 13:
                    j4 = SafeParcelReader.readLong(parcel, readHeader);
                    break;
                case 14:
                    j5 = SafeParcelReader.readLong(parcel, readHeader);
                    break;
                case 15:
                    i = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 16:
                    i2 = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 17:
                    arrayList = SafeParcelReader.createTypedList(parcel, readHeader, MilestoneEntity.CREATOR);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new QuestEntity(gameEntity, str, j, uri, str2, str3, j2, j3, uri2, str4, str5, j4, j5, i, i2, arrayList);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ QuestEntity[] newArray(int i) {
        return new QuestEntity[i];
    }
}
