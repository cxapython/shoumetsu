package com.google.android.gms.tagmanager;

import android.annotation.TargetApi;
import android.util.LruCache;

@TargetApi(12)
/* loaded from: classes.dex */
final class ax<K, V> implements ej<K, V> {
    private LruCache<K, V> a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ax(int i, zzs<K, V> zzsVar) {
        this.a = new ay(this, 1048576, zzsVar);
    }

    @Override // com.google.android.gms.tagmanager.ej
    public final V a(K k) {
        return this.a.get(k);
    }

    @Override // com.google.android.gms.tagmanager.ej
    public final void a(K k, V v) {
        this.a.put(k, v);
    }
}
