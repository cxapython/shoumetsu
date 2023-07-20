package com.google.android.gms.internal.gtm;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class q implements Runnable {
    private final /* synthetic */ n a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(n nVar) {
        this.a = nVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.c();
    }
}
