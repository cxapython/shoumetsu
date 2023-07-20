package com.amazon.device.iap.internal.b.f;

import com.amazon.device.iap.internal.b.e;

/* loaded from: classes.dex */
public final class c extends a {
    public c(e eVar, boolean z) {
        super(eVar, "2.0");
        a("receiptDelivered", Boolean.valueOf(z));
    }

    @Override // com.amazon.device.iap.internal.b.i
    public void a_() {
        String str;
        boolean z;
        Object a = b().d().a("notifyListenerResult");
        if (a == null || !Boolean.TRUE.equals(a)) {
            str = "notifyListenerSucceeded";
            z = false;
        } else {
            str = "notifyListenerSucceeded";
            z = true;
        }
        a(str, Boolean.valueOf(z));
        super.a_();
    }
}
