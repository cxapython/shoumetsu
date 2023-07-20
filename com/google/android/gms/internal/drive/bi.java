package com.google.android.gms.internal.drive;

import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.drive.MetadataBuffer;
import com.google.android.gms.drive.query.Query;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes.dex */
final class bi extends TaskApiCall<zzaw, MetadataBuffer> {
    private final /* synthetic */ Query a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bi(zzch zzchVar, Query query) {
        this.a = query;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.api.internal.TaskApiCall
    public final /* synthetic */ void a(zzaw zzawVar, TaskCompletionSource<MetadataBuffer> taskCompletionSource) {
        ((zzeo) zzawVar.getService()).zza(new zzgk(this.a), new zzhh(taskCompletionSource));
    }
}
