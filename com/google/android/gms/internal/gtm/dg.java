package com.google.android.gms.internal.gtm;

import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class dg {
    private static final Class<?> a = d();
    private static final dv<?, ?> b = a(false);
    private static final dv<?, ?> c = a(true);
    private static final dv<?, ?> d = new dw();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(int i, Object obj, de deVar) {
        return obj instanceof zzrr ? zzqj.zza(i, (zzrr) obj) : zzqj.b(i, (zzsk) obj, deVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(int i, List<?> list) {
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        int zzbb = zzqj.zzbb(i) * size;
        if (list instanceof zzrt) {
            zzrt zzrtVar = (zzrt) list;
            while (i2 < size) {
                Object zzbn = zzrtVar.zzbn(i2);
                zzbb += zzbn instanceof zzps ? zzqj.zzb((zzps) zzbn) : zzqj.zzda((String) zzbn);
                i2++;
            }
        } else {
            while (i2 < size) {
                Object obj = list.get(i2);
                zzbb += obj instanceof zzps ? zzqj.zzb((zzps) obj) : zzqj.zzda((String) obj);
                i2++;
            }
        }
        return zzbb;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(int i, List<?> list, de deVar) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int zzbb = zzqj.zzbb(i) * size;
        for (int i2 = 0; i2 < size; i2++) {
            Object obj = list.get(i2);
            zzbb += obj instanceof zzrr ? zzqj.zza((zzrr) obj) : zzqj.b((zzsk) obj, deVar);
        }
        return zzbb;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(int i, List<Long> list, boolean z) {
        if (list.size() == 0) {
            return 0;
        }
        return a(list) + (list.size() * zzqj.zzbb(i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof ck) {
            ck ckVar = (ck) list;
            i = 0;
            while (i2 < size) {
                i += zzqj.zzs(ckVar.a(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zzqj.zzs(list.get(i2).longValue());
                i2++;
            }
        }
        return i;
    }

    public static dv<?, ?> a() {
        return b;
    }

    private static dv<?, ?> a(boolean z) {
        try {
            Class<?> e = e();
            if (e != null) {
                return (dv) e.getConstructor(Boolean.TYPE).newInstance(Boolean.valueOf(z));
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <UT, UB> UB a(int i, int i2, UB ub, dv<UT, UB> dvVar) {
        if (ub == null) {
            ub = dvVar.a();
        }
        dvVar.a((dv<UT, UB>) ub, i, i2);
        return ub;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <UT, UB> UB a(int i, List<Integer> list, zzrh zzrhVar, UB ub, dv<UT, UB> dvVar) {
        UB ub2;
        int intValue;
        if (zzrhVar == null) {
            return ub;
        }
        if (list instanceof RandomAccess) {
            int size = list.size();
            ub2 = ub;
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                int intValue2 = list.get(i3).intValue();
                if (zzrhVar.zzb(intValue2)) {
                    if (i3 != i2) {
                        list.set(i2, Integer.valueOf(intValue2));
                    }
                    i2++;
                } else {
                    ub2 = (UB) a(i, intValue2, ub2, dvVar);
                }
            }
            if (i2 != size) {
                list.subList(i2, size).clear();
            }
        } else {
            Iterator<Integer> it = list.iterator();
            loop1: while (true) {
                ub2 = ub;
                while (it.hasNext()) {
                    intValue = it.next().intValue();
                    if (!zzrhVar.zzb(intValue)) {
                        break;
                    }
                }
                ub = (UB) a(i, intValue, ub2, dvVar);
                it.remove();
            }
        }
        return ub2;
    }

    public static void a(int i, List<String> list, em emVar) {
        if (list == null || list.isEmpty()) {
            return;
        }
        emVar.a(i, list);
    }

    public static void a(int i, List<?> list, em emVar, de deVar) {
        if (list == null || list.isEmpty()) {
            return;
        }
        emVar.a(i, list, deVar);
    }

    public static void a(int i, List<Double> list, em emVar, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        emVar.g(i, list, z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T, FT extends zzqv<FT>> void a(bs<FT> bsVar, T t, T t2) {
        bv<FT> a2 = bsVar.a(t2);
        if (!a2.a.isEmpty()) {
            bsVar.b(t).a(a2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> void a(cp cpVar, T t, T t2, long j) {
        dz.a(t, j, cpVar.a(dz.f(t, j), dz.f(t2, j)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T, UT, UB> void a(dv<UT, UB> dvVar, T t, T t2) {
        dvVar.a(t, dvVar.c(dvVar.b(t), dvVar.b(t2)));
    }

    public static void a(Class<?> cls) {
        Class<?> cls2;
        if (zzrc.class.isAssignableFrom(cls) || (cls2 = a) == null || cls2.isAssignableFrom(cls)) {
            return;
        }
        throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int b(int i, List<zzps> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int zzbb = size * zzqj.zzbb(i);
        for (int i2 = 0; i2 < list.size(); i2++) {
            zzbb += zzqj.zzb(list.get(i2));
        }
        return zzbb;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int b(int i, List<zzsk> list, de deVar) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            i2 += zzqj.c(i, list.get(i3), deVar);
        }
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int b(int i, List<Long> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return b(list) + (size * zzqj.zzbb(i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int b(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof ck) {
            ck ckVar = (ck) list;
            i = 0;
            while (i2 < size) {
                i += zzqj.zzt(ckVar.a(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zzqj.zzt(list.get(i2).longValue());
                i2++;
            }
        }
        return i;
    }

    public static dv<?, ?> b() {
        return c;
    }

    public static void b(int i, List<zzps> list, em emVar) {
        if (list == null || list.isEmpty()) {
            return;
        }
        emVar.b(i, list);
    }

    public static void b(int i, List<?> list, em emVar, de deVar) {
        if (list == null || list.isEmpty()) {
            return;
        }
        emVar.b(i, list, deVar);
    }

    public static void b(int i, List<Float> list, em emVar, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        emVar.f(i, list, z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int c(int i, List<Long> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return c(list) + (size * zzqj.zzbb(i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int c(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof ck) {
            ck ckVar = (ck) list;
            i = 0;
            while (i2 < size) {
                i += zzqj.zzu(ckVar.a(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zzqj.zzu(list.get(i2).longValue());
                i2++;
            }
        }
        return i;
    }

    public static dv<?, ?> c() {
        return d;
    }

    public static void c(int i, List<Long> list, em emVar, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        emVar.c(i, list, z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int d(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return d(list) + (size * zzqj.zzbb(i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int d(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof cc) {
            cc ccVar = (cc) list;
            i = 0;
            while (i2 < size) {
                i += zzqj.zzbh(ccVar.a(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zzqj.zzbh(list.get(i2).intValue());
                i2++;
            }
        }
        return i;
    }

    private static Class<?> d() {
        try {
            return Class.forName("com.google.protobuf.GeneratedMessage");
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void d(int i, List<Long> list, em emVar, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        emVar.d(i, list, z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int e(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return e(list) + (size * zzqj.zzbb(i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int e(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof cc) {
            cc ccVar = (cc) list;
            i = 0;
            while (i2 < size) {
                i += zzqj.zzbc(ccVar.a(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zzqj.zzbc(list.get(i2).intValue());
                i2++;
            }
        }
        return i;
    }

    private static Class<?> e() {
        try {
            return Class.forName("com.google.protobuf.UnknownFieldSetSchema");
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void e(int i, List<Long> list, em emVar, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        emVar.n(i, list, z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int f(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return f(list) + (size * zzqj.zzbb(i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int f(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof cc) {
            cc ccVar = (cc) list;
            i = 0;
            while (i2 < size) {
                i += zzqj.zzbd(ccVar.a(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zzqj.zzbd(list.get(i2).intValue());
                i2++;
            }
        }
        return i;
    }

    public static void f(int i, List<Long> list, em emVar, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        emVar.e(i, list, z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int g(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return g(list) + (size * zzqj.zzbb(i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int g(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof cc) {
            cc ccVar = (cc) list;
            i = 0;
            while (i2 < size) {
                i += zzqj.zzbe(ccVar.a(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zzqj.zzbe(list.get(i2).intValue());
                i2++;
            }
        }
        return i;
    }

    public static void g(int i, List<Long> list, em emVar, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        emVar.l(i, list, z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int h(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzqj.zzl(i, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int h(List<?> list) {
        return list.size() << 2;
    }

    public static void h(int i, List<Integer> list, em emVar, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        emVar.a(i, list, z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int i(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzqj.zzg(i, 0L);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int i(List<?> list) {
        return list.size() << 3;
    }

    public static void i(int i, List<Integer> list, em emVar, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        emVar.j(i, list, z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int j(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzqj.zzc(i, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int j(List<?> list) {
        return list.size();
    }

    public static void j(int i, List<Integer> list, em emVar, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        emVar.m(i, list, z);
    }

    public static void k(int i, List<Integer> list, em emVar, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        emVar.b(i, list, z);
    }

    public static void l(int i, List<Integer> list, em emVar, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        emVar.k(i, list, z);
    }

    public static void m(int i, List<Integer> list, em emVar, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        emVar.h(i, list, z);
    }

    public static void n(int i, List<Boolean> list, em emVar, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        emVar.i(i, list, z);
    }
}
