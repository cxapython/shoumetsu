package com.microsoft.appcenter.analytics;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import com.google.android.gms.tagmanager.DataLayer;
import com.microsoft.appcenter.a.b;
import com.microsoft.appcenter.c.a.a.f;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public class Analytics extends com.microsoft.appcenter.a {
    @SuppressLint({"StaticFieldLeak"})
    private static Analytics c;
    a b;
    private final Map<String, a> e;
    private WeakReference<Activity> f;
    private Context g;
    private boolean h;
    private com.microsoft.appcenter.analytics.a.c i;
    private com.microsoft.appcenter.analytics.a.b j;
    private b.InterfaceC0058b k;
    private com.microsoft.appcenter.analytics.a.a l;
    private long m;
    private boolean n = false;
    private final Map<String, f> d = new HashMap();

    private Analytics() {
        this.d.put("startSession", new com.microsoft.appcenter.analytics.b.a.a.c());
        this.d.put("page", new com.microsoft.appcenter.analytics.b.a.a.b());
        this.d.put(DataLayer.EVENT_KEY, new com.microsoft.appcenter.analytics.b.a.a.a());
        this.d.put("commonSchemaEvent", new com.microsoft.appcenter.analytics.b.a.b.a.a());
        this.e = new HashMap();
        this.m = TimeUnit.SECONDS.toMillis(3L);
    }

    private a a(String str) {
        final a aVar = new a(str, null);
        com.microsoft.appcenter.e.a.b("AppCenterAnalytics", "Created transmission target with token " + str);
        b(new Runnable() { // from class: com.microsoft.appcenter.analytics.Analytics.1
            @Override // java.lang.Runnable
            public void run() {
                aVar.a(Analytics.this.g, Analytics.this.a);
            }
        });
        return aVar;
    }

    private static String a(Class<?> cls) {
        String simpleName = cls.getSimpleName();
        return (!simpleName.endsWith("Activity") || simpleName.length() <= 8) ? simpleName : simpleName.substring(0, simpleName.length() - 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Activity activity) {
        com.microsoft.appcenter.analytics.a.c cVar = this.i;
        if (cVar != null) {
            cVar.a();
            if (!this.n) {
                return;
            }
            a(a(activity.getClass()), (Map<String, String>) null);
        }
    }

    private void a(String str, Map<String, String> map) {
        com.microsoft.appcenter.analytics.b.a.c cVar = new com.microsoft.appcenter.analytics.b.a.c();
        cVar.a(str);
        cVar.a(map);
        this.a.a(cVar, "group_analytics", 1);
    }

    private void b(String str) {
        if (str != null) {
            this.b = a(str);
        }
    }

    public static synchronized Analytics getInstance() {
        Analytics analytics;
        synchronized (Analytics.class) {
            if (c == null) {
                c = new Analytics();
            }
            analytics = c;
        }
        return analytics;
    }

    private void n() {
        Activity activity;
        if (this.h) {
            this.j = new com.microsoft.appcenter.analytics.a.b();
            this.a.a(this.j);
            this.i = new com.microsoft.appcenter.analytics.a.c(this.a, "group_analytics");
            this.a.a(this.i);
            WeakReference<Activity> weakReference = this.f;
            if (weakReference != null && (activity = weakReference.get()) != null) {
                a(activity);
            }
            this.k = a.a();
            this.a.a(this.k);
        }
    }

    @Override // com.microsoft.appcenter.a, com.microsoft.appcenter.d
    public synchronized void a(Context context, com.microsoft.appcenter.a.b bVar, String str, String str2, boolean z) {
        this.g = context;
        this.h = z;
        super.a(context, bVar, str, str2, z);
        b(str2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.microsoft.appcenter.a
    public synchronized void a(Runnable runnable) {
        super.a(runnable);
    }

    @Override // com.microsoft.appcenter.a, com.microsoft.appcenter.d
    public void a(String str, String str2) {
        this.h = true;
        n();
        b(str2);
    }

    void b(Runnable runnable) {
        a(runnable, runnable, runnable);
    }

    @Override // com.microsoft.appcenter.a
    protected synchronized void b(boolean z) {
        if (z) {
            this.a.a("group_analytics_critical", h(), 3000L, j(), null, k());
            n();
        } else {
            this.a.b("group_analytics_critical");
            if (this.j != null) {
                this.a.b(this.j);
                this.j = null;
            }
            if (this.i != null) {
                this.a.b(this.i);
                this.i.c();
                this.i = null;
            }
            if (this.k != null) {
                this.a.b(this.k);
                this.k = null;
            }
        }
    }

    @Override // com.microsoft.appcenter.a, com.microsoft.appcenter.d
    public boolean c() {
        return false;
    }

    @Override // com.microsoft.appcenter.a, com.microsoft.appcenter.d
    public Map<String, f> d() {
        return this.d;
    }

    @Override // com.microsoft.appcenter.a
    protected String e() {
        return "group_analytics";
    }

    @Override // com.microsoft.appcenter.a
    protected String f() {
        return "AppCenterAnalytics";
    }

    @Override // com.microsoft.appcenter.a
    protected long i() {
        return this.m;
    }

    @Override // com.microsoft.appcenter.a
    protected b.a k() {
        return new b.a() { // from class: com.microsoft.appcenter.analytics.Analytics.6
            @Override // com.microsoft.appcenter.a.b.a
            public void a(com.microsoft.appcenter.c.a.d dVar) {
                if (Analytics.this.l != null) {
                    Analytics.this.l.a(dVar);
                }
            }

            @Override // com.microsoft.appcenter.a.b.a
            public void a(com.microsoft.appcenter.c.a.d dVar, Exception exc) {
                if (Analytics.this.l != null) {
                    Analytics.this.l.a(dVar, exc);
                }
            }

            @Override // com.microsoft.appcenter.a.b.a
            public void b(com.microsoft.appcenter.c.a.d dVar) {
                if (Analytics.this.l != null) {
                    Analytics.this.l.b(dVar);
                }
            }
        };
    }

    @Override // com.microsoft.appcenter.d
    public String l() {
        return "Analytics";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String m() {
        return g() + "/";
    }

    @Override // com.microsoft.appcenter.a, android.app.Application.ActivityLifecycleCallbacks
    public synchronized void onActivityPaused(Activity activity) {
        final Runnable runnable = new Runnable() { // from class: com.microsoft.appcenter.analytics.Analytics.4
            @Override // java.lang.Runnable
            public void run() {
                Analytics.this.f = null;
            }
        };
        a(new Runnable() { // from class: com.microsoft.appcenter.analytics.Analytics.5
            @Override // java.lang.Runnable
            public void run() {
                runnable.run();
                if (Analytics.this.i != null) {
                    Analytics.this.i.b();
                }
            }
        }, runnable, runnable);
    }

    @Override // com.microsoft.appcenter.a, android.app.Application.ActivityLifecycleCallbacks
    public synchronized void onActivityResumed(final Activity activity) {
        final Runnable runnable = new Runnable() { // from class: com.microsoft.appcenter.analytics.Analytics.2
            @Override // java.lang.Runnable
            public void run() {
                Analytics.this.f = new WeakReference(activity);
            }
        };
        a(new Runnable() { // from class: com.microsoft.appcenter.analytics.Analytics.3
            @Override // java.lang.Runnable
            public void run() {
                runnable.run();
                Analytics.this.a(activity);
            }
        }, runnable, runnable);
    }
}
