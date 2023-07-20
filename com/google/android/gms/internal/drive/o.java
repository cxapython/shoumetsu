package com.google.android.gms.internal.drive;

import com.google.android.gms.common.api.GoogleApiClient;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class o extends zzav {
    private final /* synthetic */ zzgm b;
    private final /* synthetic */ zzee c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(zzaw zzawVar, GoogleApiClient googleApiClient, zzgm zzgmVar, zzee zzeeVar) {
        super(googleApiClient);
        this.b = zzgmVar;
        this.c = zzeeVar;
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    protected final /* synthetic */ void a(zzaw zzawVar) {
        ((zzeo) zzawVar.getService()).zza(this.b, this.c, (String) null, new zzgs(this));
    }
}
