package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.internal.GoogleApiManager;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class aa implements Runnable {
    private final /* synthetic */ GoogleApiManager.zaa a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(GoogleApiManager.zaa zaaVar) {
        this.a = zaaVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.d();
    }
}
