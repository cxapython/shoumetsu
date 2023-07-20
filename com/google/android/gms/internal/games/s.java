package com.google.android.gms.internal.games;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.leaderboard.LeaderboardScore;
import com.google.android.gms.games.leaderboard.Leaderboards;

/* loaded from: classes.dex */
final class s implements Leaderboards.LoadPlayerScoreResult {
    private final /* synthetic */ Status a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(r rVar, Status status) {
        this.a = status;
    }

    @Override // com.google.android.gms.games.leaderboard.Leaderboards.LoadPlayerScoreResult
    public final LeaderboardScore getScore() {
        return null;
    }

    @Override // com.google.android.gms.common.api.Result
    public final Status getStatus() {
        return this.a;
    }
}
