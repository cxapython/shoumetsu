package com.google.android.gms.games;

/* loaded from: classes.dex */
public class AnnotatedData<T> {
    private final T a;
    private final boolean b;

    public AnnotatedData(T t, boolean z) {
        this.a = t;
        this.b = z;
    }

    public T get() {
        return this.a;
    }

    public boolean isStale() {
        return this.b;
    }
}
