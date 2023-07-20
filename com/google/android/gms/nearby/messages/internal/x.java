package com.google.android.gms.nearby.messages.internal;

import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.internal.nearby.zzha;
import com.google.android.gms.nearby.messages.SubscribeCallback;

/* loaded from: classes.dex */
class x extends zzab {
    private static final zzha<SubscribeCallback> a = new y();
    private final ListenerHolder<SubscribeCallback> b;

    public x(ListenerHolder<SubscribeCallback> listenerHolder) {
        this.b = listenerHolder;
    }

    public void onExpired() {
        ListenerHolder<SubscribeCallback> listenerHolder = this.b;
        if (listenerHolder != null) {
            listenerHolder.notifyListener(a);
        }
    }
}
