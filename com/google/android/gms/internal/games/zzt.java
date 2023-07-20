package com.google.android.gms.internal.games;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.games.Games;

/* loaded from: classes.dex */
public class zzt extends GoogleApi<Games.GamesOptions> {
    /* JADX INFO: Access modifiers changed from: protected */
    public zzt(Activity activity, Games.GamesOptions gamesOptions) {
        super(activity, Games.API, gamesOptions, GoogleApi.Settings.DEFAULT_SETTINGS);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public zzt(Context context, Games.GamesOptions gamesOptions) {
        super(context, Games.API, gamesOptions, GoogleApi.Settings.DEFAULT_SETTINGS);
    }
}
