package com.microsoft.appcenter;

import android.annotation.SuppressLint;
import android.app.Application;
import android.os.Handler;
import android.os.HandlerThread;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public class b {
    @SuppressLint({"StaticFieldLeak"})
    private static b a;
    private boolean b;
    private String c;
    private Application d;
    private String e;
    private String f;
    private boolean g;
    private i h;
    private Set<d> j;
    private Set<d> k;
    private com.microsoft.appcenter.c.a.a.g l;
    private com.microsoft.appcenter.a.b m;
    private HandlerThread n;
    private Handler o;
    private c p;
    private com.microsoft.appcenter.e.a.c<Boolean> r;
    private com.microsoft.appcenter.a.d s;
    private final List<String> i = new ArrayList();
    private long q = 10485760;

    public static synchronized b a() {
        b bVar;
        synchronized (b.class) {
            if (a == null) {
                a = new b();
            }
            bVar = a;
        }
        return bVar;
    }

    private void a(Application application, String str, boolean z, Class<? extends d>[] clsArr) {
        if (a(application, str, z)) {
            a(z, clsArr);
        }
    }

    @SafeVarargs
    public static void a(Application application, String str, Class<? extends d>... clsArr) {
        a().b(application, str, clsArr);
    }

    private void a(d dVar, Collection<d> collection) {
        String l = dVar.l();
        if (!dVar.c()) {
            if (!b(dVar, collection)) {
                return;
            }
            this.k.add(dVar);
            return;
        }
        com.microsoft.appcenter.e.a.e("AppCenter", "This service cannot be started from a library: " + l + ".");
    }

    private void a(d dVar, Collection<d> collection, Collection<d> collection2) {
        String l = dVar.l();
        if (this.j.contains(dVar)) {
            if (this.k.remove(dVar)) {
                collection2.add(dVar);
                return;
            }
            com.microsoft.appcenter.e.a.d("AppCenter", "App Center has already started the service with class name: " + dVar.l());
        } else if (this.e != null || !dVar.c()) {
            b(dVar, collection);
        } else {
            com.microsoft.appcenter.e.a.e("AppCenter", "App Center was started without app secret, but the service requires it; not starting service " + l + ".");
        }
    }

    private void a(d dVar, Collection<d> collection, Collection<d> collection2, boolean z) {
        if (z) {
            a(dVar, collection, collection2);
        } else if (this.j.contains(dVar)) {
        } else {
            a(dVar, collection);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Iterable<d> iterable, Iterable<d> iterable2, boolean z) {
        String str;
        StringBuilder sb;
        String str2;
        for (d dVar : iterable) {
            dVar.a(this.e, this.f);
            com.microsoft.appcenter.e.a.c("AppCenter", dVar.getClass().getSimpleName() + " service configuration updated.");
        }
        boolean b = b();
        for (d dVar2 : iterable2) {
            Map<String, com.microsoft.appcenter.c.a.a.f> d = dVar2.d();
            if (d != null) {
                for (Map.Entry<String, com.microsoft.appcenter.c.a.a.f> entry : d.entrySet()) {
                    this.l.a(entry.getKey(), entry.getValue());
                }
            }
            if (!b && dVar2.b()) {
                dVar2.a(false);
            }
            if (z) {
                dVar2.a(this.d, this.m, this.e, this.f, true);
                str = "AppCenter";
                sb = new StringBuilder();
                sb.append(dVar2.getClass().getSimpleName());
                str2 = " service started from application.";
            } else {
                dVar2.a(this.d, this.m, null, null, false);
                str = "AppCenter";
                sb = new StringBuilder();
                sb.append(dVar2.getClass().getSimpleName());
                str2 = " service started from library.";
            }
            sb.append(str2);
            com.microsoft.appcenter.e.a.c(str, sb.toString());
        }
        if (z) {
            com.microsoft.appcenter.e.b.b.a().b();
            for (d dVar3 : iterable) {
                this.i.add(dVar3.l());
            }
            for (d dVar4 : iterable2) {
                this.i.add(dVar4.l());
            }
            f();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(final Runnable runnable, final Runnable runnable2) {
        if (c()) {
            Runnable runnable3 = new Runnable() { // from class: com.microsoft.appcenter.b.4
                @Override // java.lang.Runnable
                public void run() {
                    Runnable runnable4;
                    if (b.this.b()) {
                        runnable4 = runnable;
                    } else {
                        runnable4 = runnable2;
                        if (runnable4 == null) {
                            com.microsoft.appcenter.e.a.e("AppCenter", "App Center SDK is disabled.");
                            return;
                        }
                    }
                    runnable4.run();
                }
            };
            if (Thread.currentThread() == this.n) {
                runnable.run();
            } else {
                this.o.post(runnable3);
            }
        }
    }

    public static void a(String str) {
        a().b(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        f.a(this.d);
        com.microsoft.appcenter.e.d.b.a(this.d);
        com.microsoft.appcenter.e.d.d.a(this.d);
        com.microsoft.appcenter.e.b.b.a(this.d);
        com.microsoft.appcenter.e.b.e.a();
        boolean b = b();
        this.l = new com.microsoft.appcenter.c.a.a.c();
        this.l.a("startService", new com.microsoft.appcenter.c.a.a.i());
        this.l.a("customProperties", new com.microsoft.appcenter.c.a.a.b());
        this.m = new com.microsoft.appcenter.a.c(this.d, this.e, this.l, this.o);
        if (z) {
            e();
        } else {
            this.m.a(10485760L);
        }
        this.m.a(b);
        this.m.a("group_core", 50, 3000L, 3, null, null);
        this.s = new com.microsoft.appcenter.a.d(this.d, this.m, this.l, com.microsoft.appcenter.e.d.a());
        if (this.c != null) {
            if (this.e != null) {
                com.microsoft.appcenter.e.a.c("AppCenter", "The log url of App Center endpoint has been changed to " + this.c);
                this.m.c(this.c);
            } else {
                com.microsoft.appcenter.e.a.c("AppCenter", "The log url of One Collector endpoint has been changed to " + this.c);
                this.s.c(this.c);
            }
        }
        this.m.a(this.s);
        if (!b) {
            com.microsoft.appcenter.e.f.a(this.d).close();
        }
        this.h = new i(this.o, this.m);
        if (b) {
            this.h.a();
        }
        com.microsoft.appcenter.e.a.b("AppCenter", "App Center initialized.");
    }

    @SafeVarargs
    private final synchronized void a(final boolean z, Class<? extends d>... clsArr) {
        if (clsArr == null) {
            com.microsoft.appcenter.e.a.e("AppCenter", "Cannot start services, services array is null. Failed to start services.");
            return;
        }
        if (this.d == null) {
            StringBuilder sb = new StringBuilder();
            for (Class<? extends d> cls : clsArr) {
                sb.append("\t");
                sb.append(cls.getName());
                sb.append("\n");
            }
            com.microsoft.appcenter.e.a.e("AppCenter", "Cannot start services, App Center has not been configured. Failed to start the following services:\n" + ((Object) sb));
            return;
        }
        final ArrayList arrayList = new ArrayList();
        final ArrayList arrayList2 = new ArrayList();
        for (Class<? extends d> cls2 : clsArr) {
            if (cls2 == null) {
                com.microsoft.appcenter.e.a.d("AppCenter", "Skipping null service, please check your varargs/array does not contain any null reference.");
            } else {
                try {
                    a((d) cls2.getMethod("getInstance", new Class[0]).invoke(null, new Object[0]), arrayList, arrayList2, z);
                } catch (Exception e) {
                    com.microsoft.appcenter.e.a.b("AppCenter", "Failed to get service instance '" + cls2.getName() + "', skipping it.", e);
                }
            }
        }
        this.o.post(new Runnable() { // from class: com.microsoft.appcenter.b.5
            @Override // java.lang.Runnable
            public void run() {
                b.this.a(arrayList2, arrayList, z);
            }
        });
    }

    private synchronized boolean a(Application application, String str, final boolean z) {
        if (application == null) {
            com.microsoft.appcenter.e.a.e("AppCenter", "Application context may not be null.");
            return false;
        }
        if (!this.b && (application.getApplicationInfo().flags & 2) == 2) {
            com.microsoft.appcenter.e.a.a(5);
        }
        String str2 = this.e;
        if (z && !c(str)) {
            return false;
        }
        if (this.o != null) {
            if (this.e != null && !this.e.equals(str2)) {
                this.o.post(new Runnable() { // from class: com.microsoft.appcenter.b.1
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.m.a(b.this.e);
                        b.this.e();
                    }
                });
            }
            return true;
        }
        this.d = application;
        this.n = new HandlerThread("AppCenter.Looper");
        this.n.start();
        this.o = new Handler(this.n.getLooper());
        this.p = new c() { // from class: com.microsoft.appcenter.b.2
            @Override // com.microsoft.appcenter.c
            public void a(Runnable runnable, Runnable runnable2) {
                b.this.a(runnable, runnable2);
            }
        };
        this.j = new HashSet();
        this.k = new HashSet();
        this.o.post(new Runnable() { // from class: com.microsoft.appcenter.b.3
            @Override // java.lang.Runnable
            public void run() {
                b.this.a(z);
            }
        });
        com.microsoft.appcenter.e.a.c("AppCenter", "App Center SDK configured successfully.");
        return true;
    }

    private synchronized void b(Application application, String str, Class<? extends d>[] clsArr) {
        if (str != null) {
            if (!str.isEmpty()) {
                a(application, str, true, clsArr);
            }
        }
        com.microsoft.appcenter.e.a.e("AppCenter", "appSecret may not be null or empty.");
    }

    private synchronized void b(String str) {
        if (!this.g) {
            com.microsoft.appcenter.e.a.e("AppCenter", "AppCenter must be configured from application, libraries cannot use call setUserId.");
        } else if (this.e == null && this.f == null) {
            com.microsoft.appcenter.e.a.e("AppCenter", "AppCenter must be configured with a secret from application to call setUserId.");
        } else {
            if (str != null) {
                if (this.e != null && !com.microsoft.appcenter.e.b.f.b(str)) {
                    return;
                }
                if (this.f != null && !com.microsoft.appcenter.e.b.f.a(str)) {
                    return;
                }
            }
            com.microsoft.appcenter.e.b.f.a().d(str);
        }
    }

    private boolean b(d dVar, Collection<d> collection) {
        String l = dVar.l();
        if (!h.a(l)) {
            dVar.a(this.p);
            this.d.registerActivityLifecycleCallbacks(dVar);
            this.j.add(dVar);
            collection.add(dVar);
            return true;
        }
        com.microsoft.appcenter.e.a.b("AppCenter", "Instrumentation variable to disable service has been set; not starting service " + l + ".");
        return false;
    }

    private synchronized boolean c() {
        boolean z;
        if (d()) {
            z = true;
        } else {
            com.microsoft.appcenter.e.a.e("AppCenter", "App Center hasn't been configured. You need to call AppCenter.start with appSecret or AppCenter.configure first.");
            z = false;
        }
        return z;
    }

    private boolean c(String str) {
        if (this.g) {
            com.microsoft.appcenter.e.a.d("AppCenter", "App Center may only be configured once.");
            return false;
        }
        this.g = true;
        if (str != null) {
            for (String str2 : str.split(";")) {
                String[] split = str2.split("=", -1);
                String str3 = split[0];
                if (split.length == 1) {
                    if (!str3.isEmpty()) {
                        this.e = str3;
                    }
                } else if (!split[1].isEmpty()) {
                    String str4 = split[1];
                    if ("appsecret".equals(str3)) {
                        this.e = str4;
                    } else if ("target".equals(str3)) {
                        this.f = str4;
                    }
                }
            }
        }
        return true;
    }

    private synchronized boolean d() {
        return this.d != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        boolean a2 = this.m.a(this.q);
        com.microsoft.appcenter.e.a.c<Boolean> cVar = this.r;
        if (cVar != null) {
            cVar.a((com.microsoft.appcenter.e.a.c<Boolean>) Boolean.valueOf(a2));
        }
    }

    private void f() {
        if (this.i.isEmpty() || !b()) {
            return;
        }
        ArrayList arrayList = new ArrayList(this.i);
        this.i.clear();
        com.microsoft.appcenter.c.a.h hVar = new com.microsoft.appcenter.c.a.h();
        hVar.a((List<String>) arrayList);
        this.m.a(hVar, "group_core", 1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b() {
        return com.microsoft.appcenter.e.d.d.a("enabled", true);
    }
}
