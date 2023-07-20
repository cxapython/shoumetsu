package com.google.android.gms.games.internal;

import com.google.android.gms.games.internal.zze;
import com.google.android.gms.games.multiplayer.realtime.Room;
import com.google.android.gms.games.multiplayer.realtime.RoomStatusUpdateListener;
import java.util.ArrayList;

/* loaded from: classes.dex */
final /* synthetic */ class ac implements zze.w {
    static final zze.w a = new ac();

    private ac() {
    }

    @Override // com.google.android.gms.games.internal.zze.w
    public final void a(Object obj, Room room, ArrayList arrayList) {
        ((RoomStatusUpdateListener) obj).onPeersDisconnected(room, arrayList);
    }
}
