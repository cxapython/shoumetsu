package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.server.converter.zaa;
import com.google.android.gms.common.util.Base64Utils;
import com.google.android.gms.common.util.JsonUtils;
import com.google.android.gms.common.util.MapUtils;
import com.google.android.gms.common.util.VisibleForTesting;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@ShowFirstParty
@KeepForSdk
/* loaded from: classes.dex */
public abstract class FastJsonResponse {

    @VisibleForTesting
    @SafeParcelable.Class(creator = "FieldCreator")
    @ShowFirstParty
    @KeepForSdk
    /* loaded from: classes.dex */
    public static class Field<I, O> extends AbstractSafeParcelable {
        public static final zai CREATOR = new zai();
        @SafeParcelable.Field(getter = "getTypeIn", id = 2)
        protected final int a;
        @SafeParcelable.Field(getter = "isTypeInArray", id = 3)
        protected final boolean b;
        @SafeParcelable.Field(getter = "getTypeOut", id = 4)
        protected final int c;
        @SafeParcelable.Field(getter = "isTypeOutArray", id = 5)
        protected final boolean d;
        @SafeParcelable.Field(getter = "getOutputFieldName", id = 6)
        protected final String e;
        @SafeParcelable.Field(getter = "getSafeParcelableFieldId", id = 7)
        protected final int f;
        protected final Class<? extends FastJsonResponse> g;
        @SafeParcelable.VersionField(getter = "getVersionCode", id = 1)
        private final int h;
        @SafeParcelable.Field(getter = "getConcreteTypeName", id = 8)
        private final String i;
        private zak j;
        @SafeParcelable.Field(getter = "getWrappedConverter", id = 9, type = "com.google.android.gms.common.server.converter.ConverterWrapper")
        private FieldConverter<I, O> k;

        /* JADX INFO: Access modifiers changed from: package-private */
        @SafeParcelable.Constructor
        public Field(@SafeParcelable.Param(id = 1) int i, @SafeParcelable.Param(id = 2) int i2, @SafeParcelable.Param(id = 3) boolean z, @SafeParcelable.Param(id = 4) int i3, @SafeParcelable.Param(id = 5) boolean z2, @SafeParcelable.Param(id = 6) String str, @SafeParcelable.Param(id = 7) int i4, @SafeParcelable.Param(id = 8) String str2, @SafeParcelable.Param(id = 9) zaa zaaVar) {
            this.h = i;
            this.a = i2;
            this.b = z;
            this.c = i3;
            this.d = z2;
            this.e = str;
            this.f = i4;
            if (str2 == null) {
                this.g = null;
                this.i = null;
            } else {
                this.g = SafeParcelResponse.class;
                this.i = str2;
            }
            if (zaaVar == null) {
                this.k = null;
            } else {
                this.k = (FieldConverter<I, O>) zaaVar.zaci();
            }
        }

        private Field(int i, boolean z, int i2, boolean z2, String str, int i3, Class<? extends FastJsonResponse> cls, FieldConverter<I, O> fieldConverter) {
            this.h = 1;
            this.a = i;
            this.b = z;
            this.c = i2;
            this.d = z2;
            this.e = str;
            this.f = i3;
            this.g = cls;
            this.i = cls == null ? null : cls.getCanonicalName();
            this.k = fieldConverter;
        }

        private final String a() {
            String str = this.i;
            if (str == null) {
                return null;
            }
            return str;
        }

        private final zaa b() {
            FieldConverter<I, O> fieldConverter = this.k;
            if (fieldConverter == null) {
                return null;
            }
            return zaa.zaa(fieldConverter);
        }

        @VisibleForTesting
        @KeepForSdk
        public static Field<byte[], byte[]> forBase64(String str, int i) {
            return new Field<>(8, false, 8, false, str, i, null, null);
        }

        @KeepForSdk
        public static Field<Boolean, Boolean> forBoolean(String str, int i) {
            return new Field<>(6, false, 6, false, str, i, null, null);
        }

        @KeepForSdk
        public static <T extends FastJsonResponse> Field<T, T> forConcreteType(String str, int i, Class<T> cls) {
            return new Field<>(11, false, 11, false, str, i, cls, null);
        }

