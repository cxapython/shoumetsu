package com.google.android.gms.common.logging;

import android.util.Log;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.GmsLogger;
import cz.msebera.android.httpclient.message.TokenParser;
import java.util.Locale;

@KeepForSdk
/* loaded from: classes.dex */
public class Logger {
    private final String a;
    private final String b;
    private final GmsLogger c;
    private final int d;

    private Logger(String str, String str2) {
        this.b = str2;
        this.a = str;
        this.c = new GmsLogger(str);
        int i = 2;
        while (7 >= i && !Log.isLoggable(this.a, i)) {
            i++;
        }
        this.d = i;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    @KeepForSdk
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Logger(String str, String... strArr) {
        this(str, r8);
        String sb;
        if (strArr.length == 0) {
            sb = "";
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append('[');
            for (String str2 : strArr) {
                if (sb2.length() > 1) {
                    sb2.append(",");
                }
                sb2.append(str2);
            }
            sb2.append(']');
            sb2.append(TokenParser.SP);
            sb = sb2.toString();
        }
    }

    private final String a(String str, Object... objArr) {
        if (objArr != null && objArr.length > 0) {
            str = String.format(Locale.US, str, objArr);
        }
        return this.b.concat(str);
    }

    @KeepForSdk
    public void d(String str, Object... objArr) {
        if (isLoggable(3)) {
            Log.d(this.a, a(str, objArr));
        }
    }

    @KeepForSdk
    public void e(String str, Throwable th, Object... objArr) {
        Log.e(this.a, a(str, objArr), th);
    }

    @KeepForSdk
    public void e(String str, Object... objArr) {
        Log.e(this.a, a(str, objArr));
    }

    @KeepForSdk
    public void i(String str, Object... objArr) {
        Log.i(this.a, a(str, objArr));
    }

    @KeepForSdk
    public boolean isLoggable(int i) {
        return this.d <= i;
    }

    @KeepForSdk
    public void v(String str, Object... objArr) {
        if (isLoggable(2)) {
            Log.v(this.a, a(str, objArr));
        }
    }

    @KeepForSdk
    public void w(String str, Object... objArr) {
        Log.w(this.a, a(str, objArr));
    }

    @KeepForSdk
    public void wtf(String str, Throwable th, Object... objArr) {
        Log.wtf(this.a, a(str, objArr), th);
    }

    @KeepForSdk
    public void wtf(Throwable th) {
        Log.wtf(this.a, th);
    }
}
