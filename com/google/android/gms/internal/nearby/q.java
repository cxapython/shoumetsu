package com.google.android.gms.internal.nearby;

import com.google.android.gms.nearby.connection.Connections;

/* loaded from: classes.dex */
final class q extends u<Connections.EndpointDiscoveryListener> {
    private final /* synthetic */ zzet a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(o oVar, zzet zzetVar) {
        super();
        this.a = zzetVar;
    }

    @Override // com.google.android.gms.common.api.internal.ListenerHolder.Notifier
    public final /* synthetic */ void notifyListener(Object obj) {
        ((Connections.EndpointDiscoveryListener) obj).onEndpointLost(this.a.zze());
    }
}
