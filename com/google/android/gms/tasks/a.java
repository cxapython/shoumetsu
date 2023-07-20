package com.google.android.gms.tasks;

/* loaded from: classes.dex */
final class a extends CancellationToken {
    private final v<Void> a = new v<>();

    public final void a() {
        this.a.b((v<Void>) null);
    }

    @Override // com.google.android.gms.tasks.CancellationToken
    public final boolean isCancellationRequested() {
        return this.a.isComplete();
    }

    @Override // com.google.android.gms.tasks.CancellationToken
    public final CancellationToken onCanceledRequested(OnTokenCanceledListener onTokenCanceledListener) {
        this.a.addOnSuccessListener(new b(this, onTokenCanceledListener));
        return this;
    }
}
