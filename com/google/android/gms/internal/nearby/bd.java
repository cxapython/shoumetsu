package com.google.android.gms.internal.nearby;

import com.google.android.gms.common.api.GoogleApiClient;

/* loaded from: classes.dex */
final class bd extends bw {
    private final /* synthetic */ String b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bd(zzca zzcaVar, GoogleApiClient googleApiClient, String str) {
        super(googleApiClient, null);
        this.b = str;
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    protected final /* synthetic */ void a(zzx zzxVar) {
        zzxVar.disconnectFromEndpoint(this.b);
    }
}
