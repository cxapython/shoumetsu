package com.google.android.gms.internal.nearby;

import com.google.android.gms.nearby.connection.Connections;

/* loaded from: classes.dex */
final class p extends u<Connections.EndpointDiscoveryListener> {
    private final /* synthetic */ zzer a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p(o oVar, zzer zzerVar) {
        super();
        this.a = zzerVar;
    }

    @Override // com.google.android.gms.common.api.internal.ListenerHolder.Notifier
    public final /* synthetic */ void notifyListener(Object obj) {
        ((Connections.EndpointDiscoveryListener) obj).onEndpointFound(this.a.zze(), this.a.getServiceId(), this.a.getEndpointName());
    }
}
