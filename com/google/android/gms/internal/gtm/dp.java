package com.google.android.gms.internal.gtm;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
final class dp implements Iterator<Map.Entry<K, V>> {
    private int a;
    private boolean b;
    private Iterator<Map.Entry<K, V>> c;
    private final /* synthetic */ dh d;

    private dp(dh dhVar) {
        this.d = dhVar;
        this.a = -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ dp(dh dhVar, di diVar) {
        this(dhVar);
    }

    private final Iterator<Map.Entry<K, V>> a() {
        Map map;
        if (this.c == null) {
            map = this.d.c;
            this.c = map.entrySet().iterator();
        }
        return this.c;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        List list;
        Map map;
        int i = this.a + 1;
        list = this.d.b;
        if (i >= list.size()) {
            map = this.d.c;
            if (map.isEmpty() || !a().hasNext()) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.Iterator
    public final /* synthetic */ Object next() {
        List list;
        Object next;
        List list2;
        this.b = true;
        int i = this.a + 1;
        this.a = i;
        list = this.d.b;
        if (i < list.size()) {
            list2 = this.d.b;
            next = list2.get(this.a);
        } else {
            next = a().next();
        }
        return (Map.Entry) next;
    }

    @Override // java.util.Iterator
    public final void remove() {
        List list;
        if (this.b) {
            this.b = false;
            this.d.f();
            int i = this.a;
            list = this.d.b;
            if (i >= list.size()) {
                a().remove();
                return;
            }
            dh dhVar = this.d;
            int i2 = this.a;
            this.a = i2 - 1;
            dhVar.c(i2);
            return;
        }
        throw new IllegalStateException("remove() was called before next()");
    }
}
