package com.google.android.gms.games;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.internal.PendingResultUtil;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.achievement.AchievementBuffer;
import com.google.android.gms.games.achievement.Achievements;
import com.google.android.gms.games.internal.zzbe;
import com.google.android.gms.games.internal.zzbn;
import com.google.android.gms.internal.games.zzt;
import com.google.android.gms.tasks.Task;

/* loaded from: classes.dex */
public class AchievementsClient extends zzt {
    private static final PendingResultUtil.ResultConverter<Achievements.LoadAchievementsResult, AchievementBuffer> b = new z();
    private static final PendingResultUtil.ResultConverter<Achievements.UpdateAchievementResult, Void> c = new ba();
    private static final PendingResultUtil.ResultConverter<Achievements.UpdateAchievementResult, Boolean> d = new cb();
    private static final zzbn e = new cf();

    /* JADX INFO: Access modifiers changed from: package-private */
    public AchievementsClient(Activity activity, Games.GamesOptions gamesOptions) {
        super(activity, gamesOptions);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AchievementsClient(Context context, Games.GamesOptions gamesOptions) {
        super(context, gamesOptions);
    }

    private static Task<Void> a(PendingResult<Achievements.UpdateAchievementResult> pendingResult) {
        return zzbe.zza(pendingResult, e, c);
    }

    private static Task<Boolean> b(PendingResult<Achievements.UpdateAchievementResult> pendingResult) {
        return zzbe.zza(pendingResult, e, d);
    }

    public Task<Intent> getAchievementsIntent() {
        return doRead(new a(this));
    }

    public void increment(String str, int i) {
        Games.Achievements.increment(asGoogleApiClient(), str, i);
    }

    public Task<Boolean> incrementImmediate(String str, int i) {
        return b(Games.Achievements.incrementImmediate(asGoogleApiClient(), str, i));
    }

    public Task<AnnotatedData<AchievementBuffer>> load(boolean z) {
        return zzbe.zzb(Games.Achievements.load(asGoogleApiClient(), z), b);
    }

    public void reveal(String str) {
        Games.Achievements.reveal(asGoogleApiClient(), str);
    }

    public Task<Void> revealImmediate(String str) {
        return a(Games.Achievements.revealImmediate(asGoogleApiClient(), str));
    }

    public void setSteps(String str, int i) {
        Games.Achievements.setSteps(asGoogleApiClient(), str, i);
    }

    public Task<Boolean> setStepsImmediate(String str, int i) {
        return b(Games.Achievements.setStepsImmediate(asGoogleApiClient(), str, i));
    }

    public void unlock(String str) {
        Games.Achievements.unlock(asGoogleApiClient(), str);
    }

    public Task<Void> unlockImmediate(String str) {
        return a(Games.Achievements.unlockImmediate(asGoogleApiClient(), str));
    }
}
