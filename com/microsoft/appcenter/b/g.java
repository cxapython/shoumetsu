package com.microsoft.appcenter.b;

import com.microsoft.appcenter.b.d;
import com.microsoft.appcenter.e.f;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public class g extends f implements f.b {
    private final com.microsoft.appcenter.e.f b;
    private final Set<a> c;

    /* loaded from: classes.dex */
    private class a extends e {
        a(d dVar, String str, String str2, Map<String, String> map, d.a aVar, l lVar) {
            super(dVar, str, str2, map, aVar, lVar);
        }
    }

    public g(d dVar, com.microsoft.appcenter.e.f fVar) {
        super(dVar);
        this.c = new HashSet();
        this.b = fVar;
        this.b.a(this);
    }

    @Override // com.microsoft.appcenter.b.d
    public synchronized k a(String str, String str2, Map<String, String> map, d.a aVar, l lVar) {
        a aVar2;
        aVar2 = new a(this.a, str, str2, map, aVar, lVar);
        if (this.b.b()) {
            aVar2.run();
        } else {
            this.c.add(aVar2);
            com.microsoft.appcenter.e.a.b("AppCenter", "Call triggered with no network connectivity, waiting network to become available...");
        }
        return aVar2;
    }

    @Override // com.microsoft.appcenter.b.f, com.microsoft.appcenter.b.d
    public void a() {
        this.b.a(this);
        super.a();
    }

    @Override // com.microsoft.appcenter.e.f.b
    public synchronized void a(boolean z) {
        if (z) {
            if (this.c.size() > 0) {
                com.microsoft.appcenter.e.a.b("AppCenter", "Network is available. " + this.c.size() + " pending call(s) to submit now.");
                for (a aVar : this.c) {
                    aVar.run();
                }
                this.c.clear();
            }
        }
    }

    @Override // com.microsoft.appcenter.b.f, java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        this.b.b(this);
        this.c.clear();
        super.close();
    }
}
