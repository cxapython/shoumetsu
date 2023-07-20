package com.google.android.gms.tasks;

/* loaded from: classes.dex */
final class t implements OnTokenCanceledListener {
    private final /* synthetic */ TaskCompletionSource a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(TaskCompletionSource taskCompletionSource) {
        this.a = taskCompletionSource;
    }

    @Override // com.google.android.gms.tasks.OnTokenCanceledListener
    public final void onCanceled() {
        v vVar;
        vVar = this.a.a;
        vVar.a();
    }
}
