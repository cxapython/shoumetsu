package com.amazon.device.iap.internal.c;

import android.content.Context;
import android.content.SharedPreferences;
import net.gree.gamelib.payment.internal.a.g;

/* loaded from: classes.dex */
public class c {
    private static c a = new c();
    private static final String b = c.class.getSimpleName();
    private static final String c = c.class.getName() + "_PREFS_";

    public static c a() {
        return a;
    }

    public String a(String str, String str2) {
        String str3 = b;
        com.amazon.device.iap.internal.util.e.a(str3, "enter getReceiptIdFromSku for sku [" + str2 + "], user [" + str + "]");
        String str4 = null;
        try {
            com.amazon.device.iap.internal.util.d.a(str, g.c);
            com.amazon.device.iap.internal.util.d.a(str2, "sku");
            Context b2 = com.amazon.device.iap.internal.d.d().b();
            com.amazon.device.iap.internal.util.d.a(b2, "context");
            str4 = b2.getSharedPreferences(c + str, 0).getString(str2, null);
        } catch (Throwable th) {
            String str5 = b;
            com.amazon.device.iap.internal.util.e.a(str5, "error in saving v1 Entitlement:" + str2 + ":" + th.getMessage());
        }
        String str6 = b;
        com.amazon.device.iap.internal.util.e.a(str6, "leaving saveEntitlementRecord for sku [" + str2 + "], user [" + str + "]");
        return str4;
    }

    public void a(String str, String str2, String str3) {
        String str4 = b;
        com.amazon.device.iap.internal.util.e.a(str4, "enter saveEntitlementRecord for v1 Entitlement [" + str2 + "/" + str3 + "], user [" + str + "]");
        try {
            com.amazon.device.iap.internal.util.d.a(str, g.c);
            com.amazon.device.iap.internal.util.d.a(str2, "receiptId");
            com.amazon.device.iap.internal.util.d.a(str3, "sku");
            Context b2 = com.amazon.device.iap.internal.d.d().b();
            com.amazon.device.iap.internal.util.d.a(b2, "context");
            SharedPreferences.Editor edit = b2.getSharedPreferences(c + str, 0).edit();
            edit.putString(str3, str2);
            edit.commit();
        } catch (Throwable th) {
            String str5 = b;
            com.amazon.device.iap.internal.util.e.a(str5, "error in saving v1 Entitlement:" + str2 + "/" + str3 + ":" + th.getMessage());
        }
        String str6 = b;
        com.amazon.device.iap.internal.util.e.a(str6, "leaving saveEntitlementRecord for v1 Entitlement [" + str2 + "/" + str3 + "], user [" + str + "]");
    }
}
