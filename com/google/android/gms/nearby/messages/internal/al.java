package com.google.android.gms.nearby.messages.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.nearby.Nearby;

/* loaded from: classes.dex */
abstract class al extends BaseImplementation.ApiMethodImpl<Status, zzah> {
    private final ListenerHolder<BaseImplementation.ResultHolder<Status>> b;

    public al(GoogleApiClient googleApiClient) {
        super(Nearby.MESSAGES_API, googleApiClient);
        this.b = googleApiClient.registerListener(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final ListenerHolder<BaseImplementation.ResultHolder<Status>> a() {
        return this.b;
    }

    @Override // com.google.android.gms.common.api.internal.BasePendingResult
    /* renamed from: createFailedResult */
    public /* synthetic */ Result mo8createFailedResult(Status status) {
        return status;
    }
}
