package com.google.android.gms.common.util.concurrent;

import android.os.Process;

/* loaded from: classes.dex */
final class a implements Runnable {
    private final Runnable a;
    private final int b;

    public a(Runnable runnable, int i) {
        this.a = runnable;
        this.b = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Process.setThreadPriority(this.b);
        this.a.run();
    }
}
