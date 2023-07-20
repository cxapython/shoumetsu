package com.google.android.gms.tasks;

import java.util.concurrent.CancellationException;

/* loaded from: classes.dex */
final class p implements Runnable {
    private final /* synthetic */ Task a;
    private final /* synthetic */ o b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(o oVar, Task task) {
        this.b = oVar;
        this.a = task;
    }

    @Override // java.lang.Runnable
    public final void run() {
        SuccessContinuation successContinuation;
        try {
            successContinuation = this.b.b;
            Task then = successContinuation.then(this.a.getResult());
            if (then == null) {
                this.b.onFailure(new NullPointerException("Continuation returned null"));
                return;
            }
            then.addOnSuccessListener(TaskExecutors.a, this.b);
            then.addOnFailureListener(TaskExecutors.a, this.b);
            then.addOnCanceledListener(TaskExecutors.a, this.b);
        } catch (RuntimeExecutionException e) {
            if (e.getCause() instanceof Exception) {
                this.b.onFailure((Exception) e.getCause());
            } else {
                this.b.onFailure(e);
            }
        } catch (CancellationException unused) {
            this.b.onCanceled();
        } catch (Exception e2) {
            this.b.onFailure(e2);
        }
    }
}
