package com.google.firebase.iid;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import java.io.File;
import java.io.IOException;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class y {
    private final SharedPreferences a;
    private final Context b;
    private final bc c;
    private final Map<String, bb> d;

    public y(Context context) {
        this(context, new bc());
    }

    private y(Context context, bc bcVar) {
        this.d = new androidx.b.a();
        this.b = context;
        this.a = context.getSharedPreferences("com.google.android.gms.appid", 0);
        this.c = bcVar;
        File file = new File(androidx.core.a.a.a(this.b), "com.google.android.gms.appid-no-backup");
        if (!file.exists()) {
            try {
                if (!file.createNewFile() || c()) {
                    return;
                }
                Log.i("FirebaseInstanceId", "App restored, clearing state");
                b();
                FirebaseInstanceId.a().f();
            } catch (IOException e) {
                if (!Log.isLoggable("FirebaseInstanceId", 3)) {
                    return;
                }
                String valueOf = String.valueOf(e.getMessage());
                Log.d("FirebaseInstanceId", valueOf.length() != 0 ? "Error creating file in no backup dir: ".concat(valueOf) : new String("Error creating file in no backup dir: "));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a(String str, String str2) {
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 3 + String.valueOf(str2).length());
        sb.append(str);
        sb.append("|S|");
        sb.append(str2);
        return sb.toString();
    }

    private static String b(String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 4 + String.valueOf(str2).length() + String.valueOf(str3).length());
        sb.append(str);
        sb.append("|T|");
        sb.append(str2);
        sb.append("|");
        sb.append(str3);
        return sb.toString();
    }

    private final synchronized boolean c() {
        return this.a.getAll().isEmpty();
    }

    public final synchronized ab a(String str, String str2, String str3) {
        return ab.a(this.a.getString(b(str, str2, str3), null));
    }

    public final synchronized String a() {
        return this.a.getString("topic_operation_queue", "");
    }

    public final synchronized void a(String str) {
        this.a.edit().putString("topic_operation_queue", str).apply();
    }

    public final synchronized void a(String str, String str2, String str3, String str4, String str5) {
        String a = ab.a(str4, str5, System.currentTimeMillis());
        if (a == null) {
            return;
        }
        SharedPreferences.Editor edit = this.a.edit();
        edit.putString(b(str, str2, str3), a);
        edit.commit();
    }

    public final synchronized bb b(String str) {
        bb b;
        bb bbVar = this.d.get(str);
        if (bbVar != null) {
            return bbVar;
        }
        try {
            b = this.c.a(this.b, str);
        } catch (d unused) {
            Log.w("FirebaseInstanceId", "Stored data is corrupt, generating new identity");
            FirebaseInstanceId.a().f();
            b = this.c.b(this.b, str);
        }
        this.d.put(str, b);
        return b;
    }

    public final synchronized void b() {
        this.d.clear();
        bc.a(this.b);
        this.a.edit().clear().commit();
    }

    public final synchronized void c(String str) {
        String concat = String.valueOf(str).concat("|T|");
        SharedPreferences.Editor edit = this.a.edit();
        for (String str2 : this.a.getAll().keySet()) {
            if (str2.startsWith(concat)) {
                edit.remove(str2);
            }
        }
        edit.commit();
    }
}
