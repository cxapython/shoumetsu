package com.google.android.gms.internal.nearby;

import com.google.android.gms.nearby.connection.PayloadCallback;

/* loaded from: classes.dex */
final class x extends u<PayloadCallback> {
    private final /* synthetic */ zzex a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x(v vVar, zzex zzexVar) {
        super();
        this.a = zzexVar;
    }

    @Override // com.google.android.gms.common.api.internal.ListenerHolder.Notifier
    public final /* synthetic */ void notifyListener(Object obj) {
        ((PayloadCallback) obj).onPayloadTransferUpdate(this.a.zzg(), this.a.zzn());
    }
}
