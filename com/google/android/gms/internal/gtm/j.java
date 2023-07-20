package com.google.android.gms.internal.gtm;

/* loaded from: classes.dex */
final class j implements Runnable {
    private final /* synthetic */ zzce a;
    private final /* synthetic */ zzav b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(zzav zzavVar, zzce zzceVar) {
        this.b = zzavVar;
        this.a = zzceVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (!this.b.a.isConnected()) {
            this.b.a.zzr("Connected to service after a timeout");
            zzat.a(this.b.a, this.a);
        }
    }
}
