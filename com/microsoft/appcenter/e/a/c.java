package com.microsoft.appcenter.e.a;

import java.util.Collection;
import java.util.LinkedList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public class c<T> implements b<T> {
    private final CountDownLatch a = new CountDownLatch(1);
    private T b;
    private Collection<a<T>> c;

    @Override // com.microsoft.appcenter.e.a.b
    public T a() {
        while (true) {
            try {
                this.a.await();
                return this.b;
            } catch (InterruptedException unused) {
            }
        }
    }

    @Override // com.microsoft.appcenter.e.a.b
    public synchronized void a(final a<T> aVar) {
        if (b()) {
            com.microsoft.appcenter.e.c.a(new Runnable() { // from class: com.microsoft.appcenter.e.a.c.1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.lang.Runnable
                public void run() {
                    aVar.accept(c.this.b);
                }
            });
        } else {
            if (this.c == null) {
                this.c = new LinkedList();
            }
            this.c.add(aVar);
        }
    }

    public synchronized void a(final T t) {
        if (!b()) {
            this.b = t;
            this.a.countDown();
            if (this.c != null) {
                com.microsoft.appcenter.e.c.a(new Runnable() { // from class: com.microsoft.appcenter.e.a.c.2
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // java.lang.Runnable
                    public void run() {
                        for (a aVar : c.this.c) {
                            aVar.accept(t);
                        }
                        c.this.c = null;
                    }
                });
            }
        }
    }

    public boolean b() {
        while (true) {
            try {
                return this.a.await(0L, TimeUnit.MILLISECONDS);
            } catch (InterruptedException unused) {
            }
        }
    }
}
