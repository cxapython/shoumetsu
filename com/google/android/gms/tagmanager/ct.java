package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.gtm.zzl;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class ct extends ag {
    private static final String a = com.google.android.gms.internal.gtm.zza.ADVERTISING_TRACKING_ENABLED.toString();
    private final zza b;

    public ct(Context context) {
        this(zza.zzf(context));
    }

    @VisibleForTesting
    private ct(zza zzaVar) {
        super(a, new String[0]);
        this.b = zzaVar;
    }

    @Override // com.google.android.gms.tagmanager.ag
    public final zzl zzb(Map<String, zzl> map) {
        return zzgj.zzi(Boolean.valueOf(!this.b.isLimitAdTrackingEnabled()));
    }

    @Override // com.google.android.gms.tagmanager.ag
    public final boolean zzgw() {
        return false;
    }
}
