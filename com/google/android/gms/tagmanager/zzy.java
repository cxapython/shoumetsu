package com.google.android.gms.tagmanager;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BasePendingResult;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.gtm.zzi;
import com.google.android.gms.internal.gtm.zzk;
import com.google.android.gms.internal.gtm.zzop;
import com.google.android.gms.internal.gtm.zzoq;
import com.google.android.gms.internal.gtm.zzov;
import com.google.android.gms.tagmanager.ca;

@ShowFirstParty
/* loaded from: classes.dex */
public final class zzy extends BasePendingResult<ContainerHolder> {
    private final Clock b;
    private final f c;
    private final Looper d;
    private final cc e;
    private final int f;
    private final Context g;
    private final TagManager h;
    private final String i;
    private final zzai j;
    private h k;
    private zzoq l;
    private volatile eo m;
    private volatile boolean n;
    private zzk o;
    private long p;
    private String q;
    private g r;
    private c s;

    @VisibleForTesting
    private zzy(Context context, TagManager tagManager, Looper looper, String str, int i, h hVar, g gVar, zzoq zzoqVar, Clock clock, cc ccVar, zzai zzaiVar) {
        super(looper == null ? Looper.getMainLooper() : looper);
        this.g = context;
        this.h = tagManager;
        this.d = looper == null ? Looper.getMainLooper() : looper;
        this.i = str;
        this.f = i;
        this.k = hVar;
        this.r = gVar;
        this.l = zzoqVar;
        this.c = new f(this, null);
        this.o = new zzk();
        this.b = clock;
        this.e = ccVar;
        this.j = zzaiVar;
        if (b()) {
            a(ca.a().c());
        }
    }

    public zzy(Context context, TagManager tagManager, Looper looper, String str, int i, k kVar) {
        this(context, tagManager, looper, str, i, new cq(context, str), new cl(context, str, kVar), new zzoq(context), DefaultClock.getInstance(), new bb(1, 5, 900000L, 5000L, "refreshing", DefaultClock.getInstance()), new zzai(context, str));
        this.l.zzcr(kVar.a());
    }

    public final synchronized void a(long j) {
        if (this.r == null) {
            zzdi.zzac("Refresh requested, but no network load scheduler.");
        } else {
            this.r.a(j, this.o.zzql);
        }
    }

    public final synchronized void a(zzk zzkVar) {
        if (this.k != null) {
            zzop zzopVar = new zzop();
            zzopVar.zzaux = this.p;
            zzopVar.zzqk = new zzi();
            zzopVar.zzauy = zzkVar;
            this.k.a(zzopVar);
        }
    }

    public final synchronized void a(zzk zzkVar, long j, boolean z) {
        if (z) {
            boolean z2 = this.n;
        }
        if (!isReady() || this.m != null) {
            this.o = zzkVar;
            this.p = j;
            long zzhl = this.j.zzhl();
            a(Math.max(0L, Math.min(zzhl, (this.p + zzhl) - this.b.currentTimeMillis())));
            Container container = new Container(this.g, this.h.getDataLayer(), this.i, j, zzkVar);
            if (this.m == null) {
                this.m = new eo(this.h, this.d, container, this.c);
            } else {
                this.m.a(container);
            }
            if (!isReady() && this.s.a(container)) {
                setResult(this.m);
            }
        }
    }

    private final void a(boolean z) {
        this.k.a(new d(this, null));
        this.r.a(new e(this, null));
        zzov a = this.k.a(this.f);
        if (a != null) {
            TagManager tagManager = this.h;
            this.m = new eo(tagManager, this.d, new Container(this.g, tagManager.getDataLayer(), this.i, 0L, a), this.c);
        }
        this.s = new b(this, z);
        if (b()) {
            this.r.a(0L, "");
        } else {
            this.k.a();
        }
    }

    public final boolean b() {
        ca a = ca.a();
        return (a.b() == ca.a.CONTAINER || a.b() == ca.a.CONTAINER_DEBUG) && this.i.equals(a.d());
    }

    @Override // com.google.android.gms.common.api.internal.BasePendingResult
    /* renamed from: a */
    public final ContainerHolder mo8createFailedResult(Status status) {
        if (this.m != null) {
            return this.m;
        }
        if (status == Status.RESULT_TIMEOUT) {
            zzdi.zzav("timer expired: setting result to failure");
        }
        return new eo(status);
    }

    public final synchronized String a() {
        return this.q;
    }

    @VisibleForTesting
    public final synchronized void a(String str) {
        this.q = str;
        if (this.r != null) {
            this.r.a(str);
        }
    }

    public final void zzhf() {
        zzov a = this.k.a(this.f);
        if (a != null) {
            setResult(new eo(this.h, this.d, new Container(this.g, this.h.getDataLayer(), this.i, 0L, a), new a(this)));
        } else {
            zzdi.zzav("Default was requested, but no default container was found");
            setResult(mo8createFailedResult(new Status(10, "Default was requested, but no default container was found", null)));
        }
        this.r = null;
        this.k = null;
    }

    public final void zzhg() {
        a(false);
    }

    public final void zzhh() {
        a(true);
    }
}
