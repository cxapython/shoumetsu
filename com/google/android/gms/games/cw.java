package com.google.android.gms.games;

import com.google.android.gms.games.GamesMetadata;
import com.google.android.gms.games.internal.zzbm;

/* loaded from: classes.dex */
final class cw implements zzbm<GamesMetadata.LoadGamesResult> {
    @Override // com.google.android.gms.games.internal.zzbm
    public final /* synthetic */ void release(GamesMetadata.LoadGamesResult loadGamesResult) {
        GamesMetadata.LoadGamesResult loadGamesResult2 = loadGamesResult;
        if (loadGamesResult2.getGames() != null) {
            loadGamesResult2.getGames().release();
        }
    }
}
