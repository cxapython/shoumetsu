package com.google.android.gms.internal.gtm;

import java.util.Map;

/* loaded from: classes.dex */
final class ce<K> implements Map.Entry<K, Object> {
    private Map.Entry<K, zzrn> a;

    private ce(Map.Entry<K, zzrn> entry) {
        this.a = entry;
    }

    public final zzrn a() {
        return this.a.getValue();
    }

    @Override // java.util.Map.Entry
    public final K getKey() {
        return this.a.getKey();
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        if (this.a.getValue() == null) {
            return null;
        }
        return zzrn.zzpy();
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        if (obj instanceof zzsk) {
            return this.a.getValue().zzi((zzsk) obj);
        }
        throw new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
    }
}
