package com.google.android.gms.tagmanager;

import java.util.List;

/* loaded from: classes.dex */
final class r implements Runnable {
    private final /* synthetic */ List a;
    private final /* synthetic */ long b;
    private final /* synthetic */ q c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(q qVar, List list, long j) {
        this.c = qVar;
        this.a = list;
        this.b = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.c.b(this.a, this.b);
    }
}
