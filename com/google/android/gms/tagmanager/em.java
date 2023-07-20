package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.gtm.zzb;
import com.google.android.gms.internal.gtm.zzl;
import java.util.Map;

/* loaded from: classes.dex */
final class em extends ag {
    private static final String a = com.google.android.gms.internal.gtm.zza.CONSTANT.toString();
    private static final String b = zzb.VALUE.toString();

    public em() {
        super(a, b);
    }

    public static String a() {
        return a;
    }

    public static String b() {
        return b;
    }

    @Override // com.google.android.gms.tagmanager.ag
    public final zzl zzb(Map<String, zzl> map) {
        return map.get(b);
    }

    @Override // com.google.android.gms.tagmanager.ag
    public final boolean zzgw() {
        return true;
    }
}
