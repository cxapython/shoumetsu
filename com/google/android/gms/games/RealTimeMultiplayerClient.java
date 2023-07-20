package com.google.android.gms.games;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.ListenerHolders;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.multiplayer.realtime.RealTimeMultiplayer;
import com.google.android.gms.games.multiplayer.realtime.Room;
import com.google.android.gms.games.multiplayer.realtime.RoomConfig;
import com.google.android.gms.internal.games.zzt;
import com.google.android.gms.tasks.Task;
import java.util.List;

/* loaded from: classes.dex */
public class RealTimeMultiplayerClient extends zzt {

    /* loaded from: classes.dex */
    public interface ReliableMessageSentCallback extends RealTimeMultiplayer.ReliableMessageSentCallback {
        @Override // com.google.android.gms.games.multiplayer.realtime.RealTimeMultiplayer.ReliableMessageSentCallback
        void onRealTimeMessageSent(int i, int i2, String str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public RealTimeMultiplayerClient(Activity activity, Games.GamesOptions gamesOptions) {
        super(activity, gamesOptions);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public RealTimeMultiplayerClient(Context context, Games.GamesOptions gamesOptions) {
        super(context, gamesOptions);
    }

    public Task<Void> create(RoomConfig roomConfig) {
        ListenerHolder<L> registerListener = registerListener(roomConfig.zzdo(), com.google.android.gms.games.multiplayer.realtime.zzh.class.getSimpleName());
        return doRegisterEventListener(new aj(this, registerListener, registerListener, roomConfig), new ak(this, registerListener.getListenerKey()));
    }

    public Task<Void> declineInvitation(String str) {
        return doWrite(new ae(this, str));
    }

    public Task<Void> dismissInvitation(String str) {
        return doWrite(new af(this, str));
    }

    public Task<Intent> getSelectOpponentsIntent(int i, int i2) {
        return getSelectOpponentsIntent(i, i2, true);
    }

    public Task<Intent> getSelectOpponentsIntent(int i, int i2, boolean z) {
        return doRead(new ai(this, i, i2, z));
    }

    public Task<Intent> getWaitingRoomIntent(Room room, int i) {
        return doRead(new aa(this, room, i));
    }

    public Task<Void> join(RoomConfig roomConfig) {
        ListenerHolder<L> registerListener = registerListener(roomConfig.zzdo(), com.google.android.gms.games.multiplayer.realtime.zzh.class.getSimpleName());
        return doRegisterEventListener(new al(this, registerListener, registerListener, roomConfig), new am(this, registerListener.getListenerKey()));
    }

    public Task<Void> leave(RoomConfig roomConfig, String str) {
        ListenerHolder<L> registerListener = registerListener(roomConfig.zzdo(), com.google.android.gms.games.multiplayer.realtime.zzh.class.getSimpleName());
        return doRead(new ag(this, str)).continueWithTask(new aq(this, registerListener)).continueWithTask(new an(this, registerListener, str, roomConfig));
    }

    public Task<Integer> sendReliableMessage(byte[] bArr, String str, String str2, ReliableMessageSentCallback reliableMessageSentCallback) {
        return doWrite(new ar(this, reliableMessageSentCallback != null ? ListenerHolders.createListenerHolder(reliableMessageSentCallback, Looper.getMainLooper(), ReliableMessageSentCallback.class.getSimpleName()) : null, bArr, str, str2));
    }

    public Task<Void> sendUnreliableMessage(byte[] bArr, String str, String str2) {
        return doWrite(new ab(this, bArr, str, str2));
    }

    public Task<Void> sendUnreliableMessage(byte[] bArr, String str, List<String> list) {
        return doWrite(new ac(this, list, bArr, str));
    }

    public Task<Void> sendUnreliableMessageToOthers(byte[] bArr, String str) {
        return doWrite(new ad(this, bArr, str));
    }
}
