package com.google.android.gms.games;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.ApiExceptionUtil;
import com.google.android.gms.games.SnapshotsClient;
import com.google.android.gms.games.internal.zzbl;
import com.google.android.gms.games.snapshot.Snapshots;

/* loaded from: classes.dex */
final class ay implements zzbl<Snapshots.OpenSnapshotResult> {
    @Override // com.google.android.gms.games.internal.zzbl
    public final /* synthetic */ ApiException zza(Status status, Snapshots.OpenSnapshotResult openSnapshotResult) {
        Snapshots.OpenSnapshotResult openSnapshotResult2 = openSnapshotResult;
        return (status.getStatusCode() != 26572 || openSnapshotResult2.getSnapshot() == null || openSnapshotResult2.getSnapshot().getMetadata() == null) ? ApiExceptionUtil.fromStatus(status) : new SnapshotsClient.SnapshotContentUnavailableApiException(status, openSnapshotResult2.getSnapshot().getMetadata().mo28freeze());
    }
}
