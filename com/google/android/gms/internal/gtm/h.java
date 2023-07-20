package com.google.android.gms.internal.gtm;

import java.lang.Thread;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class h implements Thread.UncaughtExceptionHandler {
    private final /* synthetic */ zzap a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(zzap zzapVar) {
        this.a = zzapVar;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public final void uncaughtException(Thread thread, Throwable th) {
        zzci zzdd = this.a.zzdd();
        if (zzdd != null) {
            zzdd.zze("Job execution failed", th);
        }
    }
}
