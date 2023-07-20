package com.google.android.gms.internal.gtm;

import com.google.android.gms.internal.gtm.zzrc;
import java.util.Map;

/* loaded from: classes.dex */
final class bt extends bs<Object> {
    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.gtm.bs
    public final int a(Map.Entry<?, ?> entry) {
        entry.getKey();
        throw new NoSuchMethodError();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.gtm.bs
    public final bv<Object> a(Object obj) {
        return ((zzrc.zzc) obj).zzbaq;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.gtm.bs
    public final <UT, UB> UB a(dd ddVar, Object obj, zzqp zzqpVar, bv<Object> bvVar, UB ub, dv<UT, UB> dvVar) {
        throw new NoSuchMethodError();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.gtm.bs
    public final Object a(zzqp zzqpVar, zzsk zzskVar, int i) {
        return zzqpVar.zza(zzskVar, i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.gtm.bs
    public final void a(dd ddVar, Object obj, zzqp zzqpVar, bv<Object> bvVar) {
        throw new NoSuchMethodError();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.gtm.bs
    public final void a(em emVar, Map.Entry<?, ?> entry) {
        entry.getKey();
        throw new NoSuchMethodError();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.gtm.bs
    public final void a(zzps zzpsVar, Object obj, zzqp zzqpVar, bv<Object> bvVar) {
        throw new NoSuchMethodError();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.gtm.bs
    public final boolean a(zzsk zzskVar) {
        return zzskVar instanceof zzrc.zzc;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.gtm.bs
    public final bv<Object> b(Object obj) {
        zzrc.zzc zzcVar = (zzrc.zzc) obj;
        if (zzcVar.zzbaq.c()) {
            zzcVar.zzbaq = (bv) zzcVar.zzbaq.clone();
        }
        return zzcVar.zzbaq;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.gtm.bs
    public final void c(Object obj) {
        a(obj).b();
    }
}
