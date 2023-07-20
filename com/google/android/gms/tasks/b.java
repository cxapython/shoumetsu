package com.google.android.gms.tasks;

/* loaded from: classes.dex */
final class b implements OnSuccessListener<Void> {
    private final /* synthetic */ OnTokenCanceledListener a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, OnTokenCanceledListener onTokenCanceledListener) {
        this.a = onTokenCanceledListener;
    }

    @Override // com.google.android.gms.tasks.OnSuccessListener
    public final /* synthetic */ void onSuccess(Void r1) {
        this.a.onCanceled();
    }
}
