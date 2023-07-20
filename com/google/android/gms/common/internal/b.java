package com.google.android.gms.common.internal;

import android.content.Intent;

/* loaded from: classes.dex */
final class b extends DialogRedirect {
    private final /* synthetic */ Intent a;
    private final /* synthetic */ androidx.e.a.d b;
    private final /* synthetic */ int c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(Intent intent, androidx.e.a.d dVar, int i) {
        this.a = intent;
        this.b = dVar;
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
