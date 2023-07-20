package com.google.android.gms.common.wrappers;

import android.content.Context;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.util.PlatformVersion;

@KeepForSdk
/* loaded from: classes.dex */
public class InstantApps {
    private static Context a;
    private static Boolean b;

    @KeepForSdk
    public static synchronized boolean isInstantApp(Context context) {
        boolean z;
        synchronized (InstantApps.class) {
            Context applicationContext = context.getApplicationContext();
            if (a != null && b != null && a == applicationContext) {
                return b.booleanValue();
            }
            b = null;
            if (!PlatformVersion.isAtLeastO()) {
                try {
                    context.getClassLoader().loadClass("com.google.android.instantapps.supervisor.InstantAppsRuntime");
                    b = true;
                } catch (ClassNotFoundException unused) {
                    z = false;
                }
                a = applicationContext;
                return b.booleanValue();
            }
            z = Boolean.valueOf(applicationContext.getPackageManager().isInstantApp());
            b = z;
            a = applicationContext;
            return b.booleanValue();
        }
    }
}
