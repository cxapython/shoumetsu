package com.google.firebase.iid;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Build;
import android.os.Looper;
import android.util.Log;
import androidx.annotation.Keep;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.util.concurrent.NamedThreadFactory;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.iid.FirebaseInstanceId;
import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import javax.annotation.concurrent.GuardedBy;

/* loaded from: classes.dex */
public class FirebaseInstanceId {
    private static final long a = TimeUnit.HOURS.toSeconds(8);
    private static y b;
    @VisibleForTesting
    @GuardedBy("FirebaseInstanceId.class")
    private static ScheduledExecutorService c;
    private final Executor d;
    private final com.google.firebase.b e;
    private final q f;
    private b g;
    private final t h;
    private final ac i;
    @GuardedBy("this")
    private boolean j;
    private final a k;

    /* loaded from: classes.dex */
    public class a {
        private final com.google.firebase.b.d c;
        @GuardedBy("this")
        private com.google.firebase.b.b<com.google.firebase.a> d;
        private final boolean b = c();
        @GuardedBy("this")
        private Boolean e = b();

        a(com.google.firebase.b.d dVar) {
            FirebaseInstanceId.this = r2;
            this.c = dVar;
            if (this.e != null || !this.b) {
                return;
            }
            this.d = new com.google.firebase.b.b(this) { // from class: com.google.firebase.iid.at
                private final FirebaseInstanceId.a a;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.a = this;
                }

                @Override // com.google.firebase.b.b
                public final void a(com.google.firebase.b.a aVar) {
                    FirebaseInstanceId.a aVar2 = this.a;
                    synchronized (aVar2) {
                        if (aVar2.a()) {
                            FirebaseInstanceId.b(FirebaseInstanceId.this);
                        }
                    }
                }
            };
            dVar.a(com.google.firebase.a.class, this.d);
        }

        private final Boolean b() {
            ApplicationInfo applicationInfo;
            Context a = FirebaseInstanceId.this.e.a();
            SharedPreferences sharedPreferences = a.getSharedPreferences("com.google.firebase.messaging", 0);
            if (sharedPreferences.contains("auto_init")) {
                return Boolean.valueOf(sharedPreferences.getBoolean("auto_init", false));
            }
            try {
                PackageManager packageManager = a.getPackageManager();
                if (packageManager != null && (applicationInfo = packageManager.getApplicationInfo(a.getPackageName(), 128)) != null && applicationInfo.metaData != null && applicationInfo.metaData.containsKey("firebase_messaging_auto_init_enabled")) {
                    return Boolean.valueOf(applicationInfo.metaData.getBoolean("firebase_messaging_auto_init_enabled"));
                }
                return null;
            } catch (PackageManager.NameNotFoundException unused) {
                return null;
            }
        }

        private final boolean c() {
            try {
                Class.forName("com.google.firebase.messaging.a");
                return true;
            } catch (ClassNotFoundException unused) {
                Context a = FirebaseInstanceId.this.e.a();
                Intent intent = new Intent("com.google.firebase.MESSAGING_EVENT");
                intent.setPackage(a.getPackageName());
                ResolveInfo resolveService = a.getPackageManager().resolveService(intent, 0);
                return (resolveService == null || resolveService.serviceInfo == null) ? false : true;
            }
        }

