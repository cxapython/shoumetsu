package com.amazon.device.iap.internal.a;

import android.util.Log;

/* loaded from: classes.dex */
public class a implements com.amazon.device.iap.internal.a {
    private static String a(String str) {
        return "In App Purchasing SDK - Sandbox Mode: " + str;
    }

    @Override // com.amazon.device.iap.internal.a
    public void a(String str, String str2) {
        Log.d(str, a(str2));
    }

    @Override // com.amazon.device.iap.internal.a
    public boolean a() {
        return true;
    }

    @Override // com.amazon.device.iap.internal.a
    public void b(String str, String str2) {
        Log.e(str, a(str2));
    }

    @Override // com.amazon.device.iap.internal.a
    public boolean b() {
        return true;
    }
}
