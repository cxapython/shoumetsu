package com.google.android.gms.internal.games;

import android.os.Handler;
import android.os.Looper;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
public abstract class zzeh {
    private Handler b;
    private boolean c;
    private final Object a = new Object();
    private HashMap<String, AtomicInteger> d = new HashMap<>();
    private int e = 1000;

    public zzeh(Looper looper, int i) {
        this.b = new zzen(looper);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a() {
        synchronized (this.a) {
            this.c = false;
            flush();
        }
    }

    protected abstract void a(String str, int i);

    public final void flush() {
        synchronized (this.a) {
            for (Map.Entry<String, AtomicInteger> entry : this.d.entrySet()) {
                a(entry.getKey(), entry.getValue().get());
            }
            this.d.clear();
        }
    }

    public final void zzg(String str, int i) {
        synchronized (this.a) {
            if (!this.c) {
                this.c = true;
                this.b.postDelayed(new cr(this), this.e);
            }
            AtomicInteger atomicInteger = this.d.get(str);
            if (atomicInteger == null) {
                atomicInteger = new AtomicInteger();
                this.d.put(str, atomicInteger);
            }
            atomicInteger.addAndGet(i);
        }
    }
}
