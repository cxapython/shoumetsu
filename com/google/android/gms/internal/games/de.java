package com.google.android.gms.internal.games;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.achievement.Achievements;

/* loaded from: classes.dex */
abstract class de extends Games.zza<Achievements.UpdateAchievementResult> {
    private final String b;

    public de(String str, GoogleApiClient googleApiClient) {
        super(googleApiClient);
        this.b = str;
    }

    @Override // com.google.android.gms.common.api.internal.BasePendingResult
    /* renamed from: createFailedResult */
    public /* synthetic */ Result mo8createFailedResult(Status status) {
        return new df(this, status);
    }
}
