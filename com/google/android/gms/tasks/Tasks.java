package com.google.android.gms.tasks;

import com.google.android.gms.common.internal.Preconditions;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import javax.annotation.concurrent.GuardedBy;

/* loaded from: classes.dex */
public final class Tasks {

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class a implements b {
        private final CountDownLatch a;

        private a() {
            this.a = new CountDownLatch(1);
        }

        /* synthetic */ a(w wVar) {
            this();
        }

        public final void a() {
            this.a.await();
        }

        public final boolean a(long j, TimeUnit timeUnit) {
            return this.a.await(j, timeUnit);
        }

        @Override // com.google.android.gms.tasks.OnCanceledListener
        public final void onCanceled() {
            this.a.countDown();
        }

        @Override // com.google.android.gms.tasks.OnFailureListener
        public final void onFailure(Exception exc) {
            this.a.countDown();
        }

        @Override // com.google.android.gms.tasks.OnSuccessListener
        public final void onSuccess(Object obj) {
            this.a.countDown();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface b extends OnCanceledListener, OnFailureListener, OnSuccessListener<Object> {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class c implements b {
        private final Object a = new Object();
        private final int b;
        private final v<Void> c;
        @GuardedBy("mLock")
        private int d;
        @GuardedBy("mLock")
        private int e;
        @GuardedBy("mLock")
        private int f;
        @GuardedBy("mLock")
        private Exception g;
        @GuardedBy("mLock")
        private boolean h;

        public c(int i, v<Void> vVar) {
            this.b = i;
            this.c = vVar;
        }

        @GuardedBy("mLock")
        private final void a() {
            int i = this.d;
            int i2 = this.e;
            int i3 = i + i2 + this.f;
            int i4 = this.b;
            if (i3 == i4) {
                if (this.g == null) {
                    if (this.h) {
                        this.c.a();
                        return;
                    } else {
                        this.c.a((v<Void>) null);
                        return;
                    }
                }
                v<Void> vVar = this.c;
                StringBuilder sb = new StringBuilder(54);
                sb.append(i2);
                sb.append(" out of ");
                sb.append(i4);
                sb.append(" underlying tasks failed");
                vVar.a(new ExecutionException(sb.toString(), this.g));
            }
        }

        @Override // com.google.android.gms.tasks.OnCanceledListener
        public final void onCanceled() {
            synchronized (this.a) {
                this.f++;
                this.h = true;
                a();
            }
        }

        @Override // com.google.android.gms.tasks.OnFailureListener
        public final void onFailure(Exception exc) {
            synchronized (this.a) {
                this.e++;
                this.g = exc;
                a();
            }
        }

        @Override // com.google.android.gms.tasks.OnSuccessListener
        public final void onSuccess(Object obj) {
            synchronized (this.a) {
                this.d++;
                a();
            }
        }
    }

    private Tasks() {
    }

    private static <TResult> TResult a(Task<TResult> task) {
        if (task.isSuccessful()) {
            return task.getResult();
        }
        if (!task.isCanceled()) {
            throw new ExecutionException(task.getException());
        }
        throw new CancellationException("Task is already canceled");
    }

    private static void a(Task<?> task, b bVar) {
        task.addOnSuccessListener(TaskExecutors.a, bVar);
        task.addOnFailureListener(TaskExecutors.a, bVar);
        task.addOnCanceledListener(TaskExecutors.a, bVar);
    }

    public static <TResult> TResult await(Task<TResult> task) {
        Preconditions.checkNotMainThread();
        Preconditions.checkNotNull(task, "Task must not be null");
        if (task.isComplete()) {
            return (TResult) a(task);
        }
        a aVar = new a(null);
        a(task, aVar);
        aVar.a();
        return (TResult) a(task);
    }

    public static <TResult> TResult await(Task<TResult> task, long j, TimeUnit timeUnit) {
        Preconditions.checkNotMainThread();
        Preconditions.checkNotNull(task, "Task must not be null");
        Preconditions.checkNotNull(timeUnit, "TimeUnit must not be null");
        if (task.isComplete()) {
            return (TResult) a(task);
        }
        a aVar = new a(null);
        a(task, aVar);
        if (!aVar.a(j, timeUnit)) {
            throw new TimeoutException("Timed out waiting for Task");
        }
        return (TResult) a(task);
    }

    public static <TResult> Task<TResult> call(Callable<TResult> callable) {
        return call(TaskExecutors.MAIN_THREAD, callable);
    }

    public static <TResult> Task<TResult> call(Executor executor, Callable<TResult> callable) {
        Preconditions.checkNotNull(executor, "Executor must not be null");
        Preconditions.checkNotNull(callable, "Callback must not be null");
        v vVar = new v();
        executor.execute(new w(vVar, callable));
        return vVar;
    }

    public static <TResult> Task<TResult> forCanceled() {
        v vVar = new v();
        vVar.a();
        return vVar;
    }

    public static <TResult> Task<TResult> forException(Exception exc) {
        v vVar = new v();
        vVar.a(exc);
        return vVar;
    }

    public static <TResult> Task<TResult> forResult(TResult tresult) {
        v vVar = new v();
        vVar.a((v) tresult);
        return vVar;
    }

    public static Task<Void> whenAll(Collection<? extends Task<?>> collection) {
        if (collection.isEmpty()) {
            return forResult(null);
        }
        for (Task<?> task : collection) {
            if (task == null) {
                throw new NullPointerException("null tasks are not accepted");
            }
        }
        v vVar = new v();
        c cVar = new c(collection.size(), vVar);
        for (Task<?> task2 : collection) {
            a(task2, cVar);
        }
        return vVar;
    }

    public static Task<Void> whenAll(Task<?>... taskArr) {
        return taskArr.length == 0 ? forResult(null) : whenAll(Arrays.asList(taskArr));
    }

    public static Task<List<Task<?>>> whenAllComplete(Collection<? extends Task<?>> collection) {
        return whenAll(collection).continueWithTask(new y(collection));
    }

    public static Task<List<Task<?>>> whenAllComplete(Task<?>... taskArr) {
        return whenAllComplete(Arrays.asList(taskArr));
    }

    public static <TResult> Task<List<TResult>> whenAllSuccess(Collection<? extends Task<?>> collection) {
        return (Task<List<TResult>>) whenAll(collection).continueWith(new x(collection));
    }

    public static <TResult> Task<List<TResult>> whenAllSuccess(Task<?>... taskArr) {
        return whenAllSuccess(Arrays.asList(taskArr));
    }
}
