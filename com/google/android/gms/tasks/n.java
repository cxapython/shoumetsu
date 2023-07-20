package com.google.android.gms.tasks;

/* loaded from: classes.dex */
final class n implements Runnable {
    private final /* synthetic */ Task a;
    private final /* synthetic */ m b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(m mVar, Task task) {
        this.b = mVar;
        this.a = task;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object obj;
        OnSuccessListener onSuccessListener;
        OnSuccessListener onSuccessListener2;
        obj = this.b.b;
        synchronized (obj) {
            onSuccessListener = this.b.c;
            if (onSuccessListener != null) {
                onSuccessListener2 = this.b.c;
                onSuccessListener2.onSuccess(this.a.getResult());
            }
        }
    }
}
