package com.google.android.gms.common.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
/* loaded from: classes.dex */
public final class DeviceProperties {
    private static Boolean a;
    private static Boolean b;
    private static Boolean c;
    private static Boolean d;
    private static Boolean e;
    private static Boolean f;
    private static Boolean g;
    private static Boolean h;

    private DeviceProperties() {
    }

    @KeepForSdk
    public static boolean isAuto(Context context) {
        if (g == null) {
            g = Boolean.valueOf(PlatformVersion.isAtLeastO() && context.getPackageManager().hasSystemFeature("android.hardware.type.automotive"));
        }
        return g.booleanValue();
    }

    @KeepForSdk
    public static boolean isLatchsky(Context context) {
        if (e == null) {
            PackageManager packageManager = context.getPackageManager();
            e = Boolean.valueOf(packageManager.hasSystemFeature("com.google.android.feature.services_updater") && packageManager.hasSystemFeature("cn.google.services"));
        }
        return e.booleanValue();
    }

    @KeepForSdk
    @TargetApi(21)
    public static boolean isSidewinder(Context context) {
        if (d == null) {
            d = Boolean.valueOf(PlatformVersion.isAtLeastLollipop() && context.getPackageManager().hasSystemFeature("cn.google"));
        }
        return d.booleanValue();
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x003c, code lost:
        if (com.google.android.gms.common.util.DeviceProperties.b.booleanValue() != false) goto L23;
     */
    @KeepForSdk
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean isTablet(Resources resources) {
        boolean z = false;
        if (resources == null) {
            return false;
        }
        if (a == null) {
            if (!((resources.getConfiguration().screenLayout & 15) > 3)) {
                if (b == null) {
                    Configuration configuration = resources.getConfiguration();
                    b = Boolean.valueOf((configuration.screenLayout & 15) <= 3 && configuration.smallestScreenWidthDp >= 600);
                }
            }
            z = true;
            a = Boolean.valueOf(z);
        }
        return a.booleanValue();
    }

    @KeepForSdk
    public static boolean isTv(Context context) {
        if (h == null) {
            PackageManager packageManager = context.getPackageManager();
            h = Boolean.valueOf(packageManager.hasSystemFeature("com.google.android.tv") || packageManager.hasSystemFeature("android.hardware.type.television") || packageManager.hasSystemFeature("android.software.leanback"));
        }
        return h.booleanValue();
    }

    @KeepForSdk
    public static boolean isUserBuild() {
        return "user".equals(Build.TYPE);
    }

    @KeepForSdk
    @TargetApi(20)
    public static boolean isWearable(Context context) {
        if (c == null) {
            c = Boolean.valueOf(PlatformVersion.isAtLeastKitKatWatch() && context.getPackageManager().hasSystemFeature("android.hardware.type.watch"));
        }
        return c.booleanValue();
    }

    @KeepForSdk
    @TargetApi(26)
    public static boolean isWearableWithoutPlayStore(Context context) {
        if (isWearable(context)) {
            if (!PlatformVersion.isAtLeastN()) {
                return true;
            }
            return isSidewinder(context) && !PlatformVersion.isAtLeastO();
        }
        return false;
    }

    public static boolean zzf(Context context) {
        if (f == null) {
            f = Boolean.valueOf(context.getPackageManager().hasSystemFeature("android.hardware.type.iot") || context.getPackageManager().hasSystemFeature("android.hardware.type.embedded"));
        }
        return f.booleanValue();
    }
}
