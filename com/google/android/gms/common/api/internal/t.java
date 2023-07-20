package com.google.android.gms.common.api.internal;

import android.content.Context;
import com.google.android.gms.auth.api.signin.internal.Storage;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class t implements ResultCallback<Status> {
    private final /* synthetic */ StatusPendingResult a;
    private final /* synthetic */ boolean b;
    private final /* synthetic */ GoogleApiClient c;
    private final /* synthetic */ zaaw d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(zaaw zaawVar, StatusPendingResult statusPendingResult, boolean z, GoogleApiClient googleApiClient) {
        this.d = zaawVar;
        this.a = statusPendingResult;
        this.b = z;
        this.c = googleApiClient;
    }

    @Override // com.google.android.gms.common.api.ResultCallback
    public final /* synthetic */ void onResult(Status status) {
        Context context;
        Status status2 = status;
        context = this.d.k;
        Storage.getInstance(context).zaf();
        if (status2.isSuccess() && this.d.isConnected()) {
            this.d.reconnect();
        }
        this.a.setResult(status2);
        if (this.b) {
            this.c.disconnect();
        }
    }
}
