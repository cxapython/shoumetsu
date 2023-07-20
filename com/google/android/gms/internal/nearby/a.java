package com.google.android.gms.internal.nearby;

import com.google.android.gms.nearby.connection.ConnectionInfo;
import com.google.android.gms.nearby.connection.ConnectionLifecycleCallback;

/* loaded from: classes.dex */
final class a extends u<ConnectionLifecycleCallback> {
    private final /* synthetic */ zzeh a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(cp cpVar, zzeh zzehVar) {
        super();
        this.a = zzehVar;
    }

    @Override // com.google.android.gms.common.api.internal.ListenerHolder.Notifier
    public final /* synthetic */ void notifyListener(Object obj) {
        ((ConnectionLifecycleCallback) obj).onConnectionInitiated(this.a.zzg(), new ConnectionInfo(this.a.zzh(), this.a.getAuthenticationToken(), this.a.zzi()));
    }
}
