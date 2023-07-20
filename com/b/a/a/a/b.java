package com.b.a.a.a;

import android.content.Context;
import android.content.pm.PackageManager;

/* loaded from: classes.dex */
public abstract class b {
    /* JADX INFO: Access modifiers changed from: protected */
    public boolean b(Context context) {
        try {
            context.getPackageManager().getApplicationInfo("com.kddi.market", 0);
            return true;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }
}
