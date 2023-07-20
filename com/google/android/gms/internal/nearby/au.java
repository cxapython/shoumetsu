package com.google.android.gms.internal.nearby;

import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes.dex */
final class au extends TaskApiCall<zzx, Void> {
    private final /* synthetic */ av a;
    private final /* synthetic */ zzbd b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public au(zzbd zzbdVar, av avVar) {
        this.b = zzbdVar;
        this.a = avVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.api.internal.TaskApiCall
    public final /* synthetic */ void a(zzx zzxVar, TaskCompletionSource<Void> taskCompletionSource) {
        this.a.a(zzxVar, new ax(this.b, taskCompletionSource));
    }
}
