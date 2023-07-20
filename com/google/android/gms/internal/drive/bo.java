package com.google.android.gms.internal.drive;

import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.drive.DriveResource;
import com.google.android.gms.drive.MetadataBuffer;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes.dex */
final class bo extends TaskApiCall<zzaw, MetadataBuffer> {
    private final /* synthetic */ DriveResource a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bo(zzch zzchVar, DriveResource driveResource) {
        this.a = driveResource;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.api.internal.TaskApiCall
    public final /* synthetic */ void a(zzaw zzawVar, TaskCompletionSource<MetadataBuffer> taskCompletionSource) {
        ((zzeo) zzawVar.getService()).zza(new zzex(this.a.getDriveId()), new zzhi(taskCompletionSource));
    }
}
