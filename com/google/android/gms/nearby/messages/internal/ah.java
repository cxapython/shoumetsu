package com.google.android.gms.nearby.messages.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.internal.nearby.zzgy;

/* loaded from: classes.dex */
final class ah extends al {
    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(zzbi zzbiVar, GoogleApiClient googleApiClient) {
        super(googleApiClient);
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    protected final /* synthetic */ void a(zzah zzahVar) {
        ((zzs) zzahVar.getService()).zza(new zzh(new zzgy(a())));
    }
}
