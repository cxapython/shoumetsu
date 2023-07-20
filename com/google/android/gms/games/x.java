package com.google.android.gms.games;

import com.google.android.gms.games.Players;
import com.google.android.gms.games.internal.zzbm;

/* loaded from: classes.dex */
final class x implements zzbm<Players.LoadPlayersResult> {
    @Override // com.google.android.gms.games.internal.zzbm
    public final /* synthetic */ void release(Players.LoadPlayersResult loadPlayersResult) {
        Players.LoadPlayersResult loadPlayersResult2 = loadPlayersResult;
        if (loadPlayersResult2.getPlayers() != null) {
            loadPlayersResult2.getPlayers().release();
        }
    }
}
