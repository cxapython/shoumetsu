package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.gtm.zzb;
import com.google.android.gms.internal.gtm.zzl;
import java.util.Map;

/* loaded from: classes.dex */
final class ea extends ag {
    private static final String a = com.google.android.gms.internal.gtm.zza.UPPERCASE_STRING.toString();
    private static final String b = zzb.ARG0.toString();

    public ea() {
        super(a, b);
    }

    @Override // com.google.android.gms.tagmanager.ag
    public final zzl zzb(Map<String, zzl> map) {
        return zzgj.zzi(zzgj.zzc(map.get(b)).toUpperCase());
    }

    @Override // com.google.android.gms.tagmanager.ag
    public final boolean zzgw() {
        return true;
    }
}
