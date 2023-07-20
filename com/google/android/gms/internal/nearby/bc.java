package com.google.android.gms.internal.nearby;

import com.google.android.gms.common.api.GoogleApiClient;

/* loaded from: classes.dex */
final class bc extends bw {
    private final /* synthetic */ long b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bc(zzca zzcaVar, GoogleApiClient googleApiClient, long j) {
        super(googleApiClient, null);
        this.b = j;
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    protected final /* synthetic */ void a(zzx zzxVar) {
        zzxVar.zza(this, this.b);
    }
}
