package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.internal.GoogleApiManager;
import com.google.android.gms.common.internal.BaseGmsClient;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class ac implements BaseGmsClient.SignOutCallbacks {
    final /* synthetic */ GoogleApiManager.zaa a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(GoogleApiManager.zaa zaaVar) {
        this.a = zaaVar;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.SignOutCallbacks
    public final void onSignOutComplete() {
        GoogleApiManager.this.p.post(new ad(this));
    }
}
