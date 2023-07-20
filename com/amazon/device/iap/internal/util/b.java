package com.amazon.device.iap.internal.util;

import android.content.Context;
import android.content.SharedPreferences;
import net.gree.gamelib.payment.internal.a.g;

/* loaded from: classes.dex */
public class b {
    private static final String a = b.class.getName() + "_PREFS";

    public static String a(String str) {
        d.a((Object) str, g.c);
        Context b = com.amazon.device.iap.internal.d.d().b();
        d.a(b, "context");
        return b.getSharedPreferences(a, 0).getString(str, null);
    }

    public static void a(String str, String str2) {
        d.a((Object) str, g.c);
        Context b = com.amazon.device.iap.internal.d.d().b();
        d.a(b, "context");
        SharedPreferences.Editor edit = b.getSharedPreferences(a, 0).edit();
        edit.putString(str, str2);
        edit.commit();
    }
}
