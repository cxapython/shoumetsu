package com.google.android.gms.games;

import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.games.internal.zzbp;
import com.google.android.gms.games.internal.zze;
import com.google.android.gms.games.multiplayer.OnInvitationReceivedListener;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes.dex */
final class cz extends zzbp<OnInvitationReceivedListener> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public cz(InvitationsClient invitationsClient, ListenerHolder.ListenerKey listenerKey) {
        super(listenerKey);
    }

    @Override // com.google.android.gms.games.internal.zzbp
    protected final void a(zze zzeVar, TaskCompletionSource<Boolean> taskCompletionSource) {
        zzeVar.zzbf();
        taskCompletionSource.setResult(true);
    }
}
