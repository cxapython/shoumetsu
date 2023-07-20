package com.microsoft.appcenter.e.b;

import android.text.TextUtils;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
public class f {
    private static f a;
    private String b;
    private final Set<a> c = Collections.newSetFromMap(new ConcurrentHashMap());

    /* loaded from: classes.dex */
    public interface a {
        void a(String str);
    }

    public static synchronized f a() {
        f fVar;
        synchronized (f.class) {
            if (a == null) {
                a = new f();
            }
            fVar = a;
        }
        return fVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0048, code lost:
        if (r1 == (r6.length() - 1)) goto L7;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean a(String str) {
        String str2;
        String format;
        if (str == null) {
            return true;
        }
        if (!str.isEmpty()) {
            int indexOf = str.indexOf(":");
            if (indexOf >= 0) {
                String substring = str.substring(0, indexOf);
                if (!substring.equals("c")) {
                    str2 = "AppCenter";
                    format = String.format("userId prefix must be '%s%s', '%s%s' is not supported.", "c", ":", substring, ":");
                    com.microsoft.appcenter.e.a.e(str2, format);
                    return false;
                }
            }
            return true;
        }
        str2 = "AppCenter";
        format = "userId must not be empty.";
        com.microsoft.appcenter.e.a.e(str2, format);
        return false;
    }

    public static boolean b(String str) {
        if (str == null || str.length() <= 256) {
            return true;
        }
        com.microsoft.appcenter.e.a.e("AppCenter", "userId is limited to 256 characters.");
        return false;
    }

    public static String c(String str) {
        if (str == null || str.contains(":")) {
            return str;
        }
        return "c:" + str;
    }

    private synchronized boolean e(String str) {
        boolean z;
        if (TextUtils.equals(this.b, str)) {
            z = false;
        } else {
            this.b = str;
            z = true;
        }
        return z;
    }

    public synchronized String b() {
        return this.b;
    }

    public void d(String str) {
        if (!e(str)) {
            return;
        }
        for (a aVar : this.c) {
            aVar.a(this.b);
        }
    }
}
