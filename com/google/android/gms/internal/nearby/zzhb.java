package com.google.android.gms.internal.nearby;

import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.nearby.messages.StatusCallback;
import com.google.android.gms.nearby.messages.internal.zzy;

/* loaded from: classes.dex */
public final class zzhb extends zzy {
    private final ListenerHolder<StatusCallback> a;

    public zzhb(ListenerHolder<StatusCallback> listenerHolder) {
        this.a = listenerHolder;
    }

    @Override // com.google.android.gms.nearby.messages.internal.zzx
    public final void onPermissionChanged(boolean z) {
        this.a.notifyListener(new cj(this, z));
    }
}
