package com.google.android.gms.internal.firebase_messaging;

/* loaded from: classes.dex */
final class h extends e {
    private final g a = new g();

    @Override // com.google.android.gms.internal.firebase_messaging.e
    public final void a(Throwable th, Throwable th2) {
        if (th2 != th) {
            if (th2 == null) {
                throw new NullPointerException("The suppressed exception cannot be null.");
            }
            this.a.a(th, true).add(th2);
            return;
        }
        throw new IllegalArgumentException("Self suppression is not allowed.", th2);
    }
}
