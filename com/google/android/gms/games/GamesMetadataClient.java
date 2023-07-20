package com.google.android.gms.games;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.common.internal.PendingResultUtil;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.GamesMetadata;
import com.google.android.gms.games.internal.zzbe;
import com.google.android.gms.games.internal.zzbm;
import com.google.android.gms.internal.games.zzt;
import com.google.android.gms.tasks.Task;

/* loaded from: classes.dex */
public class GamesMetadataClient extends zzt {
    private static final PendingResultUtil.ResultConverter<GamesMetadata.LoadGamesResult, Game> b = new cv();
    private static final zzbm<GamesMetadata.LoadGamesResult> c = new cw();

    /* JADX INFO: Access modifiers changed from: package-private */
    public GamesMetadataClient(Activity activity, Games.GamesOptions gamesOptions) {
        super(activity, gamesOptions);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public GamesMetadataClient(Context context, Games.GamesOptions gamesOptions) {
        super(context, gamesOptions);
    }

    public Task<Game> getCurrentGame() {
        return doRead(new cu(this));
    }

    public Task<AnnotatedData<Game>> loadGame() {
        return zzbe.zza(Games.GamesMetadata.loadGame(asGoogleApiClient()), b, c);
    }
}
