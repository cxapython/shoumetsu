package com.google.android.gms.games;

import com.google.android.gms.games.internal.zze;
import com.google.android.gms.internal.games.zzag;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes.dex */
final class cn extends zzag<Void> {
    private final /* synthetic */ int a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cn(GamesClient gamesClient, int i) {
        this.a = i;
    }

    @Override // com.google.android.gms.internal.games.zzag
    protected final void a(zze zzeVar, TaskCompletionSource<Void> taskCompletionSource) {
        zzeVar.zzk(this.a);
        taskCompletionSource.setResult(null);
    }
}
