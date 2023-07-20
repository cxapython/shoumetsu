package com.microsoft.appcenter;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.microsoft.appcenter.a.b;
import java.util.Map;

/* loaded from: classes.dex */
public abstract class a implements d {
    protected com.microsoft.appcenter.a.b a;
    private c b;

    /* JADX INFO: Access modifiers changed from: protected */
    public synchronized com.microsoft.appcenter.e.a.b<Boolean> a() {
        final com.microsoft.appcenter.e.a.c cVar;
        cVar = new com.microsoft.appcenter.e.a.c();
        a(new Runnable() { // from class: com.microsoft.appcenter.a.1
            @Override // java.lang.Runnable
            public void run() {
                cVar.a((com.microsoft.appcenter.e.a.c) true);
            }
        }, (com.microsoft.appcenter.e.a.c<com.microsoft.appcenter.e.a.c>) cVar, (com.microsoft.appcenter.e.a.c) false);
        return cVar;
    }

    @Override // com.microsoft.appcenter.d
    public synchronized void a(Context context, com.microsoft.appcenter.a.b bVar, String str, String str2, boolean z) {
        String e = e();
        boolean b = b();
        if (e != null) {
            bVar.b(e);
            if (b) {
                bVar.a(e, h(), i(), j(), null, k());
            } else {
                bVar.d(e);
            }
        }
        this.a = bVar;
        b(b);
    }

    @Override // com.microsoft.appcenter.d
    public final synchronized void a(c cVar) {
        this.b = cVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public synchronized void a(Runnable runnable) {
        a(runnable, (Runnable) null, (Runnable) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public synchronized <T> void a(final Runnable runnable, final com.microsoft.appcenter.e.a.c<T> cVar, final T t) {
        Runnable runnable2 = new Runnable() { // from class: com.microsoft.appcenter.a.3
            @Override // java.lang.Runnable
            public void run() {
                cVar.a((com.microsoft.appcenter.e.a.c) t);
            }
        };
        if (!a(new Runnable() { // from class: com.microsoft.appcenter.a.4
            @Override // java.lang.Runnable
            public void run() {
                runnable.run();
            }
        }, runnable2, runnable2)) {
            runnable2.run();
        }
    }

    @Override // com.microsoft.appcenter.d
    public void a(String str, String str2) {
    }

    @Override // com.microsoft.appcenter.d
    public synchronized void a(boolean z) {
        if (z == b()) {
            String f = f();
            Object[] objArr = new Object[2];
            objArr[0] = l();
            objArr[1] = z ? "enabled" : "disabled";
            com.microsoft.appcenter.e.a.c(f, String.format("%s service has already been %s.", objArr));
            return;
        }
        String e = e();
        if (this.a != null && e != null) {
            if (z) {
                this.a.a(e, h(), i(), j(), null, k());
            } else {
                this.a.d(e);
                this.a.b(e);
            }
        }
        com.microsoft.appcenter.e.d.d.b(g(), z);
        String f2 = f();
        Object[] objArr2 = new Object[2];
        objArr2[0] = l();
        objArr2[1] = z ? "enabled" : "disabled";
        com.microsoft.appcenter.e.a.c(f2, String.format("%s service has been %s.", objArr2));
        if (this.a != null) {
            b(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public synchronized boolean a(final Runnable runnable, Runnable runnable2, final Runnable runnable3) {
        boolean z;
        if (this.b == null) {
            com.microsoft.appcenter.e.a.e("AppCenter", l() + " needs to be started before it can be used.");
            z = false;
        } else {
            this.b.a(new Runnable() { // from class: com.microsoft.appcenter.a.2
                @Override // java.lang.Runnable
                public void run() {
                    Runnable runnable4;
                    if (a.this.b()) {
                        runnable4 = runnable;
                    } else {
                        runnable4 = runnable3;
                        if (runnable4 == null) {
                            com.microsoft.appcenter.e.a.c("AppCenter", a.this.l() + " service disabled, discarding calls.");
                            return;
                        }
                    }
                    runnable4.run();
                }
            }, runnable2);
            z = true;
        }
        return z;
    }

    protected synchronized void b(boolean z) {
    }

    @Override // com.microsoft.appcenter.d
    public synchronized boolean b() {
        return com.microsoft.appcenter.e.d.d.a(g(), true);
    }

    @Override // com.microsoft.appcenter.d
    public boolean c() {
        return true;
    }

    @Override // com.microsoft.appcenter.d
    public Map<String, com.microsoft.appcenter.c.a.a.f> d() {
        return null;
    }

    protected abstract String e();

    protected abstract String f();

    /* JADX INFO: Access modifiers changed from: protected */
    public String g() {
        return "enabled_" + l();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int h() {
        return 50;
    }

    protected long i() {
        return 3000L;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int j() {
        return 3;
    }

    protected b.a k() {
        return null;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
    }
}
