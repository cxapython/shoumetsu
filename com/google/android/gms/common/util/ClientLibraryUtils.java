package com.google.android.gms.common.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.wrappers.Wrappers;

@KeepForSdk
/* loaded from: classes.dex */
public class ClientLibraryUtils {
    private ClientLibraryUtils() {
    }

    private static PackageInfo a(Context context, String str) {
        try {
            return Wrappers.packageManager(context).getPackageInfo(str, 128);
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    @KeepForSdk
    public static int getClientVersion(Context context, String str) {
        Bundle bundle;
        PackageInfo a = a(context, str);
        if (a == null || a.applicationInfo == null || (bundle = a.applicationInfo.metaData) == null) {
            return -1;
        }
        return bundle.getInt("com.google.android.gms.version", -1);
    }

    @KeepForSdk
    public static boolean isPackageSide() {
        return false;
    }

    public static boolean zzc(Context context, String str) {
        "com.google.android.gms".equals(str);
        return (Wrappers.packageManager(context).getApplicationInfo(str, 0).flags & 2097152) != 0;
    }
}
