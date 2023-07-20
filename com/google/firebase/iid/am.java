package com.google.firebase.iid;

import java.util.concurrent.Executor;

/* loaded from: classes.dex */
final /* synthetic */ class am implements Executor {
    static final Executor a = new am();

    private am() {
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        runnable.run();
    }
}
