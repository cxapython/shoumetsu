package com.microsoft.appcenter.crashes;

import android.annotation.SuppressLint;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import android.util.Log;
import com.microsoft.appcenter.a.b;
import com.microsoft.appcenter.c.a.a.f;
import com.microsoft.appcenter.c.a.a.g;
import com.microsoft.appcenter.crashes.a.a.e;
import com.microsoft.appcenter.e.b.e;
import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;
import org.json.JSONException;

/* loaded from: classes.dex */
public class Crashes extends com.microsoft.appcenter.a {
    private static final com.microsoft.appcenter.crashes.b b = new b();
    @SuppressLint({"StaticFieldLeak"})
    private static Crashes c = null;
    private final Map<UUID, c> e;
    private final Map<UUID, c> f;
    private g g;
    private Context h;
    private long i;
    private com.microsoft.appcenter.crashes.c j;
    private com.microsoft.appcenter.crashes.b k;
    private ComponentCallbacks2 l;
    private com.microsoft.appcenter.crashes.b.a m;
    private boolean n;
    private boolean p;
    private boolean o = true;
    private final Map<String, f> d = new HashMap();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public interface a {
        void a(com.microsoft.appcenter.crashes.b.a aVar);

        boolean a();
    }

    /* loaded from: classes.dex */
    private static class b extends com.microsoft.appcenter.crashes.a {
        private b() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class c {
        private final e a;
        private final com.microsoft.appcenter.crashes.b.a b;

        private c(e eVar, com.microsoft.appcenter.crashes.b.a aVar) {
            this.a = eVar;
            this.b = aVar;
        }
    }

    private Crashes() {
        this.d.put("managedError", com.microsoft.appcenter.crashes.a.a.a.d.a());
        this.d.put("handledError", com.microsoft.appcenter.crashes.a.a.a.c.a());
        this.d.put("errorAttachment", com.microsoft.appcenter.crashes.a.a.a.a.a());
        this.g = new com.microsoft.appcenter.c.a.a.c();
        this.g.a("managedError", com.microsoft.appcenter.crashes.a.a.a.d.a());
        this.g.a("errorAttachment", com.microsoft.appcenter.crashes.a.a.a.a.a());
        this.k = b;
        this.e = new LinkedHashMap();
        this.f = new LinkedHashMap();
    }

