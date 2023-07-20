package com.google.android.gms.internal.gtm;

import android.content.Context;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public final class zzoq {
    private final Context a;
    private final zzpa b;
    private final Clock c;
    private String d;
    @VisibleForTesting
    private Map<String, Object> e;
    private final Map<String, Object> f;

    public zzoq(Context context) {
        this(context, new HashMap(), new zzpa(context), DefaultClock.getInstance());
    }

    @VisibleForTesting
    private zzoq(Context context, Map<String, Object> map, zzpa zzpaVar, Clock clock) {
        this.d = null;
        this.e = new HashMap();
        this.a = context;
        this.c = clock;
        this.b = zzpaVar;
        this.f = map;
    }

    public final void zzcr(String str) {
        this.d = str;
    }
}
