package com.google.android.gms.games;

import com.google.android.gms.games.internal.zze;
import com.google.android.gms.internal.games.zzag;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class p extends zzag<Void> {
    private final /* synthetic */ int a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(NotificationsClient notificationsClient, int i) {
        this.a = i;
    }

    @Override // com.google.android.gms.internal.games.zzag
    protected final void a(zze zzeVar, TaskCompletionSource<Void> taskCompletionSource) {
        zzeVar.zzl(this.a);
        taskCompletionSource.setResult(null);
    }
}
