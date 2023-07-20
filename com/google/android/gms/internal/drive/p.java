package com.google.android.gms.internal.drive;

import com.google.android.gms.common.api.GoogleApiClient;

/* loaded from: classes.dex */
final class p extends zzav {
    private final /* synthetic */ zzj b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p(zzaw zzawVar, GoogleApiClient googleApiClient, zzj zzjVar) {
        super(googleApiClient);
        this.b = zzjVar;
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    protected final /* synthetic */ void a(zzaw zzawVar) {
        ((zzeo) zzawVar.getService()).zza(this.b, (zzes) null, (String) null, new zzgs(this));
    }
}
