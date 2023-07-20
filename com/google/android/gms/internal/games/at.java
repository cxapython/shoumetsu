package com.google.android.gms.internal.games;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.request.GameRequestBuffer;
import com.google.android.gms.games.request.Requests;

/* loaded from: classes.dex */
final class at implements Requests.LoadRequestsResult {
    private final /* synthetic */ Status a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public at(as asVar, Status status) {
        this.a = status;
    }

    @Override // com.google.android.gms.games.request.Requests.LoadRequestsResult
    public final GameRequestBuffer getRequests(int i) {
        return new GameRequestBuffer(DataHolder.empty(this.a.getStatusCode()));
    }

    @Override // com.google.android.gms.common.api.Result
    public final Status getStatus() {
        return this.a;
    }

    @Override // com.google.android.gms.common.api.Releasable
    public final void release() {
    }
}
