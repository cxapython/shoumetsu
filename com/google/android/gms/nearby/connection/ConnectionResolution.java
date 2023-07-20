package com.google.android.gms.nearby.connection;

import com.google.android.gms.common.api.Status;

/* loaded from: classes.dex */
public final class ConnectionResolution {
    private final Status a;

    @Deprecated
    public ConnectionResolution(Status status) {
        this.a = status;
    }

    public final Status getStatus() {
        return this.a;
    }
}
