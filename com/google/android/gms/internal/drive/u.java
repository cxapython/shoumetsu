package com.google.android.gms.internal.drive;

import android.content.IntentSender;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.drive.OpenFileActivityOptions;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes.dex */
final class u extends TaskApiCall<zzaw, IntentSender> {
    private final /* synthetic */ OpenFileActivityOptions a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(zzbb zzbbVar, OpenFileActivityOptions openFileActivityOptions) {
        this.a = openFileActivityOptions;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.api.internal.TaskApiCall
    public final /* synthetic */ void a(zzaw zzawVar, TaskCompletionSource<IntentSender> taskCompletionSource) {
        taskCompletionSource.setResult(((zzeo) zzawVar.getService()).zza(new zzgg(this.a.zzay, this.a.zzaz, this.a.zzbb, this.a.zzbc)));
    }
}
