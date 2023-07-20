package com.google.android.gms.common.api.internal;

import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.ResultTransform;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.TransformedResult;
import com.google.android.gms.common.internal.ICancelToken;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.base.zap;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

@KeepForSdk
@KeepName
/* loaded from: classes.dex */
public abstract class BasePendingResult<R extends Result> extends PendingResult<R> {
    static final ThreadLocal<Boolean> a = new az();
    private final Object b;
    private final CallbackHandler<R> c;
    private final WeakReference<GoogleApiClient> d;
    private final CountDownLatch e;
    private final ArrayList<PendingResult.StatusListener> f;
    private ResultCallback<? super R> g;
    private final AtomicReference<au> h;
    private R i;
    private Status j;
    private volatile boolean k;
    private boolean l;
    private boolean m;
    @KeepName
    private a mResultGuardian;
    private ICancelToken n;
    private volatile zacm<R> o;
    private boolean p;

    @VisibleForTesting
    /* loaded from: classes.dex */
    public static class CallbackHandler<R extends Result> extends zap {
        public CallbackHandler() {
            this(Looper.getMainLooper());
        }

        public CallbackHandler(Looper looper) {
            super(looper);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    Pair pair = (Pair) message.obj;
                    ResultCallback resultCallback = (ResultCallback) pair.first;
                    Result result = (Result) pair.second;
                    try {
                        resultCallback.onResult(result);
                        return;
                    } catch (RuntimeException e) {
                        BasePendingResult.zab(result);
                        throw e;
                    }
                case 2:
                    ((BasePendingResult) message.obj).zab(Status.RESULT_TIMEOUT);
                    return;
                default:
                    int i = message.what;
                    StringBuilder sb = new StringBuilder(45);
                    sb.append("Don't know how to handle message: ");
                    sb.append(i);
                    Log.wtf("BasePendingResult", sb.toString(), new Exception());
                    return;
            }
        }

