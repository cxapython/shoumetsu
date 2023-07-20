package com.google.android.gms.common.internal;

import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.PendingResultUtil;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
final class g implements PendingResult.StatusListener {
    private final /* synthetic */ PendingResult a;
    private final /* synthetic */ TaskCompletionSource b;
    private final /* synthetic */ PendingResultUtil.ResultConverter c;
    private final /* synthetic */ PendingResultUtil.zaa d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(PendingResult pendingResult, TaskCompletionSource taskCompletionSource, PendingResultUtil.ResultConverter resultConverter, PendingResultUtil.zaa zaaVar) {
        this.a = pendingResult;
        this.b = taskCompletionSource;
        this.c = resultConverter;
        this.d = zaaVar;
    }

    @Override // com.google.android.gms.common.api.PendingResult.StatusListener
    public final void onComplete(Status status) {
        if (!status.isSuccess()) {
            this.b.setException(this.d.zaf(status));
            return;
        }
        this.b.setResult(this.c.convert(this.a.await(0L, TimeUnit.MILLISECONDS)));
    }
}
