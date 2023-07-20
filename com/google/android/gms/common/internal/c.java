package com.google.android.gms.common.internal;

import android.content.Intent;
import com.google.android.gms.common.api.internal.LifecycleFragment;

/* loaded from: classes.dex */
final class c extends DialogRedirect {
    private final /* synthetic */ Intent a;
    private final /* synthetic */ LifecycleFragment b;
    private final /* synthetic */ int c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(Intent intent, LifecycleFragment lifecycleFragment, int i) {
        this.a = intent;
        this.b = lifecycleFragment;
        this.c = i;
    }

    @Override // com.google.android.gms.common.internal.DialogRedirect
    public final void a() {
        Intent intent = this.a;
        if (intent != null) {
            this.b.startActivityForResult(intent, this.c);
        }
    }
}