        @KeepForSdk
        public static <T extends FastJsonResponse> Field<ArrayList<T>, ArrayList<T>> forConcreteTypeArray(String str, int i, Class<T> cls) {
            return new Field<>(11, true, 11, true, str, i, cls, null);
        }

        @KeepForSdk
        public static Field<Double, Double> forDouble(String str, int i) {
            return new Field<>(4, false, 4, false, str, i, null, null);
        }

        @KeepForSdk
        public static Field<Float, Float> forFloat(String str, int i) {
            return new Field<>(3, false, 3, false, str, i, null, null);
        }

        @VisibleForTesting
        @KeepForSdk
        public static Field<Integer, Integer> forInteger(String str, int i) {
            return new Field<>(0, false, 0, false, str, i, null, null);
        }

        @KeepForSdk
        public static Field<Long, Long> forLong(String str, int i) {
            return new Field<>(2, false, 2, false, str, i, null, null);
        }

        @KeepForSdk
        public static Field<String, String> forString(String str, int i) {
            return new Field<>(7, false, 7, false, str, i, null, null);
        }

        @KeepForSdk
        public static Field<ArrayList<String>, ArrayList<String>> forStrings(String str, int i) {
            return new Field<>(7, true, 7, true, str, i, null, null);
        }

        @KeepForSdk
        public static Field withConverter(String str, int i, FieldConverter<?, ?> fieldConverter, boolean z) {
            return new Field(fieldConverter.zacj(), z, fieldConverter.zack(), false, str, i, null, fieldConverter);
        }

        public final O convert(I i) {
            return this.k.convert(i);
        }

        public final I convertBack(O o) {
            return this.k.convertBack(o);
        }

        @KeepForSdk
        public int getSafeParcelableFieldId() {
            return this.f;
        }

        public String toString() {
            Objects.ToStringHelper add = Objects.toStringHelper(this).add("versionCode", Integer.valueOf(this.h)).add("typeIn", Integer.valueOf(this.a)).add("typeInArray", Boolean.valueOf(this.b)).add("typeOut", Integer.valueOf(this.c)).add("typeOutArray", Boolean.valueOf(this.d)).add("outputFieldName", this.e).add("safeParcelFieldId", Integer.valueOf(this.f)).add("concreteTypeName", a());
            Class<? extends FastJsonResponse> cls = this.g;
            if (cls != null) {
                add.add("concreteType.class", cls.getCanonicalName());
            }
            FieldConverter<I, O> fieldConverter = this.k;
            if (fieldConverter != null) {
                add.add("converterName", fieldConverter.getClass().getCanonicalName());
            }
            return add.toString();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
            SafeParcelWriter.writeInt(parcel, 1, this.h);
            SafeParcelWriter.writeInt(parcel, 2, this.a);
            SafeParcelWriter.writeBoolean(parcel, 3, this.b);
            SafeParcelWriter.writeInt(parcel, 4, this.c);
            SafeParcelWriter.writeBoolean(parcel, 5, this.d);
            SafeParcelWriter.writeString(parcel, 6, this.e, false);
            SafeParcelWriter.writeInt(parcel, 7, getSafeParcelableFieldId());
            SafeParcelWriter.writeString(parcel, 8, a(), false);
            SafeParcelWriter.writeParcelable(parcel, 9, b(), i, false);
            SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
        }

        public final void zaa(zak zakVar) {
            this.j = zakVar;
        }

        public final Field<I, O> zacl() {
            return new Field<>(this.h, this.a, this.b, this.c, this.d, this.e, this.f, this.i, b());
        }

        public final boolean zacn() {
            return this.k != null;
        }

        public final FastJsonResponse zacp() {
            Class<? extends FastJsonResponse> cls = this.g;
            if (cls == SafeParcelResponse.class) {
                Preconditions.checkNotNull(this.j, "The field mapping dictionary must be set if the concrete type is a SafeParcelResponse object.");
                return new SafeParcelResponse(this.j, this.i);
            }
            return cls.newInstance();
        }

        public final Map<String, Field<?, ?>> zacq() {
            Preconditions.checkNotNull(this.i);
            Preconditions.checkNotNull(this.j);
            return this.j.zai(this.i);
        }
    }

    @ShowFirstParty
    /* loaded from: classes.dex */
    public interface FieldConverter<I, O> {
        O convert(I i);

