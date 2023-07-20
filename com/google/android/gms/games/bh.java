package com.google.android.gms.games;

import com.google.android.gms.common.internal.PendingResultUtil;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatch;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer;

/* loaded from: classes.dex */
final class bh implements PendingResultUtil.ResultConverter<TurnBasedMultiplayer.LoadMatchResult, TurnBasedMatch> {
    @Override // com.google.android.gms.common.internal.PendingResultUtil.ResultConverter
    public final /* synthetic */ TurnBasedMatch convert(TurnBasedMultiplayer.LoadMatchResult loadMatchResult) {
        TurnBasedMatch match;
        TurnBasedMultiplayer.LoadMatchResult loadMatchResult2 = loadMatchResult;
        if (loadMatchResult2 == null || (match = loadMatchResult2.getMatch()) == null) {
            return null;
        }
        return match.mo28freeze();
    }
}
