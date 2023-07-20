package com.google.android.gms.internal.drive;

import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.drive.TransferPreferences;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes.dex */
final class t extends TaskApiCall<zzaw, Void> {
    private final /* synthetic */ TransferPreferences a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(zzbb zzbbVar, TransferPreferences transferPreferences) {
        this.a = transferPreferences;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.api.internal.TaskApiCall
    public final /* synthetic */ void a(zzaw zzawVar, TaskCompletionSource<Void> taskCompletionSource) {
        ((zzeo) zzawVar.getService()).zza(new zzgo(new zzei(this.a)), new zzhl(taskCompletionSource));
    }
}
