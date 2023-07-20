package com.google.android.gms.internal.gtm;

import com.google.android.gms.common.util.VisibleForTesting;

@VisibleForTesting
/* loaded from: classes.dex */
public final class zzba extends zzan {
    private final zzq a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzba(zzap zzapVar) {
        super(zzapVar);
        this.a = new zzq();
    }

    @Override // com.google.android.gms.internal.gtm.zzan
    protected final void a() {
        h().zzat().zzb(this.a);
        zzda k = k();
        String zzaz = k.zzaz();
        if (zzaz != null) {
            this.a.setAppName(zzaz);
        }
        String zzba = k.zzba();
        if (zzba != null) {
            this.a.setAppVersion(zzba);
        }
    }

    public final zzq zzdv() {
        q();
        return this.a;
    }
}
