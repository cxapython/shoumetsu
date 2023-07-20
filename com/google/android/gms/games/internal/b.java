package com.google.android.gms.games.internal;

import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.achievement.Achievements;
import com.google.android.gms.games.internal.zze;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class b extends zze.u<Achievements.LoadAchievementsResult> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public b(BaseImplementation.ResultHolder resultHolder) {
        super(resultHolder);
    }

    @Override // com.google.android.gms.games.internal.zza, com.google.android.gms.games.internal.zzbq
    public final void zza(DataHolder dataHolder) {
        a(new zze.bf(dataHolder));
    }
}
