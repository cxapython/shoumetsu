package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.gtm.zzk;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class cl implements g {
    private final String a;
    private final Context b;
    private final ScheduledExecutorService c;
    private final co d;
    private ScheduledFuture<?> e;
    private boolean f;
    private k g;
    private String h;
    private bc<zzk> i;

    public cl(Context context, String str, k kVar) {
        this(context, str, kVar, null, null);
    }

    @VisibleForTesting
    private cl(Context context, String str, k kVar, cp cpVar, co coVar) {
        this.g = kVar;
        this.b = context;
        this.a = str;
        this.c = new cm(this).a();
        this.d = new cn(this);
    }

    private final synchronized void a() {
        if (this.f) {
            throw new IllegalStateException("called method after closed");
        }
    }

    @Override // com.google.android.gms.tagmanager.g
    public final synchronized void a(long j, String str) {
        String str2 = this.a;
        StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 55);
        sb.append("loadAfterDelay: containerId=");
        sb.append(str2);
        sb.append(" delay=");
        sb.append(j);
        zzdi.zzab(sb.toString());
        a();
        if (this.i == null) {
            throw new IllegalStateException("callback must be set before loadAfterDelay() is called.");
        }
        if (this.e != null) {
            this.e.cancel(false);
        }
        ScheduledExecutorService scheduledExecutorService = this.c;
        ck a = this.d.a(this.g);
        a.a(this.i);
        a.a(this.h);
        a.b(str);
        this.e = scheduledExecutorService.schedule(a, j, TimeUnit.MILLISECONDS);
    }

    @Override // com.google.android.gms.tagmanager.g
    public final synchronized void a(bc<zzk> bcVar) {
        a();
        this.i = bcVar;
    }

    @Override // com.google.android.gms.tagmanager.g
    public final synchronized void a(String str) {
        a();
        this.h = str;
    }

    @Override // com.google.android.gms.common.api.Releasable
    public final synchronized void release() {
        a();
        if (this.e != null) {
            this.e.cancel(false);
        }
        this.c.shutdown();
        this.f = true;
    }
}
