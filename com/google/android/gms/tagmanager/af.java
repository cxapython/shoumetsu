package com.google.android.gms.tagmanager;

import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.gtm.zzl;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
@VisibleForTesting
/* loaded from: classes.dex */
public final class af extends ag {
    private static final String a = com.google.android.gms.internal.gtm.zza.EVENT.toString();
    private final cv b;

    public af(cv cvVar) {
        super(a, new String[0]);
        this.b = cvVar;
    }

    @Override // com.google.android.gms.tagmanager.ag
    public final zzl zzb(Map<String, zzl> map) {
        String a2 = this.b.a();
        return a2 == null ? zzgj.zzkc() : zzgj.zzi(a2);
    }

    @Override // com.google.android.gms.tagmanager.ag
    public final boolean zzgw() {
        return false;
    }
}
