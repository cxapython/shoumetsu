package com.google.firebase.iid;

import android.content.Intent;

/* loaded from: classes.dex */
final class ad implements Runnable {
    private final /* synthetic */ Intent a;
    private final /* synthetic */ Intent b;
    private final /* synthetic */ af c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(af afVar, Intent intent, Intent intent2) {
        this.c = afVar;
        this.a = intent;
        this.b = intent2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.c.c(this.a);
        this.c.d(this.b);
    }
}
