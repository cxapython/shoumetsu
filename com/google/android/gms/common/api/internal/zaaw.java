package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.GmsClientEventManager;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.service.Common;
import com.google.android.gms.common.util.ClientLibraryUtils;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.signin.SignInOptions;
import com.google.android.gms.signin.zad;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Lock;
import javax.annotation.concurrent.GuardedBy;

/* loaded from: classes.dex */
public final class zaaw extends GoogleApiClient implements zabt {
    final Map<Api.AnyClientKey<?>, Api.Client> b;
    Set<Scope> c;
    Set<zacm> d;
    final zacp e;
    private final Lock f;
    private boolean g;
    private final GmsClientEventManager h;
    private final int j;
    private final Context k;
    private final Looper l;
    private volatile boolean m;
    private long n;
    private long o;
    private final u p;
    private final GoogleApiAvailability q;
    @VisibleForTesting
    private zabq r;
    private final ClientSettings s;
    private final Map<Api<?>, Boolean> t;
    private final Api.AbstractClientBuilder<? extends zad, SignInOptions> u;
    private final ListenerHolders v;
    private final ArrayList<zaq> w;
    private Integer x;
    private final GmsClientEventManager.GmsClientEventState y;
    private zabs i = null;
    @VisibleForTesting
    final Queue<BaseImplementation.ApiMethodImpl<?, ?>> a = new LinkedList();

    public zaaw(Context context, Lock lock, Looper looper, ClientSettings clientSettings, GoogleApiAvailability googleApiAvailability, Api.AbstractClientBuilder<? extends zad, SignInOptions> abstractClientBuilder, Map<Api<?>, Boolean> map, List<GoogleApiClient.ConnectionCallbacks> list, List<GoogleApiClient.OnConnectionFailedListener> list2, Map<Api.AnyClientKey<?>, Api.Client> map2, int i, int i2, ArrayList<zaq> arrayList, boolean z) {
        this.n = ClientLibraryUtils.isPackageSide() ? 10000L : 120000L;
        this.o = 5000L;
        this.c = new HashSet();
        this.v = new ListenerHolders();
        this.x = null;
        this.d = null;
        this.y = new q(this);
        this.k = context;
        this.f = lock;
        this.g = false;
        this.h = new GmsClientEventManager(looper, this.y);
        this.l = looper;
        this.p = new u(this, looper);
        this.q = googleApiAvailability;
        this.j = i;
        if (this.j >= 0) {
            this.x = Integer.valueOf(i2);
        }
        this.t = map;
        this.b = map2;
        this.w = arrayList;
        this.e = new zacp(this.b);
        for (GoogleApiClient.ConnectionCallbacks connectionCallbacks : list) {
            this.h.registerConnectionCallbacks(connectionCallbacks);
        }
        for (GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener : list2) {
            this.h.registerConnectionFailedListener(onConnectionFailedListener);
        }
        this.s = clientSettings;
        this.u = abstractClientBuilder;
    }