        public final void zaa(ResultCallback<? super R> resultCallback, R r) {
            sendMessage(obtainMessage(1, new Pair(resultCallback, r)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public final class a {
        private a() {
        }

        /* synthetic */ a(BasePendingResult basePendingResult, az azVar) {
            this();
        }

        protected final void finalize() {
            BasePendingResult.zab(BasePendingResult.this.i);
            super.finalize();
        }
    }

    @Deprecated
    BasePendingResult() {
        this.b = new Object();
        this.e = new CountDownLatch(1);
        this.f = new ArrayList<>();
        this.h = new AtomicReference<>();
        this.p = false;
        this.c = new CallbackHandler<>(Looper.getMainLooper());
        this.d = new WeakReference<>(null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @KeepForSdk
    @Deprecated
    public BasePendingResult(Looper looper) {
        this.b = new Object();
        this.e = new CountDownLatch(1);
        this.f = new ArrayList<>();
        this.h = new AtomicReference<>();
        this.p = false;
        this.c = new CallbackHandler<>(looper);
        this.d = new WeakReference<>(null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @KeepForSdk
    public BasePendingResult(GoogleApiClient googleApiClient) {
        this.b = new Object();
        this.e = new CountDownLatch(1);
        this.f = new ArrayList<>();
        this.h = new AtomicReference<>();
        this.p = false;
        this.c = new CallbackHandler<>(googleApiClient != null ? googleApiClient.getLooper() : Looper.getMainLooper());
        this.d = new WeakReference<>(googleApiClient);
    }

    private final R a() {
        R r;
        synchronized (this.b) {
            Preconditions.checkState(!this.k, "Result has already been consumed.");
            Preconditions.checkState(isReady(), "Result is not ready.");
            r = this.i;
            this.i = null;
            this.g = null;
            this.k = true;
        }
        au andSet = this.h.getAndSet(null);
        if (andSet != null) {
            andSet.a(this);
        }
        return r;
    }

    private final void a(R r) {
        this.i = r;
        this.n = null;
        this.e.countDown();
        this.j = this.i.getStatus();
        if (this.l) {
            this.g = null;
        } else if (this.g != null) {
            this.c.removeMessages(2);
            this.c.zaa(this.g, a());
        } else if (this.i instanceof Releasable) {
            this.mResultGuardian = new a(this, null);
        }
        ArrayList<PendingResult.StatusListener> arrayList = this.f;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            PendingResult.StatusListener statusListener = arrayList.get(i);
            i++;
            statusListener.onComplete(this.j);
        }
        this.f.clear();
    }

    public static void zab(Result result) {
        if (result instanceof Releasable) {
            try {
                ((Releasable) result).release();
            } catch (RuntimeException e) {
                String valueOf = String.valueOf(result);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 18);
                sb.append("Unable to release ");
                sb.append(valueOf);
                Log.w("BasePendingResult", sb.toString(), e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @KeepForSdk
    public final void a(ICancelToken iCancelToken) {
        synchronized (this.b) {
            this.n = iCancelToken;
        }
    }

    @Override // com.google.android.gms.common.api.PendingResult
    public final void addStatusListener(PendingResult.StatusListener statusListener) {
        Preconditions.checkArgument(statusListener != null, "Callback cannot be null.");
        synchronized (this.b) {
            if (isReady()) {
                statusListener.onComplete(this.j);
            } else {
                this.f.add(statusListener);
            }
        }
    }

    @Override // com.google.android.gms.common.api.PendingResult
    public final R await() {
        Preconditions.checkNotMainThread("await must not be called on the UI thread");
        boolean z = true;
        Preconditions.checkState(!this.k, "Result has already been consumed");
        if (this.o != null) {
            z = false;
        }
        Preconditions.checkState(z, "Cannot await if then() has been called.");
        try {
            this.e.await();
        } catch (InterruptedException unused) {
            zab(Status.RESULT_INTERRUPTED);
        }
        Preconditions.checkState(isReady(), "Result is not ready.");
        return a();
    }

    @Override // com.google.android.gms.common.api.PendingResult
    public final R await(long j, TimeUnit timeUnit) {
        if (j > 0) {
            Preconditions.checkNotMainThread("await must not be called on the UI thread when time is greater than zero.");
        }
        boolean z = true;
        Preconditions.checkState(!this.k, "Result has already been consumed.");
        if (this.o != null) {
            z = false;
        }
        Preconditions.checkState(z, "Cannot await if then() has been called.");
        try {
            if (!this.e.await(j, timeUnit)) {
                zab(Status.RESULT_TIMEOUT);
            }
        } catch (InterruptedException unused) {
            zab(Status.RESULT_INTERRUPTED);
        }
        Preconditions.checkState(isReady(), "Result is not ready.");
        return a();
    }

    @Override // com.google.android.gms.common.api.PendingResult
    @KeepForSdk
    public void cancel() {
        synchronized (this.b) {
            if (!this.l && !this.k) {
                if (this.n != null) {
                    try {
                        this.n.cancel();
                    } catch (RemoteException unused) {
                    }
                }
                zab(this.i);
                this.l = true;
                a((BasePendingResult<R>) mo8createFailedResult(Status.RESULT_CANCELED));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @KeepForSdk
    /* renamed from: createFailedResult */
    public abstract R mo8createFailedResult(Status status);

    @Override // com.google.android.gms.common.api.PendingResult
    public boolean isCanceled() {
        boolean z;
        synchronized (this.b) {
            z = this.l;
        }
        return z;
    }

    @KeepForSdk
    public final boolean isReady() {
        return this.e.getCount() == 0;
    }

    @KeepForSdk
    public final void setResult(R r) {
        synchronized (this.b) {
            if (this.m || this.l) {
                zab(r);
                return;
            }
            isReady();
            boolean z = true;
            Preconditions.checkState(!isReady(), "Results have already been set");
            if (this.k) {
                z = false;
            }
            Preconditions.checkState(z, "Result has already been consumed");
            a((BasePendingResult<R>) r);
        }
    }

    @Override // com.google.android.gms.common.api.PendingResult
    @KeepForSdk
    public final void setResultCallback(ResultCallback<? super R> resultCallback) {
        synchronized (this.b) {
            if (resultCallback == null) {
                this.g = null;
                return;
            }
            boolean z = true;
            Preconditions.checkState(!this.k, "Result has already been consumed.");
            if (this.o != null) {
                z = false;
            }
            Preconditions.checkState(z, "Cannot set callbacks if then() has been called.");
            if (isCanceled()) {
                return;
            }
            if (isReady()) {
                this.c.zaa(resultCallback, a());
            } else {
                this.g = resultCallback;
            }
        }
    }

    @Override // com.google.android.gms.common.api.PendingResult
    @KeepForSdk
    public final void setResultCallback(ResultCallback<? super R> resultCallback, long j, TimeUnit timeUnit) {
        synchronized (this.b) {
            if (resultCallback == null) {
                this.g = null;
                return;
            }
            boolean z = true;
            Preconditions.checkState(!this.k, "Result has already been consumed.");
            if (this.o != null) {
                z = false;
            }
            Preconditions.checkState(z, "Cannot set callbacks if then() has been called.");
            if (isCanceled()) {
                return;
            }
            if (isReady()) {
                this.c.zaa(resultCallback, a());
            } else {
                this.g = resultCallback;
                CallbackHandler<R> callbackHandler = this.c;
                callbackHandler.sendMessageDelayed(callbackHandler.obtainMessage(2, this), timeUnit.toMillis(j));
            }
        }
    }

    @Override // com.google.android.gms.common.api.PendingResult
    public <S extends Result> TransformedResult<S> then(ResultTransform<? super R, ? extends S> resultTransform) {
        TransformedResult<S> then;
        Preconditions.checkState(!this.k, "Result has already been consumed.");
        synchronized (this.b) {
            boolean z = false;
            Preconditions.checkState(this.o == null, "Cannot call then() twice.");
            Preconditions.checkState(this.g == null, "Cannot call then() if callbacks are set.");
            if (!this.l) {
                z = true;
            }
            Preconditions.checkState(z, "Cannot call then() if result was canceled.");
            this.p = true;
            this.o = new zacm<>(this.d);
            then = this.o.then(resultTransform);
            if (isReady()) {
                this.c.zaa(this.o, a());
            } else {
                this.g = this.o;
            }
        }
        return then;
    }

    public final void zaa(au auVar) {
        this.h.set(auVar);
    }

    public final void zab(Status status) {
        synchronized (this.b) {
            if (!isReady()) {
                setResult(mo8createFailedResult(status));
                this.m = true;
            }
        }
    }

    @Override // com.google.android.gms.common.api.PendingResult
    public final Integer zam() {
        return null;
    }

    public final boolean zat() {
        boolean isCanceled;
        synchronized (this.b) {
            if (this.d.get() == null || !this.p) {
                cancel();
            }
            isCanceled = isCanceled();
        }
        return isCanceled;
    }

    public final void zau() {
        this.p = this.p || a.get().booleanValue();
    }
}
