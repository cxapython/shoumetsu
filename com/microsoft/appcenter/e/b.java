package com.microsoft.appcenter.e;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.graphics.Point;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.view.Display;
import android.view.WindowManager;
import com.microsoft.appcenter.c.a.i;
import java.util.Locale;
import java.util.TimeZone;

/* loaded from: classes.dex */
public class b {
    private static i a;

    /* loaded from: classes.dex */
    public static class a extends Exception {
        public a(String str, Throwable th) {
            super(str, th);
        }
    }

    public static int a(PackageInfo packageInfo) {
        return packageInfo.versionCode;
    }

    public static synchronized com.microsoft.appcenter.c.a.c a(Context context) {
        com.microsoft.appcenter.c.a.c cVar;
        synchronized (b.class) {
            cVar = new com.microsoft.appcenter.c.a.c();
            try {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
                cVar.j(packageInfo.versionName);
                cVar.m(String.valueOf(a(packageInfo)));
                cVar.n(context.getPackageName());
                try {
                    TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                    String networkCountryIso = telephonyManager.getNetworkCountryIso();
                    if (!TextUtils.isEmpty(networkCountryIso)) {
                        cVar.l(networkCountryIso);
                    }
                    String networkOperatorName = telephonyManager.getNetworkOperatorName();
                    if (!TextUtils.isEmpty(networkOperatorName)) {
                        cVar.k(networkOperatorName);
                    }
                } catch (Exception e) {
                    com.microsoft.appcenter.e.a.b("AppCenter", "Cannot retrieve carrier info", e);
                }
                cVar.h(Locale.getDefault().toString());
                cVar.c(Build.MODEL);
                cVar.d(Build.MANUFACTURER);
                cVar.a(Integer.valueOf(Build.VERSION.SDK_INT));
                cVar.e("Android");
                cVar.f(Build.VERSION.RELEASE);
                cVar.g(Build.ID);
                try {
                    cVar.i(b(context));
                } catch (Exception e2) {
                    com.microsoft.appcenter.e.a.b("AppCenter", "Cannot retrieve screen size", e2);
                }
                cVar.a("appcenter.android");
                cVar.b("2.4.0");
                cVar.b(Integer.valueOf((TimeZone.getDefault().getOffset(System.currentTimeMillis()) / 60) / 1000));
                if (a != null) {
                    cVar.o(a.q());
                    cVar.p(a.r());
                    cVar.q(a.s());
                    cVar.r(a.t());
                    cVar.s(a.u());
                    cVar.t(a.v());
                }
            } catch (Exception e3) {
                com.microsoft.appcenter.e.a.b("AppCenter", "Cannot retrieve package info", e3);
                throw new a("Cannot retrieve package info", e3);
            }
        }
        return cVar;
    }

    @SuppressLint({"SwitchIntDef"})
    private static String b(Context context) {
        int i;
        int i2;
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getSize(point);
        int rotation = defaultDisplay.getRotation();
        if (rotation == 1 || rotation == 3) {
            int i3 = point.x;
            int i4 = point.y;
            i = i3;
            i2 = i4;
        } else {
            i2 = point.x;
            i = point.y;
        }
        return i2 + "x" + i;
    }
}
