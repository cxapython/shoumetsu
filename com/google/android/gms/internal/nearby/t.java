package com.google.android.gms.internal.nearby;

import com.google.android.gms.nearby.connection.Connections;

/* loaded from: classes.dex */
final class t extends u<Connections.MessageListener> {
    private final /* synthetic */ zzep a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t(r rVar, zzep zzepVar) {
        super();
        this.a = zzepVar;
    }

    @Override // com.google.android.gms.common.api.internal.ListenerHolder.Notifier
    public final /* synthetic */ void notifyListener(Object obj) {
        ((Connections.MessageListener) obj).onDisconnected(this.a.zzg());
    }
}
