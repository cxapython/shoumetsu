package com.google.android.gms.common.api;

import com.google.android.gms.common.api.internal.BasePendingResult;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class Batch extends BasePendingResult<BatchResult> {
    private int b;
    private boolean c;
    private boolean d;
    private final PendingResult<?>[] e;
    private final Object f;

    /* loaded from: classes.dex */
    public static final class Builder {
        private List<PendingResult<?>> a = new ArrayList();
        private GoogleApiClient b;

        public Builder(GoogleApiClient googleApiClient) {
            this.b = googleApiClient;
        }

        public final <R extends Result> BatchResultToken<R> add(PendingResult<R> pendingResult) {
            BatchResultToken<R> batchResultToken = new BatchResultToken<>(this.a.size());
            this.a.add(pendingResult);
            return batchResultToken;
        }

        public final Batch build() {
            return new Batch(this.a, this.b, null);
        }
    }

    private Batch(List<PendingResult<?>> list, GoogleApiClient googleApiClient) {
        super(googleApiClient);
        this.f = new Object();
        this.b = list.size();
        this.e = new PendingResult[this.b];
        if (list.isEmpty()) {
            setResult(new BatchResult(Status.RESULT_SUCCESS, this.e));
            return;
        }
        for (int i = 0; i < list.size(); i++) {
            PendingResult<?> pendingResult = list.get(i);
            this.e[i] = pendingResult;
            pendingResult.addStatusListener(new a(this));
        }
    }

    /* synthetic */ Batch(List list, GoogleApiClient googleApiClient, a aVar) {
        this(list, googleApiClient);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ int b(Batch batch) {
        int i = batch.b;
        batch.b = i - 1;
        return i;
    }

    @Override // com.google.android.gms.common.api.internal.BasePendingResult, com.google.android.gms.common.api.PendingResult
    public final void cancel() {
        super.cancel();
        for (PendingResult<?> pendingResult : this.e) {
            pendingResult.cancel();
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.android.gms.common.api.internal.BasePendingResult
    /* renamed from: createFailedResult */
    public final BatchResult mo8createFailedResult(Status status) {
        return new BatchResult(status, this.e);
    }
}
