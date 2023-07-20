package com.google.android.gms.games.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.internal.BaseGmsClient;

/* loaded from: classes.dex */
final class d implements BaseImplementation.ResultHolder<Status> {
    private final /* synthetic */ BaseGmsClient.SignOutCallbacks a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(BaseGmsClient.SignOutCallbacks signOutCallbacks) {
        this.a = signOutCallbacks;
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder
    public final void setFailedResult(Status status) {
        this.a.onSignOutComplete();
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder
    public final /* synthetic */ void setResult(Status status) {
        this.a.onSignOutComplete();
    }
}
