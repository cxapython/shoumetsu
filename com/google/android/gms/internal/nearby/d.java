package com.google.android.gms.internal.nearby;

import com.google.android.gms.nearby.connection.ConnectionLifecycleCallback;

/* loaded from: classes.dex */
final class d extends u<ConnectionLifecycleCallback> {
    private final /* synthetic */ zzef a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(cp cpVar, zzef zzefVar) {
        super();
        this.a = zzefVar;
    }

    @Override // com.google.android.gms.common.api.internal.ListenerHolder.Notifier
    public final /* synthetic */ void notifyListener(Object obj) {
        this.a.zzg();
        new com.google.android.gms.nearby.connection.zze(this.a.getQuality());
    }
}
