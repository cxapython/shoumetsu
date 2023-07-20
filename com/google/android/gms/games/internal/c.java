package com.google.android.gms.games.internal;

import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.GamesMetadata;
import com.google.android.gms.games.internal.zze;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class c extends zze.u<GamesMetadata.LoadGamesResult> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public c(BaseImplementation.ResultHolder resultHolder) {
        super(resultHolder);
    }

    @Override // com.google.android.gms.games.internal.zza, com.google.android.gms.games.internal.zzbq
    public final void zzg(DataHolder dataHolder) {
        a(new zze.bh(dataHolder));
    }
}
