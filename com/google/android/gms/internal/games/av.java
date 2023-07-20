package com.google.android.gms.internal.games;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.request.Requests;
import java.util.Set;

/* loaded from: classes.dex */
final class av implements Requests.UpdateRequestsResult {
    private final /* synthetic */ Status a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public av(au auVar, Status status) {
        this.a = status;
    }

    @Override // com.google.android.gms.games.request.Requests.UpdateRequestsResult
    public final Set<String> getRequestIds() {
        return null;
    }

    @Override // com.google.android.gms.games.request.Requests.UpdateRequestsResult
    public final int getRequestOutcome(String str) {
        String valueOf = String.valueOf(str);
        throw new IllegalArgumentException(valueOf.length() != 0 ? "Unknown request ID ".concat(valueOf) : new String("Unknown request ID "));
    }

    @Override // com.google.android.gms.common.api.Result
    public final Status getStatus() {
        return this.a;
    }

    @Override // com.google.android.gms.common.api.Releasable
    public final void release() {
    }
}
