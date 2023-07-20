package com.google.android.gms.internal.gtm;

import java.util.NoSuchElementException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class ba extends bc {
    private int a = 0;
    private final int b;
    private final /* synthetic */ zzps c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ba(zzps zzpsVar) {
        this.c = zzpsVar;
        this.b = this.c.size();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.a < this.b;
    }

    @Override // com.google.android.gms.internal.gtm.zzpz
    public final byte nextByte() {
        int i = this.a;
        if (i < this.b) {
            this.a = i + 1;
            return this.c.a(i);
        }
        throw new NoSuchElementException();
    }
}
