package com.google.android.gms.internal.gtm;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class f implements Runnable {
    private final /* synthetic */ zzbw a;
    private final /* synthetic */ zzae b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(zzae zzaeVar, zzbw zzbwVar) {
        this.b = zzaeVar;
        this.a = zzbwVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        n nVar;
        nVar = this.b.a;
        nVar.a(this.a);
    }
}
