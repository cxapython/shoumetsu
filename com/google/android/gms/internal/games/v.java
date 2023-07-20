package com.google.android.gms.internal.games;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.leaderboard.Leaderboards;
import com.google.android.gms.games.leaderboard.ScoreSubmissionData;

/* loaded from: classes.dex */
final class v implements Leaderboards.SubmitScoreResult {
    private final /* synthetic */ Status a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(zzaz zzazVar, Status status) {
        this.a = status;
    }

    @Override // com.google.android.gms.games.leaderboard.Leaderboards.SubmitScoreResult
    public final ScoreSubmissionData getScoreData() {
        return new ScoreSubmissionData(DataHolder.empty(14));
    }

    @Override // com.google.android.gms.common.api.Result
    public final Status getStatus() {
        return this.a;
    }

    @Override // com.google.android.gms.common.api.Releasable
    public final void release() {
    }
}
