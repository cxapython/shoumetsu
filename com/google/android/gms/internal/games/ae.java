package com.google.android.gms.internal.games;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.PlayerBuffer;
import com.google.android.gms.games.Players;

/* loaded from: classes.dex */
final class ae implements Players.LoadPlayersResult {
    private final /* synthetic */ Status a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(ad adVar, Status status) {
        this.a = status;
    }

    @Override // com.google.android.gms.games.Players.LoadPlayersResult
    public final PlayerBuffer getPlayers() {
        return new PlayerBuffer(DataHolder.empty(14));
    }

    @Override // com.google.android.gms.common.api.Result
    public final Status getStatus() {
        return this.a;
    }

    @Override // com.google.android.gms.common.api.Releasable
    public final void release() {
    }
}
