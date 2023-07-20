package com.google.firebase;

import android.annotation.TargetApi;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.internal.BackgroundDetector;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Base64Utils;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.util.ProcessUtils;
import com.google.firebase.components.f;
import com.google.firebase.components.i;
import com.google.firebase.components.s;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import javax.annotation.concurrent.GuardedBy;
import net.gree.gamelib.payment.shop.Product;

/* loaded from: classes.dex */
public class b {
    private final Context d;
    private final String e;
    private final com.google.firebase.d f;
    private final i g;
    private final s<com.google.firebase.d.a> j;
    private static final Object b = new Object();
    private static final Executor c = new c();
    @GuardedBy("LOCK")
    static final Map<String, b> a = new androidx.b.a();
    private final AtomicBoolean h = new AtomicBoolean(false);
    private final AtomicBoolean i = new AtomicBoolean();
    private final List<a> k = new CopyOnWriteArrayList();
    private final List<Object> l = new CopyOnWriteArrayList();

    @KeepForSdk
    /* loaded from: classes.dex */
    public interface a {
        @KeepForSdk
        void a(boolean z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @TargetApi(14)
    /* renamed from: com.google.firebase.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0057b implements BackgroundDetector.BackgroundStateChangeListener {
        private static AtomicReference<C0057b> a = new AtomicReference<>();

        private C0057b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void b(Context context) {
            if (!PlatformVersion.isAtLeastIceCreamSandwich() || !(context.getApplicationContext() instanceof Application)) {
                return;
            }
            Application application = (Application) context.getApplicationContext();
            if (a.get() != null) {
                return;
            }
            C0057b c0057b = new C0057b();
            if (!a.compareAndSet(null, c0057b)) {
                return;
            }
            BackgroundDetector.initialize(application);
            BackgroundDetector.getInstance().addListener(c0057b);
        }

        @Override // com.google.android.gms.common.api.internal.BackgroundDetector.BackgroundStateChangeListener
        public void onBackgroundStateChanged(boolean z) {
            synchronized (b.b) {
                Iterator it = new ArrayList(b.a.values()).iterator();
                while (it.hasNext()) {
                    b bVar = (b) it.next();
                    if (bVar.h.get()) {
                        bVar.a(z);
                    }
                }
            }
        }
    }

    /* loaded from: classes.dex */
    private static class c implements Executor {
        private static final Handler a = new Handler(Looper.getMainLooper());

        private c() {
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            a.post(runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @TargetApi(24)
    /* loaded from: classes.dex */
    public static class d extends BroadcastReceiver {
        private static AtomicReference<d> a = new AtomicReference<>();
        private final Context b;

        public d(Context context) {
            this.b = context;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void b(Context context) {
            if (a.get() == null) {
                d dVar = new d(context);
                if (!a.compareAndSet(null, dVar)) {
                    return;
                }
                context.registerReceiver(dVar, new IntentFilter("android.intent.action.USER_UNLOCKED"));
            }
        }

        public void a() {
            this.b.unregisterReceiver(this);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            synchronized (b.b) {
                for (b bVar : b.a.values()) {
                    bVar.j();
                }
            }
            a();
        }
    }

    protected b(Context context, String str, com.google.firebase.d dVar) {
        this.d = (Context) Preconditions.checkNotNull(context);
        this.e = Preconditions.checkNotEmpty(str);
        this.f = (com.google.firebase.d) Preconditions.checkNotNull(dVar);
        this.g = new i(c, f.a(context).a(), com.google.firebase.components.b.a(context, Context.class, new Class[0]), com.google.firebase.components.b.a(this, b.class, new Class[0]), com.google.firebase.components.b.a(dVar, com.google.firebase.d.class, new Class[0]), com.google.firebase.e.f.a("fire-android", ""), com.google.firebase.e.f.a("fire-core", "17.0.0"), com.google.firebase.e.b.b());
        this.j = new s<>(com.google.firebase.c.a(this, context));
    }

    public static b a(Context context) {
        synchronized (b) {
            if (a.containsKey("[DEFAULT]")) {
                return d();
            }
            com.google.firebase.d a2 = com.google.firebase.d.a(context);
            if (a2 == null) {
                Log.w("FirebaseApp", "Default FirebaseApp failed to initialize because no default options were found. This usually means that com.google.gms:google-services was not applied to your gradle project.");
                return null;
            }
            return a(context, a2);
        }
    }

    public static b a(Context context, com.google.firebase.d dVar) {
        return a(context, dVar, "[DEFAULT]");
    }

    public static b a(Context context, com.google.firebase.d dVar, String str) {
        b bVar;
        C0057b.b(context);
        String a2 = a(str);
        if (context.getApplicationContext() != null) {
            context = context.getApplicationContext();
        }
        synchronized (b) {
            boolean z = !a.containsKey(a2);
            Preconditions.checkState(z, "FirebaseApp name " + a2 + " already exists!");
            Preconditions.checkNotNull(context, "Application context cannot be null.");
            bVar = new b(context, a2, dVar);
            a.put(a2, bVar);
        }
        bVar.j();
        return bVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ com.google.firebase.d.a a(b bVar, Context context) {
        return new com.google.firebase.d.a(context, bVar.g(), (com.google.firebase.b.c) bVar.g.a(com.google.firebase.b.c.class));
    }

    private static String a(String str) {
        return str.trim();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        Log.d("FirebaseApp", "Notifying background state change listeners.");
        for (a aVar : this.k) {
            aVar.a(z);
        }
    }

    public static b d() {
        b bVar;
        synchronized (b) {
            bVar = a.get("[DEFAULT]");
            if (bVar == null) {
                throw new IllegalStateException("Default FirebaseApp is not initialized in this process " + ProcessUtils.getMyProcessName() + ". Make sure to call FirebaseApp.initializeApp(Context) first.");
            }
        }
        return bVar;
    }

    private void i() {
        Preconditions.checkState(!this.i.get(), "FirebaseApp was deleted");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        if (!androidx.core.c.b.a(this.d)) {
            d.b(this.d);
        } else {
            this.g.a(f());
        }
    }

    public Context a() {
        i();
        return this.d;
    }

    @KeepForSdk
    public <T> T a(Class<T> cls) {
        i();
        return (T) this.g.a(cls);
    }

    public String b() {
        i();
        return this.e;
    }

    public com.google.firebase.d c() {
        i();
        return this.f;
    }

    @KeepForSdk
    public boolean e() {
        i();
        return this.j.a().a();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof b)) {
            return false;
        }
        return this.e.equals(((b) obj).b());
    }

    @KeepForSdk
    public boolean f() {
        return "[DEFAULT]".equals(b());
    }

    @KeepForSdk
    public String g() {
        return Base64Utils.encodeUrlSafeNoPadding(b().getBytes(Charset.defaultCharset())) + "+" + Base64Utils.encodeUrlSafeNoPadding(c().a().getBytes(Charset.defaultCharset()));
    }

    public int hashCode() {
        return this.e.hashCode();
    }

    public String toString() {
        return Objects.toStringHelper(this).add(Product.KEY_NAME, this.e).add("options", this.f).toString();
    }
}
