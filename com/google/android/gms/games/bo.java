package com.google.android.gms.games;

import com.google.android.gms.common.internal.PendingResultUtil;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatch;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer;

/* loaded from: classes.dex */
final class bo implements PendingResultUtil.ResultConverter<TurnBasedMultiplayer.InitiateMatchResult, TurnBasedMatch> {
    @Override // com.google.android.gms.common.internal.PendingResultUtil.ResultConverter
    public final /* synthetic */ TurnBasedMatch convert(TurnBasedMultiplayer.InitiateMatchResult initiateMatchResult) {
        TurnBasedMatch match;
        TurnBasedMultiplayer.InitiateMatchResult initiateMatchResult2 = initiateMatchResult;
        if (initiateMatchResult2 == null || (match = initiateMatchResult2.getMatch()) == null) {
            return null;
        }
        return match.mo28freeze();
    }
}
