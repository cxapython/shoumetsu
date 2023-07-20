package com.google.android.gms.internal.nearby;

import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.nearby.connection.Connections;

@VisibleForTesting
@Deprecated
/* loaded from: classes.dex */
final class i extends zzdn {
    private final ListenerHolder<Connections.ConnectionResponseCallback> a;

    public i(ListenerHolder<Connections.ConnectionResponseCallback> listenerHolder) {
        this.a = (ListenerHolder) Preconditions.checkNotNull(listenerHolder);
    }

    @Override // com.google.android.gms.internal.nearby.zzdm
    public final void zza(zzel zzelVar) {
        this.a.notifyListener(new j(this, zzelVar));
    }
}
