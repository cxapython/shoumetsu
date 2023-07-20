package com.google.android.gms.tasks;

import java.util.concurrent.Executor;
import javax.annotation.concurrent.GuardedBy;

/* loaded from: classes.dex */
final class i<TResult> implements q<TResult> {
    private final Executor a;
    private final Object b = new Object();
    @GuardedBy("mLock")
    private OnCompleteListener<TResult> c;

    public i(Executor executor, OnCompleteListener<TResult> onCompleteListener) {
        this.a = executor;
        this.c = onCompleteListener;
    }

    @Override // com.google.android.gms.tasks.q
    public final void a() {
        synchronized (this.b) {
            this.c = null;
        }
    }

    @Override // com.google.android.gms.tasks.q
    public final void a(Task<TResult> task) {
        synchronized (this.b) {
            if (this.c == null) {
                return;
            }
            this.a.execute(new j(this, task));
        }
    }
}
