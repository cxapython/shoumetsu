package com.google.android.gms.internal.gtm;

import java.util.concurrent.Callable;

/* loaded from: classes.dex */
final class s implements Callable<String> {
    private final /* synthetic */ zzbh a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(zzbh zzbhVar) {
        this.a = zzbhVar;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ String call() {
        return this.a.c();
    }
}
