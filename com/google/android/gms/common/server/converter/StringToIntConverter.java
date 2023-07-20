package com.google.android.gms.common.server.converter;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseArray;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.server.response.FastJsonResponse;
import java.util.ArrayList;
import java.util.HashMap;

@KeepForSdk
@SafeParcelable.Class(creator = "StringToIntConverterCreator")
/* loaded from: classes.dex */
public final class StringToIntConverter extends AbstractSafeParcelable implements FastJsonResponse.FieldConverter<String, Integer> {
    public static final Parcelable.Creator<StringToIntConverter> CREATOR = new zac();
    @SafeParcelable.VersionField(id = 1)
    private final int a;
    private final HashMap<String, Integer> b;
    private final SparseArray<String> c;
    @SafeParcelable.Field(getter = "getSerializedMap", id = 2)
    private final ArrayList<zaa> d;

    @SafeParcelable.Class(creator = "StringToIntConverterEntryCreator")
    /* loaded from: classes.dex */
    public static final class zaa extends AbstractSafeParcelable {
        public static final Parcelable.Creator<zaa> CREATOR = new zad();
        @SafeParcelable.Field(id = 2)
        final String a;
        @SafeParcelable.Field(id = 3)
        final int b;
        @SafeParcelable.VersionField(id = 1)
        private final int c;

        /* JADX INFO: Access modifiers changed from: package-private */
        @SafeParcelable.Constructor
        public zaa(@SafeParcelable.Param(id = 1) int i, @SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) int i2) {
            this.c = i;
            this.a = str;
            this.b = i2;
        }

        zaa(String str, int i) {
            this.c = 1;
            this.a = str;
            this.b = i;
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i) {
            int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
            SafeParcelWriter.writeInt(parcel, 1, this.c);
            SafeParcelWriter.writeString(parcel, 2, this.a, false);
            SafeParcelWriter.writeInt(parcel, 3, this.b);
            SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
        }
    }

    @KeepForSdk
    public StringToIntConverter() {
        this.a = 1;
        this.b = new HashMap<>();
        this.c = new SparseArray<>();
        this.d = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public StringToIntConverter(@SafeParcelable.Param(id = 1) int i, @SafeParcelable.Param(id = 2) ArrayList<zaa> arrayList) {
        this.a = i;
        this.b = new HashMap<>();
        this.c = new SparseArray<>();
        this.d = null;
        ArrayList<zaa> arrayList2 = arrayList;
        int size = arrayList2.size();
        int i2 = 0;
        while (i2 < size) {
            zaa zaaVar = arrayList2.get(i2);
            i2++;
            zaa zaaVar2 = zaaVar;
            add(zaaVar2.a, zaaVar2.b);
        }
    }

    @KeepForSdk
    public final StringToIntConverter add(String str, int i) {
        this.b.put(str, Integer.valueOf(i));
        this.c.put(i, str);
        return this;
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse.FieldConverter
    public final /* synthetic */ Integer convert(String str) {
        Integer num = this.b.get(str);
        return num == null ? this.b.get("gms_unknown") : num;
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse.FieldConverter
    public final /* synthetic */ String convertBack(Integer num) {
        String str = this.c.get(num.intValue());
        return (str != null || !this.b.containsKey("gms_unknown")) ? str : "gms_unknown";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.a);
        ArrayList arrayList = new ArrayList();
        for (String str : this.b.keySet()) {
            arrayList.add(new zaa(str, this.b.get(str).intValue()));
        }
        SafeParcelWriter.writeTypedList(parcel, 2, arrayList, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse.FieldConverter
    public final int zacj() {
        return 7;
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse.FieldConverter
    public final int zack() {
        return 0;
    }
}
