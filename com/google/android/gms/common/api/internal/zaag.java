package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public class zaag extends GoogleApiClient {
    private final String a;

    public zaag(String str) {
        this.a = str;
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public ConnectionResult blockingConnect() {
        throw new UnsupportedOperationException(this.a);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public ConnectionResult blockingConnect(long j, TimeUnit timeUnit) {
        throw new UnsupportedOperationException(this.a);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public PendingResult<Status> clearDefaultAccountAndReconnect() {
        throw new UnsupportedOperationException(this.a);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public void connect() {
        throw new UnsupportedOperationException(this.a);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public void disconnect() {
        throw new UnsupportedOperationException(this.a);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        throw new UnsupportedOperationException(this.a);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public ConnectionResult getConnectionResult(Api<?> api) {
        throw new UnsupportedOperationException(this.a);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public boolean hasConnectedApi(Api<?> api) {
        throw new UnsupportedOperationException(this.a);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public boolean isConnected() {
        throw new UnsupportedOperationException(this.a);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public boolean isConnecting() {
        throw new UnsupportedOperationException(this.a);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public boolean isConnectionCallbacksRegistered(GoogleApiClient.ConnectionCallbacks connectionCallbacks) {
        throw new UnsupportedOperationException(this.a);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public boolean isConnectionFailedListenerRegistered(GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        throw new UnsupportedOperationException(this.a);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public void reconnect() {
        throw new UnsupportedOperationException(this.a);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public void registerConnectionCallbacks(GoogleApiClient.ConnectionCallbacks connectionCallbacks) {
        throw new UnsupportedOperationException(this.a);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public void registerConnectionFailedListener(GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        throw new UnsupportedOperationException(this.a);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public void stopAutoManage(androidx.e.a.e eVar) {
        throw new UnsupportedOperationException(this.a);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public void unregisterConnectionCallbacks(GoogleApiClient.ConnectionCallbacks connectionCallbacks) {
        throw new UnsupportedOperationException(this.a);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public void unregisterConnectionFailedListener(GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        throw new UnsupportedOperationException(this.a);
    }
}
