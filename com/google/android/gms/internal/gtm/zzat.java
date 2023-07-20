package com.google.android.gms.internal.gtm;

import android.content.ComponentName;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.Collections;

@VisibleForTesting
/* loaded from: classes.dex */
public final class zzat extends zzan {
    private final zzav a;
    private zzce b;
    private final y c;
    private final ai d;

    public zzat(zzap zzapVar) {
        super(zzapVar);
        this.d = new ai(zzapVar.zzcn());
        this.a = new zzav(this);
        this.c = new i(this, zzapVar);
    }

    public final void a(ComponentName componentName) {
        com.google.android.gms.analytics.zzk.zzav();
        if (this.b != null) {
            this.b = null;
            zza("Disconnected from device AnalyticsService", componentName);
            i().zzck();
        }
    }

    public static /* synthetic */ void a(zzat zzatVar, ComponentName componentName) {
        zzatVar.a(componentName);
    }

    public static /* synthetic */ void a(zzat zzatVar, zzce zzceVar) {
        zzatVar.a(zzceVar);
    }

    public final void a(zzce zzceVar) {
        com.google.android.gms.analytics.zzk.zzav();
        this.b = zzceVar;
        b();
        i().b();
    }

    private final void b() {
        this.d.a();
        this.c.a(zzby.zzaaj.get().longValue());
    }

    public final void c() {
        com.google.android.gms.analytics.zzk.zzav();
        if (!isConnected()) {
            return;
        }
        zzq("Inactivity, disconnecting from device AnalyticsService");
        disconnect();
    }

    @Override // com.google.android.gms.internal.gtm.zzan
    protected final void a() {
    }

    public final boolean connect() {
        com.google.android.gms.analytics.zzk.zzav();
        q();
        if (this.b != null) {
            return true;
        }
        zzce zzdq = this.a.zzdq();
        if (zzdq == null) {
            return false;
        }
        this.b = zzdq;
        b();
        return true;
    }

    public final void disconnect() {
        com.google.android.gms.analytics.zzk.zzav();
        q();
        try {
            ConnectionTracker.getInstance().unbindService(e(), this.a);
        } catch (IllegalArgumentException | IllegalStateException unused) {
        }
        if (this.b != null) {
            this.b = null;
            i().zzck();
        }
    }

    public final boolean isConnected() {
        com.google.android.gms.analytics.zzk.zzav();
        q();
        return this.b != null;
    }

    public final boolean zzb(zzcd zzcdVar) {
        Preconditions.checkNotNull(zzcdVar);
        com.google.android.gms.analytics.zzk.zzav();
        q();
        zzce zzceVar = this.b;
        if (zzceVar == null) {
            return false;
        }
        try {
            zzceVar.zza(zzcdVar.zzdm(), zzcdVar.zzfh(), zzcdVar.zzfj() ? zzbq.zzet() : zzbq.zzeu(), Collections.emptyList());
            b();
            return true;
        } catch (RemoteException unused) {
            zzq("Failed to send hits to AnalyticsService");
            return false;
        }
    }

    public final boolean zzdn() {
        com.google.android.gms.analytics.zzk.zzav();
        q();
        zzce zzceVar = this.b;
        if (zzceVar == null) {
            return false;
        }
        try {
            zzceVar.zzch();
            b();
            return true;
        } catch (RemoteException unused) {
            zzq("Failed to clear hits from AnalyticsService");
            return false;
        }
    }
}
