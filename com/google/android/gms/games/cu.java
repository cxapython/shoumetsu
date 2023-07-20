package com.google.android.gms.games;

import com.google.android.gms.games.internal.zze;
import com.google.android.gms.internal.games.zzag;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes.dex */
final class cu extends zzag<Game> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public cu(GamesMetadataClient gamesMetadataClient) {
    }

    @Override // com.google.android.gms.internal.games.zzag
    protected final void a(zze zzeVar, TaskCompletionSource<Game> taskCompletionSource) {
        taskCompletionSource.setResult(zzeVar.zzay());
    }
}
