package com.google.android.gms.nearby.connection;

/* loaded from: classes.dex */
public final class ConnectionInfo {
    private final String a;
    private final String b;
    private final boolean c;

    @Deprecated
    public ConnectionInfo(String str, String str2, boolean z) {
        this.a = str;
        this.b = str2;
        this.c = z;
    }

    public final String getAuthenticationToken() {
        return this.b;
    }

    public final String getEndpointName() {
        return this.a;
    }

    public final boolean isIncomingConnection() {
        return this.c;
    }
}
