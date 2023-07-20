package com.google.android.gms.internal.games;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.achievement.Achievements;

/* loaded from: classes.dex */
final class df implements Achievements.UpdateAchievementResult {
    private final /* synthetic */ Status a;
    private final /* synthetic */ de b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public df(de deVar, Status status) {
        this.b = deVar;
        this.a = status;
    }

    @Override // com.google.android.gms.games.achievement.Achievements.UpdateAchievementResult
    public final String getAchievementId() {
        String str;
        str = this.b.b;
        return str;
    }

    @Override // com.google.android.gms.common.api.Result
    public final Status getStatus() {
        return this.a;
    }
}
