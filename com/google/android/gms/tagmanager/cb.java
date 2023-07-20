package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.gtm.zzb;
import com.google.android.gms.internal.gtm.zzl;
import java.util.Map;

/* loaded from: classes.dex */
final class cb extends ag {
    private static final String a = com.google.android.gms.internal.gtm.zza.RANDOM.toString();
    private static final String b = zzb.MIN.toString();
    private static final String c = zzb.MAX.toString();

    public cb() {
        super(a, new String[0]);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x003e, code lost:
        if (r0 <= r2) goto L14;
     */
    @Override // com.google.android.gms.tagmanager.ag
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final zzl zzb(Map<String, zzl> map) {
        double d;
        double d2;
        zzl zzlVar = map.get(b);
        zzl zzlVar2 = map.get(c);
        if (zzlVar != null && zzlVar != zzgj.zzkc() && zzlVar2 != null && zzlVar2 != zzgj.zzkc()) {
            dz zzd = zzgj.zzd(zzlVar);
            dz zzd2 = zzgj.zzd(zzlVar2);
            if (zzd != zzgj.zzka() && zzd2 != zzgj.zzka()) {
                d = zzd.doubleValue();
                d2 = zzd2.doubleValue();
            }
        }
        d = 0.0d;
        d2 = 2.147483647E9d;
        return zzgj.zzi(Long.valueOf(Math.round((Math.random() * (d2 - d)) + d)));
    }

    @Override // com.google.android.gms.tagmanager.ag
    public final boolean zzgw() {
        return false;
    }
}
