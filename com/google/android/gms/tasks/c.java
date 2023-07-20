package com.google.android.gms.tasks;

import java.util.concurrent.Executor;

/* loaded from: classes.dex */
final class c<TResult, TContinuationResult> implements q<TResult> {
    private final Executor a;
    private final Continuation<TResult, TContinuationResult> b;
    private final v<TContinuationResult> c;

    public c(Executor executor, Continuation<TResult, TContinuationResult> continuation, v<TContinuationResult> vVar) {
        this.a = executor;
        this.b = continuation;
        this.c = vVar;
    }

    @Override // com.google.android.gms.tasks.q
    public final void a() {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.gms.tasks.q
    public final void a(Task<TResult> task) {
        this.a.execute(new d(this, task));
    }
}
