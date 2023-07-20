package com.amazon.device.iap.internal.util;

import java.util.Collection;

/* loaded from: classes.dex */
public class d {
    public static void a(Object obj, String str) {
        if (obj != null) {
            return;
        }
        throw new IllegalArgumentException(str + " must not be null");
    }

    public static void a(String str, String str2) {
        if (!a(str)) {
            return;
        }
        throw new IllegalArgumentException(str2 + " must not be null or empty");
    }

    public static void a(Collection<? extends Object> collection, String str) {
        if (!collection.isEmpty()) {
            return;
        }
        throw new IllegalArgumentException(str + " must not be empty");
    }

    public static boolean a(String str) {
        return str == null || str.trim().length() == 0;
    }
}
