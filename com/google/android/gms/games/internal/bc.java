package com.google.android.gms.games.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.internal.zze;
import com.google.android.gms.games.multiplayer.realtime.Room;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class bc extends zze.be<T> {
    private final /* synthetic */ zze.aa a;
    private final /* synthetic */ DataHolder b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bc(zze.aa aaVar, DataHolder dataHolder) {
        super(null);
        this.a = aaVar;
        this.b = dataHolder;
    }

    @Override // com.google.android.gms.common.api.internal.ListenerHolder.Notifier
    public final void notifyListener(T t) {
        Room b;
        zze.aa aaVar = this.a;
        int statusCode = this.b.getStatusCode();
        b = zze.b(this.b);
        aaVar.a(t, statusCode, b);
    }
}
