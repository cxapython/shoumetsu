package com.google.android.gms.internal.nearby;

import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.RegisterListenerMethod;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes.dex */
final class as extends RegisterListenerMethod<zzx, String> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public as(zzbd zzbdVar, ListenerHolder listenerHolder) {
        super(listenerHolder);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.api.internal.RegisterListenerMethod
    public final /* synthetic */ void a(zzx zzxVar, TaskCompletionSource taskCompletionSource) {
        taskCompletionSource.setResult(null);
    }
}
