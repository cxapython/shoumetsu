package com.google.android.gms.tasks;

/* loaded from: classes.dex */
final class l implements Runnable {
    private final /* synthetic */ Task a;
    private final /* synthetic */ k b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(k kVar, Task task) {
        this.b = kVar;
        this.a = task;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object obj;
        OnFailureListener onFailureListener;
        OnFailureListener onFailureListener2;
        obj = this.b.b;
        synchronized (obj) {
            onFailureListener = this.b.c;
            if (onFailureListener != null) {
                onFailureListener2 = this.b.c;
                onFailureListener2.onFailure(this.a.getException());
            }
        }
    }
}
