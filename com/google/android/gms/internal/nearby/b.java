package com.google.android.gms.internal.nearby;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.nearby.connection.ConnectionLifecycleCallback;
import com.google.android.gms.nearby.connection.ConnectionResolution;

/* loaded from: classes.dex */
final class b extends u<ConnectionLifecycleCallback> {
    private final /* synthetic */ zzen a;
    private final /* synthetic */ Status b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(cp cpVar, zzen zzenVar, Status status) {
        super();
        this.a = zzenVar;
        this.b = status;
    }

    @Override // com.google.android.gms.common.api.internal.ListenerHolder.Notifier
    public final /* synthetic */ void notifyListener(Object obj) {
        ((ConnectionLifecycleCallback) obj).onConnectionResult(this.a.zzg(), new ConnectionResolution(this.b));
    }
}
