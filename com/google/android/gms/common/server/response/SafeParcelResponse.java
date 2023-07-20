package com.google.android.gms.common.server.response;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseArray;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.server.response.FastJsonResponse;
import com.google.android.gms.common.util.ArrayUtils;
import com.google.android.gms.common.util.Base64Utils;
import com.google.android.gms.common.util.JsonUtils;
import com.google.android.gms.common.util.MapUtils;
import com.google.android.gms.common.util.VisibleForTesting;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@VisibleForTesting
@KeepForSdk
@SafeParcelable.Class(creator = "SafeParcelResponseCreator")
/* loaded from: classes.dex */
public class SafeParcelResponse extends FastSafeParcelableJsonResponse {
    @KeepForSdk
    public static final Parcelable.Creator<SafeParcelResponse> CREATOR = new zap();
    @SafeParcelable.VersionField(getter = "getVersionCode", id = 1)
    private final int a;
    @SafeParcelable.Field(getter = "getParcel", id = 2)
    private final Parcel b;
    private final int c;
    @SafeParcelable.Field(getter = "getFieldMappingDictionary", id = 3)
    private final zak d;
    private final String e;
    private int f;
    private int g;

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public SafeParcelResponse(@SafeParcelable.Param(id = 1) int i, @SafeParcelable.Param(id = 2) Parcel parcel, @SafeParcelable.Param(id = 3) zak zakVar) {
        this.a = i;
        this.b = (Parcel) Preconditions.checkNotNull(parcel);
        this.c = 2;
        this.d = zakVar;
        zak zakVar2 = this.d;
        this.e = zakVar2 == null ? null : zakVar2.zact();
        this.f = 2;
    }

    private SafeParcelResponse(SafeParcelable safeParcelable, zak zakVar, String str) {
        this.a = 1;
        this.b = Parcel.obtain();
        safeParcelable.writeToParcel(this.b, 0);
        this.c = 1;
        this.d = (zak) Preconditions.checkNotNull(zakVar);
        this.e = (String) Preconditions.checkNotNull(str);
        this.f = 2;
    }

    public SafeParcelResponse(zak zakVar, String str) {
        this.a = 1;
        this.b = Parcel.obtain();
        this.c = 0;
        this.d = (zak) Preconditions.checkNotNull(zakVar);
        this.e = (String) Preconditions.checkNotNull(str);
        this.f = 0;
    }

    private final Parcel a() {
        switch (this.f) {
            case 0:
                this.g = SafeParcelWriter.beginObjectHeader(this.b);
            case 1:
                SafeParcelWriter.finishObjectHeader(this.b, this.g);
                this.f = 2;
                break;
        }
        return this.b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static void a(zak zakVar, FastJsonResponse fastJsonResponse) {
        Class<?> cls = fastJsonResponse.getClass();
        if (!zakVar.zaa(cls)) {
            Map<String, FastJsonResponse.Field<?, ?>> fieldMappings = fastJsonResponse.getFieldMappings();
            zakVar.zaa(cls, fieldMappings);
            for (String str : fieldMappings.keySet()) {
                FastJsonResponse.Field<?, ?> field = fieldMappings.get(str);
                Class<? extends FastJsonResponse> cls2 = field.g;
                if (cls2 != null) {
                    try {
                        a(zakVar, cls2.newInstance());
                    } catch (IllegalAccessException e) {
                        String valueOf = String.valueOf(field.g.getCanonicalName());
                        throw new IllegalStateException(valueOf.length() != 0 ? "Could not access object of type ".concat(valueOf) : new String("Could not access object of type "), e);
                    } catch (InstantiationException e2) {
                        String valueOf2 = String.valueOf(field.g.getCanonicalName());
                        throw new IllegalStateException(valueOf2.length() != 0 ? "Could not instantiate an object of type ".concat(valueOf2) : new String("Could not instantiate an object of type "), e2);
                    }
                }
            }
        }
    }

    private static void a(StringBuilder sb, int i, Object obj) {
        switch (i) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                sb.append(obj);
                return;
            case 7:
                sb.append("\"");
                sb.append(JsonUtils.escapeString(obj.toString()));
                sb.append("\"");
                return;
            case 8:
                sb.append("\"");
                sb.append(Base64Utils.encode((byte[]) obj));
                sb.append("\"");
                return;
            case 9:
                sb.append("\"");
                sb.append(Base64Utils.encodeUrlSafe((byte[]) obj));
                sb.append("\"");
                return;
            case 10:
                MapUtils.writeStringMapToJson(sb, (HashMap) obj);
                return;
            case 11:
                throw new IllegalArgumentException("Method does not accept concrete type.");
            default:
                StringBuilder sb2 = new StringBuilder(26);
                sb2.append("Unknown type = ");
                sb2.append(i);
                throw new IllegalArgumentException(sb2.toString());
        }
    }

