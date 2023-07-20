package com.google.android.gms.internal.nearby;

import com.google.android.gms.nearby.connection.ConnectionInfo;
import com.google.android.gms.nearby.connection.ConnectionLifecycleCallback;
import com.google.android.gms.nearby.connection.ConnectionResolution;

/* loaded from: classes.dex */
final class aw extends ConnectionLifecycleCallback {
    private final ConnectionLifecycleCallback a;
    private final /* synthetic */ zzbd b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aw(zzbd zzbdVar, ConnectionLifecycleCallback connectionLifecycleCallback) {
        this.b = zzbdVar;
        this.a = connectionLifecycleCallback;
    }

    @Override // com.google.android.gms.nearby.connection.ConnectionLifecycleCallback
    public final void onConnectionInitiated(String str, ConnectionInfo connectionInfo) {
        if (connectionInfo.isIncomingConnection()) {
            this.b.a(str);
        }
        this.a.onConnectionInitiated(str, connectionInfo);
    }

    @Override // com.google.android.gms.nearby.connection.ConnectionLifecycleCallback
    public final void onConnectionResult(String str, ConnectionResolution connectionResolution) {
        if (!connectionResolution.getStatus().isSuccess()) {
            this.b.b(str);
        }
        this.a.onConnectionResult(str, connectionResolution);
    }

    @Override // com.google.android.gms.nearby.connection.ConnectionLifecycleCallback
    public final void onDisconnected(String str) {
        this.b.b(str);
        this.a.onDisconnected(str);
    }
}
