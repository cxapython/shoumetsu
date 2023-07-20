package com.google.android.gms.internal.nearby;

import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class zzhd<K, V> {
    private final Map<K, WeakReference<V>> a = new WeakHashMap();

    public final void clear() {
        this.a.clear();
    }

    public final boolean containsKey(K k) {
        return get(k) != null;
    }

    public final V get(K k) {
        WeakReference<V> weakReference = this.a.get(k);
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    public final void remove(K k) {
        this.a.remove(k);
    }

    public final void zza(K k, V v) {
        this.a.put(k, new WeakReference<>(v));
    }
}
