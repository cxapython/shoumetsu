package com.google.firebase.d;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import com.google.firebase.b.c;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
public class a {
    private final Context a;
    private final SharedPreferences b;
    private final c c;
    private final AtomicBoolean d = new AtomicBoolean(b());

    public a(Context context, String str, c cVar) {
        this.a = a(context);
        this.b = context.getSharedPreferences("com.google.firebase.common.prefs:" + str, 0);
        this.c = cVar;
    }

    private static Context a(Context context) {
        return (Build.VERSION.SDK_INT < 24 || androidx.core.a.a.c(context)) ? context : androidx.core.a.a.b(context);
    }

    private boolean b() {
        ApplicationInfo applicationInfo;
        if (this.b.contains("firebase_data_collection_default_enabled")) {
            return this.b.getBoolean("firebase_data_collection_default_enabled", true);
        }
        try {
            PackageManager packageManager = this.a.getPackageManager();
            if (packageManager != null && (applicationInfo = packageManager.getApplicationInfo(this.a.getPackageName(), 128)) != null && applicationInfo.metaData != null && applicationInfo.metaData.containsKey("firebase_data_collection_default_enabled")) {
                return applicationInfo.metaData.getBoolean("firebase_data_collection_default_enabled");
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return true;
    }

    public boolean a() {
        return this.d.get();
    }
}
