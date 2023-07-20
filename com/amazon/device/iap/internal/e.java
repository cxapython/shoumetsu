package com.amazon.device.iap.internal;

import android.util.Log;
import com.amazon.device.iap.internal.b.g;

/* loaded from: classes.dex */
public final class e {
    private static final String a = "com.amazon.device.iap.internal.e";
    private static volatile boolean b;
    private static volatile boolean c;
    private static volatile c d;
    private static volatile a e;
    private static volatile b f;

    private static <T> T a(Class<T> cls) {
        try {
            return d().a(cls).newInstance();
        } catch (Exception e2) {
            String str = a;
            Log.e(str, "error getting instance for " + cls, e2);
            return null;
        }
    }

    public static boolean a() {
        if (c) {
            return b;
        }
        synchronized (e.class) {
            if (c) {
                return b;
            }
            e.class.getClassLoader().loadClass("com.amazon.android.Kiwi");
            b = false;
            c = true;
            return b;
        }
    }

    public static c b() {
        if (d == null) {
            synchronized (e.class) {
                if (d == null) {
                    d = (c) a(c.class);
                }
            }
        }
        return d;
    }

    public static a c() {
        if (e == null) {
            synchronized (e.class) {
                if (e == null) {
                    e = (a) a(a.class);
                }
            }
        }
        return e;
    }

    private static b d() {
        if (f == null) {
            synchronized (e.class) {
                if (f == null) {
                    f = a() ? new com.amazon.device.iap.internal.a.d() : new g();
                }
            }
        }
        return f;
    }
}
