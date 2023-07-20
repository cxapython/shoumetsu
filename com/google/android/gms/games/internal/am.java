package com.google.android.gms.games.internal;

import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.games.GamesStatusCodes;
import com.google.android.gms.games.internal.zze;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class am extends zze.u<TurnBasedMultiplayer.CancelMatchResult> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public am(BaseImplementation.ResultHolder resultHolder) {
        super(resultHolder);
    }

    @Override // com.google.android.gms.games.internal.zza, com.google.android.gms.games.internal.zzbq
    public final void zzc(int i, String str) {
        a(new zze.al(GamesStatusCodes.zza(i), str));
    }
}
