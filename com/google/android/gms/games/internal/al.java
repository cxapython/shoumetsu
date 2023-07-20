package com.google.android.gms.games.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.games.GamesStatusCodes;
import com.google.android.gms.games.internal.zze;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class al extends zze.u<Status> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public al(BaseImplementation.ResultHolder resultHolder) {
        super(resultHolder);
    }

    @Override // com.google.android.gms.games.internal.zza, com.google.android.gms.games.internal.zzbq
    public final void onSignOutComplete() {
        a(GamesStatusCodes.zza(0));
    }
}
