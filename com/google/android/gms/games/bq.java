package com.google.android.gms.games;

import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.games.internal.zzbp;
import com.google.android.gms.games.internal.zze;
import com.google.android.gms.games.multiplayer.turnbased.OnTurnBasedMatchUpdateReceivedListener;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes.dex */
final class bq extends zzbp<OnTurnBasedMatchUpdateReceivedListener> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public bq(TurnBasedMultiplayerClient turnBasedMultiplayerClient, ListenerHolder.ListenerKey listenerKey) {
        super(listenerKey);
    }

    @Override // com.google.android.gms.games.internal.zzbp
    protected final void a(zze zzeVar, TaskCompletionSource<Boolean> taskCompletionSource) {
        zzeVar.zzbh();
        taskCompletionSource.setResult(true);
    }
}
