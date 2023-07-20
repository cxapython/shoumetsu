package com.google.android.gms.games;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.games.Games;
import com.google.android.gms.internal.games.zzt;
import com.google.android.gms.tasks.Task;

/* loaded from: classes.dex */
public class GamesClient extends zzt {
    /* JADX INFO: Access modifiers changed from: package-private */
    public GamesClient(Activity activity, Games.GamesOptions gamesOptions) {
        super(activity, gamesOptions);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public GamesClient(Context context, Games.GamesOptions gamesOptions) {
        super(context, gamesOptions);
    }

    public Task<Bundle> getActivationHint() {
        return doRead(new cs(this));
    }

    public Task<String> getAppId() {
        return doRead(new cq(this));
    }

    public Task<String> getCurrentAccountName() {
        return doRead(new cp(this));
    }

    @KeepForSdk
    public Task<Integer> getSdkVariant() {
        return doRead(new ct(this));
    }

    public Task<Intent> getSettingsIntent() {
        return doRead(new cr(this));
    }

    public Task<Void> setGravityForPopups(int i) {
        return doWrite(new cn(this, i));
    }

    public Task<Void> setViewForPopups(View view) {
        return doWrite(new co(this, view));
    }
}
