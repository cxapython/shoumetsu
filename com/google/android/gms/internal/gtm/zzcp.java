package com.google.android.gms.internal.gtm;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.stats.WakeLock;

/* loaded from: classes.dex */
public final class zzcp {
    static Object a = new Object();
    static WakeLock b;
    private static Boolean c;

    public static void onReceive(Context context, Intent intent) {
        zzci zzco = zzap.zzc(context).zzco();
        if (intent == null) {
            zzco.zzt("AnalyticsReceiver called with null intent");
            return;
        }
        String action = intent.getAction();
        zzco.zza("Local AnalyticsReceiver got", action);
        if (!"com.google.android.gms.analytics.ANALYTICS_DISPATCH".equals(action)) {
            return;
        }
        boolean zze = zzcq.zze(context);
        Intent intent2 = new Intent("com.google.android.gms.analytics.ANALYTICS_DISPATCH");
        intent2.setComponent(new ComponentName(context, "com.google.android.gms.analytics.AnalyticsService"));
        intent2.setAction("com.google.android.gms.analytics.ANALYTICS_DISPATCH");
        synchronized (a) {
            context.startService(intent2);
            if (!zze) {
                return;
            }
            try {
                if (b == null) {
                    WakeLock wakeLock = new WakeLock(context, 1, "Analytics WakeLock");
                    b = wakeLock;
                    wakeLock.setReferenceCounted(false);
                }
                b.acquire(1000L);
            } catch (SecurityException unused) {
                zzco.zzt("Analytics service at risk of not starting. For more reliable analytics, add the WAKE_LOCK permission to your manifest. See http://goo.gl/8Rd3yj for instructions.");
            }
        }
    }

    public static boolean zza(Context context) {
        Preconditions.checkNotNull(context);
        Boolean bool = c;
        if (bool != null) {
            return bool.booleanValue();
        }
        boolean zza = zzcz.zza(context, "com.google.android.gms.analytics.AnalyticsReceiver", false);
        c = Boolean.valueOf(zza);
        return zza;
    }
}
