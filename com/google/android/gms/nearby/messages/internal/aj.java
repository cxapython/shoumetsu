package com.google.android.gms.nearby.messages.internal;

import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.internal.nearby.zzha;
import com.google.android.gms.nearby.messages.PublishCallback;

/* loaded from: classes.dex */
final class aj extends zzv {
    private static final zzha<PublishCallback> a = new ak();
    private final ListenerHolder<PublishCallback> b;

    public aj(ListenerHolder<PublishCallback> listenerHolder) {
        this.b = listenerHolder;
    }

    @Override // com.google.android.gms.nearby.messages.internal.zzu
    public final void onExpired() {
        this.b.notifyListener(a);
    }
}
