package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.server.response.FastJsonResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@ShowFirstParty
@SafeParcelable.Class(creator = "FieldMappingDictionaryCreator")
/* loaded from: classes.dex */
public final class zak extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zak> CREATOR = new zan();
    @SafeParcelable.VersionField(id = 1)
    private final int a;
    private final HashMap<String, Map<String, FastJsonResponse.Field<?, ?>>> b;
    @SafeParcelable.Field(getter = "getSerializedDictionary", id = 2)
    private final ArrayList<zal> c;
    @SafeParcelable.Field(getter = "getRootClassName", id = 3)
    private final String d;

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public zak(@SafeParcelable.Param(id = 1) int i, @SafeParcelable.Param(id = 2) ArrayList<zal> arrayList, @SafeParcelable.Param(id = 3) String str) {
        this.a = i;
        this.c = null;
        HashMap<String, Map<String, FastJsonResponse.Field<?, ?>>> hashMap = new HashMap<>();
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            zal zalVar = arrayList.get(i2);
            String str2 = zalVar.a;
            HashMap hashMap2 = new HashMap();
            int size2 = zalVar.b.size();
            for (int i3 = 0; i3 < size2; i3++) {
                zam zamVar = zalVar.b.get(i3);
                hashMap2.put(zamVar.a, zamVar.b);
            }
            hashMap.put(str2, hashMap2);
        }
        this.b = hashMap;
        this.d = (String) Preconditions.checkNotNull(str);
        zacr();
    }

    public zak(Class<? extends FastJsonResponse> cls) {
        this.a = 1;
        this.c = null;
        this.b = new HashMap<>();
        this.d = cls.getCanonicalName();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        for (String str : this.b.keySet()) {
            sb.append(str);
            sb.append(":\n");
            Map<String, FastJsonResponse.Field<?, ?>> map = this.b.get(str);
            for (String str2 : map.keySet()) {
                sb.append("  ");
                sb.append(str2);
                sb.append(": ");
                sb.append(map.get(str2));
            }
        }
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.a);
        ArrayList arrayList = new ArrayList();
        for (String str : this.b.keySet()) {
            arrayList.add(new zal(str, this.b.get(str)));
        }
        SafeParcelWriter.writeTypedList(parcel, 2, arrayList, false);
        SafeParcelWriter.writeString(parcel, 3, this.d, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final void zaa(Class<? extends FastJsonResponse> cls, Map<String, FastJsonResponse.Field<?, ?>> map) {
        this.b.put(cls.getCanonicalName(), map);
    }

    public final boolean zaa(Class<? extends FastJsonResponse> cls) {
        return this.b.containsKey(cls.getCanonicalName());
    }

    public final void zacr() {
        for (String str : this.b.keySet()) {
            Map<String, FastJsonResponse.Field<?, ?>> map = this.b.get(str);
            for (String str2 : map.keySet()) {
                map.get(str2).zaa(this);
            }
        }
    }

    public final void zacs() {
        for (String str : this.b.keySet()) {
            Map<String, FastJsonResponse.Field<?, ?>> map = this.b.get(str);
            HashMap hashMap = new HashMap();
            for (String str2 : map.keySet()) {
                hashMap.put(str2, map.get(str2).zacl());
            }
            this.b.put(str, hashMap);
        }
    }

    public final String zact() {
        return this.d;
    }

    public final Map<String, FastJsonResponse.Field<?, ?>> zai(String str) {
        return this.b.get(str);
    }
}
