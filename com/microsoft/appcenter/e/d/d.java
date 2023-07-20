package com.microsoft.appcenter.e.d;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import java.util.Set;

/* loaded from: classes.dex */
public class d {
    @SuppressLint({"StaticFieldLeak"})
    private static Context a;
    private static SharedPreferences b;

    public static int a(String str, int i) {
        return b.getInt(str, i);
    }

    public static long a(String str) {
        return a(str, 0L);
    }

    public static long a(String str, long j) {
        return b.getLong(str, j);
    }

    public static String a(String str, String str2) {
        return b.getString(str, str2);
    }

    public static Set<String> a(String str, Set<String> set) {
        return b.getStringSet(str, set);
    }

    public static synchronized void a(Context context) {
        synchronized (d.class) {
            if (a == null) {
                a = context;
                b = a.getSharedPreferences("AppCenter", 0);
            }
        }
    }

    public static boolean a(String str, boolean z) {
        return b.getBoolean(str, z);
    }

    public static Set<String> b(String str) {
        return a(str, (Set<String>) null);
    }

    public static void b(String str, int i) {
        SharedPreferences.Editor edit = b.edit();
        edit.putInt(str, i);
        edit.apply();
    }

    public static void b(String str, long j) {
        SharedPreferences.Editor edit = b.edit();
        edit.putLong(str, j);
        edit.apply();
    }

    public static void b(String str, String str2) {
        SharedPreferences.Editor edit = b.edit();
        edit.putString(str, str2);
        edit.apply();
    }

    public static void b(String str, Set<String> set) {
        SharedPreferences.Editor edit = b.edit();
        edit.putStringSet(str, set);
        edit.apply();
    }

    public static void b(String str, boolean z) {
        SharedPreferences.Editor edit = b.edit();
        edit.putBoolean(str, z);
        edit.apply();
    }

    public static void c(String str) {
        SharedPreferences.Editor edit = b.edit();
        edit.remove(str);
        edit.apply();
    }
}
