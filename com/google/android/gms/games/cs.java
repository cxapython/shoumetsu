package com.google.android.gms.games;

import android.os.Bundle;
import com.google.android.gms.games.internal.zze;
import com.google.android.gms.internal.games.zzag;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes.dex */
final class cs extends zzag<Bundle> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public cs(GamesClient gamesClient) {
    }

    @Override // com.google.android.gms.internal.games.zzag
    protected final void a(zze zzeVar, TaskCompletionSource<Bundle> taskCompletionSource) {
        taskCompletionSource.setResult(zzeVar.zzat());
    }
}
