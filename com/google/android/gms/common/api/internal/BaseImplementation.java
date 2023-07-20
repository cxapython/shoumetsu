package com.google.android.gms.common.api.internal;

import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.SimpleClientAdapter;

@KeepForSdk
/* loaded from: classes.dex */
public class BaseImplementation {

    @KeepForSdk
    /* loaded from: classes.dex */
    public static abstract class ApiMethodImpl<R extends Result, A extends Api.AnyClient> extends BasePendingResult<R> implements ResultHolder<R> {
        @KeepForSdk
        private final Api.AnyClientKey<A> b;
        @KeepForSdk
        private final Api<?> c;

        /* JADX INFO: Access modifiers changed from: protected */
        @KeepForSdk
        @Deprecated
        public ApiMethodImpl(Api.AnyClientKey<A> anyClientKey, GoogleApiClient googleApiClient) {
            super((GoogleApiClient) Preconditions.checkNotNull(googleApiClient, "GoogleApiClient must not be null"));
            this.b = (Api.AnyClientKey) Preconditions.checkNotNull(anyClientKey);
            this.c = null;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @KeepForSdk
        public ApiMethodImpl(Api<?> api, GoogleApiClient googleApiClient) {
            super((GoogleApiClient) Preconditions.checkNotNull(googleApiClient, "GoogleApiClient must not be null"));
            Preconditions.checkNotNull(api, "Api must not be null");
            this.b = (Api.AnyClientKey<A>) api.getClientKey();
            this.c = api;
        }

        @KeepForSdk
        private void a(RemoteException remoteException) {
            setFailedResult(new Status(8, remoteException.getLocalizedMessage(), null));
        }

        @KeepForSdk
        protected abstract void a(A a);

        @KeepForSdk
        protected void a(R r) {
        }

        @KeepForSdk
        public final Api<?> getApi() {
            return this.c;
        }

        @KeepForSdk
        public final Api.AnyClientKey<A> getClientKey() {
            return this.b;
        }

        @KeepForSdk
        public final void run(A a) {
            if (a instanceof SimpleClientAdapter) {
                a = ((SimpleClientAdapter) a).getClient();
            }
            try {
                a((ApiMethodImpl<R, A>) a);
            } catch (DeadObjectException e) {
                a(e);
                throw e;
            } catch (RemoteException e2) {
                a(e2);
            }
        }

        @Override // com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder
        @KeepForSdk
        public final void setFailedResult(Status status) {
            Preconditions.checkArgument(!status.isSuccess(), "Failed result must not be success");
            R mo8createFailedResult = mo8createFailedResult(status);
            setResult((ApiMethodImpl<R, A>) mo8createFailedResult);
            a((ApiMethodImpl<R, A>) mo8createFailedResult);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder
        @KeepForSdk
        public /* bridge */ /* synthetic */ void setResult(Object obj) {
            super.setResult((ApiMethodImpl<R, A>) ((Result) obj));
        }
    }

    @KeepForSdk
    /* loaded from: classes.dex */
    public interface ResultHolder<R> {
        @KeepForSdk
        void setFailedResult(Status status);

        @KeepForSdk
        void setResult(R r);
    }
}
