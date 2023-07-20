package com.google.android.gms.tagmanager;

/* loaded from: classes.dex */
final class di implements Runnable {
    private final /* synthetic */ dg a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public di(dg dgVar) {
        this.a = dgVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ar arVar;
        arVar = this.a.c;
        arVar.a();
    }
}
