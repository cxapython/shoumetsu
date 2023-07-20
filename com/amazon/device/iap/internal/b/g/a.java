package com.amazon.device.iap.internal.b.g;

import com.amazon.device.iap.internal.b.e;
import com.amazon.device.iap.internal.b.i;
import com.amazon.venezia.command.SuccessResult;
import java.util.Set;

/* loaded from: classes.dex */
public final class a extends i {
    protected final Set<String> a;
    protected final String b;

    public a(e eVar, Set<String> set, String str) {
        super(eVar, "purchase_fulfilled", "2.0");
        this.a = set;
        this.b = str;
        b(false);
        a("receiptIds", this.a);
        a("fulfillmentStatus", this.b);
    }

    @Override // com.amazon.device.iap.internal.b.i
    protected boolean a(SuccessResult successResult) {
        return true;
    }

    @Override // com.amazon.device.iap.internal.b.i
    public void a_() {
        Object a = b().d().a("notifyListenerResult");
        if (a != null && Boolean.FALSE.equals(a)) {
            a("fulfillmentStatus", com.amazon.device.iap.internal.model.a.DELIVERY_ATTEMPTED.toString());
        }
        super.a_();
    }
}
