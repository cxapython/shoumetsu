package com.google.android.gms.tasks;

import java.util.concurrent.Executor;

/* loaded from: classes.dex */
final class o<TResult, TContinuationResult> implements OnCanceledListener, OnFailureListener, OnSuccessListener<TContinuationResult>, q<TResult> {
    private final Executor a;
    private final SuccessContinuation<TResult, TContinuationResult> b;
    private final v<TContinuationResult> c;

    public o(Executor executor, SuccessContinuation<TResult, TContinuationResult> successContinuation, v<TContinuationResult> vVar) {
        this.a = executor;
        this.b = successContinuation;
        this.c = vVar;
    }

    @Override // com.google.android.gms.tasks.q
    public final void a() {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.gms.tasks.q
    public final void a(Task<TResult> task) {
        this.a.execute(new p(this, task));
    }

    @Override // com.google.android.gms.tasks.OnCanceledListener
    public final void onCanceled() {
        this.c.a();
    }

    @Override // com.google.android.gms.tasks.OnFailureListener
    public final void onFailure(Exception exc) {
        this.c.a(exc);
    }

    @Override // com.google.android.gms.tasks.OnSuccessListener
    public final void onSuccess(TContinuationResult tcontinuationresult) {
        this.c.a((v<TContinuationResult>) tcontinuationresult);
    }
}
