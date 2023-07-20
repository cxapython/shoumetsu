package com.google.android.gms.internal.nearby;

import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.nearby.connection.Connections;

@VisibleForTesting
/* loaded from: classes.dex */
final class o extends zzds {
    private final ListenerHolder<Connections.EndpointDiscoveryListener> a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(ListenerHolder<Connections.EndpointDiscoveryListener> listenerHolder) {
        this.a = (ListenerHolder) Preconditions.checkNotNull(listenerHolder);
    }

    @Override // com.google.android.gms.internal.nearby.zzdr
    public final void zza(zzer zzerVar) {
        this.a.notifyListener(new p(this, zzerVar));
    }

    @Override // com.google.android.gms.internal.nearby.zzdr
    public final void zza(zzet zzetVar) {
        this.a.notifyListener(new q(this, zzetVar));
    }

    @Override // com.google.android.gms.internal.nearby.zzdr
    public final void zza(zzfd zzfdVar) {
    }
}
