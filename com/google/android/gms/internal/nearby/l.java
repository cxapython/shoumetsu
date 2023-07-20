package com.google.android.gms.internal.nearby;

import com.google.android.gms.nearby.connection.DiscoveredEndpointInfo;
import com.google.android.gms.nearby.connection.EndpointDiscoveryCallback;

/* loaded from: classes.dex */
final class l extends u<EndpointDiscoveryCallback> {
    private final /* synthetic */ zzer a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(k kVar, zzer zzerVar) {
        super();
        this.a = zzerVar;
    }

    @Override // com.google.android.gms.common.api.internal.ListenerHolder.Notifier
    public final /* synthetic */ void notifyListener(Object obj) {
        String zze;
        DiscoveredEndpointInfo discoveredEndpointInfo;
        EndpointDiscoveryCallback endpointDiscoveryCallback = (EndpointDiscoveryCallback) obj;
        if ("__UNRECOGNIZED_BLUETOOTH_DEVICE__".equals(this.a.zze())) {
            zze = this.a.zze();
            discoveredEndpointInfo = new DiscoveredEndpointInfo(this.a.getServiceId(), this.a.zzk());
        } else {
            zze = this.a.zze();
            discoveredEndpointInfo = new DiscoveredEndpointInfo(this.a.getServiceId(), this.a.getEndpointName());
        }
        endpointDiscoveryCallback.onEndpointFound(zze, discoveredEndpointInfo);
    }
}
