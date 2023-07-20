package com.google.firebase.components;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* loaded from: classes.dex */
class m {

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        private final com.google.firebase.components.b<?> a;
        private final Set<a> b = new HashSet();
        private final Set<a> c = new HashSet();

        a(com.google.firebase.components.b<?> bVar) {
            this.a = bVar;
        }

        Set<a> a() {
            return this.b;
        }

        void a(a aVar) {
            this.b.add(aVar);
        }

        com.google.firebase.components.b<?> b() {
            return this.a;
        }

        void b(a aVar) {
            this.c.add(aVar);
        }

        void c(a aVar) {
            this.c.remove(aVar);
        }

        boolean c() {
            return this.c.isEmpty();
        }

        boolean d() {
            return this.b.isEmpty();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {
        private final Class<?> a;
        private final boolean b;

        private b(Class<?> cls, boolean z) {
            this.a = cls;
            this.b = z;
        }

        public boolean equals(Object obj) {
            if (obj instanceof b) {
                b bVar = (b) obj;
                return bVar.a.equals(this.a) && bVar.b == this.b;
            }
            return false;
        }

        public int hashCode() {
            return ((this.a.hashCode() ^ 1000003) * 1000003) ^ Boolean.valueOf(this.b).hashCode();
        }
    }

    private static Set<a> a(Set<a> set) {
        HashSet hashSet = new HashSet();
        for (a aVar : set) {
            if (aVar.c()) {
                hashSet.add(aVar);
            }
        }
        return hashSet;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(List<com.google.firebase.components.b<?>> list) {
        Set<a> b2 = b(list);
        Set<a> a2 = a(b2);
        int i = 0;
        while (!a2.isEmpty()) {
            a next = a2.iterator().next();
            a2.remove(next);
            i++;
            for (a aVar : next.a()) {
                aVar.c(next);
                if (aVar.c()) {
                    a2.add(aVar);
                }
            }
        }
        if (i == list.size()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (a aVar2 : b2) {
            if (!aVar2.c() && !aVar2.d()) {
                arrayList.add(aVar2.b());
            }
        }
        throw new o(arrayList);
    }

    private static Set<a> b(List<com.google.firebase.components.b<?>> list) {
        Set<a> set;
        HashMap hashMap = new HashMap(list.size());
        for (com.google.firebase.components.b<?> bVar : list) {
            a aVar = new a(bVar);
            for (Class<? super Object> cls : bVar.a()) {
                b bVar2 = new b(cls, !bVar.g());
                if (!hashMap.containsKey(bVar2)) {
                    hashMap.put(bVar2, new HashSet());
                }
                Set set2 = (Set) hashMap.get(bVar2);
                if (!set2.isEmpty() && !bVar2.b) {
                    throw new IllegalArgumentException(String.format("Multiple components provide %s.", cls));
                }
                set2.add(aVar);
            }
        }
        for (Set<a> set3 : hashMap.values()) {
            for (a aVar2 : set3) {
                for (n nVar : aVar2.b().b()) {
                    if (nVar.d() && (set = (Set) hashMap.get(new b(nVar.a(), nVar.c()))) != null) {
                        for (a aVar3 : set) {
                            aVar2.a(aVar3);
                            aVar3.b(aVar2);
                        }
                    }
                }
            }
        }
        HashSet hashSet = new HashSet();
        for (Set set4 : hashMap.values()) {
            hashSet.addAll(set4);
        }
        return hashSet;
    }
}
