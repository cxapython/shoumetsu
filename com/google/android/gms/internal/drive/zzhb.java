package com.google.android.gms.internal.drive;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes.dex */
public class zzhb<T> extends zzl {
    private TaskCompletionSource<T> a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzhb(TaskCompletionSource<T> taskCompletionSource) {
        this.a = taskCompletionSource;
    }

    @Override // com.google.android.gms.internal.drive.zzl, com.google.android.gms.internal.drive.zzeq
    public final void zza(Status status) {
        this.a.setException(new ApiException(status));
    }

    public final TaskCompletionSource<T> zzap() {
        return this.a;
    }
}
