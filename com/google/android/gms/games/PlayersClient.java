package com.google.android.gms.games;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.common.internal.PendingResultUtil;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.Players;
import com.google.android.gms.games.internal.zzbe;
import com.google.android.gms.games.internal.zzbm;
import com.google.android.gms.internal.games.zzt;
import com.google.android.gms.tasks.Task;

/* loaded from: classes.dex */
public class PlayersClient extends zzt {
    public static final String EXTRA_PLAYER_SEARCH_RESULTS = "player_search_results";
    private static final PendingResultUtil.ResultConverter<Players.LoadPlayersResult, PlayerBuffer> b = new w();
    private static final zzbm<Players.LoadPlayersResult> c = new x();
    private static final PendingResultUtil.ResultConverter<Players.LoadPlayersResult, Player> d = new y();

    /* JADX INFO: Access modifiers changed from: package-private */
    public PlayersClient(Activity activity, Games.GamesOptions gamesOptions) {
        super(activity, gamesOptions);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PlayersClient(Context context, Games.GamesOptions gamesOptions) {
        super(context, gamesOptions);
    }

    public Task<Intent> getCompareProfileIntent(Player player) {
        return doRead(new u(this, player));
    }

    public Task<Player> getCurrentPlayer() {
        return doRead(new t(this));
    }

    public Task<String> getCurrentPlayerId() {
        return doRead(new s(this));
    }

    public Task<Intent> getPlayerSearchIntent() {
        return doRead(new v(this));
    }

    public Task<AnnotatedData<PlayerBuffer>> loadMoreRecentlyPlayedWithPlayers(int i) {
        return zzbe.zzb(Games.Players.loadMoreRecentlyPlayedWithPlayers(asGoogleApiClient(), i), b);
    }

    public Task<AnnotatedData<Player>> loadPlayer(String str) {
        return loadPlayer(str, false);
    }

    public Task<AnnotatedData<Player>> loadPlayer(String str, boolean z) {
        return zzbe.zza(Games.Players.loadPlayer(asGoogleApiClient(), str, z), d, c);
    }

    public Task<AnnotatedData<PlayerBuffer>> loadRecentlyPlayedWithPlayers(int i, boolean z) {
        return zzbe.zzb(Games.Players.loadRecentlyPlayedWithPlayers(asGoogleApiClient(), i, z), b);
    }
}
