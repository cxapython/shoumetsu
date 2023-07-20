package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class aw {
    private final int a;
    private final ConnectionResult b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aw(ConnectionResult connectionResult, int i) {
        Preconditions.checkNotNull(connectionResult);
        this.b = connectionResult;
        this.a = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int a() {
        return this.a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final ConnectionResult b() {
        return this.b;
    }
}
