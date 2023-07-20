package com.google.android.gms.tagmanager;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class ap implements Runnable {
    private final /* synthetic */ zza a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ap(zza zzaVar) {
        this.a = zzaVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.d();
    }
}
