package com.google.android.gms.analytics;

import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.gtm.zzch;

@VisibleForTesting
/* loaded from: classes.dex */
public final class zzd {
    private static String a(String str, int i) {
        if (i <= 0) {
            zzch.zzf("index out of range for prefix", str);
            return "";
        }
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 11);
        sb.append(str);
        sb.append(i);
        return sb.toString();
    }

    public static String zzd(int i) {
        return a("&cd", i);
    }

    public static String zze(int i) {
        return a("cd", i);
    }

    public static String zzf(int i) {
        return a("&cm", i);
    }

    public static String zzg(int i) {
        return a("cm", i);
    }

    public static String zzh(int i) {
        return a("&pr", i);
    }

    public static String zzi(int i) {
        return a("pr", i);
    }

    public static String zzj(int i) {
        return a("&promo", i);
    }

    public static String zzk(int i) {
        return a("promo", i);
    }

    public static String zzl(int i) {
        return a("pi", i);
    }

    public static String zzm(int i) {
        return a("&il", i);
    }

    public static String zzn(int i) {
        return a("il", i);
    }

    public static String zzo(int i) {
        return a("cd", i);
    }

    public static String zzp(int i) {
        return a("cm", i);
    }
}
