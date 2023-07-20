package com.google.android.gms.internal.drive;

import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.drive.events.OpenFileCallback;

/* loaded from: classes.dex */
final class by implements ListenerHolder.Notifier<OpenFileCallback> {
    private final /* synthetic */ bq a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public by(bu buVar, bq bqVar) {
        this.a = bqVar;
    }

    @Override // com.google.android.gms.common.api.internal.ListenerHolder.Notifier
    public final /* synthetic */ void notifyListener(OpenFileCallback openFileCallback) {
        this.a.a(openFileCallback);
    }

    @Override // com.google.android.gms.common.api.internal.ListenerHolder.Notifier
    public final void onNotifyListenerFailed() {
    }
}
