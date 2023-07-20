package com.google.android.gms.internal.drive;

import android.os.ParcelFileDescriptor;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.GmsLogger;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.IOUtils;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.drive.DriveApi;
import com.google.android.gms.drive.DriveContents;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.ExecutionOptions;
import com.google.android.gms.drive.MetadataChangeSet;
import java.io.InputStream;
import java.io.OutputStream;

/* loaded from: classes.dex */
public final class zzbi implements DriveContents {
    private static final GmsLogger a = new GmsLogger("DriveContentsImpl", "");
    private final Contents b;
    private boolean c = false;
    private boolean d = false;
    private boolean e = false;

    public zzbi(Contents contents) {
        this.b = (Contents) Preconditions.checkNotNull(contents);
    }

    private final PendingResult<Status> a(GoogleApiClient googleApiClient, MetadataChangeSet metadataChangeSet, com.google.android.gms.drive.zzn zznVar) {
        if (zznVar == null) {
            zznVar = (com.google.android.gms.drive.zzn) new com.google.android.gms.drive.zzp().build();
        }
        if (this.b.getMode() != 268435456) {
            if (ExecutionOptions.zza(zznVar.zzm()) && !this.b.zza()) {
                throw new IllegalStateException("DriveContents must be valid for conflict detection.");
            }
            zznVar.zza(googleApiClient);
            if (this.c) {
                throw new IllegalStateException("DriveContents already closed.");
            }
            if (getDriveId() == null) {
                throw new IllegalStateException("Only DriveContents obtained through DriveFile.open can be committed.");
            }
            if (metadataChangeSet == null) {
                metadataChangeSet = MetadataChangeSet.zzav;
            }
            zzi();
            return googleApiClient.execute(new y(this, googleApiClient, metadataChangeSet, zznVar));
        }
        throw new IllegalStateException("Cannot commit contents opened with MODE_READ_ONLY");
    }

    @Override // com.google.android.gms.drive.DriveContents
    public final PendingResult<Status> commit(GoogleApiClient googleApiClient, MetadataChangeSet metadataChangeSet) {
        return a(googleApiClient, metadataChangeSet, null);
    }

    @Override // com.google.android.gms.drive.DriveContents
    public final PendingResult<Status> commit(GoogleApiClient googleApiClient, MetadataChangeSet metadataChangeSet, ExecutionOptions executionOptions) {
        return a(googleApiClient, metadataChangeSet, executionOptions == null ? null : com.google.android.gms.drive.zzn.zza(executionOptions));
    }

    @Override // com.google.android.gms.drive.DriveContents
    public final void discard(GoogleApiClient googleApiClient) {
        if (!this.c) {
            zzi();
            ((aa) googleApiClient.execute(new aa(this, googleApiClient))).setResultCallback(new z(this));
            return;
        }
        throw new IllegalStateException("DriveContents already closed.");
    }

    @Override // com.google.android.gms.drive.DriveContents
    public final DriveId getDriveId() {
        return this.b.getDriveId();
    }

    @Override // com.google.android.gms.drive.DriveContents
    public final InputStream getInputStream() {
        if (!this.c) {
            if (this.b.getMode() != 268435456) {
                throw new IllegalStateException("getInputStream() can only be used with contents opened with MODE_READ_ONLY.");
            }
            if (this.d) {
                throw new IllegalStateException("getInputStream() can only be called once per Contents instance.");
            }
            this.d = true;
            return this.b.getInputStream();
        }
        throw new IllegalStateException("Contents have been closed, cannot access the input stream.");
    }

    @Override // com.google.android.gms.drive.DriveContents
    public final int getMode() {
        return this.b.getMode();
    }

    @Override // com.google.android.gms.drive.DriveContents
    public final OutputStream getOutputStream() {
        if (!this.c) {
            if (this.b.getMode() != 536870912) {
                throw new IllegalStateException("getOutputStream() can only be used with contents opened with MODE_WRITE_ONLY.");
            }
            if (this.e) {
                throw new IllegalStateException("getOutputStream() can only be called once per Contents instance.");
            }
            this.e = true;
            return this.b.getOutputStream();
        }
        throw new IllegalStateException("Contents have been closed, cannot access the output stream.");
    }

    @Override // com.google.android.gms.drive.DriveContents
    public final ParcelFileDescriptor getParcelFileDescriptor() {
        if (!this.c) {
            return this.b.getParcelFileDescriptor();
        }
        throw new IllegalStateException("Contents have been closed, cannot access the output stream.");
    }

    @Override // com.google.android.gms.drive.DriveContents
    public final PendingResult<DriveApi.DriveContentsResult> reopenForWrite(GoogleApiClient googleApiClient) {
        if (!this.c) {
            if (this.b.getMode() != 268435456) {
                throw new IllegalStateException("reopenForWrite can only be used with DriveContents opened with MODE_READ_ONLY.");
            }
            zzi();
            return googleApiClient.enqueue(new x(this, googleApiClient));
        }
        throw new IllegalStateException("DriveContents already closed.");
    }

    @Override // com.google.android.gms.drive.DriveContents
    public final Contents zzh() {
        return this.b;
    }

    @Override // com.google.android.gms.drive.DriveContents
    public final void zzi() {
        IOUtils.closeQuietly(this.b.getParcelFileDescriptor());
        this.c = true;
    }

    @Override // com.google.android.gms.drive.DriveContents
    public final boolean zzj() {
        return this.c;
    }
}
