package com.google.android.gms.tagmanager;

/* loaded from: classes.dex */
final class cr implements Runnable {
    private final /* synthetic */ cq a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cr(cq cqVar) {
        this.a = cqVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.b();
    }
}
