package com.google.android.gms.tasks;

/* loaded from: classes.dex */
public class TaskCompletionSource<TResult> {
    private final v<TResult> a = new v<>();

    public TaskCompletionSource() {
    }

    public TaskCompletionSource(CancellationToken cancellationToken) {
        cancellationToken.onCanceledRequested(new t(this));
    }

    public Task<TResult> getTask() {
        return this.a;
    }

    public void setException(Exception exc) {
        this.a.a(exc);
    }

    public void setResult(TResult tresult) {
        this.a.a((v<TResult>) tresult);
    }

    public boolean trySetException(Exception exc) {
        return this.a.b(exc);
    }

    public boolean trySetResult(TResult tresult) {
        return this.a.b((v<TResult>) tresult);
    }
}
