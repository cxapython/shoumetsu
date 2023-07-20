package com.google.android.gms.nearby.messages.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.nearby.messages.Message;

/* loaded from: classes.dex */
final class ac extends al {
    private final /* synthetic */ Message b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ac(zzbi zzbiVar, GoogleApiClient googleApiClient, Message message) {
        super(googleApiClient);
        this.b = message;
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    protected final /* synthetic */ void a(zzah zzahVar) {
        zzahVar.a(a(), zzaf.zza(this.b));
    }
}
