package com.google.android.gms.internal.nearby;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.nearby.connection.Connections;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class ac extends zzed {
    private final BaseImplementation.ResultHolder<Connections.StartAdvertisingResult> a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(BaseImplementation.ResultHolder<Connections.StartAdvertisingResult> resultHolder) {
        this.a = (BaseImplementation.ResultHolder) Preconditions.checkNotNull(resultHolder);
    }

    @Override // com.google.android.gms.internal.nearby.zzec
    public final void zza(zzez zzezVar) {
        Status b;
        b = zzx.b(zzezVar.getStatusCode());
        if (b.isSuccess()) {
            this.a.setResult(new ab(b, zzezVar.getLocalEndpointName()));
        } else {
            this.a.setFailedResult(b);
        }
    }
}
