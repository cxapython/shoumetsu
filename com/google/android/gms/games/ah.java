package com.google.android.gms.games;

import com.google.android.gms.common.api.internal.TaskUtil;
import com.google.android.gms.games.internal.zza;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes.dex */
final class ah extends zza {
    private final /* synthetic */ TaskCompletionSource a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(ag agVar, TaskCompletionSource taskCompletionSource) {
        this.a = taskCompletionSource;
    }

    @Override // com.google.android.gms.games.internal.zza, com.google.android.gms.games.internal.zzbq
    public final void onLeftRoom(int i, String str) {
        TaskUtil.setResultOrApiException(GamesClientStatusCodes.zza(GamesClientStatusCodes.zzb(i)), str, this.a);
    }
}
