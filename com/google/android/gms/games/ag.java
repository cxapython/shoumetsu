package com.google.android.gms.games;

import com.google.android.gms.games.internal.zzbu;
import com.google.android.gms.games.internal.zze;
import com.google.android.gms.internal.games.zzag;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes.dex */
final class ag extends zzag<String> {
    private final /* synthetic */ String a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(RealTimeMultiplayerClient realTimeMultiplayerClient, String str) {
        this.a = str;
    }

    @Override // com.google.android.gms.internal.games.zzag
    protected final void a(zze zzeVar, TaskCompletionSource<String> taskCompletionSource) {
        ((zzbu) zzeVar.getService()).zza(new ah(this, taskCompletionSource), this.a);
    }
}
