package com.google.android.gms.games;

import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.games.internal.zzbo;
import com.google.android.gms.games.internal.zze;
import com.google.android.gms.games.multiplayer.OnInvitationReceivedListener;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes.dex */
final class cy extends zzbo<OnInvitationReceivedListener> {
    private final /* synthetic */ ListenerHolder a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public cy(InvitationsClient invitationsClient, ListenerHolder listenerHolder, ListenerHolder listenerHolder2) {
        super(listenerHolder);
        this.a = listenerHolder2;
    }

    @Override // com.google.android.gms.games.internal.zzbo
    protected final void a(zze zzeVar, TaskCompletionSource<Void> taskCompletionSource) {
        zzeVar.zza(this.a);
        taskCompletionSource.setResult(null);
    }
}
