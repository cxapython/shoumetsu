package com.google.android.gms.internal.games;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.games.Players;

/* loaded from: classes.dex */
final class ab extends ad {
    private final /* synthetic */ int b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ab(zzbd zzbdVar, GoogleApiClient googleApiClient, int i) {
        super(googleApiClient);
        this.b = i;
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    protected final /* synthetic */ void a(com.google.android.gms.games.internal.zze zzeVar) {
        zzeVar.zza((BaseImplementation.ResultHolder<Players.LoadPlayersResult>) this, "played_with", this.b, true, false);
    }
}
