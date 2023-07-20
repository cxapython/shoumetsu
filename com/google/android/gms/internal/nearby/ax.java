package com.google.android.gms.internal.nearby;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes.dex */
final class ax<T> implements BaseImplementation.ResultHolder<T> {
    private final TaskCompletionSource<Void> a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ax(zzbd zzbdVar, TaskCompletionSource<Void> taskCompletionSource) {
        this.a = taskCompletionSource;
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder
    public final void setFailedResult(Status status) {
        this.a.setException(new ApiException(status));
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder
    public final void setResult(T t) {
        this.a.setResult(null);
    }
}
