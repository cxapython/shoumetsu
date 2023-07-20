package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.signin.SignInOptions;
import com.google.android.gms.signin.zad;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import javax.annotation.concurrent.GuardedBy;

/* loaded from: classes.dex */
public final class zabe implements zabs, zar {
    final Map<Api.AnyClientKey<?>, Api.Client> a;
    int c;
    final zaaw d;
    final zabt e;
    private final Lock f;
    private final Condition g;
    private final Context h;
    private final GoogleApiAvailabilityLight i;
    private final x j;
    private final ClientSettings k;
    private final Map<Api<?>, Boolean> l;
    private final Api.AbstractClientBuilder<? extends zad, SignInOptions> m;
    private volatile zabd n;
    final Map<Api.AnyClientKey<?>, ConnectionResult> b = new HashMap();
    private ConnectionResult o = null;

    public zabe(Context context, zaaw zaawVar, Lock lock, Looper looper, GoogleApiAvailabilityLight googleApiAvailabilityLight, Map<Api.AnyClientKey<?>, Api.Client> map, ClientSettings clientSettings, Map<Api<?>, Boolean> map2, Api.AbstractClientBuilder<? extends zad, SignInOptions> abstractClientBuilder, ArrayList<zaq> arrayList, zabt zabtVar) {
        this.h = context;
        this.f = lock;
        this.i = googleApiAvailabilityLight;
        this.a = map;
        this.k = clientSettings;
        this.l = map2;
        this.m = abstractClientBuilder;
        this.d = zaawVar;
        this.e = zabtVar;
        ArrayList<zaq> arrayList2 = arrayList;
        int size = arrayList2.size();
        int i = 0;
        while (i < size) {
            zaq zaqVar = arrayList2.get(i);
            i++;
            zaqVar.zaa(this);
        }
        this.j = new x(this, looper);
        this.g = lock.newCondition();
        this.n = new zaav(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a() {
        this.f.lock();
        try {
            this.n = new zaak(this, this.k, this.l, this.i, this.m, this.f, this.h);
            this.n.begin();
            this.g.signalAll();
        } finally {
            this.f.unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(ConnectionResult connectionResult) {
        this.f.lock();
        try {
            this.o = connectionResult;
            this.n = new zaav(this);
            this.n.begin();
            this.g.signalAll();
        } finally {
            this.f.unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(w wVar) {
        this.j.sendMessage(this.j.obtainMessage(1, wVar));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(RuntimeException runtimeException) {
        this.j.sendMessage(this.j.obtainMessage(2, runtimeException));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b() {
        this.f.lock();
        try {
            this.d.b();
            this.n = new zaah(this);
            this.n.begin();
            this.g.signalAll();
        } finally {
            this.f.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.internal.zabs
    @GuardedBy("mLock")
    public final ConnectionResult blockingConnect() {
        connect();
        while (isConnecting()) {
            try {
                this.g.await();
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
                return new ConnectionResult(15, null);
            }
        }
        if (isConnected()) {
            return ConnectionResult.RESULT_SUCCESS;
        }
        ConnectionResult connectionResult = this.o;
        return connectionResult != null ? connectionResult : new ConnectionResult(13, null);
    }

    @Override // com.google.android.gms.common.api.internal.zabs
    @GuardedBy("mLock")
    public final ConnectionResult blockingConnect(long j, TimeUnit timeUnit) {
        connect();
        long nanos = timeUnit.toNanos(j);
        while (isConnecting()) {
            if (nanos <= 0) {
                disconnect();
                return new ConnectionResult(14, null);
            }
            try {
                nanos = this.g.awaitNanos(nanos);
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
                return new ConnectionResult(15, null);
            }
            Thread.currentThread().interrupt();
            return new ConnectionResult(15, null);
        }
        if (isConnected()) {
            return ConnectionResult.RESULT_SUCCESS;
        }
        ConnectionResult connectionResult = this.o;
        return connectionResult != null ? connectionResult : new ConnectionResult(13, null);
    }

    @Override // com.google.android.gms.common.api.internal.zabs
    @GuardedBy("mLock")
    public final void connect() {
        this.n.connect();
    }

    @Override // com.google.android.gms.common.api.internal.zabs
    @GuardedBy("mLock")
    public final void disconnect() {
        if (this.n.disconnect()) {
            this.b.clear();
        }
    }

    @Override // com.google.android.gms.common.api.internal.zabs
    public final void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        String concat = String.valueOf(str).concat("  ");
        printWriter.append((CharSequence) str).append("mState=").println(this.n);
        for (Api<?> api : this.l.keySet()) {
            printWriter.append((CharSequence) str).append((CharSequence) api.getName()).println(":");
            this.a.get(api.getClientKey()).dump(concat, fileDescriptor, printWriter, strArr);
        }
    }

    @Override // com.google.android.gms.common.api.internal.zabs
    @GuardedBy("mLock")
    public final <A extends Api.AnyClient, R extends Result, T extends BaseImplementation.ApiMethodImpl<R, A>> T enqueue(T t) {
        t.zau();
        return (T) this.n.enqueue(t);
    }

    @Override // com.google.android.gms.common.api.internal.zabs
    @GuardedBy("mLock")
    public final <A extends Api.AnyClient, T extends BaseImplementation.ApiMethodImpl<? extends Result, A>> T execute(T t) {
        t.zau();
        return (T) this.n.execute(t);
    }

    @Override // com.google.android.gms.common.api.internal.zabs
    @GuardedBy("mLock")
    public final ConnectionResult getConnectionResult(Api<?> api) {
        Api.AnyClientKey<?> clientKey = api.getClientKey();
        if (this.a.containsKey(clientKey)) {
            if (this.a.get(clientKey).isConnected()) {
                return ConnectionResult.RESULT_SUCCESS;
            }
            if (!this.b.containsKey(clientKey)) {
                return null;
            }
            return this.b.get(clientKey);
        }
        return null;
    }

    @Override // com.google.android.gms.common.api.internal.zabs
    public final boolean isConnected() {
        return this.n instanceof zaah;
    }

    @Override // com.google.android.gms.common.api.internal.zabs
    public final boolean isConnecting() {
        return this.n instanceof zaak;
    }

    @Override // com.google.android.gms.common.api.internal.zabs
    public final boolean maybeSignIn(SignInConnectionListener signInConnectionListener) {
        return false;
    }

    @Override // com.google.android.gms.common.api.internal.zabs
    public final void maybeSignOut() {
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks
    public final void onConnected(Bundle bundle) {
        this.f.lock();
        try {
            this.n.onConnected(bundle);
        } finally {
            this.f.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks
    public final void onConnectionSuspended(int i) {
        this.f.lock();
        try {
            this.n.onConnectionSuspended(i);
        } finally {
            this.f.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.internal.zar
    public final void zaa(ConnectionResult connectionResult, Api<?> api, boolean z) {
        this.f.lock();
        try {
            this.n.zaa(connectionResult, api, z);
        } finally {
            this.f.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.internal.zabs
    @GuardedBy("mLock")
    public final void zaw() {
        if (isConnected()) {
            ((zaah) this.n).a();
        }
    }
}
