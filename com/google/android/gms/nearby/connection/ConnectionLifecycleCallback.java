package com.google.android.gms.nearby.connection;

/* loaded from: classes.dex */
public abstract class ConnectionLifecycleCallback {
    public abstract void onConnectionInitiated(String str, ConnectionInfo connectionInfo);

    public abstract void onConnectionResult(String str, ConnectionResolution connectionResolution);

    public abstract void onDisconnected(String str);
}
