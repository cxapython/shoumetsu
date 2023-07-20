package com.google.android.gms.internal.gtm;

import java.util.Iterator;
import java.util.Map;

/* loaded from: classes.dex */
final class dk extends dq {
    private final /* synthetic */ dh a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    private dk(dh dhVar) {
        super(dhVar, null);
        this.a = dhVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ dk(dh dhVar, di diVar) {
        this(dhVar);
    }

    @Override // com.google.android.gms.internal.gtm.dq, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator<Map.Entry<K, V>> iterator() {
        return new dj(this.a, null);
    }
}
