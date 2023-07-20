package com.google.android.gms.common.config;

import android.content.Context;
import android.os.Binder;
import android.os.StrictMode;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.HashSet;
import javax.annotation.concurrent.GuardedBy;

@KeepForSdk
/* loaded from: classes.dex */
public abstract class GservicesValue<T> {
    private static final Object c = new Object();
    private static a d = null;
    private static int e = 0;
    private static Context f;
    @GuardedBy("sLock")
    private static HashSet<String> g;
    protected final String a;
    protected final T b;
    private T h = null;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public interface a {
        Boolean a(String str, Boolean bool);

        Float a(String str, Float f);

        Integer a(String str, Integer num);

        Long a(String str, Long l);

        String a(String str, String str2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public GservicesValue(String str, T t) {
        this.a = str;
        this.b = t;
    }

    private static boolean a() {
        synchronized (c) {
        }
        return false;
    }

    @KeepForSdk
    public static boolean isInitialized() {
        synchronized (c) {
        }
        return false;
    }

    @KeepForSdk
    public static GservicesValue<Float> value(String str, Float f2) {
        return new d(str, f2);
    }

    @KeepForSdk
    public static GservicesValue<Integer> value(String str, Integer num) {
        return new c(str, num);
    }

    @KeepForSdk
    public static GservicesValue<Long> value(String str, Long l) {
        return new b(str, l);
    }

    @KeepForSdk
    public static GservicesValue<String> value(String str, String str2) {
        return new e(str, str2);
    }

    @KeepForSdk
    public static GservicesValue<Boolean> value(String str, boolean z) {
        return new com.google.android.gms.common.config.a(str, Boolean.valueOf(z));
    }

    protected abstract T a(String str);

    @KeepForSdk
    public final T get() {
        T t = this.h;
        if (t != null) {
            return t;
        }
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        synchronized (c) {
        }
        synchronized (c) {
            g = null;
            f = null;
        }
        try {
            try {
                return a(this.a);
            } finally {
                StrictMode.setThreadPolicy(allowThreadDiskReads);
            }
        } catch (SecurityException unused) {
            long clearCallingIdentity = Binder.clearCallingIdentity();
            T a2 = a(this.a);
            Binder.restoreCallingIdentity(clearCallingIdentity);
            return a2;
        }
    }

    @KeepForSdk
    @Deprecated
    public final T getBinderSafe() {
        return get();
    }

    @VisibleForTesting
    @KeepForSdk
    public void override(T t) {
        Log.w("GservicesValue", "GservicesValue.override(): test should probably call initForTests() first");
        this.h = t;
        synchronized (c) {
            a();
        }
    }

    @VisibleForTesting
    @KeepForSdk
    public void resetOverride() {
        this.h = null;
    }
}
