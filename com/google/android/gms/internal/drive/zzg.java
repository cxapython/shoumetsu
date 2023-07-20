package com.google.android.gms.internal.drive;

import android.os.RemoteException;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.internal.ICancelToken;
import com.google.android.gms.drive.events.ListenerToken;

/* loaded from: classes.dex */
public final class zzg implements ListenerToken {
    private final ListenerHolder.ListenerKey a;
    private ICancelToken b = null;

    public zzg(ListenerHolder.ListenerKey listenerKey) {
        this.a = listenerKey;
    }

    public final boolean cancel() {
        ICancelToken iCancelToken = this.b;
        if (iCancelToken != null) {
            try {
                iCancelToken.cancel();
                return true;
            } catch (RemoteException unused) {
                return false;
            }
        }
        return false;
    }

    public final void setCancelToken(ICancelToken iCancelToken) {
        this.b = iCancelToken;
    }

    public final ListenerHolder.ListenerKey zzac() {
        return this.a;
    }
}
