package com.microsoft.appcenter;

import android.content.Context;

/* loaded from: classes.dex */
public class f {
    public static String a = null;
    public static boolean b = false;

    public static void a(Context context) {
        b(context);
        c(context);
    }

    private static void b(Context context) {
        if (context != null) {
            try {
                a = context.getFilesDir().getAbsolutePath();
            } catch (Exception e) {
                com.microsoft.appcenter.e.a.b("AppCenter", "Exception thrown when accessing the application filesystem", e);
            }
        }
    }

    private static void c(Context context) {
        if (context == null || context.getApplicationInfo() == null) {
            return;
        }
        b = (context.getApplicationInfo().flags & 2) > 0;
    }
}
