package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.Api;

/* loaded from: classes.dex */
final class ad implements Runnable {
    private final /* synthetic */ ac a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(ac acVar) {
        this.a = acVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Api.Client client;
        client = this.a.a.c;
        client.disconnect();
    }
}
