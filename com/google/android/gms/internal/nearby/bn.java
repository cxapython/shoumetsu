package com.google.android.gms.internal.nearby;

import com.google.android.gms.common.api.GoogleApiClient;

/* loaded from: classes.dex */
final class bn extends bw {
    /* JADX INFO: Access modifiers changed from: package-private */
    public bn(zzca zzcaVar, GoogleApiClient googleApiClient) {
        super(googleApiClient, null);
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    protected final /* synthetic */ void a(zzx zzxVar) {
        zzxVar.stopAdvertising();
    }
}
