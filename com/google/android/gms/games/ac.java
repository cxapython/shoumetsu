package com.google.android.gms.games;

import com.google.android.gms.common.internal.ApiExceptionUtil;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.games.internal.zzbu;
import com.google.android.gms.games.internal.zze;
import com.google.android.gms.internal.games.zzag;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.List;

/* loaded from: classes.dex */
final class ac extends zzag<Void> {
    private final /* synthetic */ List a;
    private final /* synthetic */ byte[] b;
    private final /* synthetic */ String c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(RealTimeMultiplayerClient realTimeMultiplayerClient, List list, byte[] bArr, String str) {
        this.a = list;
        this.b = bArr;
        this.c = str;
    }

    @Override // com.google.android.gms.internal.games.zzag
    protected final void a(zze zzeVar, TaskCompletionSource<Void> taskCompletionSource) {
        Preconditions.checkNotNull(this.a, "Participant IDs must not be null");
        List list = this.a;
        if (((zzbu) zzeVar.getService()).zzb(this.b, this.c, (String[]) list.toArray(new String[list.size()])) == 0) {
            taskCompletionSource.setResult(null);
        } else {
            taskCompletionSource.trySetException(ApiExceptionUtil.fromStatus(GamesClientStatusCodes.zza(GamesClientStatusCodes.REAL_TIME_MESSAGE_SEND_FAILED)));
        }
    }
}
