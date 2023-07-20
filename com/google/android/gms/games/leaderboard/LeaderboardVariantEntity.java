package com.google.android.gms.games.leaderboard;

import com.google.android.apps.common.proguard.UsedByReflection;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.internal.games.zzeg;

@UsedByReflection("GamesClientImpl.java")
/* loaded from: classes.dex */
public final class LeaderboardVariantEntity implements LeaderboardVariant {
    private final int a;
    private final int b;
    private final boolean c;
    private final long d;
    private final String e;
    private final long f;
    private final String g;
    private final String h;
    private final long i;
    private final String j;
    private final String k;
    private final String l;

    public LeaderboardVariantEntity(LeaderboardVariant leaderboardVariant) {
        this.a = leaderboardVariant.getTimeSpan();
        this.b = leaderboardVariant.getCollection();
        this.c = leaderboardVariant.hasPlayerInfo();
        this.d = leaderboardVariant.getRawPlayerScore();
        this.e = leaderboardVariant.getDisplayPlayerScore();
        this.f = leaderboardVariant.getPlayerRank();
        this.g = leaderboardVariant.getDisplayPlayerRank();
        this.h = leaderboardVariant.getPlayerScoreTag();
        this.i = leaderboardVariant.getNumScores();
        this.j = leaderboardVariant.zzdk();
        this.k = leaderboardVariant.zzdl();
        this.l = leaderboardVariant.zzdm();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(LeaderboardVariant leaderboardVariant) {
        return Objects.hashCode(Integer.valueOf(leaderboardVariant.getTimeSpan()), Integer.valueOf(leaderboardVariant.getCollection()), Boolean.valueOf(leaderboardVariant.hasPlayerInfo()), Long.valueOf(leaderboardVariant.getRawPlayerScore()), leaderboardVariant.getDisplayPlayerScore(), Long.valueOf(leaderboardVariant.getPlayerRank()), leaderboardVariant.getDisplayPlayerRank(), Long.valueOf(leaderboardVariant.getNumScores()), leaderboardVariant.zzdk(), leaderboardVariant.zzdm(), leaderboardVariant.zzdl());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(LeaderboardVariant leaderboardVariant, Object obj) {
        if (!(obj instanceof LeaderboardVariant)) {
            return false;
        }
        if (leaderboardVariant == obj) {
            return true;
        }
        LeaderboardVariant leaderboardVariant2 = (LeaderboardVariant) obj;
        return Objects.equal(Integer.valueOf(leaderboardVariant2.getTimeSpan()), Integer.valueOf(leaderboardVariant.getTimeSpan())) && Objects.equal(Integer.valueOf(leaderboardVariant2.getCollection()), Integer.valueOf(leaderboardVariant.getCollection())) && Objects.equal(Boolean.valueOf(leaderboardVariant2.hasPlayerInfo()), Boolean.valueOf(leaderboardVariant.hasPlayerInfo())) && Objects.equal(Long.valueOf(leaderboardVariant2.getRawPlayerScore()), Long.valueOf(leaderboardVariant.getRawPlayerScore())) && Objects.equal(leaderboardVariant2.getDisplayPlayerScore(), leaderboardVariant.getDisplayPlayerScore()) && Objects.equal(Long.valueOf(leaderboardVariant2.getPlayerRank()), Long.valueOf(leaderboardVariant.getPlayerRank())) && Objects.equal(leaderboardVariant2.getDisplayPlayerRank(), leaderboardVariant.getDisplayPlayerRank()) && Objects.equal(Long.valueOf(leaderboardVariant2.getNumScores()), Long.valueOf(leaderboardVariant.getNumScores())) && Objects.equal(leaderboardVariant2.zzdk(), leaderboardVariant.zzdk()) && Objects.equal(leaderboardVariant2.zzdm(), leaderboardVariant.zzdm()) && Objects.equal(leaderboardVariant2.zzdl(), leaderboardVariant.zzdl());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String b(LeaderboardVariant leaderboardVariant) {
        String str;
        Objects.ToStringHelper add = Objects.toStringHelper(leaderboardVariant).add("TimeSpan", zzeg.zzn(leaderboardVariant.getTimeSpan()));
        int collection = leaderboardVariant.getCollection();
        switch (collection) {
            case -1:
                str = "UNKNOWN";
                break;
            case 0:
                str = "PUBLIC";
                break;
            case 1:
                str = "SOCIAL";
                break;
            case 2:
                str = "SOCIAL_1P";
                break;
            default:
                StringBuilder sb = new StringBuilder(43);
                sb.append("Unknown leaderboard collection: ");
                sb.append(collection);
                throw new IllegalArgumentException(sb.toString());
        }
        return add.add("Collection", str).add("RawPlayerScore", leaderboardVariant.hasPlayerInfo() ? Long.valueOf(leaderboardVariant.getRawPlayerScore()) : "none").add("DisplayPlayerScore", leaderboardVariant.hasPlayerInfo() ? leaderboardVariant.getDisplayPlayerScore() : "none").add("PlayerRank", leaderboardVariant.hasPlayerInfo() ? Long.valueOf(leaderboardVariant.getPlayerRank()) : "none").add("DisplayPlayerRank", leaderboardVariant.hasPlayerInfo() ? leaderboardVariant.getDisplayPlayerRank() : "none").add("NumScores", Long.valueOf(leaderboardVariant.getNumScores())).add("TopPageNextToken", leaderboardVariant.zzdk()).add("WindowPageNextToken", leaderboardVariant.zzdm()).add("WindowPagePrevToken", leaderboardVariant.zzdl()).toString();
    }

    public final boolean equals(Object obj) {
        return a(this, obj);
    }

    @Override // com.google.android.gms.common.data.Freezable
    /* renamed from: freeze */
    public final /* bridge */ /* synthetic */ LeaderboardVariant mo28freeze() {
        return this;
    }

    @Override // com.google.android.gms.games.leaderboard.LeaderboardVariant
    public final int getCollection() {
        return this.b;
    }

    @Override // com.google.android.gms.games.leaderboard.LeaderboardVariant
    public final String getDisplayPlayerRank() {
        return this.g;
    }

    @Override // com.google.android.gms.games.leaderboard.LeaderboardVariant
    public final String getDisplayPlayerScore() {
        return this.e;
    }

    @Override // com.google.android.gms.games.leaderboard.LeaderboardVariant
    public final long getNumScores() {
        return this.i;
    }

    @Override // com.google.android.gms.games.leaderboard.LeaderboardVariant
    public final long getPlayerRank() {
        return this.f;
    }

    @Override // com.google.android.gms.games.leaderboard.LeaderboardVariant
    public final String getPlayerScoreTag() {
        return this.h;
    }

    @Override // com.google.android.gms.games.leaderboard.LeaderboardVariant
    public final long getRawPlayerScore() {
        return this.d;
    }

    @Override // com.google.android.gms.games.leaderboard.LeaderboardVariant
    public final int getTimeSpan() {
        return this.a;
    }

    @Override // com.google.android.gms.games.leaderboard.LeaderboardVariant
    public final boolean hasPlayerInfo() {
        return this.c;
    }

    public final int hashCode() {
        return a(this);
    }

    @Override // com.google.android.gms.common.data.Freezable
    public final boolean isDataValid() {
        return true;
    }

    public final String toString() {
        return b(this);
    }

    @Override // com.google.android.gms.games.leaderboard.LeaderboardVariant
    public final String zzdk() {
        return this.j;
    }

    @Override // com.google.android.gms.games.leaderboard.LeaderboardVariant
    public final String zzdl() {
        return this.k;
    }

    @Override // com.google.android.gms.games.leaderboard.LeaderboardVariant
    public final String zzdm() {
        return this.l;
    }
}
