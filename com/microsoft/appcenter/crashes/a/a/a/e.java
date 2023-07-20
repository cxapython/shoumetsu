package com.microsoft.appcenter.crashes.a.a.a;

import com.microsoft.appcenter.c.a.a.h;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class e implements h<com.microsoft.appcenter.crashes.a.a.f> {
    private static final e a = new e();

    private e() {
    }

    public static e a() {
        return a;
    }

    @Override // com.microsoft.appcenter.c.a.a.h
    public List<com.microsoft.appcenter.crashes.a.a.f> a(int i) {
        return new ArrayList(i);
    }

    @Override // com.microsoft.appcenter.c.a.a.h
    /* renamed from: b */
    public com.microsoft.appcenter.crashes.a.a.f c() {
        return new com.microsoft.appcenter.crashes.a.a.f();
    }
}
