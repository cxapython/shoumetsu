package com.google.android.gms.common.api.internal;

/* loaded from: classes.dex */
final class n extends w {
    private final /* synthetic */ zaak a;
    private final /* synthetic */ com.google.android.gms.signin.internal.zaj b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(m mVar, zabd zabdVar, zaak zaakVar, com.google.android.gms.signin.internal.zaj zajVar) {
        super(zabdVar);
        this.a = zaakVar;
        this.b = zajVar;
    }

    @Override // com.google.android.gms.common.api.internal.w
    public final void a() {
        this.a.a(this.b);
    }
}
