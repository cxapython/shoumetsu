package com.google.android.gms.common.api.internal;

import android.app.Dialog;

/* loaded from: classes.dex */
final class ay extends zabr {
    private final /* synthetic */ Dialog a;
    private final /* synthetic */ ax b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ay(ax axVar, Dialog dialog) {
        this.b = axVar;
        this.a = dialog;
    }

    @Override // com.google.android.gms.common.api.internal.zabr
    public final void zas() {
        this.b.a.c();
        if (this.a.isShowing()) {
            this.a.dismiss();
        }
    }
}
