package com.google.android.gms.games.multiplayer.realtime;

import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.games.multiplayer.Multiplayer;
import java.util.ArrayList;
import java.util.Arrays;

/* loaded from: classes.dex */
public abstract class RoomConfig {

    /* loaded from: classes.dex */
    public static final class Builder {
        @Deprecated
        final RoomUpdateListener a;
        @Deprecated
        RoomStatusUpdateListener b;
        @Deprecated
        RealTimeMessageReceivedListener c;
        final RoomUpdateCallback d;
        RoomStatusUpdateCallback e;
        OnRealTimeMessageReceivedListener f;
        String g;
        int h;
        ArrayList<String> i;
        Bundle j;

        private Builder(RoomUpdateCallback roomUpdateCallback) {
            this.g = null;
            this.h = -1;
            this.i = new ArrayList<>();
            this.d = (RoomUpdateCallback) Preconditions.checkNotNull(roomUpdateCallback, "Must provide a RoomUpdateCallback");
            this.a = null;
        }

        @Deprecated
        private Builder(RoomUpdateListener roomUpdateListener) {
            this.g = null;
            this.h = -1;
            this.i = new ArrayList<>();
            this.a = (RoomUpdateListener) Preconditions.checkNotNull(roomUpdateListener, "Must provide a RoomUpdateListener");
            this.d = null;
        }

        public final Builder addPlayersToInvite(ArrayList<String> arrayList) {
            Preconditions.checkNotNull(arrayList);
            this.i.addAll(arrayList);
            return this;
        }

        public final Builder addPlayersToInvite(String... strArr) {
            Preconditions.checkNotNull(strArr);
            this.i.addAll(Arrays.asList(strArr));
            return this;
        }

        public final RoomConfig build() {
            return new zzd(this);
        }

        public final Builder setAutoMatchCriteria(Bundle bundle) {
            this.j = bundle;
            return this;
        }

        public final Builder setInvitationIdToAccept(String str) {
            Preconditions.checkNotNull(str);
            this.g = str;
            return this;
        }

        @Deprecated
        public final Builder setMessageReceivedListener(RealTimeMessageReceivedListener realTimeMessageReceivedListener) {
            this.c = realTimeMessageReceivedListener;
            return this;
        }

        public final Builder setOnMessageReceivedListener(OnRealTimeMessageReceivedListener onRealTimeMessageReceivedListener) {
            this.f = onRealTimeMessageReceivedListener;
            return this;
        }

        public final Builder setRoomStatusUpdateCallback(RoomStatusUpdateCallback roomStatusUpdateCallback) {
            this.e = roomStatusUpdateCallback;
            return this;
        }

        @Deprecated
        public final Builder setRoomStatusUpdateListener(RoomStatusUpdateListener roomStatusUpdateListener) {
            this.b = roomStatusUpdateListener;
            return this;
        }

        public final Builder setVariant(int i) {
            Preconditions.checkArgument(i == -1 || i > 0, "Variant must be a positive integer or Room.ROOM_VARIANT_ANY");
            this.h = i;
            return this;
        }
    }

    public static Builder builder(RoomUpdateCallback roomUpdateCallback) {
        return new Builder(roomUpdateCallback);
    }

    @Deprecated
    public static Builder builder(RoomUpdateListener roomUpdateListener) {
        return new Builder(roomUpdateListener);
    }

    public static Bundle createAutoMatchCriteria(int i, int i2, long j) {
        Bundle bundle = new Bundle();
        bundle.putInt(Multiplayer.EXTRA_MIN_AUTOMATCH_PLAYERS, i);
        bundle.putInt(Multiplayer.EXTRA_MAX_AUTOMATCH_PLAYERS, i2);
        bundle.putLong(Multiplayer.EXTRA_EXCLUSIVE_BIT_MASK, j);
        return bundle;
    }

    public abstract Bundle getAutoMatchCriteria();

    public abstract String getInvitationId();

    public abstract String[] getInvitedPlayerIds();

    @Deprecated
    public abstract RealTimeMessageReceivedListener getMessageReceivedListener();

    public abstract OnRealTimeMessageReceivedListener getOnMessageReceivedListener();

    public abstract RoomStatusUpdateCallback getRoomStatusUpdateCallback();

    @Deprecated
    public abstract RoomStatusUpdateListener getRoomStatusUpdateListener();

    public abstract RoomUpdateCallback getRoomUpdateCallback();

    @Deprecated
    public abstract RoomUpdateListener getRoomUpdateListener();

    public abstract int getVariant();

    public abstract zzh zzdo();
}
