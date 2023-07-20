package com.google.android.gms.common.internal;

import com.google.android.gms.common.api.Response;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.internal.PendingResultUtil;

/* loaded from: classes.dex */
final class h implements PendingResultUtil.ResultConverter<R, T> {
    private final /* synthetic */ Response a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(Response response) {
        this.a = response;
    }

    @Override // com.google.android.gms.common.internal.PendingResultUtil.ResultConverter
    public final /* synthetic */ Object convert(Result result) {
        this.a.setResult(result);
        return this.a;
    }
}
