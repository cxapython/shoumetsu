package com.google.firebase.iid;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.util.Log;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
final class ah {
    final Intent a;
    private final BroadcastReceiver.PendingResult b;
    private boolean c = false;
    private final ScheduledFuture<?> d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(final Intent intent, BroadcastReceiver.PendingResult pendingResult, ScheduledExecutorService scheduledExecutorService) {
        this.a = intent;
        this.b = pendingResult;
        this.d = scheduledExecutorService.schedule(new Runnable(this, intent) { // from class: com.google.firebase.iid.ag
            private final ah a;
            private final Intent b;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.a = this;
                this.b = intent;
            }

            @Override // java.lang.Runnable
            public final void run() {
                ah ahVar = this.a;
                String action = this.b.getAction();
                StringBuilder sb = new StringBuilder(String.valueOf(action).length() + 61);
                sb.append("Service took too long to process intent: ");
                sb.append(action);
                sb.append(" App may get closed.");
                Log.w("EnhancedIntentService", sb.toString());
                ahVar.a();
            }
        }, 9000L, TimeUnit.MILLISECONDS);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final synchronized void a() {
        if (!this.c) {
            this.b.finish();
            this.d.cancel(false);
            this.c = true;
        }
    }
}
