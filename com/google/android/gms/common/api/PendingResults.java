package com.google.android.gms.common.api;

import android.os.Looper;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.internal.BasePendingResult;
import com.google.android.gms.common.api.internal.OptionalPendingResultImpl;
import com.google.android.gms.common.api.internal.StatusPendingResult;
import com.google.android.gms.common.internal.Preconditions;

@KeepForSdk
/* loaded from: classes.dex */
public final class PendingResults {

    /* loaded from: classes.dex */
    private static final class a<R extends Result> extends BasePendingResult<R> {
        private final R b;

        public a(R r) {
            super(Looper.getMainLooper());
            this.b = r;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.common.api.internal.BasePendingResult
        /* renamed from: createFailedResult */
        public final R mo8createFailedResult(Status status) {
            if (status.getStatusCode() == this.b.getStatus().getStatusCode()) {
                return this.b;
            }
            throw new UnsupportedOperationException("Creating failed results is not supported");
        }
    }

    /* loaded from: classes.dex */
    private static final class b<R extends Result> extends BasePendingResult<R> {
        private final R b;

        public b(GoogleApiClient googleApiClient, R r) {
            super(googleApiClient);
            this.b = r;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.common.api.internal.BasePendingResult
        /* renamed from: createFailedResult */
        public final R mo8createFailedResult(Status status) {
            return this.b;
        }
    }

    /* loaded from: classes.dex */
    private static final class c<R extends Result> extends BasePendingResult<R> {
        public c(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.common.api.internal.BasePendingResult
        /* renamed from: createFailedResult */
        public final R mo8createFailedResult(Status status) {
            throw new UnsupportedOperationException("Creating failed results is not supported");
        }
    }

    @KeepForSdk
    private PendingResults() {
    }

    public static PendingResult<Status> canceledPendingResult() {
        StatusPendingResult statusPendingResult = new StatusPendingResult(Looper.getMainLooper());
        statusPendingResult.cancel();
        return statusPendingResult;
    }

    public static <R extends Result> PendingResult<R> canceledPendingResult(R r) {
        Preconditions.checkNotNull(r, "Result must not be null");
        Preconditions.checkArgument(r.getStatus().getStatusCode() == 16, "Status code must be CommonStatusCodes.CANCELED");
        a aVar = new a(r);
        aVar.cancel();
        return aVar;
    }

    @KeepForSdk
    public static <R extends Result> PendingResult<R> immediateFailedResult(R r, GoogleApiClient googleApiClient) {
        Preconditions.checkNotNull(r, "Result must not be null");
        Preconditions.checkArgument(!r.getStatus().isSuccess(), "Status code must not be SUCCESS");
        b bVar = new b(googleApiClient, r);
        bVar.setResult(r);
        return bVar;
    }

    @KeepForSdk
    public static <R extends Result> OptionalPendingResult<R> immediatePendingResult(R r) {
        Preconditions.checkNotNull(r, "Result must not be null");
        c cVar = new c(null);
        cVar.setResult(r);
        return new OptionalPendingResultImpl(cVar);
    }

    @KeepForSdk
    public static <R extends Result> OptionalPendingResult<R> immediatePendingResult(R r, GoogleApiClient googleApiClient) {
        Preconditions.checkNotNull(r, "Result must not be null");
        c cVar = new c(googleApiClient);
        cVar.setResult(r);
        return new OptionalPendingResultImpl(cVar);
    }

    @KeepForSdk
    public static PendingResult<Status> immediatePendingResult(Status status) {
        Preconditions.checkNotNull(status, "Result must not be null");
        StatusPendingResult statusPendingResult = new StatusPendingResult(Looper.getMainLooper());
        statusPendingResult.setResult(status);
        return statusPendingResult;
    }

    @KeepForSdk
    public static PendingResult<Status> immediatePendingResult(Status status, GoogleApiClient googleApiClient) {
        Preconditions.checkNotNull(status, "Result must not be null");
        StatusPendingResult statusPendingResult = new StatusPendingResult(googleApiClient);
        statusPendingResult.setResult(status);
        return statusPendingResult;
    }
}
