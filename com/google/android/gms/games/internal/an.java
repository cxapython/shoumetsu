package com.google.android.gms.games.internal;

import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.internal.zze;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class an extends zze.u<TurnBasedMultiplayer.LoadMatchResult> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public an(BaseImplementation.ResultHolder resultHolder) {
        super(resultHolder);
    }

    @Override // com.google.android.gms.games.internal.zza, com.google.android.gms.games.internal.zzbq
    public final void zzn(DataHolder dataHolder) {
        a(new zze.b(dataHolder));
    }
}
