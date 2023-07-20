package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.internal.GoogleApiManager;

/* loaded from: classes.dex */
final class z implements Runnable {
    private final /* synthetic */ GoogleApiManager.zaa a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(GoogleApiManager.zaa zaaVar) {
        this.a = zaaVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.c();
    }
}
