package com.google.android.gms.internal.nearby;

import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.UnregisterListenerMethod;
import com.google.android.gms.nearby.connection.EndpointDiscoveryCallback;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes.dex */
final class aq extends UnregisterListenerMethod<zzx, EndpointDiscoveryCallback> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public aq(zzbd zzbdVar, ListenerHolder.ListenerKey listenerKey) {
        super(listenerKey);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.api.internal.UnregisterListenerMethod
    public final /* synthetic */ void a(zzx zzxVar, TaskCompletionSource taskCompletionSource) {
        zzxVar.stopDiscovery();
        taskCompletionSource.setResult(true);
    }
}
