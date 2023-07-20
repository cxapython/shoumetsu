package com.amazon.device.iap.internal.b.b;

import com.amazon.device.iap.internal.b.e;
import com.amazon.device.iap.internal.b.i;
import com.amazon.device.iap.internal.model.PurchaseResponseBuilder;
import com.amazon.device.iap.model.PurchaseResponse;
import com.amazon.device.iap.model.RequestId;

/* loaded from: classes.dex */
public final class d extends e {
    public d(RequestId requestId, String str) {
        super(requestId);
        c cVar = new c(this, str);
        cVar.b(new b(this, str));
        a((i) cVar);
    }

    @Override // com.amazon.device.iap.internal.b.e
    public void a() {
    }

    @Override // com.amazon.device.iap.internal.b.e
    public void b() {
        PurchaseResponse purchaseResponse = (PurchaseResponse) d().a();
        if (purchaseResponse == null) {
            purchaseResponse = new PurchaseResponseBuilder().setRequestId(c()).setRequestStatus(PurchaseResponse.RequestStatus.FAILED).build();
        }
        a(purchaseResponse);
    }
}
