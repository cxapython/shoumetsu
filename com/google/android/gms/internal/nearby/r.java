package com.google.android.gms.internal.nearby;

import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.nearby.connection.Connections;

@VisibleForTesting
@Deprecated
/* loaded from: classes.dex */
final class r extends zzdh {
    private final ListenerHolder<Connections.MessageListener> a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(ListenerHolder<Connections.MessageListener> listenerHolder) {
        this.a = (ListenerHolder) Preconditions.checkNotNull(listenerHolder);
    }

    @Override // com.google.android.gms.internal.nearby.zzdg
    public final void zza(zzep zzepVar) {
        this.a.notifyListener(new t(this, zzepVar));
    }

    @Override // com.google.android.gms.internal.nearby.zzdg
    public final void zza(zzev zzevVar) {
        this.a.notifyListener(new s(this, zzevVar));
    }

    @Override // com.google.android.gms.internal.nearby.zzdg
    public final void zza(zzex zzexVar) {
    }
}
