package com.google.android.gms.internal.gtm;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class d implements Runnable {
    private final /* synthetic */ zzcd a;
    private final /* synthetic */ zzae b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(zzae zzaeVar, zzcd zzcdVar) {
        this.b = zzaeVar;
        this.a = zzcdVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        n nVar;
        nVar = this.b.a;
        nVar.a(this.a);
    }
}
