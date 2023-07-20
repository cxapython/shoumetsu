package com.google.android.gms.common.api.internal;

/* loaded from: classes.dex */
final class al implements Runnable {
    private final /* synthetic */ com.google.android.gms.signin.internal.zaj a;
    private final /* synthetic */ zace b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(zace zaceVar, com.google.android.gms.signin.internal.zaj zajVar) {
        this.b = zaceVar;
        this.a = zajVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.b.a(this.a);
    }
}
