package com.amazon.device.iap.internal.b.f;

import com.amazon.device.iap.internal.b.e;
import com.amazon.device.iap.internal.b.i;
import com.amazon.venezia.command.SuccessResult;

/* loaded from: classes.dex */
abstract class a extends i {
    /* JADX INFO: Access modifiers changed from: package-private */
    public a(e eVar, String str) {
        super(eVar, "response_received", str);
        b(false);
    }

    @Override // com.amazon.device.iap.internal.b.i
    protected boolean a(SuccessResult successResult) {
        return true;
    }
}
