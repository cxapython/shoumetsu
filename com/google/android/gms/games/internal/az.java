package com.google.android.gms.games.internal;

import com.google.android.gms.games.internal.zze;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class az extends zze.be<T> {
    private final /* synthetic */ zze.q a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public az(zze.q qVar) {
        super(null);
        this.a = qVar;
    }

    @Override // com.google.android.gms.common.api.internal.ListenerHolder.Notifier
    public final void notifyListener(T t) {
        this.a.a(t);
    }
}
