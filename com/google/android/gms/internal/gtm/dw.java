package com.google.android.gms.internal.gtm;

/* loaded from: classes.dex */
final class dw extends dv<zzts, zzts> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(Object obj, zzts zztsVar) {
        ((zzrc) obj).zzbak = zztsVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.gtm.dv
    public final /* synthetic */ zzts a() {
        return zzts.a();
    }

    @Override // com.google.android.gms.internal.gtm.dv
    final /* synthetic */ zzts a(zzts zztsVar) {
        zzts zztsVar2 = zztsVar;
        zztsVar2.zzmi();
        return zztsVar2;
    }

    @Override // com.google.android.gms.internal.gtm.dv
    final /* synthetic */ void a(zzts zztsVar, int i, int i2) {
        zztsVar.a((i << 3) | 5, Integer.valueOf(i2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.gtm.dv
    public final /* synthetic */ void a(zzts zztsVar, int i, long j) {
        zztsVar.a(i << 3, Long.valueOf(j));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.gtm.dv
    public final /* synthetic */ void a(zzts zztsVar, int i, zzps zzpsVar) {
        zztsVar.a((i << 3) | 2, zzpsVar);
    }

    @Override // com.google.android.gms.internal.gtm.dv
    final /* synthetic */ void a(zzts zztsVar, int i, zzts zztsVar2) {
        zztsVar.a((i << 3) | 3, zztsVar2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.gtm.dv
    public final /* synthetic */ void a(zzts zztsVar, em emVar) {
        zztsVar.zzb(emVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.gtm.dv
    public final /* synthetic */ void a(Object obj, zzts zztsVar) {
        a2(obj, zztsVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.gtm.dv
    public final boolean a(dd ddVar) {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.gtm.dv
    public final /* synthetic */ zzts b(Object obj) {
        return ((zzrc) obj).zzbak;
    }

    @Override // com.google.android.gms.internal.gtm.dv
    final /* synthetic */ void b(zzts zztsVar, int i, long j) {
        zztsVar.a((i << 3) | 1, Long.valueOf(j));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.gtm.dv
    public final /* synthetic */ void b(zzts zztsVar, em emVar) {
        zztsVar.a(emVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.gtm.dv
    public final /* synthetic */ void b(Object obj, zzts zztsVar) {
        a2(obj, zztsVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.gtm.dv
    public final /* synthetic */ zzts c(Object obj) {
        zzts zztsVar = ((zzrc) obj).zzbak;
        if (zztsVar == zzts.zzrj()) {
            zzts a = zzts.a();
            a2(obj, a);
            return a;
        }
        return zztsVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.gtm.dv
    public final /* synthetic */ zzts c(zzts zztsVar, zzts zztsVar2) {
        zzts zztsVar3 = zztsVar;
        zzts zztsVar4 = zztsVar2;
        return zztsVar4.equals(zzts.zzrj()) ? zztsVar3 : zzts.a(zztsVar3, zztsVar4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.gtm.dv
    public final void d(Object obj) {
        ((zzrc) obj).zzbak.zzmi();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.gtm.dv
    public final /* synthetic */ int e(zzts zztsVar) {
        return zztsVar.zzrl();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.gtm.dv
    public final /* synthetic */ int f(zzts zztsVar) {
        return zztsVar.zzpe();
    }
}
