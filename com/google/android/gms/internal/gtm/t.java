package com.google.android.gms.internal.gtm;

import java.util.concurrent.Callable;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class t implements Callable<String> {
    private final /* synthetic */ zzbh a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(zzbh zzbhVar) {
        this.a = zzbhVar;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ String call() {
        String r;
        r = this.a.r();
        return r;
    }
}
