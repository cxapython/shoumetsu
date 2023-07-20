package com.google.android.gms.nearby.messages.internal;

import android.os.IBinder;

/* loaded from: classes.dex */
public final class zzac extends com.google.android.gms.internal.nearby.zza implements zzaa {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzac(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.nearby.messages.internal.ISubscribeCallback");
    }

    @Override // com.google.android.gms.nearby.messages.internal.zzaa
    public final void onExpired() {
        b(1, a());
    }
}
