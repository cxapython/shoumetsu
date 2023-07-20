package com.google.android.gms.tasks;

import android.app.Activity;
import com.google.android.gms.common.api.internal.LifecycleCallback;
import com.google.android.gms.common.api.internal.LifecycleFragment;
import com.google.android.gms.common.internal.Preconditions;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import javax.annotation.concurrent.GuardedBy;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class v<TResult> extends Task<TResult> {
    private final Object a = new Object();
    private final s<TResult> b = new s<>();
    @GuardedBy("mLock")
    private boolean c;
    private volatile boolean d;
    @GuardedBy("mLock")
    private TResult e;
    @GuardedBy("mLock")
    private Exception f;

    /* loaded from: classes.dex */
    private static class a extends LifecycleCallback {
        private final List<WeakReference<q<?>>> b;

        private a(LifecycleFragment lifecycleFragment) {
            super(lifecycleFragment);
            this.b = new ArrayList();
            this.a.addCallback("TaskOnStopCallback", this);
        }

        public static a a(Activity activity) {
            LifecycleFragment fragment = getFragment(activity);
            a aVar = (a) fragment.getCallbackOrNull("TaskOnStopCallback", a.class);
            return aVar == null ? new a(fragment) : aVar;
        }

        public final <T> void a(q<T> qVar) {
            synchronized (this.b) {
                this.b.add(new WeakReference<>(qVar));
            }
        }

        @Override // com.google.android.gms.common.api.internal.LifecycleCallback
        public void onStop() {
            synchronized (this.b) {
                for (WeakReference<q<?>> weakReference : this.b) {
                    q<?> qVar = weakReference.get();
                    if (qVar != null) {
                        qVar.a();
                    }
                }
                this.b.clear();
            }
        }
    }

    @GuardedBy("mLock")
    private final void b() {
        Preconditions.checkState(this.c, "Task is not yet complete");
    }

    @GuardedBy("mLock")
    private final void c() {
        Preconditions.checkState(!this.c, "Task is already complete");
    }

    @GuardedBy("mLock")
    private final void d() {
        if (!this.d) {
            return;
        }
        throw new CancellationException("Task is already canceled.");
    }

    private final void e() {
        synchronized (this.a) {
            if (!this.c) {
                return;
            }
            this.b.a(this);
        }
    }

    public final void a(Exception exc) {
        Preconditions.checkNotNull(exc, "Exception must not be null");
        synchronized (this.a) {
            c();
            this.c = true;
            this.f = exc;
        }
        this.b.a(this);
    }

    public final void a(TResult tresult) {
        synchronized (this.a) {
            c();
            this.c = true;
            this.e = tresult;
        }
        this.b.a(this);
    }

    public final boolean a() {
        synchronized (this.a) {
            if (this.c) {
                return false;
            }
            this.c = true;
            this.d = true;
            this.b.a(this);
            return true;
        }
    }

    @Override // com.google.android.gms.tasks.Task
    public final Task<TResult> addOnCanceledListener(Activity activity, OnCanceledListener onCanceledListener) {
        g gVar = new g(TaskExecutors.MAIN_THREAD, onCanceledListener);
        this.b.a(gVar);
        a.a(activity).a(gVar);
        e();
        return this;
    }

    @Override // com.google.android.gms.tasks.Task
    public final Task<TResult> addOnCanceledListener(OnCanceledListener onCanceledListener) {
        return addOnCanceledListener(TaskExecutors.MAIN_THREAD, onCanceledListener);
    }

    @Override // com.google.android.gms.tasks.Task
    public final Task<TResult> addOnCanceledListener(Executor executor, OnCanceledListener onCanceledListener) {
        this.b.a(new g(executor, onCanceledListener));
        e();
        return this;
    }

    @Override // com.google.android.gms.tasks.Task
    public final Task<TResult> addOnCompleteListener(Activity activity, OnCompleteListener<TResult> onCompleteListener) {
        i iVar = new i(TaskExecutors.MAIN_THREAD, onCompleteListener);
        this.b.a(iVar);
        a.a(activity).a(iVar);
        e();
        return this;
    }

    @Override // com.google.android.gms.tasks.Task
    public final Task<TResult> addOnCompleteListener(OnCompleteListener<TResult> onCompleteListener) {
        return addOnCompleteListener(TaskExecutors.MAIN_THREAD, onCompleteListener);
    }

    @Override // com.google.android.gms.tasks.Task
    public final Task<TResult> addOnCompleteListener(Executor executor, OnCompleteListener<TResult> onCompleteListener) {
        this.b.a(new i(executor, onCompleteListener));
        e();
        return this;
    }

    @Override // com.google.android.gms.tasks.Task
    public final Task<TResult> addOnFailureListener(Activity activity, OnFailureListener onFailureListener) {
        k kVar = new k(TaskExecutors.MAIN_THREAD, onFailureListener);
        this.b.a(kVar);
        a.a(activity).a(kVar);
        e();
        return this;
    }

    @Override // com.google.android.gms.tasks.Task
    public final Task<TResult> addOnFailureListener(OnFailureListener onFailureListener) {
        return addOnFailureListener(TaskExecutors.MAIN_THREAD, onFailureListener);
    }

    @Override // com.google.android.gms.tasks.Task
    public final Task<TResult> addOnFailureListener(Executor executor, OnFailureListener onFailureListener) {
        this.b.a(new k(executor, onFailureListener));
        e();
        return this;
    }

    @Override // com.google.android.gms.tasks.Task
    public final Task<TResult> addOnSuccessListener(Activity activity, OnSuccessListener<? super TResult> onSuccessListener) {
        m mVar = new m(TaskExecutors.MAIN_THREAD, onSuccessListener);
        this.b.a(mVar);
        a.a(activity).a(mVar);
        e();
        return this;
    }

    @Override // com.google.android.gms.tasks.Task
    public final Task<TResult> addOnSuccessListener(OnSuccessListener<? super TResult> onSuccessListener) {
        return addOnSuccessListener(TaskExecutors.MAIN_THREAD, onSuccessListener);
    }

    @Override // com.google.android.gms.tasks.Task
    public final Task<TResult> addOnSuccessListener(Executor executor, OnSuccessListener<? super TResult> onSuccessListener) {
        this.b.a(new m(executor, onSuccessListener));
        e();
        return this;
    }

    public final boolean b(Exception exc) {
        Preconditions.checkNotNull(exc, "Exception must not be null");
        synchronized (this.a) {
            if (this.c) {
                return false;
            }
            this.c = true;
            this.f = exc;
            this.b.a(this);
            return true;
        }
    }

    public final boolean b(TResult tresult) {
        synchronized (this.a) {
            if (this.c) {
                return false;
            }
            this.c = true;
            this.e = tresult;
            this.b.a(this);
            return true;
        }
    }

    @Override // com.google.android.gms.tasks.Task
    public final <TContinuationResult> Task<TContinuationResult> continueWith(Continuation<TResult, TContinuationResult> continuation) {
        return continueWith(TaskExecutors.MAIN_THREAD, continuation);
    }

    @Override // com.google.android.gms.tasks.Task
    public final <TContinuationResult> Task<TContinuationResult> continueWith(Executor executor, Continuation<TResult, TContinuationResult> continuation) {
        v vVar = new v();
        this.b.a(new c(executor, continuation, vVar));
        e();
        return vVar;
    }

    @Override // com.google.android.gms.tasks.Task
    public final <TContinuationResult> Task<TContinuationResult> continueWithTask(Continuation<TResult, Task<TContinuationResult>> continuation) {
        return continueWithTask(TaskExecutors.MAIN_THREAD, continuation);
    }

    @Override // com.google.android.gms.tasks.Task
    public final <TContinuationResult> Task<TContinuationResult> continueWithTask(Executor executor, Continuation<TResult, Task<TContinuationResult>> continuation) {
        v vVar = new v();
        this.b.a(new e(executor, continuation, vVar));
        e();
        return vVar;
    }

    @Override // com.google.android.gms.tasks.Task
    public final Exception getException() {
        Exception exc;
        synchronized (this.a) {
            exc = this.f;
        }
        return exc;
    }

    @Override // com.google.android.gms.tasks.Task
    public final TResult getResult() {
        TResult tresult;
        synchronized (this.a) {
            b();
            d();
            if (this.f != null) {
                throw new RuntimeExecutionException(this.f);
            }
            tresult = this.e;
        }
        return tresult;
    }

    @Override // com.google.android.gms.tasks.Task
    public final <X extends Throwable> TResult getResult(Class<X> cls) {
        TResult tresult;
        synchronized (this.a) {
            b();
            d();
            if (cls.isInstance(this.f)) {
                throw cls.cast(this.f);
            }
            if (this.f != null) {
                throw new RuntimeExecutionException(this.f);
            }
            tresult = this.e;
        }
        return tresult;
    }

    @Override // com.google.android.gms.tasks.Task
    public final boolean isCanceled() {
        return this.d;
    }

    @Override // com.google.android.gms.tasks.Task
    public final boolean isComplete() {
        boolean z;
        synchronized (this.a) {
            z = this.c;
        }
        return z;
    }

    @Override // com.google.android.gms.tasks.Task
    public final boolean isSuccessful() {
        boolean z;
        synchronized (this.a) {
            z = this.c && !this.d && this.f == null;
        }
        return z;
    }

    @Override // com.google.android.gms.tasks.Task
    public final <TContinuationResult> Task<TContinuationResult> onSuccessTask(SuccessContinuation<TResult, TContinuationResult> successContinuation) {
        return onSuccessTask(TaskExecutors.MAIN_THREAD, successContinuation);
    }

    @Override // com.google.android.gms.tasks.Task
    public final <TContinuationResult> Task<TContinuationResult> onSuccessTask(Executor executor, SuccessContinuation<TResult, TContinuationResult> successContinuation) {
        v vVar = new v();
        this.b.a(new o(executor, successContinuation, vVar));
        e();
        return vVar;
    }
}
