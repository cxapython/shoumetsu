package com.google.android.gms.games;

import com.google.android.gms.games.internal.zze;
import com.google.android.gms.internal.games.zzag;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes.dex */
final class by extends zzag<Boolean> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public by(VideosClient videosClient) {
    }

    @Override // com.google.android.gms.internal.games.zzag
    protected final void a(zze zzeVar, TaskCompletionSource<Boolean> taskCompletionSource) {
        taskCompletionSource.setResult(Boolean.valueOf(zzeVar.zzce()));
    }
}
