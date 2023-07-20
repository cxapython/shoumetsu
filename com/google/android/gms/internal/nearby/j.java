package com.google.android.gms.internal.nearby;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.nearby.connection.Connections;

/* loaded from: classes.dex */
final class j extends u<Connections.ConnectionResponseCallback> {
    private final /* synthetic */ zzel a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(i iVar, zzel zzelVar) {
        super();
        this.a = zzelVar;
    }

    @Override // com.google.android.gms.common.api.internal.ListenerHolder.Notifier
    public final /* synthetic */ void notifyListener(Object obj) {
        Status b;
        String zzg = this.a.zzg();
        b = zzx.b(this.a.getStatusCode());
        ((Connections.ConnectionResponseCallback) obj).onConnectionResponse(zzg, b, this.a.zzj());
    }
}
