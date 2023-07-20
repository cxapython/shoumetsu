package com.google.android.gms.internal.drive;

import com.google.android.gms.common.api.GoogleApiClient;

/* loaded from: classes.dex */
final class an extends zzav {
    private final /* synthetic */ zzei b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public an(zzcb zzcbVar, GoogleApiClient googleApiClient, zzei zzeiVar) {
        super(googleApiClient);
        this.b = zzeiVar;
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    protected final /* synthetic */ void a(zzaw zzawVar) {
        ((zzeo) zzawVar.getService()).zza(new zzgo(this.b), new zzgs(this));
    }
}
