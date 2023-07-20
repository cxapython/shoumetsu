package com.amazon.device.iap.internal.c;

import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;

/* loaded from: classes.dex */
public class b {
    private static final b b = new b();
    private final Set<String> a = new ConcurrentSkipListSet();

    public static b a() {
        return b;
    }

    public boolean a(String str) {
        if (!com.amazon.device.iap.internal.util.d.a(str)) {
            return this.a.remove(str);
        }
        return false;
    }

    public void b(String str) {
        if (!com.amazon.device.iap.internal.util.d.a(str)) {
            this.a.add(str);
        }
    }
}
