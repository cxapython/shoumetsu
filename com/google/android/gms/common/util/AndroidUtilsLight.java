package com.google.android.gms.common.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageInfo;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.common.zzg;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@KeepForSdk
/* loaded from: classes.dex */
public class AndroidUtilsLight {
    private static volatile int a = -1;

    @KeepForSdk
    @TargetApi(24)
    @Deprecated
    public static Context getDeviceProtectedStorageContext(Context context) {
        return zzg.zzam() ? zzg.getDeviceProtectedStorageContext(context) : context;
    }

    @KeepForSdk
    public static byte[] getPackageCertificateHashBytes(Context context, String str) {
        MessageDigest zzj;
        PackageInfo packageInfo = Wrappers.packageManager(context).getPackageInfo(str, 64);
        if (packageInfo.signatures == null || packageInfo.signatures.length != 1 || (zzj = zzj("SHA1")) == null) {
            return null;
        }
        return zzj.digest(packageInfo.signatures[0].toByteArray());
    }

    public static MessageDigest zzj(String str) {
        MessageDigest messageDigest;
        for (int i = 0; i < 2; i++) {
            try {
                messageDigest = MessageDigest.getInstance(str);
            } catch (NoSuchAlgorithmException unused) {
            }
            if (messageDigest != null) {
                return messageDigest;
            }
        }
        return null;
    }
}
