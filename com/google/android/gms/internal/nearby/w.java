package com.google.android.gms.internal.nearby;

import com.google.android.gms.nearby.connection.Payload;
import com.google.android.gms.nearby.connection.PayloadCallback;

/* loaded from: classes.dex */
final class w extends u<PayloadCallback> {
    private final /* synthetic */ zzev a;
    private final /* synthetic */ Payload b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w(v vVar, zzev zzevVar, Payload payload) {
        super();
        this.a = zzevVar;
        this.b = payload;
    }

    @Override // com.google.android.gms.common.api.internal.ListenerHolder.Notifier
    public final /* synthetic */ void notifyListener(Object obj) {
        ((PayloadCallback) obj).onPayloadReceived(this.a.zzg(), this.b);
    }
}
