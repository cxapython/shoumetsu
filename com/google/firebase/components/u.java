package com.google.firebase.components;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class u extends com.google.firebase.components.a {
    private final Set<Class<?>> a;
    private final Set<Class<?>> b;
    private final Set<Class<?>> c;
    private final Set<Class<?>> d;
    private final Set<Class<?>> e;
    private final e f;

    /* loaded from: classes.dex */
    private static class a implements com.google.firebase.b.c {
        private final Set<Class<?>> a;
        private final com.google.firebase.b.c b;

        public a(Set<Class<?>> set, com.google.firebase.b.c cVar) {
            this.a = set;
            this.b = cVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(b<?> bVar, e eVar) {
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        HashSet hashSet3 = new HashSet();
        HashSet hashSet4 = new HashSet();
        for (n nVar : bVar.b()) {
            if (nVar.d()) {
                if (nVar.c()) {
                    hashSet3.add(nVar.a());
                } else {
                    hashSet.add(nVar.a());
                }
            } else if (nVar.c()) {
                hashSet4.add(nVar.a());
            } else {
                hashSet2.add(nVar.a());
            }
        }
        if (!bVar.d().isEmpty()) {
            hashSet.add(com.google.firebase.b.c.class);
        }
        this.a = Collections.unmodifiableSet(hashSet);
        this.b = Collections.unmodifiableSet(hashSet2);
        this.c = Collections.unmodifiableSet(hashSet3);
        this.d = Collections.unmodifiableSet(hashSet4);
        this.e = bVar.d();
        this.f = eVar;
    }

    @Override // com.google.firebase.components.a, com.google.firebase.components.e
    public <T> T a(Class<T> cls) {
        if (this.a.contains(cls)) {
            T t = (T) this.f.a(cls);
            return !cls.equals(com.google.firebase.b.c.class) ? t : (T) new a(this.e, (com.google.firebase.b.c) t);
        }
        throw new IllegalArgumentException(String.format("Attempting to request an undeclared dependency %s.", cls));
    }

    @Override // com.google.firebase.components.a, com.google.firebase.components.e
    public <T> Set<T> b(Class<T> cls) {
        if (this.c.contains(cls)) {
            return this.f.b(cls);
        }
        throw new IllegalArgumentException(String.format("Attempting to request an undeclared dependency Set<%s>.", cls));
    }

    @Override // com.google.firebase.components.e
    public <T> com.google.firebase.c.a<T> c(Class<T> cls) {
        if (this.b.contains(cls)) {
            return this.f.c(cls);
        }
        throw new IllegalArgumentException(String.format("Attempting to request an undeclared dependency Provider<%s>.", cls));
    }

    @Override // com.google.firebase.components.e
    public <T> com.google.firebase.c.a<Set<T>> d(Class<T> cls) {
        if (this.d.contains(cls)) {
            return this.f.d(cls);
        }
        throw new IllegalArgumentException(String.format("Attempting to request an undeclared dependency Provider<Set<%s>>.", cls));
    }
}
