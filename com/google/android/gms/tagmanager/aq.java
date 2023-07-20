package com.google.android.gms.tagmanager;

import android.content.Context;

/* loaded from: classes.dex */
final class aq implements Runnable {
    private final /* synthetic */ an a;
    private final /* synthetic */ long b;
    private final /* synthetic */ String c;
    private final /* synthetic */ ao d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aq(ao aoVar, an anVar, long j, String str) {
        this.d = aoVar;
        this.a = anVar;
        this.b = j;
        this.c = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ar arVar;
        ar arVar2;
        Context context;
        arVar = this.d.e;
        if (arVar == null) {
            dg a = dg.a();
            context = this.d.f;
            a.a(context, this.a);
            this.d.e = a.b();
        }
        arVar2 = this.d.e;
        arVar2.a(this.b, this.c);
    }
}
