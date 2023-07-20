package com.google.android.gms.games.internal;

import com.google.android.gms.games.internal.zze;
import com.google.android.gms.games.multiplayer.realtime.Room;
import com.google.android.gms.games.multiplayer.realtime.RoomUpdateListener;

/* loaded from: classes.dex */
final /* synthetic */ class w implements zze.aa {
    static final zze.aa a = new w();

    private w() {
    }

    @Override // com.google.android.gms.games.internal.zze.aa
    public final void a(Object obj, int i, Room room) {
        ((RoomUpdateListener) obj).onRoomConnected(i, room);
    }
}
