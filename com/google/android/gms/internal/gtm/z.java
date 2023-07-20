package com.google.android.gms.internal.gtm;

import android.os.Looper;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class z implements Runnable {
    private final /* synthetic */ y a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(y yVar) {
        this.a = yVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzap zzapVar;
        if (Looper.myLooper() == Looper.getMainLooper()) {
            zzapVar = this.a.a;
            zzapVar.zzcq().zza(this);
            return;
        }
        boolean c = this.a.c();
        this.a.d = 0L;
        if (!c) {
            return;
        }
        this.a.a();
    }
}
