package com.microsoft.appcenter.analytics.a;

import android.os.SystemClock;
import com.microsoft.appcenter.analytics.b.a.d;
import com.microsoft.appcenter.c.a.h;
import com.microsoft.appcenter.e.b.e;
import java.util.Date;
import java.util.UUID;

/* loaded from: classes.dex */
public class c extends com.microsoft.appcenter.a.a {
    private final com.microsoft.appcenter.a.b a;
    private final String b;
    private UUID c;
    private long d;
    private Long e;
    private Long f;

    public c(com.microsoft.appcenter.a.b bVar, String str) {
        this.a = bVar;
        this.b = str;
    }

    private void d() {
        if (this.c == null || e()) {
            this.c = UUID.randomUUID();
            e.a().a(this.c);
            this.d = SystemClock.elapsedRealtime();
            d dVar = new d();
            dVar.c(this.c);
            this.a.a(dVar, this.b, 1);
        }
    }

    private boolean e() {
        if (this.f == null) {
            return false;
        }
        boolean z = SystemClock.elapsedRealtime() - this.d >= 20000;
        boolean z2 = this.e.longValue() - Math.max(this.f.longValue(), this.d) >= 20000;
        com.microsoft.appcenter.e.a.b("AppCenterAnalytics", "noLogSentForLong=" + z + " wasBackgroundForLong=" + z2);
        return z && z2;
    }

    public void a() {
        com.microsoft.appcenter.e.a.b("AppCenterAnalytics", "onActivityResumed");
        this.e = Long.valueOf(SystemClock.elapsedRealtime());
        d();
    }

    @Override // com.microsoft.appcenter.a.a, com.microsoft.appcenter.a.b.InterfaceC0058b
    public void a(com.microsoft.appcenter.c.a.d dVar, String str) {
        if ((dVar instanceof d) || (dVar instanceof h)) {
            return;
        }
        Date n = dVar.n();
        if (n == null) {
            dVar.c(this.c);
            this.d = SystemClock.elapsedRealtime();
            return;
        }
        e.a a = e.a().a(n.getTime());
        if (a == null) {
            return;
        }
        dVar.c(a.b());
    }

    public void b() {
        com.microsoft.appcenter.e.a.b("AppCenterAnalytics", "onActivityPaused");
        this.f = Long.valueOf(SystemClock.elapsedRealtime());
    }

    public void c() {
        e.a().b();
    }
}
