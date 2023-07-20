package com.google.android.gms.games.internal;

import com.google.android.gms.games.internal.zze;
import com.google.android.gms.games.multiplayer.realtime.Room;
import com.google.android.gms.games.multiplayer.realtime.RoomStatusUpdateListener;

/* loaded from: classes.dex */
final /* synthetic */ class x implements zze.x {
    static final zze.x a = new x();

    private x() {
    }

    @Override // com.google.android.gms.games.internal.zze.x
    public final void a(Object obj, Room room) {
        ((RoomStatusUpdateListener) obj).onRoomConnecting(room);
    }
}
