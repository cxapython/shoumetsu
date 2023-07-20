package com.google.android.gms.games;

import com.google.android.gms.common.internal.PendingResultUtil;
import com.google.android.gms.games.Players;

/* loaded from: classes.dex */
final class y implements PendingResultUtil.ResultConverter<Players.LoadPlayersResult, Player> {
    private static Player a(Players.LoadPlayersResult loadPlayersResult) {
        if (loadPlayersResult == null) {
            return null;
        }
        PlayerBuffer players = loadPlayersResult.getPlayers();
        if (players != null) {
            try {
                if (players.getCount() > 0) {
                    return ((Player) players.mo27get(0)).mo28freeze();
                }
            } finally {
                if (players != null) {
                    players.release();
                }
            }
        }
        if (players != null) {
            players.release();
        }
        return null;
    }

    @Override // com.google.android.gms.common.internal.PendingResultUtil.ResultConverter
    public final /* synthetic */ Player convert(Players.LoadPlayersResult loadPlayersResult) {
        return a(loadPlayersResult);
    }
}
