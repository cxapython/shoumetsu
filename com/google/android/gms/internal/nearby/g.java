package com.google.android.gms.internal.nearby;

import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.nearby.connection.Connections;

@VisibleForTesting
@Deprecated
/* loaded from: classes.dex */
final class g extends zzde {
    private final ListenerHolder<Connections.ConnectionRequestListener> a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(ListenerHolder<Connections.ConnectionRequestListener> listenerHolder) {
        this.a = (ListenerHolder) Preconditions.checkNotNull(listenerHolder);
    }

    @Override // com.google.android.gms.internal.nearby.zzdd
    public final void zza(zzej zzejVar) {
        this.a.notifyListener(new h(this, zzejVar));
    }

    @Override // com.google.android.gms.internal.nearby.zzdd
    public final void zza(zzfb zzfbVar) {
    }
}
