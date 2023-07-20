package com.microsoft.appcenter.b;

import com.microsoft.appcenter.b.d;
import java.util.Map;

/* loaded from: classes.dex */
abstract class e implements k, l, Runnable {
    final l a;
    k b;
    private final d c;
    private final String d;
    private final String e;
    private final Map<String, String> f;
    private final d.a g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar, String str, String str2, Map<String, String> map, d.a aVar, l lVar) {
        this.c = dVar;
        this.d = str;
        this.e = str2;
        this.f = map;
        this.g = aVar;
        this.a = lVar;
    }

    @Override // com.microsoft.appcenter.b.l
    public void a(Exception exc) {
        this.a.a(exc);
    }

    @Override // com.microsoft.appcenter.b.l
    public void a(String str, Map<String, String> map) {
        this.a.a(str, map);
    }

    @Override // java.lang.Runnable
    public synchronized void run() {
        this.b = this.c.a(this.d, this.e, this.f, this.g, this);
    }
}
