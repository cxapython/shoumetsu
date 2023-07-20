package com.google.android.gms.analytics;

import android.content.BroadcastReceiver;

/* loaded from: classes.dex */
final class a implements Runnable {
    private final /* synthetic */ BroadcastReceiver.PendingResult a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(CampaignTrackingReceiver campaignTrackingReceiver, BroadcastReceiver.PendingResult pendingResult) {
        this.a = pendingResult;
    }

    @Override // java.lang.Runnable
    public final void run() {
        BroadcastReceiver.PendingResult pendingResult = this.a;
        if (pendingResult != null) {
            pendingResult.finish();
        }
    }
}
