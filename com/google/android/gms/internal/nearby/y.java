package com.google.android.gms.internal.nearby;

import com.google.android.gms.nearby.connection.PayloadCallback;
import com.google.android.gms.nearby.connection.PayloadTransferUpdate;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class y extends u<PayloadCallback> {
    private final /* synthetic */ String a;
    private final /* synthetic */ PayloadTransferUpdate b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y(v vVar, String str, PayloadTransferUpdate payloadTransferUpdate) {
        super();
        this.a = str;
        this.b = payloadTransferUpdate;
    }

    @Override // com.google.android.gms.common.api.internal.ListenerHolder.Notifier
    public final /* synthetic */ void notifyListener(Object obj) {
        ((PayloadCallback) obj).onPayloadTransferUpdate(this.a, new PayloadTransferUpdate.Builder(this.b).setStatus(2).build());
    }
}
