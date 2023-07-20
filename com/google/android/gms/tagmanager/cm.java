package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.gtm.zzdf;
import java.util.concurrent.ScheduledExecutorService;

/* loaded from: classes.dex */
final class cm implements cp {
    /* JADX INFO: Access modifiers changed from: package-private */
    public cm(cl clVar) {
    }

    @Override // com.google.android.gms.tagmanager.cp
    public final ScheduledExecutorService a() {
        return zzdf.zzgp().zza(1, com.google.android.gms.internal.gtm.zzdi.zzadg);
    }
}
