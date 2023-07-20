package com.google.android.gms.games;

import com.google.android.gms.games.internal.zze;
import com.google.android.gms.internal.games.zzag;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes.dex */
final class ct extends zzag<Integer> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public ct(GamesClient gamesClient) {
    }

    @Override // com.google.android.gms.internal.games.zzag
    protected final void a(zze zzeVar, TaskCompletionSource<Integer> taskCompletionSource) {
        taskCompletionSource.setResult(Integer.valueOf(zzeVar.zzbp()));
    }
}
