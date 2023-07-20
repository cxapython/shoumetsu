package com.google.android.gms.games;

import com.google.android.gms.common.internal.PendingResultUtil;
import com.google.android.gms.games.achievement.Achievements;

/* loaded from: classes.dex */
final class cb implements PendingResultUtil.ResultConverter<Achievements.UpdateAchievementResult, Boolean> {
    @Override // com.google.android.gms.common.internal.PendingResultUtil.ResultConverter
    public final /* synthetic */ Boolean convert(Achievements.UpdateAchievementResult updateAchievementResult) {
        Achievements.UpdateAchievementResult updateAchievementResult2 = updateAchievementResult;
        return Boolean.valueOf(updateAchievementResult2 != null && updateAchievementResult2.getStatus().getStatusCode() == 3003);
    }
}
