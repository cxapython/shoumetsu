package com.google.android.gms.nearby.messages.internal;

import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.internal.nearby.zzha;
import com.google.android.gms.nearby.messages.SubscribeCallback;

/* loaded from: classes.dex */
final class am extends zzab {
    private static final zzha<SubscribeCallback> a = new an();
    private final ListenerHolder<SubscribeCallback> b;

    public am(ListenerHolder<SubscribeCallback> listenerHolder) {
        this.b = listenerHolder;
    }

    @Override // com.google.android.gms.nearby.messages.internal.zzaa
    public final void onExpired() {
        this.b.notifyListener(a);
    }
}
