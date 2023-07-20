package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import com.google.android.gms.common.internal.GmsClientEventManager;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class q implements GmsClientEventManager.GmsClientEventState {
    private final /* synthetic */ zaaw a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(zaaw zaawVar) {
        this.a = zaawVar;
    }

    @Override // com.google.android.gms.common.internal.GmsClientEventManager.GmsClientEventState
    public final Bundle getConnectionHint() {
        return null;
    }

    @Override // com.google.android.gms.common.internal.GmsClientEventManager.GmsClientEventState
    public final boolean isConnected() {
        return this.a.isConnected();
    }
}
