package com.google.android.gms.common.api.internal;

import java.lang.ref.WeakReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class v extends zabr {
    private WeakReference<zaaw> a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(zaaw zaawVar) {
        this.a = new WeakReference<>(zaawVar);
    }

    @Override // com.google.android.gms.common.api.internal.zabr
    public final void zas() {
        zaaw zaawVar = this.a.get();
        if (zaawVar == null) {
            return;
        }
        zaawVar.f();
    }
}
