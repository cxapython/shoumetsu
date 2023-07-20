package com.google.android.gms.common.api.internal;

import java.util.concurrent.locks.Lock;

/* loaded from: classes.dex */
abstract class p implements Runnable {
    private final /* synthetic */ zaak a;

    private p(zaak zaakVar) {
        this.a = zaakVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ p(zaak zaakVar, g gVar) {
        this(zaakVar);
    }

    protected abstract void a();

    @Override // java.lang.Runnable
    public void run() {
        Lock lock;
        Lock lock2;
        zabe zabeVar;
        lock = this.a.b;
        lock.lock();
        try {
            try {
                if (!Thread.interrupted()) {
                    a();
                }
            } catch (RuntimeException e) {
                zabeVar = this.a.a;
                zabeVar.a(e);
            }
        } finally {
            lock2 = this.a.b;
            lock2.unlock();
        }
    }
}
