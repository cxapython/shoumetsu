package com.google.android.gms.tasks;

import java.util.concurrent.Callable;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class w implements Runnable {
    private final /* synthetic */ v a;
    private final /* synthetic */ Callable b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(v vVar, Callable callable) {
        this.a = vVar;
        this.b = callable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.a.a((v) this.b.call());
        } catch (Exception e) {
            this.a.a(e);
        }
    }
}
