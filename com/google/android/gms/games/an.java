package com.google.android.gms.games;

import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.games.multiplayer.realtime.RoomConfig;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;

/* loaded from: classes.dex */
final class an implements Continuation<Boolean, Task<Void>> {
    final /* synthetic */ ListenerHolder a;
    final /* synthetic */ String b;
    final /* synthetic */ RoomConfig c;
    private final /* synthetic */ RealTimeMultiplayerClient d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(RealTimeMultiplayerClient realTimeMultiplayerClient, ListenerHolder listenerHolder, String str, RoomConfig roomConfig) {
        this.d = realTimeMultiplayerClient;
        this.a = listenerHolder;
        this.b = str;
        this.c = roomConfig;
    }

    @Override // com.google.android.gms.tasks.Continuation
    public final /* synthetic */ Task<Void> then(Task<Boolean> task) {
        return this.d.doRead(new ao(this));
    }
}
