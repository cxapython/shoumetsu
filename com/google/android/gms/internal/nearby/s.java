package com.google.android.gms.internal.nearby;

import android.util.Log;
import com.google.android.gms.nearby.connection.Connections;
import com.google.android.gms.nearby.connection.Payload;

/* loaded from: classes.dex */
final class s extends u<Connections.MessageListener> {
    private final /* synthetic */ zzev a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s(r rVar, zzev zzevVar) {
        super();
        this.a = zzevVar;
    }

    @Override // com.google.android.gms.common.api.internal.ListenerHolder.Notifier
    public final /* synthetic */ void notifyListener(Object obj) {
        Connections.MessageListener messageListener = (Connections.MessageListener) obj;
        Payload a = zzfl.a(this.a.zzl());
        if (a == null) {
            Log.w("NearbyConnectionsClient", String.format("Failed to convert incoming ParcelablePayload %d to Payload.", Long.valueOf(this.a.zzl().getId())));
        } else if (a.getType() != 1) {
        } else {
            messageListener.onMessageReceived(this.a.zzg(), a.asBytes(), this.a.zzm());
        }
    }
}
