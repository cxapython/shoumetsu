package com.google.android.gms.internal.nearby;

import android.util.Log;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.api.internal.ListenerHolder;

/* loaded from: classes.dex */
public final class zzgy extends com.google.android.gms.nearby.messages.internal.zzq {
    private final ListenerHolder<BaseImplementation.ResultHolder<Status>> a;
    private boolean b = false;

    public zzgy(ListenerHolder<BaseImplementation.ResultHolder<Status>> listenerHolder) {
        this.a = listenerHolder;
    }

    @Override // com.google.android.gms.nearby.messages.internal.zzp
    public final synchronized void zza(Status status) {
        if (!this.b) {
            this.a.notifyListener(new ch(this, status));
            this.b = true;
            return;
        }
        String valueOf = String.valueOf(status);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 28);
        sb.append("Received multiple statuses: ");
        sb.append(valueOf);
        Log.wtf("NearbyMessagesCallbackWrapper", sb.toString(), new Exception());
    }
}
