package com.google.android.gms.nearby.messages.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.UnregisterListenerMethod;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class r extends UnregisterListenerMethod<zzah, T> {
    private final /* synthetic */ u a;
    private final /* synthetic */ zzak b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(zzak zzakVar, ListenerHolder.ListenerKey listenerKey, u uVar) {
        super(listenerKey);
        this.b = zzakVar;
        this.a = uVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.api.internal.UnregisterListenerMethod
    public final /* synthetic */ void a(zzah zzahVar, TaskCompletionSource taskCompletionSource) {
        ListenerHolder<BaseImplementation.ResultHolder<Status>> a;
        u uVar = this.a;
        a = this.b.a(taskCompletionSource);
        uVar.a(zzahVar, a);
    }
}
