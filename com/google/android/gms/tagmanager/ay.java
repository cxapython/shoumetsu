package com.google.android.gms.tagmanager;

import android.util.LruCache;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class ay extends LruCache<K, V> {
    private final /* synthetic */ zzs a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ay(ax axVar, int i, zzs zzsVar) {
        super(i);
        this.a = zzsVar;
    }

    @Override // android.util.LruCache
    protected final int sizeOf(K k, V v) {
        return this.a.sizeOf(k, v);
    }
}
