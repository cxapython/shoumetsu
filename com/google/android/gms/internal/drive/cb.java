package com.google.android.gms.internal.drive;

import com.google.android.gms.common.api.GoogleApiClient;
import java.util.List;

/* loaded from: classes.dex */
final class cb extends zzav {
    private final /* synthetic */ List b;
    private final /* synthetic */ zzdp c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public cb(zzdp zzdpVar, GoogleApiClient googleApiClient, List list) {
        super(googleApiClient);
        this.c = zzdpVar;
        this.b = list;
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    protected final /* synthetic */ void a(zzaw zzawVar) {
        ((zzeo) zzawVar.getService()).zza(new zzgq(this.c.a, this.b), new zzgs(this));
    }
}
