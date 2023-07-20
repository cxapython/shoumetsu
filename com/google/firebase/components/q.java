package com.google.firebase.components;

import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
class q implements com.google.firebase.b.c, com.google.firebase.b.d {
    private final Map<Class<?>, ConcurrentHashMap<com.google.firebase.b.b<Object>, Executor>> a = new HashMap();
    private Queue<com.google.firebase.b.a<?>> b = new ArrayDeque();
    private final Executor c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(Executor executor) {
        this.c = executor;
    }

    private synchronized Set<Map.Entry<com.google.firebase.b.b<Object>, Executor>> b(com.google.firebase.b.a<?> aVar) {
        ConcurrentHashMap<com.google.firebase.b.b<Object>, Executor> concurrentHashMap;
        concurrentHashMap = this.a.get(aVar.a());
        return concurrentHashMap == null ? Collections.emptySet() : concurrentHashMap.entrySet();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        Queue<com.google.firebase.b.a<?>> queue;
        synchronized (this) {
            if (this.b != null) {
                queue = this.b;
                this.b = null;
            } else {
                queue = null;
            }
        }
        if (queue != null) {
            for (com.google.firebase.b.a<?> aVar : queue) {
                a(aVar);
            }
        }
    }

    public void a(com.google.firebase.b.a<?> aVar) {
        Preconditions.checkNotNull(aVar);
        synchronized (this) {
            if (this.b != null) {
                this.b.add(aVar);
                return;
            }
            for (Map.Entry<com.google.firebase.b.b<Object>, Executor> entry : b(aVar)) {
                entry.getValue().execute(r.a(entry, aVar));
            }
        }
    }

    @Override // com.google.firebase.b.d
    public <T> void a(Class<T> cls, com.google.firebase.b.b<? super T> bVar) {
        a(cls, this.c, bVar);
    }

    public synchronized <T> void a(Class<T> cls, Executor executor, com.google.firebase.b.b<? super T> bVar) {
        Preconditions.checkNotNull(cls);
        Preconditions.checkNotNull(bVar);
        Preconditions.checkNotNull(executor);
        if (!this.a.containsKey(cls)) {
            this.a.put(cls, new ConcurrentHashMap<>());
        }
        this.a.get(cls).put(bVar, executor);
    }
}
