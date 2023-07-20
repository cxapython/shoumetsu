package com.google.android.gms.games;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.internal.PendingResultUtil;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.internal.zzbe;
import com.google.android.gms.games.internal.zzbm;
import com.google.android.gms.games.internal.zzbn;
import com.google.android.gms.games.leaderboard.Leaderboard;
import com.google.android.gms.games.leaderboard.LeaderboardBuffer;
import com.google.android.gms.games.leaderboard.LeaderboardScore;
import com.google.android.gms.games.leaderboard.LeaderboardScoreBuffer;
import com.google.android.gms.games.leaderboard.Leaderboards;
import com.google.android.gms.games.leaderboard.ScoreSubmissionData;
import com.google.android.gms.internal.games.zzt;
import com.google.android.gms.tasks.Task;

/* loaded from: classes.dex */
public class LeaderboardsClient extends zzt {
    private static final PendingResultUtil.ResultConverter<Leaderboards.LeaderboardMetadataResult, LeaderboardBuffer> b = new m();
    private static final PendingResultUtil.ResultConverter<Leaderboards.LeaderboardMetadataResult, Leaderboard> c = new n();
    private static final zzbm<Leaderboards.LeaderboardMetadataResult> d = new o();
    private static final PendingResultUtil.ResultConverter<Leaderboards.LoadPlayerScoreResult, LeaderboardScore> e = new d();
    private static final zzbn f = new e();
    private static final PendingResultUtil.ResultConverter<Leaderboards.SubmitScoreResult, ScoreSubmissionData> g = new f();
    private static final PendingResultUtil.ResultConverter<Leaderboards.LoadScoresResult, LeaderboardScores> h = new g();

    /* loaded from: classes.dex */
    public static class LeaderboardScores implements Releasable {
        private final Leaderboard a;
        private final LeaderboardScoreBuffer b;

        public LeaderboardScores(Leaderboard leaderboard, LeaderboardScoreBuffer leaderboardScoreBuffer) {
            this.a = leaderboard;
            this.b = leaderboardScoreBuffer;
        }

        public Leaderboard getLeaderboard() {
            return this.a;
        }

        public LeaderboardScoreBuffer getScores() {
            return this.b;
        }

        @Override // com.google.android.gms.common.api.Releasable
        public void release() {
            LeaderboardScoreBuffer leaderboardScoreBuffer = this.b;
            if (leaderboardScoreBuffer != null) {
                leaderboardScoreBuffer.release();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public LeaderboardsClient(Activity activity, Games.GamesOptions gamesOptions) {
        super(activity, gamesOptions);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public LeaderboardsClient(Context context, Games.GamesOptions gamesOptions) {
        super(context, gamesOptions);
    }

    public Task<Intent> getAllLeaderboardsIntent() {
        return doRead(new c(this));
    }

    public Task<Intent> getLeaderboardIntent(String str) {
        return doRead(new h(this, str));
    }

    public Task<Intent> getLeaderboardIntent(String str, int i) {
        return doRead(new i(this, str, i));
    }

    public Task<Intent> getLeaderboardIntent(String str, int i, int i2) {
        return doRead(new j(this, str, i, i2));
    }

    public Task<AnnotatedData<LeaderboardScore>> loadCurrentPlayerLeaderboardScore(String str, int i, int i2) {
        return zzbe.zza(Games.Leaderboards.loadCurrentPlayerLeaderboardScore(asGoogleApiClient(), str, i, i2), e);
    }

    public Task<AnnotatedData<Leaderboard>> loadLeaderboardMetadata(String str, boolean z) {
        return zzbe.zza(Games.Leaderboards.loadLeaderboardMetadata(asGoogleApiClient(), str, z), c, d);
    }

    public Task<AnnotatedData<LeaderboardBuffer>> loadLeaderboardMetadata(boolean z) {
        return zzbe.zzb(Games.Leaderboards.loadLeaderboardMetadata(asGoogleApiClient(), z), b);
    }

    public Task<AnnotatedData<LeaderboardScores>> loadMoreScores(LeaderboardScoreBuffer leaderboardScoreBuffer, int i, int i2) {
        return zzbe.zzb(Games.Leaderboards.loadMoreScores(asGoogleApiClient(), leaderboardScoreBuffer, i, i2), h);
    }

    public Task<AnnotatedData<LeaderboardScores>> loadPlayerCenteredScores(String str, int i, int i2, int i3) {
        return zzbe.zzb(Games.Leaderboards.loadPlayerCenteredScores(asGoogleApiClient(), str, i, i2, i3), h);
    }

    public Task<AnnotatedData<LeaderboardScores>> loadPlayerCenteredScores(String str, int i, int i2, int i3, boolean z) {
        return zzbe.zzb(Games.Leaderboards.loadPlayerCenteredScores(asGoogleApiClient(), str, i, i2, i3, z), h);
    }

    public Task<AnnotatedData<LeaderboardScores>> loadTopScores(String str, int i, int i2, int i3) {
        return zzbe.zzb(Games.Leaderboards.loadTopScores(asGoogleApiClient(), str, i, i2, i3), h);
    }

    public Task<AnnotatedData<LeaderboardScores>> loadTopScores(String str, int i, int i2, int i3, boolean z) {
        return zzbe.zzb(Games.Leaderboards.loadTopScores(asGoogleApiClient(), str, i, i2, i3, z), h);
    }

    public void submitScore(String str, long j) {
        doWrite(new k(this, str, j));
    }

    public void submitScore(String str, long j, String str2) {
        doWrite(new l(this, str, j, str2));
    }

    public Task<ScoreSubmissionData> submitScoreImmediate(String str, long j) {
        return zzbe.zza(Games.Leaderboards.submitScoreImmediate(asGoogleApiClient(), str, j), f, g);
    }

    public Task<ScoreSubmissionData> submitScoreImmediate(String str, long j, String str2) {
        return zzbe.zza(Games.Leaderboards.submitScoreImmediate(asGoogleApiClient(), str, j, str2), f, g);
    }
}
