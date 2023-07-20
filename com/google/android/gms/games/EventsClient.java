package com.google.android.gms.games;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.common.internal.PendingResultUtil;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.event.EventBuffer;
import com.google.android.gms.games.event.Events;
import com.google.android.gms.games.internal.zzbe;
import com.google.android.gms.internal.games.zzt;
import com.google.android.gms.tasks.Task;

/* loaded from: classes.dex */
public class EventsClient extends zzt {
    private static final PendingResultUtil.ResultConverter<Events.LoadEventsResult, EventBuffer> b = new ch();

    /* JADX INFO: Access modifiers changed from: package-private */
    public EventsClient(Activity activity, Games.GamesOptions gamesOptions) {
        super(activity, gamesOptions);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public EventsClient(Context context, Games.GamesOptions gamesOptions) {
        super(context, gamesOptions);
    }

    public void increment(String str, int i) {
        doWrite(new cg(this, str, i));
    }

    public Task<AnnotatedData<EventBuffer>> load(boolean z) {
        return zzbe.zzb(Games.Events.load(asGoogleApiClient(), z), b);
    }

    public Task<AnnotatedData<EventBuffer>> loadByIds(boolean z, String... strArr) {
        return zzbe.zzb(Games.Events.loadByIds(asGoogleApiClient(), z, strArr), b);
    }
}
