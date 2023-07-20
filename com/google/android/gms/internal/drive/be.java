package com.google.android.gms.internal.drive;

import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.UnregisterListenerMethod;
import com.google.android.gms.drive.events.OpenFileCallback;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes.dex */
final class be extends UnregisterListenerMethod<zzaw, OpenFileCallback> {
    private final /* synthetic */ zzg a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public be(zzch zzchVar, ListenerHolder.ListenerKey listenerKey, zzg zzgVar) {
        super(listenerKey);
        this.a = zzgVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.api.internal.UnregisterListenerMethod
    public final /* synthetic */ void a(zzaw zzawVar, TaskCompletionSource taskCompletionSource) {
        taskCompletionSource.setResult(Boolean.valueOf(this.a.cancel()));
    }
}
