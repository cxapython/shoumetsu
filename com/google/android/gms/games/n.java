package com.google.android.gms.games;

import com.google.android.gms.common.internal.PendingResultUtil;
import com.google.android.gms.games.leaderboard.Leaderboard;
import com.google.android.gms.games.leaderboard.LeaderboardBuffer;
import com.google.android.gms.games.leaderboard.Leaderboards;

/* loaded from: classes.dex */
final class n implements PendingResultUtil.ResultConverter<Leaderboards.LeaderboardMetadataResult, Leaderboard> {
    private static Leaderboard a(Leaderboards.LeaderboardMetadataResult leaderboardMetadataResult) {
        if (leaderboardMetadataResult == null) {
            return null;
        }
        LeaderboardBuffer leaderboards = leaderboardMetadataResult.getLeaderboards();
        if (leaderboards != null) {
            try {
                if (leaderboards.getCount() > 0) {
                    return leaderboards.mo27get(0).mo28freeze();
                }
            } finally {
                if (leaderboards != null) {
                    leaderboards.release();
                }
            }
        }
        if (leaderboards != null) {
            leaderboards.release();
        }
        return null;
    }

    @Override // com.google.android.gms.common.internal.PendingResultUtil.ResultConverter
    public final /* synthetic */ Leaderboard convert(Leaderboards.LeaderboardMetadataResult leaderboardMetadataResult) {
        return a(leaderboardMetadataResult);
    }
}
