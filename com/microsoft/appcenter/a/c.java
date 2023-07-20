package com.microsoft.appcenter.a;

import android.content.Context;
import android.os.Handler;
import com.microsoft.appcenter.a.b;
import com.microsoft.appcenter.b.j;
import com.microsoft.appcenter.b.l;
import com.microsoft.appcenter.c.a.a.g;
import com.microsoft.appcenter.c.a.b.k;
import com.microsoft.appcenter.c.a.e;
import com.microsoft.appcenter.d.b;
import com.microsoft.appcenter.e.b;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

/* loaded from: classes.dex */
public class c implements b {
    private final Context a;
    private String b;
    private final UUID c;
    private final Map<String, a> d;
    private final Collection<b.InterfaceC0058b> e;
    private final com.microsoft.appcenter.d.b f;
    private final com.microsoft.appcenter.c.b g;
    private final Set<com.microsoft.appcenter.c.b> h;
    private final Handler i;
    private boolean j;
    private boolean k;
    private com.microsoft.appcenter.c.a.c l;
    private int m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends com.microsoft.appcenter.e.b.a {
        final String a;
        final int b;
        final long c;
        final int d;
        final com.microsoft.appcenter.c.b f;
        final b.a g;
        int h;
        boolean i;
        boolean j;
        final Map<String, List<com.microsoft.appcenter.c.a.d>> e = new HashMap();
        final Collection<String> k = new HashSet();
        final Runnable l = new Runnable() { // from class: com.microsoft.appcenter.a.c.a.1
            @Override // java.lang.Runnable
            public void run() {
                a aVar = a.this;
                aVar.i = false;
                c.this.d(a.this);
            }
        };

        a(String str, int i, long j, int i2, com.microsoft.appcenter.c.b bVar, b.a aVar) {
            this.a = str;
            this.b = i;
            this.c = j;
            this.d = i2;
            this.f = bVar;
            this.g = aVar;
        }

        @Override // com.microsoft.appcenter.e.b.a, com.microsoft.appcenter.e.b.b.a
        public void a(String str) {
            c.this.b(this);
        }
    }

    public c(Context context, String str, g gVar, Handler handler) {
        this(context, str, a(context, gVar), new com.microsoft.appcenter.c.a(context, gVar), handler);
    }

    c(Context context, String str, com.microsoft.appcenter.d.b bVar, com.microsoft.appcenter.c.b bVar2, Handler handler) {
        this.a = context;
        this.b = str;
        this.c = com.microsoft.appcenter.e.d.a();
        this.d = new HashMap();
        this.e = new LinkedHashSet();
        this.f = bVar;
        this.g = bVar2;
        this.h = new HashSet();
        this.h.add(this.g);
        this.i = handler;
        this.j = true;
    }