    private UUID a(Throwable th, e eVar) {
        File a2 = com.microsoft.appcenter.crashes.c.a.a();
        UUID b2 = eVar.b();
        String uuid = b2.toString();
        com.microsoft.appcenter.e.a.b("AppCenterCrashes", "Saving uncaught exception.");
        File file = new File(a2, uuid + ".json");
        com.microsoft.appcenter.e.d.b.a(file, this.g.a(eVar));
        com.microsoft.appcenter.e.a.b("AppCenterCrashes", "Saved JSON content for ingestion into " + file);
        File file2 = new File(a2, uuid + ".throwable");
        if (th != null) {
            try {
                String stackTraceString = Log.getStackTraceString(th);
                com.microsoft.appcenter.e.d.b.a(file2, stackTraceString);
                com.microsoft.appcenter.e.a.b("AppCenterCrashes", "Saved stack trace as is for client side inspection in " + file2 + " stack trace:" + stackTraceString);
            } catch (StackOverflowError e) {
                com.microsoft.appcenter.e.a.b("AppCenterCrashes", "Failed to store stack trace.", e);
                th = null;
                file2.delete();
            }
        }
        if (th == null) {
            if (!file2.createNewFile()) {
                throw new IOException(file2.getName());
            }
            com.microsoft.appcenter.e.a.b("AppCenterCrashes", "Saved empty Throwable file in " + file2);
        }
        return b2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(UUID uuid) {
        com.microsoft.appcenter.crashes.c.a.d(uuid);
        b(uuid);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(UUID uuid, Iterable<com.microsoft.appcenter.crashes.a.a.b> iterable) {
        if (iterable == null) {
            com.microsoft.appcenter.e.a.b("AppCenterCrashes", "CrashesListener.getErrorAttachments returned null, no additional information will be attached to log: " + uuid.toString());
            return;
        }
        int i = 0;
        for (com.microsoft.appcenter.crashes.a.a.b bVar : iterable) {
            if (bVar != null) {
                bVar.a(UUID.randomUUID());
                bVar.b(uuid);
                if (bVar.g()) {
                    i++;
                    this.a.a(bVar, "groupErrors", 1);
                } else {
                    com.microsoft.appcenter.e.a.e("AppCenterCrashes", "Not all required fields are present in ErrorAttachmentLog.");
                }
            } else {
                com.microsoft.appcenter.e.a.d("AppCenterCrashes", "Skipping null ErrorAttachmentLog in CrashesListener.getErrorAttachments.");
            }
        }
        if (i <= 2) {
            return;
        }
        com.microsoft.appcenter.e.a.d("AppCenterCrashes", "A limit of 2 attachments per error report might be enforced by server.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(UUID uuid) {
        this.f.remove(uuid);
        d.a(uuid);
        com.microsoft.appcenter.crashes.c.a.b(uuid);
    }

    private static boolean b(int i) {
        return i == 5 || i == 10 || i == 15 || i == 80;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void c(final int i) {
        a(new Runnable() { // from class: com.microsoft.appcenter.crashes.Crashes.3
            /* JADX WARN: Removed duplicated region for block: B:27:0x00b4  */
            /* JADX WARN: Removed duplicated region for block: B:30:0x00d0  */
            /* JADX WARN: Removed duplicated region for block: B:36:0x00eb A[SYNTHETIC] */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void run() {
                com.microsoft.appcenter.crashes.a.a.b bVar;
                int i2 = i;
                if (i2 == 1) {
                    Iterator it = Crashes.this.e.keySet().iterator();
                    while (it.hasNext()) {
                        it.remove();
                        Crashes.this.a((UUID) it.next());
                    }
                    return;
                }
                if (i2 == 2) {
                    com.microsoft.appcenter.e.d.d.b("com.microsoft.appcenter.crashes.always.send", true);
                }
                Iterator it2 = Crashes.this.e.entrySet().iterator();
                while (it2.hasNext()) {
                    Map.Entry entry = (Map.Entry) it2.next();
                    c cVar = (c) entry.getValue();
                    File file = null;
                    if (cVar.b.a() != null && "appcenter.ndk".equals(cVar.b.a().r())) {
                        com.microsoft.appcenter.crashes.a.a.c l = cVar.a.l();
                        String g = l.g();
                        l.e(null);
                        if (g == null) {
                            g = l.c();
                            l.c(null);
                        }
                        if (g != null) {
                            file = new File(g);
                            bVar = com.microsoft.appcenter.crashes.a.a.b.a(com.microsoft.appcenter.e.d.b.b(file), "minidump.dmp", "application/octet-stream");
                            Crashes.this.a.a(cVar.a, "groupErrors", 2);
                            if (bVar != null) {
                                Crashes.this.a(cVar.a.b(), Collections.singleton(bVar));
                                file.delete();
                            }
                            if (!Crashes.this.o) {
                                Crashes.this.a(cVar.a.b(), Crashes.this.k.b(cVar.b));
                            }
                            it2.remove();
                            com.microsoft.appcenter.crashes.c.a.d((UUID) entry.getKey());
                        } else {
                            com.microsoft.appcenter.e.a.d("AppCenterCrashes", "NativeException found without minidump.");
                        }
                    }
                    bVar = null;
                    Crashes.this.a.a(cVar.a, "groupErrors", 2);
                    if (bVar != null) {
                    }
                    if (!Crashes.this.o) {
                    }
                    it2.remove();
                    com.microsoft.appcenter.crashes.c.a.d((UUID) entry.getKey());
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void d(int i) {
        com.microsoft.appcenter.e.d.d.b("com.microsoft.appcenter.crashes.memory", i);
        com.microsoft.appcenter.e.a.b("AppCenterCrashes", String.format("The memory running level (%s) was saved.", Integer.valueOf(i)));
    }

    public static synchronized Crashes getInstance() {
        Crashes crashes;
        synchronized (Crashes.class) {
            if (c == null) {
                c = new Crashes();
            }
            crashes = c;
        }
        return crashes;
    }

    public static com.microsoft.appcenter.e.a.b<Boolean> m() {
        return getInstance().a();
    }

    public static com.microsoft.appcenter.e.a.b<String> n() {
        return getInstance().o();
    }

    private synchronized com.microsoft.appcenter.e.a.b<String> o() {
        final com.microsoft.appcenter.e.a.c cVar;
        cVar = new com.microsoft.appcenter.e.a.c();
        a(new Runnable() { // from class: com.microsoft.appcenter.crashes.Crashes.1
            @Override // java.lang.Runnable
            public void run() {
                cVar.a((com.microsoft.appcenter.e.a.c) com.microsoft.appcenter.crashes.c.a.b().getAbsolutePath());
            }
        }, cVar, (com.microsoft.appcenter.e.a.c) null);
        return cVar;
    }

    private void p() {
        boolean b2 = b();
        this.i = b2 ? System.currentTimeMillis() : -1L;
        if (b2) {
            this.j = new com.microsoft.appcenter.crashes.c();
            this.j.a();
            q();
            return;
        }
        com.microsoft.appcenter.crashes.c cVar = this.j;
        if (cVar == null) {
            return;
        }
        cVar.b();
        this.j = null;
    }

    private void q() {
        File[] e;
        File f;
        for (File file : com.microsoft.appcenter.crashes.c.a.e()) {
            com.microsoft.appcenter.e.a.b("AppCenterCrashes", "Process pending minidump file: " + file);
            long lastModified = file.lastModified();
            File file2 = new File(com.microsoft.appcenter.crashes.c.a.c(), file.getName());
            com.microsoft.appcenter.crashes.a.a.c cVar = new com.microsoft.appcenter.crashes.a.a.c();
            cVar.a("minidump");
            cVar.d("appcenter.ndk");
            cVar.e(file2.getPath());
            e eVar = new e();
            eVar.a(cVar);
            eVar.b(new Date(lastModified));
            eVar.a((Boolean) true);
            eVar.a(UUID.randomUUID());
            e.a a2 = com.microsoft.appcenter.e.b.e.a().a(lastModified);
            eVar.a((a2 == null || a2.c() > lastModified) ? eVar.n() : new Date(a2.c()));
            eVar.a((Integer) 0);
            eVar.a("");
            eVar.f(com.microsoft.appcenter.e.b.f.a().b());
            try {
                eVar.a(com.microsoft.appcenter.e.b.a(this.h));
                eVar.r().p("appcenter.ndk");
                a(new com.microsoft.appcenter.crashes.b.b(), eVar);
            } catch (Exception e2) {
                file.delete();
                a(eVar.b());
                com.microsoft.appcenter.e.a.b("AppCenterCrashes", "Failed to process new minidump file: " + file, e2);
            }
            if (!file.renameTo(file2)) {
                throw new IOException("Failed to move file");
                break;
            }
        }
        while (true) {
            f = com.microsoft.appcenter.crashes.c.a.f();
            if (f == null || f.length() != 0) {
                break;
            }
            com.microsoft.appcenter.e.a.d("AppCenterCrashes", "Deleting empty error file: " + f);
            f.delete();
        }
        if (f != null) {
            com.microsoft.appcenter.e.a.b("AppCenterCrashes", "Processing crash report for the last session.");
            String a3 = com.microsoft.appcenter.e.d.b.a(f);
            if (a3 == null) {
                com.microsoft.appcenter.e.a.e("AppCenterCrashes", "Error reading last session error log.");
                return;
            }
            try {
                this.m = a((com.microsoft.appcenter.crashes.a.a.e) this.g.a(a3, (String) null));
                com.microsoft.appcenter.e.a.b("AppCenterCrashes", "Processed crash report for the last session.");
            } catch (JSONException e3) {
                com.microsoft.appcenter.e.a.b("AppCenterCrashes", "Error parsing last session error log.", e3);
            }
        }
    }

    private void r() {
        File[] d;
        for (File file : com.microsoft.appcenter.crashes.c.a.d()) {
            com.microsoft.appcenter.e.a.b("AppCenterCrashes", "Process pending error file: " + file);
            String a2 = com.microsoft.appcenter.e.d.b.a(file);
            if (a2 != null) {
                try {
                    com.microsoft.appcenter.crashes.a.a.e eVar = (com.microsoft.appcenter.crashes.a.a.e) this.g.a(a2, (String) null);
                    UUID b2 = eVar.b();
                    com.microsoft.appcenter.crashes.b.a a3 = a(eVar);
                    if (a3 != null) {
                        if (this.o && !this.k.a(a3)) {
                            com.microsoft.appcenter.e.a.b("AppCenterCrashes", "CrashesListener.shouldProcess returned false, clean up and ignore log: " + b2.toString());
                        }
                        if (!this.o) {
                            com.microsoft.appcenter.e.a.b("AppCenterCrashes", "CrashesListener.shouldProcess returned true, continue processing log: " + b2.toString());
                        }
                        this.e.put(b2, this.f.get(b2));
                    }
                    a(b2);
                } catch (JSONException e) {
                    com.microsoft.appcenter.e.a.b("AppCenterCrashes", "Error parsing error log. Deleting invalid file: " + file, e);
                    file.delete();
                }
            }
        }
        this.p = b(com.microsoft.appcenter.e.d.d.a("com.microsoft.appcenter.crashes.memory", -1));
        if (this.p) {
            com.microsoft.appcenter.e.a.b("AppCenterCrashes", "The application received a low memory warning in the last session.");
        }
        com.microsoft.appcenter.e.d.d.c("com.microsoft.appcenter.crashes.memory");
        if (this.o) {
            s();
        }
    }

    private boolean s() {
        final boolean a2 = com.microsoft.appcenter.e.d.d.a("com.microsoft.appcenter.crashes.always.send", false);
        com.microsoft.appcenter.e.c.a(new Runnable() { // from class: com.microsoft.appcenter.crashes.Crashes.2
            @Override // java.lang.Runnable
            public void run() {
                if (Crashes.this.e.size() > 0) {
                    if (a2) {
                        com.microsoft.appcenter.e.a.b("AppCenterCrashes", "The flag for user confirmation is set to ALWAYS_SEND, will send logs.");
                        Crashes.this.c(0);
                    } else if (!Crashes.this.o) {
                        com.microsoft.appcenter.e.a.b("AppCenterCrashes", "Automatic processing disabled, will wait for explicit user confirmation.");
                    } else if (Crashes.this.k.a()) {
                        com.microsoft.appcenter.e.a.b("AppCenterCrashes", "CrashesListener.shouldAwaitUserConfirmation returned true, wait sending logs.");
                    } else {
                        com.microsoft.appcenter.e.a.b("AppCenterCrashes", "CrashesListener.shouldAwaitUserConfirmation returned false, will send logs.");
                        Crashes.this.c(0);
                    }
                }
            }
        });
        return a2;
    }

    com.microsoft.appcenter.crashes.b.a a(com.microsoft.appcenter.crashes.a.a.e eVar) {
        UUID b2 = eVar.b();
        if (this.f.containsKey(b2)) {
            com.microsoft.appcenter.crashes.b.a aVar = this.f.get(b2).b;
            aVar.a(eVar.r());
            return aVar;
        }
        File a2 = com.microsoft.appcenter.crashes.c.a.a(b2);
        if (a2 == null) {
            return null;
        }
        com.microsoft.appcenter.crashes.b.a a3 = com.microsoft.appcenter.crashes.c.a.a(eVar, a2.length() > 0 ? com.microsoft.appcenter.e.d.b.a(a2) : null);
        this.f.put(b2, new c(eVar, a3));
        return a3;
    }

    UUID a(Thread thread, Throwable th, com.microsoft.appcenter.crashes.a.a.c cVar) {
        if (m().a().booleanValue() && !this.n) {
            this.n = true;
            return a(th, com.microsoft.appcenter.crashes.c.a.a(this.h, thread, cVar, Thread.getAllStackTraces(), this.i, true));
        }
        return null;
    }

    @Override // com.microsoft.appcenter.a, com.microsoft.appcenter.d
    public synchronized void a(Context context, com.microsoft.appcenter.a.b bVar, String str, String str2, boolean z) {
        this.h = context;
        super.a(context, bVar, str, str2, z);
        if (b()) {
            r();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Thread thread, Throwable th) {
        String str;
        String str2;
        try {
            a(thread, th, com.microsoft.appcenter.crashes.c.a.a(th));
        } catch (IOException e) {
            e = e;
            str = "AppCenterCrashes";
            str2 = "Error writing error log to file";
            com.microsoft.appcenter.e.a.b(str, str2, e);
        } catch (JSONException e2) {
            e = e2;
            str = "AppCenterCrashes";
            str2 = "Error serializing error log to JSON";
            com.microsoft.appcenter.e.a.b(str, str2, e);
        }
    }

    @Override // com.microsoft.appcenter.a
    protected synchronized void b(boolean z) {
        File[] listFiles;
        p();
        if (z) {
            this.l = new ComponentCallbacks2() { // from class: com.microsoft.appcenter.crashes.Crashes.4
                @Override // android.content.ComponentCallbacks
                public void onConfigurationChanged(Configuration configuration) {
                }

                @Override // android.content.ComponentCallbacks
                public void onLowMemory() {
                    Crashes.d(80);
                }

                @Override // android.content.ComponentCallbacks2
                public void onTrimMemory(int i) {
                    Crashes.d(i);
                }
            };
            this.h.registerComponentCallbacks(this.l);
        } else {
            for (File file : com.microsoft.appcenter.crashes.c.a.a().listFiles()) {
                com.microsoft.appcenter.e.a.b("AppCenterCrashes", "Deleting file " + file);
                if (!file.delete()) {
                    com.microsoft.appcenter.e.a.d("AppCenterCrashes", "Failed to delete file " + file);
                }
            }
            com.microsoft.appcenter.e.a.c("AppCenterCrashes", "Deleted crashes local files");
            this.f.clear();
            this.m = null;
            this.h.unregisterComponentCallbacks(this.l);
            this.l = null;
            com.microsoft.appcenter.e.d.d.c("com.microsoft.appcenter.crashes.memory");
        }
    }

    @Override // com.microsoft.appcenter.a, com.microsoft.appcenter.d
    public Map<String, f> d() {
        return this.d;
    }

    @Override // com.microsoft.appcenter.a
    protected String e() {
        return "groupErrors";
    }

    @Override // com.microsoft.appcenter.a
    protected String f() {
        return "AppCenterCrashes";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.microsoft.appcenter.a
    public int h() {
        return 1;
    }

    @Override // com.microsoft.appcenter.a
    protected b.a k() {
        return new b.a() { // from class: com.microsoft.appcenter.crashes.Crashes.5
            private void a(final com.microsoft.appcenter.c.a.d dVar, final a aVar) {
                Crashes.this.a(new Runnable() { // from class: com.microsoft.appcenter.crashes.Crashes.5.1
                    @Override // java.lang.Runnable
                    public void run() {
                        com.microsoft.appcenter.c.a.d dVar2 = dVar;
                        if (!(dVar2 instanceof com.microsoft.appcenter.crashes.a.a.e)) {
                            if ((dVar2 instanceof com.microsoft.appcenter.crashes.a.a.b) || (dVar2 instanceof com.microsoft.appcenter.crashes.a.a.d)) {
                                return;
                            }
                            com.microsoft.appcenter.e.a.d("AppCenterCrashes", "A different type of log comes to crashes: " + dVar.getClass().getName());
                            return;
                        }
                        com.microsoft.appcenter.crashes.a.a.e eVar = (com.microsoft.appcenter.crashes.a.a.e) dVar2;
                        final com.microsoft.appcenter.crashes.b.a a2 = Crashes.this.a(eVar);
                        UUID b2 = eVar.b();
                        if (a2 != null) {
                            if (aVar.a()) {
                                Crashes.this.b(b2);
                            }
                            com.microsoft.appcenter.e.c.a(new Runnable() { // from class: com.microsoft.appcenter.crashes.Crashes.5.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    aVar.a(a2);
                                }
                            });
                            return;
                        }
                        com.microsoft.appcenter.e.a.d("AppCenterCrashes", "Cannot find crash report for the error log: " + b2);
                    }
                });
            }

            @Override // com.microsoft.appcenter.a.b.a
            public void a(com.microsoft.appcenter.c.a.d dVar) {
                a(dVar, new a() { // from class: com.microsoft.appcenter.crashes.Crashes.5.2
                    @Override // com.microsoft.appcenter.crashes.Crashes.a
                    public void a(com.microsoft.appcenter.crashes.b.a aVar) {
                        Crashes.this.k.c(aVar);
                    }

                    @Override // com.microsoft.appcenter.crashes.Crashes.a
                    public boolean a() {
                        return false;
                    }
                });
            }

            @Override // com.microsoft.appcenter.a.b.a
            public void a(com.microsoft.appcenter.c.a.d dVar, final Exception exc) {
                a(dVar, new a() { // from class: com.microsoft.appcenter.crashes.Crashes.5.4
                    @Override // com.microsoft.appcenter.crashes.Crashes.a
                    public void a(com.microsoft.appcenter.crashes.b.a aVar) {
                        Crashes.this.k.a(aVar, exc);
                    }

                    @Override // com.microsoft.appcenter.crashes.Crashes.a
                    public boolean a() {
                        return true;
                    }
                });
            }

            @Override // com.microsoft.appcenter.a.b.a
            public void b(com.microsoft.appcenter.c.a.d dVar) {
                a(dVar, new a() { // from class: com.microsoft.appcenter.crashes.Crashes.5.3
                    @Override // com.microsoft.appcenter.crashes.Crashes.a
                    public void a(com.microsoft.appcenter.crashes.b.a aVar) {
                        Crashes.this.k.d(aVar);
                    }

                    @Override // com.microsoft.appcenter.crashes.Crashes.a
                    public boolean a() {
                        return true;
                    }
                });
            }
        };
    }

    @Override // com.microsoft.appcenter.d
    public String l() {
        return "Crashes";
    }
}
