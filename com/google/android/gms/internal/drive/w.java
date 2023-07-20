package com.google.android.gms.internal.drive;

import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes.dex */
final class w extends TaskApiCall<zzaw, Void> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public w(zzbb zzbbVar) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.api.internal.TaskApiCall
    public final /* synthetic */ void a(zzaw zzawVar, TaskCompletionSource<Void> taskCompletionSource) {
        ((zzeo) zzawVar.getService()).zza(new zzhl(taskCompletionSource));
    }
}
