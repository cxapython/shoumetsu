package com.google.android.gms.games;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.games.Games;
import com.google.android.gms.internal.games.zzt;
import com.google.android.gms.tasks.Task;

/* loaded from: classes.dex */
public class NotificationsClient extends zzt {
    public static final int NOTIFICATION_TYPES_ALL = 19;
    public static final int NOTIFICATION_TYPES_MULTIPLAYER = 3;
    public static final int NOTIFICATION_TYPE_INVITATION = 1;
    public static final int NOTIFICATION_TYPE_LEVEL_UP = 16;
    public static final int NOTIFICATION_TYPE_MATCH_UPDATE = 2;

    /* JADX INFO: Access modifiers changed from: package-private */
    public NotificationsClient(Activity activity, Games.GamesOptions gamesOptions) {
        super(activity, gamesOptions);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public NotificationsClient(Context context, Games.GamesOptions gamesOptions) {
        super(context, gamesOptions);
    }

    public Task<Void> clear(int i) {
        return doWrite(new p(this, i));
    }

    public Task<Void> clearAll() {
        return clear(19);
    }
}
