package com.google.android.gms.internal.gtm;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
final class dj implements Iterator<Map.Entry<K, V>> {
    private int a;
    private Iterator<Map.Entry<K, V>> b;
    private final /* synthetic */ dh c;

    private dj(dh dhVar) {
        List list;
        this.c = dhVar;
        list = this.c.b;
        this.a = list.size();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ dj(dh dhVar, di diVar) {
        this(dhVar);
    }

    private final Iterator<Map.Entry<K, V>> a() {
        Map map;
        if (this.b == null) {
            map = this.c.f;
            this.b = map.entrySet().iterator();
        }
        return this.b;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        List list;
        int i = this.a;
        if (i > 0) {
            list = this.c.b;
            if (i <= list.size()) {
                return true;
            }
        }
        return a().hasNext();
    }

    @Override // java.util.Iterator
    public final /* synthetic */ Object next() {
        List list;
        Object obj;
        if (a().hasNext()) {
            obj = a().next();
        } else {
            list = this.c.b;
            int i = this.a - 1;
            this.a = i;
            obj = list.get(i);
        }
        return (Map.Entry) obj;
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
