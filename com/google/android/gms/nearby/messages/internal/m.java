package com.google.android.gms.nearby.messages.internal;

import com.google.android.gms.common.api.internal.ListenerHolder;

/* loaded from: classes.dex */
final class m extends v {
    private final /* synthetic */ ListenerHolder a;
    private final /* synthetic */ zzak b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(zzak zzakVar, ListenerHolder listenerHolder, ListenerHolder listenerHolder2) {
        super(listenerHolder);
        this.b = zzakVar;
        this.a = listenerHolder2;
    }

    @Override // com.google.android.gms.nearby.messages.internal.v, com.google.android.gms.nearby.messages.internal.zzu
    public final void onExpired() {
        this.b.doUnregisterEventListener(this.a.getListenerKey());
        super.onExpired();
    }
}
