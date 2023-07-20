package com.google.android.gms.internal.gtm;

import java.util.concurrent.Callable;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class g implements Callable<Void> {
    private final /* synthetic */ zzae a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(zzae zzaeVar) {
        this.a = zzaeVar;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ Void call() {
        n nVar;
        nVar = this.a.a;
        nVar.u();
        return null;
    }
}
