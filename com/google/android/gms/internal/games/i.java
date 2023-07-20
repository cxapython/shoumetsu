package com.google.android.gms.internal.games;

import com.google.android.gms.common.api.GoogleApiClient;

/* loaded from: classes.dex */
final class i extends p {
    private final /* synthetic */ boolean b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(zzal zzalVar, GoogleApiClient googleApiClient, boolean z) {
        super(googleApiClient, null);
        this.b = z;
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    protected final /* synthetic */ void a(com.google.android.gms.games.internal.zze zzeVar) {
        zzeVar.zzb(this, this.b);
    }
}
