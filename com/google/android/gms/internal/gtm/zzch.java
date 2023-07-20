package com.google.android.gms.internal.gtm;

import android.annotation.SuppressLint;
import android.util.Log;
import com.google.android.gms.analytics.Logger;
import com.google.android.gms.common.util.VisibleForTesting;

@VisibleForTesting
@Deprecated
/* loaded from: classes.dex */
public final class zzch {
    private static volatile Logger a = new x();

    private static boolean a(int i) {
        return a != null && a.getLogLevel() <= i;
    }

    @VisibleForTesting
    public static Logger getLogger() {
        return a;
    }

    @VisibleForTesting
    public static void setLogger(Logger logger) {
        a = logger;
    }

    @SuppressLint({"LogTagMismatch"})
    public static void zzab(String str) {
        zzci zzfn = zzci.zzfn();
        if (zzfn != null) {
            zzfn.zzq(str);
        } else if (a(0)) {
            Log.v(zzby.zzzb.get(), str);
        }
        Logger logger = a;
        if (logger != null) {
            logger.verbose(str);
        }
    }

    @SuppressLint({"LogTagMismatch"})
    public static void zzac(String str) {
        zzci zzfn = zzci.zzfn();
        if (zzfn != null) {
            zzfn.zzt(str);
        } else if (a(2)) {
            Log.w(zzby.zzzb.get(), str);
        }
        Logger logger = a;
        if (logger != null) {
            logger.warn(str);
        }
    }

    @SuppressLint({"LogTagMismatch"})
    public static void zzf(String str, Object obj) {
        String str2;
        zzci zzfn = zzci.zzfn();
        if (zzfn != null) {
            zzfn.zze(str, obj);
        } else if (a(3)) {
            if (obj != null) {
                String valueOf = String.valueOf(obj);
                StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 1 + String.valueOf(valueOf).length());
                sb.append(str);
                sb.append(":");
                sb.append(valueOf);
                str2 = sb.toString();
            } else {
                str2 = str;
            }
            Log.e(zzby.zzzb.get(), str2);
        }
        Logger logger = a;
        if (logger != null) {
            logger.error(str);
        }
    }
}
