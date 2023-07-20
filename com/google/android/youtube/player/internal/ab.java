package com.google.android.youtube.player.internal;

import android.text.TextUtils;

/* loaded from: classes.dex */
public final class ab {
    public static <T> T a(T t) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException("null reference");
    }

    public static <T> T a(T t, Object obj) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(String.valueOf(obj));
    }

    public static String a(String str, Object obj) {
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        throw new IllegalArgumentException(String.valueOf(obj));
    }

    public static void a(boolean z) {
        if (z) {
            return;
        }
        throw new IllegalStateException();
    }
}
