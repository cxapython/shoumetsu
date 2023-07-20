package com.google.android.gms.games.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.internal.zze;
import com.google.android.gms.games.multiplayer.realtime.Room;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class ba extends zze.be<T> {
    private final /* synthetic */ zze.x a;
    private final /* synthetic */ DataHolder b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ba(zze.x xVar, DataHolder dataHolder) {
        super(null);
        this.a = xVar;
        this.b = dataHolder;
    }

    @Override // com.google.android.gms.common.api.internal.ListenerHolder.Notifier
    public final void notifyListener(T t) {
        Room b;
        zze.x xVar = this.a;
        b = zze.b(this.b);
        xVar.a(t, b);
    }
}
