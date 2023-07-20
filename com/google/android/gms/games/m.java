package com.google.android.gms.games;

import com.google.android.gms.common.internal.PendingResultUtil;
import com.google.android.gms.games.leaderboard.LeaderboardBuffer;
import com.google.android.gms.games.leaderboard.Leaderboards;

/* loaded from: classes.dex */
final class m implements PendingResultUtil.ResultConverter<Leaderboards.LeaderboardMetadataResult, LeaderboardBuffer> {
    @Override // com.google.android.gms.common.internal.PendingResultUtil.ResultConverter
    public final /* synthetic */ LeaderboardBuffer convert(Leaderboards.LeaderboardMetadataResult leaderboardMetadataResult) {
        Leaderboards.LeaderboardMetadataResult leaderboardMetadataResult2 = leaderboardMetadataResult;
        if (leaderboardMetadataResult2 == null) {
            return null;
        }
        return leaderboardMetadataResult2.getLeaderboards();
    }
}
