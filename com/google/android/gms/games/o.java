package com.google.android.gms.games;

import com.google.android.gms.games.internal.zzbm;
import com.google.android.gms.games.leaderboard.Leaderboards;

/* loaded from: classes.dex */
final class o implements zzbm<Leaderboards.LeaderboardMetadataResult> {
    @Override // com.google.android.gms.games.internal.zzbm
    public final /* synthetic */ void release(Leaderboards.LeaderboardMetadataResult leaderboardMetadataResult) {
        Leaderboards.LeaderboardMetadataResult leaderboardMetadataResult2 = leaderboardMetadataResult;
        if (leaderboardMetadataResult2.getLeaderboards() != null) {
            leaderboardMetadataResult2.getLeaderboards().release();
        }
    }
}