        I convertBack(O o);

        int zacj();

        int zack();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    public static <O, I> I a(Field<I, O> field, Object obj) {
        return ((Field) field).k != null ? field.convertBack(obj) : obj;
    }

    private static void a(StringBuilder sb, Field field, Object obj) {
        String str;
        if (field.a == 11) {
            str = field.g.cast(obj).toString();
        } else if (field.a != 7) {
            sb.append(obj);
            return;
        } else {
            sb.append("\"");
            sb.append(JsonUtils.escapeString((String) obj));
            str = "\"";
        }
        sb.append(str);
    }

    private static <O> boolean a(String str, O o) {
        if (o == null) {
            if (!Log.isLoggable("FastJsonResponse", 6)) {
                return false;
            }
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 58);
            sb.append("Output field (");
            sb.append(str);
            sb.append(") has a null value, but expected a primitive");
            Log.e("FastJsonResponse", sb.toString());
            return false;
        }
        return true;
    }

    private final <I, O> void b(Field<I, O> field, I i) {
        String str = field.e;
        O convert = field.convert(i);
        switch (field.c) {
            case 0:
                if (!a(str, convert)) {
                    return;
                }
                a((Field<?, ?>) field, str, ((Integer) convert).intValue());
                return;
            case 1:
                a((Field<?, ?>) field, str, (BigInteger) convert);
                return;
            case 2:
                if (!a(str, convert)) {
                    return;
                }
                a((Field<?, ?>) field, str, ((Long) convert).longValue());
                return;
            case 3:
            default:
                int i2 = field.c;
                StringBuilder sb = new StringBuilder(44);
                sb.append("Unsupported type for conversion: ");
                sb.append(i2);
                throw new IllegalStateException(sb.toString());
            case 4:
                if (!a(str, convert)) {
                    return;
                }
                a((Field<?, ?>) field, str, ((Double) convert).doubleValue());
                return;
            case 5:
                a((Field<?, ?>) field, str, (BigDecimal) convert);
                return;
            case 6:
                if (!a(str, convert)) {
                    return;
                }
                a((Field<?, ?>) field, str, ((Boolean) convert).booleanValue());
                return;
            case 7:
                a((Field<?, ?>) field, str, (String) convert);
                return;
            case 8:
            case 9:
                if (!a(str, convert)) {
                    return;
                }
                a((Field<?, ?>) field, str, (byte[]) convert);
                return;
        }
    }

    protected void a(Field<?, ?> field, String str, double d) {
        throw new UnsupportedOperationException("Double not supported");
    }

    protected void a(Field<?, ?> field, String str, float f) {
        throw new UnsupportedOperationException("Float not supported");
    }

    @KeepForSdk
    protected void a(Field<?, ?> field, String str, int i) {
        throw new UnsupportedOperationException("Integer not supported");
    }

    @KeepForSdk
    protected void a(Field<?, ?> field, String str, long j) {
        throw new UnsupportedOperationException("Long not supported");
    }

    @KeepForSdk
    protected void a(Field<?, ?> field, String str, String str2) {
        throw new UnsupportedOperationException("String not supported");
    }

    protected void a(Field<?, ?> field, String str, BigDecimal bigDecimal) {
        throw new UnsupportedOperationException("BigDecimal not supported");
    }

    protected void a(Field<?, ?> field, String str, BigInteger bigInteger) {
        throw new UnsupportedOperationException("BigInteger not supported");
    }

    protected void a(Field<?, ?> field, String str, ArrayList<Integer> arrayList) {
        throw new UnsupportedOperationException("Integer list not supported");
    }

    protected void a(Field<?, ?> field, String str, Map<String, String> map) {
        throw new UnsupportedOperationException("String map not supported");
    }

    @KeepForSdk
    protected void a(Field<?, ?> field, String str, boolean z) {
        throw new UnsupportedOperationException("Boolean not supported");
    }

