package com.google.android.gms.tagmanager;

/* loaded from: classes.dex */
final class t implements Runnable {
    private final /* synthetic */ String a;
    private final /* synthetic */ q b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(q qVar, String str) {
        this.b = qVar;
        this.a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.b.b(this.a);
    }
}
