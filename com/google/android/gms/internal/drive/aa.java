package com.google.android.gms.internal.drive;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.drive.Contents;

/* loaded from: classes.dex */
final class aa extends zzav {
    private final /* synthetic */ zzbi b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public aa(zzbi zzbiVar, GoogleApiClient googleApiClient) {
        super(googleApiClient);
        this.b = zzbiVar;
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    protected final /* synthetic */ void a(zzaw zzawVar) {
        Contents contents;
        contents = this.b.b;
        ((zzeo) zzawVar.getService()).zza(new zzo(contents.getRequestId(), false), new zzgs(this));
    }
}
