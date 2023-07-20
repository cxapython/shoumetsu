package com.google.android.gms.internal.gtm;

import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.internal.gtm.zzrc;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import sun.misc.Unsafe;

/* loaded from: classes.dex */
final class cv<T> implements de<T> {
    private static final int[] a = new int[0];
    private static final Unsafe b = dz.c();
    private final int[] c;
    private final Object[] d;
    private final int e;
    private final int f;
    private final zzsk g;
    private final boolean h;
    private final boolean i;
    private final boolean j;
    private final boolean k;
    private final int[] l;
    private final int m;
    private final int n;
    private final cx o;
    private final cg p;
    private final dv<?, ?> q;
    private final bs<?> r;
    private final cp s;

    private cv(int[] iArr, Object[] objArr, int i, int i2, zzsk zzskVar, boolean z, boolean z2, int[] iArr2, int i3, int i4, cx cxVar, cg cgVar, dv<?, ?> dvVar, bs<?> bsVar, cp cpVar) {
        this.c = iArr;
        this.d = objArr;
        this.e = i;
        this.f = i2;
        this.i = zzskVar instanceof zzrc;
        this.j = z;
        this.h = bsVar != null && bsVar.a(zzskVar);
        this.k = false;
        this.l = iArr2;
        this.m = i3;
        this.n = i4;
        this.o = cxVar;
        this.p = cgVar;
        this.q = dvVar;
        this.r = bsVar;
        this.g = zzskVar;
        this.s = cpVar;
    }

    private static <UT, UB> int a(dv<UT, UB> dvVar, T t) {
        return dvVar.f(dvVar.b(t));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> cv<T> a(Class<T> cls, cs csVar, cx cxVar, cg cgVar, dv<?, ?> dvVar, bs<?> bsVar, cp cpVar) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        char charAt;
        int i6;
        char charAt2;
        int charAt3;
        int i7;
        int[] iArr;
        int i8;
        char c;
        char c2;
        int i9;
        char charAt4;
        int i10;
        char charAt5;
        int i11;
        char charAt6;
        int i12;
        char charAt7;
        char charAt8;
        char charAt9;
        char charAt10;
        char charAt11;
        int i13;
        int i14;
        char c3;
        char c4;
        int i15;
        int objectFieldOffset;
        String str;
        Class<?> cls2;
        int i16;
        int i17;
        int i18;
        int i19;
        Field a2;
        int i20;
        char charAt12;
        int i21;
        int i22;
        Field a3;
        Field a4;
        int i23;
        char charAt13;
        int i24;
        char charAt14;
        int i25;
        char charAt15;
        char charAt16;
        char charAt17;
        if (!(csVar instanceof dc)) {
            ((dr) csVar).a();
            int i26 = zzrc.zze.zzbba;
            throw new NoSuchMethodError();
        }
        dc dcVar = (dc) csVar;
        int i27 = 0;
        boolean z = dcVar.a() == zzrc.zze.zzbba;
        String d = dcVar.d();
        int length = d.length();
        int charAt18 = d.charAt(0);
        if (charAt18 >= 55296) {
            int i28 = charAt18 & 8191;
            int i29 = 1;
            int i30 = 13;
            while (true) {
                i = i29 + 1;
                charAt17 = d.charAt(i29);
                if (charAt17 < 55296) {
                    break;
                }
                i28 |= (charAt17 & 8191) << i30;
                i30 += 13;
                i29 = i;
            }
            charAt18 = (charAt17 << i30) | i28;
        } else {
            i = 1;
        }
        int i31 = i + 1;
        int charAt19 = d.charAt(i);
        if (charAt19 >= 55296) {
            int i32 = charAt19 & 8191;
            int i33 = 13;
            while (true) {
                i2 = i31 + 1;
                charAt16 = d.charAt(i31);
                if (charAt16 < 55296) {
                    break;
                }
                i32 |= (charAt16 & 8191) << i33;
                i33 += 13;
                i31 = i2;
            }
            charAt19 = i32 | (charAt16 << i33);
        } else {
            i2 = i31;
        }
        if (charAt19 == 0) {
            iArr = a;
            charAt3 = 0;
            c2 = 0;
            i8 = 0;
            charAt = 0;
            charAt2 = 0;
            c = 0;
        } else {
            int i34 = i2 + 1;
            char charAt20 = d.charAt(i2);
            if (charAt20 >= 55296) {
                int i35 = charAt20 & 8191;
                int i36 = 13;
                while (true) {
                    i3 = i34 + 1;
                    charAt11 = d.charAt(i34);
                    if (charAt11 < 55296) {
                        break;
                    }
                    i35 |= (charAt11 & 8191) << i36;
                    i36 += 13;
                    i34 = i3;
                }
                charAt20 = (charAt11 << i36) | i35;
            } else {
                i3 = i34;
            }
            int i37 = i3 + 1;
            int charAt21 = d.charAt(i3);
            if (charAt21 >= 55296) {
                int i38 = charAt21 & 8191;
                int i39 = 13;
                while (true) {
                    i4 = i37 + 1;
                    charAt10 = d.charAt(i37);
                    if (charAt10 < 55296) {
                        break;
                    }
                    i38 |= (charAt10 & 8191) << i39;
                    i39 += 13;
                    i37 = i4;
                }
                charAt21 = i38 | (charAt10 << i39);
            } else {
                i4 = i37;
            }
            int i40 = i4 + 1;
            char charAt22 = d.charAt(i4);
            if (charAt22 >= 55296) {
                int i41 = charAt22 & 8191;
                int i42 = 13;
                while (true) {
                    i5 = i40 + 1;
                    charAt9 = d.charAt(i40);
                    if (charAt9 < 55296) {
                        break;
                    }
                    i41 |= (charAt9 & 8191) << i42;
                    i42 += 13;
                    i40 = i5;
                }
                charAt22 = (charAt9 << i42) | i41;
            } else {
                i5 = i40;
            }
            int i43 = i5 + 1;
            charAt = d.charAt(i5);
            if (charAt >= 55296) {
                int i44 = charAt & 8191;
                int i45 = 13;
                while (true) {
                    i6 = i43 + 1;
                    charAt8 = d.charAt(i43);
                    if (charAt8 < 55296) {
                        break;
                    }
                    i44 |= (charAt8 & 8191) << i45;
                    i45 += 13;
                    i43 = i6;
                }
                charAt = (charAt8 << i45) | i44;
            } else {
                i6 = i43;
            }
            int i46 = i6 + 1;
            charAt2 = d.charAt(i6);
            if (charAt2 >= 55296) {
                int i47 = charAt2 & 8191;
                int i48 = 13;
                while (true) {
                    i12 = i46 + 1;
                    charAt7 = d.charAt(i46);
                    if (charAt7 < 55296) {
                        break;
                    }
                    i47 |= (charAt7 & 8191) << i48;
                    i48 += 13;
                    i46 = i12;
                }
                charAt2 = (charAt7 << i48) | i47;
                i46 = i12;
            }
            int i49 = i46 + 1;
            charAt3 = d.charAt(i46);
            if (charAt3 >= 55296) {
                int i50 = charAt3 & 8191;
                int i51 = 13;
                while (true) {
                    i11 = i49 + 1;
                    charAt6 = d.charAt(i49);
                    if (charAt6 < 55296) {
                        break;
                    }
                    i50 |= (charAt6 & 8191) << i51;
                    i51 += 13;
                    i49 = i11;
                }
                charAt3 = i50 | (charAt6 << i51);
                i49 = i11;
            }
            int i52 = i49 + 1;
            int charAt23 = d.charAt(i49);
            if (charAt23 >= 55296) {
                int i53 = 13;
                int i54 = charAt23 & 8191;
                int i55 = i52;
                while (true) {
                    i10 = i55 + 1;
                    charAt5 = d.charAt(i55);
                    if (charAt5 < 55296) {
                        break;
                    }
                    i54 |= (charAt5 & 8191) << i53;
                    i53 += 13;
                    i55 = i10;
                }
                charAt23 = i54 | (charAt5 << i53);
                i7 = i10;
            } else {
                i7 = i52;
            }
            int i56 = i7 + 1;
            i27 = d.charAt(i7);
            if (i27 >= 55296) {
                int i57 = 13;
                int i58 = i27 & 8191;
                int i59 = i56;
                while (true) {
                    i9 = i59 + 1;
                    charAt4 = d.charAt(i59);
                    if (charAt4 < 55296) {
                        break;
                    }
                    i58 |= (charAt4 & 8191) << i57;
                    i57 += 13;
                    i59 = i9;
                }
                i27 = i58 | (charAt4 << i57);
                i56 = i9;
            }
            iArr = new int[i27 + charAt3 + charAt23];
            i8 = (charAt20 << 1) + charAt21;
            int i60 = i56;
            c = charAt20;
            c2 = charAt22;
            i2 = i60;
        }
        Unsafe unsafe = b;
        Object[] e = dcVar.e();
        Class<?> cls3 = dcVar.c().getClass();
        int i61 = i8;
        int[] iArr2 = new int[charAt2 * 3];
        Object[] objArr = new Object[charAt2 << 1];
        int i62 = i27 + charAt3;
        int i63 = i27;
        int i64 = i62;
        int i65 = 0;
        int i66 = 0;
        while (i2 < length) {
            int i67 = i2 + 1;
            int charAt24 = d.charAt(i2);
            char c5 = 55296;
            if (charAt24 >= 55296) {
                int i68 = 13;
                int i69 = charAt24 & 8191;
                int i70 = i67;
                while (true) {
                    i25 = i70 + 1;
                    charAt15 = d.charAt(i70);
                    if (charAt15 < c5) {
                        break;
                    }
                    i69 |= (charAt15 & 8191) << i68;
                    i68 += 13;
                    i70 = i25;
                    c5 = 55296;
                }
                charAt24 = i69 | (charAt15 << i68);
                i13 = i25;
            } else {
                i13 = i67;
            }
            int i71 = i13 + 1;
            int charAt25 = d.charAt(i13);
            int i72 = length;
            char c6 = 55296;
            if (charAt25 >= 55296) {
                int i73 = 13;
                int i74 = charAt25 & 8191;
                int i75 = i71;
                while (true) {
                    i24 = i75 + 1;
                    charAt14 = d.charAt(i75);
                    if (charAt14 < c6) {
                        break;
                    }
                    i74 |= (charAt14 & 8191) << i73;
                    i73 += 13;
                    i75 = i24;
                    c6 = 55296;
                }
                charAt25 = i74 | (charAt14 << i73);
                i14 = i24;
            } else {
                i14 = i71;
            }
            int i76 = i27;
            int i77 = charAt25 & 255;
            boolean z2 = z;
            if ((charAt25 & 1024) != 0) {
                iArr[i65] = i66;
                i65++;
            }
            int i78 = i65;
            if (i77 >= 51) {
                int i79 = i14 + 1;
                int charAt26 = d.charAt(i14);
                char c7 = 55296;
                if (charAt26 >= 55296) {
                    int i80 = charAt26 & 8191;
                    int i81 = 13;
                    while (true) {
                        i23 = i79 + 1;
                        charAt13 = d.charAt(i79);
                        if (charAt13 < c7) {
                            break;
                        }
                        i80 |= (charAt13 & 8191) << i81;
                        i81 += 13;
                        i79 = i23;
                        c7 = 55296;
                    }
                    charAt26 = i80 | (charAt13 << i81);
                    i79 = i23;
                }
                int i82 = i77 - 51;
                int i83 = i79;
                if (i82 == 9 || i82 == 17) {
                    i22 = 1;
                    objArr[((i66 / 3) << 1) + 1] = e[i61];
                    i61++;
                } else {
                    if (i82 == 12 && (charAt18 & 1) == 1) {
                        objArr[((i66 / 3) << 1) + 1] = e[i61];
                        i61++;
                    }
                    i22 = 1;
                }
                int i84 = charAt26 << i22;
                Object obj = e[i84];
                if (obj instanceof Field) {
                    a3 = (Field) obj;
                } else {
                    a3 = a(cls3, (String) obj);
                    e[i84] = a3;
                }
                char c8 = c2;
                int objectFieldOffset2 = (int) unsafe.objectFieldOffset(a3);
                int i85 = i84 + 1;
                Object obj2 = e[i85];
                if (obj2 instanceof Field) {
                    a4 = (Field) obj2;
                } else {
                    a4 = a(cls3, (String) obj2);
                    e[i85] = a4;
                }
                str = d;
                i19 = (int) unsafe.objectFieldOffset(a4);
                cls2 = cls3;
                i16 = i61;
                objectFieldOffset = objectFieldOffset2;
                i18 = 0;
                c4 = c8;
                c3 = charAt;
                i15 = charAt24;
                i2 = i83;
            } else {
                char c9 = c2;
                int i86 = i61 + 1;
                Field a5 = a(cls3, (String) e[i61]);
                c3 = charAt;
                if (i77 == 9 || i77 == 17) {
                    c4 = c9;
                    objArr[((i66 / 3) << 1) + 1] = a5.getType();
                } else {
                    if (i77 == 27 || i77 == 49) {
                        c4 = c9;
                        i21 = i86 + 1;
                        objArr[((i66 / 3) << 1) + 1] = e[i86];
                    } else if (i77 == 12 || i77 == 30 || i77 == 44) {
                        c4 = c9;
                        if ((charAt18 & 1) == 1) {
                            i21 = i86 + 1;
                            objArr[((i66 / 3) << 1) + 1] = e[i86];
                        }
                    } else if (i77 == 50) {
                        int i87 = i63 + 1;
                        iArr[i63] = i66;
                        int i88 = (i66 / 3) << 1;
                        int i89 = i86 + 1;
                        objArr[i88] = e[i86];
                        if ((charAt25 & 2048) != 0) {
                            i86 = i89 + 1;
                            objArr[i88 + 1] = e[i89];
                            c4 = c9;
                            i63 = i87;
                        } else {
                            i63 = i87;
                            i86 = i89;
                            c4 = c9;
                        }
                    } else {
                        c4 = c9;
                    }
                    i15 = charAt24;
                    i86 = i21;
                    objectFieldOffset = (int) unsafe.objectFieldOffset(a5);
                    if ((charAt18 & 1) == 1 || i77 > 17) {
                        str = d;
                        cls2 = cls3;
                        i16 = i86;
                        i17 = i14;
                        i18 = 0;
                        i19 = 0;
                    } else {
                        i17 = i14 + 1;
                        int charAt27 = d.charAt(i14);
                        if (charAt27 >= 55296) {
                            int i90 = charAt27 & 8191;
                            int i91 = 13;
                            while (true) {
                                i20 = i17 + 1;
                                charAt12 = d.charAt(i17);
                                if (charAt12 < 55296) {
                                    break;
                                }
                                i90 |= (charAt12 & 8191) << i91;
                                i91 += 13;
                                i17 = i20;
                            }
                            charAt27 = i90 | (charAt12 << i91);
                            i17 = i20;
                        }
                        int i92 = (c << 1) + (charAt27 / 32);
                        Object obj3 = e[i92];
                        str = d;
                        if (obj3 instanceof Field) {
                            a2 = (Field) obj3;
                        } else {
                            a2 = a(cls3, (String) obj3);
                            e[i92] = a2;
                        }
                        cls2 = cls3;
                        i16 = i86;
                        i19 = (int) unsafe.objectFieldOffset(a2);
                        i18 = charAt27 % 32;
                    }
                    if (i77 >= 18 && i77 <= 49) {
                        iArr[i64] = objectFieldOffset;
                        i64++;
                    }
                    i2 = i17;
                }
                i15 = charAt24;
                objectFieldOffset = (int) unsafe.objectFieldOffset(a5);
                if ((charAt18 & 1) == 1) {
                }
                str = d;
                cls2 = cls3;
                i16 = i86;
                i17 = i14;
                i18 = 0;
                i19 = 0;
                if (i77 >= 18) {
                    iArr[i64] = objectFieldOffset;
                    i64++;
                }
                i2 = i17;
            }
            int i93 = i66 + 1;
            iArr2[i66] = i15;
            int i94 = i93 + 1;
            iArr2[i93] = (i77 << 20) | ((charAt25 & 256) != 0 ? DriveFile.MODE_READ_ONLY : 0) | ((charAt25 & 512) != 0 ? DriveFile.MODE_WRITE_ONLY : 0) | objectFieldOffset;
            i66 = i94 + 1;
            iArr2[i94] = (i18 << 20) | i19;
            cls3 = cls2;
            charAt = c3;
            i27 = i76;
            i61 = i16;
            length = i72;
            z = z2;
            c2 = c4;
            i65 = i78;
            d = str;
        }
        return new cv<>(iArr2, objArr, c2, charAt, dcVar.c(), z, false, iArr, i27, i62, cxVar, cgVar, dvVar, bsVar, cpVar);
    }

    private final de a(int i) {
        int i2 = (i / 3) << 1;
        de deVar = (de) this.d[i2];
        if (deVar != null) {
            return deVar;
        }
        de<T> a2 = db.a().a((Class) ((Class) this.d[i2 + 1]));
        this.d[i2] = a2;
        return a2;
    }

