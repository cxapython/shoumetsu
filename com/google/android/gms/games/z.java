package com.google.android.gms.games;

import com.google.android.gms.common.internal.PendingResultUtil;
import com.google.android.gms.games.achievement.AchievementBuffer;
import com.google.android.gms.games.achievement.Achievements;

/* loaded from: classes.dex */
final class z implements PendingResultUtil.ResultConverter<Achievements.LoadAchievementsResult, AchievementBuffer> {
    @Override // com.google.android.gms.common.internal.PendingResultUtil.ResultConverter
    public final /* synthetic */ AchievementBuffer convert(Achievements.LoadAchievementsResult loadAchievementsResult) {
        Achievements.LoadAchievementsResult loadAchievementsResult2 = loadAchievementsResult;
        if (loadAchievementsResult2 == null) {
            return null;
        }
        return loadAchievementsResult2.getAchievements();
    }
}
