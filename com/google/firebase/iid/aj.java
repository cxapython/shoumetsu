package com.google.firebase.iid;

import android.os.Binder;
import android.os.Process;
import android.util.Log;

/* loaded from: classes.dex */
public final class aj extends Binder {
    private final af a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(af afVar) {
        this.a = afVar;
    }

    public final void a(ah ahVar) {
        if (Binder.getCallingUid() == Process.myUid()) {
            if (Log.isLoggable("EnhancedIntentService", 3)) {
                Log.d("EnhancedIntentService", "service received new intent via bind strategy");
            }
            if (this.a.b(ahVar.a)) {
                ahVar.a();
                return;
            }
            if (Log.isLoggable("EnhancedIntentService", 3)) {
                Log.d("EnhancedIntentService", "intent being queued for bg execution");
            }
            this.a.a.execute(new ai(this, ahVar));
            return;
        }
        throw new SecurityException("Binding only allowed within app");
    }
}
