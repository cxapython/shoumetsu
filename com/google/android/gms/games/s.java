package com.google.android.gms.games;

import com.google.android.gms.games.internal.zze;
import com.google.android.gms.internal.games.zzag;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes.dex */
final class s extends zzag<String> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public s(PlayersClient playersClient) {
    }

    @Override // com.google.android.gms.internal.games.zzag
    protected final void a(zze zzeVar, TaskCompletionSource<String> taskCompletionSource) {
        taskCompletionSource.setResult(zzeVar.zza(true));
    }
}
