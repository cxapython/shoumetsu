package com.google.android.gms.internal.nearby;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.ListenerHolder;

/* loaded from: classes.dex */
final class bq extends bw {
    private final /* synthetic */ String b;
    private final /* synthetic */ String c;
    private final /* synthetic */ ListenerHolder d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bq(zzca zzcaVar, GoogleApiClient googleApiClient, String str, String str2, ListenerHolder listenerHolder) {
        super(googleApiClient, null);
        this.b = str;
        this.c = str2;
        this.d = listenerHolder;
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    protected final /* synthetic */ void a(zzx zzxVar) {
        zzxVar.zza(this, this.b, this.c, this.d);
    }
}
