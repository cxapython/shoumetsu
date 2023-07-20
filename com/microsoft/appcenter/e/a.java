package com.microsoft.appcenter.e;

import android.util.Log;

/* loaded from: classes.dex */
public class a {
    private static int a = 7;

    public static int a() {
        return a;
    }

    public static void a(int i) {
        a = i;
    }

    public static void a(String str, String str2) {
        if (a <= 2) {
            Log.v(str, str2);
        }
    }

    public static void a(String str, String str2, Throwable th) {
        if (a <= 5) {
            Log.w(str, str2, th);
        }
    }

    public static void b(String str, String str2) {
        if (a <= 3) {
            Log.d(str, str2);
        }
    }

    public static void b(String str, String str2, Throwable th) {
        if (a <= 6) {
            Log.e(str, str2, th);
        }
    }

    public static void c(String str, String str2) {
        if (a <= 4) {
            Log.i(str, str2);
        }
    }

    public static void d(String str, String str2) {
        if (a <= 5) {
            Log.w(str, str2);
        }
    }

    public static void e(String str, String str2) {
        if (a <= 6) {
            Log.e(str, str2);
        }
    }
}
