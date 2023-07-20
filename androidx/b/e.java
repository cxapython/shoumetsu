package androidx.b;

import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

/* loaded from: classes.dex */
public class e<K, V> {
    private final LinkedHashMap<K, V> a;
    private int b;
    private int c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;

    public e(int i) {
        if (i > 0) {
            this.c = i;
            this.a = new LinkedHashMap<>(0, 0.75f, true);
            return;
        }
        throw new IllegalArgumentException("maxSize <= 0");
    }

    private int b(K k, V v) {
        int a = a(k, v);
        if (a >= 0) {
            return a;
        }
        throw new IllegalStateException("Negative size: " + k + "=" + v);
    }

    protected int a(K k, V v) {
        return 1;
    }

    protected V a(K k) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(boolean z, K k, V v, V v2) {
    }

    public final synchronized int createCount() {
        return this.e;
    }

    public final void evictAll() {
        trimToSize(-1);
    }

    public final synchronized int evictionCount() {
        return this.f;
    }

    public final V get(K k) {
        V put;
        if (k != null) {
            synchronized (this) {
                V v = this.a.get(k);
                if (v != null) {
                    this.g++;
                    return v;
                }
                this.h++;
                V a = a(k);
                if (a == null) {
                    return null;
                }
                synchronized (this) {
                    this.e++;
                    put = this.a.put(k, a);
                    if (put != null) {
                        this.a.put(k, put);
                    } else {
                        this.b += b(k, a);
                    }
                }
                if (put != null) {
                    a(false, k, a, put);
                    return put;
                }
                trimToSize(this.c);
                return a;
            }
        }
        throw new NullPointerException("key == null");
    }

    public final synchronized int hitCount() {
        return this.g;
    }

    public final synchronized int maxSize() {
        return this.c;
    }

    public final synchronized int missCount() {
        return this.h;
    }

    public final V put(K k, V v) {
        V put;
        if (k == null || v == null) {
            throw new NullPointerException("key == null || value == null");
        }
        synchronized (this) {
            this.d++;
            this.b += b(k, v);
            put = this.a.put(k, v);
            if (put != null) {
                this.b -= b(k, put);
            }
        }
        if (put != null) {
            a(false, k, put, v);
        }
        trimToSize(this.c);
        return put;
    }

    public final synchronized int putCount() {
        return this.d;
    }

    public final V remove(K k) {
        V remove;
        if (k != null) {
            synchronized (this) {
                remove = this.a.remove(k);
                if (remove != null) {
                    this.b -= b(k, remove);
                }
            }
            if (remove != null) {
                a(false, k, remove, null);
            }
            return remove;
        }
        throw new NullPointerException("key == null");
    }

    public void resize(int i) {
        if (i > 0) {
            synchronized (this) {
                this.c = i;
            }
            trimToSize(i);
            return;
        }
        throw new IllegalArgumentException("maxSize <= 0");
    }

    public final synchronized int size() {
        return this.b;
    }

    public final synchronized Map<K, V> snapshot() {
        return new LinkedHashMap(this.a);
    }

    public final synchronized String toString() {
        int i;
        i = this.g + this.h;
        return String.format(Locale.US, "LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]", Integer.valueOf(this.c), Integer.valueOf(this.g), Integer.valueOf(this.h), Integer.valueOf(i != 0 ? (this.g * 100) / i : 0));
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0070, code lost:
        throw new java.lang.IllegalStateException(getClass().getName() + ".sizeOf() is reporting inconsistent results!");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void trimToSize(int i) {
        K key;
        V value;
        while (true) {
            synchronized (this) {
                if (this.b >= 0 && (!this.a.isEmpty() || this.b == 0)) {
                    if (this.b <= i || this.a.isEmpty()) {
                        break;
                    }
                    Map.Entry<K, V> next = this.a.entrySet().iterator().next();
                    key = next.getKey();
                    value = next.getValue();
                    this.a.remove(key);
                    this.b -= b(key, value);
                    this.f++;
                } else {
                    break;
                }
            }
            a(true, key, value, null);
        }
    }
}
