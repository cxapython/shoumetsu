package com.google.android.gms.common.api.internal;

import java.util.concurrent.locks.Lock;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class bb implements Runnable {
    private final /* synthetic */ ba a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bb(ba baVar) {
        this.a = baVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Lock lock;
        Lock lock2;
        lock = this.a.m;
        lock.lock();
        try {
            this.a.a();
        } finally {
            lock2 = this.a.m;
            lock2.unlock();
        }
    }
}
