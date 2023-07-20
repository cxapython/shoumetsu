package com.google.android.gms.internal.games;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class cr implements Runnable {
    private final /* synthetic */ zzeh a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cr(zzeh zzehVar) {
        this.a = zzehVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.a();
    }
}
