package com.google.android.gms.games.internal;

import com.google.android.gms.common.config.GservicesValue;
import com.google.android.gms.common.internal.GmsLogger;

/* loaded from: classes.dex */
public final class zzbd {
    private static final GmsLogger a = new GmsLogger("Games");
    private static final GservicesValue<Boolean> b = GservicesValue.value("games.play_games_dogfood", false);

    public static void e(String str, String str2) {
        a.e(str, str2);
    }

    public static void e(String str, String str2, Throwable th) {
        a.e(str, str2, th);
    }

    public static void i(String str, String str2, Throwable th) {
        a.i(str, str2, th);
    }

    public static void w(String str, String str2) {
        a.w(str, str2);
    }

    public static void w(String str, String str2, Throwable th) {
        a.w(str, str2, th);
    }
}