    private static com.microsoft.appcenter.d.b a(Context context, g gVar) {
        com.microsoft.appcenter.d.a aVar = new com.microsoft.appcenter.d.a(context);
        aVar.a(gVar);
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(final a aVar, final int i, List<com.microsoft.appcenter.c.a.d> list, final String str, String str2) {
        if (a(aVar, i)) {
            e eVar = new e();
            eVar.a(list);
            aVar.f.a(str2, this.b, this.c, eVar, new l() { // from class: com.microsoft.appcenter.a.c.2
                @Override // com.microsoft.appcenter.b.l
                public void a(final Exception exc) {
                    c.this.i.post(new Runnable() { // from class: com.microsoft.appcenter.a.c.2.2
                        @Override // java.lang.Runnable
                        public void run() {
                            c.this.a(aVar, str, exc);
                        }
                    });
                }

                @Override // com.microsoft.appcenter.b.l
                public void a(String str3, Map<String, String> map) {
                    c.this.i.post(new Runnable() { // from class: com.microsoft.appcenter.a.c.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            c.this.a(aVar, str);
                        }
                    });
                }
            });
            this.i.post(new Runnable() { // from class: com.microsoft.appcenter.a.c.3
                @Override // java.lang.Runnable
                public void run() {
                    c.this.b(aVar, i);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(a aVar, String str) {
        List<com.microsoft.appcenter.c.a.d> remove = aVar.e.remove(str);
        if (remove != null) {
            this.f.a(aVar.a, str);
            b.a aVar2 = aVar.g;
            if (aVar2 != null) {
                for (com.microsoft.appcenter.c.a.d dVar : remove) {
                    aVar2.b(dVar);
                }
            }
            b(aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(a aVar, String str, Exception exc) {
        String str2 = aVar.a;
        List<com.microsoft.appcenter.c.a.d> remove = aVar.e.remove(str);
        if (remove != null) {
            com.microsoft.appcenter.e.a.b("AppCenter", "Sending logs groupName=" + str2 + " id=" + str + " failed", exc);
            boolean a2 = j.a(exc);
            if (a2) {
                aVar.h += remove.size();
            } else {
                b.a aVar2 = aVar.g;
                if (aVar2 != null) {
                    for (com.microsoft.appcenter.c.a.d dVar : remove) {
                        aVar2.a(dVar, exc);
                    }
                }
            }
            a(!a2, exc);
        }
    }

    private void a(boolean z, Exception exc) {
        b.a aVar;
        this.j = false;
        this.k = z;
        this.m++;
        for (a aVar2 : this.d.values()) {
            a(aVar2);
            Iterator<Map.Entry<String, List<com.microsoft.appcenter.c.a.d>>> it = aVar2.e.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<String, List<com.microsoft.appcenter.c.a.d>> next = it.next();
                it.remove();
                if (z && (aVar = aVar2.g) != null) {
                    for (com.microsoft.appcenter.c.a.d dVar : next.getValue()) {
                        aVar.a(dVar, exc);
                    }
                }
            }
        }
        for (com.microsoft.appcenter.c.b bVar : this.h) {
            try {
                bVar.close();
            } catch (IOException e) {
                com.microsoft.appcenter.e.a.b("AppCenter", "Failed to close ingestion: " + bVar, e);
            }
        }
        if (!z) {
            this.f.a();
            return;
        }
        for (a aVar3 : this.d.values()) {
            c(aVar3);
        }
    }

    private synchronized boolean a(a aVar, int i) {
        boolean z;
        if (i == this.m) {
            if (aVar == this.d.get(aVar.a)) {
                z = true;
            }
        }
        z = false;
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(a aVar, int i) {
        if (a(aVar, i)) {
            b(aVar);
        }
    }

    private void c(a aVar) {
        ArrayList<com.microsoft.appcenter.c.a.d> arrayList = new ArrayList();
        this.f.a(aVar.a, Collections.emptyList(), 100, arrayList, null, null);
        if (arrayList.size() > 0 && aVar.g != null) {
            for (com.microsoft.appcenter.c.a.d dVar : arrayList) {
                aVar.g.a(dVar);
                aVar.g.a(dVar, new com.microsoft.appcenter.e());
            }
        }
        if (arrayList.size() < 100 || aVar.g == null) {
            this.f.b(aVar.a);
        } else {
            c(aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void d(final a aVar) {
        final String str;
        Date date;
        if (!this.j) {
            return;
        }
        int i = aVar.h;
        int min = Math.min(i, aVar.b);
        com.microsoft.appcenter.e.a.b("AppCenter", "triggerIngestion(" + aVar.a + ") pendingLogCount=" + i);
        a(aVar);
        if (aVar.e.size() == aVar.d) {
            com.microsoft.appcenter.e.a.b("AppCenter", "Already sending " + aVar.d + " batches of analytics data to the server.");
            return;
        }
        com.microsoft.appcenter.e.b.b a2 = com.microsoft.appcenter.e.b.b.a();
        ListIterator<com.microsoft.appcenter.e.b.d> listIterator = a2.c().listIterator();
        while (listIterator.hasNext()) {
            com.microsoft.appcenter.e.b.d next = listIterator.next();
            Date date2 = null;
            if (next != null) {
                String b = next.b();
                Date c = next.c();
                Date d = next.d();
                a2.a(next);
                date = c;
                str = b;
                date2 = d;
            } else {
                str = null;
                date = null;
            }
            final ArrayList<com.microsoft.appcenter.c.a.d> arrayList = new ArrayList(min);
            final int i2 = this.m;
            final String a3 = this.f.a(aVar.a, aVar.k, min, arrayList, date, date2);
            aVar.h -= arrayList.size();
            if (a3 != null) {
                com.microsoft.appcenter.e.a.b("AppCenter", "ingestLogs(" + aVar.a + "," + a3 + ") pendingLogCount=" + aVar.h);
                if (aVar.g != null) {
                    for (com.microsoft.appcenter.c.a.d dVar : arrayList) {
                        aVar.g.a(dVar);
                    }
                }
                aVar.e.put(a3, arrayList);
                com.microsoft.appcenter.e.c.a(new Runnable() { // from class: com.microsoft.appcenter.a.c.1
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.a(aVar, i2, arrayList, a3, str);
                    }
                });
                return;
            } else if (listIterator.previousIndex() == 0 && date2 != null && this.f.a(date2) == 0) {
                a2.a(str);
            }
        }
        aVar.h = this.f.c(aVar.a);
    }

    private Long e(a aVar) {
        return aVar.c > 3000 ? f(aVar) : g(aVar);
    }

    private Long f(a aVar) {
        long j;
        long currentTimeMillis = System.currentTimeMillis();
        long a2 = com.microsoft.appcenter.e.d.d.a("startTimerPrefix." + aVar.a);
        if (aVar.h <= 0) {
            if (a2 + aVar.c >= currentTimeMillis) {
                return null;
            }
            com.microsoft.appcenter.e.d.d.c("startTimerPrefix." + aVar.a);
            com.microsoft.appcenter.e.a.b("AppCenter", "The timer for " + aVar.a + " channel finished.");
            return null;
        }
        if (a2 == 0 || a2 > currentTimeMillis) {
            com.microsoft.appcenter.e.d.d.b("startTimerPrefix." + aVar.a, currentTimeMillis);
            com.microsoft.appcenter.e.a.b("AppCenter", "The timer value for " + aVar.a + " has been saved.");
            j = aVar.c;
        } else {
            j = Math.max(aVar.c - (currentTimeMillis - a2), 0L);
        }
        return Long.valueOf(j);
    }

    private Long g(a aVar) {
        if (aVar.h >= aVar.b) {
            return 0L;
        }
        if (aVar.h <= 0) {
            return null;
        }
        return Long.valueOf(aVar.c);
    }

    @Override // com.microsoft.appcenter.a.b
    public synchronized void a() {
        a(false, (Exception) new com.microsoft.appcenter.e());
    }

    @Override // com.microsoft.appcenter.a.b
    public synchronized void a(b.InterfaceC0058b interfaceC0058b) {
        this.e.add(interfaceC0058b);
    }

    void a(a aVar) {
        if (aVar.i) {
            aVar.i = false;
            this.i.removeCallbacks(aVar.l);
            com.microsoft.appcenter.e.d.d.c("startTimerPrefix." + aVar.a);
        }
    }

    @Override // com.microsoft.appcenter.a.b
    public synchronized void a(com.microsoft.appcenter.c.a.d dVar, String str, int i) {
        boolean z;
        a aVar = this.d.get(str);
        if (aVar == null) {
            com.microsoft.appcenter.e.a.e("AppCenter", "Invalid group name:" + str);
        } else if (this.k) {
            com.microsoft.appcenter.e.a.d("AppCenter", "Channel is disabled, the log is discarded.");
            if (aVar.g != null) {
                aVar.g.a(dVar);
                aVar.g.a(dVar, new com.microsoft.appcenter.e());
            }
        } else {
            for (b.InterfaceC0058b interfaceC0058b : this.e) {
                interfaceC0058b.a(dVar, str);
            }
            if (dVar.r() == null) {
                if (this.l == null) {
                    try {
                        this.l = com.microsoft.appcenter.e.b.a(this.a);
                    } catch (b.a e) {
                        com.microsoft.appcenter.e.a.b("AppCenter", "Device log cannot be generated", e);
                        return;
                    }
                }
                dVar.a(this.l);
            }
            if (dVar.n() == null) {
                dVar.b(new Date());
            }
            for (b.InterfaceC0058b interfaceC0058b2 : this.e) {
                interfaceC0058b2.a(dVar, str, i);
            }
            loop2: while (true) {
                z = false;
                for (b.InterfaceC0058b interfaceC0058b3 : this.e) {
                    if (z || interfaceC0058b3.a(dVar)) {
                        z = true;
                    }
                }
            }
            if (z) {
                com.microsoft.appcenter.e.a.b("AppCenter", "Log of type '" + dVar.a() + "' was filtered out by listener(s)");
            } else if (this.b == null && aVar.f == this.g) {
                com.microsoft.appcenter.e.a.b("AppCenter", "Log of type '" + dVar.a() + "' was not filtered out by listener(s) but no app secret was provided. Not persisting/sending the log.");
            } else {
                try {
                    this.f.a(dVar, str, i);
                    Iterator<String> it = dVar.t().iterator();
                    String a2 = it.hasNext() ? k.a(it.next()) : null;
                    if (aVar.k.contains(a2)) {
                        com.microsoft.appcenter.e.a.b("AppCenter", "Transmission target ikey=" + a2 + " is paused.");
                        return;
                    }
                    aVar.h++;
                    com.microsoft.appcenter.e.a.b("AppCenter", "enqueue(" + aVar.a + ") pendingLogCount=" + aVar.h);
                    if (this.j) {
                        b(aVar);
                    } else {
                        com.microsoft.appcenter.e.a.b("AppCenter", "Channel is temporarily disabled, log was saved to disk.");
                    }
                } catch (b.a e2) {
                    com.microsoft.appcenter.e.a.b("AppCenter", "Error persisting log", e2);
                    if (aVar.g == null) {
                        return;
                    }
                    aVar.g.a(dVar);
                    aVar.g.a(dVar, e2);
                }
            }
        }
    }

    @Override // com.microsoft.appcenter.a.b
    public synchronized void a(String str) {
        this.b = str;
        if (this.j) {
            for (a aVar : this.d.values()) {
                if (aVar.f == this.g) {
                    b(aVar);
                }
            }
        }
    }

    @Override // com.microsoft.appcenter.a.b
    public synchronized void a(String str, int i, long j, int i2, com.microsoft.appcenter.c.b bVar, b.a aVar) {
        com.microsoft.appcenter.e.a.b("AppCenter", "addGroup(" + str + ")");
        com.microsoft.appcenter.c.b bVar2 = bVar == null ? this.g : bVar;
        this.h.add(bVar2);
        a aVar2 = new a(str, i, j, i2, bVar2, aVar);
        this.d.put(str, aVar2);
        aVar2.h = this.f.c(str);
        com.microsoft.appcenter.e.b.b.a().a(aVar2);
        if (this.b != null || this.g != bVar2) {
            b(aVar2);
        }
        for (b.InterfaceC0058b interfaceC0058b : this.e) {
            interfaceC0058b.a(str, aVar, j);
        }
    }

    @Override // com.microsoft.appcenter.a.b
    public synchronized void a(boolean z) {
        if (this.j == z) {
            return;
        }
        if (z) {
            this.j = true;
            this.k = false;
            this.m++;
            for (com.microsoft.appcenter.c.b bVar : this.h) {
                bVar.a();
            }
            for (a aVar : this.d.values()) {
                b(aVar);
            }
        } else {
            a(true, (Exception) new com.microsoft.appcenter.e());
        }
        for (b.InterfaceC0058b interfaceC0058b : this.e) {
            interfaceC0058b.a(z);
        }
    }

    @Override // com.microsoft.appcenter.a.b
    public synchronized boolean a(long j) {
        return this.f.a(j);
    }

    @Override // com.microsoft.appcenter.a.b
    public synchronized void b(b.InterfaceC0058b interfaceC0058b) {
        this.e.remove(interfaceC0058b);
    }

    synchronized void b(a aVar) {
        com.microsoft.appcenter.e.a.b("AppCenter", String.format("checkPendingLogs(%s) pendingLogCount=%s batchTimeInterval=%s", aVar.a, Integer.valueOf(aVar.h), Long.valueOf(aVar.c)));
        Long e = e(aVar);
        if (e != null && !aVar.j) {
            if (e.longValue() == 0) {
                d(aVar);
            } else if (!aVar.i) {
                aVar.i = true;
                this.i.postDelayed(aVar.l, e.longValue());
            }
        }
    }

    @Override // com.microsoft.appcenter.a.b
    public synchronized void b(String str) {
        com.microsoft.appcenter.e.a.b("AppCenter", "removeGroup(" + str + ")");
        a remove = this.d.remove(str);
        if (remove != null) {
            a(remove);
            com.microsoft.appcenter.e.b.b.a().b(remove);
        }
        for (b.InterfaceC0058b interfaceC0058b : this.e) {
            interfaceC0058b.a(str);
        }
    }

    @Override // com.microsoft.appcenter.a.b
    public synchronized void c(String str) {
        this.g.a(str);
    }

    @Override // com.microsoft.appcenter.a.b
    public synchronized void d(String str) {
        if (!this.d.containsKey(str)) {
            return;
        }
        com.microsoft.appcenter.e.a.b("AppCenter", "clear(" + str + ")");
        this.f.b(str);
        for (b.InterfaceC0058b interfaceC0058b : this.e) {
            interfaceC0058b.b(str);
        }
    }
}
