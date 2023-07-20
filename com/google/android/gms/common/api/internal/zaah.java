package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import android.os.DeadObjectException;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.SimpleClientAdapter;

/* loaded from: classes.dex */
public final class zaah implements zabd {
    private final zabe a;
    private boolean b = false;

    public zaah(zabe zabeVar) {
        this.a = zabeVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a() {
        if (this.b) {
            this.b = false;
            this.a.d.e.release();
            disconnect();
        }
    }

    @Override // com.google.android.gms.common.api.internal.zabd
    public final void begin() {
    }

    @Override // com.google.android.gms.common.api.internal.zabd
    public final void connect() {
        if (this.b) {
            this.b = false;
            this.a.a(new f(this, this));
        }
    }

    @Override // com.google.android.gms.common.api.internal.zabd
    public final boolean disconnect() {
        if (this.b) {
            return false;
        }
        if (!this.a.d.c()) {
            this.a.a((ConnectionResult) null);
            return true;
        }
        this.b = true;
        for (zacm zacmVar : this.a.d.d) {
            zacmVar.a();
        }
        return false;
    }

    @Override // com.google.android.gms.common.api.internal.zabd
    public final <A extends Api.AnyClient, R extends Result, T extends BaseImplementation.ApiMethodImpl<R, A>> T enqueue(T t) {
        return (T) execute(t);
    }

    @Override // com.google.android.gms.common.api.internal.zabd
    public final <A extends Api.AnyClient, T extends BaseImplementation.ApiMethodImpl<? extends Result, A>> T execute(T t) {
        try {
            this.a.d.e.a(t);
            zaaw zaawVar = this.a.d;
            Api.Client client = zaawVar.b.get(t.getClientKey());
            Preconditions.checkNotNull(client, "Appropriate Api was not requested.");
            if (client.isConnected() || !this.a.b.containsKey(t.getClientKey())) {
                boolean z = client instanceof SimpleClientAdapter;
                Api.SimpleClient simpleClient = client;
                if (z) {
                    simpleClient = ((SimpleClientAdapter) client).getClient();
                }
                t.run(simpleClient);
            } else {
                t.setFailedResult(new Status(17));
            }
        } catch (DeadObjectException unused) {
            this.a.a(new e(this, this));
        }
        return t;
    }

    @Override // com.google.android.gms.common.api.internal.zabd
    public final void onConnected(Bundle bundle) {
    }

    @Override // com.google.android.gms.common.api.internal.zabd
    public final void onConnectionSuspended(int i) {
        this.a.a((ConnectionResult) null);
        this.a.e.zab(i, this.b);
    }

    @Override // com.google.android.gms.common.api.internal.zabd
    public final void zaa(ConnectionResult connectionResult, Api<?> api, boolean z) {
    }
}
