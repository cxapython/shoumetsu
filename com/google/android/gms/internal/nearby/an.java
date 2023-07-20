package com.google.android.gms.internal.nearby;

import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.RegisterListenerMethod;
import com.google.android.gms.nearby.connection.AdvertisingOptions;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes.dex */
final class an extends RegisterListenerMethod<zzx, Object> {
    private final /* synthetic */ String a;
    private final /* synthetic */ String b;
    private final /* synthetic */ ListenerHolder c;
    private final /* synthetic */ AdvertisingOptions d;
    private final /* synthetic */ zzbd e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public an(zzbd zzbdVar, ListenerHolder listenerHolder, String str, String str2, ListenerHolder listenerHolder2, AdvertisingOptions advertisingOptions) {
        super(listenerHolder);
        this.e = zzbdVar;
        this.a = str;
        this.b = str2;
        this.c = listenerHolder2;
        this.d = advertisingOptions;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.api.internal.RegisterListenerMethod
    public final /* synthetic */ void a(zzx zzxVar, TaskCompletionSource taskCompletionSource) {
        zzxVar.zza(new ax(this.e, taskCompletionSource), this.a, this.b, this.c, this.d);
    }
}
