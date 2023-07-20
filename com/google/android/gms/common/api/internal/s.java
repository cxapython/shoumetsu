package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;

/* loaded from: classes.dex */
final class s implements GoogleApiClient.OnConnectionFailedListener {
    private final /* synthetic */ StatusPendingResult a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(zaaw zaawVar, StatusPendingResult statusPendingResult) {
        this.a = statusPendingResult;
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener
    public final void onConnectionFailed(ConnectionResult connectionResult) {
        this.a.setResult(new Status(8));
    }
}
