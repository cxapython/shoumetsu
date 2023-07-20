package com.google.android.gms.internal.gtm;

import java.util.Iterator;

/* loaded from: classes.dex */
final class dy implements Iterator<String> {
    private Iterator<String> a;
    private final /* synthetic */ zztu b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dy(zztu zztuVar) {
        zzrt zzrtVar;
        this.b = zztuVar;
        zzrtVar = this.b.a;
        this.a = zzrtVar.iterator();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.a.hasNext();
    }

    @Override // java.util.Iterator
    public final /* synthetic */ String next() {
        return this.a.next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
