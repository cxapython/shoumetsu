package com.microsoft.appcenter.analytics;

import android.content.Context;
import com.microsoft.appcenter.a.b;
import com.microsoft.appcenter.c.a.b.k;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class a {
    static b a;
    final a b;
    Context c;
    private final String d;
    private final Map<String, a> e = new HashMap();
    private final d f = new d(this);
    private com.microsoft.appcenter.a.b g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(String str, a aVar) {
        this.d = str;
        this.b = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static b.InterfaceC0058b a() {
        return new com.microsoft.appcenter.a.a() { // from class: com.microsoft.appcenter.analytics.a.1
            @Override // com.microsoft.appcenter.a.a, com.microsoft.appcenter.a.b.InterfaceC0058b
            public void a(com.microsoft.appcenter.c.a.d dVar, String str) {
                a.b(dVar);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(com.microsoft.appcenter.c.a.d dVar) {
        b bVar = a;
        if (bVar == null || !(dVar instanceof com.microsoft.appcenter.c.a.b.c)) {
            return;
        }
        ((com.microsoft.appcenter.c.a.b.c) dVar).h().b().a(Collections.singletonList(bVar.a()));
        a.c();
    }

    private String d() {
        return Analytics.getInstance().m() + k.a(this.d);
    }

    private boolean e() {
        return com.microsoft.appcenter.e.d.d.a(d(), true);
    }

    private boolean f() {
        for (a aVar = this.b; aVar != null; aVar = aVar.b) {
            if (!aVar.e()) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Context context, com.microsoft.appcenter.a.b bVar) {
        this.c = context;
        this.g = bVar;
        bVar.a(this.f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b() {
        return f() && e();
    }

    public d c() {
        return this.f;
    }
}
