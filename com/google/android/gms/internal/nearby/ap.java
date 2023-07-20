package com.google.android.gms.internal.nearby;

import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.RegisterListenerMethod;
import com.google.android.gms.nearby.connection.DiscoveryOptions;
import com.google.android.gms.nearby.connection.EndpointDiscoveryCallback;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes.dex */
final class ap extends RegisterListenerMethod<zzx, EndpointDiscoveryCallback> {
    private final /* synthetic */ String a;
    private final /* synthetic */ ListenerHolder b;
    private final /* synthetic */ DiscoveryOptions c;
    private final /* synthetic */ zzbd d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ap(zzbd zzbdVar, ListenerHolder listenerHolder, String str, ListenerHolder listenerHolder2, DiscoveryOptions discoveryOptions) {
        super(listenerHolder);
        this.d = zzbdVar;
        this.a = str;
        this.b = listenerHolder2;
        this.c = discoveryOptions;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.api.internal.RegisterListenerMethod
    public final /* synthetic */ void a(zzx zzxVar, TaskCompletionSource taskCompletionSource) {
        zzxVar.zza(new ax(this.d, taskCompletionSource), this.a, this.b, this.c);
    }
}
