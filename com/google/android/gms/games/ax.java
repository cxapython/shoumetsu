package com.google.android.gms.games;

import com.google.android.gms.games.internal.zze;
import com.google.android.gms.games.snapshot.Snapshot;
import com.google.android.gms.internal.games.zzag;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes.dex */
final class ax extends zzag<Void> {
    private final /* synthetic */ Snapshot a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ax(SnapshotsClient snapshotsClient, Snapshot snapshot) {
        this.a = snapshot;
    }

    @Override // com.google.android.gms.internal.games.zzag
    protected final void a(zze zzeVar, TaskCompletionSource<Void> taskCompletionSource) {
        zzeVar.zza(this.a);
        taskCompletionSource.setResult(null);
    }
}
