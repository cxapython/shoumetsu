package com.google.android.gms.internal.nearby;

import com.google.android.gms.nearby.connection.Connections;

/* loaded from: classes.dex */
final class h extends u<Connections.ConnectionRequestListener> {
    private final /* synthetic */ zzej a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(g gVar, zzej zzejVar) {
        super();
        this.a = zzejVar;
    }

    @Override // com.google.android.gms.common.api.internal.ListenerHolder.Notifier
    public final /* synthetic */ void notifyListener(Object obj) {
        ((Connections.ConnectionRequestListener) obj).onConnectionRequest(this.a.zzg(), this.a.zzh(), this.a.zzj());
    }
}
