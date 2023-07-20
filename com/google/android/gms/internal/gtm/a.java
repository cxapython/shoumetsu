package com.google.android.gms.internal.gtm;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class a implements Runnable {
    private final /* synthetic */ int a;
    private final /* synthetic */ zzae b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(zzae zzaeVar, int i) {
        this.b = zzaeVar;
        this.a = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        n nVar;
        nVar = this.b.a;
        nVar.a(this.a * 1000);
    }
}
