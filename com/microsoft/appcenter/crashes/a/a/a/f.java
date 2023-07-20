package com.microsoft.appcenter.crashes.a.a.a;

import com.microsoft.appcenter.c.a.a.h;
import com.microsoft.appcenter.crashes.a.a.g;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class f implements h<g> {
    private static final f a = new f();

    private f() {
    }

    public static f a() {
        return a;
    }

    @Override // com.microsoft.appcenter.c.a.a.h
    public List<g> a(int i) {
        return new ArrayList(i);
    }

    @Override // com.microsoft.appcenter.c.a.a.h
    /* renamed from: b */
    public g c() {
        return new g();
    }
}
