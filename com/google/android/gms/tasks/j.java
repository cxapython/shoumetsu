package com.google.android.gms.tasks;

/* loaded from: classes.dex */
final class j implements Runnable {
    private final /* synthetic */ Task a;
    private final /* synthetic */ i b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(i iVar, Task task) {
        this.b = iVar;
        this.a = task;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object obj;
        OnCompleteListener onCompleteListener;
        OnCompleteListener onCompleteListener2;
        obj = this.b.b;
        synchronized (obj) {
            onCompleteListener = this.b.c;
            if (onCompleteListener != null) {
                onCompleteListener2 = this.b.c;
                onCompleteListener2.onComplete(this.a);
            }
        }
    }
}
