package com.google.android.gms.internal.gtm;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class c implements Runnable {
    private final /* synthetic */ String a;
    private final /* synthetic */ Runnable b;
    private final /* synthetic */ zzae c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(zzae zzaeVar, String str, Runnable runnable) {
        this.c = zzaeVar;
        this.a = str;
        this.b = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        n nVar;
        nVar = this.c.a;
        nVar.a(this.a);
        Runnable runnable = this.b;
        if (runnable != null) {
            runnable.run();
        }
    }
}
