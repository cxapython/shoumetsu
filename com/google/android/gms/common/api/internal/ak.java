package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class ak implements Runnable {
    private final /* synthetic */ zace a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(zace zaceVar) {
        this.a = zaceVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zach zachVar;
        zachVar = this.a.h;
        zachVar.zag(new ConnectionResult(4));
    }
}
