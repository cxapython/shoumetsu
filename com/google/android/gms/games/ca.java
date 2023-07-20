package com.google.android.gms.games;

import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.games.internal.zzbp;
import com.google.android.gms.games.internal.zze;
import com.google.android.gms.games.video.Videos;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes.dex */
final class ca extends zzbp<Videos.CaptureOverlayStateListener> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public ca(VideosClient videosClient, ListenerHolder.ListenerKey listenerKey) {
        super(listenerKey);
    }

    @Override // com.google.android.gms.games.internal.zzbp
    protected final void a(zze zzeVar, TaskCompletionSource<Boolean> taskCompletionSource) {
        zzeVar.zzcg();
        taskCompletionSource.setResult(true);
    }
}
