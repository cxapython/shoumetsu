package com.microsoft.appcenter.analytics.b.a.a;

import com.microsoft.appcenter.c.a.b.k;
import com.microsoft.appcenter.c.a.d;
import java.util.Collection;
import java.util.LinkedList;

/* loaded from: classes.dex */
public class a extends com.microsoft.appcenter.c.a.a.a {
    @Override // com.microsoft.appcenter.c.a.a.f
    /* renamed from: a */
    public com.microsoft.appcenter.analytics.b.a.a b() {
        return new com.microsoft.appcenter.analytics.b.a.a();
    }

    @Override // com.microsoft.appcenter.c.a.a.a, com.microsoft.appcenter.c.a.a.f
    public Collection<com.microsoft.appcenter.c.a.b.c> a(d dVar) {
        LinkedList linkedList = new LinkedList();
        for (String str : dVar.t()) {
            com.microsoft.appcenter.analytics.b.a.b.a aVar = new com.microsoft.appcenter.analytics.b.a.b.a();
            com.microsoft.appcenter.analytics.b.a.a aVar2 = (com.microsoft.appcenter.analytics.b.a.a) dVar;
            k.a(aVar, aVar2.d());
            k.a(dVar, aVar, str);
            com.microsoft.appcenter.c.a.b.b.a(aVar2.c(), aVar);
            linkedList.add(aVar);
            aVar.a(dVar.s());
        }
        return linkedList;
    }
}
