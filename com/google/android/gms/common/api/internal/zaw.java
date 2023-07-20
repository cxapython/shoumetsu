package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.internal.GoogleApiManager;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.signin.SignInOptions;
import com.google.android.gms.signin.zad;

/* loaded from: classes.dex */
public final class zaw<O extends Api.ApiOptions> extends GoogleApi<O> {
    private final Api.Client b;
    private final zaq c;
    private final ClientSettings d;
    private final Api.AbstractClientBuilder<? extends zad, SignInOptions> e;

    public zaw(Context context, Api<O> api, Looper looper, Api.Client client, zaq zaqVar, ClientSettings clientSettings, Api.AbstractClientBuilder<? extends zad, SignInOptions> abstractClientBuilder) {
        super(context, api, looper);
        this.b = client;
        this.c = zaqVar;
        this.d = clientSettings;
        this.e = abstractClientBuilder;
        this.a.zaa(this);
    }

    @Override // com.google.android.gms.common.api.GoogleApi
    public final Api.Client zaa(Looper looper, GoogleApiManager.zaa<O> zaaVar) {
        this.c.zaa(zaaVar);
        return this.b;
    }

    @Override // com.google.android.gms.common.api.GoogleApi
    public final zace zaa(Context context, Handler handler) {
        return new zace(context, handler, this.d, this.e);
    }

    public final Api.Client zaab() {
        return this.b;
    }
}
