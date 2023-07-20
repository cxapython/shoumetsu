package com.google.android.gms.tasks;

/* loaded from: classes.dex */
final class h implements Runnable {
    private final /* synthetic */ g a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g gVar) {
        this.a = gVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object obj;
        OnCanceledListener onCanceledListener;
        OnCanceledListener onCanceledListener2;
        obj = this.a.b;
        synchronized (obj) {
            onCanceledListener = this.a.c;
            if (onCanceledListener != null) {
                onCanceledListener2 = this.a.c;
                onCanceledListener2.onCanceled();
            }
        }
    }
}
