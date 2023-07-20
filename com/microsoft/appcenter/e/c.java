package com.microsoft.appcenter.e;

import android.os.Handler;
import android.os.Looper;

/* loaded from: classes.dex */
public class c {
    static final Handler a = new Handler(Looper.getMainLooper());

    public static void a(Runnable runnable) {
        if (Thread.currentThread() == a.getLooper().getThread()) {
            runnable.run();
        } else {
            a.post(runnable);
        }
    }
}
