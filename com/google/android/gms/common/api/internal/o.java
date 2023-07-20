package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.signin.zad;
import java.util.concurrent.locks.Lock;

/* loaded from: classes.dex */
final class o implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {
    private final /* synthetic */ zaak a;

    private o(zaak zaakVar) {
        this.a = zaakVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ o(zaak zaakVar, g gVar) {
        this(zaakVar);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks
    public final void onConnected(Bundle bundle) {
        ClientSettings clientSettings;
        zad zadVar;
        Lock lock;
        Lock lock2;
        zad zadVar2;
        zad zadVar3;
        clientSettings = this.a.r;
        if (!clientSettings.isSignInClientDisconnectFixEnabled()) {
            zadVar = this.a.k;
            zadVar.zaa(new m(this.a));
            return;
        }
        lock = this.a.b;
        lock.lock();
        try {
            zadVar2 = this.a.k;
            if (zadVar2 == null) {
                return;
            }
            zadVar3 = this.a.k;
            zadVar3.zaa(new m(this.a));
        } finally {
            lock2 = this.a.b;
            lock2.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener
    public final void onConnectionFailed(ConnectionResult connectionResult) {
        Lock lock;
        Lock lock2;
        boolean a;
        lock = this.a.b;
        lock.lock();
        try {
            a = this.a.a(connectionResult);
            if (a) {
                this.a.d();
                this.a.b();
            } else {
                this.a.b(connectionResult);
            }
        } finally {
            lock2 = this.a.b;
            lock2.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks
    public final void onConnectionSuspended(int i) {
    }
}
