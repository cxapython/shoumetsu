package com.microsoft.appcenter.e;

import android.os.Process;

/* loaded from: classes.dex */
public class g {
    public static void a(int i) {
        Process.killProcess(Process.myPid());
        System.exit(i);
    }
}
