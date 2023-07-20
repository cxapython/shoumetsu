package com.google.android.gms.games;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.common.internal.PendingResultUtil;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.internal.zzbe;
import com.google.android.gms.games.stats.PlayerStats;
import com.google.android.gms.games.stats.Stats;
import com.google.android.gms.internal.games.zzt;
import com.google.android.gms.tasks.Task;

/* loaded from: classes.dex */
public class PlayerStatsClient extends zzt {
    private static final PendingResultUtil.ResultConverter<Stats.LoadPlayerStatsResult, PlayerStats> b = new q();

    /* JADX INFO: Access modifiers changed from: package-private */
    public PlayerStatsClient(Activity activity, Games.GamesOptions gamesOptions) {
        super(activity, gamesOptions);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PlayerStatsClient(Context context, Games.GamesOptions gamesOptions) {
        super(context, gamesOptions);
    }

    public Task<AnnotatedData<PlayerStats>> loadPlayerStats(boolean z) {
        return zzbe.zza(Games.Stats.loadPlayerStats(asGoogleApiClient(), z), b);
    }
}
