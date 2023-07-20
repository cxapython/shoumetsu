package com.google.android.gms.internal.nearby;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class aa extends zzea {
    private final BaseImplementation.ResultHolder<Status> a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(BaseImplementation.ResultHolder<Status> resultHolder) {
        this.a = (BaseImplementation.ResultHolder) Preconditions.checkNotNull(resultHolder);
    }

    @Override // com.google.android.gms.internal.nearby.zzdz
    public final void zzc(int i) {
        Status b;
        b = zzx.b(i);
        if (b.isSuccess()) {
            this.a.setResult(b);
        } else {
            this.a.setFailedResult(b);
        }
    }
}
