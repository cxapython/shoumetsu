package com.google.android.gms.games.leaderboard;

import android.util.SparseArray;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.games.zzeg;

/* loaded from: classes.dex */
public final class ScoreSubmissionData {
    private static final String[] a = {"leaderboardId", "playerId", "timeSpan", "hasResult", "rawScore", "formattedScore", "newBest", "scoreTag"};
    private String b;
    private String c;
    private int d;
    private SparseArray<Result> e = new SparseArray<>();

    /* loaded from: classes.dex */
    public static final class Result {
        public final String formattedScore;
        public final boolean newBest;
        public final long rawScore;
        public final String scoreTag;

        public Result(long j, String str, String str2, boolean z) {
            this.rawScore = j;
            this.formattedScore = str;
            this.scoreTag = str2;
            this.newBest = z;
        }

        public final String toString() {
            return Objects.toStringHelper(this).add("RawScore", Long.valueOf(this.rawScore)).add("FormattedScore", this.formattedScore).add("ScoreTag", this.scoreTag).add("NewBest", Boolean.valueOf(this.newBest)).toString();
        }
    }

    public ScoreSubmissionData(DataHolder dataHolder) {
        this.d = dataHolder.getStatusCode();
        int count = dataHolder.getCount();
        Preconditions.checkArgument(count == 3);
        for (int i = 0; i < count; i++) {
            int windowIndex = dataHolder.getWindowIndex(i);
            if (i == 0) {
                this.b = dataHolder.getString("leaderboardId", i, windowIndex);
                this.c = dataHolder.getString("playerId", i, windowIndex);
            }
            if (dataHolder.getBoolean("hasResult", i, windowIndex)) {
                this.e.put(dataHolder.getInteger("timeSpan", i, windowIndex), new Result(dataHolder.getLong("rawScore", i, windowIndex), dataHolder.getString("formattedScore", i, windowIndex), dataHolder.getString("scoreTag", i, windowIndex), dataHolder.getBoolean("newBest", i, windowIndex)));
            }
        }
    }

    public final String getLeaderboardId() {
        return this.b;
    }

    public final String getPlayerId() {
        return this.c;
    }

    public final Result getScoreResult(int i) {
        return this.e.get(i);
    }

    public final String toString() {
        Objects.ToStringHelper add = Objects.toStringHelper(this).add("PlayerId", this.c).add("StatusCode", Integer.valueOf(this.d));
        for (int i = 0; i < 3; i++) {
            Result result = this.e.get(i);
            add.add("TimesSpan", zzeg.zzn(i));
            add.add("Result", result == null ? "null" : result.toString());
        }
        return add.toString();
    }
}
