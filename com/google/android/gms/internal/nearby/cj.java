package com.google.android.gms.internal.nearby;

import com.google.android.gms.nearby.messages.StatusCallback;

/* loaded from: classes.dex */
final class cj extends zzha<StatusCallback> {
    private final /* synthetic */ boolean a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cj(zzhb zzhbVar, boolean z) {
        this.a = z;
    }

    @Override // com.google.android.gms.common.api.internal.ListenerHolder.Notifier
    public final /* synthetic */ void notifyListener(Object obj) {
        ((StatusCallback) obj).onPermissionChanged(this.a);
    }
}
