package com.google.android.gms.internal.gtm;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.common.internal.Preconditions;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* loaded from: classes.dex */
public final class zzae extends zzan {
    private final n a;

    public zzae(zzap zzapVar, zzar zzarVar) {
        super(zzapVar);
        Preconditions.checkNotNull(zzarVar);
        this.a = new n(zzapVar, zzarVar);
    }

    @Override // com.google.android.gms.internal.gtm.zzan
    protected final void a() {
        this.a.zzag();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b() {
        com.google.android.gms.analytics.zzk.zzav();
        this.a.s();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void c() {
        com.google.android.gms.analytics.zzk.zzav();
        this.a.r();
    }

    public final void setLocalDispatchPeriod(int i) {
        q();
        zzb("setLocalDispatchPeriod (sec)", Integer.valueOf(i));
        h().zza(new a(this, i));
    }

    public final void start() {
        this.a.b();
    }

    public final long zza(zzas zzasVar) {
        q();
        Preconditions.checkNotNull(zzasVar);
        com.google.android.gms.analytics.zzk.zzav();
        long a = this.a.a(zzasVar, true);
        if (a == 0) {
            this.a.a(zzasVar);
        }
        return a;
    }

    public final void zza(zzbw zzbwVar) {
        q();
        h().zza(new f(this, zzbwVar));
    }

    public final void zza(zzcd zzcdVar) {
        Preconditions.checkNotNull(zzcdVar);
        q();
        zzb("Hit delivery requested", zzcdVar);
        h().zza(new d(this, zzcdVar));
    }

    public final void zza(String str, Runnable runnable) {
        Preconditions.checkNotEmpty(str, "campaign param can't be empty");
        h().zza(new c(this, str, runnable));
    }

    public final void zzch() {
        q();
        h().zza(new e(this));
    }

    public final void zzci() {
        q();
        Context e = e();
        if (!zzcp.zza(e) || !zzcq.zze(e)) {
            zza((zzbw) null);
            return;
        }
        Intent intent = new Intent("com.google.android.gms.analytics.ANALYTICS_DISPATCH");
        intent.setComponent(new ComponentName(e, "com.google.android.gms.analytics.AnalyticsService"));
        e.startService(intent);
    }

    public final boolean zzcj() {
        q();
        try {
            h().zza(new g(this)).get(4L, TimeUnit.SECONDS);
            return true;
        } catch (InterruptedException e) {
            zzd("syncDispatchLocalHits interrupted", e);
            return false;
        } catch (ExecutionException e2) {
            zze("syncDispatchLocalHits failed", e2);
            return false;
        } catch (TimeoutException e3) {
            zzd("syncDispatchLocalHits timed out", e3);
            return false;
        }
    }

    public final void zzck() {
        q();
        com.google.android.gms.analytics.zzk.zzav();
        n nVar = this.a;
        com.google.android.gms.analytics.zzk.zzav();
        nVar.q();
        nVar.zzq("Service disconnected");
    }
}
