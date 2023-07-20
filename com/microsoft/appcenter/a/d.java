package com.microsoft.appcenter.a;

import android.content.Context;
import com.microsoft.appcenter.a.b;
import com.microsoft.appcenter.c.a.a.g;
import com.microsoft.appcenter.c.a.b.m;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/* loaded from: classes.dex */
public class d extends com.microsoft.appcenter.a.a {
    private final b a;
    private final g b;
    private final UUID c;
    private final com.microsoft.appcenter.c.b d;
    private final Map<String, a> e;

    /* loaded from: classes.dex */
    private static class a {
        final String a;
        long b;

        a(String str) {
            this.a = str;
        }
    }

    public d(Context context, b bVar, g gVar, UUID uuid) {
        this(new com.microsoft.appcenter.c.c(context, gVar), bVar, gVar, uuid);
    }

    d(com.microsoft.appcenter.c.c cVar, b bVar, g gVar, UUID uuid) {
        this.e = new HashMap();
        this.a = bVar;
        this.b = gVar;
        this.c = uuid;
        this.d = cVar;
    }

    private static boolean b(com.microsoft.appcenter.c.a.d dVar) {
        return !(dVar instanceof com.microsoft.appcenter.c.a.b.c) && !dVar.t().isEmpty();
    }

    private static String d(String str) {
        return str + "/one";
    }

    private static boolean e(String str) {
        return str.endsWith("/one");
    }

    @Override // com.microsoft.appcenter.a.a, com.microsoft.appcenter.a.b.InterfaceC0058b
    public void a(com.microsoft.appcenter.c.a.d dVar, String str, int i) {
        if (!b(dVar)) {
            return;
        }
        try {
            Collection<com.microsoft.appcenter.c.a.b.c> b = this.b.b(dVar);
            for (com.microsoft.appcenter.c.a.b.c cVar : b) {
                cVar.a(Long.valueOf(i));
                a aVar = this.e.get(cVar.e());
                if (aVar == null) {
                    aVar = new a(UUID.randomUUID().toString());
                    this.e.put(cVar.e(), aVar);
                }
                m h = cVar.h().h();
                h.b(aVar.a);
                long j = aVar.b + 1;
                aVar.b = j;
                h.a(Long.valueOf(j));
                h.a(this.c);
            }
            String d = d(str);
            for (com.microsoft.appcenter.c.a.b.c cVar2 : b) {
                this.a.a(cVar2, d, i);
            }
        } catch (IllegalArgumentException e) {
            com.microsoft.appcenter.e.a.e("AppCenter", "Cannot send a log to one collector: " + e.getMessage());
        }
    }

    @Override // com.microsoft.appcenter.a.a, com.microsoft.appcenter.a.b.InterfaceC0058b
    public void a(String str) {
        if (e(str)) {
            return;
        }
        this.a.b(d(str));
    }

    @Override // com.microsoft.appcenter.a.a, com.microsoft.appcenter.a.b.InterfaceC0058b
    public void a(String str, b.a aVar, long j) {
        if (e(str)) {
            return;
        }
        this.a.a(d(str), 50, j, 2, this.d, aVar);
    }

    @Override // com.microsoft.appcenter.a.a, com.microsoft.appcenter.a.b.InterfaceC0058b
    public void a(boolean z) {
        if (!z) {
            this.e.clear();
        }
    }

    @Override // com.microsoft.appcenter.a.a, com.microsoft.appcenter.a.b.InterfaceC0058b
    public boolean a(com.microsoft.appcenter.c.a.d dVar) {
        return b(dVar);
    }

    @Override // com.microsoft.appcenter.a.a, com.microsoft.appcenter.a.b.InterfaceC0058b
    public void b(String str) {
        if (e(str)) {
            return;
        }
        this.a.d(d(str));
    }

    public void c(String str) {
        this.d.a(str);
    }
}