    private final void a(int i) {
        Integer num = this.x;
        if (num == null) {
            this.x = Integer.valueOf(i);
        } else if (num.intValue() != i) {
            String b = b(i);
            String b2 = b(this.x.intValue());
            StringBuilder sb = new StringBuilder(String.valueOf(b).length() + 51 + String.valueOf(b2).length());
            sb.append("Cannot use sign-in mode: ");
            sb.append(b);
            sb.append(". Mode was already set to ");
            sb.append(b2);
            throw new IllegalStateException(sb.toString());
        }
        if (this.i != null) {
            return;
        }
        boolean z = false;
        boolean z2 = false;
        for (Api.Client client : this.b.values()) {
            if (client.requiresSignIn()) {
                z = true;
            }
            if (client.providesSignIn()) {
                z2 = true;
            }
        }
        switch (this.x.intValue()) {
            case 1:
                if (!z) {
                    throw new IllegalStateException("SIGN_IN_MODE_REQUIRED cannot be used on a GoogleApiClient that does not contain any authenticated APIs. Use connect() instead.");
                }
                if (z2) {
                    throw new IllegalStateException("Cannot use SIGN_IN_MODE_REQUIRED with GOOGLE_SIGN_IN_API. Use connect(SIGN_IN_MODE_OPTIONAL) instead.");
                }
                break;
            case 2:
                if (z) {
                    if (this.g) {
                        this.i = new zax(this.k, this.f, this.l, this.q, this.b, this.s, this.t, this.u, this.w, this, true);
                        return;
                    } else {
                        this.i = ba.a(this.k, this, this.f, this.l, this.q, this.b, this.s, this.t, this.u, this.w);
                        return;
                    }
                }
                break;
        }
        if (!this.g || z2) {
            this.i = new zabe(this.k, this, this.f, this.l, this.q, this.b, this.s, this.t, this.u, this.w, this);
        } else {
            this.i = new zax(this.k, this.f, this.l, this.q, this.b, this.s, this.t, this.u, this.w, this, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(GoogleApiClient googleApiClient, StatusPendingResult statusPendingResult, boolean z) {
        Common.zapi.zaa(googleApiClient).setResultCallback(new t(this, statusPendingResult, z, googleApiClient));
    }

    private static String b(int i) {
        switch (i) {
            case 1:
                return "SIGN_IN_MODE_REQUIRED";
            case 2:
                return "SIGN_IN_MODE_OPTIONAL";
            case 3:
                return "SIGN_IN_MODE_NONE";
            default:
                return "UNKNOWN";
        }
    }

    @GuardedBy("mLock")
    private final void e() {
        this.h.enableCallbacks();
        this.i.connect();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f() {
        this.f.lock();
        try {
            if (this.m) {
                e();
            }
        } finally {
            this.f.unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g() {
        this.f.lock();
        try {
            if (b()) {
                e();
            }
        } finally {
            this.f.unlock();
        }
    }

    public static int zaa(Iterable<Api.Client> iterable, boolean z) {
        boolean z2 = false;
        boolean z3 = false;
        for (Api.Client client : iterable) {
            if (client.requiresSignIn()) {
                z2 = true;
            }
            if (client.providesSignIn()) {
                z3 = true;
            }
        }
        if (z2) {
            return (!z3 || !z) ? 1 : 2;
        }
        return 3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @GuardedBy("mLock")
    public final boolean b() {
        if (!this.m) {
            return false;
        }
        this.m = false;
        this.p.removeMessages(2);
        this.p.removeMessages(1);
        zabq zabqVar = this.r;
        if (zabqVar != null) {
            zabqVar.unregister();
            this.r = null;
        }
        return true;
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final ConnectionResult blockingConnect() {
        boolean z = true;
        Preconditions.checkState(Looper.myLooper() != Looper.getMainLooper(), "blockingConnect must not be called on the UI thread");
        this.f.lock();
        try {
            if (this.j >= 0) {
                if (this.x == null) {
                    z = false;
                }
                Preconditions.checkState(z, "Sign-in mode should have been set explicitly by auto-manage.");
            } else if (this.x == null) {
                this.x = Integer.valueOf(zaa(this.b.values(), false));
            } else if (this.x.intValue() == 2) {
                throw new IllegalStateException("Cannot call blockingConnect() when sign-in mode is set to SIGN_IN_MODE_OPTIONAL. Call connect(SIGN_IN_MODE_OPTIONAL) instead.");
            }
            a(this.x.intValue());
            this.h.enableCallbacks();
            return this.i.blockingConnect();
        } finally {
            this.f.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final ConnectionResult blockingConnect(long j, TimeUnit timeUnit) {
        Preconditions.checkState(Looper.myLooper() != Looper.getMainLooper(), "blockingConnect must not be called on the UI thread");
        Preconditions.checkNotNull(timeUnit, "TimeUnit must not be null");
        this.f.lock();
        try {
            if (this.x == null) {
                this.x = Integer.valueOf(zaa(this.b.values(), false));
            } else if (this.x.intValue() == 2) {
                throw new IllegalStateException("Cannot call blockingConnect() when sign-in mode is set to SIGN_IN_MODE_OPTIONAL. Call connect(SIGN_IN_MODE_OPTIONAL) instead.");
            }
            a(this.x.intValue());
            this.h.enableCallbacks();
            return this.i.blockingConnect(j, timeUnit);
        } finally {
            this.f.unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean c() {
        this.f.lock();
        try {
            if (this.d != null) {
                return !this.d.isEmpty();
            }
            this.f.unlock();
            return false;
        } finally {
            this.f.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final PendingResult<Status> clearDefaultAccountAndReconnect() {
        Preconditions.checkState(isConnected(), "GoogleApiClient is not connected yet.");
        Preconditions.checkState(this.x.intValue() != 2, "Cannot use clearDefaultAccountAndReconnect with GOOGLE_SIGN_IN_API");
        StatusPendingResult statusPendingResult = new StatusPendingResult(this);
        if (this.b.containsKey(Common.CLIENT_KEY)) {
            a(this, statusPendingResult, false);
        } else {
            AtomicReference atomicReference = new AtomicReference();
            GoogleApiClient build = new GoogleApiClient.Builder(this.k).addApi(Common.API).addConnectionCallbacks(new r(this, atomicReference, statusPendingResult)).addOnConnectionFailedListener(new s(this, statusPendingResult)).setHandler(this.p).build();
            atomicReference.set(build);
            build.connect();
        }
        return statusPendingResult;
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final void connect() {
        this.f.lock();
        try {
            boolean z = false;
            if (this.j >= 0) {
                if (this.x != null) {
                    z = true;
                }
                Preconditions.checkState(z, "Sign-in mode should have been set explicitly by auto-manage.");
            } else if (this.x == null) {
                this.x = Integer.valueOf(zaa(this.b.values(), false));
            } else if (this.x.intValue() == 2) {
                throw new IllegalStateException("Cannot call connect() when SignInMode is set to SIGN_IN_MODE_OPTIONAL. Call connect(SIGN_IN_MODE_OPTIONAL) instead.");
            }
            connect(this.x.intValue());
        } finally {
            this.f.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final void connect(int i) {
        this.f.lock();
        boolean z = true;
        if (i != 3 && i != 1 && i != 2) {
            z = false;
        }
        try {
            StringBuilder sb = new StringBuilder(33);
            sb.append("Illegal sign-in mode: ");
            sb.append(i);
            Preconditions.checkArgument(z, sb.toString());
            a(i);
            e();
        } finally {
            this.f.unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String d() {
        StringWriter stringWriter = new StringWriter();
        dump("", null, new PrintWriter(stringWriter), null);
        return stringWriter.toString();
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final void disconnect() {
        this.f.lock();
        try {
            this.e.release();
            if (this.i != null) {
                this.i.disconnect();
            }
            this.v.release();
            for (BaseImplementation.ApiMethodImpl<?, ?> apiMethodImpl : this.a) {
                apiMethodImpl.zaa(null);
                apiMethodImpl.cancel();
            }
            this.a.clear();
            if (this.i != null) {
                b();
                this.h.disableCallbacks();
            }
        } finally {
            this.f.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.append((CharSequence) str).append("mContext=").println(this.k);
        printWriter.append((CharSequence) str).append("mResuming=").print(this.m);
        printWriter.append(" mWorkQueue.size()=").print(this.a.size());
        printWriter.append(" mUnconsumedApiCalls.size()=").println(this.e.a.size());
        zabs zabsVar = this.i;
        if (zabsVar != null) {
            zabsVar.dump(str, fileDescriptor, printWriter, strArr);
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final <A extends Api.AnyClient, R extends Result, T extends BaseImplementation.ApiMethodImpl<R, A>> T enqueue(T t) {
        Preconditions.checkArgument(t.getClientKey() != null, "This task can not be enqueued (it's probably a Batch or malformed)");
        boolean containsKey = this.b.containsKey(t.getClientKey());
        String name = t.getApi() != null ? t.getApi().getName() : "the API";
        StringBuilder sb = new StringBuilder(String.valueOf(name).length() + 65);
        sb.append("GoogleApiClient is not configured to use ");
        sb.append(name);
        sb.append(" required for this call.");
        Preconditions.checkArgument(containsKey, sb.toString());
        this.f.lock();
        try {
            if (this.i == null) {
                this.a.add(t);
            } else {
                t = (T) this.i.enqueue(t);
            }
            return t;
        } finally {
            this.f.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final <A extends Api.AnyClient, T extends BaseImplementation.ApiMethodImpl<? extends Result, A>> T execute(T t) {
        Preconditions.checkArgument(t.getClientKey() != null, "This task can not be executed (it's probably a Batch or malformed)");
        boolean containsKey = this.b.containsKey(t.getClientKey());
        String name = t.getApi() != null ? t.getApi().getName() : "the API";
        StringBuilder sb = new StringBuilder(String.valueOf(name).length() + 65);
        sb.append("GoogleApiClient is not configured to use ");
        sb.append(name);
        sb.append(" required for this call.");
        Preconditions.checkArgument(containsKey, sb.toString());
        this.f.lock();
        try {
            if (this.i == null) {
                throw new IllegalStateException("GoogleApiClient is not connected yet.");
            }
            if (this.m) {
                this.a.add(t);
                while (!this.a.isEmpty()) {
                    BaseImplementation.ApiMethodImpl<?, ?> remove = this.a.remove();
                    this.e.a(remove);
                    remove.setFailedResult(Status.RESULT_INTERNAL_ERROR);
                }
            } else {
                t = (T) this.i.execute(t);
            }
            return t;
        } finally {
            this.f.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final <C extends Api.Client> C getClient(Api.AnyClientKey<C> anyClientKey) {
        C c = (C) this.b.get(anyClientKey);
        Preconditions.checkNotNull(c, "Appropriate Api was not requested.");
        return c;
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final ConnectionResult getConnectionResult(Api<?> api) {
        ConnectionResult connectionResult;
        this.f.lock();
        try {
            if (!isConnected() && !this.m) {
                throw new IllegalStateException("Cannot invoke getConnectionResult unless GoogleApiClient is connected");
            }
            if (!this.b.containsKey(api.getClientKey())) {
                throw new IllegalArgumentException(String.valueOf(api.getName()).concat(" was never registered with GoogleApiClient"));
            }
            ConnectionResult connectionResult2 = this.i.getConnectionResult(api);
            if (connectionResult2 != null) {
                return connectionResult2;
            }
            if (this.m) {
                connectionResult = ConnectionResult.RESULT_SUCCESS;
            } else {
                Log.w("GoogleApiClientImpl", d());
                Log.wtf("GoogleApiClientImpl", String.valueOf(api.getName()).concat(" requested in getConnectionResult is not connected but is not present in the failed  connections map"), new Exception());
                connectionResult = new ConnectionResult(8, null);
            }
            return connectionResult;
        } finally {
            this.f.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final Context getContext() {
        return this.k;
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final Looper getLooper() {
        return this.l;
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final boolean hasApi(Api<?> api) {
        return this.b.containsKey(api.getClientKey());
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final boolean hasConnectedApi(Api<?> api) {
        Api.Client client;
        return isConnected() && (client = this.b.get(api.getClientKey())) != null && client.isConnected();
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final boolean isConnected() {
        zabs zabsVar = this.i;
        return zabsVar != null && zabsVar.isConnected();
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final boolean isConnecting() {
        zabs zabsVar = this.i;
        return zabsVar != null && zabsVar.isConnecting();
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final boolean isConnectionCallbacksRegistered(GoogleApiClient.ConnectionCallbacks connectionCallbacks) {
        return this.h.isConnectionCallbacksRegistered(connectionCallbacks);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final boolean isConnectionFailedListenerRegistered(GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        return this.h.isConnectionFailedListenerRegistered(onConnectionFailedListener);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final boolean maybeSignIn(SignInConnectionListener signInConnectionListener) {
        zabs zabsVar = this.i;
        return zabsVar != null && zabsVar.maybeSignIn(signInConnectionListener);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final void maybeSignOut() {
        zabs zabsVar = this.i;
        if (zabsVar != null) {
            zabsVar.maybeSignOut();
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final void reconnect() {
        disconnect();
        connect();
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final void registerConnectionCallbacks(GoogleApiClient.ConnectionCallbacks connectionCallbacks) {
        this.h.registerConnectionCallbacks(connectionCallbacks);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final void registerConnectionFailedListener(GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        this.h.registerConnectionFailedListener(onConnectionFailedListener);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final <L> ListenerHolder<L> registerListener(L l) {
        this.f.lock();
        try {
            return this.v.zaa(l, this.l, "NO_TYPE");
        } finally {
            this.f.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final void stopAutoManage(androidx.e.a.e eVar) {
        LifecycleActivity lifecycleActivity = new LifecycleActivity((Activity) eVar);
        if (this.j >= 0) {
            zaj.zaa(lifecycleActivity).zaa(this.j);
            return;
        }
        throw new IllegalStateException("Called stopAutoManage but automatic lifecycle management is not enabled.");
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final void unregisterConnectionCallbacks(GoogleApiClient.ConnectionCallbacks connectionCallbacks) {
        this.h.unregisterConnectionCallbacks(connectionCallbacks);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final void unregisterConnectionFailedListener(GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        this.h.unregisterConnectionFailedListener(onConnectionFailedListener);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final void zaa(zacm zacmVar) {
        this.f.lock();
        try {
            if (this.d == null) {
                this.d = new HashSet();
            }
            this.d.add(zacmVar);
        } finally {
            this.f.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.internal.zabt
    @GuardedBy("mLock")
    public final void zab(int i, boolean z) {
        if (i == 1 && !z && !this.m) {
            this.m = true;
            if (this.r == null && !ClientLibraryUtils.isPackageSide()) {
                this.r = this.q.zaa(this.k.getApplicationContext(), new v(this));
            }
            u uVar = this.p;
            uVar.sendMessageDelayed(uVar.obtainMessage(1), this.n);
            u uVar2 = this.p;
            uVar2.sendMessageDelayed(uVar2.obtainMessage(2), this.o);
        }
        this.e.zabx();
        this.h.onUnintentionalDisconnection(i);
        this.h.disableCallbacks();
        if (i == 2) {
            e();
        }
    }

    @Override // com.google.android.gms.common.api.internal.zabt
    @GuardedBy("mLock")
    public final void zab(Bundle bundle) {
        while (!this.a.isEmpty()) {
            execute(this.a.remove());
        }
        this.h.onConnectionSuccess(bundle);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final void zab(zacm zacmVar) {
        String str;
        String str2;
        Exception exc;
        this.f.lock();
        try {
            if (this.d == null) {
                str = "GoogleApiClientImpl";
                str2 = "Attempted to remove pending transform when no transforms are registered.";
                exc = new Exception();
            } else if (this.d.remove(zacmVar)) {
                if (!c()) {
                    this.i.zaw();
                }
            } else {
                str = "GoogleApiClientImpl";
                str2 = "Failed to remove pending transform - this may lead to memory leaks!";
                exc = new Exception();
            }
            Log.wtf(str, str2, exc);
        } finally {
            this.f.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.internal.zabt
    @GuardedBy("mLock")
    public final void zac(ConnectionResult connectionResult) {
        if (!this.q.isPlayServicesPossiblyUpdating(this.k, connectionResult.getErrorCode())) {
            b();
        }
        if (!this.m) {
            this.h.onConnectionFailure(connectionResult);
            this.h.disableCallbacks();
        }
    }
}
