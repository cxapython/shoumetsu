package com.google.firebase.iid;

import android.util.Log;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class ai implements Runnable {
    private final /* synthetic */ ah a;
    private final /* synthetic */ aj b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(aj ajVar, ah ahVar) {
        this.b = ajVar;
        this.a = ahVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        af afVar;
        if (Log.isLoggable("EnhancedIntentService", 3)) {
            Log.d("EnhancedIntentService", "bg processing of the intent starting now");
        }
        afVar = this.b.a;
        afVar.c(this.a.a);
        this.a.a();
    }
}
