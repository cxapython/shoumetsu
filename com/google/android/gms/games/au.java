package com.google.android.gms.games;

import com.google.android.gms.common.internal.PendingResultUtil;
import com.google.android.gms.games.snapshot.SnapshotMetadataBuffer;
import com.google.android.gms.games.snapshot.Snapshots;

/* loaded from: classes.dex */
final class au implements PendingResultUtil.ResultConverter<Snapshots.LoadSnapshotsResult, SnapshotMetadataBuffer> {
    @Override // com.google.android.gms.common.internal.PendingResultUtil.ResultConverter
    public final /* synthetic */ SnapshotMetadataBuffer convert(Snapshots.LoadSnapshotsResult loadSnapshotsResult) {
        Snapshots.LoadSnapshotsResult loadSnapshotsResult2 = loadSnapshotsResult;
        if (loadSnapshotsResult2 == null) {
            return null;
        }
        return loadSnapshotsResult2.getSnapshots();
    }
}
