package com.google.android.gms.tasks;

import java.util.concurrent.Executor;
import javax.annotation.concurrent.GuardedBy;

/* loaded from: classes.dex */
final class g<TResult> implements q<TResult> {
    private final Executor a;
    private final Object b = new Object();
    @GuardedBy("mLock")
    private OnCanceledListener c;

    public g(Executor executor, OnCanceledListener onCanceledListener) {
        this.a = executor;
        this.c = onCanceledListener;
    }

    @Override // com.google.android.gms.tasks.q
    public final void a() {
        synchronized (this.b) {
            this.c = null;
        }
    }

    @Override // com.google.android.gms.tasks.q
    public final void a(Task task) {
        if (task.isCanceled()) {
            synchronized (this.b) {
                if (this.c == null) {
                    return;
                }
                this.a.execute(new h(this));
            }
        }
    }
}
