package com.amazon.device.iap.internal.b.d;

import com.amazon.device.iap.internal.b.e;
import com.amazon.device.iap.internal.b.i;
import net.gree.gamelib.payment.internal.a.g;

/* loaded from: classes.dex */
abstract class b extends i {
    protected final boolean a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(e eVar, String str, boolean z) {
        super(eVar, "purchase_updates", str);
        this.a = z;
    }

    protected void preExecution() {
        super.preExecution();
        a("cursor", this.a ? null : com.amazon.device.iap.internal.util.b.a((String) b().d().a(g.c)));
    }
}
