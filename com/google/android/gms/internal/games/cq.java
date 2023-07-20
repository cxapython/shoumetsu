package com.google.android.gms.internal.games;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.video.CaptureState;
import com.google.android.gms.games.video.Videos;

/* loaded from: classes.dex */
final class cq implements Videos.CaptureStateResult {
    private final /* synthetic */ Status a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cq(cp cpVar, Status status) {
        this.a = status;
    }

    @Override // com.google.android.gms.games.video.Videos.CaptureStateResult
    public final CaptureState getCaptureState() {
        return null;
    }

    @Override // com.google.android.gms.common.api.Result
    public final Status getStatus() {
        return this.a;
    }
}
