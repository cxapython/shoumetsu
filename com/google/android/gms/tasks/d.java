package com.google.android.gms.tasks;

/* loaded from: classes.dex */
final class d implements Runnable {
    private final /* synthetic */ Task a;
    private final /* synthetic */ c b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar, Task task) {
        this.b = cVar;
        this.a = task;
    }

    @Override // java.lang.Runnable
    public final void run() {
        v vVar;
        v vVar2;
        v vVar3;
        Continuation continuation;
        v vVar4;
        v vVar5;
        if (this.a.isCanceled()) {
            vVar5 = this.b.c;
            vVar5.a();
            return;
        }
        try {
            continuation = this.b.b;
            Object then = continuation.then(this.a);
            vVar4 = this.b.c;
            vVar4.a((v) then);
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
