package com.google.android.gms.games;

import com.google.android.gms.common.internal.PendingResultUtil;
import com.google.android.gms.games.SnapshotsClient;
import com.google.android.gms.games.snapshot.Snapshot;
import com.google.android.gms.games.snapshot.Snapshots;

/* loaded from: classes.dex */
final class at implements PendingResultUtil.ResultConverter<Snapshots.OpenSnapshotResult, SnapshotsClient.DataOrConflict<Snapshot>> {
    @Override // com.google.android.gms.common.internal.PendingResultUtil.ResultConverter
    public final /* synthetic */ SnapshotsClient.DataOrConflict<Snapshot> convert(Snapshots.OpenSnapshotResult openSnapshotResult) {
        Snapshots.OpenSnapshotResult openSnapshotResult2 = openSnapshotResult;
        if (openSnapshotResult2 != null) {
            Snapshot freeze = openSnapshotResult2.getSnapshot() != null ? openSnapshotResult2.getSnapshot().mo28freeze() : null;
            if (openSnapshotResult2.getStatus().getStatusCode() == 0) {
                return new SnapshotsClient.DataOrConflict<>(freeze, null);
            }
            if (openSnapshotResult2.getStatus().getStatusCode() == 4004) {
                SnapshotsClient.SnapshotConflict snapshotConflict = (freeze == null || openSnapshotResult2.getConflictId() == null || openSnapshotResult2.getConflictingSnapshot() == null || openSnapshotResult2.getResolutionSnapshotContents() == null) ? null : new SnapshotsClient.SnapshotConflict(freeze, openSnapshotResult2.getConflictId(), openSnapshotResult2.getConflictingSnapshot().mo28freeze(), openSnapshotResult2.getResolutionSnapshotContents());
                if (snapshotConflict != null) {
                    return new SnapshotsClient.DataOrConflict<>(null, snapshotConflict);
                }
            }
        }
        return null;
    }
}
