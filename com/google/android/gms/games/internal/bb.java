package com.google.android.gms.games.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.internal.zze;
import com.google.android.gms.games.multiplayer.realtime.Room;
import java.util.ArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class bb extends zze.be<T> {
    private final /* synthetic */ zze.w a;
    private final /* synthetic */ DataHolder b;
    private final /* synthetic */ ArrayList c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bb(zze.w wVar, DataHolder dataHolder, ArrayList arrayList) {
        super(null);
        this.a = wVar;
        this.b = dataHolder;
        this.c = arrayList;
    }

    @Override // com.google.android.gms.common.api.internal.ListenerHolder.Notifier
    public final void notifyListener(T t) {
        Room b;
        zze.w wVar = this.a;
        b = zze.b(this.b);
        wVar.a(t, b, this.c);
    }
}
