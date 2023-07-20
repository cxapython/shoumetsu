package com.google.android.gms.games;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.PendingResultUtil;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.internal.zzbe;
import com.google.android.gms.games.internal.zzbl;
import com.google.android.gms.games.internal.zzbn;
import com.google.android.gms.games.snapshot.Snapshot;
import com.google.android.gms.games.snapshot.SnapshotContents;
import com.google.android.gms.games.snapshot.SnapshotMetadata;
import com.google.android.gms.games.snapshot.SnapshotMetadataBuffer;
import com.google.android.gms.games.snapshot.SnapshotMetadataChange;
import com.google.android.gms.games.snapshot.Snapshots;
import com.google.android.gms.internal.games.zzt;
import com.google.android.gms.tasks.Task;

/* loaded from: classes.dex */
public class SnapshotsClient extends zzt {
    public static final int DISPLAY_LIMIT_NONE = -1;
    public static final String EXTRA_SNAPSHOT_METADATA = "com.google.android.gms.games.SNAPSHOT_METADATA";
    public static final String EXTRA_SNAPSHOT_NEW = "com.google.android.gms.games.SNAPSHOT_NEW";
    public static final int RESOLUTION_POLICY_HIGHEST_PROGRESS = 4;
    public static final int RESOLUTION_POLICY_LAST_KNOWN_GOOD = 2;
    public static final int RESOLUTION_POLICY_LONGEST_PLAYTIME = 1;
    public static final int RESOLUTION_POLICY_MANUAL = -1;
    public static final int RESOLUTION_POLICY_MOST_RECENTLY_MODIFIED = 3;
    private static final zzbl<Snapshots.OpenSnapshotResult> b = new ay();
    private static final PendingResultUtil.ResultConverter<Snapshots.DeleteSnapshotResult, String> c = new az();
    private static final PendingResultUtil.ResultConverter<Snapshots.CommitSnapshotResult, SnapshotMetadata> d = new bb();
    private static final PendingResultUtil.ResultConverter<Snapshots.OpenSnapshotResult, Snapshots.OpenSnapshotResult> e = new bc();
    private static final zzbn f = new bd();
    private static final PendingResultUtil.ResultConverter<Snapshots.OpenSnapshotResult, DataOrConflict<Snapshot>> g = new at();
    private static final PendingResultUtil.ResultConverter<Snapshots.LoadSnapshotsResult, SnapshotMetadataBuffer> h = new au();

    /* loaded from: classes.dex */
    public static class DataOrConflict<T> {
        private final T a;
        private final SnapshotConflict b;

        /* JADX INFO: Access modifiers changed from: package-private */
        public DataOrConflict(T t, SnapshotConflict snapshotConflict) {
            this.a = t;
            this.b = snapshotConflict;
        }

        public SnapshotConflict getConflict() {
            if (isConflict()) {
                return this.b;
            }
            throw new IllegalStateException("getConflict called when there is no conflict.");
        }

        public T getData() {
            if (!isConflict()) {
                return this.a;
            }
            throw new IllegalStateException("getData called when there is a conflict.");
        }

        public boolean isConflict() {
            return this.b != null;
        }
    }

    /* loaded from: classes.dex */
    public static class SnapshotConflict {
        private final Snapshot a;
        private final String b;
        private final Snapshot c;
        private final SnapshotContents d;

        /* JADX INFO: Access modifiers changed from: package-private */
        public SnapshotConflict(Snapshot snapshot, String str, Snapshot snapshot2, SnapshotContents snapshotContents) {
            this.a = snapshot;
            this.b = str;
            this.c = snapshot2;
            this.d = snapshotContents;
        }

        public String getConflictId() {
            return this.b;
        }

        public Snapshot getConflictingSnapshot() {
            return this.c;
        }

        public SnapshotContents getResolutionSnapshotContents() {
            return this.d;
        }

        public Snapshot getSnapshot() {
            return this.a;
        }
    }

    /* loaded from: classes.dex */
    public static class SnapshotContentUnavailableApiException extends ApiException {
        protected final SnapshotMetadata b;

        /* JADX INFO: Access modifiers changed from: package-private */
        public SnapshotContentUnavailableApiException(Status status, SnapshotMetadata snapshotMetadata) {
            super(status);
            this.b = snapshotMetadata;
        }

        public SnapshotMetadata getSnapshotMetadata() {
            return this.b;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SnapshotsClient(Activity activity, Games.GamesOptions gamesOptions) {
        super(activity, gamesOptions);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SnapshotsClient(Context context, Games.GamesOptions gamesOptions) {
        super(context, gamesOptions);
    }

    private static Task<DataOrConflict<Snapshot>> a(PendingResult<Snapshots.OpenSnapshotResult> pendingResult) {
        return zzbe.zza(pendingResult, f, g, e, b);
    }

    public static SnapshotMetadata getSnapshotFromBundle(Bundle bundle) {
        return Games.Snapshots.getSnapshotFromBundle(bundle);
    }

    public Task<SnapshotMetadata> commitAndClose(Snapshot snapshot, SnapshotMetadataChange snapshotMetadataChange) {
        return zzbe.toTask(Games.Snapshots.commitAndClose(asGoogleApiClient(), snapshot, snapshotMetadataChange), d);
    }

    public Task<String> delete(SnapshotMetadata snapshotMetadata) {
        return zzbe.toTask(Games.Snapshots.delete(asGoogleApiClient(), snapshotMetadata), c);
    }

    public Task<Void> discardAndClose(Snapshot snapshot) {
        return doWrite(new ax(this, snapshot));
    }

    public Task<Integer> getMaxCoverImageSize() {
        return doRead(new av(this));
    }

    public Task<Integer> getMaxDataSize() {
        return doRead(new as(this));
    }

    public Task<Intent> getSelectSnapshotIntent(String str, boolean z, boolean z2, int i) {
        return doRead(new aw(this, str, z, z2, i));
    }

    public Task<AnnotatedData<SnapshotMetadataBuffer>> load(boolean z) {
        return zzbe.zzb(Games.Snapshots.load(asGoogleApiClient(), z), h);
    }

    public Task<DataOrConflict<Snapshot>> open(SnapshotMetadata snapshotMetadata) {
        return a(Games.Snapshots.open(asGoogleApiClient(), snapshotMetadata));
    }

    public Task<DataOrConflict<Snapshot>> open(SnapshotMetadata snapshotMetadata, int i) {
        return a(Games.Snapshots.open(asGoogleApiClient(), snapshotMetadata, i));
    }

    public Task<DataOrConflict<Snapshot>> open(String str, boolean z) {
        return a(Games.Snapshots.open(asGoogleApiClient(), str, z));
    }

    public Task<DataOrConflict<Snapshot>> open(String str, boolean z, int i) {
        return a(Games.Snapshots.open(asGoogleApiClient(), str, z, i));
    }

    public Task<DataOrConflict<Snapshot>> resolveConflict(String str, Snapshot snapshot) {
        return a(Games.Snapshots.resolveConflict(asGoogleApiClient(), str, snapshot));
    }

    public Task<DataOrConflict<Snapshot>> resolveConflict(String str, String str2, SnapshotMetadataChange snapshotMetadataChange, SnapshotContents snapshotContents) {
        return a(Games.Snapshots.resolveConflict(asGoogleApiClient(), str, str2, snapshotMetadataChange, snapshotContents));
    }
}
