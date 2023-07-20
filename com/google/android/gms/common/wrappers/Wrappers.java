package com.google.android.gms.common.wrappers;

import android.content.Context;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.util.VisibleForTesting;

@KeepForSdk
/* loaded from: classes.dex */
public class Wrappers {
    private static Wrappers b = new Wrappers();
    private PackageManagerWrapper a = null;

    @VisibleForTesting
    private final synchronized PackageManagerWrapper a(Context context) {
        if (this.a == null) {
            if (context.getApplicationContext() != null) {
                context = context.getApplicationContext();
            }
            this.a = new PackageManagerWrapper(context);
        }
        return this.a;
    }

    @KeepForSdk
    public static PackageManagerWrapper packageManager(Context context) {
        return b.a(context);
    }
}