    private final <K, V, UT, UB> UB a(int i, int i2, Map<K, V> map, zzrh zzrhVar, UB ub, dv<UT, UB> dvVar) {
        co<?, ?> f = this.s.f(b(i));
        Iterator<Map.Entry<K, V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<K, V> next = it.next();
            if (!zzrhVar.zzb(((Integer) next.getValue()).intValue())) {
                if (ub == null) {
                    ub = dvVar.a();
                }
                bg b2 = zzps.b(zzsc.a(f, next.getKey(), next.getValue()));
                try {
                    zzsc.a(b2.b(), f, next.getKey(), next.getValue());
                    dvVar.a((dv<UT, UB>) ub, i2, b2.a());
                    it.remove();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return ub;
    }

    private final <UT, UB> UB a(Object obj, int i, UB ub, dv<UT, UB> dvVar) {
        zzrh c;
        int i2 = this.c[i];
        Object f = dz.f(obj, d(i) & 1048575);
        return (f == null || (c = c(i)) == null) ? ub : (UB) a(i, i2, this.s.a(f), c, ub, dvVar);
    }

    private static Field a(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            String name = cls.getName();
            String arrays = Arrays.toString(declaredFields);
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 40 + String.valueOf(name).length() + String.valueOf(arrays).length());
            sb.append("Field ");
            sb.append(str);
            sb.append(" for ");
            sb.append(name);
            sb.append(" not found. Known fields are ");
            sb.append(arrays);
            throw new RuntimeException(sb.toString());
        }
    }

    private static <E> List<E> a(Object obj, long j) {
        return (List) dz.f(obj, j);
    }

    private static void a(int i, Object obj, em emVar) {
        if (obj instanceof String) {
            emVar.a(i, (String) obj);
        } else {
            emVar.a(i, (zzps) obj);
        }
    }

    private static <UT, UB> void a(dv<UT, UB> dvVar, T t, em emVar) {
        dvVar.a((dv<UT, UB>) dvVar.b(t), emVar);
    }

    private final <K, V> void a(em emVar, int i, Object obj, int i2) {
        if (obj != null) {
            emVar.a(i, this.s.f(b(i2)), this.s.b(obj));
        }
    }

    private final void a(Object obj, int i, dd ddVar) {
        long j;
        Object n;
        if (f(i)) {
            j = i & 1048575;
            n = ddVar.m();
        } else if (this.i) {
            j = i & 1048575;
            n = ddVar.l();
        } else {
            j = i & 1048575;
            n = ddVar.n();
        }
        dz.a(obj, j, n);
    }

    private final void a(T t, T t2, int i) {
        long d = d(i) & 1048575;
        if (!a((cv<T>) t2, i)) {
            return;
        }
        Object f = dz.f(t, d);
        Object f2 = dz.f(t2, d);
        if (f != null && f2 != null) {
            dz.a(t, d, zzre.a(f, f2));
            b((cv<T>) t, i);
        } else if (f2 == null) {
        } else {
            dz.a(t, d, f2);
            b((cv<T>) t, i);
        }
    }

    private final boolean a(T t, int i) {
        if (!this.j) {
            int e = e(i);
            return (dz.a(t, (long) (e & 1048575)) & (1 << (e >>> 20))) != 0;
        }
        int d = d(i);
        long j = d & 1048575;
        switch ((d & 267386880) >>> 20) {
            case 0:
                return dz.e(t, j) != 0.0d;
            case 1:
                return dz.d(t, j) != 0.0f;
            case 2:
                return dz.b(t, j) != 0;
            case 3:
                return dz.b(t, j) != 0;
            case 4:
                return dz.a(t, j) != 0;
            case 5:
                return dz.b(t, j) != 0;
            case 6:
                return dz.a(t, j) != 0;
            case 7:
                return dz.c(t, j);
            case 8:
                Object f = dz.f(t, j);
                if (f instanceof String) {
                    return !((String) f).isEmpty();
                } else if (!(f instanceof zzps)) {
                    throw new IllegalArgumentException();
                } else {
                    return !zzps.zzavx.equals(f);
                }
            case 9:
                return dz.f(t, j) != null;
            case 10:
                return !zzps.zzavx.equals(dz.f(t, j));
            case 11:
                return dz.a(t, j) != 0;
            case 12:
                return dz.a(t, j) != 0;
            case 13:
                return dz.a(t, j) != 0;
            case 14:
                return dz.b(t, j) != 0;
            case 15:
                return dz.a(t, j) != 0;
            case 16:
                return dz.b(t, j) != 0;
            case 17:
                return dz.f(t, j) != null;
            default:
                throw new IllegalArgumentException();
        }
    }

    private final boolean a(T t, int i, int i2) {
        return dz.a(t, (long) (e(i2) & 1048575)) == i;
    }

