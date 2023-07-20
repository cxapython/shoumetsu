package com.google.android.gms.games;

import com.google.android.gms.games.internal.zze;
import com.google.android.gms.internal.games.zzag;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes.dex */
final class af extends zzag<Void> {
    private final /* synthetic */ String a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(RealTimeMultiplayerClient realTimeMultiplayerClient, String str) {
        this.a = str;
    }

    @Override // com.google.android.gms.internal.games.zzag
    protected final void a(zze zzeVar, TaskCompletionSource<Void> taskCompletionSource) {
        zzeVar.zzb(this.a, 0);
        taskCompletionSource.setResult(null);
    }
}
