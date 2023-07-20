package com.google.android.gms.tagmanager;

import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.gtm.zzl;
import java.util.Map;

@VisibleForTesting
/* loaded from: classes.dex */
final class i extends ag {
    private static final String a = com.google.android.gms.internal.gtm.zza.CONTAINER_VERSION.toString();
    private final String b;

    public i(String str) {
        super(a, new String[0]);
        this.b = str;
    }

    @Override // com.google.android.gms.tagmanager.ag
    public final zzl zzb(Map<String, zzl> map) {
        String str = this.b;
        return str == null ? zzgj.zzkc() : zzgj.zzi(str);
    }

    @Override // com.google.android.gms.tagmanager.ag
    public final boolean zzgw() {
        return true;
    }
}
