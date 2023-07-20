package com.google.android.gms.games;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.ListenerHolders;
import com.google.android.gms.common.internal.PendingResultUtil;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.internal.zzbe;
import com.google.android.gms.games.multiplayer.InvitationBuffer;
import com.google.android.gms.games.multiplayer.InvitationCallback;
import com.google.android.gms.games.multiplayer.Invitations;
import com.google.android.gms.internal.games.zzt;
import com.google.android.gms.tasks.Task;

/* loaded from: classes.dex */
public class InvitationsClient extends zzt {
    private static final PendingResultUtil.ResultConverter<Invitations.LoadInvitationsResult, InvitationBuffer> b = new b();

    /* JADX INFO: Access modifiers changed from: package-private */
    public InvitationsClient(Activity activity, Games.GamesOptions gamesOptions) {
        super(activity, gamesOptions);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public InvitationsClient(Context context, Games.GamesOptions gamesOptions) {
        super(context, gamesOptions);
    }

    public Task<Intent> getInvitationInboxIntent() {
        return doRead(new cx(this));
    }

    public Task<AnnotatedData<InvitationBuffer>> loadInvitations() {
        return loadInvitations(0);
    }

    public Task<AnnotatedData<InvitationBuffer>> loadInvitations(int i) {
        return zzbe.zzb(Games.Invitations.loadInvitations(asGoogleApiClient(), i), b);
    }

    public Task<Void> registerInvitationCallback(InvitationCallback invitationCallback) {
        ListenerHolder<L> registerListener = registerListener(invitationCallback, InvitationCallback.class.getSimpleName());
        return doRegisterEventListener(new cy(this, registerListener, registerListener), new cz(this, registerListener.getListenerKey()));
    }

    public Task<Boolean> unregisterInvitationCallback(InvitationCallback invitationCallback) {
        return doUnregisterEventListener(ListenerHolders.createListenerKey(invitationCallback, InvitationCallback.class.getSimpleName()));
    }
}
