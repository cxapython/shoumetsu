package com.microsoft.appcenter.crashes.a.a.a;

import com.microsoft.appcenter.c.a.a.h;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class b implements h<com.microsoft.appcenter.crashes.a.a.c> {
    private static final b a = new b();

    private b() {
    }

    public static b a() {
        return a;
    }

    @Override // com.microsoft.appcenter.c.a.a.h
    public List<com.microsoft.appcenter.crashes.a.a.c> a(int i) {
        return new ArrayList(i);
    }

    @Override // com.microsoft.appcenter.c.a.a.h
    /* renamed from: b */
    public com.microsoft.appcenter.crashes.a.a.c c() {
        return new com.microsoft.appcenter.crashes.a.a.c();
    }
}
