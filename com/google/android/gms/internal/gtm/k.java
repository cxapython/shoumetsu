package com.google.android.gms.internal.gtm;

import android.content.ComponentName;

/* loaded from: classes.dex */
final class k implements Runnable {
    private final /* synthetic */ ComponentName a;
    private final /* synthetic */ zzav b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(zzav zzavVar, ComponentName componentName) {
        this.b = zzavVar;
        this.a = componentName;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzat.a(this.b.a, this.a);
    }
}
