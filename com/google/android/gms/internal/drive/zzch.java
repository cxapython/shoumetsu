package com.google.android.gms.internal.drive;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.android.gms.drive.Drive;
import com.google.android.gms.drive.DriveContents;
import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.drive.DriveFolder;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.DriveResource;
import com.google.android.gms.drive.DriveResourceClient;
import com.google.android.gms.drive.ExecutionOptions;
import com.google.android.gms.drive.Metadata;
import com.google.android.gms.drive.MetadataBuffer;
import com.google.android.gms.drive.MetadataChangeSet;
import com.google.android.gms.drive.events.ListenerToken;
import com.google.android.gms.drive.events.OnChangeListener;
import com.google.android.gms.drive.events.OpenFileCallback;
import com.google.android.gms.drive.query.Query;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
public final class zzch extends DriveResourceClient {
    private static final AtomicInteger b = new AtomicInteger();

    public zzch(Activity activity, Drive.zza zzaVar) {
        super(activity, zzaVar);
    }

    public zzch(Context context, Drive.zza zzaVar) {
        super(context, zzaVar);
    }

    public static final /* synthetic */ ListenerToken a(ListenerHolder listenerHolder, Task task) {
        if (task.isSuccessful()) {
            return new zzg(listenerHolder.getListenerKey());
        }
        throw task.getException();
    }

    public static final /* synthetic */ ListenerToken a(zzg zzgVar, Task task) {
        if (task.isSuccessful()) {
            return zzgVar;
        }
        throw task.getException();
    }

    private static void a(int i) {
        if (i == 268435456 || i == 536870912 || i == 805306368) {
            return;
        }
        throw new IllegalArgumentException("Invalid openMode provided");
    }

