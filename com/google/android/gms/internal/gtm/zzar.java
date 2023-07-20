package com.google.android.gms.internal.gtm;

import android.content.Context;
import com.google.android.gms.common.internal.Preconditions;

/* loaded from: classes.dex */
public final class zzar {
    private final Context a;
    private final Context b;

    public zzar(Context context) {
        Preconditions.checkNotNull(context);
        Context applicationContext = context.getApplicationContext();
        Preconditions.checkNotNull(applicationContext, "Application context can't be null");
        this.a = applicationContext;
        this.b = applicationContext;
    }

    public final Context getApplicationContext() {
        return this.a;
    }

    public final Context zzdc() {
        return this.b;
    }
}
