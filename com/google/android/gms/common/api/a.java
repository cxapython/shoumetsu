package com.google.android.gms.common.api;

import com.google.android.gms.common.api.PendingResult;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class a implements PendingResult.StatusListener {
    private final /* synthetic */ Batch a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(Batch batch) {
        this.a = batch;
    }

    @Override // com.google.android.gms.common.api.PendingResult.StatusListener
    public final void onComplete(Status status) {
        Object obj;
        int i;
        boolean z;
        boolean z2;
        PendingResult[] pendingResultArr;
        obj = this.a.f;
        synchronized (obj) {
            if (this.a.isCanceled()) {
                return;
            }
            if (status.isCanceled()) {
                this.a.d = true;
            } else if (!status.isSuccess()) {
                this.a.c = true;
            }
            Batch.b(this.a);
            i = this.a.b;
            if (i == 0) {
                z = this.a.d;
                if (z) {
                    super/*com.google.android.gms.common.api.internal.BasePendingResult*/.cancel();
                } else {
                    z2 = this.a.c;
                    Status status2 = z2 ? new Status(13) : Status.RESULT_SUCCESS;
                    Batch batch = this.a;
                    pendingResultArr = this.a.e;
                    batch.setResult(new BatchResult(status2, pendingResultArr));
                }
            }
        }
    }
}
