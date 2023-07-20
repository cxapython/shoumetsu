package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.internal.GoogleApiManager;

/* loaded from: classes.dex */
final class ab implements Runnable {
    private final /* synthetic */ ConnectionResult a;
    private final /* synthetic */ GoogleApiManager.zaa b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(GoogleApiManager.zaa zaaVar, ConnectionResult connectionResult) {
        this.b = zaaVar;
        this.a = connectionResult;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.b.onConnectionFailed(this.a);
    }
}
