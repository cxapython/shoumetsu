package com.amazon.device.iap.internal.c;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import com.amazon.device.iap.model.Receipt;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import net.gree.gamelib.payment.internal.a.g;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class a {
    private static final String a = "a";
    private static final String b = a.class.getName() + "_PREFS";
    private static final String c = a.class.getName() + "_CLEANER_PREFS";
    private static int d = 604800000;
    private static final a e = new a();

    public static a a() {
        return e;
    }

    private void a(long j) {
        Context b2 = com.amazon.device.iap.internal.d.d().b();
        com.amazon.device.iap.internal.util.d.a(b2, "context");
        SharedPreferences.Editor edit = b2.getSharedPreferences(c, 0).edit();
        edit.putLong("LAST_CLEANING_TIME", j);
        edit.commit();
    }

    private void e() {
        com.amazon.device.iap.internal.util.e.a(a, "enter old receipts cleanup! ");
        final Context b2 = com.amazon.device.iap.internal.d.d().b();
        com.amazon.device.iap.internal.util.d.a(b2, "context");
        a(System.currentTimeMillis());
        new Handler().post(new Runnable() { // from class: com.amazon.device.iap.internal.c.a.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    com.amazon.device.iap.internal.util.e.a(a.a, "perform house keeping! ");
                    SharedPreferences sharedPreferences = b2.getSharedPreferences(a.b, 0);
                    for (String str : sharedPreferences.getAll().keySet()) {
                        try {
                            if (System.currentTimeMillis() - d.a(sharedPreferences.getString(str, null)).c() > a.d) {
                                String str2 = a.a;
                                com.amazon.device.iap.internal.util.e.a(str2, "house keeping - try remove Receipt:" + str + " since it's too old");
                                a.this.a(str);
                            }
                        } catch (e unused) {
                            String str3 = a.a;
                            com.amazon.device.iap.internal.util.e.a(str3, "house keeping - try remove Receipt:" + str + " since it's invalid ");
                            a.this.a(str);
                        }
                    }
                } catch (Throwable th) {
                    String str4 = a.a;
                    com.amazon.device.iap.internal.util.e.a(str4, "Error in running cleaning job:" + th);
                }
            }
        });
    }

    private long f() {
        Context b2 = com.amazon.device.iap.internal.d.d().b();
        com.amazon.device.iap.internal.util.d.a(b2, "context");
        long currentTimeMillis = System.currentTimeMillis();
        long j = b2.getSharedPreferences(c, 0).getLong("LAST_CLEANING_TIME", 0L);
        if (j == 0) {
            a(currentTimeMillis);
            return currentTimeMillis;
        }
        return j;
    }

    public void a(String str) {
        String str2 = a;
        com.amazon.device.iap.internal.util.e.a(str2, "enter removeReceipt for receipt[" + str + "]");
        Context b2 = com.amazon.device.iap.internal.d.d().b();
        com.amazon.device.iap.internal.util.d.a(b2, "context");
        SharedPreferences.Editor edit = b2.getSharedPreferences(b, 0).edit();
        edit.remove(str);
        edit.commit();
        String str3 = a;
        com.amazon.device.iap.internal.util.e.a(str3, "leave removeReceipt for receipt[" + str + "]");
    }

    public void a(String str, String str2, String str3, String str4) {
        String str5 = a;
        com.amazon.device.iap.internal.util.e.a(str5, "enter saveReceipt for receipt [" + str4 + "]");
        try {
            com.amazon.device.iap.internal.util.d.a(str2, g.c);
            com.amazon.device.iap.internal.util.d.a(str3, "receiptId");
            com.amazon.device.iap.internal.util.d.a(str4, "receiptString");
            Context b2 = com.amazon.device.iap.internal.d.d().b();
            com.amazon.device.iap.internal.util.d.a(b2, "context");
            d dVar = new d(str2, str4, str, System.currentTimeMillis());
            SharedPreferences.Editor edit = b2.getSharedPreferences(b, 0).edit();
            edit.putString(str3, dVar.d());
            edit.commit();
        } catch (Throwable th) {
            String str6 = a;
            com.amazon.device.iap.internal.util.e.a(str6, "error in saving pending receipt:" + str + "/" + str4 + ":" + th.getMessage());
        }
        String str7 = a;
        com.amazon.device.iap.internal.util.e.a(str7, "leaving saveReceipt for receipt id [" + str3 + "]");
    }

    public Set<Receipt> b(String str) {
        String str2;
        StringBuilder sb;
        String str3;
        Context b2 = com.amazon.device.iap.internal.d.d().b();
        com.amazon.device.iap.internal.util.d.a(b2, "context");
        String str4 = a;
        com.amazon.device.iap.internal.util.e.a(str4, "enter getLocalReceipts for user[" + str + "]");
        HashSet hashSet = new HashSet();
        if (com.amazon.device.iap.internal.util.d.a(str)) {
            String str5 = a;
            com.amazon.device.iap.internal.util.e.b(str5, "empty UserId: " + str);
            throw new RuntimeException("Invalid UserId:" + str);
        }
        Map<String, ?> all = b2.getSharedPreferences(b, 0).getAll();
        for (String str6 : all.keySet()) {
            String str7 = (String) all.get(str6);
            try {
                d a2 = d.a(str7);
                hashSet.add(com.amazon.device.iap.internal.util.a.a(new JSONObject(a2.b()), str, a2.a()));
            } catch (com.amazon.device.iap.internal.b.d unused) {
                a(str6);
                str2 = a;
                sb = new StringBuilder();
                str3 = "failed to verify signature:[";
                sb.append(str3);
                sb.append(str7);
                sb.append("]");
                com.amazon.device.iap.internal.util.e.b(str2, sb.toString());
            } catch (JSONException unused2) {
                a(str6);
                str2 = a;
                sb = new StringBuilder();
                str3 = "failed to convert string to JSON object:[";
                sb.append(str3);
                sb.append(str7);
                sb.append("]");
                com.amazon.device.iap.internal.util.e.b(str2, sb.toString());
            } catch (Throwable unused3) {
                str2 = a;
                sb = new StringBuilder();
                str3 = "failed to load the receipt from SharedPreference:[";
                sb.append(str3);
                sb.append(str7);
                sb.append("]");
                com.amazon.device.iap.internal.util.e.b(str2, sb.toString());
            }
        }
        String str8 = a;
        com.amazon.device.iap.internal.util.e.a(str8, "leaving getLocalReceipts for user[" + str + "], " + hashSet.size() + " local receipts found.");
        if (System.currentTimeMillis() - f() > d) {
            e();
        }
        return hashSet;
    }

    public String c(String str) {
        Context b2 = com.amazon.device.iap.internal.d.d().b();
        com.amazon.device.iap.internal.util.d.a(b2, "context");
        if (!com.amazon.device.iap.internal.util.d.a(str)) {
            String string = b2.getSharedPreferences(b, 0).getString(str, null);
            if (string != null) {
                try {
                    return d.a(string).a();
                } catch (e unused) {
                }
            }
            return null;
        }
        String str2 = a;
        com.amazon.device.iap.internal.util.e.b(str2, "empty receiptId: " + str);
        throw new RuntimeException("Invalid ReceiptId:" + str);
    }
}
