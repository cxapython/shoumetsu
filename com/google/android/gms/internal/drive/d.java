package com.google.android.gms.internal.drive;

import com.google.android.gms.common.api.GoogleApiClient;

/* loaded from: classes.dex */
final class d extends zzav {
    /* JADX INFO: Access modifiers changed from: package-private */
    public d(zzaf zzafVar, GoogleApiClient googleApiClient) {
        super(googleApiClient);
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    protected final /* synthetic */ void a(zzaw zzawVar) {
        ((zzeo) zzawVar.getService()).zza(new zzgs(this));
    }
}
