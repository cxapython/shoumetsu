package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.internal.BackgroundDetector;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class y implements BackgroundDetector.BackgroundStateChangeListener {
    private final /* synthetic */ GoogleApiManager a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(GoogleApiManager googleApiManager) {
        this.a = googleApiManager;
    }

    @Override // com.google.android.gms.common.api.internal.BackgroundDetector.BackgroundStateChangeListener
    public final void onBackgroundStateChanged(boolean z) {
        this.a.p.sendMessage(this.a.p.obtainMessage(1, Boolean.valueOf(z)));
    }
}
