package com.google.firebase.components;

import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public class i extends a {
    private static final com.google.firebase.c.a<Set<Object>> a = l.b();
    private final Map<b<?>, s<?>> b = new HashMap();
    private final Map<Class<?>, s<?>> c = new HashMap();
    private final Map<Class<?>, s<Set<?>>> d = new HashMap();
    private final q e;

    public i(Executor executor, Iterable<h> iterable, b<?>... bVarArr) {
        this.e = new q(executor);
        ArrayList<b<?>> arrayList = new ArrayList();
        arrayList.add(b.a(this.e, q.class, com.google.firebase.b.d.class, com.google.firebase.b.c.class));
        for (h hVar : iterable) {
            arrayList.addAll(hVar.getComponents());
        }
        Collections.addAll(arrayList, bVarArr);
        m.a(arrayList);
        for (b<?> bVar : arrayList) {
            this.b.put(bVar, new s<>(j.a(this, bVar)));
        }
        a();
        b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Set a(Set set) {
        HashSet hashSet = new HashSet();
        Iterator it = set.iterator();
        while (it.hasNext()) {
            hashSet.add(((s) it.next()).a());
        }
        return Collections.unmodifiableSet(hashSet);
    }

    private void a() {
        for (Map.Entry<b<?>, s<?>> entry : this.b.entrySet()) {
            b<?> key = entry.getKey();
            if (key.g()) {
                s<?> value = entry.getValue();
                for (Class<? super Object> cls : key.a()) {
                    this.c.put(cls, value);
                }
            }
        }
        c();
    }

    private void b() {
        HashMap hashMap = new HashMap();
        for (Map.Entry<b<?>, s<?>> entry : this.b.entrySet()) {
            b<?> key = entry.getKey();
            if (!key.g()) {
                s<?> value = entry.getValue();
                for (Class<? super Object> cls : key.a()) {
                    if (!hashMap.containsKey(cls)) {
                        hashMap.put(cls, new HashSet());
                    }
                    ((Set) hashMap.get(cls)).add(value);
                }
            }
        }
        for (Map.Entry entry2 : hashMap.entrySet()) {
            this.d.put((Class) entry2.getKey(), new s<>(k.a((Set) entry2.getValue())));
        }
    }

    private void c() {
        for (b<?> bVar : this.b.keySet()) {
            for (n nVar : bVar.b()) {
                if (nVar.b() && !this.c.containsKey(nVar.a())) {
                    throw new t(String.format("Unsatisfied dependency for component %s: %s", bVar, nVar.a()));
                }
            }
        }
    }

    @Override // com.google.firebase.components.a, com.google.firebase.components.e
    public /* bridge */ /* synthetic */ Object a(Class cls) {
        return super.a(cls);
    }

    public void a(boolean z) {
        for (Map.Entry<b<?>, s<?>> entry : this.b.entrySet()) {
            b<?> key = entry.getKey();
            s<?> value = entry.getValue();
            if (key.e() || (key.f() && z)) {
                value.a();
            }
        }
        this.e.a();
    }

    @Override // com.google.firebase.components.a, com.google.firebase.components.e
    public /* bridge */ /* synthetic */ Set b(Class cls) {
        return super.b(cls);
    }

    @Override // com.google.firebase.components.e
    public <T> com.google.firebase.c.a<T> c(Class<T> cls) {
        Preconditions.checkNotNull(cls, "Null interface requested.");
        return this.c.get(cls);
    }

    @Override // com.google.firebase.components.e
    public <T> com.google.firebase.c.a<Set<T>> d(Class<T> cls) {
        s<Set<?>> sVar = this.d.get(cls);
        return sVar != null ? sVar : (com.google.firebase.c.a<Set<T>>) a;
    }
}
