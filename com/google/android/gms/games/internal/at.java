package com.google.android.gms.games.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.games.internal.zze;
import com.google.android.gms.games.video.VideoCapabilities;
import com.google.android.gms.games.video.Videos;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class at extends zze.u<Videos.CaptureCapabilitiesResult> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public at(BaseImplementation.ResultHolder resultHolder) {
        super(resultHolder);
    }

    @Override // com.google.android.gms.games.internal.zza, com.google.android.gms.games.internal.zzbq
    public final void zza(int i, VideoCapabilities videoCapabilities) {
        a(new zze.an(new Status(i), videoCapabilities));
    }
}
