package com.google.android.gms.nearby.messages.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class s extends TaskApiCall<zzah, Void> {
    private final /* synthetic */ u a;
    private final /* synthetic */ zzak b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(zzak zzakVar, u uVar) {
        this.b = zzakVar;
        this.a = uVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.api.internal.TaskApiCall
    public final /* synthetic */ void a(zzah zzahVar, TaskCompletionSource<Void> taskCompletionSource) {
        ListenerHolder<BaseImplementation.ResultHolder<Status>> a;
        u uVar = this.a;
        a = this.b.a((TaskCompletionSource) taskCompletionSource);
        uVar.a(zzahVar, a);
    }
}
