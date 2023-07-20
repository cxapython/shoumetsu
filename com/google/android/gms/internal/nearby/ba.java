package com.google.android.gms.internal.nearby;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.nearby.connection.Payload;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class ba extends bw {
    private final /* synthetic */ String b;
    private final /* synthetic */ Payload c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ba(zzca zzcaVar, GoogleApiClient googleApiClient, String str, Payload payload) {
        super(googleApiClient, null);
        this.b = str;
        this.c = payload;
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    protected final /* synthetic */ void a(zzx zzxVar) {
        zzxVar.zza((BaseImplementation.ResultHolder<Status>) this, new String[]{this.b}, this.c, false);
    }
}
