package com.google.android.gms.games;

import com.google.android.gms.common.internal.PendingResultUtil;
import com.google.android.gms.games.GamesMetadata;

/* loaded from: classes.dex */
final class cv implements PendingResultUtil.ResultConverter<GamesMetadata.LoadGamesResult, Game> {
    private static Game a(GamesMetadata.LoadGamesResult loadGamesResult) {
        GameBuffer games;
        if (loadGamesResult == null || (games = loadGamesResult.getGames()) == null) {
            return null;
        }
        try {
            if (games.getCount() <= 0) {
                return null;
            }
            return ((Game) games.mo27get(0)).mo28freeze();
        } finally {
            games.release();
        }
    }

    @Override // com.google.android.gms.common.internal.PendingResultUtil.ResultConverter
    public final /* synthetic */ Game convert(GamesMetadata.LoadGamesResult loadGamesResult) {
        return a(loadGamesResult);
    }
}
