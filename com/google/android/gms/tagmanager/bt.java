package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.gtm.zzl;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class bt extends ag {
    private static final String a = com.google.android.gms.internal.gtm.zza.ADVERTISER_ID.toString();
    private final zza b;

    public bt(Context context) {
        this(zza.zzf(context));
    }

    @VisibleForTesting
    private bt(zza zzaVar) {
        super(a, new String[0]);
        this.b = zzaVar;
        this.b.zzgq();
    }

    @Override // com.google.android.gms.tagmanager.ag
    public final zzl zzb(Map<String, zzl> map) {
        String zzgq = this.b.zzgq();
        return zzgq == null ? zzgj.zzkc() : zzgj.zzi(zzgq);
    }

    @Override // com.google.android.gms.tagmanager.ag
    public final boolean zzgw() {
        return false;
    }
}
