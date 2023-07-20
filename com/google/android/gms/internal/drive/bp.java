package com.google.android.gms.internal.drive;

import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.drive.DriveResource;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.List;

/* loaded from: classes.dex */
final class bp extends TaskApiCall<zzaw, Void> {
    private final /* synthetic */ DriveResource a;
    private final /* synthetic */ List b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bp(zzch zzchVar, DriveResource driveResource, List list) {
        this.a = driveResource;
        this.b = list;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.api.internal.TaskApiCall
    public final /* synthetic */ void a(zzaw zzawVar, TaskCompletionSource<Void> taskCompletionSource) {
        ((zzeo) zzawVar.getService()).zza(new zzgq(this.a.getDriveId(), this.b), new zzhl(taskCompletionSource));
    }
}
