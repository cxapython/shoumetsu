package com.google.android.gms.common.api.internal;

import android.os.Looper;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.ResultCallbacks;
import com.google.android.gms.common.api.ResultTransform;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.TransformedResult;
import com.google.android.gms.common.internal.Preconditions;
import java.lang.ref.WeakReference;
import javax.annotation.concurrent.GuardedBy;

/* loaded from: classes.dex */
public final class zacm<R extends Result> extends TransformedResult<R> implements ResultCallback<R> {
    private final WeakReference<GoogleApiClient> g;
    private final ar h;
    private ResultTransform<? super R, ? extends Result> a = null;
    private zacm<? extends Result> b = null;
    private volatile ResultCallbacks<? super R> c = null;
    private PendingResult<R> d = null;
    private final Object e = new Object();
    private Status f = null;
    private boolean i = false;

    public zacm(WeakReference<GoogleApiClient> weakReference) {
        Preconditions.checkNotNull(weakReference, "GoogleApiClient reference must not be null");
        this.g = weakReference;
        GoogleApiClient googleApiClient = this.g.get();
        this.h = new ar(this, googleApiClient != null ? googleApiClient.getLooper() : Looper.getMainLooper());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(Result result) {
        if (result instanceof Releasable) {
            try {
                ((Releasable) result).release();
            } catch (RuntimeException e) {
                String valueOf = String.valueOf(result);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 18);
                sb.append("Unable to release ");
                sb.append(valueOf);
                Log.w("TransformedResultImpl", sb.toString(), e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(Status status) {
        synchronized (this.e) {
            this.f = status;
            b(this.f);
        }
    }

    @GuardedBy("mSyncToken")
    private final void b() {
        if (this.a == null && this.c == null) {
            return;
        }
        GoogleApiClient googleApiClient = this.g.get();
        if (!this.i && this.a != null && googleApiClient != null) {
            googleApiClient.zaa(this);
            this.i = true;
        }
        Status status = this.f;
        if (status != null) {
            b(status);
            return;
        }
        PendingResult<R> pendingResult = this.d;
        if (pendingResult == null) {
            return;
        }
        pendingResult.setResultCallback(this);
    }

    private final void b(Status status) {
        synchronized (this.e) {
            if (this.a != null) {
                Status onFailure = this.a.onFailure(status);
                Preconditions.checkNotNull(onFailure, "onFailure must not return null");
                this.b.a(onFailure);
            } else if (c()) {
                this.c.onFailure(status);
            }
        }
    }

    @GuardedBy("mSyncToken")
    private final boolean c() {
        return (this.c == null || this.g.get() == null) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a() {
        this.c = null;
    }

    @Override // com.google.android.gms.common.api.TransformedResult
    public final void andFinally(ResultCallbacks<? super R> resultCallbacks) {
        synchronized (this.e) {
            boolean z = true;
            Preconditions.checkState(this.c == null, "Cannot call andFinally() twice.");
            if (this.a != null) {
                z = false;
            }
            Preconditions.checkState(z, "Cannot call then() and andFinally() on the same TransformedResult.");
            this.c = resultCallbacks;
            b();
        }
    }

    @Override // com.google.android.gms.common.api.ResultCallback
    public final void onResult(R r) {
        synchronized (this.e) {
            if (!r.getStatus().isSuccess()) {
                a(r.getStatus());
                a(r);
            } else if (this.a != null) {
                zacc.zabb().submit(new aq(this, r));
            } else if (c()) {
                this.c.onSuccess(r);
            }
        }
    }

    @Override // com.google.android.gms.common.api.TransformedResult
    public final <S extends Result> TransformedResult<S> then(ResultTransform<? super R, ? extends S> resultTransform) {
        zacm<? extends Result> zacmVar;
        synchronized (this.e) {
            boolean z = true;
            Preconditions.checkState(this.a == null, "Cannot call then() twice.");
            if (this.c != null) {
                z = false;
            }
            Preconditions.checkState(z, "Cannot call then() and andFinally() on the same TransformedResult.");
            this.a = resultTransform;
            zacmVar = new zacm<>(this.g);
            this.b = zacmVar;
            b();
        }
        return zacmVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void zaa(PendingResult<?> pendingResult) {
        synchronized (this.e) {
            this.d = pendingResult;
            b();
        }
    }
}
