package com.google.android.gms.internal.drive;

import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.drive.DriveResource;
import com.google.android.gms.drive.Metadata;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes.dex */
final class bm extends TaskApiCall<zzaw, Metadata> {
    private final /* synthetic */ DriveResource a;
    private final /* synthetic */ boolean b = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bm(zzch zzchVar, DriveResource driveResource, boolean z) {
        this.a = driveResource;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.api.internal.TaskApiCall
    public final /* synthetic */ void a(zzaw zzawVar, TaskCompletionSource<Metadata> taskCompletionSource) {
        ((zzeo) zzawVar.getService()).zza(new zzek(this.a.getDriveId(), this.b), new zzhj(taskCompletionSource));
    }
}
