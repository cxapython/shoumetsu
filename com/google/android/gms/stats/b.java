package com.google.android.gms.stats;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class b implements Runnable {
    private final /* synthetic */ WakeLock a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(WakeLock wakeLock) {
        this.a = wakeLock;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.a(0);
    }
}
