package com.google.android.gms.tagmanager;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import com.adjust.sdk.Constants;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.HashMap;
import java.util.Map;

@ShowFirstParty
@VisibleForTesting
/* loaded from: classes.dex */
public class zzcw {
    @VisibleForTesting
    static Map<String, String> a = new HashMap();
    private static String b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Context context, String str) {
        dl.a(context, "gtm_install_referrer", Constants.REFERRER, str);
        zzf(context, str);
    }

    public static void zzbe(String str) {
        synchronized (zzcw.class) {
            b = str;
        }
    }

    public static String zze(Context context, String str) {
        if (b == null) {
            synchronized (zzcw.class) {
                if (b == null) {
                    SharedPreferences sharedPreferences = context.getSharedPreferences("gtm_install_referrer", 0);
                    b = sharedPreferences != null ? sharedPreferences.getString(Constants.REFERRER, "") : "";
                }
            }
        }
        return zze(b, str);
    }

    public static String zze(String str, String str2) {
        if (str2 != null) {
            String valueOf = String.valueOf(str);
            return Uri.parse(valueOf.length() != 0 ? "http://hostname/?".concat(valueOf) : new String("http://hostname/?")).getQueryParameter(str2);
        } else if (str.length() <= 0) {
            return null;
        } else {
            return str;
        }
    }

    public static void zzf(Context context, String str) {
        String zze = zze(str, "conv");
        if (zze == null || zze.length() <= 0) {
            return;
        }
        a.put(zze, str);
        dl.a(context, "gtm_click_referrers", zze, str);
    }
}
