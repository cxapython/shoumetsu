package com.google.android.gms.common.api.internal;

import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
final class m extends com.google.android.gms.signin.internal.zac {
    private final WeakReference<zaak> a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(zaak zaakVar) {
        this.a = new WeakReference<>(zaakVar);
    }

    @Override // com.google.android.gms.signin.internal.zac, com.google.android.gms.signin.internal.zad
    public final void zab(com.google.android.gms.signin.internal.zaj zajVar) {
        zabe zabeVar;
        zaak zaakVar = this.a.get();
        if (zaakVar == null) {
            return;
        }
        zabeVar = zaakVar.a;
        zabeVar.a(new n(this, zaakVar, zaakVar, zajVar));
    }
}
