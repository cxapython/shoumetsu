package com.google.android.gms.games.internal;

import android.os.Bundle;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.games.internal.zze;
import com.google.android.gms.games.video.CaptureState;
import com.google.android.gms.games.video.Videos;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class av extends zze.u<Videos.CaptureStateResult> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public av(BaseImplementation.ResultHolder resultHolder) {
        super(resultHolder);
    }

    @Override // com.google.android.gms.games.internal.zza, com.google.android.gms.games.internal.zzbq
    public final void zze(int i, Bundle bundle) {
        a(new zze.ao(new Status(i), CaptureState.zzb(bundle)));
    }
}
