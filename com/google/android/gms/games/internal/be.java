package com.google.android.gms.games.internal;

import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.internal.zze;
import com.google.android.gms.games.leaderboard.Leaderboards;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class be extends zze.u<Leaderboards.LoadPlayerScoreResult> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public be(BaseImplementation.ResultHolder resultHolder) {
        super(resultHolder);
    }

    @Override // com.google.android.gms.games.internal.zza, com.google.android.gms.games.internal.zzbq
    public final void zzac(DataHolder dataHolder) {
        a(new zze.d(dataHolder));
    }
}
