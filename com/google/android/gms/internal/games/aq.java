package com.google.android.gms.internal.games;

import com.google.android.gms.common.api.GoogleApiClient;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class aq extends au {
    private final /* synthetic */ String[] b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public aq(zzbz zzbzVar, GoogleApiClient googleApiClient, String[] strArr) {
        super(googleApiClient, null);
        this.b = strArr;
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    protected final /* synthetic */ void a(com.google.android.gms.games.internal.zze zzeVar) {
        zzeVar.zzb(this, this.b);
    }
}
