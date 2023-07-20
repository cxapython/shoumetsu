package com.google.android.gms.internal.nearby;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnFailureListener;

/* loaded from: classes.dex */
final class ar implements OnFailureListener {
    private final /* synthetic */ String a;
    private final /* synthetic */ zzbd b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ar(zzbd zzbdVar, String str) {
        this.b = zzbdVar;
        this.a = str;
    }

    @Override // com.google.android.gms.tasks.OnFailureListener
    public final void onFailure(Exception exc) {
        if (!(exc instanceof ApiException) || ((ApiException) exc).getStatusCode() != 8003) {
            this.b.b(this.a);
        }
    }
}
