package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ResolveAccountResponse;
import com.google.android.gms.signin.SignInOptions;
import com.google.android.gms.signin.zad;
import java.util.Set;

/* loaded from: classes.dex */
public final class zace extends com.google.android.gms.signin.internal.zac implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {
    private static Api.AbstractClientBuilder<? extends zad, SignInOptions> a = com.google.android.gms.signin.zaa.zaph;
    private final Context b;
    private final Handler c;
    private final Api.AbstractClientBuilder<? extends zad, SignInOptions> d;
    private Set<Scope> e;
    private ClientSettings f;
    private zad g;
    private zach h;

    public zace(Context context, Handler handler, ClientSettings clientSettings) {
        this(context, handler, clientSettings, a);
    }

    public zace(Context context, Handler handler, ClientSettings clientSettings, Api.AbstractClientBuilder<? extends zad, SignInOptions> abstractClientBuilder) {
        this.b = context;
        this.c = handler;
        this.f = (ClientSettings) Preconditions.checkNotNull(clientSettings, "ClientSettings must not be null");
        this.e = clientSettings.getRequiredScopes();
        this.d = abstractClientBuilder;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(com.google.android.gms.signin.internal.zaj zajVar) {
        ConnectionResult connectionResult = zajVar.getConnectionResult();
        if (connectionResult.isSuccess()) {
            ResolveAccountResponse zacx = zajVar.zacx();
            connectionResult = zacx.getConnectionResult();
            if (connectionResult.isSuccess()) {
                this.h.zaa(zacx.getAccountAccessor(), this.e);
                this.g.disconnect();
            }
            String valueOf = String.valueOf(connectionResult);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 48);
            sb.append("Sign-in succeeded with resolve account failure: ");
            sb.append(valueOf);
            Log.wtf("SignInCoordinator", sb.toString(), new Exception());
        }
        this.h.zag(connectionResult);
        this.g.disconnect();
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks
    public final void onConnected(Bundle bundle) {
        this.g.zaa(this);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener
    public final void onConnectionFailed(ConnectionResult connectionResult) {
        this.h.zag(connectionResult);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks
    public final void onConnectionSuspended(int i) {
        this.g.disconnect();
    }

    public final void zaa(zach zachVar) {
        zad zadVar = this.g;
        if (zadVar != null) {
            zadVar.disconnect();
        }
        this.f.setClientSessionId(Integer.valueOf(System.identityHashCode(this)));
        Api.AbstractClientBuilder<? extends zad, SignInOptions> abstractClientBuilder = this.d;
        Context context = this.b;
        Looper looper = this.c.getLooper();
        ClientSettings clientSettings = this.f;
        this.g = abstractClientBuilder.buildClient(context, looper, clientSettings, clientSettings.getSignInOptions(), this, this);
        this.h = zachVar;
        Set<Scope> set = this.e;
        if (set == null || set.isEmpty()) {
            this.c.post(new ak(this));
        } else {
            this.g.connect();
        }
    }

    @Override // com.google.android.gms.signin.internal.zac, com.google.android.gms.signin.internal.zad
    public final void zab(com.google.android.gms.signin.internal.zaj zajVar) {
        this.c.post(new al(this, zajVar));
    }

    public final zad zabq() {
        return this.g;
    }

    public final void zabs() {
        zad zadVar = this.g;
        if (zadVar != null) {
            zadVar.disconnect();
        }
    }
}
