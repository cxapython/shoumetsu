package com.google.android.gms.common.internal;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

@KeepForSdk
/* loaded from: classes.dex */
public abstract class DowngradeableSafeParcel extends AbstractSafeParcelable implements ReflectedParcelable {
    private static final Object a = new Object();
    private static ClassLoader b = null;
    private static Integer c = null;
    private boolean d = false;

    /* JADX INFO: Access modifiers changed from: protected */
    @KeepForSdk
    public static Integer a() {
        synchronized (a) {
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @KeepForSdk
    public static boolean a(String str) {
        c();
        return true;
    }

    private static ClassLoader c() {
        synchronized (a) {
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @KeepForSdk
    public boolean b() {
        return this.d;
    }

    @KeepForSdk
    public void setShouldDowngrade(boolean z) {
        this.d = z;
    }
}
