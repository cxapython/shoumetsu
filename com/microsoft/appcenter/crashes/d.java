package com.microsoft.appcenter.crashes;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/* loaded from: classes.dex */
public class d {
    static final Map<String, String> a = new HashMap();

    public static void a(UUID uuid) {
        if (uuid == null) {
            com.microsoft.appcenter.e.a.e("AppCenterCrashes", "Failed to delete wrapper exception data: null errorId");
            return;
        }
        File c = c(uuid);
        if (!c.exists()) {
            return;
        }
        if (b(uuid) == null) {
            com.microsoft.appcenter.e.a.e("AppCenterCrashes", "Failed to load wrapper exception data.");
        }
        com.microsoft.appcenter.e.d.b.c(c);
    }

    public static String b(UUID uuid) {
        String str = null;
        if (uuid == null) {
            com.microsoft.appcenter.e.a.e("AppCenterCrashes", "Failed to load wrapper exception data: null errorId");
            return null;
        }
        String str2 = a.get(uuid.toString());
        if (str2 != null) {
            return str2;
        }
        File c = c(uuid);
        if (c.exists() && (str = com.microsoft.appcenter.e.d.b.a(c)) != null) {
            a.put(uuid.toString(), str);
        }
        return str;
    }

    private static File c(UUID uuid) {
        File a2 = com.microsoft.appcenter.crashes.c.a.a();
        return new File(a2, uuid.toString() + ".dat");
    }
}
