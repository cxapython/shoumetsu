package com.google.android.gms.common.wrappers;

import android.annotation.TargetApi;
import android.app.AppOpsManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Binder;
import android.os.Process;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.util.PlatformVersion;

@KeepForSdk
/* loaded from: classes.dex */
public class PackageManagerWrapper {
    private final Context a;

    public PackageManagerWrapper(Context context) {
        this.a = context;
    }

    @KeepForSdk
    public int checkCallingOrSelfPermission(String str) {
        return this.a.checkCallingOrSelfPermission(str);
    }

    @KeepForSdk
    public int checkPermission(String str, String str2) {
        return this.a.getPackageManager().checkPermission(str, str2);
    }

    @KeepForSdk
    public ApplicationInfo getApplicationInfo(String str, int i) {
        return this.a.getPackageManager().getApplicationInfo(str, i);
    }

    @KeepForSdk
    public CharSequence getApplicationLabel(String str) {
        return this.a.getPackageManager().getApplicationLabel(this.a.getPackageManager().getApplicationInfo(str, 0));
    }

    @KeepForSdk
    public PackageInfo getPackageInfo(String str, int i) {
        return this.a.getPackageManager().getPackageInfo(str, i);
    }

    public final String[] getPackagesForUid(int i) {
        return this.a.getPackageManager().getPackagesForUid(i);
    }

    @KeepForSdk
    public boolean isCallerInstantApp() {
        String nameForUid;
        if (Binder.getCallingUid() == Process.myUid()) {
            return InstantApps.isInstantApp(this.a);
        }
        if (PlatformVersion.isAtLeastO() && (nameForUid = this.a.getPackageManager().getNameForUid(Binder.getCallingUid())) != null) {
            return this.a.getPackageManager().isInstantApp(nameForUid);
        }
        return false;
    }

    public final PackageInfo zza(String str, int i, int i2) {
        return this.a.getPackageManager().getPackageInfo(str, 64);
    }

    @TargetApi(19)
    public final boolean zzb(int i, String str) {
        if (PlatformVersion.isAtLeastKitKat()) {
            try {
                ((AppOpsManager) this.a.getSystemService("appops")).checkPackage(i, str);
                return true;
            } catch (SecurityException unused) {
                return false;
            }
        }
        String[] packagesForUid = this.a.getPackageManager().getPackagesForUid(i);
        if (str != null && packagesForUid != null) {
            for (String str2 : packagesForUid) {
                if (str.equals(str2)) {
                    return true;
                }
            }
        }
        return false;
    }
}