    @Override // com.google.android.gms.drive.DriveResourceClient
    public final Task<ListenerToken> addChangeListener(DriveResource driveResource, OnChangeListener onChangeListener) {
        Preconditions.checkNotNull(driveResource.getDriveId());
        Preconditions.checkNotNull(onChangeListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        bs bsVar = new bs(this, onChangeListener, driveResource.getDriveId());
        int incrementAndGet = b.incrementAndGet();
        StringBuilder sb = new StringBuilder(27);
        sb.append("OnChangeListener");
        sb.append(incrementAndGet);
        ListenerHolder<L> registerListener = registerListener(bsVar, sb.toString());
        return doRegisterEventListener(new ay(this, registerListener, driveResource, bsVar), new az(this, registerListener.getListenerKey(), driveResource, bsVar)).continueWith(new Continuation(registerListener) { // from class: com.google.android.gms.internal.drive.ar
            private final ListenerHolder a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.a = registerListener;
            }

            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task) {
                return zzch.a(this.a, task);
            }
        });
    }

    @Override // com.google.android.gms.drive.DriveResourceClient
    public final Task<Void> addChangeSubscription(DriveResource driveResource) {
        Preconditions.checkNotNull(driveResource.getDriveId());
        Preconditions.checkArgument(com.google.android.gms.drive.events.zzj.zza(1, driveResource.getDriveId()));
        return doWrite(new ba(this, driveResource));
    }

    @Override // com.google.android.gms.drive.DriveResourceClient
    public final Task<Boolean> cancelOpenFileCallback(ListenerToken listenerToken) {
        if (listenerToken instanceof zzg) {
            return doUnregisterEventListener(((zzg) listenerToken).zzac());
        }
        throw new IllegalArgumentException("Unrecognized ListenerToken");
    }

    @Override // com.google.android.gms.drive.DriveResourceClient
    public final Task<Void> commitContents(DriveContents driveContents, MetadataChangeSet metadataChangeSet) {
        return commitContents(driveContents, metadataChangeSet, (com.google.android.gms.drive.zzn) new com.google.android.gms.drive.zzp().build());
    }

    @Override // com.google.android.gms.drive.DriveResourceClient
    public final Task<Void> commitContents(DriveContents driveContents, MetadataChangeSet metadataChangeSet, ExecutionOptions executionOptions) {
        Preconditions.checkNotNull(executionOptions, "Execution options cannot be null.");
        boolean z = true;
        Preconditions.checkArgument(!driveContents.zzj(), "DriveContents is already closed");
        if (driveContents.getMode() == 268435456) {
            z = false;
        }
        Preconditions.checkArgument(z, "Cannot commit contents opened in MODE_READ_ONLY.");
        Preconditions.checkNotNull(driveContents.getDriveId(), "Only DriveContents obtained through DriveFile.open can be committed.");
        com.google.android.gms.drive.zzn zza = com.google.android.gms.drive.zzn.zza(executionOptions);
        if (!ExecutionOptions.zza(zza.zzm()) || driveContents.zzh().zza()) {
            if (metadataChangeSet == null) {
                metadataChangeSet = MetadataChangeSet.zzav;
            }
            return doWrite(new bh(this, zza, driveContents, metadataChangeSet));
        }
        throw new IllegalStateException("DriveContents must be valid for conflict detection.");
    }

    @Override // com.google.android.gms.drive.DriveResourceClient
    public final Task<DriveContents> createContents() {
        Preconditions.checkArgument(true, "Contents can only be created in MODE_WRITE_ONLY or MODE_READ_WRITE.");
        return doWrite(new bf(this, DriveFile.MODE_WRITE_ONLY));
    }

    @Override // com.google.android.gms.drive.DriveResourceClient
    public final Task<DriveFile> createFile(DriveFolder driveFolder, MetadataChangeSet metadataChangeSet, DriveContents driveContents) {
        return createFile(driveFolder, metadataChangeSet, driveContents, new ExecutionOptions.Builder().build());
    }

    @Override // com.google.android.gms.drive.DriveResourceClient
    public final Task<DriveFile> createFile(DriveFolder driveFolder, MetadataChangeSet metadataChangeSet, DriveContents driveContents, ExecutionOptions executionOptions) {
        zzbs.a(metadataChangeSet);
        return doWrite(new br(driveFolder, metadataChangeSet, driveContents, executionOptions, null));
    }

    @Override // com.google.android.gms.drive.DriveResourceClient
    public final Task<DriveFolder> createFolder(DriveFolder driveFolder, MetadataChangeSet metadataChangeSet) {
        Preconditions.checkNotNull(metadataChangeSet, "MetadataChangeSet must be provided.");
        if (metadataChangeSet.getMimeType() == null || metadataChangeSet.getMimeType().equals(DriveFolder.MIME_TYPE)) {
            return doWrite(new bl(this, metadataChangeSet, driveFolder));
        }
        throw new IllegalArgumentException("The mimetype must be of type application/vnd.google-apps.folder");
    }

    @Override // com.google.android.gms.drive.DriveResourceClient
    public final Task<Void> delete(DriveResource driveResource) {
        Preconditions.checkNotNull(driveResource.getDriveId());
        return doWrite(new au(this, driveResource));
    }

    @Override // com.google.android.gms.drive.DriveResourceClient
    public final Task<Void> discardContents(DriveContents driveContents) {
        Preconditions.checkArgument(!driveContents.zzj(), "DriveContents is already closed");
        driveContents.zzi();
        return doWrite(new bk(this, driveContents));
    }

    @Override // com.google.android.gms.drive.DriveResourceClient
    public final Task<DriveFolder> getAppFolder() {
        return doRead(new ax(this));
    }

    @Override // com.google.android.gms.drive.DriveResourceClient
    public final Task<Metadata> getMetadata(DriveResource driveResource) {
        Preconditions.checkNotNull(driveResource, "DriveResource must not be null");
        Preconditions.checkNotNull(driveResource.getDriveId(), "Resource's DriveId must not be null");
        return doRead(new bm(this, driveResource, false));
    }

    @Override // com.google.android.gms.drive.DriveResourceClient
    public final Task<DriveFolder> getRootFolder() {
        return doRead(new at(this));
    }

    @Override // com.google.android.gms.drive.DriveResourceClient
    public final Task<MetadataBuffer> listChildren(DriveFolder driveFolder) {
        Preconditions.checkNotNull(driveFolder, "folder cannot be null.");
        return query(zzbs.a((Query) null, driveFolder.getDriveId()));
    }

    @Override // com.google.android.gms.drive.DriveResourceClient
    public final Task<MetadataBuffer> listParents(DriveResource driveResource) {
        Preconditions.checkNotNull(driveResource.getDriveId());
        return doRead(new bo(this, driveResource));
    }

    @Override // com.google.android.gms.drive.DriveResourceClient
    public final Task<DriveContents> openFile(DriveFile driveFile, int i) {
        a(i);
        return doRead(new bc(this, driveFile, i));
    }

    @Override // com.google.android.gms.drive.DriveResourceClient
    public final Task<ListenerToken> openFile(DriveFile driveFile, int i, OpenFileCallback openFileCallback) {
        a(i);
        int incrementAndGet = b.incrementAndGet();
        StringBuilder sb = new StringBuilder(27);
        sb.append("OpenFileCallback");
        sb.append(incrementAndGet);
        ListenerHolder<L> registerListener = registerListener(openFileCallback, sb.toString());
        ListenerHolder.ListenerKey listenerKey = registerListener.getListenerKey();
        zzg zzgVar = new zzg(listenerKey);
        return doRegisterEventListener(new bd(this, registerListener, driveFile, i, zzgVar, registerListener), new be(this, listenerKey, zzgVar)).continueWith(new Continuation(zzgVar) { // from class: com.google.android.gms.internal.drive.as
            private final zzg a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.a = zzgVar;
            }

            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task) {
                return zzch.a(this.a, task);
            }
        });
    }

    @Override // com.google.android.gms.drive.DriveResourceClient
    public final Task<MetadataBuffer> query(Query query) {
        Preconditions.checkNotNull(query, "query cannot be null.");
        return doRead(new bi(this, query));
    }

    @Override // com.google.android.gms.drive.DriveResourceClient
    public final Task<MetadataBuffer> queryChildren(DriveFolder driveFolder, Query query) {
        Preconditions.checkNotNull(driveFolder, "folder cannot be null.");
        Preconditions.checkNotNull(query, "query cannot be null.");
        return query(zzbs.a(query, driveFolder.getDriveId()));
    }

    @Override // com.google.android.gms.drive.DriveResourceClient
    public final Task<Boolean> removeChangeListener(ListenerToken listenerToken) {
        Preconditions.checkNotNull(listenerToken, "Token is required to unregister listener.");
        if (listenerToken instanceof zzg) {
            return doUnregisterEventListener(((zzg) listenerToken).zzac());
        }
        throw new IllegalStateException("Could not recover key from ListenerToken");
    }

    @Override // com.google.android.gms.drive.DriveResourceClient
    public final Task<Void> removeChangeSubscription(DriveResource driveResource) {
        Preconditions.checkNotNull(driveResource.getDriveId());
        Preconditions.checkArgument(com.google.android.gms.drive.events.zzj.zza(1, driveResource.getDriveId()));
        return doWrite(new bb(this, driveResource));
    }

    @Override // com.google.android.gms.drive.DriveResourceClient
    public final Task<DriveContents> reopenContentsForWrite(DriveContents driveContents) {
        boolean z = true;
        Preconditions.checkArgument(!driveContents.zzj(), "DriveContents is already closed");
        if (driveContents.getMode() != 268435456) {
            z = false;
        }
        Preconditions.checkArgument(z, "This method can only be called on contents that are currently opened in MODE_READ_ONLY.");
        driveContents.zzi();
        return doRead(new bg(this, driveContents));
    }

    @Override // com.google.android.gms.drive.DriveResourceClient
    public final Task<Void> setParents(DriveResource driveResource, Set<DriveId> set) {
        Preconditions.checkNotNull(driveResource.getDriveId());
        Preconditions.checkNotNull(set);
        return doWrite(new bp(this, driveResource, new ArrayList(set)));
    }

    @Override // com.google.android.gms.drive.DriveResourceClient
    public final Task<Void> trash(DriveResource driveResource) {
        Preconditions.checkNotNull(driveResource.getDriveId());
        return doWrite(new av(this, driveResource));
    }

    @Override // com.google.android.gms.drive.DriveResourceClient
    public final Task<Void> untrash(DriveResource driveResource) {
        Preconditions.checkNotNull(driveResource.getDriveId());
        return doWrite(new aw(this, driveResource));
    }

    @Override // com.google.android.gms.drive.DriveResourceClient
    public final Task<Metadata> updateMetadata(DriveResource driveResource, MetadataChangeSet metadataChangeSet) {
        Preconditions.checkNotNull(driveResource.getDriveId());
        Preconditions.checkNotNull(metadataChangeSet);
        return doWrite(new bn(this, metadataChangeSet, driveResource));
    }
}
