package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import com.google.android.gms.common.api.GoogleApiClient;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
final class r implements GoogleApiClient.ConnectionCallbacks {
    private final /* synthetic */ AtomicReference a;
    private final /* synthetic */ StatusPendingResult b;
    private final /* synthetic */ zaaw c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(zaaw zaawVar, AtomicReference atomicReference, StatusPendingResult statusPendingResult) {
        this.c = zaawVar;
        this.a = atomicReference;
        this.b = statusPendingResult;
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks
    public final void onConnected(Bundle bundle) {
        this.c.a((GoogleApiClient) this.a.get(), this.b, true);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks
    public final void onConnectionSuspended(int i) {
    }
}
