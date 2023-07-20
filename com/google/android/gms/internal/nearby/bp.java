package com.google.android.gms.internal.nearby;

import com.google.android.gms.common.api.GoogleApiClient;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class bp extends bw {
    /* JADX INFO: Access modifiers changed from: package-private */
    public bp(zzca zzcaVar, GoogleApiClient googleApiClient) {
        super(googleApiClient, null);
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    protected final /* synthetic */ void a(zzx zzxVar) {
        zzxVar.stopDiscovery();
    }
}
