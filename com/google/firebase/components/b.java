package com.google.firebase.components;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@KeepForSdk
/* loaded from: classes.dex */
public final class b<T> {
    private final Set<Class<? super T>> a;
    private final Set<n> b;
    private final int c;
    private final int d;
    private final g<T> e;
    private final Set<Class<?>> f;

    @KeepForSdk
    /* loaded from: classes.dex */
    public static class a<T> {
        private final Set<Class<? super T>> a;
        private final Set<n> b;
        private int c;
        private int d;
        private g<T> e;
        private Set<Class<?>> f;

        @SafeVarargs
        private a(Class<T> cls, Class<? super T>... clsArr) {
            this.a = new HashSet();
            this.b = new HashSet();
            this.c = 0;
            this.d = 0;
            this.f = new HashSet();
            Preconditions.checkNotNull(cls, "Null interface");
            this.a.add(cls);
            for (Class<? super T> cls2 : clsArr) {
                Preconditions.checkNotNull(cls2, "Null interface");
            }
            Collections.addAll(this.a, clsArr);
        }

        private a<T> a(int i) {
            Preconditions.checkState(this.c == 0, "Instantiation type has already been set.");
            this.c = i;
            return this;
        }

        private void a(Class<?> cls) {
            Preconditions.checkArgument(!this.a.contains(cls), "Components are not allowed to depend on interfaces they themselves provide.");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public a<T> c() {
            this.d = 1;
            return this;
        }

        @KeepForSdk
        public a<T> a() {
            return a(1);
        }

        @KeepForSdk
        public a<T> a(g<T> gVar) {
            this.e = (g) Preconditions.checkNotNull(gVar, "Null factory");
            return this;
        }

        @KeepForSdk
        public a<T> a(n nVar) {
            Preconditions.checkNotNull(nVar, "Null dependency");
            a(nVar.a());
            this.b.add(nVar);
            return this;
        }

        @KeepForSdk
        public b<T> b() {
            Preconditions.checkState(this.e != null, "Missing required property: factory.");
            return new b<>(new HashSet(this.a), new HashSet(this.b), this.c, this.d, this.e, this.f);
        }
    }

    private b(Set<Class<? super T>> set, Set<n> set2, int i, int i2, g<T> gVar, Set<Class<?>> set3) {
        this.a = Collections.unmodifiableSet(set);
        this.b = Collections.unmodifiableSet(set2);
        this.c = i;
        this.d = i2;
        this.e = gVar;
        this.f = Collections.unmodifiableSet(set3);
    }

    @KeepForSdk
    public static <T> a<T> a(Class<T> cls) {
        return new a<>(cls, new Class[0]);
    }

    @SafeVarargs
    @KeepForSdk
    public static <T> a<T> a(Class<T> cls, Class<? super T>... clsArr) {
        return new a<>(cls, clsArr);
    }

    @KeepForSdk
    public static <T> b<T> a(T t, Class<T> cls) {
        return b(cls).a(d.a(t)).b();
    }

    @SafeVarargs
    @KeepForSdk
    public static <T> b<T> a(T t, Class<T> cls, Class<? super T>... clsArr) {
        return a(cls, clsArr).a(c.a(t)).b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Object a(Object obj, e eVar) {
        return obj;
    }

    @KeepForSdk
    public static <T> a<T> b(Class<T> cls) {
        return a(cls).c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Object b(Object obj, e eVar) {
        return obj;
    }

    public Set<Class<? super T>> a() {
        return this.a;
    }

    public Set<n> b() {
        return this.b;
    }

    public g<T> c() {
        return this.e;
    }

    public Set<Class<?>> d() {
        return this.f;
    }

    public boolean e() {
        return this.c == 1;
    }

    public boolean f() {
        return this.c == 2;
    }

    public boolean g() {
        return this.d == 0;
    }

    public String toString() {
        return "Component<" + Arrays.toString(this.a.toArray()) + ">{" + this.c + ", type=" + this.d + ", deps=" + Arrays.toString(this.b.toArray()) + "}";
    }
}
