package com.google.android.gms.games;

import com.google.android.gms.common.internal.PendingResultUtil;
import com.google.android.gms.games.stats.PlayerStats;
import com.google.android.gms.games.stats.Stats;

/* loaded from: classes.dex */
final class q implements PendingResultUtil.ResultConverter<Stats.LoadPlayerStatsResult, PlayerStats> {
    @Override // com.google.android.gms.common.internal.PendingResultUtil.ResultConverter
    public final /* synthetic */ PlayerStats convert(Stats.LoadPlayerStatsResult loadPlayerStatsResult) {
        PlayerStats playerStats;
        Stats.LoadPlayerStatsResult loadPlayerStatsResult2 = loadPlayerStatsResult;
        if (loadPlayerStatsResult2 == null || (playerStats = loadPlayerStatsResult2.getPlayerStats()) == null) {
            return null;
        }
        return playerStats.mo28freeze();
    }
}
