package com.google.android.gms.nearby.messages.internal;

import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.internal.nearby.zzha;
import com.google.android.gms.nearby.messages.PublishCallback;

/* loaded from: classes.dex */
class v extends zzv {
    private static final zzha<PublishCallback> a = new w();
    private final ListenerHolder<PublishCallback> b;

    public v(ListenerHolder<PublishCallback> listenerHolder) {
        this.b = listenerHolder;
    }

    public void onExpired() {
        ListenerHolder<PublishCallback> listenerHolder = this.b;
        if (listenerHolder != null) {
            listenerHolder.notifyListener(a);
        }
    }
}
