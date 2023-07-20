package com.google.android.gms.internal.drive;

import com.google.android.gms.common.api.GoogleApiClient;

/* loaded from: classes.dex */
final class cd extends zzav {
    private final /* synthetic */ zzdp b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public cd(zzdp zzdpVar, GoogleApiClient googleApiClient) {
        super(googleApiClient);
        this.b = zzdpVar;
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    protected final /* synthetic */ void a(zzaw zzawVar) {
        ((zzeo) zzawVar.getService()).zza(new zzab(this.b.a), new zzgs(this));
    }
}
