package com.google.android.gms.internal.gtm;

/* loaded from: classes.dex */
public final class zzsc<K, V> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static <K, V> int a(co<K, V> coVar, K k, V v) {
        return bv.a(coVar.a, 1, k) + bv.a(coVar.c, 2, v);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <K, V> void a(zzqj zzqjVar, co<K, V> coVar, K k, V v) {
        bv.a(zzqjVar, coVar.a, 1, k);
        bv.a(zzqjVar, coVar.c, 2, v);
    }
}
