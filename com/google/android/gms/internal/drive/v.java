package com.google.android.gms.internal.drive;

import android.content.IntentSender;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.drive.CreateFileActivityOptions;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes.dex */
final class v extends TaskApiCall<zzaw, IntentSender> {
    private final /* synthetic */ CreateFileActivityOptions a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(zzbb zzbbVar, CreateFileActivityOptions createFileActivityOptions) {
        this.a = createFileActivityOptions;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.api.internal.TaskApiCall
    public final /* synthetic */ void a(zzaw zzawVar, TaskCompletionSource<IntentSender> taskCompletionSource) {
        zzaw zzawVar2 = zzawVar;
        this.a.zzdc.zza(zzawVar2.getContext());
        taskCompletionSource.setResult(((zzeo) zzawVar2.getService()).zza(new zzu(this.a.zzdc, this.a.zzdi.intValue(), this.a.zzay, this.a.zzbb, Integer.valueOf(this.a.zzdj))));
    }
}
