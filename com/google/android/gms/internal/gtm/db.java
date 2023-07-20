package com.google.android.gms.internal.gtm;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class db {
    private static final db a = new db();
    private final ConcurrentMap<Class<?>, de<?>> c = new ConcurrentHashMap();
    private final df b = new cl();

    private db() {
    }

    public static db a() {
        return a;
    }

    public final <T> de<T> a(Class<T> cls) {
        zzre.a(cls, "messageType");
        de<T> deVar = (de<T>) this.c.get(cls);
        if (deVar == null) {
            de<T> a2 = this.b.a(cls);
            zzre.a(cls, "messageType");
            zzre.a(a2, "schema");
            de<T> deVar2 = (de<T>) this.c.putIfAbsent(cls, a2);
            return deVar2 != null ? deVar2 : a2;
        }
        return deVar;
    }

    public final <T> de<T> a(T t) {
        return a((Class) t.getClass());
    }
}
