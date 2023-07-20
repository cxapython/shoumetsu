package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.content.ContextWrapper;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;

@KeepForSdk
/* loaded from: classes.dex */
public class LifecycleActivity {
    private final Object a;

    public LifecycleActivity(Activity activity) {
        Preconditions.checkNotNull(activity, "Activity must not be null");
        this.a = activity;
    }

    @KeepForSdk
    public LifecycleActivity(ContextWrapper contextWrapper) {
        throw new UnsupportedOperationException();
    }

    @KeepForSdk
    public Activity asActivity() {
        return (Activity) this.a;
    }

    @KeepForSdk
    public androidx.e.a.e asFragmentActivity() {
        return (androidx.e.a.e) this.a;
    }

    @KeepForSdk
    public Object asObject() {
        return this.a;
    }

    @KeepForSdk
    public boolean isChimera() {
        return false;
    }

    @KeepForSdk
    public boolean isSupport() {
        return this.a instanceof androidx.e.a.e;
    }

    public final boolean zzh() {
        return this.a instanceof Activity;
    }
}
