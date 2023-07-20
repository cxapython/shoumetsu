package com.google.android.gms.common.internal;

import android.util.Log;
import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
/* loaded from: classes.dex */
public final class GmsLogger {
    private static final int a = 15;
    private static final String b = null;
    private final String c;
    private final String d;

    public GmsLogger(String str) {
        this(str, null);
    }

    public GmsLogger(String str, String str2) {
        Preconditions.checkNotNull(str, "log tag cannot be null");
        Preconditions.checkArgument(str.length() <= 23, "tag \"%s\" is longer than the %d character maximum", str, 23);
        this.c = str;
        if (str2 == null || str2.length() <= 0) {
            this.d = null;
        } else {
            this.d = str2;
        }
    }

    private final String a(String str) {
        String str2 = this.d;
        return str2 == null ? str : str2.concat(str);
    }

    private final String a(String str, Object... objArr) {
        String format = String.format(str, objArr);
        String str2 = this.d;
        return str2 == null ? format : str2.concat(format);
    }

    @KeepForSdk
    public final boolean canLog(int i) {
        return Log.isLoggable(this.c, i);
    }

    @KeepForSdk
    public final boolean canLogPii() {
        return false;
    }

    @KeepForSdk
    public final void d(String str, String str2) {
        if (canLog(3)) {
            Log.d(str, a(str2));
        }
    }

    @KeepForSdk
    public final void d(String str, String str2, Throwable th) {
        if (canLog(3)) {
            Log.d(str, a(str2), th);
        }
    }

    @KeepForSdk
    public final void e(String str, String str2) {
        if (canLog(6)) {
            Log.e(str, a(str2));
        }
    }

    @KeepForSdk
    public final void e(String str, String str2, Throwable th) {
        if (canLog(6)) {
            Log.e(str, a(str2), th);
        }
    }

    @KeepForSdk
    public final void efmt(String str, String str2, Object... objArr) {
        if (canLog(6)) {
            Log.e(str, a(str2, objArr));
        }
    }

    @KeepForSdk
    public final void i(String str, String str2) {
        if (canLog(4)) {
            Log.i(str, a(str2));
        }
    }

    @KeepForSdk
    public final void i(String str, String str2, Throwable th) {
        if (canLog(4)) {
            Log.i(str, a(str2), th);
        }
    }

    @KeepForSdk
    public final void pii(String str, String str2) {
        if (canLogPii()) {
            String valueOf = String.valueOf(str);
            String valueOf2 = String.valueOf(" PII_LOG");
            Log.i(valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf), a(str2));
        }
    }

    @KeepForSdk
    public final void pii(String str, String str2, Throwable th) {
        if (canLogPii()) {
            String valueOf = String.valueOf(str);
            String valueOf2 = String.valueOf(" PII_LOG");
            Log.i(valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf), a(str2), th);
        }
    }

    @KeepForSdk
    public final void v(String str, String str2) {
        if (canLog(2)) {
            Log.v(str, a(str2));
        }
    }

    @KeepForSdk
    public final void v(String str, String str2, Throwable th) {
        if (canLog(2)) {
            Log.v(str, a(str2), th);
        }
    }

    @KeepForSdk
    public final void w(String str, String str2) {
        if (canLog(5)) {
            Log.w(str, a(str2));
        }
    }

    @KeepForSdk
    public final void w(String str, String str2, Throwable th) {
        if (canLog(5)) {
            Log.w(str, a(str2), th);
        }
    }

    @KeepForSdk
    public final void wfmt(String str, String str2, Object... objArr) {
        if (canLog(5)) {
            Log.w(this.c, a(str2, objArr));
        }
    }

    @KeepForSdk
    public final void wtf(String str, String str2, Throwable th) {
        if (canLog(7)) {
            Log.e(str, a(str2), th);
            Log.wtf(str, a(str2), th);
        }
    }
}
