package com.google.android.gms.internal.games;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.snapshot.Snapshot;
import com.google.android.gms.games.snapshot.SnapshotContents;
import com.google.android.gms.games.snapshot.Snapshots;

/* loaded from: classes.dex */
final class bi implements Snapshots.OpenSnapshotResult {
    private final /* synthetic */ Status a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bi(bh bhVar, Status status) {
        this.a = status;
    }

    @Override // com.google.android.gms.games.snapshot.Snapshots.OpenSnapshotResult
    public final String getConflictId() {
        return null;
    }

    @Override // com.google.android.gms.games.snapshot.Snapshots.OpenSnapshotResult
    public final Snapshot getConflictingSnapshot() {
        return null;
    }

    @Override // com.google.android.gms.games.snapshot.Snapshots.OpenSnapshotResult
    public final SnapshotContents getResolutionSnapshotContents() {
        return null;
    }

    @Override // com.google.android.gms.games.snapshot.Snapshots.OpenSnapshotResult
    public final Snapshot getSnapshot() {
        return null;
    }

    @Override // com.google.android.gms.common.api.Result
    public final Status getStatus() {
        return this.a;
    }
}
