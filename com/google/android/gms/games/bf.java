package com.google.android.gms.games;

import com.google.android.gms.common.internal.PendingResultUtil;
import com.google.android.gms.games.multiplayer.turnbased.LoadMatchesResponse;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer;

/* loaded from: classes.dex */
final class bf implements PendingResultUtil.ResultConverter<TurnBasedMultiplayer.LoadMatchesResult, LoadMatchesResponse> {
    @Override // com.google.android.gms.common.internal.PendingResultUtil.ResultConverter
    public final /* synthetic */ LoadMatchesResponse convert(TurnBasedMultiplayer.LoadMatchesResult loadMatchesResult) {
        TurnBasedMultiplayer.LoadMatchesResult loadMatchesResult2 = loadMatchesResult;
        if (loadMatchesResult2 == null) {
            return null;
        }
        return loadMatchesResult2.getMatches();
    }
}
