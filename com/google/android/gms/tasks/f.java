package com.google.android.gms.tasks;

/* loaded from: classes.dex */
final class f implements Runnable {
    private final /* synthetic */ Task a;
    private final /* synthetic */ e b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar, Task task) {
        this.b = eVar;
        this.a = task;
    }

    @Override // java.lang.Runnable
    public final void run() {
        v vVar;
        v vVar2;
        v vVar3;
        Continuation continuation;
        try {
            continuation = this.b.b;
            Task task = (Task) continuation.then(this.a);
            if (task == null) {
                this.b.onFailure(new NullPointerException("Continuation returned null"));
                return;
            }
            task.addOnSuccessListener(TaskExecutors.a, this.b);
            task.addOnFailureListener(TaskExecutors.a, this.b);
            task.addOnCanceledListener(TaskExecutors.a, this.b);
        } catch (RuntimeExecutionException e) {
            if (e.getCause() instanceof Exception) {
                vVar3 = this.b.c;
                vVar3.a((Exception) e.getCause());
                return;
            }
            vVar2 = this.b.c;
            vVar2.a((Exception) e);
        } catch (Exception e2) {
            vVar = this.b.c;
            vVar.a(e2);
        }
    }
}
