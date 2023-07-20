package com.google.android.gms.internal.gtm;

import android.content.pm.ApplicationInfo;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.ProcessUtils;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes.dex */
public final class zzbq {
    private final zzap a;
    private volatile Boolean b;
    private String c;
    private Set<Integer> d;

    /* JADX INFO: Access modifiers changed from: protected */
    public zzbq(zzap zzapVar) {
        Preconditions.checkNotNull(zzapVar);
        this.a = zzapVar;
    }

    public static boolean zzen() {
        return zzby.zzza.get().booleanValue();
    }

    public static int zzeo() {
        return zzby.zzzx.get().intValue();
    }

    public static long zzep() {
        return zzby.zzzi.get().longValue();
    }

    public static long zzeq() {
        return zzby.zzzl.get().longValue();
    }

    public static int zzer() {
        return zzby.zzzn.get().intValue();
    }

    public static int zzes() {
        return zzby.zzzo.get().intValue();
    }

    @VisibleForTesting
    public static String zzet() {
        return zzby.zzzq.get();
    }

    @VisibleForTesting
    public static String zzeu() {
        return zzby.zzzp.get();
    }

    public static String zzev() {
        return zzby.zzzr.get();
    }

    public static long zzex() {
        return zzby.zzaaf.get().longValue();
    }

    public final boolean zzem() {
        if (this.b == null) {
            synchronized (this) {
                if (this.b == null) {
                    ApplicationInfo applicationInfo = this.a.getContext().getApplicationInfo();
                    String myProcessName = ProcessUtils.getMyProcessName();
                    if (applicationInfo != null) {
                        String str = applicationInfo.processName;
                        this.b = Boolean.valueOf(str != null && str.equals(myProcessName));
                    }
                    if ((this.b == null || !this.b.booleanValue()) && "com.google.android.gms.analytics".equals(myProcessName)) {
                        this.b = Boolean.TRUE;
                    }
                    if (this.b == null) {
                        this.b = Boolean.TRUE;
                        this.a.zzco().zzu("My process not in the list of running processes");
                    }
                }
            }
        }
        return this.b.booleanValue();
    }

    public final Set<Integer> zzew() {
        String str;
        String str2 = zzby.zzaaa.get();
        if (this.d == null || (str = this.c) == null || !str.equals(str2)) {
            String[] split = TextUtils.split(str2, ",");
            HashSet hashSet = new HashSet();
            for (String str3 : split) {
                try {
                    hashSet.add(Integer.valueOf(Integer.parseInt(str3)));
                } catch (NumberFormatException unused) {
                }
            }
            this.c = str2;
            this.d = hashSet;
        }
        return this.d;
    }
}
