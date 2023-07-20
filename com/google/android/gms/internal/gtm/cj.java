package com.google.android.gms.internal.gtm;

import java.util.List;

/* loaded from: classes.dex */
final class cj extends cg {
    private cj() {
        super();
    }

    private static <E> zzrj<E> c(Object obj, long j) {
        return (zzrj) dz.f(obj, j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.gtm.cg
    public final <L> List<L> a(Object obj, long j) {
        zzrj c = c(obj, j);
        if (!c.zzmy()) {
            int size = c.size();
            zzrj zzaj = c.zzaj(size == 0 ? 10 : size << 1);
            dz.a(obj, j, zzaj);
            return zzaj;
        }
        return c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [com.google.android.gms.internal.gtm.zzrj] */
    @Override // com.google.android.gms.internal.gtm.cg
    public final <E> void a(Object obj, Object obj2, long j) {
        zzrj<E> c = c(obj, j);
        zzrj<E> c2 = c(obj2, j);
        int size = c.size();
        int size2 = c2.size();
        zzrj<E> zzrjVar = c;
        zzrjVar = c;
        if (size > 0 && size2 > 0) {
            boolean zzmy = c.zzmy();
            zzrj<E> zzrjVar2 = c;
            if (!zzmy) {
                zzrjVar2 = c.zzaj(size2 + size);
            }
            zzrjVar2.addAll(c2);
            zzrjVar = zzrjVar2;
        }
        if (size > 0) {
            c2 = zzrjVar;
        }
        dz.a(obj, j, c2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.gtm.cg
    public final void b(Object obj, long j) {
        c(obj, j).zzmi();
    }
}
