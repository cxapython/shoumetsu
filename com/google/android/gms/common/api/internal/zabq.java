package com.google.android.gms.common.api.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;

/* loaded from: classes.dex */
public final class zabq extends BroadcastReceiver {
    private Context a;
    private final zabr b;

    public zabq(zabr zabrVar) {
        this.b = zabrVar;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        Uri data = intent.getData();
        if ("com.google.android.gms".equals(data != null ? data.getSchemeSpecificPart() : null)) {
            this.b.zas();
            unregister();
        }
    }

    public final synchronized void unregister() {
        if (this.a != null) {
            this.a.unregisterReceiver(this);
        }
        this.a = null;
    }

    public final void zac(Context context) {
        this.a = context;
    }
}
