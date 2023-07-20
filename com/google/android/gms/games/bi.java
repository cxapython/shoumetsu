package com.google.android.gms.games;

import com.google.android.gms.common.internal.PendingResultUtil;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer;

/* loaded from: classes.dex */
final class bi implements PendingResultUtil.ResultConverter<TurnBasedMultiplayer.CancelMatchResult, String> {
    @Override // com.google.android.gms.common.internal.PendingResultUtil.ResultConverter
    public final /* synthetic */ String convert(TurnBasedMultiplayer.CancelMatchResult cancelMatchResult) {
        TurnBasedMultiplayer.CancelMatchResult cancelMatchResult2 = cancelMatchResult;
        if (cancelMatchResult2 == null) {
            return null;
        }
        return cancelMatchResult2.getMatchId();
    }
}
