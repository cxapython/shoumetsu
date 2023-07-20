package com.google.android.gms.tagmanager;

import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.util.VisibleForTesting;

@ShowFirstParty
/* loaded from: classes.dex */
public final class zzdi {
    static int a;
    @VisibleForTesting
    private static bd b = new zzba();

    public static void setLogLevel(int i) {
        a = i;
        b.setLogLevel(i);
    }

    public static void zza(String str, Throwable th) {
        b.zza(str, th);
    }

    public static void zzab(String str) {
        b.zzab(str);
    }

    public static void zzac(String str) {
        b.zzac(str);
    }

    public static void zzav(String str) {
        b.zzav(str);
    }

    public static void zzaw(String str) {
        b.zzaw(str);
    }

    public static void zzax(String str) {
        b.zzax(str);
    }

    public static void zzb(String str, Throwable th) {
        b.zzb(str, th);
    }
}
