package com.google.android.gms.games;

import android.content.Intent;
import com.google.android.gms.games.internal.zze;
import com.google.android.gms.internal.games.zzag;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes.dex */
final class cx extends zzag<Intent> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public cx(InvitationsClient invitationsClient) {
    }

    @Override // com.google.android.gms.internal.games.zzag
    protected final void a(zze zzeVar, TaskCompletionSource<Intent> taskCompletionSource) {
        taskCompletionSource.setResult(zzeVar.zzbe());
    }
}
