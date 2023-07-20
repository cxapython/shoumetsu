package com.google.android.gms.internal.nearby;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.nearby.connection.DiscoveryOptions;

/* loaded from: classes.dex */
final class bo extends bw {
    private final /* synthetic */ String b;
    private final /* synthetic */ ListenerHolder c;
    private final /* synthetic */ DiscoveryOptions d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bo(zzca zzcaVar, GoogleApiClient googleApiClient, String str, ListenerHolder listenerHolder, DiscoveryOptions discoveryOptions) {
        super(googleApiClient, null);
        this.b = str;
        this.c = listenerHolder;
        this.d = discoveryOptions;
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    protected final /* synthetic */ void a(zzx zzxVar) {
        zzxVar.zza(this, this.b, this.c, this.d);
    }
}
