package com.microsoft.appcenter.e;

import android.os.Bundle;

/* loaded from: classes.dex */
public class e {
    private static final String[] a = {"androidx.test.platform.app.InstrumentationRegistry", "androidx.test.InstrumentationRegistry", "androidx.test.InstrumentationRegistry"};

    public static Bundle a() {
        Exception e = null;
        for (String str : a) {
            try {
                return (Bundle) a(str).getMethod("getArguments", new Class[0]).invoke(null, new Object[0]);
            } catch (Exception e2) {
                e = e2;
            }
        }
        throw new IllegalStateException(e);
    }

    private static Class<?> a(String str) {
        return Class.forName(str);
    }
}
