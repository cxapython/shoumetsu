package com.google.android.gms.internal.gtm;

import android.content.Context;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.concurrent.ExecutorService;

/* loaded from: classes.dex */
public final class zzpa {
    private static final Integer a = 0;
    private static final Integer b = 1;
    private final Context c;
    private final ExecutorService d;

    public zzpa(Context context) {
        this(context, zzdf.zzgp().zzr(zzdi.zzadg));
    }

    @VisibleForTesting
    private zzpa(Context context, ExecutorService executorService) {
        this.c = context;
        this.d = executorService;
    }
}
