package com.google.android.gms.internal.gtm;

import java.util.Iterator;
import java.util.Map;

/* loaded from: classes.dex */
final class cq implements cp {
    @Override // com.google.android.gms.internal.gtm.cp
    public final int a(int i, Object obj, Object obj2) {
        zzse zzseVar = (zzse) obj;
        if (zzseVar.isEmpty()) {
            return 0;
        }
        Iterator it = zzseVar.entrySet().iterator();
        if (!it.hasNext()) {
            return 0;
        }
        Map.Entry entry = (Map.Entry) it.next();
        entry.getKey();
        entry.getValue();
        throw new NoSuchMethodError();
    }

    @Override // com.google.android.gms.internal.gtm.cp
    public final Object a(Object obj, Object obj2) {
        zzse zzseVar = (zzse) obj;
        zzse zzseVar2 = (zzse) obj2;
        if (!zzseVar2.isEmpty()) {
            if (!zzseVar.isMutable()) {
                zzseVar = zzseVar.zzqg();
            }
            zzseVar.zza(zzseVar2);
        }
        return zzseVar;
    }

    @Override // com.google.android.gms.internal.gtm.cp
    public final Map<?, ?> a(Object obj) {
        return (zzse) obj;
    }

    @Override // com.google.android.gms.internal.gtm.cp
    public final Map<?, ?> b(Object obj) {
        return (zzse) obj;
    }

    @Override // com.google.android.gms.internal.gtm.cp
    public final boolean c(Object obj) {
        return !((zzse) obj).isMutable();
    }

    @Override // com.google.android.gms.internal.gtm.cp
    public final Object d(Object obj) {
        ((zzse) obj).zzmi();
        return obj;
    }

    @Override // com.google.android.gms.internal.gtm.cp
    public final Object e(Object obj) {
        return zzse.zzqf().zzqg();
    }

    @Override // com.google.android.gms.internal.gtm.cp
    public final co<?, ?> f(Object obj) {
        throw new NoSuchMethodError();
    }
}
