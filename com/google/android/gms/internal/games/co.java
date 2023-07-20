package com.google.android.gms.internal.games;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.video.VideoCapabilities;
import com.google.android.gms.games.video.Videos;

/* loaded from: classes.dex */
final class co implements Videos.CaptureCapabilitiesResult {
    private final /* synthetic */ Status a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public co(cn cnVar, Status status) {
        this.a = status;
    }

    @Override // com.google.android.gms.games.video.Videos.CaptureCapabilitiesResult
    public final VideoCapabilities getCapabilities() {
        return null;
    }

    @Override // com.google.android.gms.common.api.Result
    public final Status getStatus() {
        return this.a;
    }
}
