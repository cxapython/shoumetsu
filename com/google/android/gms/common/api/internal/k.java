package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;
import javax.annotation.concurrent.GuardedBy;

/* loaded from: classes.dex */
final class k extends w {
    private final /* synthetic */ BaseGmsClient.ConnectionProgressReportCallbacks a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(i iVar, zabd zabdVar, BaseGmsClient.ConnectionProgressReportCallbacks connectionProgressReportCallbacks) {
        super(zabdVar);
        this.a = connectionProgressReportCallbacks;
    }

    @Override // com.google.android.gms.common.api.internal.w
    @GuardedBy("mLock")
    public final void a() {
        this.a.onReportServiceBinding(new ConnectionResult(16, null));
    }
}
