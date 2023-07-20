package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.gtm.zzop;

/* loaded from: classes.dex */
final class cs implements Runnable {
    private final /* synthetic */ zzop a;
    private final /* synthetic */ cq b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cs(cq cqVar, zzop zzopVar) {
        this.b = cqVar;
        this.a = zzopVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.b.b(this.a);
    }
}
