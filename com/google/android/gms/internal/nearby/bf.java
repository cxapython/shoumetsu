package com.google.android.gms.internal.nearby;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.nearby.connection.AdvertisingOptions;
import com.google.android.gms.nearby.connection.Strategy;

/* loaded from: classes.dex */
final class bf extends bu {
    private final /* synthetic */ String b;
    private final /* synthetic */ long c;
    private final /* synthetic */ ListenerHolder d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bf(zzca zzcaVar, GoogleApiClient googleApiClient, String str, long j, ListenerHolder listenerHolder) {
        super(googleApiClient, null);
        this.b = str;
        this.c = j;
        this.d = listenerHolder;
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    protected final /* synthetic */ void a(zzx zzxVar) {
        String str = this.b;
        long j = this.c;
        ListenerHolder listenerHolder = this.d;
        ((zzdu) zzxVar.getService()).zza(new zzga().zza(new ac(this)).zzi(str).zzj("__LEGACY_SERVICE_ID__").zzd(j).zza(new g(listenerHolder)).zzg(new AdvertisingOptions.Builder().setStrategy(Strategy.P2P_CLUSTER).build()).zzv());
    }
}
