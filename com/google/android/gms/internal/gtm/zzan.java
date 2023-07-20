package com.google.android.gms.internal.gtm;

/* loaded from: classes.dex */
public abstract class zzan extends zzam {
    private boolean a;

    /* JADX INFO: Access modifiers changed from: protected */
    public zzan(zzap zzapVar) {
        super(zzapVar);
    }

    protected abstract void a();

    public final boolean isInitialized() {
        return this.a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void q() {
        if (isInitialized()) {
            return;
        }
        throw new IllegalStateException("Not initialized");
    }

    public final void zzag() {
        a();
        this.a = true;
    }
}
