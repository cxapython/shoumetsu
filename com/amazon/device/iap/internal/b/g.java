package com.amazon.device.iap.internal.b;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public final class g implements com.amazon.device.iap.internal.b {
    private static final Map<Class, Class> a = new HashMap();

    static {
        a.put(com.amazon.device.iap.internal.c.class, c.class);
        a.put(com.amazon.device.iap.internal.a.class, f.class);
    }

    @Override // com.amazon.device.iap.internal.b
    public <T> Class<T> a(Class<T> cls) {
        return a.get(cls);
    }
}
