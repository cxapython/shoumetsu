package com.google.android.gms.games;

import com.google.android.gms.common.internal.PendingResultUtil;
import com.google.android.gms.games.leaderboard.LeaderboardScore;
import com.google.android.gms.games.leaderboard.Leaderboards;

/* loaded from: classes.dex */
final class d implements PendingResultUtil.ResultConverter<Leaderboards.LoadPlayerScoreResult, LeaderboardScore> {
    @Override // com.google.android.gms.common.internal.PendingResultUtil.ResultConverter
    public final /* synthetic */ LeaderboardScore convert(Leaderboards.LoadPlayerScoreResult loadPlayerScoreResult) {
        LeaderboardScore score;
        Leaderboards.LoadPlayerScoreResult loadPlayerScoreResult2 = loadPlayerScoreResult;
        if (loadPlayerScoreResult2 == null || (score = loadPlayerScoreResult2.getScore()) == null) {
            return null;
        }
        return score.mo28freeze();
    }
}
