package com.google.android.gms.internal.nearby;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.nearby.connection.Connections;

/* loaded from: classes.dex */
final class ab implements Connections.StartAdvertisingResult {
    private final Status a;
    private final String b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(Status status, String str) {
        this.a = status;
        this.b = str;
    }

    @Override // com.google.android.gms.nearby.connection.Connections.StartAdvertisingResult
    public final String getLocalEndpointName() {
        return this.b;
    }

    @Override // com.google.android.gms.common.api.Result
    public final Status getStatus() {
        return this.a;
    }
}
