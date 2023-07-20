package com.google.android.gms.internal.nearby;

import android.util.Log;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.nearby.connection.Payload;
import com.google.android.gms.nearby.connection.PayloadCallback;
import com.google.android.gms.nearby.connection.PayloadTransferUpdate;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
@VisibleForTesting
/* loaded from: classes.dex */
public final class v extends zzdx {
    private final ListenerHolder<PayloadCallback> a;
    private final Map<z, PayloadTransferUpdate> b = new androidx.b.a();

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(ListenerHolder<PayloadCallback> listenerHolder) {
        this.a = (ListenerHolder) Preconditions.checkNotNull(listenerHolder);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final synchronized void a() {
        for (Map.Entry<z, PayloadTransferUpdate> entry : this.b.entrySet()) {
            this.a.notifyListener(new y(this, entry.getKey().a(), entry.getValue()));
        }
        this.b.clear();
    }

    @Override // com.google.android.gms.internal.nearby.zzdw
    public final synchronized void zza(zzev zzevVar) {
        Payload a = zzfl.a(zzevVar.zzl());
        if (a == null) {
            Log.w("NearbyConnectionsClient", String.format("Failed to convert incoming ParcelablePayload %d to Payload.", Long.valueOf(zzevVar.zzl().getId())));
            return;
        }
        this.b.put(new z(zzevVar.zzg(), zzevVar.zzl().getId()), new PayloadTransferUpdate.Builder().setPayloadId(zzevVar.zzl().getId()).build());
        this.a.notifyListener(new w(this, zzevVar, a));
    }

    @Override // com.google.android.gms.internal.nearby.zzdw
    public final synchronized void zza(zzex zzexVar) {
        if (zzexVar.zzn().getStatus() == 3) {
            this.b.put(new z(zzexVar.zzg(), zzexVar.zzn().getPayloadId()), zzexVar.zzn());
        } else {
            this.b.remove(new z(zzexVar.zzg(), zzexVar.zzn().getPayloadId()));
        }
        this.a.notifyListener(new x(this, zzexVar));
    }
}
