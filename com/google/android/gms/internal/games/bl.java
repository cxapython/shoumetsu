package com.google.android.gms.internal.games;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.stats.PlayerStats;
import com.google.android.gms.games.stats.Stats;

/* loaded from: classes.dex */
final class bl implements Stats.LoadPlayerStatsResult {
    private final /* synthetic */ Status a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bl(bk bkVar, Status status) {
        this.a = status;
    }

    @Override // com.google.android.gms.games.stats.Stats.LoadPlayerStatsResult
    public final PlayerStats getPlayerStats() {
        return null;
    }

    @Override // com.google.android.gms.common.api.Result
    public final Status getStatus() {
        return this.a;
    }

    @Override // com.google.android.gms.common.api.Releasable
    public final void release() {
    }
}
