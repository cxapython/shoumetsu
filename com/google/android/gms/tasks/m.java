package com.google.android.gms.tasks;

import java.util.concurrent.Executor;
import javax.annotation.concurrent.GuardedBy;

/* loaded from: classes.dex */
final class m<TResult> implements q<TResult> {
    private final Executor a;
    private final Object b = new Object();
    @GuardedBy("mLock")
    private OnSuccessListener<? super TResult> c;

    public m(Executor executor, OnSuccessListener<? super TResult> onSuccessListener) {
        this.a = executor;
        this.c = onSuccessListener;
    }

    @Override // com.google.android.gms.tasks.q
    public final void a() {
        synchronized (this.b) {
            this.c = null;
        }
    }

    @Override // com.google.android.gms.tasks.q
    public final void a(Task<TResult> task) {
        if (task.isSuccessful()) {
            synchronized (this.b) {
                if (this.c == null) {
                    return;
                }
                this.a.execute(new n(this, task));
            }
        }
    }
}
