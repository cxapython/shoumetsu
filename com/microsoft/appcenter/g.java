package com.microsoft.appcenter;

/* loaded from: classes.dex */
public final class g {
    public static int a(int i, boolean z) {
        int i2 = i & 255;
        if (i2 == 1 || i2 == 2) {
            return i2;
        }
        if (i2 != 0 && z) {
            com.microsoft.appcenter.e.a.d("AppCenter", "Invalid value=" + i2 + " for persistence flag, using NORMAL as a default.");
        }
        return 1;
    }
}
