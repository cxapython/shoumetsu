package com.c.a.a;

/* loaded from: classes.dex */
class p {
    public static <T> T a(T t, String str) {
        if (t != null) {
            return t;
        }
        throw new IllegalArgumentException(str + " should not be null!");
    }

    public static void a(boolean z, String str) {
        if (z) {
            return;
        }
        throw new AssertionError(str);
    }
}
