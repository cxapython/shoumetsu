package com.google.android.gms.internal.gtm;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class e implements Runnable {
    private final /* synthetic */ zzae a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(zzae zzaeVar) {
        this.a = zzaeVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        n nVar;
        nVar = this.a.a;
        nVar.t();
    }
}
