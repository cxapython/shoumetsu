package com.google.android.gms.internal.nearby;

import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes.dex */
final class am extends TaskApiCall<zzx, Void> {
    private final /* synthetic */ ay a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(zzbd zzbdVar, ay ayVar) {
        this.a = ayVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.api.internal.TaskApiCall
    public final /* synthetic */ void a(zzx zzxVar, TaskCompletionSource<Void> taskCompletionSource) {
        this.a.a(zzxVar);
        taskCompletionSource.setResult(null);
    }
}
