package com.google.android.gms.games;

import com.google.android.gms.games.internal.zzbm;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer;

/* loaded from: classes.dex */
final class bg implements zzbm<TurnBasedMultiplayer.LoadMatchesResult> {
    @Override // com.google.android.gms.games.internal.zzbm
    public final /* synthetic */ void release(TurnBasedMultiplayer.LoadMatchesResult loadMatchesResult) {
        TurnBasedMultiplayer.LoadMatchesResult loadMatchesResult2 = loadMatchesResult;
        if (loadMatchesResult2.getMatches() != null) {
            loadMatchesResult2.getMatches().release();
        }
    }
}
