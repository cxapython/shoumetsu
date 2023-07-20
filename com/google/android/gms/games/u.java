package com.google.android.gms.games;

import android.content.Intent;
import com.google.android.gms.games.internal.zze;
import com.google.android.gms.internal.games.zzag;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes.dex */
final class u extends zzag<Intent> {
    private final /* synthetic */ Player a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(PlayersClient playersClient, Player player) {
        this.a = player;
    }

    @Override // com.google.android.gms.internal.games.zzag
    protected final void a(zze zzeVar, TaskCompletionSource<Intent> taskCompletionSource) {
        taskCompletionSource.setResult(zzeVar.zza(new PlayerEntity(this.a)));
    }
}
