package com.c.a.a;

import android.annotation.TargetApi;
import android.os.Build;
import android.util.Log;

/* loaded from: classes.dex */
public class g implements h {
    boolean a = true;
    int b = 2;

    @TargetApi(8)
    private void c(String str, String str2, Throwable th) {
        Log.wtf(str, str2, th);
    }

    public void a(int i, String str, String str2) {
        a(i, str, str2, null);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public void a(int i, String str, String str2, Throwable th) {
        if (!a() || !a(i)) {
            return;
        }
        switch (i) {
            case 2:
                Log.v(str, str2, th);
                return;
            case 3:
                Log.d(str, str2, th);
                return;
            case 4:
                Log.i(str, str2, th);
                return;
            case 5:
                Log.w(str, str2, th);
                return;
            case 6:
                break;
            case 7:
            default:
                return;
            case 8:
                if (Integer.valueOf(Build.VERSION.SDK).intValue() > 8) {
                    c(str, str2, th);
                    return;
                }
                break;
        }
        Log.e(str, str2, th);
    }

    @Override // com.c.a.a.h
    public void a(String str, String str2) {
        a(2, str, str2);
    }

    @Override // com.c.a.a.h
    public void a(String str, String str2, Throwable th) {
        a(5, str, str2, th);
    }

    public boolean a() {
        return this.a;
    }

    public boolean a(int i) {
        return i >= this.b;
    }

    @Override // com.c.a.a.h
    public void b(String str, String str2) {
        a(2, str, str2);
    }

    @Override // com.c.a.a.h
    public void b(String str, String str2, Throwable th) {
        a(6, str, str2, th);
    }

    @Override // com.c.a.a.h
    public void c(String str, String str2) {
        a(5, str, str2);
    }

    @Override // com.c.a.a.h
    public void d(String str, String str2) {
        a(6, str, str2);
    }
}
