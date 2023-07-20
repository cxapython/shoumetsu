package com.google.android.gms.games;

import com.google.android.gms.common.internal.PendingResultUtil;
import com.google.android.gms.games.snapshot.SnapshotMetadata;
import com.google.android.gms.games.snapshot.Snapshots;

/* loaded from: classes.dex */
final class bb implements PendingResultUtil.ResultConverter<Snapshots.CommitSnapshotResult, SnapshotMetadata> {
    @Override // com.google.android.gms.common.internal.PendingResultUtil.ResultConverter
    public final /* synthetic */ SnapshotMetadata convert(Snapshots.CommitSnapshotResult commitSnapshotResult) {
        SnapshotMetadata snapshotMetadata;
        Snapshots.CommitSnapshotResult commitSnapshotResult2 = commitSnapshotResult;
        if (commitSnapshotResult2 == null || (snapshotMetadata = commitSnapshotResult2.getSnapshotMetadata()) == null) {
            return null;
        }
        return snapshotMetadata.mo28freeze();
    }
}
