package com.c.a.a;

import android.os.Looper;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public class l {
    private final WeakReference<b> a;

    public l(b bVar) {
        this.a = new WeakReference<>(bVar);
    }

    public boolean a() {
        b bVar = this.a.get();
        return bVar == null || bVar.b();
    }

    public boolean a(final boolean z) {
        final b bVar = this.a.get();
        if (bVar != null) {
            if (Looper.myLooper() != Looper.getMainLooper()) {
                return bVar.a(z);
            }
            new Thread(new Runnable() { // from class: com.c.a.a.l.1
                @Override // java.lang.Runnable
                public void run() {
                    bVar.a(z);
                }
            }).start();
            return true;
        }
        return false;
    }

    public boolean b() {
        b bVar = this.a.get();
        return bVar == null || bVar.a();
    }

    public boolean c() {
        boolean z = b() || a();
        if (z) {
            this.a.clear();
        }
        return z;
    }
}