    private final boolean a(T t, int i, int i2, int i3) {
        return this.j ? a((cv<T>) t, i) : (i2 & i3) != 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static boolean a(Object obj, int i, de deVar) {
        return deVar.d(dz.f(obj, i & 1048575));
    }

    private static <T> double b(T t, long j) {
        return ((Double) dz.f(t, j)).doubleValue();
    }

    private final Object b(int i) {
        return this.d[(i / 3) << 1];
    }

    private final void b(T t, int i) {
        if (this.j) {
            return;
        }
        int e = e(i);
        long j = e & 1048575;
        dz.a((Object) t, j, dz.a(t, j) | (1 << (e >>> 20)));
    }

    private final void b(T t, int i, int i2) {
        dz.a((Object) t, e(i2) & 1048575, i);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x0485  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void b(T t, em emVar) {
        Iterator<Map.Entry<?, Object>> it;
        Map.Entry<?, Object> entry;
        int length;
        int i;
        Map.Entry<?, Object> entry2;
        int i2;
        boolean z;
        int i3;
        boolean z2;
        int i4;
        boolean z3;
        int i5;
        boolean z4;
        int i6;
        boolean z5;
        int i7;
        int i8;
        List list;
        boolean z6;
        Map.Entry<?, ?> entry3;
        if (this.h) {
            bv<?> a2 = this.r.a(t);
            if (!a2.a.isEmpty()) {
                it = a2.d();
                entry = it.next();
                int i9 = -1;
                length = this.c.length;
                Unsafe unsafe = b;
                Map.Entry<?, ?> entry4 = entry;
                int i10 = 0;
                for (i = 0; i < length; i += 3) {
                    int d = d(i);
                    int[] iArr = this.c;
                    int i11 = iArr[i];
                    int i12 = (267386880 & d) >>> 20;
                    if (this.j || i12 > 17) {
                        entry4 = entry4;
                        i2 = 0;
                    } else {
                        int i13 = iArr[i + 2];
                        int i14 = i13 & 1048575;
                        if (i14 != i9) {
                            entry3 = entry4;
                            i10 = unsafe.getInt(t, i14);
                        } else {
                            entry3 = entry4;
                            i14 = i9;
                        }
                        i2 = 1 << (i13 >>> 20);
                        i9 = i14;
                        entry4 = entry3;
                    }
                    while (entry4 != null && this.r.a(entry4) <= i11) {
                        this.r.a(emVar, entry4);
                        entry4 = it.hasNext() ? it.next() : null;
                    }
                    long j = d & 1048575;
                    switch (i12) {
                        case 0:
                            if ((i10 & i2) != 0) {
                                emVar.a(i11, dz.e(t, j));
                                continue;
                            }
                        case 1:
                            if ((i10 & i2) != 0) {
                                emVar.a(i11, dz.d(t, j));
                            } else {
                                continue;
                            }
                        case 2:
                            if ((i10 & i2) != 0) {
                                emVar.a(i11, unsafe.getLong(t, j));
                            } else {
                                continue;
                            }
                        case 3:
                            if ((i10 & i2) != 0) {
                                emVar.c(i11, unsafe.getLong(t, j));
                            } else {
                                continue;
                            }
                        case 4:
                            if ((i10 & i2) != 0) {
                                emVar.c(i11, unsafe.getInt(t, j));
                            } else {
                                continue;
                            }
                        case 5:
                            if ((i10 & i2) != 0) {
                                emVar.d(i11, unsafe.getLong(t, j));
                            } else {
                                continue;
                            }
                        case 6:
                            if ((i10 & i2) != 0) {
                                emVar.d(i11, unsafe.getInt(t, j));
                            } else {
                                continue;
                            }
                        case 7:
                            if ((i10 & i2) != 0) {
                                emVar.a(i11, dz.c(t, j));
                            } else {
                                continue;
                            }
                        case 8:
                            if ((i10 & i2) != 0) {
                                a(i11, unsafe.getObject(t, j), emVar);
                            } else {
                                continue;
                            }
                        case 9:
                            if ((i10 & i2) != 0) {
                                emVar.a(i11, unsafe.getObject(t, j), a(i));
                            } else {
                                continue;
                            }
                        case 10:
                            if ((i10 & i2) != 0) {
                                emVar.a(i11, (zzps) unsafe.getObject(t, j));
                            } else {
                                continue;
                            }
                        case 11:
                            if ((i10 & i2) != 0) {
                                emVar.e(i11, unsafe.getInt(t, j));
                            } else {
                                continue;
                            }
                        case 12:
                            if ((i10 & i2) != 0) {
                                emVar.b(i11, unsafe.getInt(t, j));
                            } else {
                                continue;
                            }
                        case 13:
                            if ((i10 & i2) != 0) {
                                emVar.a(i11, unsafe.getInt(t, j));
                            } else {
                                continue;
                            }
                        case 14:
                            if ((i10 & i2) != 0) {
                                emVar.b(i11, unsafe.getLong(t, j));
                            } else {
                                continue;
                            }
                        case 15:
                            if ((i10 & i2) != 0) {
                                emVar.f(i11, unsafe.getInt(t, j));
                            } else {
                                continue;
                            }
                        case 16:
                            if ((i10 & i2) != 0) {
                                emVar.e(i11, unsafe.getLong(t, j));
                            } else {
                                continue;
                            }
                        case 17:
                            if ((i10 & i2) != 0) {
                                emVar.b(i11, unsafe.getObject(t, j), a(i));
                            } else {
                                continue;
                            }
                        case 18:
                            dg.a(this.c[i], (List<Double>) unsafe.getObject(t, j), emVar, false);
                            continue;
                        case 19:
                            dg.b(this.c[i], (List<Float>) unsafe.getObject(t, j), emVar, false);
                            continue;
                        case 20:
                            dg.c(this.c[i], (List) unsafe.getObject(t, j), emVar, false);
                            continue;
                        case 21:
                            dg.d(this.c[i], (List) unsafe.getObject(t, j), emVar, false);
                            continue;
                        case 22:
                            dg.h(this.c[i], (List) unsafe.getObject(t, j), emVar, false);
                            continue;
                        case 23:
                            dg.f(this.c[i], (List) unsafe.getObject(t, j), emVar, false);
                            continue;
                        case 24:
                            dg.k(this.c[i], (List) unsafe.getObject(t, j), emVar, false);
                            continue;
                        case 25:
                            dg.n(this.c[i], (List) unsafe.getObject(t, j), emVar, false);
                            continue;
                        case 26:
                            dg.a(this.c[i], (List) unsafe.getObject(t, j), emVar);
                            break;
                        case 27:
                            dg.a(this.c[i], (List) unsafe.getObject(t, j), emVar, a(i));
                            break;
                        case 28:
                            dg.b(this.c[i], (List) unsafe.getObject(t, j), emVar);
                            break;
                        case 29:
                            z = false;
                            i3 = this.c[i];
                            dg.i(i3, (List) unsafe.getObject(t, j), emVar, z);
                            break;
                        case 30:
                            z2 = false;
                            i4 = this.c[i];
                            dg.m(i4, (List) unsafe.getObject(t, j), emVar, z2);
                            break;
                        case 31:
                            z3 = false;
                            i5 = this.c[i];
                            dg.l(i5, (List) unsafe.getObject(t, j), emVar, z3);
                            break;
                        case 32:
                            z4 = false;
                            i6 = this.c[i];
                            dg.g(i6, (List) unsafe.getObject(t, j), emVar, z4);
                            break;
                        case 33:
                            z5 = false;
                            i7 = this.c[i];
                            dg.j(i7, (List) unsafe.getObject(t, j), emVar, z5);
                            break;
                        case 34:
                            i8 = this.c[i];
                            list = (List) unsafe.getObject(t, j);
                            z6 = false;
                            dg.e(i8, list, emVar, z6);
                            break;
                        case 35:
                            dg.a(this.c[i], (List<Double>) unsafe.getObject(t, j), emVar, true);
                            break;
                        case 36:
                            dg.b(this.c[i], (List<Float>) unsafe.getObject(t, j), emVar, true);
                            break;
                        case 37:
                            dg.c(this.c[i], (List) unsafe.getObject(t, j), emVar, true);
                            break;
                        case 38:
                            dg.d(this.c[i], (List) unsafe.getObject(t, j), emVar, true);
                            break;
                        case 39:
                            dg.h(this.c[i], (List) unsafe.getObject(t, j), emVar, true);
                            break;
                        case 40:
                            dg.f(this.c[i], (List) unsafe.getObject(t, j), emVar, true);
                            break;
                        case 41:
                            dg.k(this.c[i], (List) unsafe.getObject(t, j), emVar, true);
                            break;
                        case 42:
                            dg.n(this.c[i], (List) unsafe.getObject(t, j), emVar, true);
                            break;
                        case 43:
                            z = true;
                            i3 = this.c[i];
                            dg.i(i3, (List) unsafe.getObject(t, j), emVar, z);
                            break;
                        case 44:
                            z2 = true;
                            i4 = this.c[i];
                            dg.m(i4, (List) unsafe.getObject(t, j), emVar, z2);
                            break;
                        case 45:
                            z3 = true;
                            i5 = this.c[i];
                            dg.l(i5, (List) unsafe.getObject(t, j), emVar, z3);
                            break;
                        case 46:
                            z4 = true;
                            i6 = this.c[i];
                            dg.g(i6, (List) unsafe.getObject(t, j), emVar, z4);
                            break;
                        case 47:
                            z5 = true;
                            i7 = this.c[i];
                            dg.j(i7, (List) unsafe.getObject(t, j), emVar, z5);
                            break;
                        case 48:
                            i8 = this.c[i];
                            list = (List) unsafe.getObject(t, j);
                            z6 = true;
                            dg.e(i8, list, emVar, z6);
                            break;
                        case 49:
                            dg.b(this.c[i], (List) unsafe.getObject(t, j), emVar, a(i));
                            break;
                        case 50:
                            a(emVar, i11, unsafe.getObject(t, j), i);
                            break;
                        case 51:
                            if (a((cv<T>) t, i11, i)) {
                                emVar.a(i11, b(t, j));
                                break;
                            }
                            break;
                        case 52:
                            if (a((cv<T>) t, i11, i)) {
                                emVar.a(i11, c(t, j));
                                break;
                            }
                            break;
                        case 53:
                            if (a((cv<T>) t, i11, i)) {
                                emVar.a(i11, e(t, j));
                                break;
                            }
                            break;
                        case 54:
                            if (a((cv<T>) t, i11, i)) {
                                emVar.c(i11, e(t, j));
                                break;
                            }
                            break;
                        case 55:
                            if (a((cv<T>) t, i11, i)) {
                                emVar.c(i11, d(t, j));
                                break;
                            }
                            break;
                        case 56:
                            if (a((cv<T>) t, i11, i)) {
                                emVar.d(i11, e(t, j));
                                break;
                            }
                            break;
                        case 57:
                            if (a((cv<T>) t, i11, i)) {
                                emVar.d(i11, d(t, j));
                                break;
                            }
                            break;
                        case 58:
                            if (a((cv<T>) t, i11, i)) {
                                emVar.a(i11, f(t, j));
                                break;
                            }
                            break;
                        case 59:
                            if (a((cv<T>) t, i11, i)) {
                                a(i11, unsafe.getObject(t, j), emVar);
                                break;
                            }
                            break;
                        case 60:
                            if (a((cv<T>) t, i11, i)) {
                                emVar.a(i11, unsafe.getObject(t, j), a(i));
                                break;
                            }
                            break;
                        case 61:
                            if (a((cv<T>) t, i11, i)) {
                                emVar.a(i11, (zzps) unsafe.getObject(t, j));
                                break;
                            }
                            break;
                        case 62:
                            if (a((cv<T>) t, i11, i)) {
                                emVar.e(i11, d(t, j));
                                break;
                            }
                            break;
                        case 63:
                            if (a((cv<T>) t, i11, i)) {
                                emVar.b(i11, d(t, j));
                                break;
                            }
                            break;
                        case 64:
                            if (a((cv<T>) t, i11, i)) {
                                emVar.a(i11, d(t, j));
                                break;
                            }
                            break;
                        case 65:
                            if (a((cv<T>) t, i11, i)) {
                                emVar.b(i11, e(t, j));
                                break;
                            }
                            break;
                        case 66:
                            if (a((cv<T>) t, i11, i)) {
                                emVar.f(i11, d(t, j));
                                break;
                            }
                            break;
                        case 67:
                            if (a((cv<T>) t, i11, i)) {
                                emVar.e(i11, e(t, j));
                                break;
                            }
                            break;
                        case 68:
                            if (a((cv<T>) t, i11, i)) {
                                emVar.b(i11, unsafe.getObject(t, j), a(i));
                                break;
                            }
                            break;
                    }
                }
                entry2 = entry4;
                while (entry2 != null) {
                    this.r.a(emVar, entry2);
                    entry2 = it.hasNext() ? it.next() : null;
                }
                a(this.q, t, emVar);
            }
        }
        it = null;
        entry = null;
        int i92 = -1;
        length = this.c.length;
        Unsafe unsafe2 = b;
        Map.Entry<?, ?> entry42 = entry;
        int i102 = 0;
        while (i < length) {
        }
        entry2 = entry42;
        while (entry2 != null) {
        }
        a(this.q, t, emVar);
    }

    private final void b(T t, T t2, int i) {
        int d = d(i);
        int i2 = this.c[i];
        long j = d & 1048575;
        if (!a((cv<T>) t2, i2, i)) {
            return;
        }
        Object f = dz.f(t, j);
        Object f2 = dz.f(t2, j);
        if (f != null && f2 != null) {
            dz.a(t, j, zzre.a(f, f2));
            b((cv<T>) t, i2, i);
        } else if (f2 == null) {
        } else {
            dz.a(t, j, f2);
            b((cv<T>) t, i2, i);
        }
    }

    private static <T> float c(T t, long j) {
        return ((Float) dz.f(t, j)).floatValue();
    }

    private final zzrh c(int i) {
        return (zzrh) this.d[((i / 3) << 1) + 1];
    }

    private final boolean c(T t, T t2, int i) {
        return a((cv<T>) t, i) == a((cv<T>) t2, i);
    }

    private final int d(int i) {
        return this.c[i + 1];
    }

    private static <T> int d(T t, long j) {
        return ((Integer) dz.f(t, j)).intValue();
    }

    private final int e(int i) {
        return this.c[i + 2];
    }

    private static <T> long e(T t, long j) {
        return ((Long) dz.f(t, j)).longValue();
    }

    private static boolean f(int i) {
        return (i & DriveFile.MODE_WRITE_ONLY) != 0;
    }

    private static <T> boolean f(T t, long j) {
        return ((Boolean) dz.f(t, j)).booleanValue();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00ce, code lost:
        if (r3 != null) goto L77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x00e0, code lost:
        if (r3 != null) goto L77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x00e2, code lost:
        r7 = r3.hashCode();
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x00e6, code lost:
        r2 = (r2 * 53) + r7;
     */
    @Override // com.google.android.gms.internal.gtm.de
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int a(T t) {
        int i;
        double e;
        float d;
        long b2;
        int a2;
        boolean c;
        Object f;
        Object f2;
        int length = this.c.length;
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3 += 3) {
            int d2 = d(i3);
            int i4 = this.c[i3];
            long j = 1048575 & d2;
            int i5 = 37;
            switch ((d2 & 267386880) >>> 20) {
                case 0:
                    i = i2 * 53;
                    e = dz.e(t, j);
                    b2 = Double.doubleToLongBits(e);
                    a2 = zzre.zzz(b2);
                    i2 = i + a2;
                    break;
                case 1:
                    i = i2 * 53;
                    d = dz.d(t, j);
                    a2 = Float.floatToIntBits(d);
                    i2 = i + a2;
                    break;
                case 2:
                case 3:
                case 5:
                case 14:
                case 16:
                    i = i2 * 53;
                    b2 = dz.b(t, j);
                    a2 = zzre.zzz(b2);
                    i2 = i + a2;
                    break;
                case 4:
                case 6:
                case 11:
                case 12:
                case 13:
                case 15:
                    i = i2 * 53;
                    a2 = dz.a(t, j);
                    i2 = i + a2;
                    break;
                case 7:
                    i = i2 * 53;
                    c = dz.c(t, j);
                    a2 = zzre.zzk(c);
                    i2 = i + a2;
                    break;
                case 8:
                    i = i2 * 53;
                    a2 = ((String) dz.f(t, j)).hashCode();
                    i2 = i + a2;
                    break;
                case 9:
                    f = dz.f(t, j);
                    break;
                case 10:
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                case 50:
                    i = i2 * 53;
                    f2 = dz.f(t, j);
                    a2 = f2.hashCode();
                    i2 = i + a2;
                    break;
                case 17:
                    f = dz.f(t, j);
                    break;
                case 51:
                    if (a((cv<T>) t, i4, i3)) {
                        i = i2 * 53;
                        e = b(t, j);
                        b2 = Double.doubleToLongBits(e);
                        a2 = zzre.zzz(b2);
                        i2 = i + a2;
                        break;
                    } else {
                        break;
                    }
                case 52:
                    if (a((cv<T>) t, i4, i3)) {
                        i = i2 * 53;
                        d = c(t, j);
                        a2 = Float.floatToIntBits(d);
                        i2 = i + a2;
                        break;
                    } else {
                        break;
                    }
                case 53:
                    if (!a((cv<T>) t, i4, i3)) {
                        break;
                    }
                    i = i2 * 53;
                    b2 = e(t, j);
                    a2 = zzre.zzz(b2);
                    i2 = i + a2;
                    break;
                case 54:
                    if (!a((cv<T>) t, i4, i3)) {
                        break;
                    }
                    i = i2 * 53;
                    b2 = e(t, j);
                    a2 = zzre.zzz(b2);
                    i2 = i + a2;
                    break;
                case 55:
                    if (!a((cv<T>) t, i4, i3)) {
                        break;
                    }
                    i = i2 * 53;
                    a2 = d(t, j);
                    i2 = i + a2;
                    break;
                case 56:
                    if (!a((cv<T>) t, i4, i3)) {
                        break;
                    }
                    i = i2 * 53;
                    b2 = e(t, j);
                    a2 = zzre.zzz(b2);
                    i2 = i + a2;
                    break;
                case 57:
                    if (!a((cv<T>) t, i4, i3)) {
                        break;
                    }
                    i = i2 * 53;
                    a2 = d(t, j);
                    i2 = i + a2;
                    break;
                case 58:
                    if (a((cv<T>) t, i4, i3)) {
                        i = i2 * 53;
                        c = f(t, j);
                        a2 = zzre.zzk(c);
                        i2 = i + a2;
                        break;
                    } else {
                        break;
                    }
                case 59:
                    if (!a((cv<T>) t, i4, i3)) {
                        break;
                    }
                    i = i2 * 53;
                    a2 = ((String) dz.f(t, j)).hashCode();
                    i2 = i + a2;
                    break;
                case 60:
                    if (!a((cv<T>) t, i4, i3)) {
                        break;
                    }
                    f2 = dz.f(t, j);
                    i = i2 * 53;
                    a2 = f2.hashCode();
                    i2 = i + a2;
                    break;
                case 61:
                    if (!a((cv<T>) t, i4, i3)) {
                        break;
                    }
                    i = i2 * 53;
                    f2 = dz.f(t, j);
                    a2 = f2.hashCode();
                    i2 = i + a2;
                    break;
                case 62:
                    if (!a((cv<T>) t, i4, i3)) {
                        break;
                    }
                    i = i2 * 53;
                    a2 = d(t, j);
                    i2 = i + a2;
                    break;
                case 63:
                    if (!a((cv<T>) t, i4, i3)) {
                        break;
                    }
                    i = i2 * 53;
                    a2 = d(t, j);
                    i2 = i + a2;
                    break;
                case 64:
                    if (!a((cv<T>) t, i4, i3)) {
                        break;
                    }
                    i = i2 * 53;
                    a2 = d(t, j);
                    i2 = i + a2;
                    break;
                case 65:
                    if (!a((cv<T>) t, i4, i3)) {
                        break;
                    }
                    i = i2 * 53;
                    b2 = e(t, j);
                    a2 = zzre.zzz(b2);
                    i2 = i + a2;
                    break;
                case 66:
                    if (!a((cv<T>) t, i4, i3)) {
                        break;
                    }
                    i = i2 * 53;
                    a2 = d(t, j);
                    i2 = i + a2;
                    break;
                case 67:
                    if (!a((cv<T>) t, i4, i3)) {
                        break;
                    }
                    i = i2 * 53;
                    b2 = e(t, j);
                    a2 = zzre.zzz(b2);
                    i2 = i + a2;
                    break;
                case 68:
                    if (!a((cv<T>) t, i4, i3)) {
                        break;
                    }
                    f2 = dz.f(t, j);
                    i = i2 * 53;
                    a2 = f2.hashCode();
                    i2 = i + a2;
                    break;
            }
        }
        int hashCode = (i2 * 53) + this.q.b(t).hashCode();
        return this.h ? (hashCode * 53) + this.r.a(t).hashCode() : hashCode;
    }

    @Override // com.google.android.gms.internal.gtm.de
    public final T a() {
        return (T) this.o.a(this.g);
    }

    @Override // com.google.android.gms.internal.gtm.de
    public final void a(T t, dd ddVar, zzqp zzqpVar) {
        long j;
        Object a2;
        int p;
        List<Double> a3;
        List<Float> a4;
        List<Long> a5;
        List<Long> a6;
        List<Integer> a7;
        List<Long> a8;
        List<Integer> a9;
        List<Boolean> a10;
        List<Integer> a11;
        List<Integer> a12;
        zzrh c;
        List<Integer> a13;
        List<Long> a14;
        List<Integer> a15;
        List<Long> a16;
        if (zzqpVar != null) {
            dv dvVar = this.q;
            bs<?> bsVar = this.r;
            bv<?> bvVar = null;
            Object obj = null;
            while (true) {
                try {
                    int a17 = ddVar.a();
                    int i = -1;
                    if (a17 >= this.e && a17 <= this.f) {
                        int i2 = 0;
                        int length = (this.c.length / 3) - 1;
                        while (true) {
                            if (i2 <= length) {
                                int i3 = (length + i2) >>> 1;
                                int i4 = i3 * 3;
                                int i5 = this.c[i4];
                                if (a17 == i5) {
                                    i = i4;
                                } else if (a17 < i5) {
                                    length = i3 - 1;
                                } else {
                                    i2 = i3 + 1;
                                }
                            }
                        }
                    }
                    if (i >= 0) {
                        int d = d(i);
                        switch ((267386880 & d) >>> 20) {
                            case 0:
                                dz.a(t, d & 1048575, ddVar.d());
                                b((cv<T>) t, i);
                                break;
                            case 1:
                                dz.a((Object) t, d & 1048575, ddVar.e());
                                b((cv<T>) t, i);
                                break;
                            case 2:
                                dz.a((Object) t, d & 1048575, ddVar.g());
                                b((cv<T>) t, i);
                                break;
                            case 3:
                                dz.a((Object) t, d & 1048575, ddVar.f());
                                b((cv<T>) t, i);
                                break;
                            case 4:
                                dz.a((Object) t, d & 1048575, ddVar.h());
                                b((cv<T>) t, i);
                                break;
                            case 5:
                                dz.a((Object) t, d & 1048575, ddVar.i());
                                b((cv<T>) t, i);
                                break;
                            case 6:
                                dz.a((Object) t, d & 1048575, ddVar.j());
                                b((cv<T>) t, i);
                                break;
                            case 7:
                                dz.a(t, d & 1048575, ddVar.k());
                                b((cv<T>) t, i);
                                break;
                            case 8:
                                a(t, d, ddVar);
                                b((cv<T>) t, i);
                                break;
                            case 9:
                                if (a((cv<T>) t, i)) {
                                    j = d & 1048575;
                                    a2 = zzre.a(dz.f(t, j), ddVar.a(a(i), zzqpVar));
                                    dz.a(t, j, a2);
                                    break;
                                } else {
                                    dz.a(t, d & 1048575, ddVar.a(a(i), zzqpVar));
                                    b((cv<T>) t, i);
                                    break;
                                }
                            case 10:
                                dz.a(t, d & 1048575, ddVar.n());
                                b((cv<T>) t, i);
                                break;
                            case 11:
                                dz.a((Object) t, d & 1048575, ddVar.o());
                                b((cv<T>) t, i);
                                break;
                            case 12:
                                p = ddVar.p();
                                zzrh c2 = c(i);
                                if (c2 != null && !c2.zzb(p)) {
                                    obj = dg.a(a17, p, obj, dvVar);
                                    break;
                                } else {
                                    dz.a((Object) t, d & 1048575, p);
                                    b((cv<T>) t, i);
                                    break;
                                }
                            case 13:
                                dz.a((Object) t, d & 1048575, ddVar.q());
                                b((cv<T>) t, i);
                                break;
                            case 14:
                                dz.a((Object) t, d & 1048575, ddVar.r());
                                b((cv<T>) t, i);
                                break;
                            case 15:
                                dz.a((Object) t, d & 1048575, ddVar.s());
                                b((cv<T>) t, i);
                                break;
                            case 16:
                                dz.a((Object) t, d & 1048575, ddVar.t());
                                b((cv<T>) t, i);
                                break;
                            case 17:
                                if (a((cv<T>) t, i)) {
                                    j = d & 1048575;
                                    a2 = zzre.a(dz.f(t, j), ddVar.b(a(i), zzqpVar));
                                    dz.a(t, j, a2);
                                    break;
                                } else {
                                    dz.a(t, d & 1048575, ddVar.b(a(i), zzqpVar));
                                    b((cv<T>) t, i);
                                    break;
                                }
                            case 18:
                                a3 = this.p.a(t, d & 1048575);
                                ddVar.a(a3);
                                break;
                            case 19:
                                a4 = this.p.a(t, d & 1048575);
                                ddVar.b(a4);
                                break;
                            case 20:
                                a5 = this.p.a(t, d & 1048575);
                                ddVar.d(a5);
                                break;
                            case 21:
                                a6 = this.p.a(t, d & 1048575);
                                ddVar.c(a6);
                                break;
                            case 22:
                                a7 = this.p.a(t, d & 1048575);
                                ddVar.e(a7);
                                break;
                            case 23:
                                a8 = this.p.a(t, d & 1048575);
                                ddVar.f(a8);
                                break;
                            case 24:
                                a9 = this.p.a(t, d & 1048575);
                                ddVar.g(a9);
                                break;
                            case 25:
                                a10 = this.p.a(t, d & 1048575);
                                ddVar.h(a10);
                                break;
                            case 26:
                                if (f(d)) {
                                    ddVar.j(this.p.a(t, d & 1048575));
                                    break;
                                } else {
                                    ddVar.i(this.p.a(t, d & 1048575));
                                    break;
                                }
                            case 27:
                                ddVar.a(this.p.a(t, d & 1048575), a(i), zzqpVar);
                                break;
                            case 28:
                                ddVar.k(this.p.a(t, d & 1048575));
                                break;
                            case 29:
                                a11 = this.p.a(t, d & 1048575);
                                ddVar.l(a11);
                                break;
                            case 30:
                                a12 = this.p.a(t, d & 1048575);
                                ddVar.m(a12);
                                c = c(i);
                                obj = dg.a(a17, a12, c, obj, dvVar);
                                break;
                            case 31:
                                a13 = this.p.a(t, d & 1048575);
                                ddVar.n(a13);
                                break;
                            case 32:
                                a14 = this.p.a(t, d & 1048575);
                                ddVar.o(a14);
                                break;
                            case 33:
                                a15 = this.p.a(t, d & 1048575);
                                ddVar.p(a15);
                                break;
                            case 34:
                                a16 = this.p.a(t, d & 1048575);
                                ddVar.q(a16);
                                break;
                            case 35:
                                a3 = this.p.a(t, d & 1048575);
                                ddVar.a(a3);
                                break;
                            case 36:
                                a4 = this.p.a(t, d & 1048575);
                                ddVar.b(a4);
                                break;
                            case 37:
                                a5 = this.p.a(t, d & 1048575);
                                ddVar.d(a5);
                                break;
                            case 38:
                                a6 = this.p.a(t, d & 1048575);
                                ddVar.c(a6);
                                break;
                            case 39:
                                a7 = this.p.a(t, d & 1048575);
                                ddVar.e(a7);
                                break;
                            case 40:
                                a8 = this.p.a(t, d & 1048575);
                                ddVar.f(a8);
                                break;
                            case 41:
                                a9 = this.p.a(t, d & 1048575);
                                ddVar.g(a9);
                                break;
                            case 42:
                                a10 = this.p.a(t, d & 1048575);
                                ddVar.h(a10);
                                break;
                            case 43:
                                a11 = this.p.a(t, d & 1048575);
                                ddVar.l(a11);
                                break;
                            case 44:
                                a12 = this.p.a(t, d & 1048575);
                                ddVar.m(a12);
                                c = c(i);
                                obj = dg.a(a17, a12, c, obj, dvVar);
                                break;
                            case 45:
                                a13 = this.p.a(t, d & 1048575);
                                ddVar.n(a13);
                                break;
                            case 46:
                                a14 = this.p.a(t, d & 1048575);
                                ddVar.o(a14);
                                break;
                            case 47:
                                a15 = this.p.a(t, d & 1048575);
                                ddVar.p(a15);
                                break;
                            case 48:
                                a16 = this.p.a(t, d & 1048575);
                                ddVar.q(a16);
                                break;
                            case 49:
                                ddVar.b(this.p.a(t, d & 1048575), a(i), zzqpVar);
                                break;
                            case 50:
                                Object b2 = b(i);
                                long d2 = d(i) & 1048575;
                                Object f = dz.f(t, d2);
                                if (f == null) {
                                    f = this.s.e(b2);
                                    dz.a(t, d2, f);
                                } else if (this.s.c(f)) {
                                    Object e = this.s.e(b2);
                                    this.s.a(e, f);
                                    dz.a(t, d2, e);
                                    f = e;
                                }
                                ddVar.a(this.s.a(f), this.s.f(b2), zzqpVar);
                                break;
                            case 51:
                                dz.a(t, d & 1048575, Double.valueOf(ddVar.d()));
                                b((cv<T>) t, a17, i);
                                break;
                            case 52:
                                dz.a(t, d & 1048575, Float.valueOf(ddVar.e()));
                                b((cv<T>) t, a17, i);
                                break;
                            case 53:
                                dz.a(t, d & 1048575, Long.valueOf(ddVar.g()));
                                b((cv<T>) t, a17, i);
                                break;
                            case 54:
                                dz.a(t, d & 1048575, Long.valueOf(ddVar.f()));
                                b((cv<T>) t, a17, i);
                                break;
                            case 55:
                                dz.a(t, d & 1048575, Integer.valueOf(ddVar.h()));
                                b((cv<T>) t, a17, i);
                                break;
                            case 56:
                                dz.a(t, d & 1048575, Long.valueOf(ddVar.i()));
                                b((cv<T>) t, a17, i);
                                break;
                            case 57:
                                dz.a(t, d & 1048575, Integer.valueOf(ddVar.j()));
                                b((cv<T>) t, a17, i);
                                break;
                            case 58:
                                dz.a(t, d & 1048575, Boolean.valueOf(ddVar.k()));
                                b((cv<T>) t, a17, i);
                                break;
                            case 59:
                                a(t, d, ddVar);
                                b((cv<T>) t, a17, i);
                                break;
                            case 60:
                                if (a((cv<T>) t, a17, i)) {
                                    long j2 = d & 1048575;
                                    dz.a(t, j2, zzre.a(dz.f(t, j2), ddVar.a(a(i), zzqpVar)));
                                } else {
                                    dz.a(t, d & 1048575, ddVar.a(a(i), zzqpVar));
                                    b((cv<T>) t, i);
                                }
                                b((cv<T>) t, a17, i);
                                break;
                            case 61:
                                dz.a(t, d & 1048575, ddVar.n());
                                b((cv<T>) t, a17, i);
                                break;
                            case 62:
                                dz.a(t, d & 1048575, Integer.valueOf(ddVar.o()));
                                b((cv<T>) t, a17, i);
                                break;
                            case 63:
                                p = ddVar.p();
                                zzrh c3 = c(i);
                                if (c3 != null && !c3.zzb(p)) {
                                    obj = dg.a(a17, p, obj, dvVar);
                                    break;
                                }
                                dz.a(t, d & 1048575, Integer.valueOf(p));
                                b((cv<T>) t, a17, i);
                                break;
                            case 64:
                                dz.a(t, d & 1048575, Integer.valueOf(ddVar.q()));
                                b((cv<T>) t, a17, i);
                                break;
                            case 65:
                                dz.a(t, d & 1048575, Long.valueOf(ddVar.r()));
                                b((cv<T>) t, a17, i);
                                break;
                            case 66:
                                dz.a(t, d & 1048575, Integer.valueOf(ddVar.s()));
                                b((cv<T>) t, a17, i);
                                break;
                            case 67:
                                dz.a(t, d & 1048575, Long.valueOf(ddVar.t()));
                                b((cv<T>) t, a17, i);
                                break;
                            case 68:
                                dz.a(t, d & 1048575, ddVar.b(a(i), zzqpVar));
                                b((cv<T>) t, a17, i);
                                break;
                            default:
                                if (obj == null) {
                                    try {
                                        obj = dvVar.a();
                                    } catch (zzrl unused) {
                                        dvVar.a(ddVar);
                                        if (obj == null) {
                                            obj = dvVar.c(t);
                                        }
                                        if (!dvVar.a((dv) obj, ddVar)) {
                                            for (int i6 = this.m; i6 < this.n; i6++) {
                                                obj = a((Object) t, this.l[i6], (int) obj, (dv<UT, int>) dvVar);
                                            }
                                            if (obj == null) {
                                                return;
                                            }
                                            dvVar.b((Object) t, (T) obj);
                                            return;
                                        }
                                        break;
                                    }
                                }
                                if (!dvVar.a((dv) obj, ddVar)) {
                                    for (int i7 = this.m; i7 < this.n; i7++) {
                                        obj = a((Object) t, this.l[i7], (int) obj, (dv<UT, int>) dvVar);
                                    }
                                    if (obj == null) {
                                        return;
                                    }
                                    dvVar.b((Object) t, (T) obj);
                                    return;
                                }
                                break;
                        }
                    } else if (a17 == Integer.MAX_VALUE) {
                        for (int i8 = this.m; i8 < this.n; i8++) {
                            obj = a((Object) t, this.l[i8], (int) obj, (dv<UT, int>) dvVar);
                        }
                        if (obj == null) {
                            return;
                        }
                        dvVar.b((Object) t, (T) obj);
                        return;
                    } else {
                        Object a18 = !this.h ? null : bsVar.a(zzqpVar, this.g, a17);
                        if (a18 != null) {
                            if (bvVar == null) {
                                bvVar = bsVar.b(t);
                            }
                            bv<?> bvVar2 = bvVar;
                            obj = bsVar.a(ddVar, a18, zzqpVar, bvVar2, obj, dvVar);
                            bvVar = bvVar2;
                        } else {
                            dvVar.a(ddVar);
                            if (obj == null) {
                                obj = dvVar.c(t);
                            }
                            if (!dvVar.a((dv) obj, ddVar)) {
                                for (int i9 = this.m; i9 < this.n; i9++) {
                                    obj = a((Object) t, this.l[i9], (int) obj, (dv<UT, int>) dvVar);
                                }
                                if (obj == null) {
                                    return;
                                }
                                dvVar.b((Object) t, (T) obj);
                                return;
                            }
                        }
                    }
                } catch (Throwable th) {
                    for (int i10 = this.m; i10 < this.n; i10++) {
                        obj = a((Object) t, this.l[i10], (int) obj, (dv<UT, int>) dvVar);
                    }
                    if (obj != null) {
                        dvVar.b((Object) t, (T) obj);
                    }
                    throw th;
                }
            }
        } else {
            throw new NullPointerException();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x04bb  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x04fb  */
    /* JADX WARN: Removed duplicated region for block: B:363:0x097b  */
    @Override // com.google.android.gms.internal.gtm.de
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a(T t, em emVar) {
        Iterator<Map.Entry<?, Object>> it;
        Map.Entry<?, Object> entry;
        int length;
        Map.Entry<?, Object> entry2;
        int i;
        double e;
        float d;
        long b2;
        long b3;
        int a2;
        long b4;
        int a3;
        boolean c;
        int a4;
        int a5;
        int a6;
        long b5;
        int a7;
        long b6;
        Iterator<Map.Entry<?, Object>> it2;
        Map.Entry<?, Object> entry3;
        int length2;
        double e2;
        float d2;
        long b7;
        long b8;
        int a8;
        long b9;
        int a9;
        boolean c2;
        int a10;
        int a11;
        int a12;
        long b10;
        int a13;
        long b11;
        if (emVar.a() == zzrc.zze.zzbbd) {
            a(this.q, t, emVar);
            if (this.h) {
                bv<?> a14 = this.r.a(t);
                if (!a14.a.isEmpty()) {
                    it2 = a14.e();
                    entry3 = it2.next();
                    for (length2 = this.c.length - 3; length2 >= 0; length2 -= 3) {
                        int d3 = d(length2);
                        int i2 = this.c[length2];
                        while (entry3 != null && this.r.a(entry3) > i2) {
                            this.r.a(emVar, entry3);
                            entry3 = it2.hasNext() ? it2.next() : null;
                        }
                        switch ((d3 & 267386880) >>> 20) {
                            case 0:
                                if (a((cv<T>) t, length2)) {
                                    e2 = dz.e(t, d3 & 1048575);
                                    emVar.a(i2, e2);
                                    break;
                                } else {
                                    break;
                                }
                            case 1:
                                if (a((cv<T>) t, length2)) {
                                    d2 = dz.d(t, d3 & 1048575);
                                    emVar.a(i2, d2);
                                    break;
                                } else {
                                    break;
                                }
                            case 2:
                                if (a((cv<T>) t, length2)) {
                                    b7 = dz.b(t, d3 & 1048575);
                                    emVar.a(i2, b7);
                                    break;
                                } else {
                                    break;
                                }
                            case 3:
                                if (a((cv<T>) t, length2)) {
                                    b8 = dz.b(t, d3 & 1048575);
                                    emVar.c(i2, b8);
                                    break;
                                } else {
                                    break;
                                }
                            case 4:
                                if (a((cv<T>) t, length2)) {
                                    a8 = dz.a(t, d3 & 1048575);
                                    emVar.c(i2, a8);
                                    break;
                                } else {
                                    break;
                                }
                            case 5:
                                if (a((cv<T>) t, length2)) {
                                    b9 = dz.b(t, d3 & 1048575);
                                    emVar.d(i2, b9);
                                    break;
                                } else {
                                    break;
                                }
                            case 6:
                                if (a((cv<T>) t, length2)) {
                                    a9 = dz.a(t, d3 & 1048575);
                                    emVar.d(i2, a9);
                                    break;
                                } else {
                                    break;
                                }
                            case 7:
                                if (a((cv<T>) t, length2)) {
                                    c2 = dz.c(t, d3 & 1048575);
                                    emVar.a(i2, c2);
                                    break;
                                } else {
                                    break;
                                }
                            case 8:
                                if (!a((cv<T>) t, length2)) {
                                    break;
                                }
                                a(i2, dz.f(t, d3 & 1048575), emVar);
                                break;
                            case 9:
                                if (!a((cv<T>) t, length2)) {
                                    break;
                                }
                                emVar.a(i2, dz.f(t, d3 & 1048575), a(length2));
                                break;
                            case 10:
                                if (!a((cv<T>) t, length2)) {
                                    break;
                                }
                                emVar.a(i2, (zzps) dz.f(t, d3 & 1048575));
                                break;
                            case 11:
                                if (a((cv<T>) t, length2)) {
                                    a10 = dz.a(t, d3 & 1048575);
                                    emVar.e(i2, a10);
                                    break;
                                } else {
                                    break;
                                }
                            case 12:
                                if (a((cv<T>) t, length2)) {
                                    a11 = dz.a(t, d3 & 1048575);
                                    emVar.b(i2, a11);
                                    break;
                                } else {
                                    break;
                                }
                            case 13:
                                if (a((cv<T>) t, length2)) {
                                    a12 = dz.a(t, d3 & 1048575);
                                    emVar.a(i2, a12);
                                    break;
                                } else {
                                    break;
                                }
                            case 14:
                                if (a((cv<T>) t, length2)) {
                                    b10 = dz.b(t, d3 & 1048575);
                                    emVar.b(i2, b10);
                                    break;
                                } else {
                                    break;
                                }
                            case 15:
                                if (a((cv<T>) t, length2)) {
                                    a13 = dz.a(t, d3 & 1048575);
                                    emVar.f(i2, a13);
                                    break;
                                } else {
                                    break;
                                }
                            case 16:
                                if (a((cv<T>) t, length2)) {
                                    b11 = dz.b(t, d3 & 1048575);
                                    emVar.e(i2, b11);
                                    break;
                                } else {
                                    break;
                                }
                            case 17:
                                if (!a((cv<T>) t, length2)) {
                                    break;
                                }
                                emVar.b(i2, dz.f(t, d3 & 1048575), a(length2));
                                break;
                            case 18:
                                dg.a(this.c[length2], (List<Double>) dz.f(t, d3 & 1048575), emVar, false);
                                break;
                            case 19:
                                dg.b(this.c[length2], (List<Float>) dz.f(t, d3 & 1048575), emVar, false);
                                break;
                            case 20:
                                dg.c(this.c[length2], (List) dz.f(t, d3 & 1048575), emVar, false);
                                break;
                            case 21:
                                dg.d(this.c[length2], (List) dz.f(t, d3 & 1048575), emVar, false);
                                break;
                            case 22:
                                dg.h(this.c[length2], (List) dz.f(t, d3 & 1048575), emVar, false);
                                break;
                            case 23:
                                dg.f(this.c[length2], (List) dz.f(t, d3 & 1048575), emVar, false);
                                break;
                            case 24:
                                dg.k(this.c[length2], (List) dz.f(t, d3 & 1048575), emVar, false);
                                break;
                            case 25:
                                dg.n(this.c[length2], (List) dz.f(t, d3 & 1048575), emVar, false);
                                break;
                            case 26:
                                dg.a(this.c[length2], (List) dz.f(t, d3 & 1048575), emVar);
                                break;
                            case 27:
                                dg.a(this.c[length2], (List) dz.f(t, d3 & 1048575), emVar, a(length2));
                                break;
                            case 28:
                                dg.b(this.c[length2], (List) dz.f(t, d3 & 1048575), emVar);
                                break;
                            case 29:
                                dg.i(this.c[length2], (List) dz.f(t, d3 & 1048575), emVar, false);
                                break;
                            case 30:
                                dg.m(this.c[length2], (List) dz.f(t, d3 & 1048575), emVar, false);
                                break;
                            case 31:
                                dg.l(this.c[length2], (List) dz.f(t, d3 & 1048575), emVar, false);
                                break;
                            case 32:
                                dg.g(this.c[length2], (List) dz.f(t, d3 & 1048575), emVar, false);
                                break;
                            case 33:
                                dg.j(this.c[length2], (List) dz.f(t, d3 & 1048575), emVar, false);
                                break;
                            case 34:
                                dg.e(this.c[length2], (List) dz.f(t, d3 & 1048575), emVar, false);
                                break;
                            case 35:
                                dg.a(this.c[length2], (List<Double>) dz.f(t, d3 & 1048575), emVar, true);
                                break;
                            case 36:
                                dg.b(this.c[length2], (List<Float>) dz.f(t, d3 & 1048575), emVar, true);
                                break;
                            case 37:
                                dg.c(this.c[length2], (List) dz.f(t, d3 & 1048575), emVar, true);
                                break;
                            case 38:
                                dg.d(this.c[length2], (List) dz.f(t, d3 & 1048575), emVar, true);
                                break;
                            case 39:
                                dg.h(this.c[length2], (List) dz.f(t, d3 & 1048575), emVar, true);
                                break;
                            case 40:
                                dg.f(this.c[length2], (List) dz.f(t, d3 & 1048575), emVar, true);
                                break;
                            case 41:
                                dg.k(this.c[length2], (List) dz.f(t, d3 & 1048575), emVar, true);
                                break;
                            case 42:
                                dg.n(this.c[length2], (List) dz.f(t, d3 & 1048575), emVar, true);
                                break;
                            case 43:
                                dg.i(this.c[length2], (List) dz.f(t, d3 & 1048575), emVar, true);
                                break;
                            case 44:
                                dg.m(this.c[length2], (List) dz.f(t, d3 & 1048575), emVar, true);
                                break;
                            case 45:
                                dg.l(this.c[length2], (List) dz.f(t, d3 & 1048575), emVar, true);
                                break;
                            case 46:
                                dg.g(this.c[length2], (List) dz.f(t, d3 & 1048575), emVar, true);
                                break;
                            case 47:
                                dg.j(this.c[length2], (List) dz.f(t, d3 & 1048575), emVar, true);
                                break;
                            case 48:
                                dg.e(this.c[length2], (List) dz.f(t, d3 & 1048575), emVar, true);
                                break;
                            case 49:
                                dg.b(this.c[length2], (List) dz.f(t, d3 & 1048575), emVar, a(length2));
                                break;
                            case 50:
                                a(emVar, i2, dz.f(t, d3 & 1048575), length2);
                                break;
                            case 51:
                                if (a((cv<T>) t, i2, length2)) {
                                    e2 = b(t, d3 & 1048575);
                                    emVar.a(i2, e2);
                                    break;
                                } else {
                                    break;
                                }
                            case 52:
                                if (a((cv<T>) t, i2, length2)) {
                                    d2 = c(t, d3 & 1048575);
                                    emVar.a(i2, d2);
                                    break;
                                } else {
                                    break;
                                }
                            case 53:
                                if (a((cv<T>) t, i2, length2)) {
                                    b7 = e(t, d3 & 1048575);
                                    emVar.a(i2, b7);
                                    break;
                                } else {
                                    break;
                                }
                            case 54:
                                if (a((cv<T>) t, i2, length2)) {
                                    b8 = e(t, d3 & 1048575);
                                    emVar.c(i2, b8);
                                    break;
                                } else {
                                    break;
                                }
                            case 55:
                                if (a((cv<T>) t, i2, length2)) {
                                    a8 = d(t, d3 & 1048575);
                                    emVar.c(i2, a8);
                                    break;
                                } else {
                                    break;
                                }
                            case 56:
                                if (a((cv<T>) t, i2, length2)) {
                                    b9 = e(t, d3 & 1048575);
                                    emVar.d(i2, b9);
                                    break;
                                } else {
                                    break;
                                }
                            case 57:
                                if (a((cv<T>) t, i2, length2)) {
                                    a9 = d(t, d3 & 1048575);
                                    emVar.d(i2, a9);
                                    break;
                                } else {
                                    break;
                                }
                            case 58:
                                if (a((cv<T>) t, i2, length2)) {
                                    c2 = f(t, d3 & 1048575);
                                    emVar.a(i2, c2);
                                    break;
                                } else {
                                    break;
                                }
                            case 59:
                                if (!a((cv<T>) t, i2, length2)) {
                                    break;
                                }
                                a(i2, dz.f(t, d3 & 1048575), emVar);
                                break;
                            case 60:
                                if (!a((cv<T>) t, i2, length2)) {
                                    break;
                                }
                                emVar.a(i2, dz.f(t, d3 & 1048575), a(length2));
                                break;
                            case 61:
                                if (!a((cv<T>) t, i2, length2)) {
                                    break;
                                }
                                emVar.a(i2, (zzps) dz.f(t, d3 & 1048575));
                                break;
                            case 62:
                                if (a((cv<T>) t, i2, length2)) {
                                    a10 = d(t, d3 & 1048575);
                                    emVar.e(i2, a10);
                                    break;
                                } else {
                                    break;
                                }
                            case 63:
                                if (a((cv<T>) t, i2, length2)) {
                                    a11 = d(t, d3 & 1048575);
                                    emVar.b(i2, a11);
                                    break;
                                } else {
                                    break;
                                }
                            case 64:
                                if (a((cv<T>) t, i2, length2)) {
                                    a12 = d(t, d3 & 1048575);
                                    emVar.a(i2, a12);
                                    break;
                                } else {
                                    break;
                                }
                            case 65:
                                if (a((cv<T>) t, i2, length2)) {
                                    b10 = e(t, d3 & 1048575);
                                    emVar.b(i2, b10);
                                    break;
                                } else {
                                    break;
                                }
                            case 66:
                                if (a((cv<T>) t, i2, length2)) {
                                    a13 = d(t, d3 & 1048575);
                                    emVar.f(i2, a13);
                                    break;
                                } else {
                                    break;
                                }
                            case 67:
                                if (a((cv<T>) t, i2, length2)) {
                                    b11 = e(t, d3 & 1048575);
                                    emVar.e(i2, b11);
                                    break;
                                } else {
                                    break;
                                }
                            case 68:
                                if (!a((cv<T>) t, i2, length2)) {
                                    break;
                                }
                                emVar.b(i2, dz.f(t, d3 & 1048575), a(length2));
                                break;
                        }
                    }
                    while (entry3 != null) {
                        this.r.a(emVar, entry3);
                        entry3 = it2.hasNext() ? it2.next() : null;
                    }
                }
            }
            it2 = null;
            entry3 = null;
            while (length2 >= 0) {
            }
            while (entry3 != null) {
            }
        } else if (!this.j) {
            b((cv<T>) t, emVar);
        } else {
            if (this.h) {
                bv<?> a15 = this.r.a(t);
                if (!a15.a.isEmpty()) {
                    it = a15.d();
                    entry = it.next();
                    length = this.c.length;
                    entry2 = entry;
                    for (i = 0; i < length; i += 3) {
                        int d4 = d(i);
                        int i3 = this.c[i];
                        while (entry2 != null && this.r.a(entry2) <= i3) {
                            this.r.a(emVar, entry2);
                            entry2 = it.hasNext() ? it.next() : null;
                        }
                        switch ((d4 & 267386880) >>> 20) {
                            case 0:
                                if (a((cv<T>) t, i)) {
                                    e = dz.e(t, d4 & 1048575);
                                    emVar.a(i3, e);
                                    break;
                                } else {
                                    break;
                                }
                            case 1:
                                if (a((cv<T>) t, i)) {
                                    d = dz.d(t, d4 & 1048575);
                                    emVar.a(i3, d);
                                    break;
                                } else {
                                    break;
                                }
                            case 2:
                                if (a((cv<T>) t, i)) {
                                    b2 = dz.b(t, d4 & 1048575);
                                    emVar.a(i3, b2);
                                    break;
                                } else {
                                    break;
                                }
                            case 3:
                                if (a((cv<T>) t, i)) {
                                    b3 = dz.b(t, d4 & 1048575);
                                    emVar.c(i3, b3);
                                    break;
                                } else {
                                    break;
                                }
                            case 4:
                                if (a((cv<T>) t, i)) {
                                    a2 = dz.a(t, d4 & 1048575);
                                    emVar.c(i3, a2);
                                    break;
                                } else {
                                    break;
                                }
                            case 5:
                                if (a((cv<T>) t, i)) {
                                    b4 = dz.b(t, d4 & 1048575);
                                    emVar.d(i3, b4);
                                    break;
                                } else {
                                    break;
                                }
                            case 6:
                                if (a((cv<T>) t, i)) {
                                    a3 = dz.a(t, d4 & 1048575);
                                    emVar.d(i3, a3);
                                    break;
                                } else {
                                    break;
                                }
                            case 7:
                                if (a((cv<T>) t, i)) {
                                    c = dz.c(t, d4 & 1048575);
                                    emVar.a(i3, c);
                                    break;
                                } else {
                                    break;
                                }
                            case 8:
                                if (!a((cv<T>) t, i)) {
                                    break;
                                }
                                a(i3, dz.f(t, d4 & 1048575), emVar);
                                break;
                            case 9:
                                if (!a((cv<T>) t, i)) {
                                    break;
                                }
                                emVar.a(i3, dz.f(t, d4 & 1048575), a(i));
                                break;
                            case 10:
                                if (!a((cv<T>) t, i)) {
                                    break;
                                }
                                emVar.a(i3, (zzps) dz.f(t, d4 & 1048575));
                                break;
                            case 11:
                                if (a((cv<T>) t, i)) {
                                    a4 = dz.a(t, d4 & 1048575);
                                    emVar.e(i3, a4);
                                    break;
                                } else {
                                    break;
                                }
                            case 12:
                                if (a((cv<T>) t, i)) {
                                    a5 = dz.a(t, d4 & 1048575);
                                    emVar.b(i3, a5);
                                    break;
                                } else {
                                    break;
                                }
                            case 13:
                                if (a((cv<T>) t, i)) {
                                    a6 = dz.a(t, d4 & 1048575);
                                    emVar.a(i3, a6);
                                    break;
                                } else {
                                    break;
                                }
                            case 14:
                                if (a((cv<T>) t, i)) {
                                    b5 = dz.b(t, d4 & 1048575);
                                    emVar.b(i3, b5);
                                    break;
                                } else {
                                    break;
                                }
                            case 15:
                                if (a((cv<T>) t, i)) {
                                    a7 = dz.a(t, d4 & 1048575);
                                    emVar.f(i3, a7);
                                    break;
                                } else {
                                    break;
                                }
                            case 16:
                                if (a((cv<T>) t, i)) {
                                    b6 = dz.b(t, d4 & 1048575);
                                    emVar.e(i3, b6);
                                    break;
                                } else {
                                    break;
                                }
                            case 17:
                                if (!a((cv<T>) t, i)) {
                                    break;
                                }
                                emVar.b(i3, dz.f(t, d4 & 1048575), a(i));
                                break;
                            case 18:
                                dg.a(this.c[i], (List<Double>) dz.f(t, d4 & 1048575), emVar, false);
                                break;
                            case 19:
                                dg.b(this.c[i], (List<Float>) dz.f(t, d4 & 1048575), emVar, false);
                                break;
                            case 20:
                                dg.c(this.c[i], (List) dz.f(t, d4 & 1048575), emVar, false);
                                break;
                            case 21:
                                dg.d(this.c[i], (List) dz.f(t, d4 & 1048575), emVar, false);
                                break;
                            case 22:
                                dg.h(this.c[i], (List) dz.f(t, d4 & 1048575), emVar, false);
                                break;
                            case 23:
                                dg.f(this.c[i], (List) dz.f(t, d4 & 1048575), emVar, false);
                                break;
                            case 24:
                                dg.k(this.c[i], (List) dz.f(t, d4 & 1048575), emVar, false);
                                break;
                            case 25:
                                dg.n(this.c[i], (List) dz.f(t, d4 & 1048575), emVar, false);
                                break;
                            case 26:
                                dg.a(this.c[i], (List) dz.f(t, d4 & 1048575), emVar);
                                break;
                            case 27:
                                dg.a(this.c[i], (List) dz.f(t, d4 & 1048575), emVar, a(i));
                                break;
                            case 28:
                                dg.b(this.c[i], (List) dz.f(t, d4 & 1048575), emVar);
                                break;
                            case 29:
                                dg.i(this.c[i], (List) dz.f(t, d4 & 1048575), emVar, false);
                                break;
                            case 30:
                                dg.m(this.c[i], (List) dz.f(t, d4 & 1048575), emVar, false);
                                break;
                            case 31:
                                dg.l(this.c[i], (List) dz.f(t, d4 & 1048575), emVar, false);
                                break;
                            case 32:
                                dg.g(this.c[i], (List) dz.f(t, d4 & 1048575), emVar, false);
                                break;
                            case 33:
                                dg.j(this.c[i], (List) dz.f(t, d4 & 1048575), emVar, false);
                                break;
                            case 34:
                                dg.e(this.c[i], (List) dz.f(t, d4 & 1048575), emVar, false);
                                break;
                            case 35:
                                dg.a(this.c[i], (List<Double>) dz.f(t, d4 & 1048575), emVar, true);
                                break;
                            case 36:
                                dg.b(this.c[i], (List<Float>) dz.f(t, d4 & 1048575), emVar, true);
                                break;
                            case 37:
                                dg.c(this.c[i], (List) dz.f(t, d4 & 1048575), emVar, true);
                                break;
                            case 38:
                                dg.d(this.c[i], (List) dz.f(t, d4 & 1048575), emVar, true);
                                break;
                            case 39:
                                dg.h(this.c[i], (List) dz.f(t, d4 & 1048575), emVar, true);
                                break;
                            case 40:
                                dg.f(this.c[i], (List) dz.f(t, d4 & 1048575), emVar, true);
                                break;
                            case 41:
                                dg.k(this.c[i], (List) dz.f(t, d4 & 1048575), emVar, true);
                                break;
                            case 42:
                                dg.n(this.c[i], (List) dz.f(t, d4 & 1048575), emVar, true);
                                break;
                            case 43:
                                dg.i(this.c[i], (List) dz.f(t, d4 & 1048575), emVar, true);
                                break;
                            case 44:
                                dg.m(this.c[i], (List) dz.f(t, d4 & 1048575), emVar, true);
                                break;
                            case 45:
                                dg.l(this.c[i], (List) dz.f(t, d4 & 1048575), emVar, true);
                                break;
                            case 46:
                                dg.g(this.c[i], (List) dz.f(t, d4 & 1048575), emVar, true);
                                break;
                            case 47:
                                dg.j(this.c[i], (List) dz.f(t, d4 & 1048575), emVar, true);
                                break;
                            case 48:
                                dg.e(this.c[i], (List) dz.f(t, d4 & 1048575), emVar, true);
                                break;
                            case 49:
                                dg.b(this.c[i], (List) dz.f(t, d4 & 1048575), emVar, a(i));
                                break;
                            case 50:
                                a(emVar, i3, dz.f(t, d4 & 1048575), i);
                                break;
                            case 51:
                                if (a((cv<T>) t, i3, i)) {
                                    e = b(t, d4 & 1048575);
                                    emVar.a(i3, e);
                                    break;
                                } else {
                                    break;
                                }
                            case 52:
                                if (a((cv<T>) t, i3, i)) {
                                    d = c(t, d4 & 1048575);
                                    emVar.a(i3, d);
                                    break;
                                } else {
                                    break;
                                }
                            case 53:
                                if (a((cv<T>) t, i3, i)) {
                                    b2 = e(t, d4 & 1048575);
                                    emVar.a(i3, b2);
                                    break;
                                } else {
                                    break;
                                }
                            case 54:
                                if (a((cv<T>) t, i3, i)) {
                                    b3 = e(t, d4 & 1048575);
                                    emVar.c(i3, b3);
                                    break;
                                } else {
                                    break;
                                }
                            case 55:
                                if (a((cv<T>) t, i3, i)) {
                                    a2 = d(t, d4 & 1048575);
                                    emVar.c(i3, a2);
                                    break;
                                } else {
                                    break;
                                }
                            case 56:
                                if (a((cv<T>) t, i3, i)) {
                                    b4 = e(t, d4 & 1048575);
                                    emVar.d(i3, b4);
                                    break;
                                } else {
                                    break;
                                }
                            case 57:
                                if (a((cv<T>) t, i3, i)) {
                                    a3 = d(t, d4 & 1048575);
                                    emVar.d(i3, a3);
                                    break;
                                } else {
                                    break;
                                }
                            case 58:
                                if (a((cv<T>) t, i3, i)) {
                                    c = f(t, d4 & 1048575);
                                    emVar.a(i3, c);
                                    break;
                                } else {
                                    break;
                                }
                            case 59:
                                if (!a((cv<T>) t, i3, i)) {
                                    break;
                                }
                                a(i3, dz.f(t, d4 & 1048575), emVar);
                                break;
                            case 60:
                                if (!a((cv<T>) t, i3, i)) {
                                    break;
                                }
                                emVar.a(i3, dz.f(t, d4 & 1048575), a(i));
                                break;
                            case 61:
                                if (!a((cv<T>) t, i3, i)) {
                                    break;
                                }
                                emVar.a(i3, (zzps) dz.f(t, d4 & 1048575));
                                break;
                            case 62:
                                if (a((cv<T>) t, i3, i)) {
                                    a4 = d(t, d4 & 1048575);
                                    emVar.e(i3, a4);
                                    break;
                                } else {
                                    break;
                                }
                            case 63:
                                if (a((cv<T>) t, i3, i)) {
                                    a5 = d(t, d4 & 1048575);
                                    emVar.b(i3, a5);
                                    break;
                                } else {
                                    break;
                                }
                            case 64:
                                if (a((cv<T>) t, i3, i)) {
                                    a6 = d(t, d4 & 1048575);
                                    emVar.a(i3, a6);
                                    break;
                                } else {
                                    break;
                                }
                            case 65:
                                if (a((cv<T>) t, i3, i)) {
                                    b5 = e(t, d4 & 1048575);
                                    emVar.b(i3, b5);
                                    break;
                                } else {
                                    break;
                                }
                            case 66:
                                if (a((cv<T>) t, i3, i)) {
                                    a7 = d(t, d4 & 1048575);
                                    emVar.f(i3, a7);
                                    break;
                                } else {
                                    break;
                                }
                            case 67:
                                if (a((cv<T>) t, i3, i)) {
                                    b6 = e(t, d4 & 1048575);
                                    emVar.e(i3, b6);
                                    break;
                                } else {
                                    break;
                                }
                            case 68:
                                if (!a((cv<T>) t, i3, i)) {
                                    break;
                                }
                                emVar.b(i3, dz.f(t, d4 & 1048575), a(i));
                                break;
                        }
                    }
                    while (entry2 != null) {
                        this.r.a(emVar, entry2);
                        entry2 = it.hasNext() ? it.next() : null;
                    }
                    a(this.q, t, emVar);
                }
            }
            it = null;
            entry = null;
            length = this.c.length;
            entry2 = entry;
            while (i < length) {
            }
            while (entry2 != null) {
            }
            a(this.q, t, emVar);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:102:0x01b0, code lost:
        if (java.lang.Double.doubleToLongBits(com.google.android.gms.internal.gtm.dz.e(r10, r6)) == java.lang.Double.doubleToLongBits(com.google.android.gms.internal.gtm.dz.e(r11, r6))) goto L84;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0038, code lost:
        if (com.google.android.gms.internal.gtm.dg.a(com.google.android.gms.internal.gtm.dz.f(r10, r6), com.google.android.gms.internal.gtm.dz.f(r11, r6)) != false) goto L84;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x005c, code lost:
        if (com.google.android.gms.internal.gtm.dg.a(com.google.android.gms.internal.gtm.dz.f(r10, r6), com.google.android.gms.internal.gtm.dz.f(r11, r6)) != false) goto L84;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0070, code lost:
        if (com.google.android.gms.internal.gtm.dz.b(r10, r6) == com.google.android.gms.internal.gtm.dz.b(r11, r6)) goto L84;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0082, code lost:
        if (com.google.android.gms.internal.gtm.dz.a(r10, r6) == com.google.android.gms.internal.gtm.dz.a(r11, r6)) goto L84;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0096, code lost:
        if (com.google.android.gms.internal.gtm.dz.b(r10, r6) == com.google.android.gms.internal.gtm.dz.b(r11, r6)) goto L84;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00a8, code lost:
        if (com.google.android.gms.internal.gtm.dz.a(r10, r6) == com.google.android.gms.internal.gtm.dz.a(r11, r6)) goto L84;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00ba, code lost:
        if (com.google.android.gms.internal.gtm.dz.a(r10, r6) == com.google.android.gms.internal.gtm.dz.a(r11, r6)) goto L84;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00cc, code lost:
        if (com.google.android.gms.internal.gtm.dz.a(r10, r6) == com.google.android.gms.internal.gtm.dz.a(r11, r6)) goto L84;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00e2, code lost:
        if (com.google.android.gms.internal.gtm.dg.a(com.google.android.gms.internal.gtm.dz.f(r10, r6), com.google.android.gms.internal.gtm.dz.f(r11, r6)) != false) goto L84;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x00f8, code lost:
        if (com.google.android.gms.internal.gtm.dg.a(com.google.android.gms.internal.gtm.dz.f(r10, r6), com.google.android.gms.internal.gtm.dz.f(r11, r6)) != false) goto L84;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x010e, code lost:
        if (com.google.android.gms.internal.gtm.dg.a(com.google.android.gms.internal.gtm.dz.f(r10, r6), com.google.android.gms.internal.gtm.dz.f(r11, r6)) != false) goto L84;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0120, code lost:
        if (com.google.android.gms.internal.gtm.dz.c(r10, r6) == com.google.android.gms.internal.gtm.dz.c(r11, r6)) goto L84;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x0132, code lost:
        if (com.google.android.gms.internal.gtm.dz.a(r10, r6) == com.google.android.gms.internal.gtm.dz.a(r11, r6)) goto L84;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x0145, code lost:
        if (com.google.android.gms.internal.gtm.dz.b(r10, r6) == com.google.android.gms.internal.gtm.dz.b(r11, r6)) goto L84;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x0156, code lost:
        if (com.google.android.gms.internal.gtm.dz.a(r10, r6) == com.google.android.gms.internal.gtm.dz.a(r11, r6)) goto L84;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x0169, code lost:
        if (com.google.android.gms.internal.gtm.dz.b(r10, r6) == com.google.android.gms.internal.gtm.dz.b(r11, r6)) goto L84;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x017c, code lost:
        if (com.google.android.gms.internal.gtm.dz.b(r10, r6) == com.google.android.gms.internal.gtm.dz.b(r11, r6)) goto L84;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x0195, code lost:
        if (java.lang.Float.floatToIntBits(com.google.android.gms.internal.gtm.dz.d(r10, r6)) == java.lang.Float.floatToIntBits(com.google.android.gms.internal.gtm.dz.d(r11, r6))) goto L84;
     */
    @Override // com.google.android.gms.internal.gtm.de
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean a(T t, T t2) {
        int length = this.c.length;
        int i = 0;
        while (true) {
            boolean z = true;
            if (i >= length) {
                if (!this.q.b(t).equals(this.q.b(t2))) {
                    return false;
                }
                if (!this.h) {
                    return true;
                }
                return this.r.a(t).equals(this.r.a(t2));
            }
            int d = d(i);
            long j = d & 1048575;
            switch ((d & 267386880) >>> 20) {
                case 0:
                    if (c(t, t2, i)) {
                        break;
                    }
                    z = false;
                    break;
                case 1:
                    if (c(t, t2, i)) {
                        break;
                    }
                    z = false;
                    break;
                case 2:
                    if (c(t, t2, i)) {
                        break;
                    }
                    z = false;
                    break;
                case 3:
                    if (c(t, t2, i)) {
                        break;
                    }
                    z = false;
                    break;
                case 4:
                    if (c(t, t2, i)) {
                        break;
                    }
                    z = false;
                    break;
                case 5:
                    if (c(t, t2, i)) {
                        break;
                    }
                    z = false;
                    break;
                case 6:
                    if (c(t, t2, i)) {
                        break;
                    }
                    z = false;
                    break;
                case 7:
                    if (c(t, t2, i)) {
                        break;
                    }
                    z = false;
                    break;
                case 8:
                    if (c(t, t2, i)) {
                        break;
                    }
                    z = false;
                    break;
                case 9:
                    if (c(t, t2, i)) {
                        break;
                    }
                    z = false;
                    break;
                case 10:
                    if (c(t, t2, i)) {
                        break;
                    }
                    z = false;
                    break;
                case 11:
                    if (c(t, t2, i)) {
                        break;
                    }
                    z = false;
                    break;
                case 12:
                    if (c(t, t2, i)) {
                        break;
                    }
                    z = false;
                    break;
                case 13:
                    if (c(t, t2, i)) {
                        break;
                    }
                    z = false;
                    break;
                case 14:
                    if (c(t, t2, i)) {
                        break;
                    }
                    z = false;
                    break;
                case 15:
                    if (c(t, t2, i)) {
                        break;
                    }
                    z = false;
                    break;
                case 16:
                    if (c(t, t2, i)) {
                        break;
                    }
                    z = false;
                    break;
                case 17:
                    if (c(t, t2, i)) {
                        break;
                    }
                    z = false;
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                case 50:
                    z = dg.a(dz.f(t, j), dz.f(t2, j));
                    break;
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                case 58:
                case 59:
                case 60:
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                case 68:
                    long e = e(i) & 1048575;
                    if (dz.a(t, e) == dz.a(t2, e)) {
                        break;
                    }
                    z = false;
                    break;
            }
            if (!z) {
                return false;
            }
            i += 3;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x0181, code lost:
        if (r19.k != false) goto L104;
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x0193, code lost:
        if (r19.k != false) goto L104;
     */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x01a5, code lost:
        if (r19.k != false) goto L104;
     */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x01b6, code lost:
        if (r19.k != false) goto L104;
     */
    /* JADX WARN: Code restructure failed: missing block: B:121:0x01c7, code lost:
        if (r19.k != false) goto L104;
     */
    /* JADX WARN: Code restructure failed: missing block: B:126:0x01d8, code lost:
        if (r19.k != false) goto L104;
     */
    /* JADX WARN: Code restructure failed: missing block: B:131:0x01e9, code lost:
        if (r19.k != false) goto L104;
     */
    /* JADX WARN: Code restructure failed: missing block: B:136:0x01fa, code lost:
        if (r19.k != false) goto L104;
     */
    /* JADX WARN: Code restructure failed: missing block: B:141:0x020b, code lost:
        if (r19.k != false) goto L104;
     */
    /* JADX WARN: Code restructure failed: missing block: B:142:0x020d, code lost:
        r2.putInt(r20, r14, r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:143:0x0211, code lost:
        r3 = (com.google.android.gms.internal.gtm.zzqj.zzbb(r3) + com.google.android.gms.internal.gtm.zzqj.zzbd(r5)) + r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:193:0x0331, code lost:
        if ((r5 instanceof com.google.android.gms.internal.gtm.zzps) != false) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:195:0x0334, code lost:
        r3 = com.google.android.gms.internal.gtm.zzqj.zzb(r3, (java.lang.String) r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:249:0x0417, code lost:
        if (a((com.google.android.gms.internal.gtm.cv<T>) r20, r15, r3) != false) goto L266;
     */
    /* JADX WARN: Code restructure failed: missing block: B:258:0x0437, code lost:
        if (a((com.google.android.gms.internal.gtm.cv<T>) r20, r15, r3) != false) goto L278;
     */
    /* JADX WARN: Code restructure failed: missing block: B:261:0x043f, code lost:
        if (a((com.google.android.gms.internal.gtm.cv<T>) r20, r15, r3) != false) goto L281;
     */
    /* JADX WARN: Code restructure failed: missing block: B:270:0x045f, code lost:
        if (a((com.google.android.gms.internal.gtm.cv<T>) r20, r15, r3) != false) goto L293;
     */
    /* JADX WARN: Code restructure failed: missing block: B:273:0x0467, code lost:
        if (a((com.google.android.gms.internal.gtm.cv<T>) r20, r15, r3) != false) goto L297;
     */
    /* JADX WARN: Code restructure failed: missing block: B:278:0x0477, code lost:
        if ((r4 instanceof com.google.android.gms.internal.gtm.zzps) != false) goto L294;
     */
    /* JADX WARN: Code restructure failed: missing block: B:309:0x051c, code lost:
        if (r19.k != false) goto L334;
     */
    /* JADX WARN: Code restructure failed: missing block: B:314:0x052e, code lost:
        if (r19.k != false) goto L334;
     */
    /* JADX WARN: Code restructure failed: missing block: B:319:0x0540, code lost:
        if (r19.k != false) goto L334;
     */
    /* JADX WARN: Code restructure failed: missing block: B:324:0x0552, code lost:
        if (r19.k != false) goto L334;
     */
    /* JADX WARN: Code restructure failed: missing block: B:329:0x0564, code lost:
        if (r19.k != false) goto L334;
     */
    /* JADX WARN: Code restructure failed: missing block: B:334:0x0576, code lost:
        if (r19.k != false) goto L334;
     */
    /* JADX WARN: Code restructure failed: missing block: B:339:0x0588, code lost:
        if (r19.k != false) goto L334;
     */
    /* JADX WARN: Code restructure failed: missing block: B:344:0x059a, code lost:
        if (r19.k != false) goto L334;
     */
    /* JADX WARN: Code restructure failed: missing block: B:349:0x05ab, code lost:
        if (r19.k != false) goto L334;
     */
    /* JADX WARN: Code restructure failed: missing block: B:354:0x05bc, code lost:
        if (r19.k != false) goto L334;
     */
    /* JADX WARN: Code restructure failed: missing block: B:359:0x05cd, code lost:
        if (r19.k != false) goto L334;
     */
    /* JADX WARN: Code restructure failed: missing block: B:364:0x05de, code lost:
        if (r19.k != false) goto L334;
     */
    /* JADX WARN: Code restructure failed: missing block: B:369:0x05ef, code lost:
        if (r19.k != false) goto L334;
     */
    /* JADX WARN: Code restructure failed: missing block: B:374:0x0600, code lost:
        if (r19.k != false) goto L334;
     */
    /* JADX WARN: Code restructure failed: missing block: B:375:0x0602, code lost:
        r2.putInt(r20, r11, r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:376:0x0606, code lost:
        r8 = (com.google.android.gms.internal.gtm.zzqj.zzbb(r15) + com.google.android.gms.internal.gtm.zzqj.zzbd(r4)) + r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:398:0x06ce, code lost:
        if ((r12 & r18) != 0) goto L266;
     */
    /* JADX WARN: Code restructure failed: missing block: B:399:0x06d0, code lost:
        r4 = com.google.android.gms.internal.gtm.zzqj.c(r15, (com.google.android.gms.internal.gtm.zzsk) r2.getObject(r20, r8), a(r3));
     */
    /* JADX WARN: Code restructure failed: missing block: B:409:0x06fb, code lost:
        if ((r12 & r18) != 0) goto L278;
     */
    /* JADX WARN: Code restructure failed: missing block: B:410:0x06fd, code lost:
        r4 = com.google.android.gms.internal.gtm.zzqj.zzh(r15, 0L);
     */
    /* JADX WARN: Code restructure failed: missing block: B:412:0x0706, code lost:
        if ((r12 & r18) != 0) goto L281;
     */
    /* JADX WARN: Code restructure failed: missing block: B:413:0x0708, code lost:
        r8 = com.google.android.gms.internal.gtm.zzqj.zzm(r15, 0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:424:0x072b, code lost:
        if ((r12 & r18) != 0) goto L293;
     */
    /* JADX WARN: Code restructure failed: missing block: B:425:0x072d, code lost:
        r4 = r2.getObject(r20, r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:426:0x0731, code lost:
        r4 = com.google.android.gms.internal.gtm.zzqj.zzc(r15, (com.google.android.gms.internal.gtm.zzps) r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:428:0x073a, code lost:
        if ((r12 & r18) != 0) goto L297;
     */
    /* JADX WARN: Code restructure failed: missing block: B:429:0x073c, code lost:
        r4 = com.google.android.gms.internal.gtm.dg.a(r15, r2.getObject(r20, r8), a(r3));
     */
    /* JADX WARN: Code restructure failed: missing block: B:433:0x0754, code lost:
        if ((r4 instanceof com.google.android.gms.internal.gtm.zzps) != false) goto L294;
     */
    /* JADX WARN: Code restructure failed: missing block: B:435:0x0757, code lost:
        r4 = com.google.android.gms.internal.gtm.zzqj.zzb(r15, (java.lang.String) r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00ab, code lost:
        if ((r5 instanceof com.google.android.gms.internal.gtm.zzps) != false) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x0127, code lost:
        if (r19.k != false) goto L104;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x0139, code lost:
        if (r19.k != false) goto L104;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x014b, code lost:
        if (r19.k != false) goto L104;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x015d, code lost:
        if (r19.k != false) goto L104;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x016f, code lost:
        if (r19.k != false) goto L104;
     */
    @Override // com.google.android.gms.internal.gtm.de
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int b(T t) {
        int i;
        int i2;
        long j;
        int zzd;
        Object object;
        int i3;
        int i4;
        int i5;
        long j2;
        int i6;
        int h;
        int i7;
        int zzbb;
        long b2;
        long b3;
        int a2;
        Object f;
        int a3;
        int a4;
        int a5;
        long b4;
        int i8;
        int i9;
        int i10 = 267386880;
        int i11 = 1048575;
        int i12 = 1;
        if (this.j) {
            Unsafe unsafe = b;
            int i13 = 0;
            int i14 = 0;
            while (i13 < this.c.length) {
                int d = d(i13);
                int i15 = (d & i10) >>> 20;
                int i16 = this.c[i13];
                long j3 = d & 1048575;
                int i17 = (i15 < zzqw.DOUBLE_LIST_PACKED.id() || i15 > zzqw.SINT64_LIST_PACKED.id()) ? 0 : this.c[i13 + 2] & 1048575;
                switch (i15) {
                    case 0:
                        if (!a((cv<T>) t, i13)) {
                            continue;
                            i13 += 3;
                            i10 = 267386880;
                        }
                        i8 = zzqj.zzb(i16, 0.0d);
                        break;
                    case 1:
                        if (!a((cv<T>) t, i13)) {
                            continue;
                            i13 += 3;
                            i10 = 267386880;
                        }
                        i8 = zzqj.zzb(i16, 0.0f);
                        break;
                    case 2:
                        if (a((cv<T>) t, i13)) {
                            b2 = dz.b(t, j3);
                            i8 = zzqj.zzd(i16, b2);
                            break;
                        } else {
                            continue;
                            i13 += 3;
                            i10 = 267386880;
                        }
                    case 3:
                        if (a((cv<T>) t, i13)) {
                            b3 = dz.b(t, j3);
                            i8 = zzqj.zze(i16, b3);
                            break;
                        } else {
                            continue;
                            i13 += 3;
                            i10 = 267386880;
                        }
                    case 4:
                        if (a((cv<T>) t, i13)) {
                            a2 = dz.a(t, j3);
                            i8 = zzqj.zzi(i16, a2);
                            break;
                        } else {
                            continue;
                            i13 += 3;
                            i10 = 267386880;
                        }
                    case 5:
                        if (!a((cv<T>) t, i13)) {
                            continue;
                            i13 += 3;
                            i10 = 267386880;
                        }
                        i8 = zzqj.zzg(i16, 0L);
                        break;
                    case 6:
                        if (!a((cv<T>) t, i13)) {
                            continue;
                            i13 += 3;
                            i10 = 267386880;
                        }
                        i8 = zzqj.zzl(i16, 0);
                        break;
                    case 7:
                        if (!a((cv<T>) t, i13)) {
                            continue;
                            i13 += 3;
                            i10 = 267386880;
                        }
                        i8 = zzqj.zzc(i16, true);
                        break;
                    case 8:
                        if (a((cv<T>) t, i13)) {
                            f = dz.f(t, j3);
                            break;
                        } else {
                            continue;
                            i13 += 3;
                            i10 = 267386880;
                        }
                    case 9:
                        if (!a((cv<T>) t, i13)) {
                            continue;
                            i13 += 3;
                            i10 = 267386880;
                        }
                        i8 = dg.a(i16, dz.f(t, j3), a(i13));
                        break;
                    case 10:
                        if (!a((cv<T>) t, i13)) {
                            continue;
                            i13 += 3;
                            i10 = 267386880;
                        }
                        f = dz.f(t, j3);
                        i8 = zzqj.zzc(i16, (zzps) f);
                        break;
                    case 11:
                        if (a((cv<T>) t, i13)) {
                            a3 = dz.a(t, j3);
                            i8 = zzqj.zzj(i16, a3);
                            break;
                        } else {
                            continue;
                            i13 += 3;
                            i10 = 267386880;
                        }
                    case 12:
                        if (a((cv<T>) t, i13)) {
                            a4 = dz.a(t, j3);
                            i8 = zzqj.zzn(i16, a4);
                            break;
                        } else {
                            continue;
                            i13 += 3;
                            i10 = 267386880;
                        }
                    case 13:
                        if (!a((cv<T>) t, i13)) {
                            continue;
                            i13 += 3;
                            i10 = 267386880;
                        }
                        i8 = zzqj.zzm(i16, 0);
                        break;
                    case 14:
                        if (!a((cv<T>) t, i13)) {
                            continue;
                            i13 += 3;
                            i10 = 267386880;
                        }
                        i8 = zzqj.zzh(i16, 0L);
                        break;
                    case 15:
                        if (a((cv<T>) t, i13)) {
                            a5 = dz.a(t, j3);
                            i8 = zzqj.zzk(i16, a5);
                            break;
                        } else {
                            continue;
                            i13 += 3;
                            i10 = 267386880;
                        }
                    case 16:
                        if (a((cv<T>) t, i13)) {
                            b4 = dz.b(t, j3);
                            i8 = zzqj.zzf(i16, b4);
                            break;
                        } else {
                            continue;
                            i13 += 3;
                            i10 = 267386880;
                        }
                    case 17:
                        if (!a((cv<T>) t, i13)) {
                            continue;
                            i13 += 3;
                            i10 = 267386880;
                        }
                        i8 = zzqj.c(i16, (zzsk) dz.f(t, j3), a(i13));
                        break;
                    case 18:
                    case 23:
                    case 32:
                        i8 = dg.i(i16, a(t, j3), false);
                        break;
                    case 19:
                    case 24:
                    case 31:
                        i8 = dg.h(i16, a(t, j3), false);
                        break;
                    case 20:
                        i8 = dg.a(i16, (List<Long>) a(t, j3), false);
                        break;
                    case 21:
                        i8 = dg.b(i16, (List<Long>) a(t, j3), false);
                        break;
                    case 22:
                        i8 = dg.e(i16, a(t, j3), false);
                        break;
                    case 25:
                        i8 = dg.j(i16, a(t, j3), false);
                        break;
                    case 26:
                        i8 = dg.a(i16, a(t, j3));
                        break;
                    case 27:
                        i8 = dg.a(i16, (List<?>) a(t, j3), a(i13));
                        break;
                    case 28:
                        i8 = dg.b(i16, a(t, j3));
                        break;
                    case 29:
                        i8 = dg.f(i16, a(t, j3), false);
                        break;
                    case 30:
                        i8 = dg.d(i16, a(t, j3), false);
                        break;
                    case 33:
                        i8 = dg.g(i16, a(t, j3), false);
                        break;
                    case 34:
                        i8 = dg.c(i16, a(t, j3), false);
                        break;
                    case 35:
                        i9 = dg.i((List) unsafe.getObject(t, j3));
                        if (i9 > 0) {
                            break;
                        } else {
                            continue;
                            i13 += 3;
                            i10 = 267386880;
                        }
                    case 36:
                        i9 = dg.h((List) unsafe.getObject(t, j3));
                        if (i9 > 0) {
                            break;
                        } else {
                            continue;
                            i13 += 3;
                            i10 = 267386880;
                        }
                    case 37:
                        i9 = dg.a((List) unsafe.getObject(t, j3));
                        if (i9 > 0) {
                            break;
                        } else {
                            continue;
                            i13 += 3;
                            i10 = 267386880;
                        }
                    case 38:
                        i9 = dg.b((List) unsafe.getObject(t, j3));
                        if (i9 > 0) {
                            break;
                        } else {
                            continue;
                            i13 += 3;
                            i10 = 267386880;
                        }
                    case 39:
                        i9 = dg.e((List) unsafe.getObject(t, j3));
                        if (i9 > 0) {
                            break;
                        } else {
                            continue;
                            i13 += 3;
                            i10 = 267386880;
                        }
                    case 40:
                        i9 = dg.i((List) unsafe.getObject(t, j3));
                        if (i9 > 0) {
                            break;
                        } else {
                            continue;
                            i13 += 3;
                            i10 = 267386880;
                        }
                    case 41:
                        i9 = dg.h((List) unsafe.getObject(t, j3));
                        if (i9 > 0) {
                            break;
                        } else {
                            continue;
                            i13 += 3;
                            i10 = 267386880;
                        }
                    case 42:
                        i9 = dg.j((List) unsafe.getObject(t, j3));
                        if (i9 > 0) {
                            break;
                        } else {
                            continue;
                            i13 += 3;
                            i10 = 267386880;
                        }
                    case 43:
                        i9 = dg.f((List) unsafe.getObject(t, j3));
                        if (i9 > 0) {
                            break;
                        } else {
                            continue;
                            i13 += 3;
                            i10 = 267386880;
                        }
                    case 44:
                        i9 = dg.d((List) unsafe.getObject(t, j3));
                        if (i9 > 0) {
                            break;
                        } else {
                            continue;
                            i13 += 3;
                            i10 = 267386880;
                        }
                    case 45:
                        i9 = dg.h((List) unsafe.getObject(t, j3));
                        if (i9 > 0) {
                            break;
                        } else {
                            continue;
                            i13 += 3;
                            i10 = 267386880;
                        }
                    case 46:
                        i9 = dg.i((List) unsafe.getObject(t, j3));
                        if (i9 > 0) {
                            break;
                        } else {
                            continue;
                            i13 += 3;
                            i10 = 267386880;
                        }
                    case 47:
                        i9 = dg.g((List) unsafe.getObject(t, j3));
                        if (i9 > 0) {
                            break;
                        } else {
                            continue;
                            i13 += 3;
                            i10 = 267386880;
                        }
                    case 48:
                        i9 = dg.c((List) unsafe.getObject(t, j3));
                        if (i9 > 0) {
                            break;
                        } else {
                            continue;
                            i13 += 3;
                            i10 = 267386880;
                        }
                    case 49:
                        i8 = dg.b(i16, a(t, j3), a(i13));
                        break;
                    case 50:
                        i8 = this.s.a(i16, dz.f(t, j3), b(i13));
                        break;
                    case 51:
                        if (!a((cv<T>) t, i16, i13)) {
                            continue;
                            i13 += 3;
                            i10 = 267386880;
                        }
                        i8 = zzqj.zzb(i16, 0.0d);
                        break;
                    case 52:
                        if (!a((cv<T>) t, i16, i13)) {
                            continue;
                            i13 += 3;
                            i10 = 267386880;
                        }
                        i8 = zzqj.zzb(i16, 0.0f);
                        break;
                    case 53:
                        if (a((cv<T>) t, i16, i13)) {
                            b2 = e(t, j3);
                            i8 = zzqj.zzd(i16, b2);
                            break;
                        } else {
                            continue;
                            i13 += 3;
                            i10 = 267386880;
                        }
                    case 54:
                        if (a((cv<T>) t, i16, i13)) {
                            b3 = e(t, j3);
                            i8 = zzqj.zze(i16, b3);
                            break;
                        } else {
                            continue;
                            i13 += 3;
                            i10 = 267386880;
                        }
                    case 55:
                        if (a((cv<T>) t, i16, i13)) {
                            a2 = d(t, j3);
                            i8 = zzqj.zzi(i16, a2);
                            break;
                        } else {
                            continue;
                            i13 += 3;
                            i10 = 267386880;
                        }
                    case 56:
                        if (!a((cv<T>) t, i16, i13)) {
                            continue;
                            i13 += 3;
                            i10 = 267386880;
                        }
                        i8 = zzqj.zzg(i16, 0L);
                        break;
                    case 57:
                        if (!a((cv<T>) t, i16, i13)) {
                            continue;
                            i13 += 3;
                            i10 = 267386880;
                        }
                        i8 = zzqj.zzl(i16, 0);
                        break;
                    case 58:
                        if (!a((cv<T>) t, i16, i13)) {
                            continue;
                            i13 += 3;
                            i10 = 267386880;
                        }
                        i8 = zzqj.zzc(i16, true);
                        break;
                    case 59:
                        if (a((cv<T>) t, i16, i13)) {
                            f = dz.f(t, j3);
                            break;
                        } else {
                            continue;
                            i13 += 3;
                            i10 = 267386880;
                        }
                    case 60:
                        if (!a((cv<T>) t, i16, i13)) {
                            continue;
                            i13 += 3;
                            i10 = 267386880;
                        }
                        i8 = dg.a(i16, dz.f(t, j3), a(i13));
                        break;
                    case 61:
                        if (!a((cv<T>) t, i16, i13)) {
                            continue;
                            i13 += 3;
                            i10 = 267386880;
                        }
                        f = dz.f(t, j3);
                        i8 = zzqj.zzc(i16, (zzps) f);
                        break;
                    case 62:
                        if (a((cv<T>) t, i16, i13)) {
                            a3 = d(t, j3);
                            i8 = zzqj.zzj(i16, a3);
                            break;
                        } else {
                            continue;
                            i13 += 3;
                            i10 = 267386880;
                        }
                    case 63:
                        if (a((cv<T>) t, i16, i13)) {
                            a4 = d(t, j3);
                            i8 = zzqj.zzn(i16, a4);
                            break;
                        } else {
                            continue;
                            i13 += 3;
                            i10 = 267386880;
                        }
                    case 64:
                        if (!a((cv<T>) t, i16, i13)) {
                            continue;
                            i13 += 3;
                            i10 = 267386880;
                        }
                        i8 = zzqj.zzm(i16, 0);
                        break;
                    case 65:
                        if (!a((cv<T>) t, i16, i13)) {
                            continue;
                            i13 += 3;
                            i10 = 267386880;
                        }
                        i8 = zzqj.zzh(i16, 0L);
                        break;
                    case 66:
                        if (a((cv<T>) t, i16, i13)) {
                            a5 = d(t, j3);
                            i8 = zzqj.zzk(i16, a5);
                            break;
                        } else {
                            continue;
                            i13 += 3;
                            i10 = 267386880;
                        }
                    case 67:
                        if (a((cv<T>) t, i16, i13)) {
                            b4 = e(t, j3);
                            i8 = zzqj.zzf(i16, b4);
                            break;
                        } else {
                            continue;
                            i13 += 3;
                            i10 = 267386880;
                        }
                    case 68:
                        if (!a((cv<T>) t, i16, i13)) {
                            continue;
                            i13 += 3;
                            i10 = 267386880;
                        }
                        i8 = zzqj.c(i16, (zzsk) dz.f(t, j3), a(i13));
                        break;
                    default:
                        i13 += 3;
                        i10 = 267386880;
                }
                i14 += i8;
                i13 += 3;
                i10 = 267386880;
            }
            return i14 + a((dv) this.q, (Object) t);
        }
        Unsafe unsafe2 = b;
        int i18 = 0;
        int i19 = 0;
        int i20 = -1;
        int i21 = 0;
        while (i18 < this.c.length) {
            int d2 = d(i18);
            int[] iArr = this.c;
            int i22 = iArr[i18];
            int i23 = (d2 & 267386880) >>> 20;
            if (i23 <= 17) {
                i = iArr[i18 + 2];
                int i24 = i & i11;
                i2 = i12 << (i >>> 20);
                if (i24 != i20) {
                    i21 = unsafe2.getInt(t, i24);
                } else {
                    i24 = i20;
                }
                i20 = i24;
            } else {
                i = (!this.k || i23 < zzqw.DOUBLE_LIST_PACKED.id() || i23 > zzqw.SINT64_LIST_PACKED.id()) ? 0 : this.c[i18 + 2] & i11;
                i2 = 0;
            }
            long j4 = d2 & i11;
            switch (i23) {
                case 0:
                    j = 0;
                    if ((i21 & i2) != 0) {
                        i19 += zzqj.zzb(i22, 0.0d);
                        continue;
                        i18 += 3;
                        i11 = 1048575;
                        i12 = 1;
                    }
                    break;
                case 1:
                    j = 0;
                    if ((i21 & i2) != 0) {
                        i19 += zzqj.zzb(i22, 0.0f);
                        break;
                    }
                    break;
                case 2:
                    j = 0;
                    if ((i21 & i2) != 0) {
                        zzd = zzqj.zzd(i22, unsafe2.getLong(t, j4));
                        i19 += zzd;
                        break;
                    }
                    break;
                case 3:
                    j = 0;
                    if ((i21 & i2) != 0) {
                        zzd = zzqj.zze(i22, unsafe2.getLong(t, j4));
                        i19 += zzd;
                        break;
                    }
                    break;
                case 4:
                    j = 0;
                    if ((i21 & i2) != 0) {
                        zzd = zzqj.zzi(i22, unsafe2.getInt(t, j4));
                        i19 += zzd;
                        break;
                    }
                    break;
                case 5:
                    if ((i21 & i2) != 0) {
                        j = 0;
                        zzd = zzqj.zzg(i22, 0L);
                        i19 += zzd;
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 6:
                    if ((i21 & i2) != 0) {
                        i19 += zzqj.zzl(i22, 0);
                    }
                    j = 0;
                    i18 += 3;
                    i11 = 1048575;
                    i12 = 1;
                case 7:
                    if ((i21 & i2) != 0) {
                        i19 += zzqj.zzc(i22, true);
                        j = 0;
                        i18 += 3;
                        i11 = 1048575;
                        i12 = 1;
                    }
                    j = 0;
                    i18 += 3;
                    i11 = 1048575;
                    i12 = 1;
                case 8:
                    if ((i21 & i2) != 0) {
                        object = unsafe2.getObject(t, j4);
                        break;
                    }
                    j = 0;
                    i18 += 3;
                    i11 = 1048575;
                    i12 = 1;
                case 9:
                    break;
                case 10:
                    break;
                case 11:
                    if ((i21 & i2) != 0) {
                        i3 = unsafe2.getInt(t, j4);
                        i6 = zzqj.zzj(i22, i3);
                        i19 += i6;
                    }
                    j = 0;
                    i18 += 3;
                    i11 = 1048575;
                    i12 = 1;
                case 12:
                    if ((i21 & i2) != 0) {
                        i4 = unsafe2.getInt(t, j4);
                        i6 = zzqj.zzn(i22, i4);
                        i19 += i6;
                    }
                    j = 0;
                    i18 += 3;
                    i11 = 1048575;
                    i12 = 1;
                case 13:
                    break;
                case 14:
                    break;
                case 15:
                    if ((i21 & i2) != 0) {
                        i5 = unsafe2.getInt(t, j4);
                        i6 = zzqj.zzk(i22, i5);
                        i19 += i6;
                    }
                    j = 0;
                    i18 += 3;
                    i11 = 1048575;
                    i12 = 1;
                case 16:
                    if ((i21 & i2) != 0) {
                        j2 = unsafe2.getLong(t, j4);
                        i6 = zzqj.zzf(i22, j2);
                        i19 += i6;
                    }
                    j = 0;
                    i18 += 3;
                    i11 = 1048575;
                    i12 = 1;
                case 17:
                    break;
                case 18:
                    i6 = dg.i(i22, (List) unsafe2.getObject(t, j4), false);
                    i19 += i6;
                    j = 0;
                    i18 += 3;
                    i11 = 1048575;
                    i12 = 1;
                case 19:
                case 24:
                case 31:
                    h = dg.h(i22, (List) unsafe2.getObject(t, j4), false);
                    i19 += h;
                    j = 0;
                    i18 += 3;
                    i11 = 1048575;
                    i12 = 1;
                case 20:
                    h = dg.a(i22, (List<Long>) unsafe2.getObject(t, j4), false);
                    i19 += h;
                    j = 0;
                    i18 += 3;
                    i11 = 1048575;
                    i12 = 1;
                case 21:
                    h = dg.b(i22, (List<Long>) unsafe2.getObject(t, j4), false);
                    i19 += h;
                    j = 0;
                    i18 += 3;
                    i11 = 1048575;
                    i12 = 1;
                case 22:
                    h = dg.e(i22, (List) unsafe2.getObject(t, j4), false);
                    i19 += h;
                    j = 0;
                    i18 += 3;
                    i11 = 1048575;
                    i12 = 1;
                case 23:
                case 32:
                    h = dg.i(i22, (List) unsafe2.getObject(t, j4), false);
                    i19 += h;
                    j = 0;
                    i18 += 3;
                    i11 = 1048575;
                    i12 = 1;
                case 25:
                    h = dg.j(i22, (List) unsafe2.getObject(t, j4), false);
                    i19 += h;
                    j = 0;
                    i18 += 3;
                    i11 = 1048575;
                    i12 = 1;
                case 26:
                    i6 = dg.a(i22, (List) unsafe2.getObject(t, j4));
                    i19 += i6;
                    j = 0;
                    i18 += 3;
                    i11 = 1048575;
                    i12 = 1;
                case 27:
                    i6 = dg.a(i22, (List<?>) unsafe2.getObject(t, j4), a(i18));
                    i19 += i6;
                    j = 0;
                    i18 += 3;
                    i11 = 1048575;
                    i12 = 1;
                case 28:
                    i6 = dg.b(i22, (List) unsafe2.getObject(t, j4));
                    i19 += i6;
                    j = 0;
                    i18 += 3;
                    i11 = 1048575;
                    i12 = 1;
                case 29:
                    i6 = dg.f(i22, (List) unsafe2.getObject(t, j4), false);
                    i19 += i6;
                    j = 0;
                    i18 += 3;
                    i11 = 1048575;
                    i12 = 1;
                case 30:
                    h = dg.d(i22, (List) unsafe2.getObject(t, j4), false);
                    i19 += h;
                    j = 0;
                    i18 += 3;
                    i11 = 1048575;
                    i12 = 1;
                case 33:
                    h = dg.g(i22, (List) unsafe2.getObject(t, j4), false);
                    i19 += h;
                    j = 0;
                    i18 += 3;
                    i11 = 1048575;
                    i12 = 1;
                case 34:
                    h = dg.c(i22, (List) unsafe2.getObject(t, j4), false);
                    i19 += h;
                    j = 0;
                    i18 += 3;
                    i11 = 1048575;
                    i12 = 1;
                case 35:
                    i7 = dg.i((List) unsafe2.getObject(t, j4));
                    if (i7 > 0) {
                        break;
                    }
                    j = 0;
                    i18 += 3;
                    i11 = 1048575;
                    i12 = 1;
                case 36:
                    i7 = dg.h((List) unsafe2.getObject(t, j4));
                    if (i7 > 0) {
                        break;
                    }
                    j = 0;
                    i18 += 3;
                    i11 = 1048575;
                    i12 = 1;
                case 37:
                    i7 = dg.a((List) unsafe2.getObject(t, j4));
                    if (i7 > 0) {
                        break;
                    }
                    j = 0;
                    i18 += 3;
                    i11 = 1048575;
                    i12 = 1;
                case 38:
                    i7 = dg.b((List) unsafe2.getObject(t, j4));
                    if (i7 > 0) {
                        break;
                    }
                    j = 0;
                    i18 += 3;
                    i11 = 1048575;
                    i12 = 1;
                case 39:
                    i7 = dg.e((List) unsafe2.getObject(t, j4));
                    if (i7 > 0) {
                        break;
                    }
                    j = 0;
                    i18 += 3;
                    i11 = 1048575;
                    i12 = 1;
                case 40:
                    i7 = dg.i((List) unsafe2.getObject(t, j4));
                    if (i7 > 0) {
                        break;
                    }
                    j = 0;
                    i18 += 3;
                    i11 = 1048575;
                    i12 = 1;
                case 41:
                    i7 = dg.h((List) unsafe2.getObject(t, j4));
                    if (i7 > 0) {
                        break;
                    }
                    j = 0;
                    i18 += 3;
                    i11 = 1048575;
                    i12 = 1;
                case 42:
                    i7 = dg.j((List) unsafe2.getObject(t, j4));
                    if (i7 > 0) {
                        break;
                    }
                    j = 0;
                    i18 += 3;
                    i11 = 1048575;
                    i12 = 1;
                case 43:
                    i7 = dg.f((List) unsafe2.getObject(t, j4));
                    if (i7 > 0) {
                        break;
                    }
                    j = 0;
                    i18 += 3;
                    i11 = 1048575;
                    i12 = 1;
                case 44:
                    i7 = dg.d((List) unsafe2.getObject(t, j4));
                    if (i7 > 0) {
                        break;
                    }
                    j = 0;
                    i18 += 3;
                    i11 = 1048575;
                    i12 = 1;
                case 45:
                    i7 = dg.h((List) unsafe2.getObject(t, j4));
                    if (i7 > 0) {
                        break;
                    }
                    j = 0;
                    i18 += 3;
                    i11 = 1048575;
                    i12 = 1;
                case 46:
                    i7 = dg.i((List) unsafe2.getObject(t, j4));
                    if (i7 > 0) {
                        break;
                    }
                    j = 0;
                    i18 += 3;
                    i11 = 1048575;
                    i12 = 1;
                case 47:
                    i7 = dg.g((List) unsafe2.getObject(t, j4));
                    if (i7 > 0) {
                        break;
                    }
                    j = 0;
                    i18 += 3;
                    i11 = 1048575;
                    i12 = 1;
                case 48:
                    i7 = dg.c((List) unsafe2.getObject(t, j4));
                    if (i7 > 0) {
                        break;
                    }
                    j = 0;
                    i18 += 3;
                    i11 = 1048575;
                    i12 = 1;
                case 49:
                    i6 = dg.b(i22, (List) unsafe2.getObject(t, j4), a(i18));
                    i19 += i6;
                    j = 0;
                    i18 += 3;
                    i11 = 1048575;
                    i12 = 1;
                case 50:
                    i6 = this.s.a(i22, unsafe2.getObject(t, j4), b(i18));
                    i19 += i6;
                    j = 0;
                    i18 += 3;
                    i11 = 1048575;
                    i12 = 1;
                case 51:
                    if (a((cv<T>) t, i22, i18)) {
                        i6 = zzqj.zzb(i22, 0.0d);
                        i19 += i6;
                    }
                    j = 0;
                    i18 += 3;
                    i11 = 1048575;
                    i12 = 1;
                case 52:
                    if (a((cv<T>) t, i22, i18)) {
                        zzbb = zzqj.zzb(i22, 0.0f);
                        i19 += zzbb;
                    }
                    j = 0;
                    i18 += 3;
                    i11 = 1048575;
                    i12 = 1;
                case 53:
                    if (a((cv<T>) t, i22, i18)) {
                        i6 = zzqj.zzd(i22, e(t, j4));
                        i19 += i6;
                    }
                    j = 0;
                    i18 += 3;
                    i11 = 1048575;
                    i12 = 1;
                case 54:
                    if (a((cv<T>) t, i22, i18)) {
                        i6 = zzqj.zze(i22, e(t, j4));
                        i19 += i6;
                    }
                    j = 0;
                    i18 += 3;
                    i11 = 1048575;
                    i12 = 1;
                case 55:
                    if (a((cv<T>) t, i22, i18)) {
                        i6 = zzqj.zzi(i22, d(t, j4));
                        i19 += i6;
                    }
                    j = 0;
                    i18 += 3;
                    i11 = 1048575;
                    i12 = 1;
                case 56:
                    if (a((cv<T>) t, i22, i18)) {
                        i6 = zzqj.zzg(i22, 0L);
                        i19 += i6;
                    }
                    j = 0;
                    i18 += 3;
                    i11 = 1048575;
                    i12 = 1;
                case 57:
                    if (a((cv<T>) t, i22, i18)) {
                        zzbb = zzqj.zzl(i22, 0);
                        i19 += zzbb;
                    }
                    j = 0;
                    i18 += 3;
                    i11 = 1048575;
                    i12 = 1;
                case 58:
                    if (a((cv<T>) t, i22, i18)) {
                        zzbb = zzqj.zzc(i22, true);
                        i19 += zzbb;
                    }
                    j = 0;
                    i18 += 3;
                    i11 = 1048575;
                    i12 = 1;
                case 59:
                    if (a((cv<T>) t, i22, i18)) {
                        object = unsafe2.getObject(t, j4);
                        break;
                    }
                    j = 0;
                    i18 += 3;
                    i11 = 1048575;
                    i12 = 1;
                case 60:
                    break;
                case 61:
                    break;
                case 62:
                    if (a((cv<T>) t, i22, i18)) {
                        i3 = d(t, j4);
                        i6 = zzqj.zzj(i22, i3);
                        i19 += i6;
                    }
                    j = 0;
                    i18 += 3;
                    i11 = 1048575;
                    i12 = 1;
                case 63:
                    if (a((cv<T>) t, i22, i18)) {
                        i4 = d(t, j4);
                        i6 = zzqj.zzn(i22, i4);
                        i19 += i6;
                    }
                    j = 0;
                    i18 += 3;
                    i11 = 1048575;
                    i12 = 1;
                case 64:
                    break;
                case 65:
                    break;
                case 66:
                    if (a((cv<T>) t, i22, i18)) {
                        i5 = d(t, j4);
                        i6 = zzqj.zzk(i22, i5);
                        i19 += i6;
                    }
                    j = 0;
                    i18 += 3;
                    i11 = 1048575;
                    i12 = 1;
                case 67:
                    if (a((cv<T>) t, i22, i18)) {
                        j2 = e(t, j4);
                        i6 = zzqj.zzf(i22, j2);
                        i19 += i6;
                    }
                    j = 0;
                    i18 += 3;
                    i11 = 1048575;
                    i12 = 1;
                case 68:
                    break;
                default:
                    j = 0;
                    i18 += 3;
                    i11 = 1048575;
                    i12 = 1;
            }
            i18 += 3;
            i11 = 1048575;
            i12 = 1;
        }
        int a6 = i19 + a((dv) this.q, (Object) t);
        if (!this.h) {
            return a6;
        }
        bv<?> a7 = this.r.a(t);
        int i25 = 0;
        for (int i26 = 0; i26 < a7.a.c(); i26++) {
            Map.Entry<?, Object> b5 = a7.a.b(i26);
            i25 += bv.a((zzqv) b5.getKey(), b5.getValue());
        }
        for (Map.Entry<?, Object> entry : a7.a.d()) {
            i25 += bv.a((zzqv) entry.getKey(), entry.getValue());
        }
        return a6 + i25;
    }

    @Override // com.google.android.gms.internal.gtm.de
    public final void b(T t, T t2) {
        if (t2 != null) {
            for (int i = 0; i < this.c.length; i += 3) {
                int d = d(i);
                long j = 1048575 & d;
                int i2 = this.c[i];
                switch ((d & 267386880) >>> 20) {
                    case 0:
                        if (a((cv<T>) t2, i)) {
                            dz.a(t, j, dz.e(t2, j));
                            b((cv<T>) t, i);
                            break;
                        } else {
                            break;
                        }
                    case 1:
                        if (a((cv<T>) t2, i)) {
                            dz.a((Object) t, j, dz.d(t2, j));
                            b((cv<T>) t, i);
                            break;
                        } else {
                            break;
                        }
                    case 2:
                        if (!a((cv<T>) t2, i)) {
                            break;
                        }
                        dz.a((Object) t, j, dz.b(t2, j));
                        b((cv<T>) t, i);
                        break;
                    case 3:
                        if (!a((cv<T>) t2, i)) {
                            break;
                        }
                        dz.a((Object) t, j, dz.b(t2, j));
                        b((cv<T>) t, i);
                        break;
                    case 4:
                        if (!a((cv<T>) t2, i)) {
                            break;
                        }
                        dz.a((Object) t, j, dz.a(t2, j));
                        b((cv<T>) t, i);
                        break;
                    case 5:
                        if (!a((cv<T>) t2, i)) {
                            break;
                        }
                        dz.a((Object) t, j, dz.b(t2, j));
                        b((cv<T>) t, i);
                        break;
                    case 6:
                        if (!a((cv<T>) t2, i)) {
                            break;
                        }
                        dz.a((Object) t, j, dz.a(t2, j));
                        b((cv<T>) t, i);
                        break;
                    case 7:
                        if (a((cv<T>) t2, i)) {
                            dz.a(t, j, dz.c(t2, j));
                            b((cv<T>) t, i);
                            break;
                        } else {
                            break;
                        }
                    case 8:
                        if (!a((cv<T>) t2, i)) {
                            break;
                        }
                        dz.a(t, j, dz.f(t2, j));
                        b((cv<T>) t, i);
                        break;
                    case 9:
                    case 17:
                        a(t, t2, i);
                        break;
                    case 10:
                        if (!a((cv<T>) t2, i)) {
                            break;
                        }
                        dz.a(t, j, dz.f(t2, j));
                        b((cv<T>) t, i);
                        break;
                    case 11:
                        if (!a((cv<T>) t2, i)) {
                            break;
                        }
                        dz.a((Object) t, j, dz.a(t2, j));
                        b((cv<T>) t, i);
                        break;
                    case 12:
                        if (!a((cv<T>) t2, i)) {
                            break;
                        }
                        dz.a((Object) t, j, dz.a(t2, j));
                        b((cv<T>) t, i);
                        break;
                    case 13:
                        if (!a((cv<T>) t2, i)) {
                            break;
                        }
                        dz.a((Object) t, j, dz.a(t2, j));
                        b((cv<T>) t, i);
                        break;
                    case 14:
                        if (!a((cv<T>) t2, i)) {
                            break;
                        }
                        dz.a((Object) t, j, dz.b(t2, j));
                        b((cv<T>) t, i);
                        break;
                    case 15:
                        if (!a((cv<T>) t2, i)) {
                            break;
                        }
                        dz.a((Object) t, j, dz.a(t2, j));
                        b((cv<T>) t, i);
                        break;
                    case 16:
                        if (!a((cv<T>) t2, i)) {
                            break;
                        }
                        dz.a((Object) t, j, dz.b(t2, j));
                        b((cv<T>) t, i);
                        break;
                    case 18:
                    case 19:
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                    case 24:
                    case 25:
                    case 26:
                    case 27:
                    case 28:
                    case 29:
                    case 30:
                    case 31:
                    case 32:
                    case 33:
                    case 34:
                    case 35:
                    case 36:
                    case 37:
                    case 38:
                    case 39:
                    case 40:
                    case 41:
                    case 42:
                    case 43:
                    case 44:
                    case 45:
                    case 46:
                    case 47:
                    case 48:
                    case 49:
                        this.p.a(t, t2, j);
                        break;
                    case 50:
                        dg.a(this.s, t, t2, j);
                        break;
                    case 51:
                    case 52:
                    case 53:
                    case 54:
                    case 55:
                    case 56:
                    case 57:
                    case 58:
                    case 59:
                        if (!a((cv<T>) t2, i2, i)) {
                            break;
                        }
                        dz.a(t, j, dz.f(t2, j));
                        b((cv<T>) t, i2, i);
                        break;
                    case 60:
                    case 68:
                        b(t, t2, i);
                        break;
                    case 61:
                    case 62:
                    case 63:
                    case 64:
                    case 65:
                    case 66:
                    case 67:
                        if (!a((cv<T>) t2, i2, i)) {
                            break;
                        }
                        dz.a(t, j, dz.f(t2, j));
                        b((cv<T>) t, i2, i);
                        break;
                }
            }
            if (this.j) {
                return;
            }
            dg.a(this.q, t, t2);
            if (!this.h) {
                return;
            }
            dg.a(this.r, t, t2);
            return;
        }
        throw new NullPointerException();
    }

    @Override // com.google.android.gms.internal.gtm.de
    public final void c(T t) {
        int i;
        int i2 = this.m;
        while (true) {
            i = this.n;
            if (i2 >= i) {
                break;
            }
            long d = d(this.l[i2]) & 1048575;
            Object f = dz.f(t, d);
            if (f != null) {
                dz.a(t, d, this.s.d(f));
            }
            i2++;
        }
        int length = this.l.length;
        while (i < length) {
            this.p.b(t, this.l[i]);
            i++;
        }
        this.q.d(t);
        if (this.h) {
            this.r.c(t);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:86:0x0104, code lost:
        continue;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v12 */
    /* JADX WARN: Type inference failed for: r4v14, types: [com.google.android.gms.internal.gtm.de] */
    /* JADX WARN: Type inference failed for: r4v17 */
    /* JADX WARN: Type inference failed for: r4v5, types: [com.google.android.gms.internal.gtm.de] */
    @Override // com.google.android.gms.internal.gtm.de
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean d(T t) {
        int i;
        int i2 = 0;
        int i3 = -1;
        int i4 = 0;
        while (true) {
            boolean z = true;
            if (i2 >= this.m) {
                return !this.h || this.r.a(t).f();
            }
            int i5 = this.l[i2];
            int i6 = this.c[i5];
            int d = d(i5);
            if (!this.j) {
                int i7 = this.c[i5 + 2];
                int i8 = i7 & 1048575;
                i = 1 << (i7 >>> 20);
                if (i8 != i3) {
                    i4 = b.getInt(t, i8);
                    i3 = i8;
                }
            } else {
                i = 0;
            }
            if (((268435456 & d) != 0) && !a((cv<T>) t, i5, i4, i)) {
                return false;
            }
            int i9 = (267386880 & d) >>> 20;
            if (i9 != 9 && i9 != 17) {
                if (i9 != 27) {
                    if (i9 != 60 && i9 != 68) {
                        switch (i9) {
                            case 50:
                                Map<?, ?> b2 = this.s.b(dz.f(t, d & 1048575));
                                if (!b2.isEmpty()) {
                                    if (this.s.f(b(i5)).c.zzrs() == zzul.MESSAGE) {
                                        de<T> deVar = 0;
                                        Iterator<?> it = b2.values().iterator();
                                        while (true) {
                                            if (it.hasNext()) {
                                                Object next = it.next();
                                                if (deVar == null) {
                                                    deVar = db.a().a((Class) next.getClass());
                                                }
                                                boolean d2 = deVar.d(next);
                                                deVar = deVar;
                                                if (!d2) {
                                                    z = false;
                                                }
                                            }
                                        }
                                    }
                                }
                                if (z) {
                                    break;
                                } else {
                                    return false;
                                }
                        }
                    } else if (a((cv<T>) t, i6, i5) && !a(t, d, a(i5))) {
                        return false;
                    }
                }
                List list = (List) dz.f(t, d & 1048575);
                if (!list.isEmpty()) {
                    ?? a2 = a(i5);
                    int i10 = 0;
                    while (true) {
                        if (i10 < list.size()) {
                            if (!a2.d(list.get(i10))) {
                                z = false;
                            } else {
                                i10++;
                            }
                        }
                    }
                }
                if (!z) {
                    return false;
                }
            } else if (a((cv<T>) t, i5, i4, i) && !a(t, d, a(i5))) {
                return false;
            }
            i2++;
        }
    }
}
