package com.google.android.gms.games;

import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.games.internal.zzbo;
import com.google.android.gms.games.internal.zze;
import com.google.android.gms.games.multiplayer.realtime.RealTimeMessageReceivedListener;
import com.google.android.gms.games.multiplayer.realtime.RoomConfig;
import com.google.android.gms.games.multiplayer.realtime.RoomStatusUpdateListener;
import com.google.android.gms.games.multiplayer.realtime.RoomUpdateListener;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes.dex */
final class aj extends zzbo<com.google.android.gms.games.multiplayer.realtime.zzh> {
    private final /* synthetic */ ListenerHolder a;
    private final /* synthetic */ RoomConfig b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public aj(RealTimeMultiplayerClient realTimeMultiplayerClient, ListenerHolder listenerHolder, ListenerHolder listenerHolder2, RoomConfig roomConfig) {
        super(listenerHolder);
        this.a = listenerHolder2;
        this.b = roomConfig;
    }

    @Override // com.google.android.gms.games.internal.zzbo
    protected final void a(zze zzeVar, TaskCompletionSource<Void> taskCompletionSource) {
        ListenerHolder<? extends RoomUpdateListener> listenerHolder = this.a;
        zzeVar.zza(listenerHolder, (ListenerHolder<? extends RoomStatusUpdateListener>) listenerHolder, (ListenerHolder<? extends RealTimeMessageReceivedListener>) listenerHolder, this.b);
        taskCompletionSource.setResult(null);
    }
}
