package com.google.android.gms.internal.games;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.games.stats.Stats;

/* loaded from: classes.dex */
public final class zzcv implements Stats {
    @Override // com.google.android.gms.games.stats.Stats
    public final PendingResult<Stats.LoadPlayerStatsResult> loadPlayerStats(GoogleApiClient googleApiClient, boolean z) {
        return googleApiClient.enqueue(new bj(this, googleApiClient, z));
    }
}
