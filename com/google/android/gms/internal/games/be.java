package com.google.android.gms.internal.games;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.snapshot.Snapshots;

/* loaded from: classes.dex */
final class be implements Snapshots.DeleteSnapshotResult {
    private final /* synthetic */ Status a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public be(bd bdVar, Status status) {
        this.a = status;
    }

    @Override // com.google.android.gms.games.snapshot.Snapshots.DeleteSnapshotResult
    public final String getSnapshotId() {
        return null;
    }

    @Override // com.google.android.gms.common.api.Result
    public final Status getStatus() {
        return this.a;
    }
}
