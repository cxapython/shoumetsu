package com.google.android.gms.internal.drive;

import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes.dex */
final class r extends TaskApiCall<zzaw, DriveId> {
    private final /* synthetic */ String a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(zzbb zzbbVar, String str) {
        this.a = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.api.internal.TaskApiCall
    public final /* synthetic */ void a(zzaw zzawVar, TaskCompletionSource<DriveId> taskCompletionSource) {
        ((zzeo) zzawVar.getService()).zza(new zzek(DriveId.zza(this.a), false), new zzhf(taskCompletionSource));
    }
}
