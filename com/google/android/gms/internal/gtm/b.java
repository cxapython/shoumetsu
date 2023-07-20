package com.google.android.gms.internal.gtm;

/* loaded from: classes.dex */
final class b implements Runnable {
    private final /* synthetic */ boolean a;
    private final /* synthetic */ zzae b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(zzae zzaeVar, boolean z) {
        this.b = zzaeVar;
        this.a = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        n nVar;
        nVar = this.b.a;
        nVar.v();
    }
}
