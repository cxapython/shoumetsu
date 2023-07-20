package com.google.android.gms.games;

import com.google.android.gms.common.internal.PendingResultUtil;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatch;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer;

/* loaded from: classes.dex */
final class bl implements PendingResultUtil.ResultConverter<TurnBasedMultiplayer.LeaveMatchResult, TurnBasedMatch> {
    @Override // com.google.android.gms.common.internal.PendingResultUtil.ResultConverter
    public final /* synthetic */ TurnBasedMatch convert(TurnBasedMultiplayer.LeaveMatchResult leaveMatchResult) {
        TurnBasedMatch match;
        TurnBasedMultiplayer.LeaveMatchResult leaveMatchResult2 = leaveMatchResult;
        if (leaveMatchResult2 == null || (match = leaveMatchResult2.getMatch()) == null) {
            return null;
        }
        return match.mo28freeze();
    }
}
