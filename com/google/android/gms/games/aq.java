package com.google.android.gms.games;

import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;

/* loaded from: classes.dex */
final class aq implements Continuation<String, Task<Boolean>> {
    private final /* synthetic */ ListenerHolder a;
    private final /* synthetic */ RealTimeMultiplayerClient b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aq(RealTimeMultiplayerClient realTimeMultiplayerClient, ListenerHolder listenerHolder) {
        this.b = realTimeMultiplayerClient;
        this.a = listenerHolder;
    }

    @Override // com.google.android.gms.tasks.Continuation
    public final /* synthetic */ Task<Boolean> then(Task<String> task) {
        return this.b.doUnregisterEventListener(this.a.getListenerKey());
    }
}
