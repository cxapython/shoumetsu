package com.google.android.gms.internal.gtm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
final class ci extends cg {
    private static final Class<?> a = Collections.unmodifiableList(Collections.emptyList()).getClass();

    private ci() {
        super();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static <L> List<L> a(Object obj, long j, int i) {
        List<L> zzaj;
        zzrs zzrsVar;
        List<L> c = c(obj, j);
        if (!c.isEmpty()) {
            if (a.isAssignableFrom(c.getClass())) {
                ArrayList arrayList = new ArrayList(c.size() + i);
                arrayList.addAll(c);
                zzrsVar = arrayList;
            } else if (c instanceof zztu) {
                zzrs zzrsVar2 = new zzrs(c.size() + i);
                zzrsVar2.addAll((zztu) c);
                zzrsVar = zzrsVar2;
            } else if (!(c instanceof da) || !(c instanceof zzrj)) {
                return c;
            } else {
                zzrj zzrjVar = (zzrj) c;
                if (zzrjVar.zzmy()) {
                    return c;
                }
                zzaj = zzrjVar.zzaj(c.size() + i);
            }
            dz.a(obj, j, zzrsVar);
            return zzrsVar;
        }
        zzaj = c instanceof zzrt ? new zzrs(i) : (!(c instanceof da) || !(c instanceof zzrj)) ? new ArrayList<>(i) : ((zzrj) c).zzaj(i);
        dz.a(obj, j, zzaj);
        return zzaj;
    }

    private static <E> List<E> c(Object obj, long j) {
        return (List) dz.f(obj, j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.gtm.cg
    public final <L> List<L> a(Object obj, long j) {
        return a(obj, j, 10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.gtm.cg
    public final <E> void a(Object obj, Object obj2, long j) {
        List c = c(obj2, j);
        List a2 = a(obj, j, c.size());
        int size = a2.size();
        int size2 = c.size();
        if (size > 0 && size2 > 0) {
            a2.addAll(c);
        }
        if (size > 0) {
            c = a2;
        }
        dz.a(obj, j, c);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.gtm.cg
    public final void b(Object obj, long j) {
        Object unmodifiableList;
        List list = (List) dz.f(obj, j);
        if (list instanceof zzrt) {
            unmodifiableList = ((zzrt) list).zzqb();
        } else if (a.isAssignableFrom(list.getClass())) {
            return;
        } else {
            if ((list instanceof da) && (list instanceof zzrj)) {
                zzrj zzrjVar = (zzrj) list;
                if (!zzrjVar.zzmy()) {
                    return;
                }
                zzrjVar.zzmi();
                return;
            }
            unmodifiableList = Collections.unmodifiableList(list);
        }
        dz.a(obj, j, unmodifiableList);
    }
}
