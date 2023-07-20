package com.google.firebase.components;

/* loaded from: classes.dex */
public class s<T> implements com.google.firebase.c.a<T> {
    private static final Object a = new Object();
    private volatile Object b = a;
    private volatile com.google.firebase.c.a<T> c;

    public s(com.google.firebase.c.a<T> aVar) {
        this.c = aVar;
    }

    @Override // com.google.firebase.c.a
    public T a() {
        T t = (T) this.b;
        if (t == a) {
            synchronized (this) {
                t = this.b;
                if (t == a) {
                    t = this.c.a();
                    this.b = t;
                    this.c = null;
                }
            }
        }
        return t;
    }
}
