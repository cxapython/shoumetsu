package com.google.android.gms.common.internal.service;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;

/* loaded from: classes.dex */
final class c extends zaa {
    private final BaseImplementation.ResultHolder<Status> a;

    public c(BaseImplementation.ResultHolder<Status> resultHolder) {
        this.a = resultHolder;
    }

    @Override // com.google.android.gms.common.internal.service.zaa, com.google.android.gms.common.internal.service.zaj
    public final void zaj(int i) {
        this.a.setResult(new Status(i));
    }
}
