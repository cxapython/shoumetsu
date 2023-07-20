package com.google.android.gms.internal.gtm;

import android.os.Handler;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class ah implements zzbw {
    private final /* synthetic */ Runnable a;
    private final /* synthetic */ zzcq b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(zzcq zzcqVar, Runnable runnable) {
        this.b = zzcqVar;
        this.a = runnable;
    }

    @Override // com.google.android.gms.internal.gtm.zzbw
    public final void zza(Throwable th) {
        Handler handler;
        handler = this.b.a;
        handler.post(this.a);
    }
}