        public final synchronized boolean a() {
            if (this.e != null) {
                return this.e.booleanValue();
            }
            return this.b && FirebaseInstanceId.this.e.e();
        }
    }

    public FirebaseInstanceId(com.google.firebase.b bVar, com.google.firebase.b.d dVar, com.google.firebase.e.g gVar) {
        this(bVar, new q(bVar.a()), ak.b(), ak.b(), dVar, gVar);
    }

    private FirebaseInstanceId(com.google.firebase.b bVar, q qVar, Executor executor, Executor executor2, com.google.firebase.b.d dVar, com.google.firebase.e.g gVar) {
        this.j = false;
        if (q.a(bVar) != null) {
            synchronized (FirebaseInstanceId.class) {
                if (b == null) {
                    b = new y(bVar.a());
                }
            }
            this.e = bVar;
            this.f = qVar;
            if (this.g == null) {
                b bVar2 = (b) bVar.a(b.class);
                this.g = (bVar2 == null || !bVar2.a()) ? new av(bVar, qVar, executor, gVar) : bVar2;
            }
            this.g = this.g;
            this.d = executor2;
            this.i = new ac(b);
            this.k = new a(dVar);
            this.h = new t(executor);
            if (!this.k.a()) {
                return;
            }
            j();
            return;
        }
        throw new IllegalStateException("FirebaseInstanceId failed to initialize, FirebaseApp is missing project ID");
    }

    public static FirebaseInstanceId a() {
        return getInstance(com.google.firebase.b.d());
    }

    private final <T> T a(Task<T> task) {
        try {
            return (T) Tasks.await(task, 30000L, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | TimeoutException unused) {
            throw new IOException("SERVICE_NOT_AVAILABLE");
        } catch (ExecutionException e) {
            Throwable cause = e.getCause();
            if (cause instanceof IOException) {
                if ("INSTANCE_ID_RESET".equals(cause.getMessage())) {
                    f();
                }
                throw ((IOException) cause);
            } else if (!(cause instanceof RuntimeException)) {
                throw new IOException(e);
            } else {
                throw ((RuntimeException) cause);
            }
        }
    }

    public static void a(Runnable runnable, long j) {
        synchronized (FirebaseInstanceId.class) {
            if (c == null) {
                c = new ScheduledThreadPoolExecutor(1, new NamedThreadFactory("FirebaseInstanceId"));
            }
            c.schedule(runnable, j, TimeUnit.SECONDS);
        }
    }

    private final Task<com.google.firebase.iid.a> b(String str, String str2) {
        return Tasks.forResult(null).continueWithTask(this.d, new Continuation(this, str, c(str2)) { // from class: com.google.firebase.iid.ar
            private final FirebaseInstanceId a;
            private final String b;
            private final String c;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.a = this;
                this.b = str;
                this.c = r3;
            }

            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task) {
                return this.a.a(this.b, this.c, task);
            }
        });
    }

    public static /* synthetic */ void b(FirebaseInstanceId firebaseInstanceId) {
        firebaseInstanceId.j();
    }

    @VisibleForTesting
    private static ab c(String str, String str2) {
        return b.a("", str, str2);
    }

    private static String c(String str) {
        return (str.isEmpty() || str.equalsIgnoreCase("fcm") || str.equalsIgnoreCase("gcm")) ? "*" : str;
    }

    public static boolean e() {
        if (!Log.isLoggable("FirebaseInstanceId", 3)) {
            return Build.VERSION.SDK_INT == 23 && Log.isLoggable("FirebaseInstanceId", 3);
        }
        return true;
    }

    @Keep
    public static FirebaseInstanceId getInstance(com.google.firebase.b bVar) {
        return (FirebaseInstanceId) bVar.a(FirebaseInstanceId.class);
    }

    public final void j() {
        ab c2 = c();
        if (i() || a(c2) || this.i.a()) {
            k();
        }
    }

    private final synchronized void k() {
        if (!this.j) {
            a(0L);
        }
    }

    private static String l() {
        return q.a(b.b("").a());
    }

    public final /* synthetic */ Task a(String str, String str2, Task task) {
        String l = l();
        ab c2 = c(str, str2);
        if (this.g.b() || a(c2)) {
            return this.h.a(str, str2, new u(this, l, ab.a(c2), str, str2) { // from class: com.google.firebase.iid.aq
                private final FirebaseInstanceId a;
                private final String b;
                private final String c;
                private final String d;
                private final String e;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.a = this;
                    this.b = l;
                    this.c = r3;
                    this.d = str;
                    this.e = str2;
                }

                @Override // com.google.firebase.iid.u
                public final Task a() {
                    return this.a.a(this.b, this.c, this.d, this.e);
                }
            });
        }
        return Tasks.forResult(new ba(l, c2.a));
    }

    public final /* synthetic */ Task a(String str, String str2, String str3, String str4) {
        return this.g.a(str, str2, str3, str4).onSuccessTask(this.d, new SuccessContinuation(this, str3, str4, str) { // from class: com.google.firebase.iid.as
            private final FirebaseInstanceId a;
            private final String b;
            private final String c;
            private final String d;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.a = this;
                this.b = str3;
                this.c = str4;
                this.d = str;
            }

            @Override // com.google.android.gms.tasks.SuccessContinuation
            public final Task then(Object obj) {
                return this.a.b(this.b, this.c, this.d, (String) obj);
            }
        });
    }

    public String a(String str, String str2) {
        if (Looper.getMainLooper() != Looper.myLooper()) {
            return ((com.google.firebase.iid.a) a(b(str, str2))).a();
        }
        throw new IOException("MAIN_THREAD");
    }

    public final synchronized void a(long j) {
        a(new aa(this, this.f, this.i, Math.min(Math.max(30L, j << 1), a)), j);
        this.j = true;
    }

    public final void a(String str) {
        ab c2 = c();
        if (!a(c2)) {
            a(this.g.a(l(), c2.a, str));
            return;
        }
        throw new IOException("token not available");
    }

    public final synchronized void a(boolean z) {
        this.j = z;
    }

    public final boolean a(ab abVar) {
        return abVar == null || abVar.b(this.f.b());
    }

    public final /* synthetic */ Task b(String str, String str2, String str3, String str4) {
        b.a("", str, str2, str4, this.f.b());
        return Tasks.forResult(new ba(str3, str4));
    }

    public final com.google.firebase.b b() {
        return this.e;
    }

    public final void b(String str) {
        ab c2 = c();
        if (!a(c2)) {
            a(this.g.b(l(), c2.a, str));
            return;
        }
        throw new IOException("token not available");
    }

    public final ab c() {
        return c(q.a(this.e), "*");
    }

    public final String d() {
        return a(q.a(this.e), "*");
    }

    public final synchronized void f() {
        b.b();
        if (this.k.a()) {
            k();
        }
    }

    public final boolean g() {
        return this.g.a();
    }

    public final void h() {
        b.c("");
        k();
    }

    public final boolean i() {
        return this.g.b();
    }
}
