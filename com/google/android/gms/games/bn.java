package com.google.android.gms.games;

import com.google.android.gms.common.internal.PendingResultUtil;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatch;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer;

/* loaded from: classes.dex */
final class bn implements PendingResultUtil.ResultConverter<TurnBasedMultiplayer.UpdateMatchResult, TurnBasedMatch> {
    @Override // com.google.android.gms.common.internal.PendingResultUtil.ResultConverter
    public final /* synthetic */ TurnBasedMatch convert(TurnBasedMultiplayer.UpdateMatchResult updateMatchResult) {
        TurnBasedMatch match;
        TurnBasedMultiplayer.UpdateMatchResult updateMatchResult2 = updateMatchResult;
        if (updateMatchResult2 == null || (match = updateMatchResult2.getMatch()) == null) {
            return null;
        }
        return match.mo28freeze();
    }
}
