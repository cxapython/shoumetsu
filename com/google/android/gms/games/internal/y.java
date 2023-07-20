package com.google.android.gms.games.internal;

import com.google.android.gms.games.internal.zze;
import com.google.android.gms.games.multiplayer.realtime.Room;
import com.google.android.gms.games.multiplayer.realtime.RoomStatusUpdateListener;

/* loaded from: classes.dex */
final /* synthetic */ class y implements zze.x {
    static final zze.x a = new y();

    private y() {
    }

    @Override // com.google.android.gms.games.internal.zze.x
    public final void a(Object obj, Room room) {
        ((RoomStatusUpdateListener) obj).onRoomAutoMatching(room);
    }
}
