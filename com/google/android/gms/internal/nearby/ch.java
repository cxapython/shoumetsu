package com.google.android.gms.internal.nearby;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class ch extends zzha<BaseImplementation.ResultHolder<Status>> {
    private final /* synthetic */ Status a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ch(zzgy zzgyVar, Status status) {
        this.a = status;
    }

    @Override // com.google.android.gms.common.api.internal.ListenerHolder.Notifier
    public final /* synthetic */ void notifyListener(Object obj) {
        BaseImplementation.ResultHolder resultHolder = (BaseImplementation.ResultHolder) obj;
        if (this.a.isSuccess()) {
            resultHolder.setResult(this.a);
        } else {
            resultHolder.setFailedResult(this.a);
        }
    }
}
