package com.google.android.gms.games;

import com.google.android.gms.games.internal.zze;
import com.google.android.gms.internal.games.zzag;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes.dex */
final class t extends zzag<Player> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public t(PlayersClient playersClient) {
    }

    @Override // com.google.android.gms.internal.games.zzag
    protected final void a(zze zzeVar, TaskCompletionSource<Player> taskCompletionSource) {
        taskCompletionSource.setResult(zzeVar.zzaw());
    }
}
