package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;
import javax.annotation.concurrent.GuardedBy;

/* loaded from: classes.dex */
final class j extends w {
    private final /* synthetic */ ConnectionResult a;
    private final /* synthetic */ i b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(i iVar, zabd zabdVar, ConnectionResult connectionResult) {
        super(zabdVar);
        this.b = iVar;
        this.a = connectionResult;
    }

    @Override // com.google.android.gms.common.api.internal.w
    @GuardedBy("mLock")
    public final void a() {
        this.b.a.b(this.a);
    }
}
