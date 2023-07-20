package com.google.android.gms.common.api.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.base.zap;
import com.google.android.gms.signin.SignInOptions;
import com.google.android.gms.signin.zad;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import javax.annotation.concurrent.GuardedBy;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class ba implements zabs {
    private final Context a;
    private final zaaw b;
    private final Looper c;
    private final zabe d;
    private final zabe e;
    private final Map<Api.AnyClientKey<?>, zabe> f;
    private final Api.Client h;
    private Bundle i;
    private final Lock m;
    private final Set<SignInConnectionListener> g = Collections.newSetFromMap(new WeakHashMap());
    private ConnectionResult j = null;
    private ConnectionResult k = null;
    private boolean l = false;
    @GuardedBy("mLock")
    private int n = 0;

    private ba(Context context, zaaw zaawVar, Lock lock, Looper looper, GoogleApiAvailabilityLight googleApiAvailabilityLight, Map<Api.AnyClientKey<?>, Api.Client> map, Map<Api.AnyClientKey<?>, Api.Client> map2, ClientSettings clientSettings, Api.AbstractClientBuilder<? extends zad, SignInOptions> abstractClientBuilder, Api.Client client, ArrayList<zaq> arrayList, ArrayList<zaq> arrayList2, Map<Api<?>, Boolean> map3, Map<Api<?>, Boolean> map4) {
        this.a = context;
        this.b = zaawVar;
        this.m = lock;
        this.c = looper;
        this.h = client;
        this.d = new zabe(context, this.b, lock, looper, googleApiAvailabilityLight, map2, null, map4, null, arrayList2, new bc(this, null));
        this.e = new zabe(context, this.b, lock, looper, googleApiAvailabilityLight, map, clientSettings, map3, abstractClientBuilder, arrayList, new bd(this, null));
        androidx.b.a aVar = new androidx.b.a();
        for (Api.AnyClientKey<?> anyClientKey : map2.keySet()) {
            aVar.put(anyClientKey, this.d);
        }
        for (Api.AnyClientKey<?> anyClientKey2 : map.keySet()) {
            aVar.put(anyClientKey2, this.e);
        }
        this.f = Collections.unmodifiableMap(aVar);
    }

    public static ba a(Context context, zaaw zaawVar, Lock lock, Looper looper, GoogleApiAvailabilityLight googleApiAvailabilityLight, Map<Api.AnyClientKey<?>, Api.Client> map, ClientSettings clientSettings, Map<Api<?>, Boolean> map2, Api.AbstractClientBuilder<? extends zad, SignInOptions> abstractClientBuilder, ArrayList<zaq> arrayList) {
        androidx.b.a aVar = new androidx.b.a();
        androidx.b.a aVar2 = new androidx.b.a();
        Api.Client client = null;
        for (Map.Entry<Api.AnyClientKey<?>, Api.Client> entry : map.entrySet()) {
            Api.Client value = entry.getValue();
            if (value.providesSignIn()) {
                client = value;
            }
            if (value.requiresSignIn()) {
                aVar.put(entry.getKey(), value);
            } else {
                aVar2.put(entry.getKey(), value);
            }
        }
        Preconditions.checkState(!aVar.isEmpty(), "CompositeGoogleApiClient should not be used without any APIs that require sign-in.");
        androidx.b.a aVar3 = new androidx.b.a();
        androidx.b.a aVar4 = new androidx.b.a();
        for (Api<?> api : map2.keySet()) {
            Api.AnyClientKey<?> clientKey = api.getClientKey();
            if (aVar.containsKey(clientKey)) {
                aVar3.put(api, map2.get(api));
            } else if (!aVar2.containsKey(clientKey)) {
                throw new IllegalStateException("Each API in the isOptionalMap must have a corresponding client in the clients map.");
            } else {
                aVar4.put(api, map2.get(api));
            }
        }
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList<zaq> arrayList4 = arrayList;
        int size = arrayList4.size();
        int i = 0;
        while (i < size) {
            zaq zaqVar = arrayList4.get(i);
            i++;
            zaq zaqVar2 = zaqVar;
            if (aVar3.containsKey(zaqVar2.mApi)) {
                arrayList2.add(zaqVar2);
            } else if (!aVar4.containsKey(zaqVar2.mApi)) {
                throw new IllegalStateException("Each ClientCallbacks must have a corresponding API in the isOptionalMap");
            } else {
                arrayList3.add(zaqVar2);
            }
        }
        return new ba(context, zaawVar, lock, looper, googleApiAvailabilityLight, aVar, aVar2, clientSettings, abstractClientBuilder, client, arrayList2, arrayList3, aVar3, aVar4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @GuardedBy("mLock")
    public final void a() {
        if (!b(this.j)) {
            if (this.j != null && b(this.k)) {
                this.e.disconnect();
                a(this.j);
                return;
            }
            ConnectionResult connectionResult = this.j;
            if (connectionResult == null || this.k == null) {
                return;
            }
            if (this.e.c < this.d.c) {
                connectionResult = this.k;
            }
            a(connectionResult);
        } else if (b(this.k) || c()) {
            switch (this.n) {
                case 2:
                    this.b.zab(this.i);
                case 1:
                    b();
                    break;
                default:
                    Log.wtf("CompositeGAC", "Attempted to call success callbacks in CONNECTION_MODE_NONE. Callbacks should be disabled via GmsClientSupervisor", new AssertionError());
                    break;
            }
            this.n = 0;
        } else {
            ConnectionResult connectionResult2 = this.k;
            if (connectionResult2 == null) {
                return;
            }
            if (this.n == 1) {
                b();
                return;
            }
            a(connectionResult2);
            this.d.disconnect();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @GuardedBy("mLock")
    public final void a(int i, boolean z) {
        this.b.zab(i, z);
        this.k = null;
        this.j = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(Bundle bundle) {
        Bundle bundle2 = this.i;
        if (bundle2 == null) {
            this.i = bundle;
        } else if (bundle == null) {
        } else {
            bundle2.putAll(bundle);
        }
    }

    @GuardedBy("mLock")
    private final void a(ConnectionResult connectionResult) {
        switch (this.n) {
            case 2:
                this.b.zac(connectionResult);
            case 1:
                b();
                break;
            default:
                Log.wtf("CompositeGAC", "Attempted to call failure callbacks in CONNECTION_MODE_NONE. Callbacks should be disabled via GmsClientSupervisor", new Exception());
                break;
        }
        this.n = 0;
    }

    private final boolean a(BaseImplementation.ApiMethodImpl<? extends Result, ? extends Api.AnyClient> apiMethodImpl) {
        Api.AnyClientKey<? extends Api.AnyClient> clientKey = apiMethodImpl.getClientKey();
        Preconditions.checkArgument(this.f.containsKey(clientKey), "GoogleApiClient is not configured to use the API required for this call.");
        return this.f.get(clientKey).equals(this.e);
    }

    @GuardedBy("mLock")
    private final void b() {
        for (SignInConnectionListener signInConnectionListener : this.g) {
            signInConnectionListener.onComplete();
        }
        this.g.clear();
    }

    private static boolean b(ConnectionResult connectionResult) {
        return connectionResult != null && connectionResult.isSuccess();
    }

    @GuardedBy("mLock")
    private final boolean c() {
        ConnectionResult connectionResult = this.k;
        return connectionResult != null && connectionResult.getErrorCode() == 4;
    }

    private final PendingIntent d() {
        if (this.h == null) {
            return null;
        }
        return PendingIntent.getActivity(this.a, System.identityHashCode(this.b), this.h.getSignInIntent(), 134217728);
    }

    @Override // com.google.android.gms.common.api.internal.zabs
    @GuardedBy("mLock")
    public final ConnectionResult blockingConnect() {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.gms.common.api.internal.zabs
    @GuardedBy("mLock")
    public final ConnectionResult blockingConnect(long j, TimeUnit timeUnit) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.gms.common.api.internal.zabs
    @GuardedBy("mLock")
    public final void connect() {
        this.n = 2;
        this.l = false;
        this.k = null;
        this.j = null;
        this.d.connect();
        this.e.connect();
    }

    @Override // com.google.android.gms.common.api.internal.zabs
    @GuardedBy("mLock")
    public final void disconnect() {
        this.k = null;
        this.j = null;
        this.n = 0;
        this.d.disconnect();
        this.e.disconnect();
        b();
    }

    @Override // com.google.android.gms.common.api.internal.zabs
    public final void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.append((CharSequence) str).append("authClient").println(":");
        this.e.dump(String.valueOf(str).concat("  "), fileDescriptor, printWriter, strArr);
        printWriter.append((CharSequence) str).append("anonClient").println(":");
        this.d.dump(String.valueOf(str).concat("  "), fileDescriptor, printWriter, strArr);
    }

    @Override // com.google.android.gms.common.api.internal.zabs
    @GuardedBy("mLock")
    public final <A extends Api.AnyClient, R extends Result, T extends BaseImplementation.ApiMethodImpl<R, A>> T enqueue(T t) {
        if (a((BaseImplementation.ApiMethodImpl<? extends Result, ? extends Api.AnyClient>) t)) {
            if (!c()) {
                return (T) this.e.enqueue(t);
            }
            t.setFailedResult(new Status(4, null, d()));
            return t;
        }
        return (T) this.d.enqueue(t);
    }

    @Override // com.google.android.gms.common.api.internal.zabs
    @GuardedBy("mLock")
    public final <A extends Api.AnyClient, T extends BaseImplementation.ApiMethodImpl<? extends Result, A>> T execute(T t) {
        if (a((BaseImplementation.ApiMethodImpl<? extends Result, ? extends Api.AnyClient>) t)) {
            if (!c()) {
                return (T) this.e.execute(t);
            }
            t.setFailedResult(new Status(4, null, d()));
            return t;
        }
        return (T) this.d.execute(t);
    }

    @Override // com.google.android.gms.common.api.internal.zabs
    @GuardedBy("mLock")
    public final ConnectionResult getConnectionResult(Api<?> api) {
        return this.f.get(api.getClientKey()).equals(this.e) ? c() ? new ConnectionResult(4, d()) : this.e.getConnectionResult(api) : this.d.getConnectionResult(api);
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x001e, code lost:
        if (r2.n == 1) goto L12;
     */
    @Override // com.google.android.gms.common.api.internal.zabs
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean isConnected() {
        this.m.lock();
        try {
            boolean z = true;
            if (this.d.isConnected()) {
                if (!this.e.isConnected() && !c()) {
                }
                return z;
            }
            z = false;
            return z;
        } finally {
            this.m.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.internal.zabs
    public final boolean isConnecting() {
        this.m.lock();
        try {
            return this.n == 2;
        } finally {
            this.m.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.internal.zabs
    public final boolean maybeSignIn(SignInConnectionListener signInConnectionListener) {
        this.m.lock();
        try {
            if ((!isConnecting() && !isConnected()) || this.e.isConnected()) {
                this.m.unlock();
                return false;
            }
            this.g.add(signInConnectionListener);
            if (this.n == 0) {
                this.n = 1;
            }
            this.k = null;
            this.e.connect();
            return true;
        } finally {
            this.m.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.internal.zabs
    public final void maybeSignOut() {
        this.m.lock();
        try {
            boolean isConnecting = isConnecting();
            this.e.disconnect();
            this.k = new ConnectionResult(4);
            if (isConnecting) {
                new zap(this.c).post(new bb(this));
            } else {
                b();
            }
        } finally {
            this.m.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.internal.zabs
    @GuardedBy("mLock")
    public final void zaw() {
        this.d.zaw();
        this.e.zaw();
    }
}
