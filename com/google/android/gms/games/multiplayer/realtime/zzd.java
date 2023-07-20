package com.google.android.gms.games.multiplayer.realtime;

import android.os.Bundle;
import com.google.android.gms.games.multiplayer.realtime.RoomConfig;

/* loaded from: classes.dex */
public final class zzd extends RoomConfig {
    @Deprecated
    private final RoomUpdateListener a;
    @Deprecated
    private final RoomStatusUpdateListener b;
    @Deprecated
    private final RealTimeMessageReceivedListener c;
    private final RoomUpdateCallback d;
    private final RoomStatusUpdateCallback e;
    private final zzg f;
    private final OnRealTimeMessageReceivedListener g;
    private final String h;
    private final int i;
    private final String[] j;
    private final Bundle k;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzd(RoomConfig.Builder builder) {
        this.a = builder.a;
        this.b = builder.b;
        this.c = builder.c;
        this.d = builder.d;
        this.e = builder.e;
        this.g = builder.f;
        RoomStatusUpdateCallback roomStatusUpdateCallback = this.e;
        if (roomStatusUpdateCallback != null) {
            this.f = new zzg(this.d, roomStatusUpdateCallback, this.g);
        } else {
            this.f = null;
        }
        this.h = builder.g;
        this.i = builder.h;
        this.k = builder.j;
        this.j = (String[]) builder.i.toArray(new String[builder.i.size()]);
        if (this.g == null && this.c == null) {
            throw new NullPointerException(String.valueOf("Must specify a message listener"));
        }
    }

    @Override // com.google.android.gms.games.multiplayer.realtime.RoomConfig
    public final Bundle getAutoMatchCriteria() {
        return this.k;
    }

    @Override // com.google.android.gms.games.multiplayer.realtime.RoomConfig
    public final String getInvitationId() {
        return this.h;
    }

    @Override // com.google.android.gms.games.multiplayer.realtime.RoomConfig
    public final String[] getInvitedPlayerIds() {
        return this.j;
    }

    @Override // com.google.android.gms.games.multiplayer.realtime.RoomConfig
    @Deprecated
    public final RealTimeMessageReceivedListener getMessageReceivedListener() {
        return this.c;
    }

    @Override // com.google.android.gms.games.multiplayer.realtime.RoomConfig
    public final OnRealTimeMessageReceivedListener getOnMessageReceivedListener() {
        return this.g;
    }

    @Override // com.google.android.gms.games.multiplayer.realtime.RoomConfig
    public final RoomStatusUpdateCallback getRoomStatusUpdateCallback() {
        return this.e;
    }

    @Override // com.google.android.gms.games.multiplayer.realtime.RoomConfig
    @Deprecated
    public final RoomStatusUpdateListener getRoomStatusUpdateListener() {
        return this.b;
    }

    @Override // com.google.android.gms.games.multiplayer.realtime.RoomConfig
    public final RoomUpdateCallback getRoomUpdateCallback() {
        return this.d;
    }

    @Override // com.google.android.gms.games.multiplayer.realtime.RoomConfig
    @Deprecated
    public final RoomUpdateListener getRoomUpdateListener() {
        return this.a;
    }

    @Override // com.google.android.gms.games.multiplayer.realtime.RoomConfig
    public final int getVariant() {
        return this.i;
    }

    @Override // com.google.android.gms.games.multiplayer.realtime.RoomConfig
    public final zzh zzdo() {
        return this.f;
    }
}