    @KeepForSdk
    protected void a(Field<?, ?> field, String str, byte[] bArr) {
        throw new UnsupportedOperationException("byte[] not supported");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @KeepForSdk
    public boolean a(Field field) {
        if (field.c == 11) {
            if (field.d) {
                String str = field.e;
                throw new UnsupportedOperationException("Concrete type arrays not supported");
            }
            String str2 = field.e;
            throw new UnsupportedOperationException("Concrete types not supported");
        }
        return isPrimitiveFieldSet(field.e);
    }

    @KeepForSdk
    public <T extends FastJsonResponse> void addConcreteTypeArrayInternal(Field<?, ?> field, String str, ArrayList<T> arrayList) {
        throw new UnsupportedOperationException("Concrete type array not supported");
    }

    @KeepForSdk
    public <T extends FastJsonResponse> void addConcreteTypeInternal(Field<?, ?> field, String str, T t) {
        throw new UnsupportedOperationException("Concrete type not supported");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @KeepForSdk
    public Object b(Field field) {
        String str = field.e;
        if (field.g != null) {
            Preconditions.checkState(getValueObject(field.e) == null, "Concrete field shouldn't be value object: %s", field.e);
            boolean z = field.d;
            try {
                char upperCase = Character.toUpperCase(str.charAt(0));
                String substring = str.substring(1);
                StringBuilder sb = new StringBuilder(String.valueOf(substring).length() + 4);
                sb.append("get");
                sb.append(upperCase);
                sb.append(substring);
                return getClass().getMethod(sb.toString(), new Class[0]).invoke(this, new Object[0]);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return getValueObject(field.e);
    }

    protected void b(Field<?, ?> field, String str, ArrayList<BigInteger> arrayList) {
        throw new UnsupportedOperationException("BigInteger list not supported");
    }

    protected void c(Field<?, ?> field, String str, ArrayList<Long> arrayList) {
        throw new UnsupportedOperationException("Long list not supported");
    }

    protected void d(Field<?, ?> field, String str, ArrayList<Float> arrayList) {
        throw new UnsupportedOperationException("Float list not supported");
    }

    protected void e(Field<?, ?> field, String str, ArrayList<Double> arrayList) {
        throw new UnsupportedOperationException("Double list not supported");
    }

    protected void f(Field<?, ?> field, String str, ArrayList<BigDecimal> arrayList) {
        throw new UnsupportedOperationException("BigDecimal list not supported");
    }

    protected void g(Field<?, ?> field, String str, ArrayList<Boolean> arrayList) {
        throw new UnsupportedOperationException("Boolean list not supported");
    }

    @KeepForSdk
    public abstract Map<String, Field<?, ?>> getFieldMappings();

    @KeepForSdk
    protected abstract Object getValueObject(String str);

    @KeepForSdk
    protected void h(Field<?, ?> field, String str, ArrayList<String> arrayList) {
        throw new UnsupportedOperationException("String list not supported");
    }

    @KeepForSdk
    protected abstract boolean isPrimitiveFieldSet(String str);

    @KeepForSdk
    public String toString() {
        String str;
        String encode;
        Map<String, Field<?, ?>> fieldMappings = getFieldMappings();
        StringBuilder sb = new StringBuilder(100);
        for (String str2 : fieldMappings.keySet()) {
            Field<?, ?> field = fieldMappings.get(str2);
            if (a(field)) {
                Object a = a(field, b(field));
                sb.append(sb.length() == 0 ? "{" : ",");
                sb.append("\"");
                sb.append(str2);
                sb.append("\":");
                if (a != null) {
                    switch (field.c) {
                        case 8:
                            sb.append("\"");
                            encode = Base64Utils.encode((byte[]) a);
                            sb.append(encode);
                            str = "\"";
                            break;
                        case 9:
                            sb.append("\"");
                            encode = Base64Utils.encodeUrlSafe((byte[]) a);
                            sb.append(encode);
                            str = "\"";
                            break;
                        case 10:
                            MapUtils.writeStringMapToJson(sb, (HashMap) a);
                            break;
                        default:
                            if (field.b) {
                                ArrayList arrayList = (ArrayList) a;
                                sb.append("[");
                                int size = arrayList.size();
                                for (int i = 0; i < size; i++) {
                                    if (i > 0) {
                                        sb.append(",");
                                    }
                                    Object obj = arrayList.get(i);
                                    if (obj != null) {
                                        a(sb, field, obj);
                                    }
                                }
                                str = "]";
                                break;
                            } else {
                                a(sb, field, a);
                                break;
                            }
                    }
                } else {
                    str = "null";
                }
                sb.append(str);
            }
        }
        sb.append(sb.length() > 0 ? "}" : "{}");
        return sb.toString();
    }

    public final <O> void zaa(Field<Double, O> field, double d) {
        if (((Field) field).k != null) {
            b(field, Double.valueOf(d));
        } else {
            a(field, field.e, d);
        }
    }

    public final <O> void zaa(Field<Float, O> field, float f) {
        if (((Field) field).k != null) {
            b(field, Float.valueOf(f));
        } else {
            a((Field<?, ?>) field, field.e, f);
        }
    }

    public final <O> void zaa(Field<Integer, O> field, int i) {
        if (((Field) field).k != null) {
            b(field, Integer.valueOf(i));
        } else {
            a((Field<?, ?>) field, field.e, i);
        }
    }

    public final <O> void zaa(Field<Long, O> field, long j) {
        if (((Field) field).k != null) {
            b(field, Long.valueOf(j));
        } else {
            a((Field<?, ?>) field, field.e, j);
        }
    }

    public final <O> void zaa(Field<String, O> field, String str) {
        if (((Field) field).k != null) {
            b(field, str);
        } else {
            a(field, field.e, str);
        }
    }

    public final <O> void zaa(Field<BigDecimal, O> field, BigDecimal bigDecimal) {
        if (((Field) field).k != null) {
            b(field, bigDecimal);
        } else {
            a(field, field.e, bigDecimal);
        }
    }

    public final <O> void zaa(Field<BigInteger, O> field, BigInteger bigInteger) {
        if (((Field) field).k != null) {
            b(field, bigInteger);
        } else {
            a(field, field.e, bigInteger);
        }
    }

    public final <O> void zaa(Field<ArrayList<Integer>, O> field, ArrayList<Integer> arrayList) {
        if (((Field) field).k != null) {
            b(field, arrayList);
        } else {
            a(field, field.e, arrayList);
        }
    }

    public final <O> void zaa(Field<Map<String, String>, O> field, Map<String, String> map) {
        if (((Field) field).k != null) {
            b(field, map);
        } else {
            a(field, field.e, map);
        }
    }

    public final <O> void zaa(Field<Boolean, O> field, boolean z) {
        if (((Field) field).k != null) {
            b(field, Boolean.valueOf(z));
        } else {
            a(field, field.e, z);
        }
    }

    public final <O> void zaa(Field<byte[], O> field, byte[] bArr) {
        if (((Field) field).k != null) {
            b(field, bArr);
        } else {
            a((Field<?, ?>) field, field.e, bArr);
        }
    }

    public final <O> void zab(Field<ArrayList<BigInteger>, O> field, ArrayList<BigInteger> arrayList) {
        if (((Field) field).k != null) {
            b(field, arrayList);
        } else {
            b(field, field.e, arrayList);
        }
    }

    public final <O> void zac(Field<ArrayList<Long>, O> field, ArrayList<Long> arrayList) {
        if (((Field) field).k != null) {
            b(field, arrayList);
        } else {
            c(field, field.e, arrayList);
        }
    }

    public final <O> void zad(Field<ArrayList<Float>, O> field, ArrayList<Float> arrayList) {
        if (((Field) field).k != null) {
            b(field, arrayList);
        } else {
            d(field, field.e, arrayList);
        }
    }

    public final <O> void zae(Field<ArrayList<Double>, O> field, ArrayList<Double> arrayList) {
        if (((Field) field).k != null) {
            b(field, arrayList);
        } else {
            e(field, field.e, arrayList);
        }
    }

    public final <O> void zaf(Field<ArrayList<BigDecimal>, O> field, ArrayList<BigDecimal> arrayList) {
        if (((Field) field).k != null) {
            b(field, arrayList);
        } else {
            f(field, field.e, arrayList);
        }
    }

    public final <O> void zag(Field<ArrayList<Boolean>, O> field, ArrayList<Boolean> arrayList) {
        if (((Field) field).k != null) {
            b(field, arrayList);
        } else {
            g(field, field.e, arrayList);
        }
    }

    public final <O> void zah(Field<ArrayList<String>, O> field, ArrayList<String> arrayList) {
        if (((Field) field).k != null) {
            b(field, arrayList);
        } else {
            h(field, field.e, arrayList);
        }
    }
}