    private final void a(StringBuilder sb, FastJsonResponse.Field<?, ?> field, Object obj) {
        if (!field.b) {
            a(sb, field.a, obj);
            return;
        }
        ArrayList arrayList = (ArrayList) obj;
        sb.append("[");
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (i != 0) {
                sb.append(",");
            }
            a(sb, field.a, arrayList.get(i));
        }
        sb.append("]");
    }

    private final void a(StringBuilder sb, Map<String, FastJsonResponse.Field<?, ?>> map, Parcel parcel) {
        Object createBigInteger;
        String escapeString;
        String str;
        Object[] createBigIntegerArray;
        Object valueOf;
        Object a;
        SparseArray sparseArray = new SparseArray();
        for (Map.Entry<String, FastJsonResponse.Field<?, ?>> entry : map.entrySet()) {
            sparseArray.put(entry.getValue().getSafeParcelableFieldId(), entry);
        }
        sb.append('{');
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        boolean z = false;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            Map.Entry entry2 = (Map.Entry) sparseArray.get(SafeParcelReader.getFieldId(readHeader));
            if (entry2 != null) {
                if (z) {
                    sb.append(",");
                }
                FastJsonResponse.Field<?, ?> field = (FastJsonResponse.Field) entry2.getValue();
                sb.append("\"");
                sb.append((String) entry2.getKey());
                sb.append("\":");
                if (field.zacn()) {
                    switch (field.c) {
                        case 0:
                            valueOf = Integer.valueOf(SafeParcelReader.readInt(parcel, readHeader));
                            a = a(field, valueOf);
                            break;
                        case 1:
                            valueOf = SafeParcelReader.createBigInteger(parcel, readHeader);
                            a = a(field, valueOf);
                            break;
                        case 2:
                            valueOf = Long.valueOf(SafeParcelReader.readLong(parcel, readHeader));
                            a = a(field, valueOf);
                            break;
                        case 3:
                            valueOf = Float.valueOf(SafeParcelReader.readFloat(parcel, readHeader));
                            a = a(field, valueOf);
                            break;
                        case 4:
                            valueOf = Double.valueOf(SafeParcelReader.readDouble(parcel, readHeader));
                            a = a(field, valueOf);
                            break;
                        case 5:
                            valueOf = SafeParcelReader.createBigDecimal(parcel, readHeader);
                            a = a(field, valueOf);
                            break;
                        case 6:
                            valueOf = Boolean.valueOf(SafeParcelReader.readBoolean(parcel, readHeader));
                            a = a(field, valueOf);
                            break;
                        case 7:
                            valueOf = SafeParcelReader.createString(parcel, readHeader);
                            a = a(field, valueOf);
                            break;
                        case 8:
                        case 9:
                            valueOf = SafeParcelReader.createByteArray(parcel, readHeader);
                            a = a(field, valueOf);
                            break;
                        case 10:
                            Bundle createBundle = SafeParcelReader.createBundle(parcel, readHeader);
                            HashMap hashMap = new HashMap();
                            for (String str2 : createBundle.keySet()) {
                                hashMap.put(str2, createBundle.getString(str2));
                            }
                            a = a(field, hashMap);
                            break;
                        case 11:
                            throw new IllegalArgumentException("Method does not accept concrete type.");
                        default:
                            int i = field.c;
                            StringBuilder sb2 = new StringBuilder(36);
                            sb2.append("Unknown field out type = ");
                            sb2.append(i);
                            throw new IllegalArgumentException(sb2.toString());
                    }
                    a(sb, field, a);
                } else {
                    if (field.d) {
                        sb.append("[");
                        switch (field.c) {
                            case 0:
                                ArrayUtils.writeArray(sb, SafeParcelReader.createIntArray(parcel, readHeader));
                                break;
                            case 1:
                                createBigIntegerArray = SafeParcelReader.createBigIntegerArray(parcel, readHeader);
                                ArrayUtils.writeArray(sb, createBigIntegerArray);
                                break;
                            case 2:
                                ArrayUtils.writeArray(sb, SafeParcelReader.createLongArray(parcel, readHeader));
                                break;
                            case 3:
                                ArrayUtils.writeArray(sb, SafeParcelReader.createFloatArray(parcel, readHeader));
                                break;
                            case 4:
                                ArrayUtils.writeArray(sb, SafeParcelReader.createDoubleArray(parcel, readHeader));
                                break;
                            case 5:
                                createBigIntegerArray = SafeParcelReader.createBigDecimalArray(parcel, readHeader);
                                ArrayUtils.writeArray(sb, createBigIntegerArray);
                                break;
                            case 6:
                                ArrayUtils.writeArray(sb, SafeParcelReader.createBooleanArray(parcel, readHeader));
                                break;
                            case 7:
                                ArrayUtils.writeStringArray(sb, SafeParcelReader.createStringArray(parcel, readHeader));
                                break;
                            case 8:
                            case 9:
                            case 10:
                                throw new UnsupportedOperationException("List of type BASE64, BASE64_URL_SAFE, or STRING_MAP is not supported");
                            case 11:
                                Parcel[] createParcelArray = SafeParcelReader.createParcelArray(parcel, readHeader);
                                int length = createParcelArray.length;
                                for (int i2 = 0; i2 < length; i2++) {
                                    if (i2 > 0) {
                                        sb.append(",");
                                    }
                                    createParcelArray[i2].setDataPosition(0);
                                    a(sb, field.zacq(), createParcelArray[i2]);
                                }
                                break;
                            default:
                                throw new IllegalStateException("Unknown field type out.");
                        }
                        str = "]";
                    } else {
                        switch (field.c) {
                            case 0:
                                sb.append(SafeParcelReader.readInt(parcel, readHeader));
                                break;
                            case 1:
                                createBigInteger = SafeParcelReader.createBigInteger(parcel, readHeader);
                                sb.append(createBigInteger);
                                break;
                            case 2:
                                sb.append(SafeParcelReader.readLong(parcel, readHeader));
                                break;
                            case 3:
                                sb.append(SafeParcelReader.readFloat(parcel, readHeader));
                                break;
                            case 4:
                                sb.append(SafeParcelReader.readDouble(parcel, readHeader));
                                break;
                            case 5:
                                createBigInteger = SafeParcelReader.createBigDecimal(parcel, readHeader);
                                sb.append(createBigInteger);
                                break;
                            case 6:
                                sb.append(SafeParcelReader.readBoolean(parcel, readHeader));
                                break;
                            case 7:
                                String createString = SafeParcelReader.createString(parcel, readHeader);
                                sb.append("\"");
                                escapeString = JsonUtils.escapeString(createString);
                                sb.append(escapeString);
                                str = "\"";
                                break;
                            case 8:
                                byte[] createByteArray = SafeParcelReader.createByteArray(parcel, readHeader);
                                sb.append("\"");
                                escapeString = Base64Utils.encode(createByteArray);
                                sb.append(escapeString);
                                str = "\"";
                                break;
                            case 9:
                                byte[] createByteArray2 = SafeParcelReader.createByteArray(parcel, readHeader);
                                sb.append("\"");
                                escapeString = Base64Utils.encodeUrlSafe(createByteArray2);
                                sb.append(escapeString);
                                str = "\"";
                                break;
                            case 10:
                                Bundle createBundle2 = SafeParcelReader.createBundle(parcel, readHeader);
                                Set<String> keySet = createBundle2.keySet();
                                keySet.size();
                                sb.append("{");
                                boolean z2 = true;
                                for (String str3 : keySet) {
                                    if (!z2) {
                                        sb.append(",");
                                    }
                                    sb.append("\"");
                                    sb.append(str3);
                                    sb.append("\"");
                                    sb.append(":");
                                    sb.append("\"");
                                    sb.append(JsonUtils.escapeString(createBundle2.getString(str3)));
                                    sb.append("\"");
                                    z2 = false;
                                }
                                str = "}";
                                break;
                            case 11:
                                Parcel createParcel = SafeParcelReader.createParcel(parcel, readHeader);
                                createParcel.setDataPosition(0);
                                a(sb, field.zacq(), createParcel);
                                break;
                            default:
                                throw new IllegalStateException("Unknown field type out");
                        }
                    }
                    sb.append(str);
                }
                z = true;
            }
        }
        if (parcel.dataPosition() == validateObjectHeader) {
            sb.append('}');
            return;
        }
        StringBuilder sb3 = new StringBuilder(37);
        sb3.append("Overread allowed size end=");
        sb3.append(validateObjectHeader);
        throw new SafeParcelReader.ParseException(sb3.toString(), parcel);
    }

    private final void c(FastJsonResponse.Field<?, ?> field) {
        if (field.f != -1) {
            Parcel parcel = this.b;
            if (parcel == null) {
                throw new IllegalStateException("Internal Parcel object is null.");
            }
            switch (this.f) {
                case 0:
                    this.g = SafeParcelWriter.beginObjectHeader(parcel);
                    this.f = 1;
                    return;
                case 1:
                    return;
                case 2:
                    throw new IllegalStateException("Attempted to parse JSON with a SafeParcelResponse object that is already filled with data.");
                default:
                    throw new IllegalStateException("Unknown parse state in SafeParcelResponse.");
            }
        }
        throw new IllegalStateException("Field does not have a valid safe parcelable field id.");
    }

    @KeepForSdk
    public static <T extends FastJsonResponse & SafeParcelable> SafeParcelResponse from(T t) {
        String canonicalName = t.getClass().getCanonicalName();
        zak zakVar = new zak(t.getClass());
        a(zakVar, t);
        zakVar.zacs();
        zakVar.zacr();
        return new SafeParcelResponse(t, zakVar, canonicalName);
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    protected final void a(FastJsonResponse.Field<?, ?> field, String str, double d) {
        c(field);
        SafeParcelWriter.writeDouble(this.b, field.getSafeParcelableFieldId(), d);
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    protected final void a(FastJsonResponse.Field<?, ?> field, String str, float f) {
        c(field);
        SafeParcelWriter.writeFloat(this.b, field.getSafeParcelableFieldId(), f);
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    protected void a(FastJsonResponse.Field<?, ?> field, String str, int i) {
        c(field);
        SafeParcelWriter.writeInt(this.b, field.getSafeParcelableFieldId(), i);
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    protected void a(FastJsonResponse.Field<?, ?> field, String str, long j) {
        c(field);
        SafeParcelWriter.writeLong(this.b, field.getSafeParcelableFieldId(), j);
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    protected void a(FastJsonResponse.Field<?, ?> field, String str, String str2) {
        c(field);
        SafeParcelWriter.writeString(this.b, field.getSafeParcelableFieldId(), str2, true);
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    protected final void a(FastJsonResponse.Field<?, ?> field, String str, BigDecimal bigDecimal) {
        c(field);
        SafeParcelWriter.writeBigDecimal(this.b, field.getSafeParcelableFieldId(), bigDecimal, true);
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    protected final void a(FastJsonResponse.Field<?, ?> field, String str, BigInteger bigInteger) {
        c(field);
        SafeParcelWriter.writeBigInteger(this.b, field.getSafeParcelableFieldId(), bigInteger, true);
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    protected final void a(FastJsonResponse.Field<?, ?> field, String str, ArrayList<Integer> arrayList) {
        c(field);
        int size = arrayList.size();
        int[] iArr = new int[size];
        for (int i = 0; i < size; i++) {
            iArr[i] = arrayList.get(i).intValue();
        }
        SafeParcelWriter.writeIntArray(this.b, field.getSafeParcelableFieldId(), iArr, true);
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    protected final void a(FastJsonResponse.Field<?, ?> field, String str, Map<String, String> map) {
        c(field);
        Bundle bundle = new Bundle();
        for (String str2 : map.keySet()) {
            bundle.putString(str2, map.get(str2));
        }
        SafeParcelWriter.writeBundle(this.b, field.getSafeParcelableFieldId(), bundle, true);
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    protected void a(FastJsonResponse.Field<?, ?> field, String str, boolean z) {
        c(field);
        SafeParcelWriter.writeBoolean(this.b, field.getSafeParcelableFieldId(), z);
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    protected void a(FastJsonResponse.Field<?, ?> field, String str, byte[] bArr) {
        c(field);
        SafeParcelWriter.writeByteArray(this.b, field.getSafeParcelableFieldId(), bArr, true);
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public <T extends FastJsonResponse> void addConcreteTypeArrayInternal(FastJsonResponse.Field<?, ?> field, String str, ArrayList<T> arrayList) {
        c(field);
        ArrayList arrayList2 = new ArrayList();
        arrayList.size();
        ArrayList<T> arrayList3 = arrayList;
        int size = arrayList3.size();
        int i = 0;
        while (i < size) {
            T t = arrayList3.get(i);
            i++;
            arrayList2.add(((SafeParcelResponse) t).a());
        }
        SafeParcelWriter.writeParcelList(this.b, field.getSafeParcelableFieldId(), arrayList2, true);
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public <T extends FastJsonResponse> void addConcreteTypeInternal(FastJsonResponse.Field<?, ?> field, String str, T t) {
        c(field);
        SafeParcelWriter.writeParcel(this.b, field.getSafeParcelableFieldId(), ((SafeParcelResponse) t).a(), true);
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    protected final void b(FastJsonResponse.Field<?, ?> field, String str, ArrayList<BigInteger> arrayList) {
        c(field);
        int size = arrayList.size();
        BigInteger[] bigIntegerArr = new BigInteger[size];
        for (int i = 0; i < size; i++) {
            bigIntegerArr[i] = arrayList.get(i);
        }
        SafeParcelWriter.writeBigIntegerArray(this.b, field.getSafeParcelableFieldId(), bigIntegerArr, true);
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    protected final void c(FastJsonResponse.Field<?, ?> field, String str, ArrayList<Long> arrayList) {
        c(field);
        int size = arrayList.size();
        long[] jArr = new long[size];
        for (int i = 0; i < size; i++) {
            jArr[i] = arrayList.get(i).longValue();
        }
        SafeParcelWriter.writeLongArray(this.b, field.getSafeParcelableFieldId(), jArr, true);
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    protected final void d(FastJsonResponse.Field<?, ?> field, String str, ArrayList<Float> arrayList) {
        c(field);
        int size = arrayList.size();
        float[] fArr = new float[size];
        for (int i = 0; i < size; i++) {
            fArr[i] = arrayList.get(i).floatValue();
        }
        SafeParcelWriter.writeFloatArray(this.b, field.getSafeParcelableFieldId(), fArr, true);
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    protected final void e(FastJsonResponse.Field<?, ?> field, String str, ArrayList<Double> arrayList) {
        c(field);
        int size = arrayList.size();
        double[] dArr = new double[size];
        for (int i = 0; i < size; i++) {
            dArr[i] = arrayList.get(i).doubleValue();
        }
        SafeParcelWriter.writeDoubleArray(this.b, field.getSafeParcelableFieldId(), dArr, true);
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    protected final void f(FastJsonResponse.Field<?, ?> field, String str, ArrayList<BigDecimal> arrayList) {
        c(field);
        int size = arrayList.size();
        BigDecimal[] bigDecimalArr = new BigDecimal[size];
        for (int i = 0; i < size; i++) {
            bigDecimalArr[i] = arrayList.get(i);
        }
        SafeParcelWriter.writeBigDecimalArray(this.b, field.getSafeParcelableFieldId(), bigDecimalArr, true);
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    protected final void g(FastJsonResponse.Field<?, ?> field, String str, ArrayList<Boolean> arrayList) {
        c(field);
        int size = arrayList.size();
        boolean[] zArr = new boolean[size];
        for (int i = 0; i < size; i++) {
            zArr[i] = arrayList.get(i).booleanValue();
        }
        SafeParcelWriter.writeBooleanArray(this.b, field.getSafeParcelableFieldId(), zArr, true);
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public Map<String, FastJsonResponse.Field<?, ?>> getFieldMappings() {
        zak zakVar = this.d;
        if (zakVar == null) {
            return null;
        }
        return zakVar.zai(this.e);
    }

    @Override // com.google.android.gms.common.server.response.FastSafeParcelableJsonResponse, com.google.android.gms.common.server.response.FastJsonResponse
    public Object getValueObject(String str) {
        throw new UnsupportedOperationException("Converting to JSON does not require this method.");
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    protected void h(FastJsonResponse.Field<?, ?> field, String str, ArrayList<String> arrayList) {
        c(field);
        int size = arrayList.size();
        String[] strArr = new String[size];
        for (int i = 0; i < size; i++) {
            strArr[i] = arrayList.get(i);
        }
        SafeParcelWriter.writeStringArray(this.b, field.getSafeParcelableFieldId(), strArr, true);
    }

    @Override // com.google.android.gms.common.server.response.FastSafeParcelableJsonResponse, com.google.android.gms.common.server.response.FastJsonResponse
    public boolean isPrimitiveFieldSet(String str) {
        throw new UnsupportedOperationException("Converting to JSON does not require this method.");
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public String toString() {
        Preconditions.checkNotNull(this.d, "Cannot convert to JSON on client side.");
        Parcel a = a();
        a.setDataPosition(0);
        StringBuilder sb = new StringBuilder(100);
        a(sb, this.d.zai(this.e), a);
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zak zakVar;
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.a);
        SafeParcelWriter.writeParcel(parcel, 2, a(), false);
        int i2 = this.c;
        switch (i2) {
            case 0:
                zakVar = null;
                break;
            case 1:
            case 2:
                zakVar = this.d;
                break;
            default:
                StringBuilder sb = new StringBuilder(34);
                sb.append("Invalid creation type: ");
                sb.append(i2);
                throw new IllegalStateException(sb.toString());
        }
        SafeParcelWriter.writeParcelable(parcel, 3, zakVar, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
