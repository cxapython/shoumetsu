package com.google.firebase.components;

import java.util.Set;

/* loaded from: classes.dex */
abstract class a implements e {
    @Override // com.google.firebase.components.e
    public <T> T a(Class<T> cls) {
        com.google.firebase.c.a<T> c = c(cls);
        if (c == null) {
            return null;
        }
        return c.a();
    }

    @Override // com.google.firebase.components.e
    public <T> Set<T> b(Class<T> cls) {
        return d(cls).a();
    }
}
