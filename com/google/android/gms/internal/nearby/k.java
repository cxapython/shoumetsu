package com.google.android.gms.internal.nearby;

import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.nearby.connection.EndpointDiscoveryCallback;
import java.util.Set;

@VisibleForTesting
/* loaded from: classes.dex */
final class k extends zzds {
    private final ListenerHolder<EndpointDiscoveryCallback> a;
    private final Set<String> b = new androidx.b.b();

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(ListenerHolder<EndpointDiscoveryCallback> listenerHolder) {
        this.a = (ListenerHolder) Preconditions.checkNotNull(listenerHolder);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final synchronized void a() {
        for (String str : this.b) {
            this.a.notifyListener(new n(this, str));
        }
        this.b.clear();
    }

    @Override // com.google.android.gms.internal.nearby.zzdr
    public final synchronized void zza(zzer zzerVar) {
        this.b.add(zzerVar.zze());
        this.a.notifyListener(new l(this, zzerVar));
    }

    @Override // com.google.android.gms.internal.nearby.zzdr
    public final synchronized void zza(zzet zzetVar) {
        this.b.remove(zzetVar.zze());
        this.a.notifyListener(new m(this, zzetVar));
    }

    @Override // com.google.android.gms.internal.nearby.zzdr
    public final void zza(zzfd zzfdVar) {
    }
}
