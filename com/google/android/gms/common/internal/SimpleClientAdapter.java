package com.google.android.gms.common.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;

/* loaded from: classes.dex */
public class SimpleClientAdapter<T extends IInterface> extends GmsClient<T> {
    private final Api.SimpleClient<T> d;

    public SimpleClientAdapter(Context context, Looper looper, int i, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener, ClientSettings clientSettings, Api.SimpleClient<T> simpleClient) {
        super(context, looper, i, clientSettings, connectionCallbacks, onConnectionFailedListener);
        this.d = simpleClient;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    protected T a(IBinder iBinder) {
        return this.d.createServiceInterface(iBinder);
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    protected void a(int i, T t) {
        this.d.setState(i, t);
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    protected String b() {
        return this.d.getServiceDescriptor();
    }

    public Api.SimpleClient<T> getClient() {
        return this.d;
    }

    @Override // com.google.android.gms.common.internal.GmsClient, com.google.android.gms.common.internal.BaseGmsClient, com.google.android.gms.common.api.Api.Client
    public int getMinApkVersion() {
        return super.getMinApkVersion();
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    protected String getStartServiceAction() {
        return this.d.getStartServiceAction();
    }
}
