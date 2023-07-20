package com.google.android.gms.games;

import android.view.View;
import com.google.android.gms.games.internal.zze;
import com.google.android.gms.internal.games.zzag;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes.dex */
final class co extends zzag<Void> {
    private final /* synthetic */ View a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public co(GamesClient gamesClient, View view) {
        this.a = view;
    }

    @Override // com.google.android.gms.internal.games.zzag
    protected final void a(zze zzeVar, TaskCompletionSource<Void> taskCompletionSource) {
        zzeVar.zza(this.a);
        taskCompletionSource.setResult(null);
    }
}
